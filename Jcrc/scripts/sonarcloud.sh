#!/bin/bash

workspace="/home/max/git/Jcrc/Jcrc/"
export JAVA_HOME="/usr/lib/jvm/java-8-oracle"
export M2_HOME="/opt/apache-maven-3.5.2"
export PATH="$PATH:${JAVA_HOME}${M2_HOME}"

echo -e "\e[1;34m-----------------------------------------\e[0m"
echo -e "\e[1;34m.      Maximiliano Correa Jcrc           \e[0m"
echo -e "\e[1;34m-----------------------------------------\e[0m"

echo -e "\e[1;37m------- Enveronment Veriables -----------\e[0m"
echo -e "\e[1;33m       Workspace --- $workspace          \e[0m"
echo -e "\e[1;33m       JAVA_HOME --- $JAVA_HOME          \e[0m"
echo -e "\e[1;33m       M2_HOME   --- $M2_HOME            \e[0m"
echo -e "\e[1;37m-----------------------------------------\e[0m"

cd $workspace

echo -e "\e[1;37m------- Preparing the coverage ----------\e[0m"
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent verify --settings settings.xml
echo -e "\e[1;37m-----------------------------------------\e[0m"

echo -e "\e[1;37m- Analyzing and uploading to sonarcloud -\e[0m"
mvn sonar:sonar -Dsonar.organization=maxicorrea-github -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=df7e2a6ed91101dbf24cb08fa0c9c4bcd0cce8a6 --settings settings.xml
echo -e "\e[1;37m-----------------------------------------\e[0m"
