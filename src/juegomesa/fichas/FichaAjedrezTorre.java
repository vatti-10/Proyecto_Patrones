/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.fichas;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoFicha;
import juegomesa.emuns.ETipoJuego;

/**
 *
 * @author jmda9
 */
public class FichaAjedrezTorre extends Ficha{
    
    public FichaAjedrezTorre(int[] pCoordenadas, EColorJugador pColor) {
        super(pCoordenadas[0], pCoordenadas[1], ETipoFicha.TORRE, pColor);
    }

    @Override
    public boolean verificarMovimientoValido(int[] pCoordenadas) {
        
    }
    
}
