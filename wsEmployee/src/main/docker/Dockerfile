FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER jmansilla@gfi.es
ADD microservicio-employee-1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]