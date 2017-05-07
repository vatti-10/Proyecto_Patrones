/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.tableros;

import juegomesa.emuns.EColorJugador;
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
    protected abstract void construirCasillasTablero();
    protected void rellarTableroConCasillas(){
        for (int i = 0; i < this.casillasTablero.length; i++) {
            for (int j = 0; j < this.casillasTablero[i].length; j++) {
                casillasTablero[i][j]=new Casilla();
            }
        }
    }
    public Casilla[][] getCasillasTablero(){
        return casillasTablero;
    }
    protected abstract int[] getCoordenadasNumericas(String pCoordenadas);

    protected boolean estaCasillaVacia(int pCoordenadaX,int pCoordenadaY){
        return getCasillasTablero()[pCoordenadaY][pCoordenadaX].casillaVacia();
    }
    protected Ficha getFicha(int pCoordenadaX,int pCoordenadaY){
        return getCasillasTablero()[pCoordenadaY][pCoordenadaX].getFicha();
    }
    public abstract boolean actualizarTablero(String pCoordenadas,EColorJugador pColorJugador);
    
    protected abstract boolean verificarCoordenadas(String pCoordenadas);
    
    protected boolean validarCoordenadas(int[] coordenas) {
        return coordenas[0]<getCasillasTablero()[0].length
                && coordenas[1]<getCasillasTablero().length
                && coordenas[2]<getCasillasTablero()[0].length
                && coordenas[3]<getCasillasTablero().length;
    }
}
