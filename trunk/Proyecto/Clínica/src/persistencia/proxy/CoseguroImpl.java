package persistencia.proxy;

public class CoseguroImpl implements Coseguro{
   private int codigoCoseguro;
   private float porcentaje;

   @Override
   public int getCodigoCoseguro() {
      return codigoCoseguro;
   }

   @Override
   public void setCodigoCoseguro(int codigoCoseguro) {
      this.codigoCoseguro = codigoCoseguro;
   }

   @Override
   public float getPorcentaje() {
      return porcentaje;
   }

   @Override
   public void setPorcentaje(float porcentaje) {
      this.porcentaje = porcentaje;
   }  
}