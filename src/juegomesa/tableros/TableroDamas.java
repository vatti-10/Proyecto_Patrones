/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.tableros;

import juegomesa.emuns.EColorJugador;
import juegomesa.emuns.ETipoFicha;
import juegomesa.fichas.Ficha;
import juegomesa.utils.convertidores.ConvertidorInputsDamas;

/**
 *
 * @author carlo
 */
public class TableroDamas extends Tablero{

    @Override
    public void construirCasillasTablero() {
        casillasTablero=new Casilla[10][10];
        rellarTableroConCasillas();
        ubicarFichas();
    }

    @Override
    public void actualizarTablero(String pCoordenadas) {
        int [] coordenadas=getCoordenadasNumericas(pCoordenadas);
        if(!estaCasillaVacia(coordenadas[0],coordenadas[1])){
            realizarJugada(coordenadas,pCoordenadas);
        }
    }
     private void realizarJugada(int[] coordenadas,String pCoordenadas) {
       if(!verificarSalto(coordenadas)){
           moverFicha(coordenadas,pCoordenadas);
       }
    }
     private boolean verificarSalto(int[] coordenadas) {
        if(getFicha(coordenadas[0], coordenadas[1]).getColor()==EColorJugador.NEGRO){
            return verificarSaltoFichaNegra(coordenadas);
        }else{
            return verificarSaltoFichaBlanca(coordenadas);
        }
    }
     
    private boolean verificarSaltoFichaNegra(int[] coordenadas) {
        boolean haySalto=false,resul=false;
        do{
            if(coordenadas[0]<8 &&coordenadas[0]>1 && coordenadas[1]>1){
                if(!estaCasillaVacia(coordenadas[0]+1, coordenadas[1]-1) && estaCasillaVacia(coordenadas[0]+2, coordenadas[1]-2)){
                    comerFicha(getFicha(coordenadas[0], coordenadas[1]),getFicha(coordenadas[0]+1, coordenadas[1]-1),coordenadas[1]-2, coordenadas[0]+2);
                    coordenadas[0]=coordenadas[0]+2;
                    coordenadas[1]=coordenadas[1]-2;
                    haySalto=true;
                    resul=true;
                }else if(!estaCasillaVacia(coordenadas[0]-1, coordenadas[1]-1) && estaCasillaVacia(coordenadas[0]-2, coordenadas[1]-2)){
                    comerFicha(getFicha(coordenadas[0], coordenadas[1]),getFicha(coordenadas[0]-1, coordenadas[1]-1),coordenadas[0]-2, coordenadas[1]-2);
                    coordenadas[0]=coordenadas[0]-2;
                    coordenadas[1]=coordenadas[1]-2;
                    haySalto=true;
                    resul=true;
                }else{
                    haySalto=false;
                }
            }else break;
        }while(haySalto);
        return resul;
    }
    private boolean verificarSaltoFichaBlanca(int[] coordenadas) {
        boolean haySalto=false,resul=false;
        do{
            if(coordenadas[0]<8 &&coordenadas[0]>1 && coordenadas[1]>1){
                if(!estaCasillaVacia(coordenadas[0]+1, coordenadas[1]+1) && estaCasillaVacia(coordenadas[0]+2, coordenadas[1]+2)){
                    comerFicha(getFicha(coordenadas[0], coordenadas[1]),getFicha(coordenadas[0]+1, coordenadas[1]+1),coordenadas[1]+2, coordenadas[0]+2);
                    coordenadas[0]=coordenadas[0]+2;
                    coordenadas[1]=coordenadas[1]+2;
                    haySalto=true;
                    resul=true;
                }else if(!estaCasillaVacia(coordenadas[0]-1, coordenadas[1]+1) && estaCasillaVacia(coordenadas[0]-2, coordenadas[1]+2)){
                    comerFicha(getFicha(coordenadas[0], coordenadas[1]),getFicha(coordenadas[0]-1, coordenadas[1]+1),coordenadas[0]-2, coordenadas[1]+2);
                    coordenadas[0]=coordenadas[0]-2;
                    coordenadas[1]=coordenadas[1]+2;
                    haySalto=true;
                    resul=true;
                }else{
                    haySalto=false;
                }
            }else break;
        }while(haySalto);
        return resul;
    }
    
    private void comerFicha(Ficha pFichaAMover,Ficha pFichaAComer, int coordenadaYNueva, int coordenadaXNueva) {
        getCasillasTablero()[coordenadaYNueva][coordenadaXNueva].setFicha(getFicha(pFichaAMover.getCoordenadaX(), pFichaAMover.getCoordenadaY()));
        getCasillasTablero()[pFichaAMover.getCoordenadaY()][pFichaAMover.getCoordenadaX()].setFicha(null);
        getCasillasTablero()[pFichaAComer.getCoordenadaY()][pFichaAComer.getCoordenadaX()].setFicha(null);
        getCasillasTablero()[coordenadaYNueva][coordenadaXNueva].getFicha().setCoordenadaY(coordenadaYNueva);
        getCasillasTablero()[coordenadaYNueva][coordenadaXNueva].getFicha().setCoordenadaX(coordenadaXNueva);
    }
    
    private void moverFicha(int[] coordenadas,String pCoordenadas) {
        if(estaCasillaVacia(coordenadas[2], coordenadas[3])){
            getFicha(coordenadas[0], coordenadas[1]).moverFicha(pCoordenadas);
        }
    }
    
    @Override
    public boolean verificarCoordenadas(String pCoordenadas) {
       return validarCoordenadas(getCoordenadasNumericas(pCoordenadas));
    }
    @Override
    public int[] getCoordenadasNumericas(String pCoordenadas){
        ConvertidorInputsDamas convertidorInputsDamas = new ConvertidorInputsDamas();
        return convertidorInputsDamas.convertir(pCoordenadas);
    }
    private void ubicarFichas(){
        ubicarFichasBlancas();
        ubicarFichasNegras();
    }

    private void ubicarFichasBlancas() {
        int ubicacionFichaInicio=1;
        for (int i = 0; i < 4; i++) {
            for (int j = ubicacionFichaInicio; j < getCasillasTablero()[i].length; j+=2) {
                getCasillasTablero()[i][j].setFicha(new Ficha(i, j, ETipoFicha.DAMAS_NORMAL, EColorJugador.BLANCO));
            }
            if(ubicacionFichaInicio==1)ubicacionFichaInicio=0;
            else ubicacionFichaInicio=1;
        }
    }

    private void ubicarFichasNegras() {
        int ubicacionFichaInicio=1;
        for (int i = 9; i < 5; i--) {
            for (int j = ubicacionFichaInicio; j < getCasillasTablero()[i].length; j+=2) {
                getCasillasTablero()[i][j].setFicha(new Ficha(i, j, ETipoFicha.DAMAS_NORMAL, EColorJugador.BLANCO));
            }
            if(ubicacionFichaInicio==1)ubicacionFichaInicio=0;
            else ubicacionFichaInicio=1;
        }
    }



}
