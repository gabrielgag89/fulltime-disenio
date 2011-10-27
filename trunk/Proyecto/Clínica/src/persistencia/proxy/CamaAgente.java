// CamaAgente: CamaAgente.java
// 

package persistencia.proxy;

/**
 *
 * @author Gabriel
 */
public class CamaAgente extends ObjetoPersistente implements Cama{
   private CamaImpl impl;
   private boolean habitacion;
   private boolean estadoCama;
   private String oidHabitacion;
   private String oidEstadoCama;

   public void setImplementacion(CamaImpl impl){
      this.impl = impl;
   }

   @Override
   public int getNumCama() {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void setNumCama(int numCama) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Habitacion getHabitacion() {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void setHabitacion(Habitacion habitacion) {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public EstadoCama getEstadoCama() {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void setEstadoCama(EstadoCama estadoCama) {
      throw new UnsupportedOperationException("Not supported yet.");
   }
   
} // fin de la clase CamaAgente
