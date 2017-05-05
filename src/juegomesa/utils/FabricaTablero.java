/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.utils;

import juegomesa.emuns.ETipoJuego;
import juegomesa.tableros.Tablero;
import juegomesa.tableros.TableroAjedrez;
import juegomesa.tableros.TableroDamas;
import juegomesa.tableros.TableroGo;

/**
 *
 * @author carlo
 */
public class FabricaTablero {

    private FabricaTablero() {
    }
    public static Tablero crearTablero(ETipoJuego pTipoJuego){
        switch(pTipoJuego){
            case AJEDREZ:
                return new TableroAjedrez();
            case DAMAS:
                return new TableroDamas();
            case GO:
                return new TableroGo();
            default:
                return null;
        }
    }
}
