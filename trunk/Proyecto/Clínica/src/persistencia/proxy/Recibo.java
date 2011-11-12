package persistencia.proxy;

import java.util.Date;
import java.util.List;

public interface Recibo {
	public int getNroRecibo();
	public void setNroRecibo(int nroRecibo);
	public double getMonto();
        public void setMonto(double montos);
	public Date getFecha();
	public void setFecha(Date fecha);
	public FacturaCliente getFacturaCliente();
	public void setFacturaCliente(FacturaCliente facturacliente);
}