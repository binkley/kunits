VERSION 0.8
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /code
# Save Maven downloads across targets and runs of earthly
# This adds a layer to the image
CACHE --id maven-cache --persist maven-cache

copy:
    COPY .mvn .mvn
    COPY config config
    COPY mvnw .
    COPY pom.xml .
    COPY run .
    COPY src src

# Builds and tests with Maven, and saves the target/ directory
build:
    FROM +copy
    ARG --required BUILD_TS

    RUN \
        --mount type=cache,id=maven-cache,target=/root/.m2 \
        --mount type=secret,id=OWASP_NVD_API_KEY,target=/run/secrets/OWASP_NVD_API_KEY \
        ./mvnw \
            --batch-mode \
            --define build.ts="$BUILD_TS" \
            --no-transfer-progress \
            clean verify

    # For CI so that GitHub can copy artifacts:
    # Just copy everything rather than maintain a whitelist of files/dirs.
    SAVE ARTIFACT --keep-ts target AS LOCAL target

# Runs the demo program with Maven, building if needed
run:
    FROM +build

    RUN \
        --mount type=cache,id=maven-cache,target=/root/.m2 \
        --no-cache \
        ./run

# Builds for checking that jar timestamps match for the same build
compare-jar-checksums-on-rebuild:
    FROM +copy
    ARG --required BUILD_TS

    RUN \
        --mount type=cache,id=maven-cache,target=/root/.m2 \
        --no-cache \
        ./mvnw \
            --batch-mode \
            --define build.ts="$BUILD_TS" \
            --define skipTests \
            --no-transfer-progress \
            --quiet \
            clean package
    LET SUM1 = $(sha256sum ./target/kunits-0-SNAPSHOT.jar)

    RUN \
        --mount type=cache,id=maven-cache,target=/root/.m2 \
        --no-cache \
        ./mvnw \
            --batch-mode \
            --define build.ts="$BUILD_TS" \
            --define skipTests \
            --no-transfer-progress \
            --quiet \
            clean package
    LET SUM2 = $(sha256sum ./target/kunits-0-SNAPSHOT.jar)

    RUN test "$SUM1" = "$SUM2"
