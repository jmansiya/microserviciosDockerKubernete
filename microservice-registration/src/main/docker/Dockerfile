FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER jmansiya@gmail.com
ADD microservice_registration-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8075
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]