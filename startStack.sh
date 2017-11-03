#!/bin/bash

echo "Creating the swarm in case it does not exist yet"
docker swarm init
docker node ls

docker stack deploy -c compose-dev.yml mystack

docker stack ls
docker stack ps mystack

echo "You can now connect to http://127.0.0.1:8080/browser"






