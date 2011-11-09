package facturarcliente;

import java.util.List;
import persistencia.FachadaPersistencia;

public class ExpertoFacturarCliente {
    
    // NO LO HE PUESTO EN LA SECUENCIA
    public List buscarPacientes()          
    {
        FachadaPersistencia FP = FachadaPersistencia.getInstancia();
        List pacientes = FP.getColeccion("Paciente");
        return pacientes;
        
    }

        public void facturar(Object objeto){

     }
}
