// Convenio: Convenio.java
//

package persistencia.proxy;

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public interface Convenio {
   public Date getFechaInicio();

   public void setFechaInicio(Date fechaInicio);

   public Date getFechaFin();

   public void setFechaFin(Date fechaFin);

   public Plan getPlan();

   public void setPlan(Plan plan);

   public Prestacion getPrestacion();

   public void setPrestacion(Prestacion prestacion);

   public Coseguro getCoseguro();

   public void setCoseguro(Coseguro coseguro);
} // fin de la clase Convenio