/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturarcliente;

import java.util.List;
import java.util.Calendar;

/**
 *
 * @author Fede
 */
public class DTOFichaInternacion {
    private int nroFicha;
    private int numPaciente;
    private String nombrePaciente;
    private Calendar fechaIngreso;
    private Calendar fechaEgreso;
    private List<DTODetalleServicio> dtoDetalle;

    public int getNroFicha() {
        return nroFicha;
    }

    public void setNroFicha(int nroFicha) {
        this.nroFicha = nroFicha;
    }

    public int getNumPaciente() {
        return numPaciente;
    }

    public void setNumPaciente(int numPaciente) {
        this.numPaciente = numPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Calendar getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Calendar getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Calendar fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public List<DTODetalleServicio> getDtoDetalle() {
        return dtoDetalle;
    }

    public void setDtoDetalle(List<DTODetalleServicio> dtoDetalle) {
        this.dtoDetalle = dtoDetalle;
    }
}