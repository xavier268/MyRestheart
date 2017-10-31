package com.twiceagain.myrestheart.utils;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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
public class HttpUtilities {

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
