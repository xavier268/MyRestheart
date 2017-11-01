# MyRestheart
Customized Restheart Server ( see www.restheart.org ) and related utilities.

## Notes

* the **mongo** environement property, if set when launching the jvm ( use for instance java -Dmongo="mongodb://mongohost:9999" ), will replace  the mongo-uri in the embedded configuration file. If not set, a reasonable default (mongodb://localhost:27017 ) will be used. The actual value inside the embedded configuration file will **never** be used, in either case. A mongo server must nbe available for testing or building. When testing from inside *Netbeans*, the jvm -D parameters set as options are not used, so make sure a default test mongo server is available on localhost:27017.
