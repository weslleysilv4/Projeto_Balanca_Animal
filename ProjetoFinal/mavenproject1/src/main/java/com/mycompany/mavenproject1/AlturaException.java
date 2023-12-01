package com.mycompany.mavenproject1;

/**
 *
 * @author Wes
 */
public class AlturaException extends Exception{
    public AlturaException(){
        super("ALTURA NEGATIVA");
        System.out.println("\nA Altura não pode ser Negativa, Ze");
    }
}
