/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xavier
 */
public class DirectMongoConnectivityTest extends HttpUtilities{
    
    public DirectMongoConnectivityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test(timeout = 1000)
    public void mongoIsRunning() throws IOException {
        HttpResponse rep = get("http://localhost:27017");
        assertEquals(200, rep.getStatusLine().getStatusCode());
        assertTrue(retrieveContent(rep).toLowerCase().contains("looks like you are trying to access mongodb over http on the native driver port"));
    }
    
}
