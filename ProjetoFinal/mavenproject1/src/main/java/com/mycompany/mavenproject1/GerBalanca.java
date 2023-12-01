///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// */
//
//package com.mycompany.weslleysilva_2410257;
//
///**
// *
// * @author Família Silva
// */
//import java.util.ArrayList;
//import java.util.List;
//
//public class GerBalanca {
//    private final List<BalancaVeiculo> bdBalanca = new ArrayList<BalancaVeiculo>();
//    private BalancaVeiculo balanca;
//    private final Leitura l = new Leitura();
//
//    public Balanca cadBal(BalancaVeiculo b1){
//        b1.setTicketPesagem(Integer.parseInt(l.entDados("\n COD PESO..: ")));
//        b1.setPesoInicial(Integer.parseInt(l.entDados("\n PESO INICIAL..: ")));
//        b1.setPesoFinal(Integer.parseInt(l.entDados("\n PESO FINAL..: ")));
//        b1.setDestinoCarga(l.entDados("\nDESTINO DA CARGA..: "));
//        b1.setDataPesagem();
//        b1.setPesoLiquido(Math.abs(b1.getPesoInicial() - b1.getPesoFinal()));
//        if (consBalanca(b1) == null){
//            bdBalanca.add(b1);
//            return balanca;
//        }
//        else {
//            return null;
//        }
//    }
//
////    private BalancaVeiculo consBalanca(BalancaVeiculo bal){;;
////        for (BalancaVeiculo balanca : bdBalanca){
////            if(bal.getTicketPesagem() == balanca.getTicketPesagem()){
////                return balanca;
////            }
////        }
////        return null;
////    }
////    public void impAllBdBal(){
////        if(bdBalanca.isEmpty()){
////            System.out.println("\n Nenhum peso Cadastrado!");
////            return;
////        }
////        for (BalancaVeiculo balanca : bdBalanca) {
////            System.out.println("CODIGO: " + balanca.getTicketPesagem() +
////                    "  - PESO INICIAL: " + balanca.getPesoInicial() +
////                    " - PESO FINAL: " + balanca.getPesoFinal() +
////                    " - DESTINO DA CARGA: " + balanca.getDestinoCarga() +
////                    " - DATA PESAGEM..: " + balanca.getDataPesagem() +
////                    " - PESO LIQUIDO: "+ balanca.getPesoLiquido());
////        }
////    }
//}
