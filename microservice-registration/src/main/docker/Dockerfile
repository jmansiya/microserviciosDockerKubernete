FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER jmansilla@gfi.es
ADD microservice_registration-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 1111
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]