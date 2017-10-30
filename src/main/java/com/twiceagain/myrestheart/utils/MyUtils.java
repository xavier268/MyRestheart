/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Various utilities.
 * @author xavier
 */
public class MyUtils {
    
    /**
     * Save embedded resource file locally in default filesytem.
     * Actual location will depend from wheteer we are running as jar (cli) or folder (netbeans).
     * Existing file will be replaced, if any.
     * @param resourceName relative to the root jar directory.
     * @param fileName 
     * @return  absolute file name of the saved resource.
     */
    static public String  copyResourceToFile(String resourceName, String fileName) {
        
        // Copy embedded custom configuration file locally.
        InputStream is = ClassLoader.getSystemResourceAsStream(resourceName);
        Path target = Paths.get(fileName);
        try {
            Files.copy(is, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(MyUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return target.toAbsolutePath().toString();
        
    }
    
}
