#!/bin/zsh


# netty server 在 netty/MyNettyServer
mvn -f pom.xml clean package
# netty client 在 netty/MyClient
mvn -f pom2.xml clean package
# 启动 server
nohup java -jar target_server/server.jar &
echo "\n--- sleep 3 for sever start---\n"
sleep 3
# 请求 server
java -jar target_client/client.jar
echo "\n---remember kill server ps---\n"