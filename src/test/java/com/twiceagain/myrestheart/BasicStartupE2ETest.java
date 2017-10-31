/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart;

import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restheart.ConfigurationException;

/**
 *
 * @author xavier
 */
public class BasicStartupE2ETest {

    public BasicStartupE2ETest() {
    }

    @BeforeClass
    public static void setUpClass() throws ConfigurationException, URISyntaxException, IOException {
        MyStart.main(new String[0]);
    }

    @AfterClass
    public static void tearDownClass() {
        MyAbort.main(new String[0]);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void browserIsReacheable() throws IOException {
        System.out.println("Test that browser is running");
        HttpResponse rep = Get("http://localhost:8080/browser");
        assertEquals(200, rep.getStatusLine().getStatusCode());
        assertEquals("text/html", rep.getEntity().getContentType().getValue());

    }

    @Test
    public void browserContent() throws IOException {
        System.out.println("Test browser content");
        HttpResponse rep = Get("http://localhost:8080/browser");
        String content = retrieveContent(rep);
        assertEquals(200, rep.getStatusLine().getStatusCode());
        assertEquals("text/html", rep.getEntity().getContentType().getValue());
        assertTrue((content.length()> 3000));
        assertTrue(content.toLowerCase().contains("about the hal browser"));
    }

    // ================================Utilities====================================
    /**
     * Get a response.
     *
     * @param uri
     * @return
     * @throws java.io.IOException
     */
    public static HttpResponse Get(String uri) throws IOException {
        return HttpClientBuilder.create().build().execute(new HttpGet(uri));
    }

    /**
     * Retrieve content as String.
     * @param response
     * @return
     * @throws java.io.IOException
     */
    public static String retrieveContent(HttpResponse response) throws IOException {
    
        return EntityUtils.toString(response.getEntity(), "UTF-8");
       
}
    
}
