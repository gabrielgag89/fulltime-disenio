package generar_factura_paciente;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import observador.SuscriptorGenerarFacturaPaciente;
import persistencia.proxy.EstadoFichaInternacion;
import persistencia.FachadaPersistenciaInterna;
import persistencia.proxy.EstadoFacturaCliente;
import persistencia.proxy.FichaInternacion;
import persistencia.proxy.CostoPrestacion;
import persistencia.proxy.FacturaCliente;
import persistencia.proxy.CostoServicio;
import persistencia.FachadaPersistencia;
import persistencia.criterios.Criterio;
import persistencia.proxy.DetalleFicha;
import persistencia.proxy.EstadoCama;
import persistencia.proxy.Convenio;
import dtos.DTOFichaInternacion;
import dtos.DTODetalleServicio;
import dtos.DTOFacturaPaciente;
import util.ServiciosTiempo;

public class ExpertoGenerarFacturaPaciente {
   private FichaInternacion fichaInternacion = null;
   private DTOFichaInternacion dtoFicha = null;

   public DTOFichaInternacion buscarFichaInternacion(int numFicha){
      List<Criterio> criterios = new ArrayList<Criterio>();
      Criterio criterio = FachadaPersistencia.getInstancia().getCriterio("nroFicha", "=", numFicha, "");
      criterios.add(criterio);
      
      try{
         this.fichaInternacion = (FichaInternacion) FachadaPersistencia.getInstancia().buscar("FichaInternacion", criterios).get(0);
         
         if(this.fichaInternacion.getEstadoFichaInternacion().getNombreEstado().equals("Creada")){
            this.dtoFicha = new DTOFichaInternacion();
            this.dtoFicha.setFecha(this.fichaInternacion.getFechaCreacion());
            this.dtoFicha.setNroFicha(this.fichaInternacion.getNroFicha());
            this.dtoFicha.setNumPaciente(this.fichaInternacion.getPaciente().getNumPaciente());
            this.dtoFicha.setNombrePaciente(this.fichaInternacion.getPaciente().getNombre());
            this.dtoFicha.setNombrePrestacion(this.fichaInternacion.getPrestacion().getDescripcion());
            
            criterios = new ArrayList<Criterio>();
            criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaInicio", "<=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
            criterios.add(criterio);
            criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaFin", ">=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
            criterios.add(criterio);
            criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("prestacion", "=", this.fichaInternacion.getPrestacion(), "");
            criterios.add(criterio);
            
            CostoPrestacion costoPres = (CostoPrestacion) FachadaPersistencia.getInstancia().buscar("CostoPrestacion", criterios).get(0);

            this.dtoFicha.setCostoPrestacion(costoPres.getMonto());

            if(this.fichaInternacion.getPaciente().getPlan() != null){
               criterios = new ArrayList<Criterio>();
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaInicio", "<=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
               criterios.add(criterio);
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaFin", ">=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
               criterios.add(criterio);
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("prestacion", "=", this.fichaInternacion.getPrestacion(), "AND");
               criterios.add(criterio);
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("plan", "=", this.fichaInternacion.getPaciente().getPlan(), "");
               criterios.add(criterio);
               
               try{
                  Convenio convenio = (Convenio) FachadaPersistencia.getInstancia().buscar("Convenio", criterios).get(0);
                  this.dtoFicha.setDescuento(convenio.getCoseguro().getPorcentaje());
               } // fin de try ocasionado por inexistencia de un convenio para el plan y la prestación en el período
               catch(IndexOutOfBoundsException ex){
                  this.dtoFicha.setDescuento(0.0);
                  System.err.println("ExpertoGenerarFacturaPaciente - buscarFichaInternacion(int numFicha) - No existe convenio en el período - " + ex.getMessage());
               } // fin de catch ocasionado por inexistencia de un convenio para el plan y la prestación en el período
            } // fin de if de búsqueda del plan del paciente

            List<DetalleFicha> listaDetalles = this.fichaInternacion.getDetalleFicha();
            
            List<DTODetalleServicio> listaDtoDetalle = new ArrayList<DTODetalleServicio>();
            DTODetalleServicio dtoDetalle;

            for(DetalleFicha detalle : listaDetalles){
               dtoDetalle = new DTODetalleServicio();

               dtoDetalle.setNombreServicio(detalle.getServicioEspecial().getNombreServicio());
               dtoDetalle.setCantidad(detalle.getCantidad());

               criterios = new ArrayList<Criterio>();
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaInicio", "<=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
               criterios.add(criterio);
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaFin", ">=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
               criterios.add(criterio);
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("servicioEspecial", "=", detalle.getServicioEspecial(), "");
               criterios.add(criterio);
               
               CostoServicio costoServ = (CostoServicio) FachadaPersistencia.getInstancia().buscar("CostoServicio", criterios).get(0);

               dtoDetalle.setMonto(costoServ.getMonto());
               dtoDetalle.setSubtotal(costoServ.getMonto() * detalle.getCantidad());

               listaDtoDetalle.add(dtoDetalle);
            } // fin de for de creación del DTO del detalle

            this.dtoFicha.setDtoDetalle(listaDtoDetalle);
         } // fin de if de búsqueda de facturas en estado "Creada"
      } // fin de try de comprobación de existencia de ficha
      catch(IndexOutOfBoundsException ex){
         System.err.println("ExpertoGenerarFacturaPaciente - buscarFichaInternacion(int numFicha) - Ficha no encontrada - " + ex.getMessage());
         return null;
      } // fin de catch de comprobación de existencia de ficha
      
      return this.dtoFicha;
   } // findel método buscarFichaInternacion
   
