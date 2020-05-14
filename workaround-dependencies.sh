#!/usr/bin/env bash

set -e

trap 'rm -rf "$tmpdir"' EXIT
tmpdir="$(mktemp -d 2>/dev/null || mktemp -d -t "${0##*/}")"
cd $tmpdir

git clone --depth 1 --branch master https://github.com/binkley/kotlin-rational.git
cd kotlin-rational
./mvnw install
