package generar_factura_paciente;

import dtos.DTOFichaInternacion;
import fabricaExpertos.FabricaExpertos;
import java.util.List;

public class ControladorGenerarFacturaPaciente {
    // NO LO HE PUESTO EN LA SECUENCIA
    
    
    public DTOFichaInternacion buscarFichaInternacion(int numFicha){     
        DecoradorExpertoGenerarFacturaPaciente DEFC = (DecoradorExpertoGenerarFacturaPaciente) FabricaExpertos.getInstancia().getExperto("ExpertoFacturarCliente");
        return DEFC.buscarFichaInternacion(numFicha);   
    }

    void GenerarFactura(DTOFichaInternacion dtoficha) {
        DecoradorExpertoGenerarFacturaPaciente DEFC = (DecoradorExpertoGenerarFacturaPaciente) FabricaExpertos.getInstancia().getExperto("ExpertoFacturarCliente");
        DEFC.GenerarFactura(dtoficha);  
    }
    
    
}

