/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.juego;

import java.util.Calendar;
import java.util.GregorianCalendar;
import juegomesa.emuns.ETipoJuego;

/**
 *
 * @author hmari_001
 */
public class JuegoGo extends JuegoMesa{
    
    public JuegoGo(Jugador pjugador1, Jugador pjugador2, ETipoJuego ptipoJuego){
       super(pjugador1, pjugador2, ptipoJuego);
       almacenarDatosGeneralesJuego();
    }
    
    public void almacenarDatosGeneralesJuego(){
        Calendar fecha = new GregorianCalendar();
        int anno = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DATE);
        String date = "[DT" + anno + "-" + (mes + 1) + "-" + dia + "]";
        String primerJugador = "PB[" + jugador1.getUsername() + "]";
        String segundoJugador = "PW[" + jugador2.getUsername() + "]";
        registrosJugadas.append(primerJugador);
        registrosJugadas.append("\n");
        registrosJugadas.append(segundoJugador);
        registrosJugadas.append("\n");
        registrosJugadas.append(date);
        registrosJugadas.append("\n");
    }
    
     @Override
    public void almacenarJugada(String pjugada) {
        registrosJugadas.append(pjugada + ";");
    }
}
