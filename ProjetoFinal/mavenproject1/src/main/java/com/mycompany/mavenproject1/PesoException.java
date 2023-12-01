/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author Wes
 */

public class PesoException extends Exception {
    public PesoException(){
         super("PESO NEGATIVO");
        System.out.println("\n O peso não pode ser negativo! ");
    }
}
