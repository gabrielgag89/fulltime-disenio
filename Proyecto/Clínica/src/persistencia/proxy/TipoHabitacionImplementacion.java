package persistencia.proxy;


public class TipoHabitacionImplementacion implements TipoHabitacion {

	private int codigoTipoHab;
	private String nombreTipo;

    @Override
    public int getCodigoTipoHabitacion() {
        return codigoTipoHab;
    }

    @Override
    public void setCodigoTipoHabitacion(int codigoTipoHab) {
        this.codigoTipoHab = codigoTipoHab;
    }

    @Override
    public String getNombreTipo() {
        return nombreTipo;
    }

    @Override
    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
        
        

    
    }

    