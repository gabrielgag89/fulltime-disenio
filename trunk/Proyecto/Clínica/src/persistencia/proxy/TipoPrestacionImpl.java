package persistencia.proxy;

public class TipoPrestacionImpl implements TipoPrestacion {
   private int codigoTipoPrestacion;
   private String nombreTipoPrestacion;
   public TipoHabitacion tipoHabitacion;

   @Override
   public int getCodigoTipoPrestacion() {
      return codigoTipoPrestacion;
   }

   @Override
   public void setCodigoTipoPrestacion(int codigoTipoPrestacion) {
      this.codigoTipoPrestacion = codigoTipoPrestacion;
   }

   @Override
   public TipoHabitacion getTipoHabitacion() {
      return tipoHabitacion;
   }

   @Override
   public void setTipoHabitacion(TipoHabitacion mi_TipoHabitacion) {
      this.tipoHabitacion = mi_TipoHabitacion;
   }

   @Override
   public String getNombreTipoPrestacion() {
      return nombreTipoPrestacion;
   }

   @Override
   public void setNombreTipoPrestacion(String nombreTipoPrestacion) {
      this.nombreTipoPrestacion = nombreTipoPrestacion;
   }
}//end TipoPrestacion