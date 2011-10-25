
public class EstadoFichaInternacionAgente implements EstadoFichaInternacion {
  private EstadoFichaInternacionImplementacion implementacion;
   
    public EstadoFichaInternacionAgente(){
      this.implementacion = new EstadoFichaInternacionImplementacion();
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
