
package tp2capaenlacededatos;

import giovynet.nativelink.SerialPort;
import giovynet.serial.Parameters;


public class Puerto extends SerialPort {
    
    private static SerialPort puertoSerie;
    private static Parameters parametros;
    
    
    public static Puerto getPuertoSerie() {
        if(puertoSerie == null)
            puertoSerie = new SerialPort();
        
        return (Puerto) puertoSerie;
    }
    
    
    
        
    
}