   public DTOFacturaPaciente generarFactura(){
      FacturaCliente factura = (FacturaCliente) FachadaPersistencia.getInstancia().nuevaEntidad("FacturaCliente");
      
      factura.setFechaEmision(new Date());
      factura.setNumFactura(this.fichaInternacion.getNroFicha());
      factura.setFichaInternacion(this.fichaInternacion);
      
      List<Criterio> criterios = new ArrayList<Criterio>();
      Criterio criterio = FachadaPersistencia.getInstancia().getCriterio("nombreEstado", "=", "Emitida", "");
      criterios.add(criterio);
      
      EstadoFacturaCliente estadoFactura = (EstadoFacturaCliente) FachadaPersistencia.getInstancia().buscar("EstadoFacturaCliente", criterios).get(0);
      factura.setEstadoFacturaCliente(estadoFactura);
      
      criterios = new ArrayList<Criterio>();
      criterio = FachadaPersistencia.getInstancia().getCriterio("nombreEstado", "=", "Facturada", "");
      criterios.add(criterio);
      
      EstadoFichaInternacion estadoFicha = (EstadoFichaInternacion) FachadaPersistencia.getInstancia().buscar("EstadoFichaInternacion", criterios).get(0);
      this.fichaInternacion.setEstadoFichaInternacion(estadoFicha);
      
      criterios = new ArrayList<Criterio>();
      criterio = FachadaPersistencia.getInstancia().getCriterio("nombreEstado", "=", "Disponible", "");
      criterios.add(criterio);
      
      EstadoCama estadoCama = (EstadoCama) FachadaPersistencia.getInstancia().buscar("EstadoCama", criterios).get(0);
      this.fichaInternacion.getCama().setEstadoCama(estadoCama);
      
      DTOFacturaPaciente dtoFactura = new DTOFacturaPaciente();
      dtoFactura.setFecha(factura.getFechaEmision());
      dtoFactura.setNroFicha(factura.getFichaInternacion().getNroFicha());
      dtoFactura.setNumFactura(factura.getNumFactura());
      dtoFactura.setNombrePaciente(this.dtoFicha.getNombrePaciente());
      dtoFactura.setNombrePrestacion(this.dtoFicha.getNombrePrestacion());
      dtoFactura.setCostoPrestacion(this.dtoFicha.getCostoPrestacion());
      dtoFactura.setDescuento(this.dtoFicha.getDescuento());
      dtoFactura.setDtoDetalle(this.dtoFicha.getDtoDetalle());
      
      double monto = dtoFactura.getCostoPrestacion() - dtoFactura.getCostoPrestacion() * dtoFactura.getDescuento();
      
      for(DTODetalleServicio dtoDetalle : dtoFactura.getDtoDetalle()){
         monto += dtoDetalle.getSubtotal();
      } // fin de for 
      
      factura.setMonto(monto);
      dtoFactura.setMonto(monto);
      
      FachadaPersistencia.getInstancia().guardar("FacturaCliente", factura);
      FachadaPersistencia.getInstancia().guardar("Cama", this.fichaInternacion.getCama());
      FachadaPersistencia.getInstancia().guardar("FichaInternacion", this.fichaInternacion);
      
      SuscriptorGenerarFacturaPaciente.getInstancia().notificar(dtoFactura);
      
      return dtoFactura;
   } // findel método generarFactura
} // fin de la clase ExpertoGenerarFacturaPaciente