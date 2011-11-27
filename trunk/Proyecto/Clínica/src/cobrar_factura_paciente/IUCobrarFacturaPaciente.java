package cobrar_factura_paciente;

import java.util.List;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.table.DefaultTableModel;
import dtos.DTOFacturaPaciente;
import util.ServiciosTiempo;

public class IUCobrarFacturaPaciente extends javax.swing.JFrame {
   private DefaultTableModel tablaFacturas;
   private ControladorCobrarFacturaPaciente controlador;
   private int seleccion;
   
   public IUCobrarFacturaPaciente(ControladorCobrarFacturaPaciente controlador) {
      // crea la tabla personalizada
      tablaFacturas = new DefaultTableModel();
      initComponents();
      this.setLocationRelativeTo(null);
      // guarda la referencia al controlador
      this.controlador = controlador;
      // arma la tabla
      armarTablaFacturas();
      // carga la tabla
      cargarFacturas();
   } // fin del constructor

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneTablaFacturas = new javax.swing.JScrollPane();
        tablaFacturasExterna = new javax.swing.JTable();
        botonCobrar = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();

        setTitle("Facturas a Cobrar");
        setResizable(false);

        scrollPaneTablaFacturas.setEnabled(false);
        scrollPaneTablaFacturas.setWheelScrollingEnabled(false);

        tablaFacturasExterna.setModel(tablaFacturas);
        tablaFacturasExterna.setEnabled(false);
        scrollPaneTablaFacturas.setViewportView(tablaFacturasExterna);

        botonCobrar.setText("Cobrar");
        botonCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCobrarActionPerformed(evt);
            }
        });

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
                .addComponent(scrollPaneTablaFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(botonVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                .addComponent(botonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneTablaFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVolver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void botonCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCobrarActionPerformed
      if(this.seleccion == -1 || this.seleccion >= this.tablaFacturas.getRowCount()){
         JOptionPane.showMessageDialog(null, "Debe seleccionar una factura");
      } // fub de if de comprobación de selección de fila
      else{
         int numFactura = Integer.parseInt(this.tablaFacturas.getValueAt(seleccion, 0).toString());
         this.controlador.cobrarFactura(numFactura);
         cargarFacturas();
      } // fin de else de comprobación de selección de fila
   }//GEN-LAST:event_botonCobrarActionPerformed
   // fin del método botonCobrarActionPerformed
   
   private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
      this.setVisible(false);
   }//GEN-LAST:event_botonVolverActionPerformed
   // fin del método botonVolverActionPerformed
   
   private void armarTablaFacturas(){
      // configura la cabecera de las columnas
      this.tablaFacturas.addColumn("Nº Factura");
      this.tablaFacturas.addColumn("Fecha");
      this.tablaFacturas.addColumn("Nº Ficha");
      this.tablaFacturas.addColumn("Paciente");
      this.tablaFacturas.addColumn("Prestación");
      this.tablaFacturas.addColumn("Monto");
      
      // configura el ancho de las columnas
      this.tablaFacturasExterna.getColumnModel().getColumn(0).setMinWidth(75);
      this.tablaFacturasExterna.getColumnModel().getColumn(0).setMaxWidth(75);
      this.tablaFacturasExterna.getColumnModel().getColumn(1).setMinWidth(75);
      this.tablaFacturasExterna.getColumnModel().getColumn(1).setMaxWidth(75);
      this.tablaFacturasExterna.getColumnModel().getColumn(2).setMinWidth(75);
      this.tablaFacturasExterna.getColumnModel().getColumn(2).setMaxWidth(75);
      this.tablaFacturasExterna.getColumnModel().getColumn(3).setMinWidth(150);
      this.tablaFacturasExterna.getColumnModel().getColumn(3).setMaxWidth(150);
      this.tablaFacturasExterna.getColumnModel().getColumn(4).setMinWidth(150);
      this.tablaFacturasExterna.getColumnModel().getColumn(4).setMaxWidth(150);
      this.tablaFacturasExterna.getColumnModel().getColumn(5).setMinWidth(75);
      this.tablaFacturasExterna.getColumnModel().getColumn(5).setMaxWidth(75);
   } // fin del método armarTablaFacturas
   
   public void cargarFacturas(){
      List<DTOFacturaPaciente> listaFacturas = this.controlador.buscarFacturasPacientes();
      int fila = 0, col;
      this.seleccion = -1;
      this.tablaFacturas.setRowCount(listaFacturas.size());
      String monto;
      
      for(DTOFacturaPaciente dtoFactura : listaFacturas){
         col = 0;
         this.tablaFacturas.setValueAt(dtoFactura.getNumFactura(), fila, col++);
         this.tablaFacturas.setValueAt(ServiciosTiempo.getInstancia().dateToStringDDMMAAAA(dtoFactura.getFecha()), fila, col++);
         this.tablaFacturas.setValueAt(dtoFactura.getNroFicha(), fila, col++);
         this.tablaFacturas.setValueAt(dtoFactura.getNombrePaciente(), fila, col++);
         this.tablaFacturas.setValueAt(dtoFactura.getNombrePrestacion(), fila, col++);
         monto = String.format("%.2f", dtoFactura.getMonto());
         this.tablaFacturas.setValueAt(monto, fila, col++);
         fila++;
      } // fin de for de llenado de la tabla de facturas
      
      this.tablaFacturasExterna.addMouseListener(new MouseAdapter(){
         @Override
         public void mouseClicked(MouseEvent e){
            seleccion = tablaFacturasExterna.rowAtPoint(e.getPoint());
            tablaFacturas.isCellEditable(seleccion, 0);
         } // fin del método mouseClicked
      });
   } // fin del método cargarFacturas
   
   public void actualizar(DTOFacturaPaciente dtoFactura){
      int col = 0,
          fila = this.tablaFacturas.getRowCount();
      this.tablaFacturas.setRowCount(this.tablaFacturas.getRowCount() + 1);
      
      this.tablaFacturas.setValueAt(dtoFactura.getNumFactura(), fila, col++);
      this.tablaFacturas.setValueAt(ServiciosTiempo.getInstancia().dateToStringDDMMAAAA(dtoFactura.getFecha()), fila, col++);
      this.tablaFacturas.setValueAt(dtoFactura.getNroFicha(), fila, col++);
      this.tablaFacturas.setValueAt(dtoFactura.getNombrePaciente(), fila, col++);
      this.tablaFacturas.setValueAt(dtoFactura.getNombrePrestacion(), fila, col++);
      String monto = String.format("%.2f", dtoFactura.getMonto());
      this.tablaFacturas.setValueAt(monto, fila, col++);
   } // fin del método actualizar
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCobrar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JScrollPane scrollPaneTablaFacturas;
    private javax.swing.JTable tablaFacturasExterna;
    // End of variables declaration//GEN-END:variables
} // fin de la clase IUCobrarFacturaPaciente