package com.mycompany.mavenproject1;

/**
 *
 * @author Wes
 */
//Discente: Weslley Silva - RA:2410257

public class BalancaAnimal extends Balanca{
    private Bovino bovino = new Bovino();
    private Equino equino = new Equino();

    public Bovino getBovino(){
        return bovino;
    }
    public Equino getEquino(){
        return equino;
    }

}
