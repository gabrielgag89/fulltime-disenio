
package persistencia.proxy;


public class TipoPrestacionAgente implements TipoPrestacion extends ObjetoPersistente {
    
    private TipoPrestacionImplementacion implementacion;

   
    
    public void setImplementacion(TipoPrestacionImplementacion implementacion) {
        this.implementacion = implementacion;
    }  
    
    
    @Override
    public int getCodigoTipoPrestacion() {
        return this.implementacion.getCodigoTipoPrestacion();
    }

    @Override
    public void setCodigoTipoPrestacion(int codigoTipoPrestacion) {
        this.implementacion.setCodigoTipoPrestacion(codigoTipoPrestacion);
    }

    @Override
    public TipoHabitacion getTipoHabitacion() {
        return this.implementacion.getTipoHabitacion();
    }

    @Override
    public void setTipoHabitacion(TipoHabitacion mi_TipoHabitacion) {
        this.implementacion.setTipoHabitacion(mi_TipoHabitacion);
    }

    @Override
    public String getNombreTipoPrestacion() {
        return this.implementacion.getNombreTipoPrestacion();
    }

    @Override
    public void setNombreTipoPrestacion(String nombreTipoPrestacion) {
        this.implementacion.getNombreTipoPrestacion();
    }
   
}
