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
public class ConvertidorInputsAjedrez implements IConvertidorInput{

    @Override
    public int[] convertir(String pInput) {
        int coordX = Character.getNumericValue(pInput.charAt(pInput.length()-2))-10;
        int coorY = Character.getNumericValue(pInput.charAt(pInput.length()-1))-1;
        int[] coordenada = {coordX,coorY};
        return coordenada;
    }
    
}
