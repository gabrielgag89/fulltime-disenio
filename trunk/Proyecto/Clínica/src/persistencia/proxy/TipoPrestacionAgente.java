package persistencia.proxy;

import persistencia.FachadaPersistenciaInterna;

public class TipoPrestacionAgente extends ObjetoPersistente implements TipoPrestacion{
   private TipoPrestacionImpl impl;
   private boolean tipoHabitacion = false;
   private String oidTipoHabitacion;

   public void setImplementacion(TipoPrestacionImpl impl) {
      this.impl = impl;
   }

    public String getOidTipoHabitacion() {
        return oidTipoHabitacion;
    }

    public void setOidTipoHabitacion(String oidTipoHabitacion) {
        this.oidTipoHabitacion = oidTipoHabitacion;
    }

   @Override
   public int getCodigoTipoPrestacion() {
      return this.impl.getCodigoTipoPrestacion();
   }

   @Override
   public void setCodigoTipoPrestacion(int codigoTipoPrestacion) {
      this.impl.setCodigoTipoPrestacion(codigoTipoPrestacion);
   }

   @Override
   public TipoHabitacion getTipoHabitacion() {
      if(!tipoHabitacion){
         this.impl.setTipoHabitacion((TipoHabitacion)FachadaPersistenciaInterna.getInstancia().buscar("TipoHabitacion",oidTipoHabitacion));
         this.tipoHabitacion=true;
      }
      return this.impl.getTipoHabitacion();
   }

   @Override
   public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
      this.impl.setTipoHabitacion(tipoHabitacion);
   }

   @Override
   public String getNombreTipoPrestacion() {
      return this.impl.getNombreTipoPrestacion();
   }

   @Override
   public void setNombreTipoPrestacion(String nombreTipoPrestacion) {
      this.impl.getNombreTipoPrestacion();
   }
}