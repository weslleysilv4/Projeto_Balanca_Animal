package com.mycompany.mavenproject1;

/**
 *
 * @author Wes
 */
public class Bovino extends Animal implements CalcPeso{
    private Double pesoEmArroba;

    public Bovino() throws PesoException{
            setCodAnimal(0);
            setIdadeAnimal(0);
            setDoencaAnimal("");
            setPesoAnimal(0.0);
            pesoEmArroba = 0.0;
    }

    public Double getPesoEmArroba() {
        return pesoEmArroba;
    }

    public void setPesoEmArroba(Double pesoEmArroba) throws PesoException{
        if(pesoEmArroba < 0){
            throw new PesoException("O peso não pode ser Negativo");
        }
        this.pesoEmArroba = calcPeso(pesoEmArroba);
    }

    // Sobrescrita
    @Override
    public Double calcPeso(Double peso) {
        return ((peso * 0.5)/15);
    }
}
