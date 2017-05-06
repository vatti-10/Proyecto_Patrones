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
public class FichaAjedrezCaballo extends Ficha{

    public FichaAjedrezCaballo(int pCoordX, int pCoordY, EColorJugador pColor) {
        super(pCoordX, pCoordY, ETipoFicha.CABALLO, pColor);
    }

    @Override
    public boolean verificarMovimientoValido(int[] pCoordenadas) {
        if(pCoordenadas[0] == (coordenadaX+2) && pCoordenadas[1] == (coordenadaY+1)) return true;
        if(pCoordenadas[0] == (coordenadaX+2) && pCoordenadas[1] == (coordenadaY-1)) return true;
        if(pCoordenadas[0] == (coordenadaX-2) && pCoordenadas[1] == (coordenadaY+1)) return true;
        if(pCoordenadas[0] == (coordenadaX-2) && pCoordenadas[1] == (coordenadaY-1)) return true;
        if(pCoordenadas[0] == (coordenadaX+1) && pCoordenadas[1] == (coordenadaY+2)) return true;
        if(pCoordenadas[0] == (coordenadaX+1) && pCoordenadas[1] == (coordenadaY-2)) return true;
        if(pCoordenadas[0] == (coordenadaX-1) && pCoordenadas[1] == (coordenadaY+2)) return true;
        if(pCoordenadas[0] == (coordenadaX-1) && pCoordenadas[1] == (coordenadaY-2)) return true;
        return false;        
    }
    
}
