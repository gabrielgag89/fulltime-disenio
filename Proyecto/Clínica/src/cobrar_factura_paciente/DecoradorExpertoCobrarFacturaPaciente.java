/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cobrar_factura_paciente;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
      
      return this.buscarFacturasPendientes();
   }
}