package observador;

import java.util.Vector;

public class SuscriptorFacturarCliente {
    private static SuscriptorFacturarCliente instancia;
    private boolean changed = false;
    private Vector obs;

    public static SuscriptorFacturarCliente getInstance(){
        if (instancia == null) {
            instancia = new SuscriptorFacturarCliente();
        }
        return instancia;
    }

    public SuscriptorFacturarCliente() {
	obs = new Vector();
    }

    public synchronized void agregarObservadorFacturarCliente(ObservadorFacturarCliente o) {
        if (o == null)
            throw new NullPointerException();
	if (!obs.contains(o)) {
	    obs.addElement(o);
	}
    }

    public synchronized void borrarObservadorFacturarCliente(ObservadorFacturarCliente o) {
        obs.removeElement(o);
    }

    public void nitificarObservadoresFacturarCliente() {
	notificarObservadoresFacturarCliente(null);
    }

    public void notificarObservadoresFacturarCliente(Object arg) {
        Object[] arrLocal;

	synchronized (this) {
	    if (!changed) return;
            arrLocal = obs.toArray();
            limpiarCambio();
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            ((ObservadorFacturarCliente)arrLocal[i]).actualizar(this, arg);
    }

    public synchronized void borrarObservadoresFacturarCliente() {
	obs.removeAllElements();
    }

    public synchronized int cantidadObservadoresFacturarCliente() {
	return obs.size();
    }

        protected synchronized void notificarCambio() {
	changed = true;
    }

    protected synchronized void limpiarCambio() {
	changed = false;
    }

    public synchronized boolean aCambiado() {
	return changed;
    }
}
