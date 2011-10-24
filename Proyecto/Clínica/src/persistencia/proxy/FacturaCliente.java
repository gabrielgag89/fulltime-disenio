// FacturaCliente: FacturaCliente.java
//

package persistencia.proxy;

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public interface FacturaCliente {
   public int getNumFactura();

   public void setNumFactura(int numFactura);

   public Date getFechaEmision();

   public void setFechaEmision(Date fechaEmision);

   public FichaInternacion getFichaInternacion();

   public void setFichaInternacion(FichaInternacion fichaInternacion);

   public EstadoFacturaCliente getEstadoFacturaCliente();

   public void setEstadoFacturaCliente(EstadoFacturaCliente estadoFacturaCliente);
} // fin de la clase FacturaCliente