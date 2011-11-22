package generar_factura_paciente;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import dtos.DTODetalleServicio;
import dtos.DTOFacturaPaciente;
import util.ServiciosTiempo;

public class IUMonstrarFactura extends javax.swing.JFrame {
   private DefaultTableModel tablaFacturas;
   
   public IUMonstrarFactura() {
      this.tablaFacturas = new DefaultTableModel();
      initComponents();
      armarTabla();
   } // fin del constructor

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonVolver = new javax.swing.JButton();
        scrollPaneServiciosEspeciales = new javax.swing.JScrollPane();
        tablaFacturasExterna = new javax.swing.JTable();
        panelDatosFactura = new javax.swing.JPanel();
        etiquetaNumFactura = new javax.swing.JLabel();
        etiquetaNombrePaciente = new javax.swing.JLabel();
        etiquetaNombrePrestacion = new javax.swing.JLabel();
        etiquetaCostoPrestacion = new javax.swing.JLabel();
        etiquetaCoseguro = new javax.swing.JLabel();
        etiquetaFecha = new javax.swing.JLabel();
        campoTextoFecha = new javax.swing.JTextField();
        campoTextoNumFactura = new javax.swing.JTextField();
        campoTextoNombrePaciente = new javax.swing.JTextField();
        campoTextoNombrePrestacion = new javax.swing.JTextField();
        campoTextoCostoPrestacion = new javax.swing.JTextField();
        campoTextoCoseguro = new javax.swing.JTextField();
        campoTextoNumFicha = new javax.swing.JTextField();
        etiquetaNumFicha = new javax.swing.JLabel();
        etiquetaTotal = new javax.swing.JLabel();
        campoTextoTotal = new javax.swing.JTextField();

        setTitle("Factura");

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        scrollPaneServiciosEspeciales.setBorder(javax.swing.BorderFactory.createTitledBorder("Servicios Especiales"));

        tablaFacturasExterna.setModel(tablaFacturas);
        scrollPaneServiciosEspeciales.setViewportView(tablaFacturasExterna);

        panelDatosFactura.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Factura"));

        etiquetaNumFactura.setText("Nº Factura:");

        etiquetaNombrePaciente.setText("Nombre Paciente:");

        etiquetaNombrePrestacion.setText("Prestación:");

        etiquetaCostoPrestacion.setText("Costo Prestación:");

        etiquetaCoseguro.setText("Coseguro:");

        etiquetaFecha.setText("Fecha:");

        campoTextoFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoNumFactura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoNombrePaciente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoNombrePrestacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoCostoPrestacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoCoseguro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoNumFicha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        etiquetaNumFicha.setText("Nº Ficha:");

