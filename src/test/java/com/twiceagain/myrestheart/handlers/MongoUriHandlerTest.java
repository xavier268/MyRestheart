/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.handlers;

import com.twiceagain.myrestheart.MyEntryPoint;
import static com.twiceagain.myrestheart.utils.TestConfig.RESTHEART_HTTP;
import static com.twiceagain.myrestheart.utils.TestUtilities.get;
import static com.twiceagain.myrestheart.utils.TestUtilities.retrieveContent;
import java.io.IOException;
import org.apache.http.HttpResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author xavier
 */
public class MongoUriHandlerTest {
    
    public MongoUriHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        MyEntryPoint.start(new String[0]);
        
    }

    @Test
    public void checkMongoUriHandler() throws IOException {
        System.out.println("Test /_logic/mongo-uri - should contain the mongo uri ...");
        HttpResponse rep = get(RESTHEART_HTTP + "/_logic/mongo-uri");
        assertEquals(200, rep.getStatusLine().getStatusCode());   
        assertTrue(retrieveContent(rep).contains("mongodb://localhost:27017"));
    }
}
