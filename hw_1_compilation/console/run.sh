#!/bin/bash

echo Main-Class: ua.com.nix.Main>MANIFEST.MF

javac -sourcepath ./src -d build/classes -cp ./libs/commons-lang3-3.12.0.jar:./libs/commons-math3-3.6.1.jar src/dot/dim/orp/MathManipulation.java src/ua/com/nix/spg/StringManipulation.java src/ua/com/nix/Main.java

mkdir -p build/jar

cd build/classes

jar xf ../../libs/commons-lang3-3.12.0.jar org

jar xf ../../libs/commons-math3-3.6.1.jar org

cd ../../

jar cfm build/jar/ConsoleWork.jar MANIFEST.MF -C build/classes/ .

java -jar build/jar/ConsoleWork.jar




