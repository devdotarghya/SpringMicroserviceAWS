FROM openjdk:8-jdk-alpine

MAINTAINER org.arghya

COPY target/springdockeraws-0.0.1-SNAPSHOT.jar springdockeraws-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar", "/springdockeraws-0.0.1-SNAPSHOT.jar"]