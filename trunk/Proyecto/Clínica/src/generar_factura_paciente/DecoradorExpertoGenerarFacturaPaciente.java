package generar_factura_paciente;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.FachadaPersistenciaInterna;
import dtos.DTOFichaInternacion;
import dtos.DTOFacturaPaciente;

public class DecoradorExpertoGenerarFacturaPaciente extends ExpertoGenerarFacturaPaciente {
   @Override
   public DTOFichaInternacion buscarFichaInternacion(int numPaciente){
      try {
         FachadaPersistenciaInterna.getInstancia().iniciarTransaccion();
      }
      catch (SQLException ex) {
         
      }
      catch (Exception ex) {
         
      }
      
      return null;
   } // fin del método buscarFichaInternacion

   @Override
   public DTOFacturaPaciente generarFactura() {
      
      
      return null;
   } // fin del método generarFactura
} // fin de la clase DecoradorExpertoGenerarFacturaPaciente