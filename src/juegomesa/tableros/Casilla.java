/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.tableros;
import juegomesa.fichas.Ficha;
/**
 *
 * @author carlo
 */
public class Casilla {
    private Ficha ficha;
    private int cordenadax;
    private int cordenaday;

    public Casilla() {
        setCordenadax(0);
        setCordenaday(0);
        setFicha(null);
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha pficha) {
        ficha = pficha;
    }

    public int getCordenadax() {
        return cordenadax;
    }

    public void setCordenadax(int pcordenadax) {
        cordenadax = pcordenadax;
    }

    public int getCordenaday() {
        return cordenaday;
    }

    public void setCordenaday(int pcordenaday) {
       cordenaday = pcordenaday;
    }
    public boolean casillaVacia(){
        return getFicha()==null;
    }
}
