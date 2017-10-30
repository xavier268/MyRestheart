/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart;

import org.restheart.Shutdowner;

/**
 *
 * @author xavier
 */
public class MyAbort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.printf("\nPreparing to abort custom Restheart application ...\n");
        Shutdowner.main(args);
    }
    
}
