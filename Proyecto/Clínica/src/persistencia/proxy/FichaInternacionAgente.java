package persistencia.proxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.FachadaPersistenciaInterna;
import persistencia.criterios.Criterio;

public class FichaInternacionAgente  extends ObjetoPersistente implements FichaInternacion{
   private FichaInternacionImpl impl;
   private boolean cama=false;
   private boolean paciente=false;
   private boolean prestacion=false;
   private boolean estadoFichaInternacion=false;
   private boolean habitacion=false;
   private boolean detalleFicha=false;
   private String oidCama;
   private String oidPaciente;
   private String oidPrestacion;
   private String oidEstadoFichaInternacion;
   private String oidHabitacion;
   private String oidFacturaOS;
        
    public void setImplementacion(FichaInternacionImpl impl) {
        this.impl = impl;
    }

    public String getOidcama() {
        return oidCama;
    }

    public void setOidcama(String oidcama) {
        this.oidCama = oidcama;
    }

    public String getOidestadoFichaInternacion() {
        return oidEstadoFichaInternacion;
    }

    public void setOidestadoFichaInternacion(String oidestadoFichaInternacion) {
        this.oidEstadoFichaInternacion = oidestadoFichaInternacion;
    }

    public String getOidhabitacion() {
        return oidHabitacion;
    }

    public void setOidhabitacion(String oidhabitacion) {
        this.oidHabitacion = oidhabitacion;
    }

    public String getOidpaciente() {
        return oidPaciente;
    }

    public void setOidpaciente(String oidpaciente) {
        this.oidPaciente = oidpaciente;
    }

    public String getOidprestacion() {
        return oidPrestacion;
    }

    public void setOidprestacion(String oidprestacion) {
        this.oidPrestacion = oidprestacion;
    }
    
    public String getOidFacturaOS() {
        return oidFacturaOS;
    }

    public void setOidFacturaOS(String oidFacturaOS) {
        this.oidFacturaOS = oidFacturaOS;
    }

    @Override
    public Cama getCama() {
      if(!cama){
         this.impl.setCama((Cama)FachadaPersistenciaInterna.getInstancia().buscar("Cama",oidCama));
         this.cama=true;
      }
      return this.impl.getCama();
    }

    @Override
    public void setCama(Cama cama) {
        this.impl.setCama(cama);
    }

    @Override
    public List<DetalleFicha> getDetalleFicha() {
      if(!detalleFicha){
            List<Criterio> CS = new ArrayList<Criterio>();
            CS.add(FachadaPersistenciaInterna.getInstancia().getCriterio("oidficha_internacion", "=", this.getOid()));
            Criterio CC = FachadaPersistenciaInterna.getInstancia().and(CS);
         this.impl.setDetalleFicha((List<DetalleFicha>)FachadaPersistenciaInterna.getInstancia().buscar("DetalleFicha",CC));
         this.detalleFicha=true;
      }
      return this.impl.getDetalleFicha();
    }

    @Override
    public void setDetalleFicha(List<DetalleFicha> ListaDetalleFicha) {
        this.impl.setDetalleFicha(ListaDetalleFicha);
    }
    
    @Override
    public void addDetalleFicha(DetalleFicha detalleFicha) {
        this.impl.addDetalleFicha(detalleFicha);
    }

    @Override
    public boolean deleteDetalleFicha(DetalleFicha detalleFicha) {
        return this.impl.deleteDetalleFicha(detalleFicha);
    }

    @Override
    public EstadoFichaInternacion getEstadoFichaInternacion() {
      if(!estadoFichaInternacion){
         this.impl.setEstadoFichaInternacion((EstadoFichaInternacion)FachadaPersistenciaInterna.getInstancia().buscar("EstadoFichaInternacion",oidEstadoFichaInternacion));
         this.estadoFichaInternacion=true;
      }
      return this.impl.getEstadoFichaInternacion();
    }

    @Override
    public void setEstadoFichaInternacion(EstadoFichaInternacion estadoFichaInternacion) {
        this.impl.setEstadoFichaInternacion(estadoFichaInternacion);
        this.oidEstadoFichaInternacion = ((ObjetoPersistente) estadoFichaInternacion).getOid();
    }

    @Override
    public Date getFechaCreacion() {
        return this.impl.getFechaCreacion();
    }

    @Override
    public void setFechaCreacion(Date fechaCreacion) {
        this.impl.setFechaCreacion(fechaCreacion);
    }

    @Override
    public Habitacion getHabitacion() {
      if(!habitacion){
         this.impl.setHabitacion((Habitacion)FachadaPersistenciaInterna.getInstancia().buscar("Habitacion",oidHabitacion));
         this.habitacion=true;
      }
      return this.impl.getHabitacion();
    }

    @Override
    public void setHabitacion(Habitacion habitacion) {
        this.impl.setHabitacion(habitacion);
        this.oidHabitacion = ((ObjetoPersistente) habitacion).getOid();
    }

    @Override
    public int getNroFicha() {
        return this.impl.getNroFicha();
    }

    @Override
    public void setNroFicha(int nroFicha) {
        this.impl.setNroFicha(nroFicha);
    }

    @Override
    public Paciente getPaciente() {
      if(!paciente){
         this.impl.setPaciente((Paciente)FachadaPersistenciaInterna.getInstancia().buscar("Paciente",oidPaciente));
         this.paciente=true;
      }
      return this.impl.getPaciente();
    }

    @Override
    public void setPaciente(Paciente paciente) {
        this.impl.setPaciente(paciente);
        this.oidPaciente = ((ObjetoPersistente) paciente).getOid();
    }

    @Override
    public Prestacion getPrestacion() {
      if(!prestacion){
         this.impl.setPrestacion((Prestacion)FachadaPersistenciaInterna.getInstancia().buscar("Prestacion",oidPrestacion));
         this.prestacion=true;
      }
      return this.impl.getPrestacion();
    }

    @Override
    public void setPrestacion(Prestacion prestacion) {
        this.impl.setPrestacion(prestacion);
        this.oidPrestacion = ((ObjetoPersistente) prestacion).getOid();
    }
}