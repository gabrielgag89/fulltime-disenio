package observador;

import java.util.ArrayList;
import java.util.List;

public class SuscriptorGenerarFacturaPaciente {
    private static SuscriptorGenerarFacturaPaciente instancia;
    private boolean changed = false;
    private List<ObservadorGenerarFacturaPaciente> obs = new  ArrayList<ObservadorGenerarFacturaPaciente>();

    public static SuscriptorGenerarFacturaPaciente getInstance(){
        if (instancia == null) {
            instancia = new SuscriptorGenerarFacturaPaciente();
        }
        return instancia;
    }

    public synchronized void agregarObservadorGenerarFacturaPaciente(ObservadorGenerarFacturaPaciente o) {
               
	if (!obs.contains(o)) 
	    obs.add(o);
	
    }

    public synchronized void borrarObservadorFacturarCliente(ObservadorGenerarFacturaPaciente o) {
        obs.remove(o);
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
            ((ObservadorGenerarFacturaPaciente)arrLocal[i]).actualizar(this, arg);
    }

    public synchronized void borrarObservadoresFacturarCliente() {
	obs.removeAll(obs);
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
