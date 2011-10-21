
package tp2capaenlacededatos;

import giovynet.nativelink.SerialPort;
import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Puerto {
    
    private static SerialPort puertoSerie;
    private final static String puertoLibre = "COM1";
    private static Baud baudios = Baud._1200;//a 1200 baudios por ahora
    private static Parameters parametros;
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
