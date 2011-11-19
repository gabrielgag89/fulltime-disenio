package generar_factura_paciente;

import dtos.DTODetalleServicio;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import dtos.DTOFichaInternacion;
import javax.swing.JOptionPane;
import util.ServiciosTiempo;

public class IUGenerarFacturaPaciente extends javax.swing.JFrame {
   private DefaultTableModel tablaFichas;
   private ControladorGenerarFacturaPaciente controlador;
   
   public IUGenerarFacturaPaciente() {
      this.tablaFichas = new DefaultTableModel();
      initComponents();
      this.setLocationRelativeTo(null);
      disableControls();
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

      etiqueteNumFicha = new javax.swing.JLabel();
      botonBuscarFicha = new javax.swing.JButton();
      botonGenerarFactura = new javax.swing.JButton();
      campoTextoNumFicha = new javax.swing.JTextField();
      botonMostrarFicha = new javax.swing.JButton();
      panelDatosFicha = new javax.swing.JPanel();
      etiquetaNumPaciente = new javax.swing.JLabel();
      etiquetaNombrePaciente = new javax.swing.JLabel();
      etiquetaNombrePrestacion = new javax.swing.JLabel();
      etiquetaCostoPrestacion = new javax.swing.JLabel();
      etiquetaCoseguro = new javax.swing.JLabel();
      etiquetaFecha = new javax.swing.JLabel();
      campoTextoFecha = new javax.swing.JTextField();
      campoTextoNumPaciente = new javax.swing.JTextField();
      campoTextoNombrePaciente = new javax.swing.JTextField();
      campoTextoNombrePrestacion = new javax.swing.JTextField();
      campoTextoCostoPrestacion = new javax.swing.JTextField();
      campoTextoCoseguro = new javax.swing.JTextField();
      scrollPaneServiciosEspeciales = new javax.swing.JScrollPane();
      tablaFichasExterna = new javax.swing.JTable();
      botonVolver = new javax.swing.JButton();

      setResizable(false);

      etiqueteNumFicha.setText("Nº Ficha Internacion:");

      botonBuscarFicha.setText("...");

      botonGenerarFactura.setText("Generar Factura");
      botonGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonGenerarFacturaActionPerformed(evt);
         }
      });

      botonMostrarFicha.setText("Mostrar Ficha");
      botonMostrarFicha.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonMostrarFichaActionPerformed(evt);
         }
      });

      panelDatosFicha.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Ficha"));

      etiquetaNumPaciente.setText("Nº Paciente:");

      etiquetaNombrePaciente.setText("Nombre Paciente:");

      etiquetaNombrePrestacion.setText("Prestación:");

      etiquetaCostoPrestacion.setText("Costo Prestación:");

      etiquetaCoseguro.setText("Coseguro:");

      etiquetaFecha.setText("Fecha:");

      javax.swing.GroupLayout panelDatosFichaLayout = new javax.swing.GroupLayout(panelDatosFicha);
      panelDatosFicha.setLayout(panelDatosFichaLayout);
      panelDatosFichaLayout.setHorizontalGroup(
         panelDatosFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelDatosFichaLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelDatosFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(etiquetaFecha)
               .addComponent(etiquetaCoseguro)
               .addComponent(etiquetaCostoPrestacion)
               .addComponent(etiquetaNombrePrestacion)
               .addComponent(etiquetaNumPaciente)
               .addComponent(etiquetaNombrePaciente))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(panelDatosFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(campoTextoCoseguro)
               .addComponent(campoTextoCostoPrestacion)
               .addComponent(campoTextoNombrePrestacion)
               .addComponent(campoTextoNombrePaciente)
               .addComponent(campoTextoNumPaciente)
               .addComponent(campoTextoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      panelDatosFichaLayout.setVerticalGroup(
         panelDatosFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelDatosFichaLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelDatosFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(etiquetaFecha)
               .addComponent(campoTextoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelDatosFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(etiquetaNumPaciente)
               .addComponent(campoTextoNumPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelDatosFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(etiquetaNombrePaciente)
               .addComponent(campoTextoNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelDatosFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(etiquetaNombrePrestacion)
               .addComponent(campoTextoNombrePrestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelDatosFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(etiquetaCostoPrestacion)
               .addComponent(campoTextoCostoPrestacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(panelDatosFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(etiquetaCoseguro)
               .addComponent(campoTextoCoseguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      scrollPaneServiciosEspeciales.setBorder(javax.swing.BorderFactory.createTitledBorder("Servicios Especiales"));

      tablaFichasExterna.setModel(tablaFichas);
      scrollPaneServiciosEspeciales.setViewportView(tablaFichasExterna);

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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addComponent(botonGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(scrollPaneServiciosEspeciales, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                     .addComponent(panelDatosFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addContainerGap())
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(etiqueteNumFicha)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                     .addComponent(botonMostrarFicha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                     .addComponent(campoTextoNumFicha, javax.swing.GroupLayout.Alignment.LEADING))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(botonBuscarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(109, 109, 109))))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(campoTextoNumFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(etiqueteNumFicha)
               .addComponent(botonBuscarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(botonMostrarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panelDatosFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(scrollPaneServiciosEspeciales, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(botonVolver)
               .addComponent(botonGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(13, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void botonMostrarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarFichaActionPerformed
      try{
         int numFicha = Integer.parseInt(this.campoTextoNumFicha.getText());
         
         DTOFichaInternacion fichaInt = this.controlador.buscarFicha(numFicha);
         
         if(fichaInt != null){
            enableControls();
            cargarCampos(fichaInt);
         } // fin de if de carga de campos
         else
            JOptionPane.showMessageDialog(null, "La ficha ingresada no existe");
      } // fin de try de error de formato
      catch(NumberFormatException ex){
         JOptionPane.showMessageDialog(null, "Debe ingresar un número en el campo \"Nº Ficha Internacion:\"");
      } // fin de catch de error de formato
   }//GEN-LAST:event_botonMostrarFichaActionPerformed
   // fin del método botonMostrarFichaActionPerformed
   
   private void botonGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarFacturaActionPerformed
      this.controlador.generarFactura();
   }//GEN-LAST:event_botonGenerarFacturaActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botonVolverActionPerformed
   // fin del método botonGenerarFacturaActionPerformed
   
   private void disableControls(){
      // deshabilita los campos del panel de datos de la ficha
      this.panelDatosFicha.setEnabled(false);
      this.campoTextoFecha.setEnabled(false);
      this.campoTextoNumPaciente.setEnabled(false);
      this.campoTextoNombrePaciente.setEnabled(false);
      this.campoTextoNombrePrestacion.setEnabled(false);
      this.campoTextoCostoPrestacion.setEnabled(false);
      this.campoTextoCoseguro.setEnabled(false);
      
      // deshabilita la tabla de detalles de servicios especiales
      this.tablaFichasExterna.setEnabled(false);
      
      // deshabilita el botón para generar la factura
      this.botonGenerarFactura.setEnabled(false);
   } // fin del método disableControls
   
   private void enableControls(){
      // habilita los campos del panel de datos de la ficha
      this.panelDatosFicha.setEnabled(true);
      this.campoTextoFecha.setEnabled(true);
      this.campoTextoNumPaciente.setEnabled(true);
      this.campoTextoNombrePaciente.setEnabled(true);
      this.campoTextoNombrePrestacion.setEnabled(true);
      this.campoTextoCostoPrestacion.setEnabled(true);
      this.campoTextoCoseguro.setEnabled(true);
      
      // habilita la tabla de detalles de servicios especiales
      this.tablaFichasExterna.setEnabled(true);
      
      // habilita el botón para generar la factura
      this.botonGenerarFactura.setEnabled(true);
   } // fin del método enableControls
   
   private void armarTabla(){
      // crea las columnas de la tabla
      this.tablaFichas.addColumn("Servicio");
      this.tablaFichas.addColumn("Cantidad");
      this.tablaFichas.addColumn("Costo");
      this.tablaFichas.addColumn("Subtotal");
      
      // configura el ancho de las columnas
      this.tablaFichasExterna.getColumnModel().getColumn(0).setMinWidth(200);
      this.tablaFichasExterna.getColumnModel().getColumn(0).setMaxWidth(200);
      this.tablaFichasExterna.getColumnModel().getColumn(1).setMinWidth(100);
      this.tablaFichasExterna.getColumnModel().getColumn(1).setMaxWidth(100);
      this.tablaFichasExterna.getColumnModel().getColumn(2).setMinWidth(100);
      this.tablaFichasExterna.getColumnModel().getColumn(2).setMaxWidth(100);
      this.tablaFichasExterna.getColumnModel().getColumn(3).setMinWidth(100);
      this.tablaFichasExterna.getColumnModel().getColumn(3).setMaxWidth(100);
   } // fin del método armarTabla
   
   private void cargarCampos(DTOFichaInternacion fichaInt){
      int fila = 0, col;

      this.campoTextoFecha.setText(ServiciosTiempo.dateToStringDDMMAAAA(fichaInt.getFecha()));
      this.campoTextoNumPaciente.setText(fichaInt.getNumPaciente() + "");
      this.campoTextoNombrePaciente.setText(fichaInt.getNombrePaciente());
      this.campoTextoNombrePrestacion.setText(fichaInt.getNombrePrestacion());
      this.campoTextoCostoPrestacion.setText(fichaInt.getCostoPrestacion() + "");
      this.campoTextoCoseguro.setText(fichaInt.getDescuento() + "");

      List<DTODetalleServicio> listaDetalle = fichaInt.getDtoDetalle();

      for(DTODetalleServicio dtoDetalle : listaDetalle){
         col = 0;
         this.tablaFichas.setValueAt(dtoDetalle.getNombreServicio(), fila, col++);
         this.tablaFichas.setValueAt(dtoDetalle.getCantidad(), fila, col++);
         this.tablaFichas.setValueAt(dtoDetalle.getMonto(), fila, col++);
         this.tablaFichas.setValueAt(dtoDetalle.getSubtotal(), fila, col++);
      } // fin de for de llenado de la tabla de detalles de servicios especiales
   } // fin del método cargarCampos
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton botonBuscarFicha;
   private javax.swing.JButton botonGenerarFactura;
   private javax.swing.JButton botonMostrarFicha;
   private javax.swing.JButton botonVolver;
   private javax.swing.JTextField campoTextoCoseguro;
   private javax.swing.JTextField campoTextoCostoPrestacion;
   private javax.swing.JTextField campoTextoFecha;
   private javax.swing.JTextField campoTextoNombrePaciente;
   private javax.swing.JTextField campoTextoNombrePrestacion;
   private javax.swing.JTextField campoTextoNumFicha;
   private javax.swing.JTextField campoTextoNumPaciente;
   private javax.swing.JLabel etiquetaCoseguro;
   private javax.swing.JLabel etiquetaCostoPrestacion;
   private javax.swing.JLabel etiquetaFecha;
   private javax.swing.JLabel etiquetaNombrePaciente;
   private javax.swing.JLabel etiquetaNombrePrestacion;
   private javax.swing.JLabel etiquetaNumPaciente;
   private javax.swing.JLabel etiqueteNumFicha;
   private javax.swing.JPanel panelDatosFicha;
   private javax.swing.JScrollPane scrollPaneServiciosEspeciales;
   private javax.swing.JTable tablaFichasExterna;
   // End of variables declaration//GEN-END:variables
} // fin de la clase IUGenerarFacturaPaciente