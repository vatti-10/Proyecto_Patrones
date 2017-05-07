/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.fichas;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoFicha;
import juegomesa.fichas.estadosfichas.EstadoFichaDamasCorona;
import juegomesa.fichas.estadosfichas.EstadoFichaDamasNormal;
import juegomesa.fichas.estadosfichas.IEstadoFichaDamas;

/**
 *
 * @author jmda9
 */
public class FichaDamas extends Ficha{
    
    private IEstadoFichaDamas estadoNormal;
    private IEstadoFichaDamas estadoCorona;
    private IEstadoFichaDamas estado;

    public FichaDamas(int pCoordX, int pCoordY, EColorJugador pColor) {
        super(pCoordX, pCoordY, ETipoFicha.FICHA_DAMAS, pColor);
        setEstadoNormal(new EstadoFichaDamasNormal(this));
        setEstadoCorona(new EstadoFichaDamasCorona(this));
        setEstado(getEstadoNormal());
    }

    @Override
    protected boolean verificarMovimientoValido(int[] pCoordenadas) {
        return getEstado().verificarMovimientoValido(pCoordenadas);
    }

    @Override
    protected void actualizarCoordenadas(int[] pCoordenadas) {
        getEstado().actualizarCoordenadas(pCoordenadas);
    }

    /**
     * @return the estadoNormal
     */
    public IEstadoFichaDamas getEstadoNormal() {
        return estadoNormal;
    }

    /**
     * @param estadoNormal the estadoNormal to set
     */
    public void setEstadoNormal(IEstadoFichaDamas estadoNormal) {
        this.estadoNormal = estadoNormal;
    }

    /**
     * @return the estadoCorona
     */
    public IEstadoFichaDamas getEstadoCorona() {
        return estadoCorona;
    }

    /**
     * @param estadoCorona the estadoCorona to set
     */
    public void setEstadoCorona(IEstadoFichaDamas estadoCorona) {
        this.estadoCorona = estadoCorona;
    }

    /**
     * @return the estado
     */
    public IEstadoFichaDamas getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(IEstadoFichaDamas estado) {
        this.estado = estado;
    }
    
    
    
}
