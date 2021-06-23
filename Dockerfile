FROM maven:3.6.0-jdk-8-slim AS build
FROM openjdk:8-jre-slim
RUN mkdir /usr/my-app
COPY src /usr/my-app/src
COPY pom.xml /usr/my-app/pom.xml

RUN mvn -f /usr/my-app/pom.xml package

 

EXPOSE 8085
ENTRYPOINT ["java","-jar","/usr/my-app/target/*.jar]

