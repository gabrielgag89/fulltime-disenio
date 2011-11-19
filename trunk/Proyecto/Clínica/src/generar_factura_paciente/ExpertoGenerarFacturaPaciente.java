package generar_factura_paciente;

import dtos.DTOFichaInternacion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import persistencia.FachadaPersistencia;
import persistencia.criterios.Criterio;
import persistencia.proxy.*;

public class ExpertoGenerarFacturaPaciente {
    
    private DTOFichaInternacion dtofichainternacion;
    List c;
    double totalfactura;
    

    public DTOFichaInternacion buscarFichaInternacion(int numFicha)
            
    {
       
        try {
            
            
            FachadaPersistencia FP = FachadaPersistencia.getInstancia();
            Criterio C1 = FP.getCriterio("numero_ficha_internacion", "=", Integer.toString(numFicha));
            FichaInternacion fichainternacion = (FichaInternacion)  FP.buscar("ficha_internacion", C1).get(0);
            String estado= fichainternacion.getEstadoFichaInternacion().getNombreEstado().toString();
            
            if (estado.equals("Creada"))
                
            {
                
                dtofichainternacion= new DTOFichaInternacion();
                dtofichainternacion.setNroFicha(fichainternacion.getNroFicha());
                dtofichainternacion.setFecha(fichainternacion.getFechaCreacion());
                
                Date fecha=new Date();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fechaActual = formato.format(fecha);
         
                 Criterio C2= FP.getCriterio("fecha_inicio", "<", fechaActual.toString());
                 c.add(C2);
                 Criterio C3= FP.getCriterio("fecha_fin", ">", fechaActual.toString());
                 c.add(C3);  
                 Criterio C4= FP.getCriterio("codigo_prestacion", "=", Integer.toString(fichainternacion.getPrestacion().getCodigoPrestacion()));
                 c.add(C4);  

                 Criterio CC= FP.and(c);
                 List L = FP.buscar("costo_prestacion", CC);
                 CostoPrestacion costoprestacion=(CostoPrestacion) L.get(0);
                 c.clear();

                dtofichainternacion.setCostoPrestacion(costoprestacion.getMonto());
                
                Paciente paciente=fichainternacion.getPaciente();
                
                dtofichainternacion.setNombrePaciente(paciente.getNombre().toString());
                
                if (paciente.getPlan() != null)
                {
                    
                 Criterio C5= FP.getCriterio("fecha_inicio", "<", fechaActual.toString());
                 c.add(C2);
                 Criterio C6= FP.getCriterio("fecha_fin", ">", fechaActual.toString());
                 c.add(C3);  
                 Criterio C7= FP.getCriterio("codigo_plan", "=", Integer.toString(paciente.getPlan().getCodigoPlan()));
                 c.add(C4);  

                 Criterio CC1= FP.and(c);
                 List L1 = FP.buscar("convenio", CC1);
                 Convenio convenio=(Convenio) L.get(0);
                    
                    
                    
                    
                }
                
                
                
                
                
                
                
                
                
                
                
            }
            
            
            
            
            
                  return null;
            }  catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
    
    }
    
    
    

        public void GenerarFactura(DTOFichaInternacion dtoficha)
        
     {
         try
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
         
         Criterio C8= FP.getCriterio("nombreEstado", "=", "Creada");
         List listaEstadoFactura = FP.buscar("EstadoFacturaCliente", C8);
         
         
         EstadoFacturaCliente estadofactura= (EstadoFacturaCliente) listaEstadoFactura.get(0);
         
         
         factura.setFichaInternacion(fichainternacion);
         factura.setEstadoFacturaCliente(estadofactura);
         factura.setFechaEmision(fecha);
         factura.setNumFactura(0);
         
         FP.guardar("facturaCliente", factura);      
         JOptionPane.showMessageDialog(null,"La factura se ha guardado correctamente","Generar Factura",JOptionPane.INFORMATION_MESSAGE);
                        
         
         }  catch (Exception ex) {
             
             JOptionPane.showMessageDialog(null,"Problema al generar la factura","Generar Factura",JOptionPane.ERROR_MESSAGE);
             System.out.println(ex.getMessage());
               
        }

     }
}
