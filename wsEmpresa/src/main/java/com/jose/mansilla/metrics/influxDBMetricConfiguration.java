package com.jose.mansilla.metrics;

import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point; 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.boot.actuate.endpoint.MetricsEndpointMetricReader;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.writer.GaugeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.config.MeterRegistryConfig;
import io.micrometer.spring.autoconfigure.MeterRegistryCustomizer;

@Component
public class influxDBMetricConfiguration {
	private static final Logger logger = Logger.getLogger("influxDBMetricConfiguration");
	
	@Value("${spring.application.name}")
	private String nombreAplicacion;
	
	InfluxDB influxDB = null;

	@Bean
	public MetricsEndpointMetricReader metricsEndpointMetricReader(final MetricsEndpoint metricsEndpoint) {
	    return new MetricsEndpointMetricReader(metricsEndpoint);
	}

	@Bean
	@ExportMetricWriter
	GaugeWriter influxMetricsWriter() {
	    influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
	    String dbName = "jose";
	   
	    if (!influxDB.databaseExists(dbName)) {
	    	influxDB.createDatabase(dbName); 
	    } 
	    
	    influxDB.setDatabase(dbName);
	    String rpName = "aRetentionPolicy";
	    influxDB.createRetentionPolicy(rpName, dbName, "30d", 1, true);
	    influxDB.setRetentionPolicy(rpName);
	    
	    influxDB.enableBatch(10, 1000, TimeUnit.MILLISECONDS);
	    
	    return new GaugeWriter() {
	 
	        @Override
	        public void set(Metric<?> value) {
	            Point point = Point.measurement(value.getName())
	            		.time(value.getTimestamp().getTime(), TimeUnit.MILLISECONDS)
	            		.addField("service", nombreAplicacion)
	                    .addField("value", value.getValue()).build();
	            
	            influxDB.write(point);
	            
	            logger.info("write(" + value.getName() + "): " + value.getValue());	           
	        }
	    };
	}
	
	
	@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer(
	    @Value("${spring.application.name}") String applicationName) {
	    return (registry) -> {
	    	registry.config().commonTags("application", applicationName);
	    	registry.counter("database.calls", "db", "users");
	    	registry.config()
	        	.meterFilter(MeterFilter.deny(id -> { // (4)
	                String uri = id.getTag("uri");
	                return uri != null && uri.startsWith("/info");
	            }));
	    	registry.config()
        	.meterFilter(MeterFilter.deny(id -> { // (4)
                String uri = id.getTag("uri");
                return uri != null && uri.startsWith("/health");
            }));
	    };
	}
}
