package facturarcliente;

import java.util.List;

public class ControladorFacturarCliente {
    // NO LO HE PUESTO EN LA SECUENCIA
    public List<DTOPaciente> buscarPacientes(){     
        DecoradorExpertoFacturarCliente DEFC = (DecoradorExpertoFacturarCliente) FabricaExpertoFacturarCliente.getInstancia().obtenerExperto("ExpertoFacturarCliente");
        return DEFC.buscarPacientes();   
    }
    
    public DTOFichaInternacion buscarFichaInternacion(int numPaciente){     
        DecoradorExpertoFacturarCliente DEFC = (DecoradorExpertoFacturarCliente) FabricaExpertoFacturarCliente.getInstancia().obtenerExperto("ExpertoFacturarCliente");
        return DEFC.buscarFichaInternacion(numPaciente);   
    }

    void GenerarFactura(DTOFichaInternacion dtoficha) {
        DecoradorExpertoFacturarCliente DEFC = (DecoradorExpertoFacturarCliente) FabricaExpertoFacturarCliente.getInstancia().obtenerExperto("ExpertoFacturarCliente");
        DEFC.GenerarFactura(dtoficha);  
    }
    
    
}

