package com.twiceagain.myrestheart.utils;

import java.io.IOException;
import java.util.Base64;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xavier
 */
public class HttpUtilities implements TestConfig{

    /**
     * get a response via Http.
     *
     * @param uri
     * @return
     * @throws java.io.IOException
     */
    public static HttpResponse get(String uri) throws IOException {
        return HttpClientBuilder.create().build().execute(new HttpGet(uri));
    }

    public static HttpResponse authGet(String uri, String user, String passwordOrToken) throws IOException {
        HttpUriRequest ur = new HttpGet(uri);
        String b64 = Base64.getEncoder().encodeToString((user + ":" + passwordOrToken).getBytes());
        Header header = new BasicHeader("Authorization", "Basic " + b64);
        ur.setHeader(header);
        return HttpClientBuilder.create().build().execute(ur);
    }

    /**
     * Retrieve content as String.
     *
     * @param response
     * @return
     * @throws java.io.IOException
     */
    public static String retrieveContent(HttpResponse response) throws IOException {
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

}
