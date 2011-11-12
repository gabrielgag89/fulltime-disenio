/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturarcliente;

/**
 *
 * @author Fede
 */
public class DTODetalleServicio {
    private String nombreServicio;
    private int cantidad;
    private double monto;
    private float subtotal;

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
}