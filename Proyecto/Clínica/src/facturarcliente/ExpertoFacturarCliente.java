package facturarcliente;

import java.util.List;
import persistencia.FachadaPersistencia;
import persistencia.criterios.Criterio;
import persistencia.proxy.Paciente;

public class ExpertoFacturarCliente {
    
    // NO LO HE PUESTO EN LA SECUENCIA
    public List buscarPacientes()          
    {
        FachadaPersistencia FP = FachadaPersistencia.getInstancia();
        List pacientes = FP.getColeccion("Paciente");
        return pacientes;
        
    }
    
    public List<DTOFichaInternacion> buscarFichaInternacion(int NumPaciente)
            
    {
       
        try {
            
            
            FachadaPersistencia FP = FachadaPersistencia.getInstancia();
            Criterio C1 = FP.getCriterio("numero_paciente ", "=", Integer.toString(NumPaciente));
            Paciente paciente = (Paciente) FP.buscar("paciente", C1).get(0);
            
            
            
            
            
            
                return null;
            }  catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
    
    
    
    
    
    
    }

        public void facturar(Object objeto){

     }
}
