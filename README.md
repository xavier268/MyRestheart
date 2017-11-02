# MyRestheart
Customized Restheart Server ( see www.restheart.org ) and related utilities.

## Addressing plan (as per embedded configuration file)

   URL              |     Comments
--------------------|-----------------------------------------------------
/         |   Reserved for (future) static assets
/browser  |   The HAL navigator page
/api         |   Main mongo ressource interface
/api/xxx...   |   Access to collection and mongo ressources
/api/roles/anId  |   Check credentials for anId, get security roles

/_logic          |   Main application logic interface
/_logic/ping      |   Ping handler
/_logic/mongo-uri  |   (debug) : Get the mongodb uri as used by running instance
/_authtokens/anId  |   DELETE: invalidate the current token, GET: refresh the current token


## Setting the **mongo** uri

The **mongo** environment property, if set when launching the jvm 
( use for instance java -Dmongo="mongodb://mongohost:9999" ), will 
replace  the mongo-uri in the embedded configuration file. If not set,
a reasonable default (mongodb://localhost:27017 ) will be used.

**IMPORTANT** : The actual value inside the embedded configuration file it 
just a place holder ! It will never be used, in either case. 
A mongo server must be available for testing 
or building. When testing from inside *Netbeans*, the jvm -D parameters 
set as options are not used, so make sure a default test mongo server
is available on localhost:27017.
