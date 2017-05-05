/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.tableros;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoFicha;
import juegomesa.fichas.Ficha;

/**
 *
 * @author carlo
 */
public class TableroAjedrez extends Tablero{

    @Override
    public void construirCasillasTablero() {
        casillasTablero=new Casilla[8][8];
        rellarTableroConCasillas();
        ubicarFichas();
    }

    @Override
    public int[] getCoordenadasNumericas(String pCoordenadas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarTablero(String pCoordenadas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarCoordenadas(String pCoordenadas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ubicarFichas(){
        ubicarFichasBlancas();
        ubicarFichasNegras();
    }

    private void ubicarFichasBlancas() {
        getCasillasTablero()[0][0].setFicha(new Ficha(0, 0, ETipoFicha.TORRE, EColorJugador.BLANCO));
        getCasillasTablero()[0][7].setFicha(new Ficha(0, 0, ETipoFicha.TORRE, EColorJugador.BLANCO));
        getCasillasTablero()[0][1].setFicha(new Ficha(0, 0, ETipoFicha.CABALLO, EColorJugador.BLANCO));
        getCasillasTablero()[0][6].setFicha(new Ficha(0, 0, ETipoFicha.CABALLO, EColorJugador.BLANCO));
        getCasillasTablero()[0][2].setFicha(new Ficha(0, 0, ETipoFicha.ARFIL, EColorJugador.BLANCO));
        getCasillasTablero()[0][5].setFicha(new Ficha(0, 0, ETipoFicha.ARFIL, EColorJugador.BLANCO));
        getCasillasTablero()[0][3].setFicha(new Ficha(0, 0, ETipoFicha.REINA, EColorJugador.BLANCO));
        getCasillasTablero()[0][4].setFicha(new Ficha(0, 0, ETipoFicha.REY, EColorJugador.BLANCO));
        ubicarPeones(1);
    }

    private void ubicarFichasNegras() {
        getCasillasTablero()[0][0].setFicha(new Ficha(0, 0, ETipoFicha.TORRE, EColorJugador.BLANCO));
        getCasillasTablero()[0][7].setFicha(new Ficha(0, 0, ETipoFicha.TORRE, EColorJugador.BLANCO));
        getCasillasTablero()[0][1].setFicha(new Ficha(0, 0, ETipoFicha.CABALLO, EColorJugador.BLANCO));
        getCasillasTablero()[0][6].setFicha(new Ficha(0, 0, ETipoFicha.CABALLO, EColorJugador.BLANCO));
        getCasillasTablero()[0][2].setFicha(new Ficha(0, 0, ETipoFicha.ARFIL, EColorJugador.BLANCO));
        getCasillasTablero()[0][5].setFicha(new Ficha(0, 0, ETipoFicha.ARFIL, EColorJugador.BLANCO));
        getCasillasTablero()[0][3].setFicha(new Ficha(0, 0, ETipoFicha.REINA, EColorJugador.BLANCO));
        getCasillasTablero()[0][4].setFicha(new Ficha(0, 0, ETipoFicha.REY, EColorJugador.BLANCO));
        ubicarPeones(6);
    }
    private void ubicarPeones(int pFila){
        for (int i = 0; i < getCasillasTablero().length; i++) {
            getCasillasTablero()[pFila][i].setFicha(new Ficha(0, 0, ETipoFicha.PEON, EColorJugador.BLANCO));
        }
    }
}
