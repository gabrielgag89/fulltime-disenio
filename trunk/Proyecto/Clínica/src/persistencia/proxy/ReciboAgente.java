package persistencia.proxy;

import java.util.Date;
import java.util.List;
import persistencia.FachadaPersistenciaInterna;

public class ReciboAgente extends ObjetoPersistente implements Recibo {
    private ReciboImpl impl;
    private String oidFacturaCliente;
    private boolean facturacliente = false;

    public void setImplementacion(ReciboImpl impl) {
        this.impl = impl;
    }

    @Override
    public int getNroRecibo() {
        return this.impl.getNroRecibo();
    }

    @Override
    public void setNroRecibo(int nroRecibo) {
         this.impl.setNroRecibo(nroRecibo);
    }

    @Override
    public List<Monto> getMonto() {
        return  this.impl.getMonto();
    }

    @Override
    public void setMonto(List<Monto> montos) {
         this.impl.setMonto(montos);
    }

    @Override
    public void addMonto(Monto monto) {
         this.impl.addMonto(monto);
    }

    @Override
    public Date getFecha() {
        return  this.impl.getFecha();
    }

    @Override
    public void setFecha(Date fecha) {
         this.impl.setFecha(fecha);
    }

    @Override
    public FacturaCliente getFacturaCliente() {
      if(!facturacliente){
         this.impl.setFacturaCliente((FacturaCliente)FachadaPersistenciaInterna.getInstancia().buscar("FacturaCliente",oidFacturaCliente));
         this.facturacliente=true;
      }
      return this.impl.getFacturaCliente();
    }

    @Override
    public void setFacturaCliente(FacturaCliente facturacliente) {
         this.impl.setFacturaCliente(facturacliente);
    }

}
