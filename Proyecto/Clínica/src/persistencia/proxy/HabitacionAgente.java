package persistencia.proxy;

import persistencia.proxy.Sector;
import persistencia.proxy.TipoHabitacion;
import persistencia.FachadaPersistenciaInterna;

public class HabitacionAgente extends ObjetoPersistente implements Habitacion  {
   private HabitacionImpl impl;
   private boolean sector = false;
   private boolean tipoHabitacion = false;
   private String oidSector;
   private String oidTipoHabitacion;

   public String getOidSector() {
      return oidSector;
   }

   public void setOidSector(String oidSector) {
      this.oidSector = oidSector;
   }

   public String getOidTipoHabitacion() {
      return oidTipoHabitacion;
   }

   public void setOidTipoHabitacion(String oidTipoHabitacion) {
      this.oidTipoHabitacion = oidTipoHabitacion;
   }

   public void setImplementacion(HabitacionImpl implementacion) {
      this.impl=implementacion;
   }

   @Override
   public int getNroHabitacion() {
      return  this.impl.getNroHabitacion();
   }

   @Override
   public void setNroHabitacion(int nroHabitacion) {
      this.impl.setNroHabitacion(nroHabitacion);
   }

   @Override
   public Sector getSector() {
      if(sector)
         return this.impl.getSector();
      else{
         this.impl.setSector((Sector)FachadaPersistenciaInterna.getInstancia().buscar("Sector",oidSector));
         this.sector=true;
         
         return this.impl.getSector();
      }
   }

   @Override
   public void setSector(Sector sector) {
      this.impl.setSector(sector);
   }

   @Override
   public TipoHabitacion getTipoHabitacion() {
      if(tipoHabitacion)
         return this.impl.getTipoHabitacion();
      else{
         this.impl.setTipoHabitacion((TipoHabitacion)FachadaPersistenciaInterna.getInstancia().buscar("TipoHabitacion",oidTipoHabitacion));
         this.tipoHabitacion=true;
         
         return this.impl.getTipoHabitacion();
      }
   }

   @Override
   public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
      this.impl.setTipoHabitacion(tipoHabitacion);
   }
}