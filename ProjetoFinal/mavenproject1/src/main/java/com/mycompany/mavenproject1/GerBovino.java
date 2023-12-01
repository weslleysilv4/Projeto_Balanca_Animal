//package com.mycompany.mavenproject1;
//
///**
// *
// * @author Wes
// */
//import java.util.ArrayList;
//import java.util.List;
//
//public class GerBovino {
//    private Bovino bovino;
//    private final List<Bovino> bdBovino = new ArrayList<Bovino>();
//    private final Leitura l = new Leitura();
//    public Bovino cadBovino (Bovino bov1){
//        try {
//            bov1.setCodAnimal(Integer.parseInt(l.entDados("\nCODIGO ANIMAL: ")));
//            bov1.setPesoAnimal(Double.parseDouble(l.entDados("PESO ANIMAL: ")));
//            bov1.setIdadeAnimal(Integer.parseInt(l.entDados("IDADE: ")));
//            bov1.setPesoEmArroba(bov1.getPesoAnimal());
//            String response = l.entDados("O animal possui alguma doenca? <S/N>");
//            bov1.setDoencaAnimal(response.equalsIgnoreCase("S"));
//        }  catch (Exception e){
//            System.out.println("ERRO: "+ e.getMessage());
//        }
//        if (consBovino(bov1) == null){
//            bdBovino.add(bov1);
//            return bovino;
//        }
//        else {
//            return null;
//        }
//    }
//
//    public Bovino consBovino(Bovino bov1) {
//        for(Bovino bovino1 : bdBovino){
//            if(bovino1.getCodAnimal() == bov1.getCodAnimal()){
//                return bovino;
//            }
//        }
//        return null;
//    }
//
//    public List<Bovino> getListBovino(){
//        return bdBovino;
//    }
//}
//
