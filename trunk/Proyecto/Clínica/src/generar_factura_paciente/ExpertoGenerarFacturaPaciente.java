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
      // se declara y crea una lista de criterios para usar en la búsqueda
      List<Criterio> criterios = new ArrayList<Criterio>();
      // se daclara y crea un criterio
      Criterio criterio = FachadaPersistencia.getInstancia().getCriterio("nroFicha", "=", numFicha, "");
      // se agrega el criterio a la lista
      criterios.add(criterio);
      
      // se buscan todas la ficha de internación que corresponde al número de ficha ingresado
      List<FichaInternacion> listaFichas = FachadaPersistencia.getInstancia().buscar("FichaInternacion", criterios);
      
      // se comprueba que la lista no esté vacía
      if(!listaFichas.isEmpty()){
         // se obtiene el primer elemento de la lista
         this.fichaInternacion = listaFichas.get(0);
         
         // se comprueba que la ficha de internación no esté facturada
         if(this.fichaInternacion.getEstadoFichaInternacion().getNombreEstado().equals("Creada")){
            // se crea el DTO donde se colocarán los datos de la ficha, la preatación y los servicios especiales
            this.dtoFicha = new DTOFichaInternacion();
            this.dtoFicha.setFecha(this.fichaInternacion.getFechaCreacion());
            this.dtoFicha.setNroFicha(this.fichaInternacion.getNroFicha());
            this.dtoFicha.setNumPaciente(this.fichaInternacion.getPaciente().getNumPaciente());
            this.dtoFicha.setNombrePaciente(this.fichaInternacion.getPaciente().getNombre());
            this.dtoFicha.setNombrePrestacion(this.fichaInternacion.getPrestacion().getDescripcion());
            
            // se crea una nueva lista de criterios
            criterios = new ArrayList<Criterio>();
            criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaInicio", "<=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
            criterios.add(criterio);
            criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaFin", ">=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
            criterios.add(criterio);
            criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("prestacion", "=", this.fichaInternacion.getPrestacion(), "");
            criterios.add(criterio);
            
            // se buscan los costos de la prestación que pertenezcan al período indicado y a la prestación
            List<CostoPrestacion> listaCostosPres = FachadaPersistencia.getInstancia().buscar("CostoPrestacion", criterios);
            
            // se comprueba que exista un costo para la prestación en el período
            if(!listaCostosPres.isEmpty()){
               // se toma el primer elemento de la lista de costos
               CostoPrestacion costoPres = listaCostosPres.get(0);
               
               // se guarda en el DTO de la ficha el costo de la prestación
               this.dtoFicha.setCostoPrestacion(costoPres.getMonto());
            } // fin de if de comprobación del costo de la prestación

            // se comprueba si el paciente tiene un plan de alguna obra social
            if(this.fichaInternacion.getPaciente().getPlan() != null){
               // se crea una nueva lista de criterios
               criterios = new ArrayList<Criterio>();
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaInicio", "<=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
               criterios.add(criterio);
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaFin", ">=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
               criterios.add(criterio);
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("prestacion", "=", this.fichaInternacion.getPrestacion(), "AND");
               criterios.add(criterio);
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("plan", "=", this.fichaInternacion.getPaciente().getPlan(), "");
               criterios.add(criterio);

               // se buscan los criterios que pertenezcan al período indicado y a la prestación y plan correspondiente
               List<Convenio> listaConvenios = FachadaPersistencia.getInstancia().buscar("Convenio", criterios);

               // se comprueba que exista un convenio
               if(!listaConvenios.isEmpty()){
                  // se toma el primer elemento de la lista de convenios
                  Convenio convenio = (Convenio) FachadaPersistencia.getInstancia().buscar("Convenio", criterios).get(0);
                  
                  // se guarda en la ficha el porcentaje de descuento para la prestación
                  this.dtoFicha.setDescuento(convenio.getCoseguro().getPorcentaje());
               } // fin de if de comprobación de existencia de un convenio para la prestación
            } // fin de if de comprobación del plan del paciente
            
            // se toman los detalles de la ficha de internación
            List<DetalleFicha> listaDetalles = this.fichaInternacion.getDetalleFicha();
            
            // se declara una lista de DTOs de datalles
            List<DTODetalleServicio> listaDtoDetalle = new ArrayList<DTODetalleServicio>();
            // se declara un DTO de detalle
            DTODetalleServicio dtoDetalle;

            // se recorre la lista de detalles
            for(DetalleFicha detalle : listaDetalles){
               // se crea un nuevo DTO de detalle y se le asignan los datos del detalle correspondiente
               dtoDetalle = new DTODetalleServicio();
               dtoDetalle.setNombreServicio(detalle.getServicioEspecial().getNombreServicio());
               dtoDetalle.setCantidad(detalle.getCantidad());
               
               // se crea una nueva lista de criterios
               criterios = new ArrayList<Criterio>();
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaInicio", "<=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
               criterios.add(criterio);
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("fechaFin", ">=", ServiciosTiempo.getInstancia().dateToString(this.fichaInternacion.getFechaCreacion()), "AND");
               criterios.add(criterio);
               criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("servicioEspecial", "=", detalle.getServicioEspecial(), "");
               criterios.add(criterio);
               
               // se buscan los costos del servicio especial que pertenezcan al período indicado
               List<CostoServicio> listaCostosServ = FachadaPersistencia.getInstancia().buscar("CostoServicio", criterios);
               
               // se comprueba que se hayan encontrado costos para el servicio en el período
               if(!listaCostosServ.isEmpty()){
                  // se toma el primer elemento de la lista de costos del servicio
                  CostoServicio costoServ = listaCostosServ.get(0);

                  // se guarda en el DTO del detalle el costo del servicio especial
                  dtoDetalle.setMonto(costoServ.getMonto());
                  // se calcula el subtotal para el detalle y se guarda en éste
                  dtoDetalle.setSubtotal(costoServ.getMonto() * detalle.getCantidad());
               } // fin de if de comprobación del costo del servicio
               
               // se agrega el DTO del detalle a la lista de DTOs de detalles para el DTO de la ficha
               listaDtoDetalle.add(dtoDetalle);
            } // fin de for de creación del DTO del detalle

            // se coloca la lista de DTOs de detalles en el DTO de la ficha
            this.dtoFicha.setDtoDetalle(listaDtoDetalle);
         } // fin de if de comprobación del estado de la ficha
      } // fin de if de comprobación de existencia de la ficha
      
      // se regresa el DTO con los datos de la ficha solicitada, o null si ésta no se encontró o ya se había facturado
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