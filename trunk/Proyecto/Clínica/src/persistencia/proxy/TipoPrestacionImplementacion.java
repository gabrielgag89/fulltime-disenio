
package persistencia.proxy;


public class TipoPrestacionImplementacion implements TipoPrestacion {

    private int codigoTipoPrestacion;
    private String nombreTipoPrestacion;
    public TipoHabitacion mi_TipoHabitacion;

    @Override
    public int getCodigoTipoPrestacion() {
        return codigoTipoPrestacion;
    }

    @Override
    public void setCodigoTipoPrestacion(int codigoTipoPrestacion) {
        this.codigoTipoPrestacion = codigoTipoPrestacion;
    }

    @Override
    public TipoHabitacion getTipoHabitacion() {
        return mi_TipoHabitacion;
    }

    @Override
    public void setTipoHabitacion(TipoHabitacion mi_TipoHabitacion) {
        this.mi_TipoHabitacion = mi_TipoHabitacion;
    }

    @Override
    public String getNombreTipoPrestacion() {
        return nombreTipoPrestacion;
    }

    @Override
    public void setNombreTipoPrestacion(String nombreTipoPrestacion) {
        this.nombreTipoPrestacion = nombreTipoPrestacion;
    }
   
	
}//end TipoPrestacion