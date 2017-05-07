/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.utils;

import juegomesa.emuns.ETipoJuego;
import juegomesa.juego.JuegoAjedrez;
import juegomesa.juego.JuegoDamas;
import juegomesa.juego.JuegoGo;
import juegomesa.juego.JuegoMesa;
import juegomesa.juego.Jugador;


/**
 *
 * @author hmari_001
 */
public class FabricaTipoJuego {
    public static JuegoMesa FabricarJuego(ETipoJuego ptipoJuego,Jugador pJugador1,Jugador pJugador2){
        switch(ptipoJuego){
            case AJEDREZ: 
                return new JuegoAjedrez(pJugador1,pJugador2);
                
            case DAMAS:
                return new JuegoDamas(pJugador1,pJugador2);
                
            case GO: 
                return new JuegoGo(pJugador1,pJugador2);
                
            default:
                return null;
        }
    }
}
