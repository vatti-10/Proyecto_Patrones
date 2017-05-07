/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.fichas.estadosfichas;

import juegomesa.fichas.FichaDamas;

/**
 *
 * @author jmda9
 */
public class EstadoFichaDamasCorona implements IEstadoFichaDamas{
    private FichaDamas ficha;

    public EstadoFichaDamasCorona(FichaDamas pFicha) {
        this.ficha = pFicha;
    }    
    

    @Override
    public boolean verificarMovimientoValido(int[] pCoordenadas) {
        if((Math.abs(pCoordenadas[2]-ficha.getCoordenadaX()) == Math.abs(pCoordenadas[3]-ficha.getCoordenadaY())) && (pCoordenadas[2] != ficha.getCoordenadaX())) return true;
        return false;
    }

    @Override
    public void actualizarCoordenadas(int[] pCoordenadas) {
        ficha.setCoordenadaX(pCoordenadas[2]);
        ficha.setCoordenadaY(pCoordenadas[3]);
    }
    
}
