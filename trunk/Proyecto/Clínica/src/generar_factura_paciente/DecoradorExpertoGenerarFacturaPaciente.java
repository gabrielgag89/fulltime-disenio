package generar_factura_paciente;

import java.sql.SQLException;
import persistencia.FachadaPersistenciaInterna;
import dtos.DTOFichaInternacion;
import dtos.DTOFacturaPaciente;
import persistencia.Conector;

public class DecoradorExpertoGenerarFacturaPaciente extends ExpertoGenerarFacturaPaciente {
   private Conector conecctor;
   
   @Override
   public DTOFichaInternacion buscarFichaInternacion(int numPaciente){
      try {
         FachadaPersistenciaInterna.getInstancia().iniciarTransaccion();
      } // fin de try de inicio de transacción
      catch (SQLException ex) {
         System.err.println("SQLException en buscarFichaInternacion: " + ex.getMessage());
      } // fin de catch de SQLException
      catch (Exception ex) {
         System.err.println("Exception en buscarFacturasPendientes: " + ex.getMessage());
      } // fin de catch de Exception
      
      DTOFichaInternacion dtoDetalle = super.buscarFichaInternacion(numPaciente);
      
      return dtoDetalle;
   } // fin del método buscarFichaInternacion

   @Override
   public DTOFacturaPaciente generarFactura() {
      DTOFacturaPaciente dtoFactura = super.generarFactura();
      
      try {
         FachadaPersistenciaInterna.getInstancia().finalizarTransaccion(this.conecctor);
      } // fin de try de fin de transacción
      catch (SQLException ex) {
         System.err.println("SQLException en generarFactura: " + ex.getMessage());
      } // fin de catch de SQLException
      
      return dtoFactura;
   } // fin del método generarFactura
} // fin de la clase DecoradorExpertoGenerarFacturaPaciente