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
    
    static GerEquino gerEquinoUnic;
    
    
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
        for(Equino cav1 : bdEquino){
            if(cav1.getCodAnimal() == cav.getCodAnimal()){
                return cav;
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
    
    public Equino attEquino(Equino cav){
        for(int i = 0; i < bdEquino.size(); i++){
            if(cav.getCodAnimal() == bdEquino.get(i).getCodAnimal()){
                cav = bdEquino.get(i);
                
                String idade = JOptionPane.showInputDialog(
                        null,
                        "Informe a nova Idade do Animal: ",
                        "Atualização de Idade",
                        JOptionPane.QUESTION_MESSAGE
                );
                String altura = JOptionPane.showInputDialog(
                        null,
                        "Informe a nova Altura do Animal: ",
                        "Atualização de Altura",
                        JOptionPane.QUESTION_MESSAGE
                );
                
                if(!idade.equals(""))cav.setIdadeAnimal(Integer.parseInt(idade));
                if(!altura.equals(""))cav.setAlturaEquino(Double.parseDouble(altura));
               
                bdEquino.set(i, cav);
                return bdEquino.get(i);
            }
        }
        return null;
    }
}

