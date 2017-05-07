/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.juego;

import java.util.Calendar;
import java.util.GregorianCalendar;
import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoJuego;

/**
 *
 * @author hmari_001
 */
public class JuegoDamas extends JuegoMesa{
    public JuegoDamas(Jugador pjugador1, Jugador pjugador2){
        super(pjugador1, pjugador2, ETipoJuego.DAMAS);
        almacenarDatosGeneralesJuego();
    }
    
    public void almacenarDatosGeneralesJuego(){
        Calendar fecha = new GregorianCalendar();
        int anno = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DATE);
        String date = "[Date \"" + anno + "-" + (mes + 1) + "-" + dia + "\"]";
        String primerJugador = "[White \" " + jugador1.getUsername() + "\"]";
        String segundoJugador = "[Black \" " + jugador2.getUsername() + "\"]";
        registrosJugadas.append(primerJugador);
        registrosJugadas.append("\n");
        registrosJugadas.append(segundoJugador);
        registrosJugadas.append("\n");
        registrosJugadas.append(date);
        registrosJugadas.append("\n");
        registrosJugadas.append("[GameType \"20\"]");
        registrosJugadas.append("\n");
    }

    @Override
    public void almacenarJugada(String pjugada){
        if(jugadorActual.getEColorJugador() == EColorJugador.BLANCO){
            registrosJugadas.append(contadorTurnos);
            registrosJugadas.append(". ");
            registrosJugadas.append(pjugada);
            registrosJugadas.append(" ");
        }else{
            registrosJugadas.append(pjugada);  
            registrosJugadas.append("\n");
        }
    }
}
