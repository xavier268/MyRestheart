/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Various utilities.
 *
 * @author xavier
 */
public class MyUtils {

    /**
     * Save embedded resource file locally in default filesytem. Actual location
     * will depend from wheteer we are running as jar (cli) or folder
     * (netbeans). Existing file will be replaced, if any.
     *
     * @param resourceName relative to the root jar directory.
     * @param fileName
     * @return absolute file name of the saved resource.
     */
    static public String copyResourceToFile(String resourceName, String fileName) {
        // Copy embedded custom configuration file locally.
        InputStream is = ClassLoader.getSystemResourceAsStream(resourceName);
        Path target = Paths.get(fileName);
        try {
            Files.copy(is, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.err.println(Arrays.toString(ex.getStackTrace()));
            return null;
        }
        return target.toAbsolutePath().toString();
    }

    /**
     * Save embedded resource file locally in default filesytem. Actual location
     * will depend from wheteer we are running as jar (cli) or folder
     * (netbeans). Existing file will be replaced, if any.
     *
     * @param resourceName relative to the root jar directory. Will be used as
     * the local target file name.
     * @return absolute file name of the saved resource.
     */
    static public String copyResourceToFile(String resourceName) {
        try {
            // Create extracted directory if it does not exists.
            if (!Files.exists(Paths.get("extracted/"))) {
                Files.createDirectory(Paths.get("extracted/"));
            }
            return copyResourceToFile(resourceName, "extracted/" + resourceName);
        } catch (IOException ex) {
            Logger.getLogger(MyUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Extract all necessary embeded ressources from file. The parameters are
     * adjusted as needed, with the absolute file names.
     *
     * @return absolute file name of the main configuration file.
     */
    static public String extractAndAdjustEmbedded() {

        try {
            String configure = copyResourceToFile("mydefaultconfig.yml");
            String security = copyResourceToFile("security.yml");

            // Substitute absolute path names.
            List<String> newConf = Files.lines(Paths.get(configure))
                    .map((line) -> {
                        line = line.replaceAll("security.yml", security);
                        return line;
                    })
                    .collect(Collectors.toList());

            // Rewrite modified file.
            Files.write(Paths.get(configure), newConf, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            return configure;
        } catch (IOException ex) {
            Logger.getLogger(MyUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
