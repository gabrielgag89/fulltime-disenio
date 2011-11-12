package generar_factura_paciente;

import java.util.ArrayList;
import java.util.List;
import persistencia.FachadaPersistencia;
import persistencia.criterios.Criterio;
import persistencia.proxy.*;

public class ExpertoGenerarFacturaPaciente {
    
    private DTOFichaInternacion dtofichainternacion;
    private DTOPaciente dtopaciente;
    List<DTOPaciente> listapacientes;
    
    // NO LO HE PUESTO EN LA SECUENCIA
    public List<DTOPaciente> buscarPacientes()          
    {
        
        try {
   
        FachadaPersistencia FP = FachadaPersistencia.getInstancia();
        List<Paciente> pacientes = FP.getColeccion("Paciente");
        
        listapacientes=new ArrayList<DTOPaciente>();
        
        for (int i=0; i<pacientes.size();i++)
        {          
           dtopaciente= new DTOPaciente();
           dtopaciente.setNumPaciente(pacientes.get(i).getNumPaciente());
           dtopaciente.setNombrePaciente(pacientes.get(i).getNombre().toString());
           listapacientes.add(dtopaciente);
        }   
            
        return listapacientes;
        
        } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
        }
        
    }
    
    public DTOFichaInternacion buscarFichaInternacion(int NumPaciente)
            
    {
       
        try {
            
            
            FachadaPersistencia FP = FachadaPersistencia.getInstancia();
            Criterio C1 = FP.getCriterio("oidpaciente ", "=", Integer.toString(NumPaciente));
            FichaInternacion fichainternacion = (FichaInternacion)  FP.buscar("ficha_internacion", C1).get(0);
            
            dtofichainternacion = new DTOFichaInternacion();
            dtofichainternacion.setNroFicha(fichainternacion.getNroFicha());
            dtofichainternacion.setFechaIngreso(fichainternacion.getFechaCreacion());
            //dtofichainternacion.setFechaEgreso(fichainternacion.getFechaEgreso());
            
            //agregar fecha egreso y ademas no se puede continuar hasta que se cree detalle servicio y detalle prestacion en la ficha
            
            
            
            
            
            
            
                return null;
            }  catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
    
    
    
    
    
    
    }

        public void GenerarFactura(DTOFichaInternacion dtoficha)
        
     {
         
         int numFicha= dtoficha.getNroFicha();
         FachadaPersistencia FP= FachadaPersistencia.getInstancia();
         Criterio C1= FP.getCriterio("numero_ficha_internacion", "=", Integer.toString(numFicha));
         FichaInternacion fichainternacion=(FichaInternacion) FP.buscar("ficha_internacion", C1);
         
                 
                 
         
         
         
         
         
         

     }
}
