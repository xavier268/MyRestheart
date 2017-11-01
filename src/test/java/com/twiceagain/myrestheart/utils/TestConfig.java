/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.utils;

import com.mongodb.MongoClient;

/**
 * Configuration parameters for the unit tests.
 *
 * @author xavier
 */
public interface TestConfig {

    final static String TESTPASSWORD = "changeit";
    final static String TESTUSER = "admin";

    final static String RESTHEART_HTTP = "http://localhost:8080";
    final static String RESTHEART_HTTPS = "https://localhost:4443";

    final static String RESTHEART_VERSION_EXPECTED = "3.1.3";

    final static String MONGO_HOST = "localhost";
    final static Integer MONGO_PORT = 27017;
    final static String MONGO_HTTP = "http://"+MONGO_HOST+"/"+MONGO_PORT;
    final static String MONGO_SERVER_VERSION_EXPECTED = "3.4";
    final static String MONGO_TEST_DATABASE = "testDatabase";
    final static MongoClient MONGO_CLIENT = new MongoClient(MONGO_HOST, MONGO_PORT);
}
