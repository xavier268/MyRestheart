/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.basic;

import com.twiceagain.myrestheart.utils.TestUtilities;
import com.twiceagain.myrestheart.utils.TestConfig;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xavier
 */
public class DirectMongoConnectivityTest extends TestUtilities implements TestConfig {

    public DirectMongoConnectivityTest() {
    }


    @Test(timeout = 1000)
    public void mongoIsRunning() throws IOException {
        HttpResponse rep = get(TestConfig.MONGO_HTTP);
        assertEquals(200, rep.getStatusLine().getStatusCode());
        assertTrue(retrieveContent(rep).toLowerCase().contains("looks like you are trying to access mongodb over http on the native driver port"));
    }

}
