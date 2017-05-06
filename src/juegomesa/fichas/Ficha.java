
package juegomesa.fichas;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoFicha;
import juegomesa.emuns.ETipoJuego;
import juegomesa.utils.FabricaConvertidoresInputCoordenada;


public abstract class Ficha {
    protected int coordenadaX;
    protected int coordenadaY;
    protected ETipoFicha tipoFicha;
    protected EColorJugador color;
    
    public Ficha(int pCoordX, int pCoordY, ETipoFicha pTipo, EColorJugador pColor){
        setCoordenadaX(pCoordX);
        setCoordenadaY(pCoordY);
        setColor(pColor);
        setTipoFicha(pTipo);
    }
    
    public final boolean moverFicha(int[] pCoordenadas){
        if(verificarMovimientoValido(pCoordenadas)){
            actualizarCoordenadas(pCoordenadas);
            return true;
        }
        return false;
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
     * @return the tipoFicha
     */
    public ETipoFicha getTipoFicha() {
        return tipoFicha;
    }

    /**
     * @param tipoFicha the tipoFicha to set
     */
    public void setTipoFicha(ETipoFicha tipoFicha) {
        this.tipoFicha = tipoFicha;
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


