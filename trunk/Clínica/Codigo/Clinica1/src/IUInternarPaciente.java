


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class IUInternarPaciente extends javax.swing.JFrame {

  
   public IUInternarPaciente() {
      initComponents();
   }

  
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      dni = new javax.swing.JTextField();
      buscar = new javax.swing.JButton();
      salir = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
      jLabel1.setText("Internar Paciente");

      buscar.setText("Buscar");
      buscar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            buscarActionPerformed(evt);
         }
      });

      salir.setText("Salir");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(142, 142, 142)
                  .addComponent(jLabel1))
               .addGroup(layout.createSequentialGroup()
                  .addGap(70, 70, 70)
                  .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(buscar))
               .addGroup(layout.createSequentialGroup()
                  .addGap(58, 58, 58)
                  .addComponent(salir)))
            .addContainerGap(124, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(45, 45, 45)
            .addComponent(jLabel1)
            .addGap(40, 40, 40)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(buscar))
            .addGap(58, 58, 58)
            .addComponent(salir)
            .addContainerGap(89, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
      ControladorInternarPaciente controlador = new ControladorInternarPaciente();
      try {
         DtoPaciente dto = controlador.buscarPaciente(dni.getText());
         //tenemos que mostrar en pantalla
         JOptionPane.showMessageDialog(rootPane, "Dni:"+dto.getDni()+"\n"+"Nombre:"
                 +dto.getNombre()+"\n"+"Telefono:"+dto.getTel());
      } catch (SQLException ex) {
         Logger.getLogger(IUInternarPaciente.class.getName()).log(Level.SEVERE, null, ex);
      }
   }//GEN-LAST:event_buscarActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {

         @Override
         public void run() {
            new IUInternarPaciente().setVisible(true);
         }
      });
   }
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton buscar;
   private javax.swing.JTextField dni;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JButton salir;
   // End of variables declaration//GEN-END:variables
}
