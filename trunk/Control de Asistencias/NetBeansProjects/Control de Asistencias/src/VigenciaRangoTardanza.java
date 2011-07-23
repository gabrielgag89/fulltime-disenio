// VigenciaRangoTardanza: VigenciaRangoTardanza.java
// 

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class VigenciaRangoTardanza {
   private Date fechaDesde;
   private Date fechaHasta;
   public Vector rangoDeTardanza = new Vector();
   public TipoHorasTrabajadas tipoHorasTrabajadas;

   public Date getFechaDesde() {
      return fechaDesde;
   } // fin del método getFechaDesde

   public void setFechaDesde(Date fechaDesde) {
      this.fechaDesde = fechaDesde;
   } // fin del método setFechaDesde

   public Date getFechaHasta() {
      return fechaHasta;
   } // fin del método getFechaHasta

   public void setFechaHasta(Date fechaHasta) {
      this.fechaHasta = fechaHasta;
   } // fin del método setFechaHasta

   public Vector getRangoDeTardanza() {
      return rangoDeTardanza;
   } // fin del método getRangoDeTardanza

   public void setRangoDeTardanza(RangoDeTardanza rangoDeTardanza) {
      this.rangoDeTardanza.addElement(rangoDeTardanza);
   } // fin del método setRangoDeTardanza

   public TipoHorasTrabajadas getTipoHorasTrabajadas() {
      return tipoHorasTrabajadas;
   } // fin del método getTipoHorasTrabajadas

   public void setTipoHorasTrabajadas(TipoHorasTrabajadas tipoHorasTrabajadas) {
      this.tipoHorasTrabajadas = tipoHorasTrabajadas;
   } // fin del método setTipoHorasTrabajadas
} // fin de la clase VigenciaRangoTardanza