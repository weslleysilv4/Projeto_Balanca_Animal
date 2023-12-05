// DISCENTE: WESLLEY SILVA - RA: 2410257



/**
 *
 * @author Wes
 */
public class Equino extends Animal implements CalcPeso{
    private Double perimetroToracico;
    private Double alturaEquino;

    public Equino() throws PesoException{
            setCodAnimal(0);
            setIdadeAnimal(0);
            setDoencaAnimal("");
            setPesoAnimal(0.0);
            // Equinos
            perimetroToracico = 0.0;
            alturaEquino = 0.0;
    }

    public Double getPerimetroToracico() {
        return perimetroToracico;
    }

    public void setPerimetroToracico(Double perimetroToracico){
        this.perimetroToracico = perimetroToracico;
    }

    public Double getAlturaEquino() {
        return alturaEquino;
    }

    public void setAlturaEquino(Double alturaEquino) throws AlturaException{
        if(alturaEquino <= 0) {
            throw new AlturaException("A altura não pode ser menor que 0");
        }
        this.alturaEquino = alturaEquino;
    }

    //
    public Double calcPeso(Double perimetroToracico) {
        return (Math.pow(perimetroToracico,3) * 80);
    }
}
