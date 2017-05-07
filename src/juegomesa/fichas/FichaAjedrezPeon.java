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
public class FichaAjedrezPeon extends Ficha{

    public FichaAjedrezPeon(int pCoordX, int pCoordY, EColorJugador pColor) {
        super(pCoordX, pCoordY, ETipoFicha.PEON, pColor);
    }

    @Override
    protected boolean verificarMovimientoValido(int[] pCoordenadas) {
        switch(color){
            case BLANCO:
                return verficarMovimientoFichaBlanca(pCoordenadas);
            case NEGRO:
                return verficarMovimientoFichaNegra(pCoordenadas);
            default:
                return false;
        }
    }

    private boolean verficarMovimientoFichaBlanca(int[] pCoordenadas) {
        if(coordenadaY == 6 && pCoordenadas[0] == coordenadaX && pCoordenadas[1] == coordenadaY-2) return true;
        if(pCoordenadas[0] == coordenadaX && pCoordenadas[1] == coordenadaY-1) return true;
        if(Math.abs(pCoordenadas[0]-coordenadaX) == 1 && pCoordenadas[1] == coordenadaY-1) return true;
        return false;
    }

    private boolean verficarMovimientoFichaNegra(int[] pCoordenadas) {
        if(coordenadaY == 1 && pCoordenadas[0] == coordenadaX && pCoordenadas[1] == coordenadaY+2) return true;
        if(pCoordenadas[0] == coordenadaX && pCoordenadas[1] == coordenadaY+1) return true;
        if(Math.abs(pCoordenadas[0]-coordenadaX) == 1 && pCoordenadas[1] == coordenadaY+1) return true;
        return false;
    }
    
}
