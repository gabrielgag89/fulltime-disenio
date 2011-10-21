
package tp2capaenlacededatos;

import giovynet.nativelink.SerialPort;
import giovynet.serial.Baud;
import giovynet.serial.Parameters;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Puerto {
    
    private static SerialPort puertoSerie;
    private final String puertoLibre = "COM1";
    private static Baud baudios = ;
    private static Parameters parametros;
    
    
    public static SerialPort getPuertoSerie() {        
        if(puertoSerie == null)
            puertoSerie = new SerialPort();
        
        return puertoSerie;
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
    
    public void configurarParametros(){
        
        Puerto.getParametros().setPort(puertoLibre);
        Puerto.getParametros().setBaudRate(Baud._1200);
        
    }        
    
}
