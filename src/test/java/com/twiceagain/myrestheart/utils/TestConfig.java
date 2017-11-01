/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.utils;

/**
 * Configuration parameters for the unit tests.
 * @author xavier
 */
public interface TestConfig {

     final static String TESTPASSWORD = "changeit";
     final static String TESTUSER = "admin";
     
     final static String BASE_RESTHEART_HTTP = "http://localhost:8080";
     final static String BASE_RESTHEART_HTTPS = "https://localhost:4443";
     final static String BASE_MONGO_HTTP = "http://localhost:27017";
    
}
