/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.main;
import java.util.ArrayList;
import juegomesa.emuns.EColorJugador;
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
        if(!existeUsuario(pUsername)){
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
        switch(juegoActual.getTipoJuego()){
            case AJEDREZ:
                tableroString=getTableroAjedrez(tablero);
                break;
            case DAMAS:
                tableroString=getTableroDamas(tablero);
                break;
            case GO:
                tableroString=getTableroGo(tablero);
                break;
        }
        return tableroString;
    }

    private String getTableroAjedrez(Casilla[][] tablero) {
        String resul="";
        for (int i = 0; i < tablero.length; i++) {
            resul+="|";
            for (int j = 0; j < tablero[i].length; j++) {
                if(!tablero[i][j].casillaVacia()&& j==tablero[i].length-1){
                    resul+=" "+getTipoFicha(i, j, tablero)+" |\n";
                }else if(!tablero[i][j].casillaVacia()){
                    resul+=" "+getTipoFicha(i, j, tablero)+" |";
                }else if(tablero[i][j].casillaVacia() && j==tablero[i].length-1){
                    resul+=" _  |\n";
                }else {
                    resul+=" _  |";
                }
            }
        }
         return resul;
    }

    private String getTableroDamas(Casilla[][] tablero) {
        String resul="";
        for (int i = 0; i < tablero.length; i++) {
            resul+="|";
            for (int j = 0; j < tablero[i].length; j++) {
                if(!tablero[i][j].casillaVacia()&& j==tablero[i].length-1){
                    resul+=" "+getColorFicha(i, j, tablero)+" |\n";
                }else if(!tablero[i][j].casillaVacia()&& j==tablero[i].length-1){
                    resul+=" "+getColorFicha(i, j, tablero)+" |\n";
                }else if(tablero[i][j].casillaVacia() && j==tablero[i].length-1){
                    resul+=" _  |\n";
                }else {
                    resul+=" _  |";
                }
            }
        }
         return resul;
    }

    private String getTableroGo(Casilla[][] tablero) {
         String resul="";
        for (int i = 0; i < tablero.length; i++) {
            resul+="|";
            for (int j = 0; j < tablero[i].length; j++) {
                if(!tablero[i][j].casillaVacia()&& j==tablero[i].length-1){
                    resul+=" "+getColorFicha(i, j, tablero)+" |\n";
                }else if(!tablero[i][j].casillaVacia()&& j==tablero[i].length-1){
                    resul+=" "+getColorFicha(i, j, tablero)+" |\n";
                }else if(tablero[i][j].casillaVacia() && j==tablero[i].length-1){
                    resul+=" _  |\n";
                }else {
                    resul+=" _  |";
                }
            }
        }
         return resul;
    }
    private char getTipoFicha(int i,int j,Casilla[][] tablero){
        char ficha = 0;
        switch(tablero[i][j].getFicha().getTipoFicha()){
            case ARFIL:
                ficha= 'B';
            case CABALLO:
                ficha= 'N';
            case TORRE:
                ficha= 'R';
            case REY:
                ficha= 'K';
            case REINA:
                ficha= 'Q';
            case PEON:
                ficha= 'P';
        }
        return ficha;
    }
    private char getColorFicha(int i,int j,Casilla[][] tablero){
        char ficha = 0;
        switch(tablero[i][j].getFicha().getColor()){
            case BLANCO:
                ficha= 'W';
            case NEGRO:
                ficha= 'B';
        }
        return ficha;
    }
}
