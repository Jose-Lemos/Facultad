/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author eljos
 */

import controller.InscribirACarreraController;
import javax.swing.*;
public class InscribirACarrera extends JFrame {

    /**
     * Creates new form InscribirACarrera
     */
    public InscribirACarrera() {
        initComponents();
        myInitComponent();
        centrar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        inscribirAlumno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCarreras = new javax.swing.JTable();
        lblPropuestasUNTDF = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inscribir Alumno a Carrera");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setBackground(new java.awt.Color(255, 0, 0));
        back.setText("Volver <--");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 103, 49));

        inscribirAlumno.setBackground(new java.awt.Color(0, 204, 0));
        inscribirAlumno.setText("Inscribir Alumno");
        inscribirAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscribirAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(inscribirAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 130, 60));

        jTableCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTableCarreras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 520, -1));

        lblPropuestasUNTDF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPropuestasUNTDF.setText("Propuestas UNTDF:");
        getContentPane().add(lblPropuestasUNTDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 20));
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        InscribirACarreraController.back();
    }//GEN-LAST:event_backActionPerformed

    private void inscribirAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscribirAlumnoActionPerformed
        // TODO add your handling code here:
        InscribirACarreraController.inscribirAlumnoCarrera();
    }//GEN-LAST:event_inscribirAlumnoActionPerformed

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
            java.util.logging.Logger.getLogger(InscribirACarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InscribirACarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InscribirACarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InscribirACarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InscribirACarrera inscribirACarrera = new InscribirACarrera();
                inscribirACarrera.setLocationRelativeTo(null);
                inscribirACarrera.setVisible(true);
            }
        });
    }
    
    public void myInitComponent(){
        ImageIcon image = new ImageIcon("C:\\Users\\eljos\\Documents\\NetBeansProjects\\Facultad\\src\\main\\java\\imagenes\\carreras-universitarias-programas.png");
        Fondo.setIcon(image);
    }

    public void centrar(){
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public JTable getjTableCarreras() {
        return jTableCarreras;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton back;
    private javax.swing.JButton inscribirAlumno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCarreras;
    private javax.swing.JLabel lblPropuestasUNTDF;
    // End of variables declaration//GEN-END:variables
}
