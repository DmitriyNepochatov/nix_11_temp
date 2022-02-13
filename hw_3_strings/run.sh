#!/bin/sh
mvn clean
rm dependency-reduced-pom.xml
cd ../
cd reverse_string
mvn clean
mvn install
cd ../
cd hw_3_strings
mvn package
java -jar target/hw_3_strings.jar