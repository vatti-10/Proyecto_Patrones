/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.juego;

import juegomesa.emuns.ETipoJuego;
import juegomesa.tableros.Tablero;

/**
 *
 * @author hmari_001
 */
public abstract class JuegoMesa {
    private Jugador jugadorB;
    private Jugador jugadorN;
    private String tipo;
    private Tablero tablero;
    private ETipoJuego tipoJuego;
    private Jugador jugadorActual;
    private int contadorTurnos;
    private StringBuilder registrosJugadas;
    
    public JuegoMesa(Jugador pjugadorB, Jugador pjugadorN, String ptipo, Tablero ptablero, ETipoJuego ptipoJuego, Jugador pjugadorActual, int pcontadorTurnos, StringBuilder pregistrosJugadas){
        setJugadorB(pjugadorB);
        setJugadorN(pjugadorN);
        setTipo(ptipo);
        setTablero(ptablero);
        setTipoJuego(ptipoJuego);
        setJugadorActual(pjugadorActual);
        setContadorTurnos(pcontadorTurnos);
        setRegistrosJugadas(pregistrosJugadas);
    }
    
    public Jugador getJugadorB(){
        return jugadorB;
    }
    
    public void setJugadorB(Jugador pjugadorB){
        jugadorB = pjugadorB;
    }
    
    public Jugador getJugadorN(){
        return jugadorN;
    }
    
    public void setJugadorN(Jugador pjugadorN){
        jugadorN = pjugadorN;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String ptipo){
        tipo = ptipo;
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
    
    public abstract iniciarJuego(){
        
    }
    
}
