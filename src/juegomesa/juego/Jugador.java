
package juegomesa.juego;

import juegomesa.emuns.EColorJugador;

/**
 *
 * @author hmari_001
 */
public class Jugador {
    private String  username;
    private String correo;
    private String password;
    private String colorJugador;
    private EColorJugador EcolorJugador;
    
    public Jugador(String pusername, String pcorreo, String ppassword, String pcolorJugador, EColorJugador pEColorJugador){
        setUsername(pusername);
        setCorreo(pcorreo);
        setPassword(ppassword);
        setColorJugador(pcolorJugador);
        setEColorJugador(pEColorJugador);
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String pusername){
        username = pusername;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String pcorreo){
        correo = pcorreo;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String ppassword){
        password = ppassword;
    }
    
    public String getColorJugador(){
        return colorJugador;
    }
    
    public void setColorJugador(String pcolorJugador){
        colorJugador = pcolorJugador;
    }
    
    public EColorJugador getEColorJugador(){
        return EcolorJugador;
    }
    
    public void setEColorJugador(EColorJugador pEColorJugador){
        EcolorJugador = pEColorJugador;
    }
}
