FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8-jre-slim


EXPOSE 8085
ENTRYPOINT ["java","-jar","/home/app/target/*.jar]

