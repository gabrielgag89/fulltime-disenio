package cobrar_factura_paciente;

import java.util.List;
import fabricaExpertos.FabricaExpertos;
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
   } // fin del método actualizar
   
   public List<DTOFacturaPaciente> buscarFacturasPacientes(){
      SuscriptorGenerarFacturaPaciente.getInstance().agregarObservadorGenerarFacturaPaciente(this);
      
      experto = (ExpertoCobrarFacturaPaciente) FabricaExpertos.getInstancia().getExperto("ExpertoCobrarFacturaPaciente");
      
      return experto.buscarFacturasPendientes();
   } // fin del método cobrarFacturaPaciente
   
   public DTORecibo cobrarFactura(int numFactura){
      return experto.cobrarFactura(numFactura);
   } // fin del método cobrarFactura
} // fin de la clase ControladorCobrarFacturaPaciente