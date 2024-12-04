#!/bin/bash

# Run Checkstyle
mvn checkstyle:check

# Run SpotBugs
mvn spotbugs:spotbugs

# Run tests with JaCoCo coverage
mvn clean verify
