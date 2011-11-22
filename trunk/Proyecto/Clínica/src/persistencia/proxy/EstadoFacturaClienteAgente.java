package persistencia.proxy;

public class EstadoFacturaClienteAgente extends ObjetoPersistente implements EstadoFacturaCliente {
   private EstadoFacturaClienteImpl impl;

   public void setImplementacion(EstadoFacturaClienteImpl impl){
      this.impl = impl;
   }
   
   @Override
   public String getNombreEstado() {
      return this.impl.getNombreEstado();
   }

   @Override
   public void setNombreEstado(String nombreEstado) {
      this.impl.setNombreEstado(nombreEstado);
   }
} // fin de la clase EstadoFacturaClienteAgente