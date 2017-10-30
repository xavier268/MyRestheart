/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart;

import static com.twiceagain.myrestheart.utils.MyUtils.copyResourceToFile;
import java.io.IOException;
import java.net.URISyntaxException;
import org.restheart.Bootstrapper;
import org.restheart.ConfigurationException;

/**
 *
 * @author xavier
 */

public class MyStart {

    /**
     * @param args the command line arguments
     * @throws org.restheart.ConfigurationException
     * @throws java.net.URISyntaxException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ConfigurationException, URISyntaxException, IOException {
        
        // Identify custom vs. standard version.
        System.out.println("\nStarting my customized bootstrapper (MyRestheart) ...");
        
        // Copy embedded configuration files to filesystem.
        copyResourceToFile("myconfig.yaml","configuration.yaml");
        
        
        Bootstrapper.main(args);

    }

}
