/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.juego;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoJuego;
import juegomesa.tableros.Tablero;
import juegomesa.utils.FabricaTablero;

/**
 *
 * @author hmari_001
 */
public abstract class JuegoMesa {
    protected Jugador jugador1;
    protected Jugador jugador2;
    protected Tablero tablero;
    protected ETipoJuego tipoJuego;
    protected Jugador jugadorActual;
    protected int contadorTurnos;
    protected StringBuilder registrosJugadas;
    
    public JuegoMesa(Jugador pjugador1, Jugador pjugador2, ETipoJuego ptipoJuego){
        setJugador1(pjugador1);
        setJugador2(pjugador2);
        setTipoJuego(ptipoJuego);
        setJugadorActual(null);
        setContadorTurnos(0);
        setRegistrosJugadas(null);
        iniciarJuego(ptipoJuego);
    }
    
    public Jugador getJugador1(){
        return jugador1;
    }
    
    public void setJugador1(Jugador pjugador1){
        jugador1 = pjugador1;
    }
    
    public Jugador getJugador2(){
        return jugador2;
    }
    
    public void setJugador2(Jugador pjugador2){
        jugador2 = pjugador2;
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    
    public void setTablero(Tablero ptablero){
        tablero = ptablero;
    }
    
    public ETipoJuego getTipoJuego(){
        return tipoJuego;
    }
    
    public void setTipoJuego(ETipoJuego ptipoJuego){
        tipoJuego = ptipoJuego;
    }
    
    public Jugador getJugadorActual(){
        return jugadorActual;
    }
    
    public void setJugadorActual(Jugador pjugadorActual){
        jugadorActual = pjugadorActual;
    }
    
    public int getContadorTurnos(){
        return contadorTurnos;
    }
    
    public void setContadorTurnos(int pcontadorTurnos){
        contadorTurnos = pcontadorTurnos;
    }
    
    public StringBuilder getRegistrosJugadas(){
        return registrosJugadas;
    }
    
    public void setRegistrosJugadas(StringBuilder pregistrosJugadas){
        registrosJugadas = pregistrosJugadas;
    }
    
    public void iniciarJuego(ETipoJuego ptipoJuego){
        setTablero(FabricaTablero.crearTablero(ptipoJuego));
        setJugadorActual(getJugador1());
    }
    
    public boolean realizarJugada(String pjugada){
        if(getTablero().actualizarTablero(pjugada, getJugadorActual().getEColorJugador())){
            return true;
        }else{
            return false;
        }
        
    }
    
    public final boolean jugarTurno(String pjugada){
        if(realizarJugada(pjugada)){
            pasarTurno();
            almacenarJugada(pjugada);
            return true;
        }else{
            return false;
        }
    }
    
    public void pasarTurno(){
        if(getJugadorActual().getEColorJugador() == getJugador2().getEColorJugador()){
            setJugadorActual(getJugador1());
            setContadorTurnos(getContadorTurnos()+1);
        }else{
            setJugadorActual(getJugador2());
        }
    }
    
    public abstract void almacenarJugada(String pjugada);
    
}
