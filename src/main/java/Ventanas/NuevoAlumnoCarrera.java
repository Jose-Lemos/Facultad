/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import controller.MostrarAlumnosCarreraController;
import controller.NuevoAlumnoCarreraController;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author eljos
 */
public class NuevoAlumnoCarrera extends javax.swing.JFrame {

    /**
     * Creates new form NuevoAlumnoCarrera
     */
    public NuevoAlumnoCarrera() {
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

        jtxtLegajo = new javax.swing.JTextField();
        jtxtDni = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jtxtApellido = new javax.swing.JTextField();
        jtxtDIreccion = new javax.swing.JTextField();
        jtxtCorreo = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnCrearAlumno = new javax.swing.JButton();
        lblLegajo = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Alumno de la Carrera");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jtxtLegajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 130, -1));
        getContentPane().add(jtxtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 190, -1));
        getContentPane().add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 270, -1));
        getContentPane().add(jtxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 230, -1));
        getContentPane().add(jtxtDIreccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 450, -1));
        getContentPane().add(jtxtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 450, -1));

        btnBack.setText("CANCELAR");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 110, 60));

        btnCrearAlumno.setText("CREAR ALUMNO");
        btnCrearAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 433, 130, 60));

        lblLegajo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLegajo.setText("Legajo:");
        getContentPane().add(lblLegajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        lblDni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDni.setText("DNI:");
        getContentPane().add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        lblApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblApellido.setText("Apellido:");
        getContentPane().add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, -1));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDireccion.setText("Direccion:");
        getContentPane().add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCorreo.setText("Correo:");
        getContentPane().add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, -1));
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        NuevoAlumnoCarreraController.back();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCrearAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAlumnoActionPerformed
        // TODO add your handling code here:
        NuevoAlumnoCarreraController.crearAlumno();
    }//GEN-LAST:event_btnCrearAlumnoActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoAlumnoCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoAlumnoCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoAlumnoCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoAlumnoCarrera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoAlumnoCarrera().setVisible(true);
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

    public JTextField getJtxtApellido() {
        return jtxtApellido;
    }

    public JTextField getJtxtCorreo() {
        return jtxtCorreo;
    }

    public JTextField getJtxtDIreccion() {
        return jtxtDIreccion;
    }

    public JTextField getJtxtDni() {
        return jtxtDni;
    }

    public JTextField getJtxtLegajo() {
        return jtxtLegajo;
    }

    public JTextField getJtxtNombre() {
        return jtxtNombre;
    }

    public void setJtxtApellido(JTextField jtxtApellido) {
        this.jtxtApellido = jtxtApellido;
    }

    public void setJtxtCorreo(JTextField jtxtCorreo) {
        this.jtxtCorreo = jtxtCorreo;
    }

    public void setJtxtDIreccion(JTextField jtxtDIreccion) {
        this.jtxtDIreccion = jtxtDIreccion;
    }

    public void setJtxtDni(JTextField jtxtDni) {
        this.jtxtDni = jtxtDni;
    }

    public void setJtxtLegajo(JTextField jtxtLegajo) {
        this.jtxtLegajo = jtxtLegajo;
    }

    public void setJtxtNombre(JTextField jtxtNombre) {
        this.jtxtNombre = jtxtNombre;
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCrearAlumno;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtCorreo;
    private javax.swing.JTextField jtxtDIreccion;
    private javax.swing.JTextField jtxtDni;
    private javax.swing.JTextField jtxtLegajo;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblLegajo;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
