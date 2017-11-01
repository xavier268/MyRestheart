/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart;

import com.twiceagain.myrestheart.utils.MyUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.restheart.Bootstrapper;

/**
 *
 * @author xavier
 */
public class MyEntryPoint {

    /**
     * This contains the arguments used to call the bootstrapper, possibly after
     * substitution. It might be needed to call the shutdowner later ...
     */
    static public List<String> ARGS = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        start(args);
    }

    public static void start(String[] args) {
        // Do nothing if already running ...
        // Typically, tests will make multiple calls to start
        if (ARGS != null) {
            return;
        }

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
