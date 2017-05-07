/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.main;
import java.util.ArrayList;
import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoFicha;
import juegomesa.emuns.ETipoJuego;
import juegomesa.juego.Jugador;
import juegomesa.juego.JuegoMesa;
import juegomesa.tableros.Casilla;
import juegomesa.utils.FabricaTipoJuego;
import juegomesa.utils.GeneradorArchivosJugadores;
/**
 *
 * @author carlo
 */
public class Gestora {
    private final ArrayList<Jugador>jugadoresRegistrados;
    private Jugador jugadorActual;
    private JuegoMesa juegoActual;
    public Gestora() {
        jugadoresRegistrados=new ArrayList<>();
    }
    
    public boolean registrarJugador(String pUsername,String pEmail,String pPassword,EColorJugador pColorJugador){
        if(!existeUsuario(pUsername) && contraseñaValida(pPassword)){
            jugadoresRegistrados.add(new Jugador(pUsername, pEmail, pPassword, pColorJugador));
            GeneradorArchivosJugadores.generarArchivoJugador(pUsername, pEmail, pPassword);
            return true;
        }else
            return false;
    }

    private boolean existeUsuario(String pUsername) {
        if(!jugadoresRegistrados.isEmpty()){
            for (int i = 0; i < jugadoresRegistrados.size(); i++) {
                if(jugadoresRegistrados.get(i).getUsername().equals(pUsername)){
                    return true;
                }
            }
        }
        return false;
    }
    public String[] obtenerUsuarios(){
        if(obtenerCantidadUsuariosParaInvitar()>0){
            int contadorUsuarios=0;
            String[] usuarios=new String[obtenerCantidadUsuariosParaInvitar()];
            for (int i = 0; i < jugadoresRegistrados.size(); i++) {
                if(!jugadoresRegistrados.get(i).getUsername().equals(jugadorActual.getUsername())){
                    usuarios[contadorUsuarios]=jugadoresRegistrados.get(i).getUsername();
                    contadorUsuarios++;
                }
            }
            return usuarios;
        }
        
        return null;
    }
    public boolean iniciarSesion(String pUsername){
        if(existeUsuario(pUsername)){
            jugadorActual=buscarJugador(pUsername);
            return true;
        }
        return false;
    }

    private Jugador buscarJugador(String pUsername) {
        for (int i = 0; i < jugadoresRegistrados.size(); i++) {
                if(jugadoresRegistrados.get(i).getUsername().equals(pUsername)){
                    return jugadoresRegistrados.get(i);
                }
        }
        return null;
    }
    private int obtenerCantidadUsuariosParaInvitar(){
        int cantidad=0;
        if(jugadoresRegistrados.size()>1){
            for (int i = 0; i < jugadoresRegistrados.size(); i++) {
                if(!jugadoresRegistrados.get(i).getUsername().equals(jugadorActual.getUsername())&&jugadoresRegistrados.get(i).getEColorJugador()!=jugadorActual.getEColorJugador()){
                    cantidad++;
                }
            }
            return cantidad;
        }
        
        return cantidad;
    }
    public boolean iniciarJuego(String pUsernameJ2,ETipoJuego pTipoJuego){
        if(existeUsuario(pUsernameJ2)){
            juegoActual=FabricaTipoJuego.FabricarJuego(pTipoJuego, jugadorActual, buscarJugador(pUsernameJ2));
            return true;
        }else
            return false;
    }
    public boolean realizarJugada(String pJugada){
        return juegoActual.jugarTurno(pJugada);
    }
    public String mostrarTablero(){
        Casilla[][] tablero=juegoActual.getTablero().getCasillasTablero();
        String tableroString="";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tableroString += "|";
                if(tablero[i][j].casillaVacia()){
                    tableroString += "__";
                }else{
                    tableroString += stringLetraInicial(tablero[i][j].getFicha().getTipoFicha());
                    tableroString += stringColor(tablero[i][j].getFicha().getColor());
                }                
            }
            tableroString += "|\n";           
        }
        
        return tableroString;
    }
    
    private String stringLetraInicial(ETipoFicha pTipo){
        switch(pTipo){
            case ARFIL: return "B";
            case CABALLO: return "N";
            case PEON: return "P";
            case REINA: return "Q";
            case REY: return "K";
            case TORRE: return "R";
            case FICHA_DAMAS:
            case FICHA_GO: return " ";
            default: return "";
        }
    }
    
    private String stringColor(EColorJugador pColor){
        switch(pColor){
            case BLANCO: return "W";
            case NEGRO: return "B";
            default: return ""; 
        }
    }
    
    private boolean contraseñaValida(String pPassword) {
        if(pPassword.length() > 5) return true;
        return false;
    }
    
    public JuegoMesa getJuegoActual(){
        return juegoActual;
    }
}
