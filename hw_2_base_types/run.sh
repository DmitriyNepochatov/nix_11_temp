#!/bin/bash
mvn clean
rm dependency-reduced-pom.xml
mvn package
java -jar target/hw_2_base_types.jar