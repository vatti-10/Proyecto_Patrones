/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.fichas;

import juegomesa.utils.FabricaConvertidoresInputCoordenada;

/**
 *
 * @author jmda9
 */
public class FichaGo extends Ficha{

    public FichaGo(String pInput) {
        int[]coordenadas = FabricaConvertidoresInputCoordenada.fabricarConvertidor(tipoJuego)
        super(coordenadaX, coordenadaY, tipo, color, tipoJuego);
    }
    
    

    @Override
    public boolean verificarMovimientoValido(int[] pCoordenadas) {
        return true;
    }
    
}
