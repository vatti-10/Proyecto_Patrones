/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.tableros;

import juegomesa.fichas.Ficha;
import juegomesa.utils.convertidores.ConvertidorInputsDamas;

/**
 *
 * @author carlo
 */
public abstract class Tablero {
    protected Casilla[][] casillasTablero;

    public Tablero() {
        construirCasillasTablero();
    }
    public abstract void construirCasillasTablero();
    public void rellarTableroConCasillas(){
        for (int i = 0; i < this.casillasTablero.length; i++) {
            for (int j = 0; j < this.casillasTablero[i].length; j++) {
                casillasTablero[i][j]=new Casilla();
            }
        }
    }
    public Casilla[][] getCasillasTablero(){
        return casillasTablero;
    }
    public int[] getCoordenadasNumericas(String pCoordenadas){
        ConvertidorInputsDamas convertidorInputsDamas = new ConvertidorInputsDamas();
        return convertidorInputsDamas.convertir(pCoordenadas);
    }
    public Ficha getFicha(int pCoordenadaX,int pCoordenadaY){
        return getCasillasTablero()[pCoordenadaY][pCoordenadaX].getFicha();
    }
    public abstract void actualizarTablero(String pCoordenadas);
    
    public abstract boolean verificarCoordenadas(String pCoordenadas);
    
    public boolean validarCoordenadas(int[] coordenas) {
        return coordenas[0]<getCasillasTablero()[0].length
                && coordenas[1]<getCasillasTablero().length
                && coordenas[2]<getCasillasTablero()[0].length
                && coordenas[3]<getCasillasTablero().length;
    }
}
