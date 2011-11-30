package stub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IUStub extends javax.swing.JFrame {
   private DefaultTableModel tabla;
   private static String bd = "clinica";
   private static String login = "fulltime";
   private static String password = "disenio";
   private static String host = "localhost";
   private static String url_bd = "jdbc:mysql://";
   private static String driver = "com.mysql.jdbc.Driver";
   private static Connection conexion;
   
   public IUStub() {
      tabla = new DefaultTableModel();
      initComponents();
      this.setLocationRelativeTo(null);
      armarTabla();      
   }
   
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNumFicha = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaExterna = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stub");
        setResizable(false);

        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("N° Ficha:");

        campoNumFicha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumFichaKeyTyped(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(campoNumFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNumFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(botonBuscar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tablaExterna.setModel(tabla);
        jScrollPane1.setViewportView(tablaExterna);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
      try {
      int numFicha = Integer.parseInt(this.campoNumFicha.getText());      
      cargarTabla(numFicha);
      } catch(NumberFormatException e){
         JOptionPane.showMessageDialog(rootPane, "Debe ingresar un número en el campo");
         System.err.print(e.getMessage());
         limpiarCampos();
      }
   }//GEN-LAST:event_botonBuscarActionPerformed

   private void campoNumFichaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumFichaKeyTyped
      int k = (int)evt.getKeyChar();
        if(k==10){
          java.awt.event.ActionEvent event = null;
          botonBuscarActionPerformed(event);
        }    
   }//GEN-LAST:event_campoNumFichaKeyTyped
 
   private void armarTabla(){
      // configura la cabecera de las columnas
      this.tabla.addColumn("Nº Ficha");
      this.tabla.addColumn("Estado Ficha");
      this.tabla.addColumn("Nº Factura");
      this.tabla.addColumn("Estado Factura");      
      this.tabla.addColumn("Nº Cama");
      this.tabla.addColumn("Estado Cama");      
      
      // configura el ancho de las columnas
      this.tablaExterna.getColumnModel().getColumn(0).setMinWidth(60);
      this.tablaExterna.getColumnModel().getColumn(0).setMaxWidth(50);
      this.tablaExterna.getColumnModel().getColumn(1).setMinWidth(90);
      this.tablaExterna.getColumnModel().getColumn(1).setMaxWidth(75);
      this.tablaExterna.getColumnModel().getColumn(2).setMinWidth(60);
      this.tablaExterna.getColumnModel().getColumn(2).setMaxWidth(50);
      this.tablaExterna.getColumnModel().getColumn(3).setMinWidth(90);
      this.tablaExterna.getColumnModel().getColumn(3).setMaxWidth(75);
      this.tablaExterna.getColumnModel().getColumn(4).setMinWidth(60);
      this.tablaExterna.getColumnModel().getColumn(4).setMaxWidth(50);
      this.tablaExterna.getColumnModel().getColumn(5).setMinWidth(90);
      this.tablaExterna.getColumnModel().getColumn(5).setMaxWidth(75);
   } // fin del método armarTablaFacturas
 
 public void cargarTabla(int numFicha) {
    limpiarCampos();
    try {
       conexion = DriverManager.getConnection(url_bd+host+"/"+bd,login,password);
       conexion.setAutoCommit(false);
       System.out.println("Se logro la conexion con la base de datos "+url_bd+host+"/"+bd+".");
       String sql = "SELECT `ficha_internacion`.`numero_ficha_internacion`"
                           + ",`estado_ficha_internacion`.`nombre_estado_ficha_internacion`, `cama`.`numero_cama`,"
                           + " `estado_cama`.`nombre_estado_cama` , `factura_paciente`.`numero_factura_paciente` ,"
                           + " `estado_factura_paciente`.`nombre_estado_factura_paciente` "
                  + "FROM `clinica`.`ficha_internacion` "       
                     + "LEFT JOIN `clinica`.`factura_paciente` ON (`factura_paciente`.`oidficha_internacion` = `ficha_internacion`.`oidficha_internacion`) "
                     + "LEFT JOIN `clinica`.`estado_factura_paciente`  ON (`factura_paciente`.`oidestado_factura_paciente` = `estado_factura_paciente`.`oidestado_factura_paciente`) "                     
                     + "LEFT JOIN `clinica`.`estado_ficha_internacion` ON (`ficha_internacion`.`oidestado_ficha_internacion` = `estado_ficha_internacion`.`oidestado_ficha_internacion`)"
                     + "RIGHT JOIN `clinica`.`cama` ON (`ficha_internacion`.`oidcama` = `cama`.`oidcama`) "
                     + "RIGHT JOIN `clinica`.`estado_cama` ON (`cama`.`oidestado_cama` = `estado_cama`.`oidestado_cama`) "
                     
                     
                    
                  + "WHERE (`ficha_internacion`.`numero_ficha_internacion` = '"+numFicha+"')";
       
       System.out.println(sql);
       PreparedStatement consulta = conexion.prepareStatement(sql);
       ResultSet rs = consulta.executeQuery(sql);
       int fila = 0,columna = 0;
       this.tabla.setRowCount(1);
       limpiarTabla();
       while(rs.next()) {
          this.tabla.setValueAt(rs.getInt("numero_ficha_internacion"), fila, columna++);
          this.tabla.setValueAt(rs.getString("nombre_estado_ficha_internacion"), fila, columna++);
          this.tabla.setValueAt(rs.getString("numero_factura_paciente"), fila, columna++);
          this.tabla.setValueAt(rs.getString("nombre_estado_factura_paciente"), fila, columna++);
          this.tabla.setValueAt(rs.getInt("numero_cama"), fila, columna++);
          this.tabla.setValueAt(rs.getString("nombre_estado_cama"), fila, columna);
       }
       
    }catch (SQLException e) {
      System.err.println ("Error: "+e.getMessage());
    }
      
 }
 
 private void limpiarCampos() {
       campoNumFicha.selectAll();
       campoNumFicha.cut();
       campoNumFicha.requestFocus();       
   }
 
 private void limpiarTabla(){
    int i;
    for(i=0;i<6;i++)
       tabla.setValueAt("", 0, i);
 }
 
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
       * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(IUStub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(IUStub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(IUStub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(IUStub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {

         @Override
         public void run() {
            new IUStub().setVisible(true);
         }
      });
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JTextField campoNumFicha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tablaExterna;
    // End of variables declaration//GEN-END:variables
}
