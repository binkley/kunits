#!/usr/bin/env bash

set -e

trap 'rm -rf "$tmpdir"' EXIT
tmpdir="$(mktemp -d 2>/dev/null || mktemp -d -t "${0##*/}")"
cd $tmpdir

git clone https://github.com/binkley/kotlin-rational.git
cd kotlin-rational
git co kotlin-rational-1.0.0
./mvnw install
