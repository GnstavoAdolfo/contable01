/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Tarea_plan;
import servicios.Conexion;
import servicios.Tareas_plan;
/**
 *
 * @author Master Kaizen - MK
 */
public class vista_guardar_plan extends javax.swing.JFrame {
    private final Tareas_plan tareas_plan = new Tareas_plan();
    private final Tarea_plan tarea_plan;
    /**
     * Creates new form vista_guardar_plan
     */
    public vista_guardar_plan() {
        this.tarea_plan = new Tarea_plan();
        initComponents();
    }
    
    public vista_guardar_plan(Tarea_plan p_tarea){
        this.tarea_plan = p_tarea;
        initComponents();
        //Integer elemento_id = this.tarea_plan.getA1();
        elemento_cuenta.setText(this.tarea_plan.getA2());
        elemento_descripcion.setText(this.tarea_plan.getA3());
        //System.out.println("Id=" + elemento_id);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        elemento_cuenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        elemento_descripcion = new javax.swing.JTextField();
        elemento_guardar = new javax.swing.JButton();
        elemento_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cuenta");

        jLabel2.setText("Descripcion");

        elemento_guardar.setText("Guardar");
        elemento_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elemento_guardarActionPerformed(evt);
            }
        });

        elemento_cancelar.setText("Cancelar");
        elemento_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elemento_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(elemento_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(elemento_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(elemento_guardar)
                        .addGap(18, 18, 18)
                        .addComponent(elemento_cancelar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(elemento_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(elemento_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento_guardar)
                    .addComponent(elemento_cancelar))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void elemento_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elemento_guardarActionPerformed
        // TODO add your handling code here:
        if(this.validar()){
                this.guardar();
        }else{
            JOptionPane.showMessageDialog(this, "Hay campos incompletos.");
        }
    }//GEN-LAST:event_elemento_guardarActionPerformed

    private void elemento_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elemento_cancelarActionPerformed
        // TODO add your handling code here:
        vista_guardar_plan.this.dispose();
        vista_plan vista = new vista_plan();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }//GEN-LAST:event_elemento_cancelarActionPerformed
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // TODO add your handling code here:
        try{
            Conexion.cerrar();
            System.out.println("Conexión cerrada.");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }                                  

    private boolean validar(){
        boolean validado = true;
        String cuenta = elemento_cuenta.getText();
        String descripcion = elemento_descripcion.getText();
        //String tipo;
        if(!cuenta.trim().equals("") && !descripcion.trim().equals("")){
            try{
                
            }catch(Exception ex){
                validado = false;
            }
        }else{
            validado = false;
        }
        return validado;
    }
    
    private void guardar(){
        String cuenta = elemento_cuenta.getText();
        String descripcion = elemento_descripcion.getText();
        
        //this.tarea_plan.setUno();
        this.tarea_plan.setA2(cuenta);
        this.tarea_plan.setA3(descripcion);

        try{
            this.tareas_plan.guardar(Conexion.obtener(), this.tarea_plan);
            vista_guardar_plan.this.dispose();
            vista_plan vista = new vista_plan();
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(vista_guardar_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_guardar_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_guardar_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_guardar_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista_guardar_plan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton elemento_cancelar;
    private javax.swing.JTextField elemento_cuenta;
    private javax.swing.JTextField elemento_descripcion;
    private javax.swing.JButton elemento_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
