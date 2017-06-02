package com.jmansilla.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jmansilla.modelo.Employee;
import com.jmansilla.modelo.EmployeeCompleto;
import com.jmansilla.servicio.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeControler {
	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(method = RequestMethod.POST)
	public Employee create(@RequestBody Employee employee){
		Employee resultado = employeeService.insertarEmpleado(employee);
		
		return resultado;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getEmpleados(){	
		return employeeService.getEmpleados();
	}
	
	@RequestMapping(value = "/{employeeID}", method = RequestMethod.GET)
	public Employee getEmpleado(@PathVariable String employeeID){	
		return employeeService.getEmpleadoById(employeeID);
	}
	
	@RequestMapping(value = "/completo/{employeeID}", method = RequestMethod.GET)
	public EmployeeCompleto getEmpleadoCompleto(@PathVariable String employeeID){	
		
		return employeeService.getEmpleadoCompletoById(employeeID);
	}
}
