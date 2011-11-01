
package tp2capaenlacededatos;

import giovynet.nativelink.SerialPort;
import giovynet.serial.ActionListenerReadPort;
import giovynet.serial.Baud;
import giovynet.serial.Buffer;
import giovynet.serial.Buffer.BufferException;
import giovynet.serial.Com;
import giovynet.serial.Com.ActionListenerReadPortException;
import giovynet.serial.Parameters;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Puerto extends Thread implements ActionListenerReadPort{
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
    
    public static Com getPuertoCom(){        
        if(puertoCom == null){
            try {
                Puerto.getPuertoSerie().getFreeSerialPort();
                Puerto.getParametros().setPort(puertoLibre);
                Puerto.getParametros().setBaudRate(baudios);
                puertoCom = new Com(parametros);    
                
            } catch (Exception ex) {
                Logger.getLogger(Puerto.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    public void inicializarPuerto(){
        try {            
            Puerto.getPuertoCom().addActionListenerReadPort(this);
            Thread lecturaP = new Thread(this);
            lecturaP.start();            
        } catch (ActionListenerReadPortException ex) {
            Logger.getLogger(Puerto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
                        
        } catch (InterruptedException e) {
            System.err.println("Error en el método run:"+e.getMessage());
        }
    }

    public void tryActionPerformed(Buffer buffer) {
        try {
            CapaFisica.getinstancia().recibirTrama(buffer.getBufferInCharArray());     
        } catch (BufferException ex) {
            Logger.getLogger(Puerto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void catchActionPerformed(Exception e) {
        System.err.println("Error evento en el puerto:"+e.getMessage());
    }
       
}
