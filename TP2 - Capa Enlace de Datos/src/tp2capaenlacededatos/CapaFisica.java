/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2capaenlacededatos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class CapaFisica {
    private static CapaFisica capaFisica;
    
    public static CapaFisica getinstancia(){
       if(capaFisica == null)
          capaFisica = new CapaFisica();
       
       return capaFisica;
    }
    
    public void enviarTrama(Trama trama){
       String mensaje = trama.tramaToString();
        try {
            Puerto.getPuertoCom().sendArrayChar(mensaje.toCharArray());
        } catch (Exception ex) {
            Logger.getLogger(CapaFisica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void recibirTrama(Trama trama){
        CapaEnlace.getInstancia().desdeFisica(trama);
    }
}
