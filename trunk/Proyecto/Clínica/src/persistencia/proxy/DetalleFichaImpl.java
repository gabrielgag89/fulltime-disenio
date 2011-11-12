package persistencia.proxy;

/**
 * @author Matías
 */
public class DetalleFichaImpl implements DetalleFicha {
    private FichaInternacion fichaInternacion;
    private ServicioEspecial servicioEspecial;

    @Override
    public FichaInternacion getFichaInternacion() {
        return fichaInternacion;
    }

    @Override
    public void setFichaInternacion(FichaInternacion fichaInternacion) {
        this.fichaInternacion = fichaInternacion;
    }

    @Override
    public ServicioEspecial getServicioEspecial() {
        return servicioEspecial;
    }

    @Override
    public void setServicioEspecial(ServicioEspecial servicioEspecial) {
        this.servicioEspecial = servicioEspecial;
    }
}