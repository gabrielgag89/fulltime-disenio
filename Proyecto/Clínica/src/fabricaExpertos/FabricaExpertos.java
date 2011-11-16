package fabricaExpertos;

import generar_factura_paciente.DecoradorExpertoGenerarFacturaPaciente;
import cobrar_factura_paciente.DecoradorExpertoCobrarFacturaPaciente;

/**
 *
 * @author gabriel
 */
public class FabricaExpertos {
   private static FabricaExpertos instancia;

   public static FabricaExpertos getinstancia(){
      if(instancia == null)
         instancia = new FabricaExpertos();

      return instancia;
   }

   public Object getExperto(String nombre){
      if(nombre.equals("ExpertoGenerarFacturarPaciente"))
         return new DecoradorExpertoGenerarFacturaPaciente();
      else
         return new DecoradorExpertoCobrarFacturaPaciente();
    }
}