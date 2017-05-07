/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.main;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoJuego;

/**
 *
 * @author jmda9
 */
public class JuegoMesaMain {

    /**
     * @param args the command line arguments
     */
    private static Gestora gestora;
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static PrintStream out = System.out;
    
    public static void main(String[] args) throws IOException {
        gestora=new Gestora();
        boolean salir=false;
        do {            
            mostrarMenu();
            char opc= leerOpcion();
            salir=ejecutarMenuPrincipal(opc);
        } while (!salir);

    }

    private static void mostrarMenu() {
        out.println("====Menu principal====");
        out.println("1-Crear cuenta");
        out.println("2-Ingresar");
        out.println("3-Salir");
    }

    private static char leerOpcion() throws IOException {
        out.print("Digite su opcion: ");
        return in.readLine().charAt(0);
    }

    private static boolean ejecutarMenuPrincipal(char opc) throws IOException {
        switch(opc){
            case '1':
               ejecutarCrearCuenta();
               return false;
            case '2':
               ejecutarIngresar();
               return false;
            case '3':
               return true;
            default:
                out.println("Por favor ingrese una opcion valida");
                return false;
        }
    }

    private static void ejecutarCrearCuenta() throws IOException {
        out.println("Username: ");
        String username= in.readLine();
        out.println("Email: ");
        String email= in.readLine();
        out.println("Password: ");
        String password= in.readLine();
        out.println("Seleccione su color (1-Negro,2-Blanco): ");
        char color= in.readLine().charAt(0);
        if(gestora.registrarJugador(username, email, password, getColor(color))){
            out.println("Jugador registrado con exito!!");
        }else
            out.println("Nombre de usuario ya registrado");

}

    private static EColorJugador getColor(char color) {
       switch(color){
           case '1':
               return EColorJugador.NEGRO;
           case '2':
               return EColorJugador.BLANCO;
           default:
               return EColorJugador.BLANCO;
       }
    }

    private static void ejecutarIngresar() throws IOException {
        out.println("Digite su nombre de usuario: ");
        String username= in.readLine();
        if(gestora.iniciarSesion(username)){
            ejecutarMenuJuego();
        }else{
            out.println("Datos incorrectos o el usuario no se encuentra registrado");
        }
    }

    private static void ejecutarMenuJuego() throws IOException{
        boolean salir=false;
        do {
            mostrarMenuJuego();
            char opc= leerOpcion();
            salir=ejecutarMenuJuego(opc);
        } while (!salir);
    }

    private static void mostrarMenuJuego() {
        out.println("================");
        out.println("1-Jugar");
        out.println("2-Salir");
    }

    private static boolean ejecutarMenuJuego(char opc) throws IOException {
        switch(opc){
            case '1':
               ejecutarIniciarJuego();
               return false;
            case '2':
               return true;
            default:
                out.println("Por favor ingrese una opcion valida");
                return false;
        }
    }

    private static void ejecutarIniciarJuego() throws IOException {
        mostrarOpcionesDeJuegos();
        char opc=leerOpcion();
        ejecutarOpcionJuego(opc);
    }

    private static void mostrarOpcionesDeJuegos() {
        out.println("===Seleccione un juego de estrategia===");
        out.println("1-Damas");
        out.println("2-Ajedrez");
        out.println("3-Go");
        out.println("4-Salir");
    }

    private static void ejecutarOpcionJuego(char opc) throws IOException {
        switch(opc){
            case '1':
                iniciarJuego(ETipoJuego.DAMAS);
                break;
            case '2':
                iniciarJuego(ETipoJuego.AJEDREZ);
                break;
            case '3':
                iniciarJuego(ETipoJuego.GO);
                break;
            case '4':
                break;
            default:
                break;
        }
    }

    private static void iniciarJuego(ETipoJuego eTipoJuego) throws IOException {
        String[] jugadores=gestora.obtenerUsuarios();
        out.println("Por favor invite a un jugador");
        if(mostrarJugadores(jugadores)){
            char opc=leerOpcion();
            int pos=Integer.parseInt(""+opc)-1;
            ejecutarJuego(eTipoJuego,jugadores[pos]);
        }
    }

    private static boolean mostrarJugadores(String [] pJugadores) {
        
        if (pJugadores!=null) {
            for (int i = 0; i < pJugadores.length; i++) {
                out.println((i+1)+"-"+pJugadores[i]);
            }
            return true;
        }else{
            out.println("No se encuentran mas usuarios registrados");
            return false;
        }
    }

    private static void ejecutarJuego(ETipoJuego eTipoJuego, String jugadore) throws IOException {
        boolean salir=false;
        do {            
            String opc=mostrarOpcionJugada();
            salir=ejecutarJugada(opc);
        } while (!salir);
    }

    private static String mostrarOpcionJugada() throws IOException {
        out.println("Por favor ingrese su jugada"+"\n Digite 0 para salir o -1 para mostrar el tablero");
        return in.readLine();
    }

    private static boolean ejecutarJugada(String opc) {
       if(opc.equals("-1")){
           mostrarTablero();
           return false;
       }else if(opc.equals("0")){
           return true;
       }else {
            realizarJugada(opc);
            return false;
       }
    }

    private static void realizarJugada(String opc) {
        if(gestora.realizarJugada(opc))
            out.println("Movimiento incorrecto");
    }

    private static void mostrarTablero() {
        out.println(gestora.mostrarTablero());
    }
}
