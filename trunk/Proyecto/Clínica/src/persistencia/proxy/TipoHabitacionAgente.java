/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.proxy;

/**
 *
 * @author Cristian Mesa
 */
public class TipoHabitacionAgente extends ObjetoPersistente implements TipoHabitacion {
    private TipoHabitacionImplementacion implementacion;
    
    public void setImplementacion(TipoHabitacionImplementacion implementacion) {
        this.implementacion = implementacion;
        }
    @Override
        public int getCodigoTipoHabitacion() {
        return this.implementacion.getCodigoTipoHabitacion();
        }
    @Override
        public void setCodigoTipoHabitacion(int codigoTipoHabitacion) {
        this.implementacion.setCodigoTipoHabitacion(codigoTipoHabitacion);
        }
    @Override
        public String getNombreTipo() {
        return this.implementacion.getNombreTipo();
        }
    @Override
        public void setNombreTipo(String nombreTipo) {
        this.implementacion.setNombreTipo(nombreTipo);
        }

}
