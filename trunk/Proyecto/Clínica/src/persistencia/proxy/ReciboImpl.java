package persistencia.proxy;

import java.util.Date;
import java.util.List;

public class ReciboImpl implements Recibo{
    private int nroRecibo;
    private Date fecha;
    private FacturaCliente facturacliente;
    private List<Monto> montos;

    @Override
    public int getNroRecibo() {
        return this.nroRecibo;
    }

    @Override
    public void setNroRecibo(int nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    @Override
    public List<Monto> getMonto() {
        return this.montos;
    }

    @Override
    public void setMonto(List<Monto> montos){
        this.montos = montos;
    }
    
    @Override
    public void addMonto(Monto monto) {
        this.montos.add(monto);
    }

    @Override
    public Date getFecha() {
        return this.fecha;
    }

    @Override
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public FacturaCliente getFacturaCliente() {
        return this.facturacliente;
    }

    @Override
    public void setFacturaCliente(FacturaCliente facturacliente) {
        this.facturacliente = facturacliente;
    }

}
