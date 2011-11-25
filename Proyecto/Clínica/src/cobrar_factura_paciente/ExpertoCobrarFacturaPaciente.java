package cobrar_factura_paciente;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import persistencia.proxy.EstadoFacturaPaciente;
import persistencia.proxy.CostoPrestacion;
import persistencia.proxy.FacturaPaciente;
import persistencia.FachadaPersistencia;
import persistencia.proxy.CostoServicio;
import persistencia.proxy.DetalleFicha;
import persistencia.criterios.Criterio;
import persistencia.proxy.Recibo;
import util.ServiciosTiempo;
import dtos.*;

public class ExpertoCobrarFacturaPaciente {
   public List<DTOFacturaPaciente> buscarFacturasPendientes() {
      List<Criterio> criterios = new ArrayList<Criterio>();
      Criterio criterio = FachadaPersistencia.getInstancia().getCriterio("nombreEstado", "=", "Emitida", "");
      criterios.add(criterio);
      
      EstadoFacturaPaciente estadoFactura = (EstadoFacturaPaciente) FachadaPersistencia.getInstancia().buscar("EstadoFacturaPaciente", criterios).get(0);
      
      criterios = new ArrayList<Criterio>();
      criterio = FachadaPersistencia.getInstancia().getCriterio("estadoFacturaPaciente", "=", estadoFactura, "");
      criterios.add(criterio);
      
      List<FacturaPaciente> listaFacturas = FachadaPersistencia.getInstancia().buscar("FacturaPaciente", criterios);
      
      List<DTOFacturaPaciente> listaDtoFacturas = new ArrayList<DTOFacturaPaciente>();
      DTOFacturaPaciente dtoFactura;
      
      List<DetalleFicha> listaDetalle;
      List<DTODetalleServicio> listaDtoDetalle;
      DTODetalleServicio dtoDetalle;
      
      CostoPrestacion costoPres;
      CostoServicio costoServ;
      
      for(FacturaPaciente f : listaFacturas){
         dtoFactura = new DTOFacturaPaciente();
         dtoFactura.setNumFactura(f.getNumFactura());
         dtoFactura.setFecha(f.getFechaEmision());
         dtoFactura.setNroFicha(f.getFichaInternacion().getNroFicha());
         dtoFactura.setNombrePaciente(f.getFichaInternacion().getPaciente().getNombre());
         dtoFactura.setNombrePrestacion(f.getFichaInternacion().getPrestacion().getDescripcion());

         criterios = new ArrayList<Criterio>();
         criterio = FachadaPersistencia.getInstancia().getCriterio("fechaInicio", "<=", ServiciosTiempo.getInstancia().dateToString(dtoFactura.getFecha()), "AND");
         criterios.add(criterio);

         criterio = FachadaPersistencia.getInstancia().getCriterio("fechaFin", ">=", ServiciosTiempo.getInstancia().dateToString(dtoFactura.getFecha()), "AND");
         criterios.add(criterio);

         criterio = FachadaPersistencia.getInstancia().getCriterio("prestacion", "=", f.getFichaInternacion().getPrestacion(), "");
         criterios.add(criterio);

         costoPres = (CostoPrestacion) FachadaPersistencia.getInstancia().buscar("CostoPrestacion", criterios).get(0);

         dtoFactura.setCostoPrestacion(costoPres.getMonto());

         listaDetalle = f.getFichaInternacion().getDetalleFicha();

         listaDtoDetalle = new ArrayList<DTODetalleServicio>();

         for(DetalleFicha df : listaDetalle){
            criterios = new ArrayList<Criterio>();
            criterio = FachadaPersistencia.getInstancia().getCriterio("fechaInicio", "<=", ServiciosTiempo.getInstancia().dateToString(dtoFactura.getFecha()), "AND");
            criterios.add(criterio);

            criterio = FachadaPersistencia.getInstancia().getCriterio("fechaFin", ">=", ServiciosTiempo.getInstancia().dateToString(dtoFactura.getFecha()), "AND");
            criterios.add(criterio);

            criterio = FachadaPersistencia.getInstancia().getCriterio("servicioEspecial", "=", df.getServicioEspecial(), "");
            criterios.add(criterio);

            costoServ = (CostoServicio) FachadaPersistencia.getInstancia().buscar("CostoServicio", criterios).get(0);

            dtoDetalle = new DTODetalleServicio();
            dtoDetalle.setNombreServicio(costoServ.getServicioEspecial().getNombreServicio());
            dtoDetalle.setMonto(costoServ.getMonto());
            dtoDetalle.setCantidad(df.getCantidad());
            dtoDetalle.setSubtotal(dtoDetalle.getMonto() * dtoDetalle.getCantidad());

            listaDtoDetalle.add(dtoDetalle);
         } // fin de for de creación de DTOs de detalle de la ficha

         dtoFactura.setMonto(f.getMonto());
         dtoFactura.setDtoDetalle(listaDtoDetalle);

         listaDtoFacturas.add(dtoFactura);
      } // fin de for de creación de DTOs de facturas
      
      return listaDtoFacturas;
   } // fin del método buscarFacturasPendientes
   
   public DTORecibo cobrarFactura(int numFactura){
      List<Criterio> criterios = new ArrayList<Criterio>();
      Criterio criterio = FachadaPersistencia.getInstancia().getCriterio("numFactura", "=", numFactura, "");
      criterios.add(criterio);
      
      FacturaPaciente factura = (FacturaPaciente) FachadaPersistencia.getInstancia().buscar("FacturaPaciente", criterios).get(0);
      
      Recibo recibo = (Recibo) FachadaPersistencia.getInstancia().nuevaEntidad("Recibo");
      
      recibo.setFacturaPaciente(factura);
      recibo.setFecha(new Date());
      recibo.setNroRecibo(numFactura);
      
      DTORecibo dtoRecibo = new DTORecibo();
      dtoRecibo.setNroRecibo(recibo.getNroRecibo());
      dtoRecibo.setNumFactura(recibo.getFacturaPaciente().getNumFactura());
      dtoRecibo.setFecha(recibo.getFecha());
      dtoRecibo.setMonto(factura.getMonto());
      
      criterios = new ArrayList<Criterio>();
      criterio = FachadaPersistencia.getInstancia().getCriterio("nombreEstado", "=", "Pagada", "");
      criterios.add(criterio);
      
      EstadoFacturaPaciente estadoFactura = (EstadoFacturaPaciente) FachadaPersistencia.getInstancia().buscar("EstadoFacturaPaciente", criterios).get(0);
      
      factura.setEstadoFacturaPaciente(estadoFactura);
      
      FachadaPersistencia.getInstancia().guardar("FacturaPaciente", factura);
      FachadaPersistencia.getInstancia().guardar("Recibo", recibo);
      
      return dtoRecibo;
   } // fin del método cobrarFactura
} // fin de la clase ExpertoCobrarFacturaPaciente