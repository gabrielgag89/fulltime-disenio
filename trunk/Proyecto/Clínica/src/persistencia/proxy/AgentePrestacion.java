// AgentePrestacion: AgentePrestacion.java
// 

package persistencia.proxy;

import persistencia.FachadaPersistenciaInterna;

/**
 *
 * @author Gabriel
 */
public class AgentePrestacion extends ObjetoPersistente implements Prestacion{
   private PrestacionImpl impl;
   private boolean tipoPrestacion = false;
   private String oidTipoPrestacion;
   
   public void setImplementacion(PrestacionImpl impl){
      this.impl = impl;
   }

   @Override
   public int getCodigoPrestacion() {
      return this.impl.getCodigoPrestacion();
   }

   @Override
   public void setCodigoPrestacion(int codigoPrestacion) {
      this.impl.setCodigoPrestacion(codigoPrestacion);
   }

   @Override
   public String getDescripcion() {
      return this.impl.getDescripcion();
   }

   @Override
   public void setDescripcion(String descripcion) {
      this.impl.setDescripcion(descripcion);
   }

   @Override
   public TipoPrestacion getTipoPrestacion() {
      if(!this.tipoPrestacion){
         this.impl.setTipoPrestacion((TipoPrestacion) FachadaPersistenciaInterna.getInstancia().buscar("TipoPrestacion", this.oidTipoPrestacion));
         this.tipoPrestacion = true;
      }
      
      return this.impl.getTipoPrestacion();
   }

   @Override
   public void setTipoPrestacion(TipoPrestacion tipoPrestacion) {
      this.impl.setTipoPrestacion(tipoPrestacion);
   }

   public String getOidTipoPrestacion() {
      return oidTipoPrestacion;
   }

   public void setOidTipoPrestacion(String oidTipoPrestacion) {
      this.oidTipoPrestacion = oidTipoPrestacion;
   }
} // fin de la clase AgentePrestacion