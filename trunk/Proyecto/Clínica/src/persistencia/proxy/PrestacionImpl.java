// PrestacionImpl: PrestacionImpl.java
//

package persistencia.proxy;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:22 p.m.
 */
public class PrestacionImpl implements Prestacion{
   private int codigoPrestacion;
   private String descripcion;
   public TipoPrestacion tipoPrestacion;

   @Override
   public int getCodigoPrestacion() {
      return codigoPrestacion;
   }

   @Override
   public void setCodigoPrestacion(int codigoPrestacion) {
      this.codigoPrestacion = codigoPrestacion;
   }
   
   @Override
   public String getDescripcion() {
      return descripcion;
   }

   @Override
   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   @Override
   public TipoPrestacion getTipoPrestacion() {
      return tipoPrestacion;
   }

   @Override
   public void setTipoPrestacion(TipoPrestacion tipoPrestacion) {
      this.tipoPrestacion = tipoPrestacion;
   }
} // fin de la clase PrestacionImpl