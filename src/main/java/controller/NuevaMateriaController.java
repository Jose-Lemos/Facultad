/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author eljos
 */

import Ventanas.NuevaMateria;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DB;
import model.Materia;

public class NuevaMateriaController {
    private static NuevaMateria nuevaMateria = new NuevaMateria(); 
    public static int idCarrera;
    
    public static void crearVentana(int idCarrera){
        NuevaMateriaController.idCarrera = idCarrera;
        nuevaMateria.setVisible(true);
    }
    
    public static void cerrarVentana(){
        nuevaMateria.setVisible(false);
        resetComponents();
    }
    
    public static void back(){
        cerrarVentana();
        MostrarMateriasController.crearVentana(idCarrera);
    }
    
    public static boolean verificarCodigoMateria(){
        String codigo = nuevaMateria.getTextCodMateria().getText();
        boolean valido = true;
        String caracteresValidos = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz-()0123456789";
        
        
        int i = 0;
        while (i<codigo.length() && (valido == true)){
            char valor = codigo.charAt(i);
            int j = 0; 
            boolean pertenece = false;
            
            while (j<caracteresValidos.length() && (pertenece==false)){
                if (valor == caracteresValidos.charAt(j)){
                    pertenece = true;
                }
                j += 1;
            }
            
            if ((pertenece == false))
            {
                valido = false;
                JOptionPane.showMessageDialog(null, "Error al ingresar el Codigo de la Materia, caracteres inválidos!!"
                    + "Por Favor corrija el codigo de la Materia...");
            }
            i += 1;
        }
            if(valido){
                if (DB.materias.size()>0){
                    int ind = 0;
                
                    while(ind < DB.materias.size()&&valido == true){
                        if (DB.materias.get(ind).getCodigo().compareTo(codigo) == 0){
                            valido = false;
                            JOptionPane.showMessageDialog(null, "Error al ingresar el codigo de la Materia, este código ya le pertenece a otra...","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        ind++; 
                    }
                    
                }
                
            }
             
            return valido;
        }
    
    public static boolean verificarNombreMateria(){
        boolean valido = true;
        String nombre = nuevaMateria.getTextNombreMateria().getText();
        String letrasValidas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz";
        
        int i = 0;  
        
        while (i < nombre.length()&& valido){  //recorro el nombre completo o hasta que válido sea falso.
            char valor = nombre.charAt(i);
            int j = 0; 
            boolean pertenece = false;
            
            while (j < letrasValidas.length() && (pertenece == false)){
                System.out.println(letrasValidas.charAt(j));
                if (valor == letrasValidas.charAt(j)){
                    pertenece = true;
                    
                }
                j += 1;
            }
            
            if ((pertenece == false))
            {
                valido = false;
                JOptionPane.showMessageDialog(null, "Error al ingresar el Nombre de la Materia, caracteres inválidos!!"
                    + "Por Favor corrija el Nombre de la Materia...");
             }
            
            i +=1;
           }
        
        return valido;
    }
    
    
    public static void resetComponents(){
        JLabel lblVacio = nuevaMateria.getCodigoVerificado();
        lblVacio.setText("");
        nuevaMateria.setCodigoVerificado(lblVacio);
        
        lblVacio = nuevaMateria.getNombreVerificado();
        lblVacio.setText("");
        nuevaMateria.setNombreVerificado(lblVacio);
        
        JTextField espacioVacio = nuevaMateria.getTextCodMateria();
        espacioVacio.setText("");
        nuevaMateria.setTextCodMateria(espacioVacio);
        
        espacioVacio = nuevaMateria.getTextNombreMateria();
        espacioVacio.setText("");
        nuevaMateria.setTextNombreMateria(espacioVacio);
        
    }
    
    public static boolean validarDatos(){
        boolean codigoValido, nombreValido;
        String informe= "";
        
        if (nuevaMateria.getTextCodMateria().getText().isEmpty())  //verifico el legajo.
        {
            informe += "No hay nada en el Codigo de la Materia!! Falta Completar!!";
            codigoValido = false;
        }
        else
            {
                codigoValido = verificarCodigoMateria();
         
                if (codigoValido == true)
                {
                    informe += "Código Válido \n";
                }
                else
                    {
                        informe += "Hay que Corregir el Código \n";
                    }
        }
        
        if (nuevaMateria.getTextNombreMateria().getText().isEmpty())  //verifico el legajo.
        {
            informe += "No hay nada en el Nombre de la Materia!! Falta Completar!!";
            nombreValido = false;
        }
        else
            {
                nombreValido = verificarNombreMateria();
         
                if (nombreValido)
                {
                    informe += "Nombre Válido \n";
                }
                else
                    {
                        informe += "Hay que Corregir el Nombre \n";
                    }
        }
        
        
        return codigoValido && nombreValido;
    }
    
    
    public static void crearMateria(){
        boolean valido = validarDatos();
        if(valido == true){
            String codigo = nuevaMateria.getTextCodMateria().getText();
            String nombre = nuevaMateria.getTextNombreMateria().getText();
            String tipo = nuevaMateria.getTipo();
            int grado = Integer.parseInt(nuevaMateria.getAños());
            int cuatrimestre = Integer.parseInt(nuevaMateria.getCuatrimestres());
            
            boolean promocion;
            if (nuevaMateria.getPromocion()=="SI"){
                promocion = true;
            }
            else {
                promocion = false;
            }
            
            
            Materia matNueva = new Materia(codigo, nombre, tipo, grado, cuatrimestre, promocion);
            DB.carreras.get(idCarrera).materias.add(matNueva);
            JOptionPane.showMessageDialog(null, "MATERIA CREADA");
        }
    }
}
       
    

