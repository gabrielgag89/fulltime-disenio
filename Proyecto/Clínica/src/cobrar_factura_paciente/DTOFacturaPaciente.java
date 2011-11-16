package cobrar_factura_paciente;

import java.util.Date;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class DTOFacturaPaciente {
   private int numFactura;
   private Date fecha;
   private int nroFicha;
   private String nombrePaciente;
   private String nombrePrestacion;
   private double costoPrestacion;
   private double descuento;
   private List<DTODetalle> dtoDetalle;

   public int getNumFactura() {
      return numFactura;
   }

   public void setNumFactura(int numFactura) {
      this.numFactura = numFactura;
   }

   public Date getFecha() {
      return fecha;
   }

   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

   public int getNroFicha() {
      return nroFicha;
   }

   public void setNroFicha(int nroFicha) {
      this.nroFicha = nroFicha;
   }

   public String getNombrePaciente() {
      return nombrePaciente;
   }

   public void setNombrePaciente(String nombrePaciente) {
      this.nombrePaciente = nombrePaciente;
   }

   public String getNombrePrestacion() {
      return nombrePrestacion;
   }

   public void setNombrePrestacion(String nombrePrestacion) {
      this.nombrePrestacion = nombrePrestacion;
   }

   public double getCostoPrestacion() {
      return costoPrestacion;
   }

   public void setCostoPrestacion(double costoPrestacion) {
      this.costoPrestacion = costoPrestacion;
   }

   public double getDescuento() {
      return descuento;
   }

   public void setDescuento(double descuento) {
      this.descuento = descuento;
   }

   public List<DTODetalle> getDtoDetalle() {
      return dtoDetalle;
   }

   public void setDtoDetalle(List<DTODetalle> dtoDetalle) {
      this.dtoDetalle = dtoDetalle;
   }
}