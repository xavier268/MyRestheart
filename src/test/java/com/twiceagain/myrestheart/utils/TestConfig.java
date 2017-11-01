/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Configuration parameters for the unit tests. These values are independant
 * from production environement.
 *
 * @author xavier
 */
public interface TestConfig {

    final static String TESTPASSWORD = "changeit";
    final static String TESTUSER = "admin";

    final static String RESTHEART_HTTP = "http://localhost:8080";
    final static String RESTHEART_HTTPS = "https://localhost:4443";

    final static String RESTHEART_VERSION_EXPECTED = "3.1.3";

    //MongoUri read from system property (use -D option)
    //Not available when testing/building with Netbeans, so default will be used.
    final static String MONGO_URI = MyUtils.getMongoUri();
    final static MongoClient MONGO_CLIENT = new MongoClient(new MongoClientURI(MONGO_URI));

    final static String MONGO_SERVER_VERSION_EXPECTED = "3.4";
    final static String MONGO_TEST_DATABASE = "testDatabase";
}
