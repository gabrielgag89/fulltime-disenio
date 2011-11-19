package generar_factura_paciente;

import persistencia.proxy.FichaInternacion;
import dtos.DTOFichaInternacion;
import dtos.DTOFacturaPaciente;
import java.util.Date;
import java.util.List;
import persistencia.FachadaPersistencia;
import persistencia.FachadaPersistenciaInterna;
import persistencia.criterios.Criterio;
import persistencia.proxy.Convenio;
import persistencia.proxy.CostoPrestacion;
import util.ServiciosTiempo;

public class ExpertoGenerarFacturaPaciente {
   private FichaInternacion fichaInternacion;

   public DTOFichaInternacion buscarFichaInternacion(int numFicha){
      Criterio criterio = FachadaPersistencia.getInstancia().getCriterio("numero_ficha_internacion", "=", numFicha + "");
      this.fichaInternacion = (FichaInternacion) FachadaPersistencia.getInstancia().buscar("FichaInternacion", criterio).get(0);
      
      if(this.fichaInternacion.getEstadoFichaInternacion().getNombreEstado().equals("Creada")){
         DTOFichaInternacion dtoFicha = new DTOFichaInternacion();
         
         dtoFicha.setNroFicha(this.fichaInternacion.getNroFicha());
         dtoFicha.setNumPaciente(this.fichaInternacion.getPaciente().getNumPaciente());
         dtoFicha.setNombrePaciente(this.fichaInternacion.getPaciente().getNombre());
         dtoFicha.setNombrePrestacion(this.fichaInternacion.getPrestacion().getDescripcion());
         
         Criterio c1 = FachadaPersistenciaInterna.getInstancia().getCriterio("fecha_inicio", "<=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()));
         Criterio c2 = FachadaPersistenciaInterna.getInstancia().getCriterio("fecha_fin", ">=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()));
         Criterio cc = FachadaPersistenciaInterna.getInstancia().and(c1, c2);
         
         List<CostoPrestacion> listaCostos = FachadaPersistencia.getInstancia().buscar("CostoPrestacion", cc);
         
         for(CostoPrestacion costo : listaCostos){
            if(this.fichaInternacion.getPrestacion().getCodigoPrestacion() == costo.getPrestacion().getCodigoPrestacion()){
               dtoFicha.setCostoPrestacion(costo.getMonto());
               break;
            } // fin de if de búsqueda del costo de la prestación
         } // fin de for de búsqueda del costo de la prestación
         
         if(this.fichaInternacion.getPaciente().getPlan() != null){
            c1 = FachadaPersistenciaInterna.getInstancia().getCriterio("fecha_inicio", "<=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()));
            c2 = FachadaPersistenciaInterna.getInstancia().getCriterio("fecha_fin", ">=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()));
            cc = FachadaPersistenciaInterna.getInstancia().and(c1, c2);

            List<Convenio> listaConvenios = FachadaPersistencia.getInstancia().buscar("Convenio", cc);
            
            dtoFicha.setDescuento(0.0);
            
            for(Convenio conv : listaConvenios){
               if(this.fichaInternacion.getPrestacion().getCodigoPrestacion() == conv.getPrestacion().getCodigoPrestacion() &&
                       this.fichaInternacion.getPaciente().getPlan().getCodigoPlan() == conv.getPlan().getCodigoPlan()){
                  dtoFicha.setDescuento(conv.getCoseguro().getPorcentaje());
                  break;
               } // fin de if de búsqueda del convenio
            } // fin de for de búsqueda del convenio
         } // fin de if de búsqueda del plan del paciente
         
      } // fin de if de 
      
      return null;
   } // findel método buscarFichaInternacion
   
   public DTOFacturaPaciente generarFactura(){
      return null;
   } // findel método generarFactura
} // fin de la clase ExpertoGenerarFacturaPaciente