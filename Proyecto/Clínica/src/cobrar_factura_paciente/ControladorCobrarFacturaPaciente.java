package cobrar_factura_paciente;

import fabricaExpertos.FabricaExpertos;
import java.util.List;
import observador.*;

/**
 *
 * @author gabriel
 */
public class ControladorCobrarFacturaPaciente implements ObservadorGenerarFacturaPaciente{
   private ExpertoCobrarFacturaPaciente experto;
   
   @Override
   public void actualizar(SuscriptorGenerarFacturaPaciente o, Object arg) {
      throw new UnsupportedOperationException("Not supported yet.");
   }
   
   public List<DTOFacturaPaciente> cobrarFacturaPaciente(){
      SuscriptorGenerarFacturaPaciente.getInstance().agregarObservadorGenerarFacturaPaciente(this);
      
      experto = (ExpertoCobrarFacturaPaciente) FabricaExpertos.getinstancia().getExperto("ExpertoCobrarFacturaPaciente");
      
      return null;
   }
}