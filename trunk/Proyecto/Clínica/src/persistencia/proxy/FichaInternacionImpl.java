package persistencia.proxy;

import java.util.Date;
import java.util.List;

public class FichaInternacionImpl implements FichaInternacion {
    private int nroFicha;
    private Date fechaCreacion;
    private Cama cama;
    private Paciente paciente;
    private Prestacion prestacion;
    private EstadoFichaInternacion estadoFichaInternacion;
    private Habitacion habitacion;
    private List<DetalleFicha> detalleFicha;

    @Override
    public Cama getCama() {
        return cama;
    }

    @Override
    public void setCama(Cama cama) {
        this.cama = cama;
    }

    @Override
    public List<DetalleFicha> getDetalleFicha() {
        return detalleFicha;
    }
    
    @Override
    public void setDetalleFicha(List<DetalleFicha> ListaDetalleFicha) {
        this.detalleFicha = ListaDetalleFicha;
    }

    @Override
    public void addDetalleFicha(DetalleFicha detalleFicha) {
        this.detalleFicha.add(detalleFicha);
    }

    @Override
    public boolean deleteDetalleFicha(DetalleFicha detalleFicha) {
        return this.detalleFicha.remove(detalleFicha);
    }

    @Override
    public EstadoFichaInternacion getEstadoFichaInternacion() {
        return estadoFichaInternacion;
    }

    @Override
    public void setEstadoFichaInternacion(EstadoFichaInternacion estadoFichaInternacion) {
        this.estadoFichaInternacion = estadoFichaInternacion;
    }

    @Override
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public Habitacion getHabitacion() {
        return habitacion;
    }

    @Override
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public int getNroFicha() {
        return nroFicha;
    }

    @Override
    public void setNroFicha(int nroFicha) {
        this.nroFicha = nroFicha;
    }

    @Override
    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public Prestacion getPrestacion() {
        return prestacion;
    }

    @Override
    public void setPrestacion(Prestacion prestacion) {
        this.prestacion = prestacion;
    }
}//end FichaInternacionImpl