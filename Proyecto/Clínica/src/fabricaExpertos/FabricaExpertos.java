package fabricaExpertos;

import generar_factura_paciente.DecoradorExpertoGenerarFacturaPaciente;
import cobrar_factura_paciente.DecoradorExpertoCobrarFacturaPaciente;

/**
 *
 * @author gabriel
 */
public class FabricaExpertos {
   private static FabricaExpertos instancia;

   public static FabricaExpertos getInstancia(){
      if(instancia == null)
         instancia = new FabricaExpertos();

      return instancia;
   } // fin del método getInstancia

   public Object getExperto(String nombre){
      if(nombre.equals("ExpertoGenerarFacturarPaciente"))
         return new DecoradorExpertoGenerarFacturaPaciente();
      else if(nombre.equals("ExpertoCobrarFacturaPaciente"))
         return new DecoradorExpertoCobrarFacturaPaciente();
      else
         return null;
    } // fin del método getExperto
} // fin de la clase FabricaExpertos