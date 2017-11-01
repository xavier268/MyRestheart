/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.authenticate;

import com.twiceagain.myrestheart.MyEntryPoint;
import com.twiceagain.myrestheart.utils.HttpUtilities;
import static com.twiceagain.myrestheart.utils.HttpUtilities.get;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.HttpResponse;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test token creation/usage for authentication.
 *
 * @author xavier
 */
public class RestheartAuthenticationTest extends HttpUtilities {

    private static final String TESTUSER = "admin";
    private static final String TESTPASSWORD = "changeit";

    public RestheartAuthenticationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        MyEntryPoint.start(new String[0]);

    }

    @Test
    public void authenticateConnectivity() throws IOException {
        System.out.println("Ability to reach browser before actually authenticating ...");
        HttpResponse rep = get("http://localhost:8080/browser");
        assertEquals(200, rep.getStatusLine().getStatusCode());
        assertEquals("text/html", rep.getEntity().getContentType().getValue());
    }

    @Test
    public void unauthenticatedCall() throws IOException {
        System.out.println("Unauthenticated call");
        HttpResponse rep = get("http://localhost:8080/");
        assertEquals(401, rep.getStatusLine().getStatusCode());
    }

    @Test
    public void authenticateAsAdmin() throws IOException {
        System.out.println("Authenticated with password");
        HttpResponse rep = authGet("http://localhost:8080/", TESTUSER, TESTPASSWORD);
        assertEquals(200, rep.getStatusLine().getStatusCode());
    }

    @Test
    public void authenticateAsAdminWrongPassword() throws IOException {
        System.out.println("Authenticated as Admin (a)-wrong password");
        HttpResponse rep = authGet("http://localhost:8080/", TESTUSER, TESTPASSWORD + "x");
        assertEquals(401, rep.getStatusLine().getStatusCode());
    }

    @Test
    public void authenticateAndReadToken() throws IOException {
        System.out.println("Authenticated, read token, and re-authentify with it (a)");

        // Authenticate with password
        HttpResponse rep = authGet("http://localhost:8080/", TESTUSER, TESTPASSWORD);
        assertEquals(200, rep.getStatusLine().getStatusCode());

        System.out.println(Arrays.toString(rep.getHeaders("Auth-Token")));
        System.out.println(Arrays.toString(rep.getHeaders("Auth-Token-Location")));
        System.out.println(Arrays.toString(rep.getHeaders("Auth-Token-Valid-Until")));

        String oldValidity = rep.getHeaders("Auth-Token-Valid-Until")[0].getValue();
        String token = rep.getHeaders("Auth-Token")[0].getValue();
        String location = rep.getHeaders("Auth-Token-Location")[0].getValue();

        // Reauthenticate with token
        rep = authGet("http://localhost:8080/", TESTUSER, token);
        assertEquals(200, rep.getStatusLine().getStatusCode());
        assertNotEquals(oldValidity, rep.getHeaders("Auth-Token-Valid-Until")[0].getValue());
        assertEquals(token, rep.getHeaders("Auth-Token")[0].getValue());
        assertEquals(location, rep.getHeaders("Auth-Token-Location")[0].getValue());
    }

}
