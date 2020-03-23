#!/bin/sh

test -r target/kunit-0-SNAPSHOT-jar-with-dependencies.jar || ./mvnw "$@"

exec java -jar target/kunit-0-SNAPSHOT-jar-with-dependencies.jar
