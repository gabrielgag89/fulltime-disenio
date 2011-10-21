
package tp2capaenlacededatos;

import giovynet.nativelink.SerialPort;
import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Puerto {
    
    /**
     * puerto de serie, pedimos el que esté libre
     */
    private static SerialPort puertoSerie;
    /**
     * nombre del puerto
     */
    private final static String puertoLibre = "COM1";
    /**
     * velocidas de comunicacion en baudios 
     */
    private static Baud baudios = Baud._1200;//a 1200 baudios por ahora
    /**
     * parametros del puerto
     */
    private static Parameters parametros;
    /**
     * El puerto que se retorna para enviar
     */
    private static Com puertoCom;
    
    
    private static SerialPort getPuertoSerie() {        
        if(puertoSerie == null)
            puertoSerie = new SerialPort();
        
        return puertoSerie;
    }
    
    public static Com getPuertoCom() throws Exception {        
        if(puertoCom == null){
            Puerto.getPuertoSerie().getFreeSerialPort();
            Puerto.getParametros().setPort(puertoLibre);
            Puerto.getParametros().setBaudRate(baudios);
            puertoCom = new Com(parametros);
        }
        
        return puertoCom;
    }
    
    
    private static Parameters getParametros() {        
        if(parametros == null)
            try {
            parametros = new Parameters();
        } catch (Exception ex) {
            Logger.getLogger(Puerto.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return parametros;
    }
   
    
}
