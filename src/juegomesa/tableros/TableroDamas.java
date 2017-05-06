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
    public TableroDamas(){
        super();
    }
    @Override
    protected void construirCasillasTablero() {
        casillasTablero=new Casilla[10][10];
        rellarTableroConCasillas();
        ubicarFichas();
    }

    @Override
    public boolean actualizarTablero(String pCoordenadas,EColorJugador pColorJugador) {
        int [] coordenadas=getCoordenadasNumericas(pCoordenadas);
        if(verificarCoordenadas(pCoordenadas)&&!estaCasillaVacia(coordenadas[0],coordenadas[1])){

          return realizarJugada(coordenadas,pCoordenadas);

        }else
            return false;
    }
     private boolean realizarJugada(int[] coordenadas,String pCoordenadas) {
       boolean resul=false;

       if(!verificarSalto(coordenadas)){
           if(moverFicha(coordenadas,pCoordenadas)){
               resul=true;
           }
       }
       return resul;
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

    private boolean moverFicha(int[] coordenadas,String pCoordenadas) {
        boolean resul=false;
        if(estaCasillaVacia(coordenadas[2], coordenadas[3])){
            if(getFicha(coordenadas[0], coordenadas[1]).moverFicha(pCoordenadas))
                resul=true;
        }
        return resul;
    }
    
    @Override
    protected boolean verificarCoordenadas(String pCoordenadas) {
       return validarCoordenadas(getCoordenadasNumericas(pCoordenadas));
    }
    @Override
    protected int[] getCoordenadasNumericas(String pCoordenadas){
        ConvertidorInputsDamas convertidorInputsDamas = new ConvertidorInputsDamas();
        return convertidorInputsDamas.convertir(pCoordenadas);
    }
    private void ubicarFichas(){
        ubicarFichasBlancas();
        ubicarFichasNegras();
    }

    private void ubicarFichasBlancas() {
        int ubicacionFichaInicio=0;
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
        for (int i = 9; i > 6; i--) {
            for (int j = ubicacionFichaInicio; j < getCasillasTablero()[i].length; j+=2) {
                getCasillasTablero()[i][j].setFicha(new Ficha(i, j, ETipoFicha.DAMAS_NORMAL, EColorJugador.BLANCO));
            }
            if(ubicacionFichaInicio==1)ubicacionFichaInicio=0;
            else ubicacionFichaInicio=1;
        }
    }



}
