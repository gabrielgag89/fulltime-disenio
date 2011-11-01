
package tp2capaenlacededatos;

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
            System.err.println("Error al enviar un paquete al puerto:"+ex.getMessage());
        }
    }
    
    public void recibirTrama(char[] paquete){
        Trama trama = new Trama();
        trama.setByteInicio(paquete[0]);
        trama.setNumSec(paquete[1]);
        trama.setMsj_ack(paquete[2]);
        trama.setDato(paquete[3]);
        trama.setSumVerif(paquete[4]);
        trama.setByteFin(paquete[5]);
        
        CapaEnlace.getInstancia().desdeFisica(trama);
    }
}
