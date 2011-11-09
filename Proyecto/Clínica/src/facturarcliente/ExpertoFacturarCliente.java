package facturarcliente;

import java.util.List;
import java.util.Vector;
import persistencia.FachadaPersistencia;

public class ExpertoFacturarCliente {

    
    public ExpertoFacturarCliente(){}
    
    // NO LO HE PUESTO EN LA SECUENCIA
    public List buscarPacientes()          
    {
        FachadaPersistencia FP = FachadaPersistencia.getInstancia();
        List pacientes = FP.getColeccion("Paciente");
        return pacientes;
        
    }
    
}
