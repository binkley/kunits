#!/bin/sh

test -r target/kunits-0-SNAPSHOT-jar-with-dependencies.jar || ./mvnw -C "$@"

exec java -jar target/kunits-0-SNAPSHOT-jar-with-dependencies.jar
