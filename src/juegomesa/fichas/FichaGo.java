/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.fichas;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoFicha;
import juegomesa.emuns.ETipoJuego;
import juegomesa.utils.FabricaConvertidoresInputCoordenada;

/**
 *
 * @author jmda9
 */
public class FichaGo extends Ficha{

    public FichaGo(int pCoordX, int pCoordY, EColorJugador pColor) {
        super(pCoordX, pCoordY, ETipoFicha.FICHA_GO, pColor);
    }    

    @Override
    public boolean verificarMovimientoValido(int[] pCoordenadas) {
        return true;
    }
    
}
