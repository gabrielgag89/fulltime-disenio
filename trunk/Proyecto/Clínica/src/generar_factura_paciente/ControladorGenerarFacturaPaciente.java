package generar_factura_paciente;

import fabricaExpertos.FabricaExpertos;
import dtos.DTOFichaInternacion;
import dtos.DTOFacturaPaciente;

public class ControladorGenerarFacturaPaciente {
   private ExpertoGenerarFacturaPaciente experto;
   
   public DTOFichaInternacion buscarFicha(int numFicha){ 
      // se obtiene un ExpertoGenerarFacturaPaciente y se guarda en una variable de instancia
      this.experto = (ExpertoGenerarFacturaPaciente) FabricaExpertos.getInstancia().getExperto("GenerarFacturarPaciente");
      
      // se busca la ficha de internación correspondiente al número ingresado y se devuelve a la GUI
      return this.experto.buscarFichaInternacion(numFicha);   
   } // fin del método buscarFichaInternacion

   public void generarFactura(){
      // se genera la factura y se guarda el DTO recibido para mostrarla luego en la GUI
      DTOFacturaPaciente dtoFactura = this.experto.generarFactura();
      
      // se crea una GUI para mostrar la factura emitida
      IUMonstrarFactura iuMostrFact = new IUMonstrarFactura();
      // se envía el DTO con los datos de la factura a la GUI
      iuMostrFact.cargarCampos(dtoFactura);
      // se hace visible la GUI
      iuMostrFact.setVisible(true);
   } // fin del método generarFactura
} // fin de la clase ControladorGenerarFacturaPaciente