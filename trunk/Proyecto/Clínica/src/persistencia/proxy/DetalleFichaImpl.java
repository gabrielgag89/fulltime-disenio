package persistencia.proxy;

/**
 * @author Matías
 */
public class DetalleFichaImpl implements DetalleFicha {
    
    private FichaInternacion fichaInternacion;
    private ServicioEspecial servicioEspecial;
    private int cantidad;

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

   @Override
   public int getCantidad() {
      return cantidad;
   }

   @Override
   public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
   }
}