/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.utils.convertidores;

/**
 *
 * @author jmda9
 */
public class ConvertidorInputsDamas implements IConvertidorInput{

    @Override
    /**
     * El metodo para Damas retornará tanto la coordenada incial de la ficha como la final. En las posiciones 0 y 1 del arreglo 
     * iran las coordenadas X y Y iniciales, mientras que en las posiciones 2 y 3 irán las coordenadas X y Y finales
     */
    public int[] convertir(String pInput) {
        String[] coordenadasString = pInput.substring(1, pInput.length()-1).split("-");
        if(coordenadasString.length == 1){
            coordenadasString = pInput.substring(1, pInput.length()-1).split("x");
        }
        int[] coordenadas = {
            coordenadaX(coordenadasString[0]),
            coordenadaY(coordenadasString[0]),
            coordenadaX(coordenadasString[1]),
            coordenadaY(coordenadasString[1])
        };
        return coordenadas;
    }

    private int coordenadaX(String pString) {
        int valor = (Integer.parseInt(pString)) % 10;
        switch(valor){
            case 0: return 8;
            case 1: return 1;
            case 2: return 3;
            case 3: return 5;
            case 4: return 7;
            case 5: return 9;
            case 6: return 0;
            case 7: return 2;
            case 8: return 4;
            case 9: return 6;
            default: return -1;
        }
    }

    private int coordenadaY(String pString) {
        int valor = Integer.parseInt(pString);
        if(valor <= 5) return 9;
        if(valor > 5 && valor <= 10) return 8;
        if(valor > 10 && valor <= 15) return 7;
        if(valor > 15 && valor <= 20) return 6;
        if(valor > 20 && valor <= 25) return 5;
        if(valor > 25 && valor <= 30) return 4;
        if(valor > 30 && valor <= 35) return 3;
        if(valor > 35 && valor <= 40) return 2;
        if(valor > 40 && valor <= 45) return 1;
        if(valor > 45) return 0;
        return -1;
    }
    
}
