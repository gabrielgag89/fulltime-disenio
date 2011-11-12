package generar_factura_paciente;

import java.util.List;

public class ControladorGenerarFacturaPaciente {
    // NO LO HE PUESTO EN LA SECUENCIA
    public List<DTOPaciente> buscarPacientes(){     
        DecoradorExpertoGenerarFacturaPaciente DEFC = (DecoradorExpertoGenerarFacturaPaciente) FabricaExpertos.getInstancia().obtenerExperto("ExpertoFacturarCliente");
        return DEFC.buscarPacientes();   
    }
    
    public DTOFichaInternacion buscarFichaInternacion(int numPaciente){     
        DecoradorExpertoGenerarFacturaPaciente DEFC = (DecoradorExpertoGenerarFacturaPaciente) FabricaExpertos.getInstancia().obtenerExperto("ExpertoFacturarCliente");
        return DEFC.buscarFichaInternacion(numPaciente);   
    }

    void GenerarFactura(DTOFichaInternacion dtoficha) {
        DecoradorExpertoGenerarFacturaPaciente DEFC = (DecoradorExpertoGenerarFacturaPaciente) FabricaExpertos.getInstancia().obtenerExperto("ExpertoFacturarCliente");
        DEFC.GenerarFactura(dtoficha);  
    }
    
    
}

