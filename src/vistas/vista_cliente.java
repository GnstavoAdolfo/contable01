/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Tarea;
import servicios.Conexion;
import servicios.Tareas_servicio;
/**
 *
 * @author Master Kaizen - MK
 */
public class vista_cliente extends javax.swing.JFrame {
    
    private final Tareas_servicio tareas_servicio = new Tareas_servicio();
    private List<Tarea> tareas;
    /**
     * Creates new form vista_cliente
     */
    public vista_cliente() {
        initComponents();
        this.cargar_lista_de_tareas();
    }
    
    private void cargar_lista_de_tareas(){
        try{
            this.tareas = this.tareas_servicio.recuperarTodas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) elemento_tabla.getModel();
            dtm.setRowCount(0);
            for(int i = 0; i < this.tareas.size(); i++){
                dtm.addRow(new Object[]{
                    this.tareas.get(i).getUno(),
                    this.tareas.get(i).getDos(),
                    this.tareas.get(i).getTres(),
                    this.tareas.get(i).getCuatro(),
                    this.tareas.get(i).getCinco()
                });
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        elemento_tabla = new javax.swing.JTable();
        elemento_crear = new javax.swing.JButton();
        elemento_modificar = new javax.swing.JButton();
        elemento_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        elemento_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "DNI/RUC", "Nombre/R. Social", "Estado", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(elemento_tabla);

        elemento_crear.setText("Crear");
        elemento_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elemento_crearActionPerformed(evt);
            }
        });

        elemento_modificar.setText("Modificar");
        elemento_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elemento_modificarActionPerformed(evt);
            }
        });

        elemento_eliminar.setText("Eliminar");
        elemento_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elemento_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(elemento_crear)
                        .addGap(18, 18, 18)
                        .addComponent(elemento_modificar)
                        .addGap(18, 18, 18)
                        .addComponent(elemento_eliminar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento_crear)
                    .addComponent(elemento_modificar)
                    .addComponent(elemento_eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
            // TODO add your handling code here:
        } 
    
     private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // TODO add your handling code here:
        try{
            Conexion.cerrar();
            System.out.println("Conexión cerrada.");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }    
     
    private void elemento_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elemento_crearActionPerformed
        // TODO add your handling code here:
        vista_cliente.this.dispose();
        vista_guardar_cliente vista = new vista_guardar_cliente();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }//GEN-LAST:event_elemento_crearActionPerformed

    private void elemento_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elemento_modificarActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = elemento_tabla.getSelectedRow();
        if(fila_seleccionada >= 0){
            vista_cliente.this.dispose();
            vista_guardar_cliente vista = new vista_guardar_cliente(this.tareas.get(fila_seleccionada));
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        }else{
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.");
        }
    }//GEN-LAST:event_elemento_modificarActionPerformed

    private void elemento_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elemento_eliminarActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = elemento_tabla.getSelectedRow();
        if(fila_seleccionada >= 0){            
            int decision = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar esta tarea?", "Advertencia", JOptionPane.YES_NO_OPTION);            
            if(decision == 0){
                try{
                    this.tareas_servicio.eliminar(Conexion.obtener(), this.tareas.get(fila_seleccionada));
                    this.cargar_lista_de_tareas();
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido eliminar el registro.");
                }catch(ClassNotFoundException ex){
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido eliminar el registro.");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.");
        }
    }//GEN-LAST:event_elemento_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(vista_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton elemento_crear;
    private javax.swing.JButton elemento_eliminar;
    private javax.swing.JButton elemento_modificar;
    private javax.swing.JTable elemento_tabla;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
