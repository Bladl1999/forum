FROM maven:3.8.4-jdk-11-slim as builder
WORKDIR /src
COPY . .
RUN mvn clean install -Dmaven.test.skip