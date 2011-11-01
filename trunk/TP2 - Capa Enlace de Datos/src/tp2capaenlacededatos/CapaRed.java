// CapaRed: CapaRed.java
// 
package tp2capaenlacededatos;

import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class CapaRed extends javax.swing.JFrame {

    private static CapaRed capa;

    public static CapaRed getCapa() {
        if(capa == null)
            capa = new CapaRed();
        return capa;
    }
         
    /**
    * Inicializa los componentes de la interfaz.
    */
    public CapaRed(){
        initComponents();
        textAreaMsjRec.setEnabled(false);
        botonLimpia.setEnabled(false);
        this.setLocationRelativeTo(null);
    }
    
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textEnvioMsj = new javax.swing.JTextField();
        buttonEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaMsjRec = new javax.swing.JTextArea();
        labelMsjRec = new javax.swing.JLabel();
        botonLimpia = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textEnvioMsj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textEnvioMsjKeyTyped(evt);
            }
        });

        buttonEnviar.setText("Enviar");
        buttonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnviarActionPerformed(evt);
            }
        });

        textAreaMsjRec.setColumns(20);
        textAreaMsjRec.setRows(5);
        jScrollPane1.setViewportView(textAreaMsjRec);

        labelMsjRec.setText("Mensajes recibidos");

        botonLimpia.setText("Limpiar");
        botonLimpia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiaActionPerformed(evt);
            }
        });

        jLabel1.setText("TP2 CAPA DE ENLACE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textEnvioMsj, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(botonLimpia))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelMsjRec))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEnvioMsj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEnviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonLimpia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(labelMsjRec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void buttonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnviarActionPerformed
       String msj;
       char []paquete;
       
       if(textEnvioMsj.getText().isEmpty())
           msj = "mensaje por defecto";
       else
           msj = textEnvioMsj.getText();
       
       paquete = msj.toCharArray();
       CapaEnlace.getInstancia().enviarPaquetes(paquete);
       JOptionPane.showMessageDialog(rootPane, "Mensaje enviado:"+msj);
       
   }//GEN-LAST:event_buttonEnviarActionPerformed

    private void botonLimpiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiaActionPerformed
        textEnvioMsj.selectAll();
        textEnvioMsj.cut();
        textEnvioMsj.requestFocus();
        botonLimpia.setEnabled(false);
    }//GEN-LAST:event_botonLimpiaActionPerformed

    private void textEnvioMsjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEnvioMsjKeyTyped
        if(!textEnvioMsj.getText().isEmpty())
            botonLimpia.setEnabled(true);
        else 
            botonLimpia.setEnabled(false);
    }//GEN-LAST:event_textEnvioMsjKeyTyped

   public void recibirPaquete(char[] datos){
       for(char c: datos)
          this.textAreaMsjRec.append(String.valueOf(c));
   }
   
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
    private javax.swing.JButton botonLimpia;
    private javax.swing.JButton buttonEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMsjRec;
    private javax.swing.JTextArea textAreaMsjRec;
    private javax.swing.JTextField textEnvioMsj;
    // End of variables declaration//GEN-END:variables
} // fin de la clase CapaRed
