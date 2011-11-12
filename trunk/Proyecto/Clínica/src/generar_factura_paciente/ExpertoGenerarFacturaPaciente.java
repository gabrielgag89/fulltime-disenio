package generar_factura_paciente;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.FachadaPersistencia;
import persistencia.criterios.Criterio;
import persistencia.proxy.*;

public class ExpertoGenerarFacturaPaciente {
    
    private DTOFichaInternacion dtofichainternacion;
    List c;
    double totalfactura;
    
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
         FichaInternacionImpl fichainternacion=(FichaInternacionImpl) FP.buscar("FichaInternacion", C1);
         FacturaCliente factura = (FacturaCliente) FP.nuevaEntidad("FacturaCliente");
         
        //calculo total factura
         
         Prestacion prestacion= fichainternacion.getPrestacion();
         
         Date fecha=new Date();
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
         String fechaActual = formato.format(fecha);
         
         Criterio C2= FP.getCriterio("fechaInicio", "<", fechaActual.toString());
         c.add(C2);
         Criterio C3= FP.getCriterio("fechaFin", ">", fechaActual.toString());
         c.add(C3);  
         Criterio C4= FP.getCriterio("CodigoPrestacion", "=", Integer.toString(prestacion.getCodigoPrestacion()));
         c.add(C4);  
         
         Criterio CC= FP.and(c);
         List L = FP.buscar("CostoPrestacion", CC);
         CostoPrestacion costoprestacion=(CostoPrestacion) L.get(0);
         
         totalfactura+=costoprestacion.getMonto();
         
         
         List<DetalleFicha> detalleficha= fichainternacion.getDetalleFicha();
         
         for (int i=0; i<detalleficha.size();i++)
             
         {
             
             ServicioEspecial servicioespecial= detalleficha.get(i).getServicioEspecial();

             Criterio C5= FP.getCriterio("fechaInicio", "<", fechaActual.toString());
             c.add(C5);
             Criterio C6= FP.getCriterio("fechaFin", ">", fechaActual.toString());
             c.add(C6);  
             Criterio C7= FP.getCriterio("CodigoServicio", "=", Integer.toString(servicioespecial.getCodigoServicio()));
             c.add(C7);  
             
             Criterio CC1= FP.and(c);
             List lista = FP.buscar("CostoServicio", CC1);
             CostoServicio costoservicio=(CostoServicio) lista.get(0);

             totalfactura+=costoservicio.getMonto();
             
         }
         
         totalfactura-= dtofichainternacion.getDescuento();
         
         
                 
                 
         
         
         
         
         
         

     }
}
