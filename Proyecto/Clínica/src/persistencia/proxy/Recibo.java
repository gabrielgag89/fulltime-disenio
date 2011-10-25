package persistencia.proxy;

import java.util.Date;
import java.util.List;

public interface Recibo {
	public int getNroRecibo();
	public void setNroRecibo(int nroRecibo);
	public List<Monto> getMonto();
        public void setMonto(List<Monto> montos);
	public void addMonto(Monto monto);
	public Date getFecha();
	public void setFecha(Date fecha);
	public FacturaCliente getFacturaCliente();
	public void setFacturaCliente(FacturaCliente facturacliente);
}