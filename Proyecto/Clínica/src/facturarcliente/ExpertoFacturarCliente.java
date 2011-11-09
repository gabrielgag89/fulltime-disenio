package facturarcliente;

import java.util.List;
import persistencia.FachadaPersistencia;
import persistencia.criterios.Criterio;
import persistencia.proxy.*;

public class ExpertoFacturarCliente {
    
    private DTOFichaInternacion dtofichainternacion;
    
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
            Criterio C1 = FP.getCriterio("oidpaciente ", "=", Integer.toString(NumPaciente));
            FichaInternacion fichainternacion = (FichaInternacion)  FP.buscar("ficha_internacion", C1).get(0);
            
            dtofichainternacion = new DTOFichaInternacion();
            dtofichainternacion.setNroFicha(fichainternacion.getNroFicha());
            dtofichainternacion.setFechaIngreso(fichainternacion.getFechaCreacion());
            //dtofichainternacion.setFechaEgreso(fichainternacion.getFechaEgreso());
            
            
            
            
            
            
            
                return null;
            }  catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
    
    
    
    
    
    
    }

        public void facturar(Object objeto){

     }
}
