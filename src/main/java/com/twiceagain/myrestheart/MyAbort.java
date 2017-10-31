/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart;

import static com.twiceagain.myrestheart.MyStart.ARGS;
import org.restheart.Shutdowner;

/**
 *
 * @author xavier
 */
public class MyAbort {

    /**
     * @Todo - does not actuelally close the running instance ?
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.printf("\nPreparing to abort custom Restheart application ...\n");
        Shutdowner.main(ARGS.toArray(args));
    }
    
}
