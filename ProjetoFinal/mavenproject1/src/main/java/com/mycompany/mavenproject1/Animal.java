package com.mycompany.mavenproject1;

/**
 *
 * @author Wes
 */
//Discente: Weslley Silva - RA:2410257
public abstract class Animal {
    private int codAnimal;
    private int idadeAnimal;
    private Double pesoAnimal;
    private Boolean doencaAnimal;

    //Getters and setters

    public int getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(int codAnimal) {
        this.codAnimal = codAnimal;
    }

    public int getIdadeAnimal() {
        return idadeAnimal;
    }

    public void setIdadeAnimal(int idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public Double getPesoAnimal() {
        return pesoAnimal;
    }

    public void setPesoAnimal(Double pesoAnimal){
        this.pesoAnimal = pesoAnimal;
    }

    public Boolean getDoencaAnimal() {
        return doencaAnimal;
    }

    public void setDoencaAnimal(Boolean doencaAnimal) {
        this.doencaAnimal = doencaAnimal;
    }

}
