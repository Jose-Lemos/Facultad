/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Ventanas.*;

/**
 *
 * @author eljos
 */
public class PrincipalController {
   private static VentanaPrincipal ventPrincipal = new VentanaPrincipal();
   
    
    public static void mostrarVentanaPrincipal(){
        ventPrincipal.setVisible(true);
    }
    
    public static void ocultarVentanaPrincipal(){
        ventPrincipal.setVisible(false);
    }
     
    
    public static void mostrarCarreras(){
        ocultarVentanaPrincipal();
        MostrarCarrerasController.mostrarVentana();
        MostrarCarrerasController.cargarCarreras();
    }
    
    public static void mostrarAlumnos(){
        ocultarVentanaPrincipal();
        MostrarAlumnosController.mostrarVentana();
    }
    
    public static void salir(){
        ventPrincipal.dispose();
    }
    
    
    public static void ayuda(){
        ocultarVentanaPrincipal();
        AyudaController.mostrarAyuda();
    }
    
    

}
