#!/bin/bash
# Run this command to install two containers mongo and restheart containers, 
# to run the application. 

# Todo : use volumes to save databes
# Todo : create a configuration file that is compatible with swarm mode
# Todo : reduce log volumes in production ...
# Todo : provide nginx https proxy, possibly used for static files (eg angular 
#        aot compiled clients)

echo "Preparing a common network between mongo-restheart"
sudo -- docker network create mybridge

echo "Launching default mongo on internal port 27017, not external port open"
sudo -- docker kill mongo
sudo -- docker run --rm -d --name mongo --network="mybridge" mongo

echo "Launching the custumized restheart uberjar in a docker container"
JAR=MyRestheart-1.0-SNAPSHOT.jar
sudo -- docker kill myrestheart

sudo -- docker run --rm -d                      \
-p8080:8080      				\
--name myrestheart --network="mybridge"         \
-v$(pwd)/target/$JAR:/$JAR                      \
openjdk:8-jre-alpine 				\
java -Dmongo="mongodb://mongo:27017" -jar /$JAR

sudo -- docker ps 

echo "Connect to http://localhost:8080/browser to test"
