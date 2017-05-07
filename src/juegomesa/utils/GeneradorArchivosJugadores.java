/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegomesa.utils;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Properties;
/**
 *
 * @author carlos
 */
public class GeneradorArchivosJugadores {
    public static void generarArchivoJugador(String pUsername,String pEmail, String pPassword){
       Properties property=new Properties();
       FileInputStream input=null;
       try {
            input = new FileInputStream("src\\juegomesa\\properties\\rutas.properties");
            String filename=pUsername+".txt";
            property.load(input);
            String ruta=property.getProperty("ruta_archivos");
            File archivo = new File(ruta+filename);
            BufferedWriter bw = null;
            if(!archivo.exists()) {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("{email: "+pEmail+", password: "+pPassword+"}");
                bw.close();
            }            
        }catch (IOException ex) {
        ex.printStackTrace();
        } finally {
            if (input != null) {
             try {
                input.close();
             } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
    }
}
