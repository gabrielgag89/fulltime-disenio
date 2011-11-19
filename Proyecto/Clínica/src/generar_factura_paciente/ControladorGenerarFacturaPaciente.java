package generar_factura_paciente;

import dtos.DTOFichaInternacion;
import fabricaExpertos.FabricaExpertos;
import java.util.List;

public class ControladorGenerarFacturaPaciente {
   private ExpertoGenerarFacturaPaciente experto;
   
   public DTOFichaInternacion buscarFicha(int numFicha){     
      this.experto = (ExpertoGenerarFacturaPaciente) FabricaExpertos.getInstancia().getExperto("GenerarFacturarPaciente");
      
      return experto.buscarFichaInternacion(numFicha);   
   } // fin del método buscarFichaInternacion

   public void generarFactura(int numFicha) {
      
   } // fin del método GenerarFactura
} // fin de la clase ControladorGenerarFacturaPaciente