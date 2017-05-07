/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.fichas.estadosfichas;

/**
 *
 * @author jmda9
 */
public interface IEstadoFichaDamas {
    public boolean verificarMovimientoValido(int[] pCoordenadas);
    public void actualizarCoordenadas(int[] pCoordenadas);
}
