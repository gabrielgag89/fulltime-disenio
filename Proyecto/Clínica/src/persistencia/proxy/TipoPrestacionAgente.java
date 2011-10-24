package persistencia.proxy;

public class TipoPrestacionAgente extends ObjetoPersistente implements TipoPrestacion{
   private TipoPrestacionImpl impl;

   public void setImplementacion(TipoPrestacionImpl impl) {
      this.impl = impl;
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
      return this.impl.getTipoHabitacion();
   }

   @Override
   public void setTipoHabitacion(TipoHabitacion mi_TipoHabitacion) {
      this.impl.setTipoHabitacion(mi_TipoHabitacion);
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