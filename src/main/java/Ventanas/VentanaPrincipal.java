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
import controller.PrincipalController;
import java.awt.Image;
import javax.swing.*;
public class VentanaPrincipal extends JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
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

        help = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        Carrera = new javax.swing.JLabel();
        Alumno = new javax.swing.JLabel();
        gestionCarrera = new javax.swing.JButton();
        gestionAlumnos = new javax.swing.JButton();
        logoUntdf = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UNTDF");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setName("VentanaPrincipal"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        help.setBackground(new java.awt.Color(0, 255, 51));
        help.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        help.setText("Ayuda");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        getContentPane().add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        salir.setBackground(new java.awt.Color(255, 0, 0));
        salir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, -1));

        Carrera.setBackground(new java.awt.Color(255, 255, 255));
        Carrera.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 40)); // NOI18N
        Carrera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Carrera.setText("Carreras");
        getContentPane().add(Carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 190, 90));

        Alumno.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 40)); // NOI18N
        Alumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Alumno.setText("Alumnos");
        getContentPane().add(Alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        gestionCarrera.setToolTipText("");
        gestionCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionCarreraActionPerformed(evt);
            }
        });
        getContentPane().add(gestionCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 220, 160));

        gestionAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionAlumnosActionPerformed(evt);
            }
        });
        getContentPane().add(gestionAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 220, 160));

        logoUntdf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(logoUntdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 330, 90));

        Fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fondo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Fondo.setOpaque(true);
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        PrincipalController.salir();
    }//GEN-LAST:event_salirActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        // TODO add your handling code here:
        PrincipalController.ayuda();
    }//GEN-LAST:event_helpActionPerformed

    private void gestionCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionCarreraActionPerformed
        // TODO add your handling code here:
        PrincipalController.mostrarCarreras();
        
    }//GEN-LAST:event_gestionCarreraActionPerformed

    private void gestionAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionAlumnosActionPerformed
        // TODO add your handling code here:
        PrincipalController.mostrarAlumnos();
    }//GEN-LAST:event_gestionAlumnosActionPerformed

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
        } catch (ClassNotFoundException ex) {  //No encuentra la clase.
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {  //Falta la instanciación de la clase.
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {  //Acceso Ilegal.
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {  //
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    VentanaPrincipal frameP = new VentanaPrincipal();
                    frameP.setLocationRelativeTo(null);
                    frameP.setVisible(true);
                   }
                catch(NullPointerException e){
                    System.out.println("TE capturé wachin");
                }
            }
        });

    }
    
    public void myInitComponent(){
        ImageIcon fondo = new ImageIcon("C:\\Users\\eljos\\Documents\\NetBeansProjects\\Facultad\\src\\main\\java\\imagenes\\carreras-universitarias-programas.png");
        Fondo.setIcon(fondo);
        
        ImageIcon logo = new ImageIcon("C:\\Users\\eljos\\Documents\\NetBeansProjects\\Facultad\\src\\main\\java\\imagenes\\logo-untdf.jpg");
        logoUntdf.setIcon(logo);
        
        String urlCarrera = "C:\\Users\\eljos\\Documents\\NetBeansProjects\\Facultad\\src\\main\\java\\imagenes\\estudiar-carrera.jpg";
        gestionCarrera.setIcon(setIcono(urlCarrera, gestionCarrera));
        gestionCarrera.setPressedIcon(setIconoPresionado(urlCarrera, gestionCarrera,15,15));
        
        String urlAlumnos = "C:\\Users\\eljos\\Documents\\NetBeansProjects\\Facultad\\src\\main\\java\\imagenes\\icon-gestion-alumnos.jpg";
        gestionAlumnos.setIcon(setIcono(urlAlumnos,gestionAlumnos));
        gestionAlumnos.setPressedIcon(setIconoPresionado(urlAlumnos, gestionAlumnos,15,15));
    }

    public void centrar(){
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    protected Icon setIcono(String url, JButton botonCarrera){
        ImageIcon icon = new ImageIcon(url);
        
        int ancho = botonCarrera.getWidth();
        
        int alto = botonCarrera.getHeight();
                      
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        
        return icono;        
    }
    
    public Icon setIconoPresionado(String url, JButton botonCarrera, int ancho, int alto){
        ImageIcon icon = new ImageIcon(url);
        
        int width = botonCarrera.getWidth()-ancho;
        
        int height = botonCarrera.getHeight()-alto;
        
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        
        return icono;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alumno;
    private javax.swing.JLabel Carrera;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton gestionAlumnos;
    private javax.swing.JButton gestionCarrera;
    private javax.swing.JButton help;
    private javax.swing.JLabel logoUntdf;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
