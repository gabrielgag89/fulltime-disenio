package generar_factura_paciente;

import fabricaExpertos.FabricaExpertos;
import dtos.DTOFichaInternacion;
import dtos.DTOFacturaPaciente;

public class ControladorGenerarFacturaPaciente {
   private ExpertoGenerarFacturaPaciente experto;
   
   public ControladorGenerarFacturaPaciente(){
      IUGenerarFacturaPaciente iuGenerarFactura = new IUGenerarFacturaPaciente(this);
      iuGenerarFactura.setVisible(true);
   } // fin del constructor
   
   public DTOFichaInternacion buscarFichaInternacion(int numFicha){ 
      // se obtiene un ExpertoGenerarFacturaPaciente y se guarda en una variable de instancia
      this.experto = (ExpertoGenerarFacturaPaciente) FabricaExpertos.getInstancia().getExperto("GenerarFacturarPaciente");
      
      // se busca la ficha de internación correspondiente al número ingresado y se devuelve a la GUI
      return this.experto.buscarFichaInternacion(numFicha);   
   } // fin del método buscarFichaInternacion

   public void generarFactura(){
      // se genera la factura y se guarda el DTO recibido para mostrarla luego en la GUI
      DTOFacturaPaciente dtoFactura = this.experto.generarFactura();
      
      // se comprueba que se haya emitido la factura con éxito
      if(dtoFactura != null){
         // se crea una GUI para mostrar la factura emitida
         IUMostrarFactura iuMostrFact = new IUMostrarFactura();
         // se envía el DTO con los datos de la factura a la GUI
         iuMostrFact.cargarCampos(dtoFactura);
         // se hace visible la GUI
         iuMostrFact.setVisible(true);
      } // fin de if de comprobación de emisión de la factura
   } // fin del método generarFactura
} // fin de la clase ControladorGenerarFacturaPaciente