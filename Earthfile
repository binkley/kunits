VERSION 0.8
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /code

build:
    COPY mvnw .
    COPY .mvn .mvn
    COPY pom.xml .
    COPY config config
    COPY src src
    RUN --secret OWASP_NVD_API_KEY ./mvnw --no-transfer-progress clean verify site

    # For CI so that GitHub can copy artifacts:
    # Just copy everything rather than maintain a whitelist of files/dirs.
    SAVE ARTIFACT --keep-ts target AS LOCAL target

run:
    FROM +build
    COPY run .
    RUN ./run
