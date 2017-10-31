/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart;

import com.twiceagain.myrestheart.utils.MyUtils;
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
     * This contains the arguments used to call the bootstrapper, possibly after
     * substitution. It is needed to call the shutdowner ...
     */
    static public List<String> ARGS;

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
        ARGS = new ArrayList<>(Arrays.asList(args));
        if ((ARGS.contains("--fork") && ARGS.size() == 1) || ARGS.isEmpty()) {
            System.out.println("Extracting and adjusting embedded configuration file");
            ARGS.add(MyUtils.extractAndAdjustEmbedded());
        } else {
            System.out.println("Using provided command line arguments");            
        }

        Bootstrapper.main((String[]) ARGS.toArray(args));

    }

}
