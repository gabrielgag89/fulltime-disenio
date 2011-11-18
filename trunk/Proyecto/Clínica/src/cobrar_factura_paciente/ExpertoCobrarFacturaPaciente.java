/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cobrar_factura_paciente;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import persistencia.proxy.EstadoFacturaCliente;
import persistencia.proxy.CostoPrestacion;
import persistencia.proxy.FacturaCliente;
import persistencia.FachadaPersistencia;
import persistencia.proxy.CostoServicio;
import persistencia.proxy.DetalleFicha;
import persistencia.criterios.Criterio;
import persistencia.proxy.Recibo;
import util.ServiciosTiempo;

/**
 *
 * @author gabriel
 */
public class ExpertoCobrarFacturaPaciente {
   private List<DTOFacturaPaciente> listaDtoFacturas;
   
   public List<DTOFacturaPaciente> buscarFacturasPendientes() {
      List<FacturaCliente> listaFacturas = FachadaPersistencia.getInstancia().buscar("FacturaCliente");
      listaDtoFacturas = new ArrayList<DTOFacturaPaciente>();
      DTOFacturaPaciente dtoFactura;
      List<CostoPrestacion> listaCostosPrestaciones;
      List<DetalleFicha> listaDetalle;
      List<DTODetalle> listaDtoDetalle;
      DTODetalle dtoDetalle;
      List<CostoServicio> listaCostosServicios;
      
      for(FacturaCliente f : listaFacturas){
         if(f.getEstadoFacturaCliente().getNombreEstado().equals("Emitida")){
            dtoFactura = new DTOFacturaPaciente();
            dtoFactura.setNumFactura(f.getNumFactura());
            dtoFactura.setFecha(f.getFechaEmision());
            dtoFactura.setNroFicha(f.getFichaInternacion().getNroFicha());
            dtoFactura.setNombrePaciente(f.getFichaInternacion().getPaciente().getNombre());
            dtoFactura.setNombrePrestacion(f.getFichaInternacion().getPrestacion().getDescripcion());
            
            Criterio c1 = FachadaPersistencia.getInstancia().getCriterio("fecha_inicio", "<=", ServiciosTiempo.dateToString(dtoFactura.getFecha()));
            Criterio c2 = FachadaPersistencia.getInstancia().getCriterio("fecha_fin", ">=", ServiciosTiempo.dateToString(dtoFactura.getFecha()));
            Criterio cc = FachadaPersistencia.getInstancia().and(c1, c2);
            
            listaCostosPrestaciones = FachadaPersistencia.getInstancia().buscar("CostoPrestacion", cc);
            
            for(CostoPrestacion c : listaCostosPrestaciones){
               if(c.getPrestacion().getCodigoPrestacion() == f.getFichaInternacion().getPrestacion().getCodigoPrestacion()){
                  dtoFactura.setCostoPrestacion(c.getMonto());
                  break;
               }
            }
            
            listaDetalle = FachadaPersistencia.getInstancia().buscar("DetalleFicha");
            listaCostosServicios = FachadaPersistencia.getInstancia().buscar("CostoServicio", cc);
            
            
            listaDtoDetalle = new ArrayList<DTODetalle>();
            
            for(DetalleFicha df : listaDetalle){
               if(df.getFichaInternacion().getNroFicha() != f.getFichaInternacion().getNroFicha()){
                  listaDetalle.remove(df);
               }
               else{
                  for(CostoServicio c : listaCostosServicios){
                     if(c.getServicioEspecial().getCodigoServicio() == df.getServicioEspecial().getCodigoServicio()){
                        dtoDetalle = new DTODetalle();
                        dtoDetalle.setNombreServicio(c.getServicioEspecial().getNombreServicio());
                        dtoDetalle.setMonto(c.getMonto());
                        dtoDetalle.setCantidad(df.getCantidad());
                        dtoDetalle.setSubtotal(dtoDetalle.getMonto() * dtoDetalle.getCantidad());
                        
                        listaDtoDetalle.add(dtoDetalle);
                     }
                  }
               }
            }
            
            dtoFactura.setDtoDetalle(listaDtoDetalle);
            
            listaDtoFacturas.add(dtoFactura);
         }
      }
      
      return listaDtoFacturas;
   } // fin del método buscarFacturasPendientes
   
   public DTORecibo cobrarFactura(int numFactura){
      Criterio c1 = FachadaPersistencia.getInstancia().getCriterio("numero_factura_cliente", "=", numFactura + "");
      FacturaCliente factura = (FacturaCliente) FachadaPersistencia.getInstancia().buscar("FacturaCliente", c1).get(0);
      
      Recibo recibo = (Recibo) FachadaPersistencia.getInstancia().nuevaEntidad("Recibo");
      
      recibo.setFacturaCliente(factura);
      recibo.setFecha(new Date());
      recibo.setNroRecibo(numFactura);
      
      DTOFacturaPaciente dtoFactura = buscarDtoFactura(numFactura);
      
      double monto = 0.0;
      
      if(dtoFactura.getDescuento() != 0.0)
         monto += dtoFactura.getCostoPrestacion() - (dtoFactura.getCostoPrestacion() * dtoFactura.getDescuento());
      else
         monto += dtoFactura.getCostoPrestacion();
      
      for(DTODetalle dtoDetalle : dtoFactura.getDtoDetalle())
         monto += dtoDetalle.getSubtotal();
      
      recibo.setMonto(monto);
      
      DTORecibo dtoRecibo = new DTORecibo();
      dtoRecibo.setNroRecibo(recibo.getNroRecibo());
      dtoRecibo.setNumFactura(recibo.getFacturaCliente().getNumFactura());
      dtoRecibo.setFecha(recibo.getFecha());
      dtoRecibo.setMonto(recibo.getMonto());
      
      Criterio c2 = FachadaPersistencia.getInstancia().getCriterio("nombre_estado_factura_cliente", "=", "'Pagada'");
      EstadoFacturaCliente estadoFactura = (EstadoFacturaCliente) FachadaPersistencia.getInstancia().buscar("EstadoFacturaCliente", c2).get(0);
      
      factura.setEstadoFacturaCliente(estadoFactura);
      
      return dtoRecibo;
   } // fin del método cobrarFactura
   
   private DTOFacturaPaciente buscarDtoFactura(int numFactura){
      for(DTOFacturaPaciente dtoFactura : listaDtoFacturas){
         if(dtoFactura.getNumFactura() == numFactura)
            return dtoFactura;
      }
      
      return null;
   } // fin del método buscarDtoFactura
} // fin de la clase ExpertoCobrarFacturaPaciente