#§/bin/bash

echo "Starts a test mongo server locally"
docker kill test-mongo
docker rm test-mongo
docker run --rm -it --name test-mongo -p27017:27017 mongo

 
