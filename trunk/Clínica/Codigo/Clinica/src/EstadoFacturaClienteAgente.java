
public class EstadoFacturaClienteAgente implements EstadoFacturaCliente {
    private EstadoFacturaClienteImplementacion implementacion;
   
    public EstadoFacturaClienteAgente(){
      this.implementacion = new EstadoFacturaClienteImplementacion();
   }
    @Override
    public String getNombreEstado() {
        return this.implementacion.getNombreEstado();
    }

    @Override
    public void setNombreEstado(String nombreEstado) {
        this.implementacion.setNombreEstado(nombreEstado);
    }
}
