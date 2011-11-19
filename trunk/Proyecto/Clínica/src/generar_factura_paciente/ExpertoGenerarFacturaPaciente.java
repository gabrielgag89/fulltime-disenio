package generar_factura_paciente;

import dtos.DTODetalleServicio;
import persistencia.proxy.FichaInternacion;
import dtos.DTOFichaInternacion;
import dtos.DTOFacturaPaciente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import observador.SuscriptorGenerarFacturaPaciente;
import persistencia.FachadaPersistencia;
import persistencia.FachadaPersistenciaInterna;
import persistencia.criterios.Criterio;
import persistencia.proxy.Convenio;
import persistencia.proxy.CostoPrestacion;
import persistencia.proxy.CostoServicio;
import persistencia.proxy.DetalleFicha;
import persistencia.proxy.EstadoCama;
import persistencia.proxy.EstadoFacturaCliente;
import persistencia.proxy.EstadoFichaInternacion;
import persistencia.proxy.FacturaCliente;
import util.ServiciosTiempo;

public class ExpertoGenerarFacturaPaciente {
   private FichaInternacion fichaInternacion = null;
   private DTOFichaInternacion dtoFicha = null;

   public DTOFichaInternacion buscarFichaInternacion(int numFicha){
      Criterio criterio = FachadaPersistencia.getInstancia().getCriterio("numero_ficha_internacion", "=", numFicha + "");
      
      try{
         this.fichaInternacion = (FichaInternacion) FachadaPersistencia.getInstancia().buscar("FichaInternacion", criterio).get(0);
         
         if(this.fichaInternacion.getEstadoFichaInternacion().getNombreEstado().equals("Creada")){
            dtoFicha = new DTOFichaInternacion();

            dtoFicha.setFecha(this.fichaInternacion.getFechaCreacion());
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

            List<DetalleFicha> listaDetalles = this.fichaInternacion.getDetalleFicha();
            List<DTODetalleServicio> listaDtoDetalle = new ArrayList<DTODetalleServicio>();
            DTODetalleServicio dtoDetalle;

            for(DetalleFicha detalle : listaDetalles){
               dtoDetalle = new DTODetalleServicio();

               dtoDetalle.setNombreServicio(detalle.getServicioEspecial().getNombreServicio());
               dtoDetalle.setCantidad(detalle.getCantidad());

               List<CostoServicio> listaCostosServicios = FachadaPersistencia.getInstancia().buscar("CostoServicio", cc);

               for(CostoServicio costo : listaCostosServicios){
                  if(detalle.getServicioEspecial().getCodigoServicio() == costo.getServicioEspecial().getCodigoServicio()){
                     dtoDetalle.setMonto(costo.getMonto());
                     dtoDetalle.setSubtotal(costo.getMonto());
                     break;
                  } // fin de if de búsqueda del costo del servicio
               } // fin de for de búsqueda del costo del servicio

               listaDtoDetalle.add(dtoDetalle);
            } // fin de for de creación del DTO del detalle

            dtoFicha.setDtoDetalle(listaDtoDetalle);
         } // fin de if de búsqueda de facturas en estado "Creada"
      } // fin de try de comprobación de existencia de ficha
      catch(IndexOutOfBoundsException ex){
         System.err.println("IndexOutOfBoundsException en buscarFichaInternacion - " + ex.getMessage());
         return null;
      } // fin de catch de comprobación de existencia de ficha
      
      return dtoFicha;
   } // findel método buscarFichaInternacion
   
   public DTOFacturaPaciente generarFactura(){
      FacturaCliente factura = (FacturaCliente) FachadaPersistencia.getInstancia().nuevaEntidad("FacturaCliente");
      
      factura.setFechaEmision(new Date());
      factura.setNumFactura(this.fichaInternacion.getNroFicha());
      factura.setFichaInternacion(this.fichaInternacion);
      
      Criterio c1 = FachadaPersistencia.getInstancia().getCriterio("nombre_estado_factura_cliente", "=", "Emitida");
      EstadoFacturaCliente estadoFactura = (EstadoFacturaCliente) FachadaPersistencia.getInstancia().buscar("EstadoFacturaCliente", c1).get(0);
      factura.setEstadoFacturaCliente(estadoFactura);
      
      Criterio c2 = FachadaPersistencia.getInstancia().getCriterio("nombre_estado_ficha_internacion", "=", "Facturada");
      EstadoFichaInternacion estadoFicha = (EstadoFichaInternacion) FachadaPersistencia.getInstancia().buscar("EstadoFichaInternacion", c2).get(0);
      this.fichaInternacion.setEstadoFichaInternacion(estadoFicha);
      
      Criterio c3 = FachadaPersistencia.getInstancia().getCriterio("nombre_estado_cama", "=", "Disponible");
      EstadoCama estadoCama = (EstadoCama) FachadaPersistencia.getInstancia().buscar("EstadoCama", c3).get(0);
      this.fichaInternacion.getCama().setEstadoCama(estadoCama);
      
      DTOFacturaPaciente dtoFactura = new DTOFacturaPaciente();
      dtoFactura.setFecha(factura.getFechaEmision());
      dtoFactura.setNroFicha(factura.getFichaInternacion().getNroFicha());
      dtoFactura.setNumFactura(factura.getNumFactura());
      dtoFactura.setNombrePaciente(this.dtoFicha.getNombrePaciente());
      dtoFactura.setNombrePrestacion(this.dtoFicha.getNombrePrestacion());
      dtoFactura.setCostoPrestacion(dtoFicha.getCostoPrestacion());
      dtoFactura.setDescuento(dtoFicha.getDescuento());
      dtoFactura.setDtoDetalle(dtoFicha.getDtoDetalle());
      
      double monto = dtoFactura.getCostoPrestacion() - dtoFactura.getCostoPrestacion() * dtoFactura.getDescuento();
      
      for(DTODetalleServicio dtoDetalle : dtoFactura.getDtoDetalle()){
         monto += dtoDetalle.getSubtotal();
      } // fin de for 
      
      factura.setMonto(monto);
      
      FachadaPersistencia.getInstancia().guardar("FacturaCliente", factura);
      FachadaPersistencia.getInstancia().guardar("Cama", this.fichaInternacion.getCama());
      FachadaPersistencia.getInstancia().guardar("FichaInternacion", this.fichaInternacion);
      
      SuscriptorGenerarFacturaPaciente.getInstancia().notificar(dtoFactura);
      
      return dtoFactura;
   } // findel método generarFactura
} // fin de la clase ExpertoGenerarFacturaPaciente