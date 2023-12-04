package com.mycompany.mavenproject1;

/**
 *
 * @author Wes
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GerEquino {
    private Equino equino;
    private List<Equino> bdEquino;
    private static GerEquino gerEquinoUnic;
    
    
    private GerEquino () {
        bdEquino = new ArrayList<Equino>();
    }
    
    public static GerEquino getGerEquinoUnic(){
        if(gerEquinoUnic == null){
            gerEquinoUnic = new GerEquino();
        }
        return gerEquinoUnic;
    }
    
    public List<Equino> getBdEquino(){
        return bdEquino;
    }
    
    public Equino cadEquino(Equino cav){
        if (consEquino(cav) == null){
            bdEquino.add(cav);
            return cav;
        }
        else {
            return null;
        }
    }

    public Equino consEquino(Equino cav) {
        for(int i = 0; i < bdEquino.size(); i++){
            if(cav.getCodAnimal() == bdEquino.get(i).getCodAnimal()){
                return bdEquino.get(i);
            }
        }
        return null;
    }
    
    public Equino remEquino(Equino cav){
        Equino cav1 = consEquino(cav);
        if(cav1 != null){
            bdEquino.remove(cav1);
            return null;
        }
        else {
            return cav;
        }
    }
    
    public Equino attEquino(Equino cav) throws AlturaException{
        for(int i = 0; i < bdEquino.size(); i++){
            try{
                if(cav.getCodAnimal() == bdEquino.get(i).getCodAnimal()){
                    cav = bdEquino.get(i);

                    String idade = JOptionPane.showInputDialog(
                            null,
                            "Informe a nova Idade do Animal: ",
                            "ATUALIZAÇÃO IDADE DO ANIMAL",
                            JOptionPane.QUESTION_MESSAGE
                    );
                    String altura = JOptionPane.showInputDialog(
                            null,
                            "Informe a nova Altura do Animal: ",
                            "ATUALIZAÇÃO ALTURA DO ANIMAL",
                            JOptionPane.QUESTION_MESSAGE
                    );
                    String perimetroT = JOptionPane.showInputDialog(
                            null,
                            "Informe o novo Perimetro Torarico:",
                            "ATUALIZAÇÃO DO PERIMETRO TORARICO",
                            JOptionPane.QUESTION_MESSAGE
                    );
                    String doença = JOptionPane.showInputDialog(
                            null,
                            "Caso possua Doença, informe",
                            "ATUALIZAÇÃO DOENÇA",
                            JOptionPane.QUESTION_MESSAGE
                    );

                    if(!idade.equals(""))cav.setIdadeAnimal(Integer.parseInt(idade));
                    if(!altura.equals(""))cav.setAlturaEquino(Double.parseDouble(altura));
                    if(!perimetroT.equals(""))cav.setPerimetroToracico(Double.parseDouble(perimetroT));
                    if(!doença.equals(""))cav.setDoencaAnimal(doença);

                    bdEquino.set(i, cav);
                    return bdEquino.get(i);
                }
                
            } catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(
                        null,
                        "ERRO, o valor " + nfe + " precisa ser um inteiro.",
                        "ERRO",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        return null;
    }
}

