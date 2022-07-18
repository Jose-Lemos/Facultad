/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Ventanas.Ayuda;


/**
 *
 * @author eljos
 */
public class AyudaController {
    public static void mostrarAyuda(){
        Ayuda ayuda = new Ayuda(); 
        ayuda.setVisible(true);
    }
    
    public static void cerrarAyuda(Ayuda ayuda){
        ayuda.dispose();        
    }
    
    public static void aceptar(Ayuda ayuda){
        AyudaController.cerrarAyuda(ayuda);
        PrincipalController.mostrarVentanaPrincipal();
    }
    
}
