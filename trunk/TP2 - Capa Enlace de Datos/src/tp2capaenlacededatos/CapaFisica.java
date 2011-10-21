/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2capaenlacededatos;

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
       
    }
    
    public void recibirTrama(Trama trama){
       
    }
}
