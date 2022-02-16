#!/bin/sh
mvn clean
rm dependency-reduced-pom.xml
mvn package
java -jar target/hw_4_start_oop.jar