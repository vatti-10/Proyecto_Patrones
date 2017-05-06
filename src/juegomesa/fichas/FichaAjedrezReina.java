/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.fichas;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoFicha;

/**
 *
 * @author jmda9
 */
public class FichaAjedrezReina extends Ficha{

    public FichaAjedrezReina(int pCoordX, int pCoordY, EColorJugador pColor) {
        super(pCoordX, pCoordY, ETipoFicha.REINA, pColor);
    }

    @Override
    protected boolean verificarMovimientoValido(int[] pCoordenadas) {
        if((Math.abs(pCoordenadas[0]-coordenadaX) == Math.abs(pCoordenadas[1]-coordenadaY)) && (pCoordenadas[0] != coordenadaX)) return true;
        if(pCoordenadas[0] == coordenadaX && pCoordenadas[1] != coordenadaY) return true;
        if(pCoordenadas[0] != coordenadaX && pCoordenadas[1] == coordenadaY) return true;
        return false;
    }
    
}
