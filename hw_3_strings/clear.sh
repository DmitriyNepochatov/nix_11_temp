#!/bin/sh
mvn clean
rm dependency-reduced-pom.xml
cd ../
cd reverse_string
mvn clean
cd ../
cd hw_3_strings