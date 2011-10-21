// CapaRed: CapaRed.java
// 
package tp2capaenlacededatos;

/**
 *
 * @author gabriel
 */
public class CapaRed extends javax.swing.JFrame {

   /**
    * Inicializa los componentes de la interfaz.
    */
   public CapaRed() {
      initComponents();
   } // fin de CapaRed

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxRxTx = new javax.swing.JComboBox();
        textEnvioMsj = new javax.swing.JTextField();
        buttonEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaMsjRec = new javax.swing.JTextArea();
        labelMsjRec = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboBoxRxTx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Emisor", "Receptor" }));
        comboBoxRxTx.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboBoxRxTxPropertyChange(evt);
            }
        });

        buttonEnviar.setText("Enviar");

        textAreaMsjRec.setColumns(20);
        textAreaMsjRec.setRows(5);
        jScrollPane1.setViewportView(textAreaMsjRec);

        labelMsjRec.setText("Mensaje recibido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMsjRec)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboBoxRxTx, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(textEnvioMsj, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(buttonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxRxTx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEnvioMsj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEnviar))
                .addGap(30, 30, 30)
                .addComponent(labelMsjRec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void comboBoxRxTxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboBoxRxTxPropertyChange
       int tipo; //0 emisor  o 1 receptor
       tipo = comboBoxRxTx.getSelectedIndex();
       if(tipo == 1){
           textEnvioMsj.setEnabled(false);
           buttonEnviar.setEnabled(false);
       }else {
           textEnvioMsj.setEnabled(true);
           buttonEnviar.setEnabled(true);
           textEnvioMsj.requestFocus();
       }
   }//GEN-LAST:event_comboBoxRxTxPropertyChange

   /**
    * Método principal de la interfaz.
    * @param args argumentos de la línea de comandos
    */
   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {

         public void run() {
            new CapaRed().setVisible(true);
         }
      });
   } // fin de main
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEnviar;
    private javax.swing.JComboBox comboBoxRxTx;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMsjRec;
    private javax.swing.JTextArea textAreaMsjRec;
    private javax.swing.JTextField textEnvioMsj;
    // End of variables declaration//GEN-END:variables
} // fin de la clase CapaRed
