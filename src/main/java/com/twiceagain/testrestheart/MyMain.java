/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.testrestheart;

import org.restheart.Bootstrapper;
import org.restheart.ConfigurationException;

/**
 *
 * @author xavier
 */

public class MyMain {

    /**
     * @param args the command line arguments
     * @throws org.restheart.ConfigurationException
     */
    public static void main(String[] args) throws ConfigurationException {
        System.out.println("\nStarting my customized bootstrapper ...");
        
        Bootstrapper.main(args);

    }

}
