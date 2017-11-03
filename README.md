# MyRestheart
Customized Restheart Server ( see www.restheart.org ) and related utilities.

## Building

Unless you build without tests, you need to have a mongo test server running.
You can create and launch one with the **./startTestMongoServer.sh** script.
Then, do a normal maven build. This build will produce an uberjar with all the 
needed files included.

## Running

Assuming you built the executable jar (see above), 
just run the **startStack.sh** script and connect to *127.0.0.1:8080/browser/* 
or any other REST service (see addressing plan below).

## Addressing plan (as per embedded configuration file)

   URL              |     Comments
--------------------|-----------------------------------------------------
/         |   Reserved for (future) static assets
/browser  |   The HAL navigator page
/api         |   Main mongo ressource interface
/api/xxx...   |   Access to collection and mongo ressources
/_logic/roles/anId  |   Check credentials for anId, get security roles
/_authtokens/anId  |   DELETE: invalidate the current token, GET: refresh the current token
/_logic/ping      |   Ping handler
/_logic/mongo-uri  |   (debug) : Get the mongodb uri as used by running instance

## Setting the **mongo** uri (overriding embedded configuration)

The **mongo** environment property, if set when launching the jvm 
( use for instance java -Dmongo="mongodb://mongohost:9999" ), will 
replace  the mongo-uri in the embedded configuration file. If not set,
a reasonable default (mongodb://localhost:27017 ) will be used. 
See the compose-dev.yml file for an example.

**IMPORTANT** : The actual value inside the embedded configuration file it 
just a place holder ! It will never be used, in either case. 
A mongo server must be available for testing 
or building. When testing from inside *Netbeans*, the jvm -D parameters 
set as options are not used, so make sure a default test mongo server
is available on localhost:27017.
