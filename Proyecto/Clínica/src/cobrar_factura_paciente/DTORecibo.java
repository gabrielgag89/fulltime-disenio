/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cobrar_factura_paciente;

import java.util.Date;
import persistencia.proxy.FacturaCliente;

/**
 *
 * @author Gabriel
 */
public class DTORecibo {
    private int nroRecibo;
    private int numFactura;
    private Date fecha;
    private double monto;

   public int getNroRecibo() {
      return nroRecibo;
   }

   public void setNroRecibo(int nroRecibo) {
      this.nroRecibo = nroRecibo;
   }

   public Date getFecha() {
      return fecha;
   }

   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

   public int getNumFactura() {
      return numFactura;
   }

   public void setNumFactura(int numFactura) {
      this.numFactura = numFactura;
   }

   public double getMonto() {
      return monto;
   }

   public void setMonto(double monto) {
      this.monto = monto;
   }
} // fin de la clase DTORecibo