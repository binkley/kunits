VERSION 0.7
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /code

build:
    COPY mvnw .
    COPY .mvn .mvn
    COPY pom.xml .
    COPY config config
    COPY src src
    RUN ./mvnw --no-transfer-progress clean verify site
    SAVE ARTIFACT --keep-ts target/site/jacoco/jacoco.csv AS LOCAL target/site/jacoco/jacoco.csv

run:
    FROM +build-with-maven
    COPY run .
    RUN ./run
