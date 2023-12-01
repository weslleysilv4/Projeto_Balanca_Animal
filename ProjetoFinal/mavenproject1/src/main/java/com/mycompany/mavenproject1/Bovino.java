package com.mycompany.mavenproject1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wes
 */
public class Bovino extends Animal implements CalcPeso{
    private Double pesoEmArroba;

    public Bovino(){
            setCodAnimal(0);
            setIdadeAnimal(0);
            setDoencaAnimal(false);
            setPesoAnimal(0.0);
            pesoEmArroba = 0.0;
    }

    public Double getPesoEmArroba() {
        return pesoEmArroba;
    }

    public void setPesoEmArroba(Double pesoEmArroba) throws PesoException{
        if(pesoEmArroba > 0){
            this.pesoEmArroba = calcPeso(pesoEmArroba);
            return;
        }
        throw new PesoException();
    }

    // Sobrescrita
    @Override
    public Double calcPeso(Double peso) {
        return ((peso * 0.5)/15);
    }
}
