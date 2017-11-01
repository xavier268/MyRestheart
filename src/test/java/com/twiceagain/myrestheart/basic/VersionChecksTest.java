/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.basic;

import com.twiceagain.myrestheart.MyEntryPoint;
import com.twiceagain.myrestheart.utils.MyUtils;
import com.twiceagain.myrestheart.utils.TestConfig;
import com.twiceagain.myrestheart.utils.TestUtilities;
import org.bson.Document;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xavier
 */
public class VersionChecksTest extends TestUtilities implements TestConfig {

    public VersionChecksTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        MyEntryPoint.start(new String[0]);
    }

    @Test
    public void checkRestheartVersion() {
        System.out.println("Resheart version : " + MyUtils.getRestheartVersion());
        assertEquals(RESTHEART_VERSION_EXPECTED, MyUtils.getRestheartVersion());
    }

    @Test(timeout = 500)
    public void checkMongoVersion() {
        Document command = new Document("serverStatus", 1);
        Document result = MONGO_CLIENT.getDatabase(MONGO_TEST_DATABASE).runCommand(command);
        System.out.println("Mongo server version : " + result.getString("version"));
        System.out.println("Mongo server expectd : " + MONGO_SERVER_VERSION_EXPECTED);
        assertNotNull(result.getString("version"));
        assertTrue(result.getString("version").startsWith(MONGO_SERVER_VERSION_EXPECTED));
    }
}
