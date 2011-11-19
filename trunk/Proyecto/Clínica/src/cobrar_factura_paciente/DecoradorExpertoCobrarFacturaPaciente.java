package cobrar_factura_paciente;

import dtos.DTORecibo;
import dtos.DTOFacturaPaciente;
import java.util.List;
import java.sql.SQLException;
import persistencia.FachadaPersistenciaInterna;

/**
 *
 * @author gabriel
 */
public class DecoradorExpertoCobrarFacturaPaciente extends ExpertoCobrarFacturaPaciente{
   @Override
   public List<DTOFacturaPaciente> buscarFacturasPendientes() {
      try {
         FachadaPersistenciaInterna.getInstancia().iniciarTransaccion();
      } // fin de try de inicio de transacción
      catch (SQLException ex) {
         System.err.println("SQLException en buscarFacturasPendientes: " + ex.getMessage());
      } // fin de catch de SQLException
      catch (Exception ex) {
         System.err.println("Exception en buscarFacturasPendientes: " + ex.getMessage());
      } // fin de catch de Exception
      
      return super.buscarFacturasPendientes();
   } // fin del método buscarFacturasPendientes
   
   @Override
   public DTORecibo cobrarFactura(int numFactura){
      DTORecibo dtoRecibo = super.cobrarFactura(numFactura);
      
      try {
         FachadaPersistenciaInterna.getInstancia().finalizarTransaccion();
      } // fin de try de fin de transacción
      catch (SQLException ex) {
         System.err.println("SQLException en cobrarFactura: " + ex.getMessage());
      } // fin de catch de SQLException
      
      return dtoRecibo;
   } // fin del método cobrarFactura
} // fin de la clase DecoradorExpertoCobrarFacturaPaciente