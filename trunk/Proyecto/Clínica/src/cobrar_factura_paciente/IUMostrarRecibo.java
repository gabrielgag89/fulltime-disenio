package cobrar_factura_paciente;

import util.ServiciosTiempo;
import dtos.DTORecibo;

public class IUMostrarRecibo extends javax.swing.JFrame {
   public IUMostrarRecibo() {
      initComponents();
      this.setLocationRelativeTo(null);
   } // fin del constructor

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosRecibo = new javax.swing.JPanel();
        campoTextoFecha = new javax.swing.JTextField();
        etiquetaFecha = new javax.swing.JLabel();
        campoTextoFacturaNum = new javax.swing.JTextField();
        etiquetaFacturaNum = new javax.swing.JLabel();
        etiquetaMonto = new javax.swing.JLabel();
        campoTextoReciboNum = new javax.swing.JTextField();
        campoTextoMonto = new javax.swing.JTextField();
        etiquetaReciboNum = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();

        setTitle("Recibo");

        panelDatosRecibo.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Recibo"));

        campoTextoFecha.setBackground(new java.awt.Color(255, 255, 255));
        campoTextoFecha.setEditable(false);
        campoTextoFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        etiquetaFecha.setText("Fecha:");

        campoTextoFacturaNum.setBackground(new java.awt.Color(255, 255, 255));
        campoTextoFacturaNum.setEditable(false);
        campoTextoFacturaNum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        etiquetaFacturaNum.setText("Factura Nº:");

        etiquetaMonto.setText("Monto:");

        campoTextoReciboNum.setBackground(new java.awt.Color(255, 255, 255));
        campoTextoReciboNum.setEditable(false);
        campoTextoReciboNum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoMonto.setBackground(new java.awt.Color(255, 255, 255));
        campoTextoMonto.setEditable(false);
        campoTextoMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        etiquetaReciboNum.setText("Recibo Nº:");

        javax.swing.GroupLayout panelDatosReciboLayout = new javax.swing.GroupLayout(panelDatosRecibo);
        panelDatosRecibo.setLayout(panelDatosReciboLayout);
        panelDatosReciboLayout.setHorizontalGroup(
            panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosReciboLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosReciboLayout.createSequentialGroup()
                        .addGroup(panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiquetaFecha)
                            .addComponent(etiquetaReciboNum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoTextoFecha)
                            .addComponent(campoTextoReciboNum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDatosReciboLayout.createSequentialGroup()
                        .addGroup(panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiquetaMonto)
                            .addComponent(etiquetaFacturaNum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(campoTextoFacturaNum))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosReciboLayout.setVerticalGroup(
            panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosReciboLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaReciboNum)
                    .addComponent(campoTextoReciboNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaFecha)
                    .addComponent(campoTextoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaFacturaNum)
                    .addComponent(campoTextoFacturaNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaMonto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatosRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelDatosRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
      // oculta la ventana
      this.setVisible(false);
   }//GEN-LAST:event_botonVolverActionPerformed
   // fin del método botonVolverActionPerformed
   
   public void cargarCampos(DTORecibo dtoRecibo){
      // carga los campos de texto en la GUI con los datos del DTO de recibo recibido
      campoTextoReciboNum.setText(dtoRecibo.getNroRecibo() + "");
      campoTextoFecha.setText(ServiciosTiempo.getInstancia().dateToStringDDMMAAAA(dtoRecibo.getFecha()));
      campoTextoFacturaNum.setText(dtoRecibo.getNumFactura() + "");
      String monto = String.format("%.2f", dtoRecibo.getMonto());
      campoTextoMonto.setText(monto);
   } // fin del método cargarCampos
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonVolver;
    private javax.swing.JTextField campoTextoFacturaNum;
    private javax.swing.JTextField campoTextoFecha;
    private javax.swing.JTextField campoTextoMonto;
    private javax.swing.JTextField campoTextoReciboNum;
    private javax.swing.JLabel etiquetaFacturaNum;
    private javax.swing.JLabel etiquetaFecha;
    private javax.swing.JLabel etiquetaMonto;
    private javax.swing.JLabel etiquetaReciboNum;
    private javax.swing.JPanel panelDatosRecibo;
    // End of variables declaration//GEN-END:variables
} // fin de la clase IUMostrarRecibo