/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.utils;

import juegomesa.emuns.ETipoJuego;
import juegomesa.juego.JuegoMesa;
import juegomesa.utils.tipojuego.ITipoJuego;

/**
 *
 * @author hmari_001
 */
public class FabricaTipoJuego {
    public static JuegoMesa FabricarJuego(ETipoJuego ptipoJuego){
        switch(ptipoJuego){
            case AJEDREZ: 
                return new JuegoAjedrez();
                
            case DAMAS:
                return new JuegoDamas();
                
            case GO: 
                return new JuegoGo();
                
            default:
                return null;
    }
}
