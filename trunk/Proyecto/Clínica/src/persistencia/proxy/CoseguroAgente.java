package persistencia.proxy;

public class CoseguroAgente extends ObjetoPersistente implements Coseguro {
   private CoseguroImpl impl;

   public void setImplementacion(CoseguroImpl impl){
      this.impl = impl;
   }

   @Override
   public int getCodigoCoseguro() {
      return this.impl.getCodigoCoseguro();
   }

   @Override
   public void setCodigoCoseguro(int codigoCoseguro) {
      this.impl.setCodigoCoseguro(codigoCoseguro);
   }

   @Override
   public float getPorcentaje() {
      return this.impl.getPorcentaje();
   }

   @Override
   public void setPorcentaje(float porcentaje) {
      this.impl.setPorcentaje(porcentaje);
   }
}