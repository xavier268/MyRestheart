# MyRestheart
Customized Restheart Server ( see www.restheart.org ) and related utilities.

## Notes

* the **mongo** environement property, if set when launching the jvm ( use java -Dmongo="mongodb://mongohost:9999" ), will replace  the mongo-uri in the embedded configuration file. If not set, a reasonable default will be used. The actual value inside the embedded configuration file will **never** be used, in either case.
