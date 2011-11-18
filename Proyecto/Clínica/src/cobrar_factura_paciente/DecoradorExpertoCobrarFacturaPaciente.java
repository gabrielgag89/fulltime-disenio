/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cobrar_factura_paciente;

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
      }
      catch (SQLException ex) {
         System.err.println("SQLException en buscarFacturasPendientes: " + ex.getMessage());
      }
      catch (Exception ex) {
         System.err.println("Exception en buscarFacturasPendientes: " + ex.getMessage());
      }
      
      return super.buscarFacturasPendientes();
   } // fin del método buscarFacturasPendientes
   
   @Override
   public DTORecibo cobrarFactura(int numFactura){
      DTORecibo dtoRecibo = super.cobrarFactura(numFactura);
      try {
         FachadaPersistenciaInterna.getInstancia().finalizarTransaccion();
      } catch (SQLException ex) {
         System.err.println("SQLException en cobrarFactura: " + ex.getMessage());
      }
      
      return dtoRecibo;
   } // fin del método cobrarFactura
} // fin de la clase DecoradorExpertoCobrarFacturaPaciente