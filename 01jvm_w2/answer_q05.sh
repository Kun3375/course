#!/bin/zsh

mvn -f pom.xml clean package
mvn -f pom2.xml clean package
nohup java -jar target_server/server.jar &
echo "\n--- sleep 3 for sever start---\n"
java -jar target_client/client.jar
echo "\n---remember kill server ps---\n"