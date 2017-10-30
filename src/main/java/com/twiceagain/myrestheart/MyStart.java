/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart;

import com.twiceagain.myrestheart.utils.MyUtils;
import static com.twiceagain.myrestheart.utils.MyUtils.copyResourceToFile;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        // If no config file specified on command line,  add the embedded one.
        List<String> newArgs = new ArrayList<>(Arrays.asList(args));
        if ((newArgs.contains("--fork") && newArgs.size() == 1)
                || newArgs.isEmpty()) {
            System.out.println("Extracting and adjusting embedded configuration file");
            newArgs.add(MyUtils.extractAndAdjustEmbedded());
        } else {
            System.out.println("Using provided command line arguments");
        }

        Bootstrapper.main((String[]) newArgs.toArray(args));

    }

}
