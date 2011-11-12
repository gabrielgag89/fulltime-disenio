package persistencia.proxy;

import java.util.Date;
import java.util.List;

public class ReciboImpl implements Recibo{
    private int nroRecibo;
    private Date fecha;
    private FacturaCliente facturacliente;
    private double monto;

    @Override
    public int getNroRecibo() {
        return this.nroRecibo;
    }

    @Override
    public void setNroRecibo(int nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    @Override
    public double getMonto() {
        return this.monto;
    }

    @Override
    public void setMonto(double monto){
        this.monto = monto;
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