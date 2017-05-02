
package juegomesa.fichas;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoJuego;
import juegomesa.utils.FabricaConvertidoresInputCoordenada;


public abstract class Ficha {
    protected int coordenadaX;
    protected int coordenadaY;
    protected String tipo;
    protected EColorJugador color;
    protected ETipoJuego tipoJuego;
    
    public Ficha(int pCoordX, int pCoordY, String pTipo, EColorJugador pColor, ETipoJuego pTipoJuego){
        setCoordenadaX(pCoordX);
        setCoordenadaY(pCoordY);
        setColor(pColor);
        setTipo(pTipo);
    }
    
    public final boolean moverFicha(String pInput){
        int[] coordenadas = convertirInputACoordenadas(pInput, tipoJuego);
        if(verificarMovimientoValido(coordenadas)){
            actualizarCoordenadas(coordenadas);
            return true;
        }
        return false;
    }
    
    protected int[] convertirInputACoordenadas(String pInput, ETipoJuego pTipoInput){
        return FabricaConvertidoresInputCoordenada.fabricarConvertidor(pTipoInput).convertir(pInput);
    }
    
    public abstract boolean verificarMovimientoValido(int[] pCoordenadas);
    
    protected void actualizarCoordenadas(int[] pCoordenadas){
        setCoordenadaX(pCoordenadas[0]);
        setCoordenadaY(pCoordenadas[1]);
    }
    

    /**
     * @return the coordenadaX
     */
    public int getCoordenadaX() {
        return coordenadaX;
    }

    /**
     * @param coordenadaX the coordenadaX to set
     */
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    /**
     * @return the coordenadaY
     */
    public int getCoordenadaY() {
        return coordenadaY;
    }

    /**
     * @param coordenadaY the coordenadaY to set
     */
    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the color
     */
    public EColorJugador getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(EColorJugador color) {
        this.color = color;
    }
}


