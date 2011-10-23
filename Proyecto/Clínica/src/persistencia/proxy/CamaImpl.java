package persistencia.proxy;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:28 p.m.
 */
public class CamaImpl implements Cama{
   private int numCama;
   private Habitacion habitacion;
   private EstadoCama estadoCama;

   @Override
   public int getNumCama() {
      return numCama;
   }

   @Override
   public void setNumCama(int numCama) {
      this.numCama = numCama;
   }

   @Override
   public Habitacion getHabitacion() {
      return habitacion;
   }

   @Override
   public void setHabitacion(Habitacion habitacion) {
      this.habitacion = habitacion;
   }

   @Override
   public EstadoCama getEstadoCama() {
      return estadoCama;
   }

   @Override
   public void setEstadoCama(EstadoCama estadoCama) {
      this.estadoCama = estadoCama;
   }
}//end Cama