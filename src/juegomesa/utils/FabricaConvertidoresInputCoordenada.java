/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.utils;

import juegomesa.emuns.ETipoJuego;
import juegomesa.utils.convertidores.ConvertidorInputsAjedrez;
import juegomesa.utils.convertidores.ConvertidorInputsDamas;
import juegomesa.utils.convertidores.ConvertidorInputsGo;
import juegomesa.utils.convertidores.IConvertidorInput;

/**
 *
 * @author jmda9
 */
public class FabricaConvertidoresInputCoordenada {

    private FabricaConvertidoresInputCoordenada(){}
    
    public static IConvertidorInput fabricarConvertidor(ETipoJuego pTipoInput){
        switch(pTipoInput){
            case AJEDREZ:
                return new ConvertidorInputsAjedrez();
            case DAMAS:
                return new ConvertidorInputsDamas();
            case GO:
                return new ConvertidorInputsGo();
            default:
                return null;
        }
    }
        
}
