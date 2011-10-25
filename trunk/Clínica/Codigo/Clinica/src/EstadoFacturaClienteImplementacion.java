
public class EstadoFacturaClienteImplementacion implements EstadoFacturaCliente {
    private String nombreEstado;

    @Override
    public String getNombreEstado() {
        return nombreEstado;
    }

    @Override
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
}
