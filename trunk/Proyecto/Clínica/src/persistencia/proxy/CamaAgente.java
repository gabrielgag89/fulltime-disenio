// CamaAgente: CamaAgente.java
// 

package persistencia.proxy;

import persistencia.FachadaPersistenciaInterna;

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
      if(!this.habitacion){
           this.impl.setHabitacion((Habitacion) FachadaPersistenciaInterna.getInstancia().buscar("Habitacion", this.oidHabitacion));
       }
       return this.impl.getHabitacion();
   }

   @Override
   public void setHabitacion(Habitacion habitacion) {
        this.impl.setHabitacion(habitacion);
   }
   
   public String getOidHabitacion(){
       return oidHabitacion;
   }
   
   public void setOidHabitacion(String oidHabitacion){
       this.oidHabitacion = oidHabitacion;
   }

   @Override
   public EstadoCama getEstadoCama() {
       if(!this.estadoCama){
           this.impl.setEstadoCama((EstadoCama) FachadaPersistenciaInterna.getInstancia().buscar("EstadoCama", this.oidEstadoCama));
       }
       return this.impl.getEstadoCama();
   }

   @Override
   public void setEstadoCama(EstadoCama estadoCama) {
      this.impl.setEstadoCama(estadoCama);
   }
   
   public String getOidEstadoCama(){
       return oidEstadoCama;
   }
   
   public void setOidEstadoCama(String oidEstadoCama){
       this.oidEstadoCama = oidEstadoCama;
   }
      
} // fin de la clase CamaAgente
