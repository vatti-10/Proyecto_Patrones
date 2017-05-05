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
public class ConvertidorInputsGo implements IConvertidorInput{

    @Override
    public int[] convertir(String pInput) {
        String valor = pInput.substring(2, pInput.length()-1);
        int coordX = Character.getNumericValue(valor.charAt(0))-10;
        int coorY = (Character.getNumericValue(valor.charAt(1))-29)*-1;
        int[] coordenada = {coordX,coorY};
        return coordenada;
    }
    
}
