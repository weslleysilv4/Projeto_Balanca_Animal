//package com.mycompany.mavenproject1;
//
///**
// *
// * @author Wes
// */
//import java.util.ArrayList;
//import java.util.List;
//
//public class GerAnimal {
//    private Animal anim;
//    private final List<Animal> bdAnimal= new ArrayList<Animal>();
//    private final Leitura l = new Leitura();
//    public Animal cadAnimal(Animal an){
//        try {
//            an.setCodAnimal(Integer.parseInt(l.entDados("\nCODIGO ANIMAL: ")));
//            an.setPesoAnimal(Double.parseDouble(l.entDados("PESO ANIMAL: ")));
//            an.setIdadeAnimal(Integer.parseInt(l.entDados("IDADE: ")));
//            String response = l.entDados("O animal possui alguma doenca? <S/N>");
//            an.setDoencaAnimal(response.equalsIgnoreCase("S"));
//        } catch (Exception e){
//            System.out.println("ERRO: "+ e.getMessage());
//        }
//        if (consAnimal(an) == null){
//            bdAnimal.add(an);
//            return anim;
//        }
//        else {
//            return null;
//        }
//    }
//
//    public Animal consAnimal(Animal anim) {
//        for(Animal animal : bdAnimal){
//            if(anim.getCodAnimal() == animal.getCodAnimal()){
//                return animal;
//            }
//        }
//        return null;
//    }
//
//    //Sobrecarga
//    public void impAllAnimal(List<Bovino> bovinos, List<Equino> equinos){
//        if(bdAnimal.isEmpty() && bovinos.isEmpty() && equinos.isEmpty()){
//            System.out.println("Nenhum animal cadastrado! ");
//            return;
//        }
//        for (Animal animal : bdAnimal){
//            System.out.println(
//                "CODIGO: "+ animal.getCodAnimal() +
//                "PESO: "+ animal.getPesoAnimal() +
//                "IDADE: "+ animal.getIdadeAnimal() +
//                "DOENCA: "+ (animal.getDoencaAnimal() ? "Sim" : "Não")
//            );
//        }
//        System.out.println("\n\t\t BOVINOS: ");
//        for (Bovino bovino : bovinos){
//            System.out.println(
//                    "CODIGO: "+ bovino.getCodAnimal() +
//                    "\nPESO: "+ bovino.getPesoAnimal() + "KG" +
//                    "\nPESO EM @: "+ bovino.getPesoEmArroba() +
//                    "\nIDADE: "+ (bovino.getIdadeAnimal() > 1 ? bovino.getIdadeAnimal() + " Anos" : bovino.getIdadeAnimal() + " Ano") +
//                    "\nDOENCA: "+ (bovino.getDoencaAnimal() ? "Sim" : "Não")
//            );
//        }
//        System.out.println("\n\t\t EQUINOS: ");
//        for (Equino equino : equinos){
//            System.out.println(
//                            "CODIGO: " + equino.getCodAnimal() +
//                            "\nPESO: " + equino.getPesoAnimal() +" KG" +
//                            "\nPERIMETRO TORARICO " + equino.getPerimetroToracico() + " m" +
//                            "\nALTURA: " + equino.getAlturaEquino() + " m" +
//                            "\nIDADE: " + (equino.getIdadeAnimal() > 1 ? equino.getIdadeAnimal() + " Anos" : equino.getIdadeAnimal() + " Ano") +
//                            "\nDOENCA: " + (equino.getDoencaAnimal() ? "Sim" : "Não")
//            );
//        }
//    }
//}
