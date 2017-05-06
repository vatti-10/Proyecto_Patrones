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
    public TableroGo(){
        super();
    }
    
    @Override
    public void construirCasillasTablero() {
        casillasTablero=new Casilla[19][19];
        rellarTableroConCasillas();
    }

    @Override
    public boolean actualizarTablero(String pCoordenadas,EColorJugador pColorJugador) {
        boolean resul=false;
        int [] coordenadas=getCoordenadasNumericas(pCoordenadas);
        if(estaCasillaVacia(coordenadas[0],coordenadas[1])){
            ubicarFicha(coordenadas,pCoordenadas.charAt(0));
            observarAlrededorDeFicha(coordenadas);
            resul=true;
        }
        return resul;
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
    public boolean validarCoordenadas(int[] pCoordenadas){
        return pCoordenadas[0]<getCasillasTablero()[0].length
                && pCoordenadas[1]<getCasillasTablero().length;
    }
    @Override
    public int[] getCoordenadasNumericas(String pCoordenadas) {
        
        return FabricaConvertidoresInputCoordenada.fabricarConvertidor(ETipoJuego.GO).convertir(pCoordenadas);
    }

    private void observarAlrededorDeFicha(int[] coordenadas) {
        EColorJugador colorFicha=getCasillasTablero()[coordenadas[1]][coordenadas[0]].getFicha().getColor();
        EColorJugador colorFichaEnemiga;
        if(colorFicha==EColorJugador.BLANCO)colorFichaEnemiga=EColorJugador.NEGRO;
        else colorFichaEnemiga=EColorJugador.BLANCO;
        
        if(coordenadas[0]>0 && coordenadas[0]<18 && coordenadas[1]>0 && coordenadas[1]<18){
            if(fichaTocaAFichaEnemiga(coordenadas,colorFichaEnemiga)){
                int[] coordenadasFichaEnemiga=getCoordenadasFichaEnemiga(coordenadas,colorFichaEnemiga);
                verificarFichaEnemigaRodeada(coordenadasFichaEnemiga,colorFicha);
            }
        }
    }
    private boolean fichaTocaAFichaEnemiga(int [] coordenadas,EColorJugador pColorFicha){
        return fichaChocaAOtra(coordenadas[0],coordenadas[1]-1,pColorFicha)||fichaChocaAOtra(coordenadas[0],coordenadas[1]+1,pColorFicha)||
                fichaChocaAOtra(coordenadas[0]-1,coordenadas[1],pColorFicha)||fichaChocaAOtra(coordenadas[0]+1,coordenadas[1],pColorFicha);
    }
    private int [] getCoordenadasFichaEnemiga(int [] pCoordenadas,EColorJugador pColorFicha){
        int[] coordenadas=new int[2];
        if(fichaChocaAOtra(pCoordenadas[0],pCoordenadas[1]-1, pColorFicha)){
            coordenadas[0]=pCoordenadas[0];
            coordenadas[1]=pCoordenadas[1]-1;
        }
        if(fichaChocaAOtra(pCoordenadas[0],pCoordenadas[1]+1, pColorFicha)){
            coordenadas[0]=pCoordenadas[0];
            coordenadas[1]=pCoordenadas[1]+1;
        }
        if(fichaChocaAOtra(pCoordenadas[0]-1,pCoordenadas[1], pColorFicha)){
            coordenadas[0]=pCoordenadas[0]-1;
            coordenadas[1]=pCoordenadas[1];
        }
        if(fichaChocaAOtra(pCoordenadas[0]+1,pCoordenadas[1], pColorFicha)){
            coordenadas[0]=pCoordenadas[0]+1;
            coordenadas[1]=pCoordenadas[1];
        }
        return coordenadas;
    }

    private boolean fichaChocaAOtra(int pCoordenadasX,int pCoordenadaY,EColorJugador pcolor) {
        return !getCasillasTablero()[pCoordenadaY][pCoordenadasX].casillaVacia() && getFicha(pCoordenadasX,pCoordenadaY).getColor()==pcolor;
    }


    private boolean fichaRodeada(int coordenadaX, int coordenadaY, EColorJugador color) {
       return fichaChocaAOtra(coordenadaX+1,coordenadaY,color)&&fichaChocaAOtra(coordenadaX,coordenadaY-1,color)&&fichaChocaAOtra(coordenadaX,coordenadaY+1,color)&&
               fichaChocaAOtra(coordenadaX-1,coordenadaY,color);
    }
    
    private void verificarFichaEnemigaRodeada(int[] coordenadas, EColorJugador pColorFicha) {
        if(fichaRodeada(coordenadas[0],coordenadas[1],pColorFicha)){
            getCasillasTablero()[coordenadas[1]][coordenadas[0]].setFicha(null);
        }
    }

}
