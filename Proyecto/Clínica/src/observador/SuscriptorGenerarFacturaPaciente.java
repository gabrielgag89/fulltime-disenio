package observador;

import java.util.List;
import java.util.ArrayList;
import dtos.DTOFacturaPaciente;

public class SuscriptorGenerarFacturaPaciente {
   private static SuscriptorGenerarFacturaPaciente instancia;
   private List<ObservadorGenerarFacturaPaciente> observadores = new  ArrayList<ObservadorGenerarFacturaPaciente>();
   
   private SuscriptorGenerarFacturaPaciente(){}

   public static SuscriptorGenerarFacturaPaciente getInstancia(){
      if (instancia == null) 
         instancia = new SuscriptorGenerarFacturaPaciente();

      return instancia;
   } // fin del método getInstancia

   public  void suscribirse(ObservadorGenerarFacturaPaciente o) {
      this.observadores.add(o);
   } // fin del método agregarObservador

   public void quitarObservador(ObservadorGenerarFacturaPaciente o) {
      this.observadores.remove(o);
   } // fin del método quitarObservador

   public void notificar(DTOFacturaPaciente dtoFactura){
      for(ObservadorGenerarFacturaPaciente obs : observadores)
         obs.actualizar(dtoFactura);
   } // fin del método notificar
} // fin de la clase SuscriptorGenerarFacturaPaciente