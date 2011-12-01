package generar_factura_paciente;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dtos.DTOFichaInternacion;
import dtos.DTODetalleServicio;
import util.ServiciosTiempo;

public class IUGenerarFacturaPaciente extends javax.swing.JFrame {
   private DefaultTableModel tablaFichas;
   private ControladorGenerarFacturaPaciente controlador;
   
   public IUGenerarFacturaPaciente(ControladorGenerarFacturaPaciente controlador) {
      // crea la tabla para los detalles
      this.tablaFichas = new DefaultTableModel();
      // inicializa los componentes de la GUI
      initComponents();
      // centra la GUI en la pantalla
      this.setLocationRelativeTo(null);
      // crea el controlador con el que se comunicará laa GUI y lo guarda en una variable de instancia
      this.controlador = controlador;
      // arma la cabecera de la tabla
      armarTabla();
      // deshabilita los controles
      disableControls();
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
        botonMostrarFichasPendientes = new javax.swing.JButton();

        setTitle("Generar Factura Paciente");
        setResizable(false);

        etiqueteNumFicha.setText("Nº Ficha Internacion:");

        botonGenerarFactura.setText("Generar Factura");
        botonGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarFacturaActionPerformed(evt);
            }
        });

        campoTextoNumFicha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoTextoNumFicha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTextoNumFichaKeyTyped(evt);
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

        campoTextoFecha.setEditable(false);
        campoTextoFecha.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoNumPaciente.setEditable(false);
        campoTextoNumPaciente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoNombrePaciente.setEditable(false);
        campoTextoNombrePaciente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoNombrePrestacion.setEditable(false);
        campoTextoNombrePrestacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoCostoPrestacion.setEditable(false);
        campoTextoCostoPrestacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTextoCoseguro.setEditable(false);
        campoTextoCoseguro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

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
                .addContainerGap(62, Short.MAX_VALUE))
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
        scrollPaneServiciosEspeciales.setFocusable(false);
        scrollPaneServiciosEspeciales.setRequestFocusEnabled(false);

        tablaFichasExterna.setModel(tablaFichas);
        tablaFichasExterna.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaFichasExterna.setEnabled(false);
        tablaFichasExterna.setFocusable(false);
        tablaFichasExterna.setRequestFocusEnabled(false);
        tablaFichasExterna.setRowSelectionAllowed(false);
        scrollPaneServiciosEspeciales.setViewportView(tablaFichasExterna);

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        botonMostrarFichasPendientes.setText("...");
        botonMostrarFichasPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarFichasPendientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelDatosFicha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollPaneServiciosEspeciales, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiqueteNumFicha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonMostrarFicha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoTextoNumFicha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonMostrarFichasPendientes)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueteNumFicha)
                    .addComponent(campoTextoNumFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMostrarFichasPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(botonMostrarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatosFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneServiciosEspeciales, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVolver)
                    .addComponent(botonGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void botonMostrarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarFichaActionPerformed
      try{
         // toma el número de ficha ingresado
         int numFicha = Integer.parseInt(this.campoTextoNumFicha.getText());
         
         // busca los datos de la ficha para mostrarlos en la GUI
         DTOFichaInternacion fichaInt = this.controlador.buscarFichaInternacion(numFicha);
         
         // comprueba que la ficha se haya encontrado
         if(fichaInt != null){
            // habilita los controles
            enableControls();
            // llena los campos con los datos de la ficha
            cargarCampos(fichaInt);
         } // fin de if de carga de campos
         else{
            JOptionPane.showMessageDialog(null, "La ficha ingresada no existe o ya se ha facturado");
            this.campoTextoNumFicha.setText("");
            // deshabilita los controles
            disableControls();
         } // fin de else de inexistencia de la ficha
      } // fin de try de error de formato
      catch(NumberFormatException ex){
         //JOptionPane.showMessageDialog(null, "Debe ingresar un número en el campo \"Nº Ficha Internacion:\"");
         this.campoTextoNumFicha.setText("");
         botonMostrarFichasPendientesActionPerformed(null);
         // deshabilita los controles
         disableControls();
      } // fin de catch de error de formato
   }//GEN-LAST:event_botonMostrarFichaActionPerformed
   // fin del método botonMostrarFichaActionPerformed
   
   private void botonGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarFacturaActionPerformed
      // oculta la ventana
      this.setVisible(false);
      // se genera la factura sobre la ficha ingresada
      this.controlador.generarFactura();
   }//GEN-LAST:event_botonGenerarFacturaActionPerformed
   // fin del método botonGenerarFacturaActionPerformed
   
    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
       // oculta la ventana
       this.setVisible(false);
    }//GEN-LAST:event_botonVolverActionPerformed
   // fin del método botonVolverActionPerformed
    
    private void botonMostrarFichasPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarFichasPendientesActionPerformed
       this.controlador.buscarFichasPendientes();
    }//GEN-LAST:event_botonMostrarFichasPendientesActionPerformed
   // fin del método botonMostrarFichasPendientesActionPerformed
    
   private void campoTextoNumFichaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoNumFichaKeyTyped
      if((int)evt.getKeyChar()== '\n')
         botonMostrarFichaActionPerformed(null);
   }//GEN-LAST:event_campoTextoNumFichaKeyTyped
   // fin del método campoTextoNumFichaKeyTyped
   
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
      this.scrollPaneServiciosEspeciales.setEnabled(false);
      
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
      this.scrollPaneServiciosEspeciales.setEnabled(true);
      
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
      // se declaran variables utilizadas para las posiciones de la tabla a llenar
      int fila = 0, col;
      String monto, subtotal;

      // se cargan los campos de texto de la GUI en base a los datos recibidos en el DTO de la ficha
      this.campoTextoFecha.setText(ServiciosTiempo.getInstancia().dateToStringDDMMAAAA(fichaInt.getFecha()));
      this.campoTextoNumPaciente.setText(fichaInt.getNumPaciente() + "");
      this.campoTextoNombrePaciente.setText(fichaInt.getNombrePaciente());
      this.campoTextoNombrePrestacion.setText(fichaInt.getNombrePrestacion());
      String costo = String.format("%.2f", fichaInt.getCostoPrestacion());
      this.campoTextoCostoPrestacion.setText(costo);
      String coseguro = String.format("%.2f", fichaInt.getDescuento());
      this.campoTextoCoseguro.setText(coseguro);
      
      // se toma la lista de DTOs de detalles del DTO de la ficha
      List<DTODetalleServicio> listaDetalle = fichaInt.getDtoDetalle();
      
      // se configura la cantidad de filas de la tabla respecto al número de detalles a colocar
      this.tablaFichas.setRowCount(listaDetalle.size());
      
      // se cargan las filas de la tabla con los datos de la lista de DTOs de detalles
      for(DTODetalleServicio dtoDetalle : listaDetalle){
         col = 0;
         this.tablaFichas.setValueAt(dtoDetalle.getNombreServicio(), fila, col++);
         this.tablaFichas.setValueAt(dtoDetalle.getCantidad(), fila, col++);
         monto = String.format("%.2f", dtoDetalle.getMonto());
         this.tablaFichas.setValueAt(monto, fila, col++);
         subtotal = String.format("%.2f", dtoDetalle.getSubtotal());
         this.tablaFichas.setValueAt(subtotal, fila++, col++);
      } // fin de for de llenado de la tabla de detalles de servicios especiales
   } // fin del método cargarCampos
   
   public void cargaNumFicha(int numFicha){
      this.campoTextoNumFicha.setText(numFicha + "");
   } // fin del método cargaNumFicha
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGenerarFactura;
    private javax.swing.JButton botonMostrarFicha;
    private javax.swing.JButton botonMostrarFichasPendientes;
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