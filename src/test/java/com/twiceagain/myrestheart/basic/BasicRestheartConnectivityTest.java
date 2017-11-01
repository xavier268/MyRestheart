/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.basic;

import com.twiceagain.myrestheart.utils.HttpUtilities;
import com.twiceagain.myrestheart.MyEntryPoint;
import java.io.IOException;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.HttpResponse;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author xavier
 */
public class BasicRestheartConnectivityTest extends HttpUtilities{

    public BasicRestheartConnectivityTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        MyEntryPoint.start(new String[0]);
        
    }

    @AfterClass
    public static void tearDownClass() {          
        // MyEntryPoint.stop(new String[0]);
    }    

    @Test
    public void browserIsReacheable() throws IOException {
        System.out.println("Test browser is reacheable (no trailing slash)");
        HttpResponse rep = get("http://localhost:8080/browser");
        assertEquals(200, rep.getStatusLine().getStatusCode());
        assertEquals("text/html", rep.getEntity().getContentType().getValue());
    }

    @Test
    public void browserIsReacheableTrailingSlash() throws IOException {
        System.out.println("Test browser is reacheable (with trailing slash)");
        HttpResponse rep = get("http://localhost:8080/browser/");
        assertEquals(200, rep.getStatusLine().getStatusCode());
        assertEquals("text/html", rep.getEntity().getContentType().getValue());
    }

    @Test(expected = SSLHandshakeException.class)
    @Deprecated 
    public void browserIsReacheableOnHttps() throws IOException {
        System.out.println("Test browser is reacheable on https - generates exception for selfsigned certyificate ...");
        HttpResponse rep = get("https://localhost:4443/browser/");        
    }
    
    

    @Test
    public void browserContent() throws IOException {
        System.out.println("Test browser content is credible");
        HttpResponse rep = get("http://localhost:8080/browser");
        String content = retrieveContent(rep);
        assertEquals(200, rep.getStatusLine().getStatusCode());
        assertEquals("text/html", rep.getEntity().getContentType().getValue());
        assertTrue((content.length() > 3000));
        assertTrue(content.toLowerCase().contains("about the hal browser"));
    }
    
    @Test
    public void rootAccess() throws IOException {
        System.out.println("Test root access - should be unauthorized (401)");
        HttpResponse rep = get("http://localhost:8080/");
        assertEquals(401, rep.getStatusLine().getStatusCode());        
    }
    
    @Test
    public void pingTest() throws IOException {
        System.out.println("Test /_logic/ping - should contain ciao ...");
        HttpResponse rep = get("http://localhost:8080/_logic/ping");
        assertEquals(200, rep.getStatusLine().getStatusCode());   
        assertTrue(retrieveContent(rep).contains("ciao from the restheart team"));
   
    }
    
@Test
    public void unknownUnauthorizedCollection() throws IOException {
        System.out.println("Test unknown mongo collection");
        HttpResponse rep = get("http://localhost:8080/nonexistingcollection/");
        assertEquals(401, rep.getStatusLine().getStatusCode()); 
    }
    // ================================Utilities====================================
    /**
     * Get a response via Http.
     *
     * @param uri
     * @return
     * @throws java.io.IOException
     */
    /**
     * Retrieve content as String.
     *
     * @param response
     * @return
     * @throws java.io.IOException
     */
    
   
    
   

}
