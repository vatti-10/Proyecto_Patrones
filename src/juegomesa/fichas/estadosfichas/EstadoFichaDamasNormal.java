/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.fichas.estadosfichas;

import juegomesa.emuns.ETipoFicha;
import juegomesa.fichas.FichaDamas;

/**
 *
 * @author jmda9
 */
public class EstadoFichaDamasNormal implements IEstadoFichaDamas{
    private FichaDamas ficha;

    public EstadoFichaDamasNormal(FichaDamas pFicha) {
        this.ficha = pFicha;
    }    

    @Override
    public boolean verificarMovimientoValido(int[] pCoordenadas) {
        switch(ficha.getColor()){
            case BLANCO:
                return verficarMovimientoFichaBlanca(pCoordenadas);
            case NEGRO:
                return verficarMovimientoFichaNegra(pCoordenadas);
            default:
                return false;
        }
    }

    private boolean verficarMovimientoFichaBlanca(int[] pCoordenadas) {
        if(Math.abs(pCoordenadas[2]-ficha.getCoordenadaX()) == 1 && pCoordenadas[3] == ficha.getCoordenadaY()-1) return true;
        if(Math.abs(pCoordenadas[2]-ficha.getCoordenadaX()) == 2 && pCoordenadas[3] == ficha.getCoordenadaY()-2) return true;
        if(Math.abs(pCoordenadas[2]-ficha.getCoordenadaX()) == 2 && pCoordenadas[3] == ficha.getCoordenadaY()+2) return true;
        return false;
    }

    private boolean verficarMovimientoFichaNegra(int[] pCoordenadas) {
        if(Math.abs(pCoordenadas[2]-ficha.getCoordenadaX()) == 1 && pCoordenadas[3] == ficha.getCoordenadaY()+1) return true;
        if(Math.abs(pCoordenadas[2]-ficha.getCoordenadaX()) == 2 && pCoordenadas[3] == ficha.getCoordenadaY()+2) return true;
        if(Math.abs(pCoordenadas[2]-ficha.getCoordenadaX()) == 2 && pCoordenadas[3] == ficha.getCoordenadaY()-2) return true;
        return false;
    }

    @Override
    public void actualizarCoordenadas(int[] pCoordenadas) {
        ficha.setCoordenadaX(pCoordenadas[2]);
        ficha.setCoordenadaY(pCoordenadas[3]);
        verificarCambioDeEstadoNecesario();
    }

    private void verificarCambioDeEstadoNecesario() {
        switch(ficha.getColor()){
            case BLANCO:
                if(ficha.getCoordenadaY() == 0) ficha.setEstado(ficha.getEstadoCorona());
                break;
            case NEGRO:
                if(ficha.getCoordenadaY() == 9) ficha.setEstado(ficha.getEstadoCorona());
                break;
        }
        if(ficha.getEstado() == ficha.getEstadoCorona()) ficha.setTipoFicha(ETipoFicha.DAMAS_CORONA);
    }
    
}
