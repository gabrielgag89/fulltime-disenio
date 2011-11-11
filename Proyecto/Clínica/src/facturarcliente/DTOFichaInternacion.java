/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturarcliente;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Fede
 */
public class DTOFichaInternacion {
    
    private int nroFicha;
    private Date fechaIngreso;
    private Date fechaEgreso;
    private List DTODetalleFichaInternacion;

    public List getDTODetalleFichaInternacion() {
        return DTODetalleFichaInternacion;
    }

    public void setDTODetalleFichaInternacion(List DTODetalleFichaInternacion) {
        this.DTODetalleFichaInternacion = DTODetalleFichaInternacion;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getNroFicha() {
        return nroFicha;
    }

    public void setNroFicha(int nroFicha) {
        this.nroFicha = nroFicha;
    }
    
    
    
    
    
    
}
