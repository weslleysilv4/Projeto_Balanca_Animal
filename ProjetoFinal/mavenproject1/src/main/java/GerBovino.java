

/**
 *
 * @author Wes
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GerBovino {
    private Bovino bovino;
    private List<Bovino> bdBovino;
    private static GerBovino getBovUnic;
    
    public static GerBovino getBovUnic(){ //Singleton GerBovino
        if(getBovUnic == null){
            getBovUnic = new GerBovino();
        }
        return getBovUnic;
    }
    private GerBovino (){
        bdBovino = new ArrayList<Bovino>();
    }
    
    public List<Bovino> getBdBovino() {
        return bdBovino;
    }
    
  
    public Bovino cadBovino (Bovino bov){
        if(consBovino(bov) == null){
            bdBovino.add(bov);
            return bov;
        }
        else {
            return null;
        }
    }

    public Bovino consBovino(Bovino bov) {
        for(int i = 0; i < bdBovino.size(); i++){
            if(bov.getCodAnimal() == bdBovino.get(i).getCodAnimal()){
                return bdBovino.get(i);
            }
        }
        return null;
    }

    public Bovino remBovino(Bovino bov){
        Bovino bov1 = consBovino(bov);
        if(bov1 != null){
            bdBovino.remove(bov1);
            return null;
        }
        else {
            return bov1;
        }
    }
    
    public Bovino attBovino(Bovino bov){
        for(int i = 0; i < bdBovino.size(); i++){
            try{
                if(bov.getCodAnimal() == bdBovino.get(i).getCodAnimal()){
                    bov = bdBovino.get(i);
                    String idade = JOptionPane.showInputDialog(
                            null,
                            "Informe a nova Idade do Animal: ",
                            "ATUALIZAÇÃO IDADE DO ANIMAL",
                            JOptionPane.QUESTION_MESSAGE
                    );
                    String doença = JOptionPane.showInputDialog(
                            null,
                            "Caso possua Doença, informe",
                            "ATUALIZAÇÃO DOENÇA",
                            JOptionPane.QUESTION_MESSAGE
                    );
                    String peso = JOptionPane.showInputDialog(
                            null,
                            "Informe o novo Peso",
                            "ATUALIZAÇÃO DE PESO",
                            JOptionPane.QUESTION_MESSAGE
                    );
                    if(!idade.equals(""))bov.setIdadeAnimal(Integer.parseInt(idade));
                    if(!peso.equals(""))bov.setPesoAnimal(Double.parseDouble(peso));
                    if(!doença.equals(""))bov.setDoencaAnimal(doença);
                    
                    bov.setPesoEmArroba(bov.getPesoAnimal());
                    
                    bdBovino.set(i, bov);
                    return bdBovino.get(i);
                }
            }
            catch(PesoException pe){
                JOptionPane.showMessageDialog(
                    null,
                    pe.getMessage(),
                    "ERRO!",
                    JOptionPane.ERROR_MESSAGE
            );
        }
            catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(
                        null,
                        "ERRO, o valor precisa ser Numérico.",
                        "ERRO",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        return null;
    }
}

