FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER Jose Mansilla jmansilla@gfi.es
ADD edgeservice-0.0.1.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]