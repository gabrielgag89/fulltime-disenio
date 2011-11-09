package facturarcliente;

import java.util.List;


public class ControladorFacturarCliente {
    
    
    // NO LO HE PUESTO EN LA SECUENCIA
    public List buscarPacientes()            
    {     
        DecoradorExpertoFacturarCliente DEFC = (DecoradorExpertoFacturarCliente) FabricaExpertoFacturarCliente.getInstancia().obtenerExperto("ExpertoFacturarCliente");
        return DEFC.buscarPacientes();   
    }
  
    }

