// AgenteCama: AgenteCama.java
// 

package persistencia.proxy;

/**
 *
 * @author Gabriel
 */
public class AgenteCama extends ObjetoPersistente implements Cama{
   private CamaImpl impl;
   
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
   
} // fin de la clase AgenteCama
