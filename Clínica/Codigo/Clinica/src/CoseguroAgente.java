
public class CoseguroAgente implements Coseguro {
   
    private CoseguroImplementacion implementacion;
    
    public CoseguroAgente(){
      this.implementacion = new CoseguroImplementacion();
     }
    @Override
    public int getCodigoCoseguro() {
        return this.implementacion.getCodigoCoseguro();
    }

    @Override
    public void setCodigoCoseguro(int codigoCoseguro) {
        this.implementacion.setCodigoCoseguro(codigoCoseguro);
    }

    @Override
    public float getPorcentaje() {
        return this.implementacion.getPorcentaje();
    }

    @Override
    public void setPorcentaje(float porcentaje) {
        this.implementacion.setPorcentaje(porcentaje);
    }
   }

