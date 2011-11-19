package persistencia.proxy;

import persistencia.FachadaPersistenciaInterna;

public class DetalleFichaAgente extends ObjetoPersistente implements DetalleFicha {
   private DetalleFichaImpl impl;
   private boolean fichaInternacion = false;
   private boolean servicioEspecial = false;
   private String oidFichaInternacion;
   private String oidServicioEspecial;

   public void setImplementacion(DetalleFichaImpl impl){
      this.impl = impl;
   }

   @Override
   public ServicioEspecial getServicioEspecial(){
      if(!this.servicioEspecial)
         this.impl.setServicioEspecial((ServicioEspecial)FachadaPersistenciaInterna.getInstancia().buscar("ServicioEspecial", this.oidServicioEspecial));
      
      return this.impl.getServicioEspecial();
   }

   @Override
   public void setServicioEspecial(ServicioEspecial servicioEspecial){
      this.impl.setServicioEspecial(servicioEspecial);
   }

   public String getOidServicioEspecial(){
      return oidServicioEspecial;
   }

   public void setOidServicioEspecial(String oidServicioEspecial){
      this.oidServicioEspecial = oidServicioEspecial;
   }

   @Override
   public FichaInternacion getFichaInternacion() {
      if(!this.fichaInternacion)
         this.impl.setFichaInternacion((FichaInternacion) FachadaPersistenciaInterna.getInstancia().buscar("FichaInternacion",this.oidFichaInternacion));
      
      return this.impl.getFichaInternacion();
   }

   @Override
   public void setFichaInternacion(FichaInternacion fichaInternacion) {
      this.impl.setFichaInternacion(fichaInternacion);
   }

   @Override
   public int getCantidad() {
      return this.impl.getCantidad();
   }

   @Override
   public void setCantidad(int cantidad) {
      this.impl.setCantidad(cantidad);
   }

   public String getOidFichaInternacion(){
      return oidFichaInternacion;
   }

   public void setOidFichaInterncaion(String oidFichaInternacion){
      this.oidFichaInternacion = oidFichaInternacion;
   }
}//end DetalleFichaAgente