        javax.swing.GroupLayout panelDatosFacturaLayout = new javax.swing.GroupLayout(panelDatosFactura);
        panelDatosFactura.setLayout(panelDatosFacturaLayout);
        panelDatosFacturaLayout.setHorizontalGroup(
            panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosFacturaLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosFacturaLayout.createSequentialGroup()
                        .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiquetaCoseguro)
                            .addComponent(etiquetaCostoPrestacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoTextoCoseguro, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(campoTextoCostoPrestacion, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosFacturaLayout.createSequentialGroup()
                        .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiquetaNumFactura)
                            .addComponent(etiquetaFecha)
                            .addComponent(etiquetaNumFicha)
                            .addComponent(etiquetaNombrePrestacion)
                            .addComponent(etiquetaNombrePaciente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoTextoNombrePrestacion, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                .addComponent(campoTextoNombrePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoTextoNumFactura)
                                .addComponent(campoTextoNumFicha, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(campoTextoFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelDatosFacturaLayout.setVerticalGroup(
            panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosFacturaLayout.createSequentialGroup()
                .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaNumFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoNumFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaNumFicha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombrePaciente)
                    .addComponent(campoTextoNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombrePrestacion)
                    .addComponent(campoTextoNombrePrestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCostoPrestacion)
                    .addComponent(campoTextoCostoPrestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCoseguro)
                    .addComponent(campoTextoCoseguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        etiquetaTotal.setText("Total:");

        campoTextoTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneServiciosEspeciales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187)
                        .addComponent(etiquetaTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTextoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDatosFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatosFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneServiciosEspeciales, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaTotal)
                    .addComponent(botonVolver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
      this.setVisible(false);
}//GEN-LAST:event_botonVolverActionPerformed
   // fin del método botonVolverActionPerformed
   
   private void armarTabla(){
      // crea las columnas de la tabla
      this.tablaFacturas.addColumn("Servicio");
      this.tablaFacturas.addColumn("Cantidad");
      this.tablaFacturas.addColumn("Costo");
      this.tablaFacturas.addColumn("Subtotal");
      
      // configura el ancho de las columnas
      this.tablaFacturasExterna.getColumnModel().getColumn(0).setMinWidth(200);
      this.tablaFacturasExterna.getColumnModel().getColumn(0).setMaxWidth(200);
      this.tablaFacturasExterna.getColumnModel().getColumn(1).setMinWidth(100);
      this.tablaFacturasExterna.getColumnModel().getColumn(1).setMaxWidth(100);
      this.tablaFacturasExterna.getColumnModel().getColumn(2).setMinWidth(100);
      this.tablaFacturasExterna.getColumnModel().getColumn(2).setMaxWidth(100);
      this.tablaFacturasExterna.getColumnModel().getColumn(3).setMinWidth(100);
      this.tablaFacturasExterna.getColumnModel().getColumn(3).setMaxWidth(100);
   } // fin del método armarTabla
   
   public void cargarCampos(DTOFacturaPaciente dtoFactura){
      int fila = 0, col;
      String monto, subtotal;

      this.campoTextoNumFactura.setText(dtoFactura.getNumFactura() + "");
      this.campoTextoFecha.setText(ServiciosTiempo.getInstancia().dateToStringDDMMAAAA(dtoFactura.getFecha()));
      this.campoTextoNumFicha.setText(dtoFactura.getNroFicha() + "");
      this.campoTextoNombrePaciente.setText(dtoFactura.getNombrePaciente());
      this.campoTextoNombrePrestacion.setText(dtoFactura.getNombrePrestacion());
      String costoPrest = String.format("%.2f", dtoFactura.getCostoPrestacion());
      this.campoTextoCostoPrestacion.setText(costoPrest);
      String descuento = String.format("%.2f", dtoFactura.getDescuento());
      this.campoTextoCoseguro.setText(descuento);

      List<DTODetalleServicio> listaDetalle = dtoFactura.getDtoDetalle();
      
      this.tablaFacturas.setRowCount(listaDetalle.size());

      for(DTODetalleServicio dtoDetalle : listaDetalle){
         col = 0;
         this.tablaFacturas.setValueAt(dtoDetalle.getNombreServicio(), fila, col++);
         this.tablaFacturas.setValueAt(dtoDetalle.getCantidad(), fila, col++);
         monto = String.format("%.2f", dtoDetalle.getMonto());
         this.tablaFacturas.setValueAt(monto, fila, col++);
         subtotal = String.format("%.2f", dtoDetalle.getSubtotal());
         this.tablaFacturas.setValueAt(subtotal, fila++, col++);
      } // fin de for de llenado de la tabla de detalles de servicios especiales
      
      this.campoTextoTotal.setText(dtoFactura.getMonto() + "");
   } // fin del método cargarCampos
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonVolver;
    private javax.swing.JTextField campoTextoCoseguro;
    private javax.swing.JTextField campoTextoCostoPrestacion;
    private javax.swing.JTextField campoTextoFecha;
    private javax.swing.JTextField campoTextoNombrePaciente;
    private javax.swing.JTextField campoTextoNombrePrestacion;
    private javax.swing.JTextField campoTextoNumFactura;
    private javax.swing.JTextField campoTextoNumFicha;
    private javax.swing.JTextField campoTextoTotal;
    private javax.swing.JLabel etiquetaCoseguro;
    private javax.swing.JLabel etiquetaCostoPrestacion;
    private javax.swing.JLabel etiquetaFecha;
    private javax.swing.JLabel etiquetaNombrePaciente;
    private javax.swing.JLabel etiquetaNombrePrestacion;
    private javax.swing.JLabel etiquetaNumFactura;
    private javax.swing.JLabel etiquetaNumFicha;
    private javax.swing.JLabel etiquetaTotal;
    private javax.swing.JPanel panelDatosFactura;
    private javax.swing.JScrollPane scrollPaneServiciosEspeciales;
    private javax.swing.JTable tablaFacturasExterna;
    // End of variables declaration//GEN-END:variables
} // fin de la clase IUMonstrarFactura