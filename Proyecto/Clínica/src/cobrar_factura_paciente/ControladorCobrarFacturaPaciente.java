package cobrar_factura_paciente;

import dtos.DTORecibo;
import dtos.DTOFacturaPaciente;
import java.util.List;
import fabricaExpertos.FabricaExpertos;
import observador.*;

/**
 *
 * @author gabriel
 */
public class ControladorCobrarFacturaPaciente implements ObservadorGenerarFacturaPaciente{
   private ExpertoCobrarFacturaPaciente experto;
   private IUCobrarFacturaPaciente iuCobrar;
   
   public List<DTOFacturaPaciente> buscarFacturasPacientes(IUCobrarFacturaPaciente iuCobrar){
      this.iuCobrar = iuCobrar;
      
      SuscriptorGenerarFacturaPaciente.getInstancia().agregarObservador(this);
      
      experto = (ExpertoCobrarFacturaPaciente) FabricaExpertos.getInstancia().getExperto("ExpertoCobrarFacturaPaciente");
      
      return experto.buscarFacturasPendientes();
   } // fin del método cobrarFacturaPaciente
   
   public void cobrarFactura(int numFactura){
      DTORecibo dtoRecibo = experto.cobrarFactura(numFactura);
      
      IUMostrarRecibo iuMostrar = new IUMostrarRecibo();
      iuMostrar.cargarControlador(this);
      iuMostrar.cargarCampos(dtoRecibo);
      iuMostrar.setVisible(true);
   } // fin del método cobrarFactura

   public void volver() {
      this.iuCobrar.cargarFacturas();
      this.iuCobrar.setVisible(true);
   } // fin del método volver
   
   @Override
   public void actualizar(DTOFacturaPaciente dtoFactura) {
      this.iuCobrar.actualizar(dtoFactura);
   } // fin del método actualizar
} // fin de la clase ControladorCobrarFacturaPaciente