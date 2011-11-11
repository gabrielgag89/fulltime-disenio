/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturarcliente;

/**
 *
 * @author Fede
 */
public class DTODetalleFichaInternacion {
    
    private int nroLinea;
    private String NombreDetalle;
    private int cantidad;
    private float Subtotal;
    private String tipoDetalle;

    public String getNombreDetalle() {
        return NombreDetalle;
    }

    public void setNombreDetalle(String NombreDetalle) {
        this.NombreDetalle = NombreDetalle;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float Subtotal) {
        this.Subtotal = Subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNroLinea() {
        return nroLinea;
    }

    public void setNroLinea(int nroLinea) {
        this.nroLinea = nroLinea;
    }

    public String getTipoDetalle() {
        return tipoDetalle;
    }

    public void setTipoDetalle(String tipoDetalle) {
        this.tipoDetalle = tipoDetalle;
    }
    
    
    
    
    
    
}
