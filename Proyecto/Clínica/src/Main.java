import generar_factura_paciente.IUGenerarFacturaPaciente;
import cobrar_factura_paciente.IUCobrarFacturaPaciente;

public class Main extends javax.swing.JFrame {
   public Main() {
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

        botonFacturarFicha = new javax.swing.JButton();
        botonCobrarFactura = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        botonFacturarFicha.setText("Facturar Ficha");
        botonFacturarFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFacturarFichaActionPerformed(evt);
            }
        });

        botonCobrarFactura.setText("Cobrar Factura");
        botonCobrarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCobrarFacturaActionPerformed(evt);
            }
        });

        jLabel1.setText("Clinica");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonCobrarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonFacturarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1)))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(botonFacturarFicha)
                .addGap(18, 18, 18)
                .addComponent(botonCobrarFactura)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void botonFacturarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFacturarFichaActionPerformed
      new IUGenerarFacturaPaciente().setVisible(true);
   }//GEN-LAST:event_botonFacturarFichaActionPerformed
   // fin del método botonFacturarFichaActionPerformed
   
   private void botonCobrarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCobrarFacturaActionPerformed
      new IUCobrarFacturaPaciente().setVisible(true);
   }//GEN-LAST:event_botonCobrarFacturaActionPerformed
   // fin del método botonCobrarFacturaActionPerformed
   
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
         java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {

         public void run() {
            new Main().setVisible(true);
         }
      });
   } // fin del método main
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCobrarFactura;
    private javax.swing.JButton botonFacturarFicha;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
} // fin de la clase Main