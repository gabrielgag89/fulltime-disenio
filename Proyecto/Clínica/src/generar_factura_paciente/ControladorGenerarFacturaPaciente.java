package generar_factura_paciente;

import dtos.DTOFichaInternacion;
import fabricaExpertos.FabricaExpertos;

public class ControladorGenerarFacturaPaciente {
   private ExpertoGenerarFacturaPaciente experto;
   
   public DTOFichaInternacion buscarFicha(int numFicha){     
      this.experto = (ExpertoGenerarFacturaPaciente) FabricaExpertos.getInstancia().getExperto("GenerarFacturarPaciente");
      
      return this.experto.buscarFichaInternacion(numFicha);   
   } // fin del método buscarFichaInternacion

   public void generarFactura(){
      this.experto.generarFactura();
   } // fin del método GenerarFactura
} // fin de la clase ControladorGenerarFacturaPaciente