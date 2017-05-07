/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.utils;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoFicha;
import juegomesa.fichas.Ficha;
import juegomesa.fichas.FichaAjedrezArfil;
import juegomesa.fichas.FichaAjedrezCaballo;
import juegomesa.fichas.FichaAjedrezPeon;
import juegomesa.fichas.FichaAjedrezReina;
import juegomesa.fichas.FichaAjedrezRey;
import juegomesa.fichas.FichaAjedrezTorre;
import juegomesa.fichas.FichaDamas;
import juegomesa.fichas.FichaGo;

/**
 *
 * @author jmda9
 */
public class FabricaFichas {
    private FabricaFichas(){}
    
    public static Ficha crearFicha(ETipoFicha pTipo, int pCoordX, int pCoordY, EColorJugador pColor){
        switch(pTipo){
            case FICHA_GO:
                return new FichaGo(pCoordX, pCoordY, pColor);
            case FICHA_DAMAS:
                return new FichaDamas(pCoordX, pCoordY, pColor);
            case PEON:
                return new FichaAjedrezPeon(pCoordX, pCoordY, pColor);
            case TORRE:
                return new FichaAjedrezTorre(pCoordX, pCoordY, pColor);
            case ARFIL:
                return new FichaAjedrezArfil(pCoordX, pCoordY, pColor);
            case CABALLO:
                return new FichaAjedrezCaballo(pCoordX, pCoordY, pColor);
            case REINA:
                return new FichaAjedrezReina(pCoordX, pCoordY, pColor);
            case REY:
                return new FichaAjedrezRey(pCoordX, pCoordY, pColor);
            default:
                return null;
        }
    }
    
}
