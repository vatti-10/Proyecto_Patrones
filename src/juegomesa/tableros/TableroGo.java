/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.tableros;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoFicha;
import juegomesa.emuns.ETipoJuego;
import juegomesa.fichas.Ficha;
import juegomesa.utils.FabricaConvertidoresInputCoordenada;

/**
 *
 * @author carlos
 */
public class TableroGo extends Tablero{

    @Override
    public void construirCasillasTablero() {
        casillasTablero=new Casilla[19][19];
        rellarTableroConCasillas();
    }

    @Override
    public void actualizarTablero(String pCoordenadas) {
        int [] coordenadas=getCoordenadasNumericas(pCoordenadas);
        if(estaCasillaVacia(coordenadas[0],coordenadas[1])){
            ubicarFicha(coordenadas,pCoordenadas.charAt(0));
            observarAlrededorDeFicha(coordenadas);
        }
    }
    
    private void ubicarFicha(int[] coordenadas,char pJugador) {
        if(pJugador=='B'){
            getCasillasTablero()[coordenadas[1]][coordenadas[0]].setFicha(new Ficha(coordenadas[0], coordenadas[1], ETipoFicha.GO, EColorJugador.BLANCO));
        }else{
            getCasillasTablero()[coordenadas[1]][coordenadas[0]].setFicha(new Ficha(coordenadas[0], coordenadas[1], ETipoFicha.GO, EColorJugador.NEGRO));
        }
    }
    
    @Override
    public boolean verificarCoordenadas(String pCoordenadas) {
        if(pCoordenadas.length()==5){
            return validarCoordenadas(getCoordenadasNumericas(pCoordenadas));
        }
        return false;
    }

    @Override
    public int[] getCoordenadasNumericas(String pCoordenadas) {
        
        return FabricaConvertidoresInputCoordenada.fabricarConvertidor(ETipoJuego.GO).convertir(pCoordenadas);
    }

    private void observarAlrededorDeFicha(int[] coordenadas) {
        if(coordenadas[0]>0 && coordenadas[0]<18 && coordenadas[1]>0 && coordenadas[1]<18){
            if(fichaEsUnidad(coordenadas)){
                verificarUnidadRodeada(coordenadas);
            }else{
                verificarFichaRodeada(coordenadas);
            }
        }
    }

    private boolean fichaEsUnidad(int[] coordenadas) {
        EColorJugador colorFicha=getCasillasTablero()[coordenadas[1]][coordenadas[0]].getFicha().getColor();
        return fichaChocaAOtra(coordenadas[0],coordenadas[1]-1,colorFicha)||fichaChocaAOtra(coordenadas[0],coordenadas[1]+1,colorFicha)||
                fichaChocaAOtra(coordenadas[0]-1,coordenadas[1],colorFicha)||fichaChocaAOtra(coordenadas[0]+1,coordenadas[1],colorFicha);
    }

    private boolean fichaChocaAOtra(int pCoordenadasX,int pCoordenadaY,EColorJugador pcolor) {
        return !getCasillasTablero()[pCoordenadaY][pCoordenadasX].casillaVacia() && getFicha(pCoordenadasX,pCoordenadaY).getColor()==pcolor;
    }

    private void verificarFichaRodeada(int[] coordenadas) {
        EColorJugador colorFicha=getCasillasTablero()[coordenadas[1]][coordenadas[0]].getFicha().getColor();
        if(colorFicha==EColorJugador.BLANCO)colorFicha=EColorJugador.NEGRO;
        else colorFicha=EColorJugador.BLANCO;
        
        comerFicha(coordenadas,colorFicha);
    }

    private void comerFicha(int[] coordenadas, EColorJugador colorFicha) {
        if(fichaChocaAOtra(coordenadas[0],coordenadas[1]-1, colorFicha)){
            fichaRodeada(coordenadas[0],coordenadas[1]-1,getFicha(coordenadas[0],coordenadas[1]).getColor());
        }
        if(fichaChocaAOtra(coordenadas[0],coordenadas[1]+1, colorFicha)){
            fichaRodeada(coordenadas[0],coordenadas[1]-1,getFicha(coordenadas[0],coordenadas[1]).getColor());
        }
        if(fichaChocaAOtra(coordenadas[0]-1,coordenadas[1], colorFicha)){
            fichaRodeada(coordenadas[0],coordenadas[1]-1,getFicha(coordenadas[0],coordenadas[1]).getColor());
        }
        if(fichaChocaAOtra(coordenadas[0]+1,coordenadas[1], colorFicha)){
            fichaRodeada(coordenadas[0],coordenadas[1]-1,getFicha(coordenadas[0],coordenadas[1]).getColor());
        }
    }

    private void fichaRodeada(int coordenadaX, int coordenadaY, EColorJugador color) {
       if (fichaChocaAOtra(coordenadaX+1,coordenadaY,color)&&fichaChocaAOtra(coordenadaX,coordenadaY-1,color)&&fichaChocaAOtra(coordenadaX,coordenadaY+1,color)&&
               fichaChocaAOtra(coordenadaX-1,coordenadaY,color))
           getCasillasTablero()[coordenadaY][coordenadaX].setFicha(null);
    }

    private void verificarUnidadRodeada(int[] coordenadas) {
        
    }

}
