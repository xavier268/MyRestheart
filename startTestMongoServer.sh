#§/bin/bash

echo "Starts a test mongo server locally"
echo "Type Ctrl-C to stop and destroy the test container"

docker rm test-mongo
docker run --rm -it -p27017:27017 mvertes/alpine-mongo


 
