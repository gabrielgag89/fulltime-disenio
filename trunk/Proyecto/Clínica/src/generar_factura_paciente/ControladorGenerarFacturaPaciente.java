package generar_factura_paciente;

import fabricaExpertos.FabricaExpertos;
import dtos.DTOFichaInternacion;
import dtos.DTOFacturaPaciente;

public class ControladorGenerarFacturaPaciente {
   private ExpertoGenerarFacturaPaciente experto;
   
   public DTOFichaInternacion buscarFicha(int numFicha){     
      this.experto = (ExpertoGenerarFacturaPaciente) FabricaExpertos.getInstancia().getExperto("GenerarFacturarPaciente");
      
      return this.experto.buscarFichaInternacion(numFicha);   
   } // fin del método buscarFichaInternacion

   public void generarFactura(){
      DTOFacturaPaciente dtoFactura = this.experto.generarFactura();
      
      IUMonstrarFactura iuMostrFact = new IUMonstrarFactura();
      iuMostrFact.cargarCampos(dtoFactura);
      iuMostrFact.setVisible(true);
   } // fin del método generarFactura
} // fin de la clase ControladorGenerarFacturaPaciente