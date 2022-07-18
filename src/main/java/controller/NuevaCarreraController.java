/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Ventanas.NuevaCarrera;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Carrera;
import model.DB;


/**
 *
 * @author eljos
 */
public class NuevaCarreraController {
    public static NuevaCarrera nuevaCarrera = new NuevaCarrera();
    
    public static void crearVentana(){
        nuevaCarrera.setVisible(true);
    }
    
    public static void cerrarVentana(){
        nuevaCarrera.setVisible(false);
        resetComponents();
    }

    public static boolean verificarCodigoCarrera(){
        String codigo = nuevaCarrera.getTextCodigoCarrera().getText();
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
                JOptionPane.showMessageDialog(null, "Error al ingresar el Codigo de la Carrera, caracteres inválidos!!"
                    + "Por Favor corrija el codigo de la Carrera...");

            }
            i += 1;
        }
            if(valido){
                if (DB.carreras.size()>0){
                    int ind = 0;
                
                    while(ind < DB.carreras.size() && valido == true){
                        if (DB.carreras.get(ind).getCodigo().compareTo(codigo) == 0){
                            valido = false;
                            JOptionPane.showMessageDialog(null, "Error al ingresar el codigo de la Carrera, este código ya le pertenece a otra...","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        ind++; 
                    }
                    
                }
                
            }
             
            return valido;
        }
    
    
    public static boolean verificarNombreCarrera(){
        boolean valido = true;
        String nombre = nuevaCarrera.getTextNombreCarrera().getText();
        String letrasValidas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz";
        
        int i = 0;  
        
        while (i < nombre.length()&& valido){  //recorro el nombre completo o hasta que válido sea falso.
            char valor = nombre.charAt(i);
            int j = 0; 
            boolean pertenece = false;
            
            while (j < letrasValidas.length() && (pertenece == false)){
                if (valor == letrasValidas.charAt(j)){
                    pertenece = true;
                    
                }
                j += 1;
            }
            
            if ((pertenece == false))
            {
                valido = false;
                JOptionPane.showMessageDialog(null, "Error al ingresar el Nombre de la Carrera, caracteres inválidos!!"
                    + "Por Favor corrija el Nombre de la Carrera...");
                    
             }
            
            i +=1;
           }

        return valido;
    }
    
    
    
    
    public static boolean verificarPorcentaje(){
        String porcentaje = nuevaCarrera.getjTxtPorcentaje().getText();
        boolean valido = true;
        
        try{
            int valorPorcentaje = Integer.parseInt(porcentaje);
        }catch(NumberFormatException e){
            valido = false;
            JOptionPane.showMessageDialog(null, "Error al ingresar el Porcentaje de las Materias Optativas Requeridas para la graduación, usted ingresó un caracter alfanumérco o un numero mayor al máximo permitido"
                    + "Por Favor corrija el Porcentaje...");
        }
        
        
        return valido;
    }
    

    
   public static void resetComponents(){
       JTextField espacioVacio = nuevaCarrera.getTextCodigoCarrera();
        espacioVacio.setText("");
        nuevaCarrera.setTextCodigoCarrera(espacioVacio);
        
        espacioVacio = nuevaCarrera.getTextNombreCarrera();
        espacioVacio.setText("");
        nuevaCarrera.setTextNombreCarrera(espacioVacio);
   }
    
    
    public static boolean verificarDatos(){
        boolean codigoValido, nombreValido, porcentajeValido;
        String informe= "";
        
        if (nuevaCarrera.getTextCodigoCarrera().getText().isEmpty())  //verifico el legajo.
        {
            informe += "No hay nada en el Codigo de la Carrera!! Falta Completar!!";
            codigoValido = false;
        }
        else
            {
                codigoValido = verificarCodigoCarrera();
         
                if (codigoValido)
                {
                    informe += "Código Válido \n";
                }
                else
                    {
                        informe += "Hay que Corregir el Código \n";
                    }
        }
        
        if (nuevaCarrera.getTextNombreCarrera().getText().isEmpty())  //verifico el legajo.
        {
            informe += "No hay nada en el Nombre de la Carrera!! Falta Completar!!";
            nombreValido = false;
        }
        else
            {
                nombreValido = verificarNombreCarrera();
         
                if (nombreValido)
                {
                    informe += "Nombre Válido \n";
                }
                else
                    {
                        informe += "Hay que Corregir el Nombre \n";
                    }
        }
        
        
        if(nuevaCarrera.getjTxtPorcentaje().getText().isEmpty()){
            informe += "No hay nada en el Nombre de la Materia!! Falta Completar!!";
            porcentajeValido = false;
        }else{
            porcentajeValido = verificarPorcentaje();
            
            if (porcentajeValido)
                {
                    informe += "Porcentaje Válido \n";
                }
                else
                    {
                        informe += "Hay que Corregir el Porcentaje \n";
                    }
        }
        
        
        
        return codigoValido && nombreValido && porcentajeValido;
    }
    
    public static void crearCarrera(){
        boolean valido = verificarDatos();
        if(valido){
            String codigo = nuevaCarrera.getTextCodigoCarrera().getText();
            String nombre = nuevaCarrera.getTextNombreCarrera().getText();
            String grado = nuevaCarrera.getGradoCarrera();
            String plan = nuevaCarrera.getListaTiposPlanes();
            String porcentaje = nuevaCarrera.getjTxtPorcentaje().getText();
            
            int anios; 
            String titulo;
            if (grado == "Licenciatura"){
                anios = 5;
                titulo = "Lic en ";
            }
            else{
                if(grado == "Tecnicatura"){
                    anios = 3;
                    titulo = "Tec en ";
                }
                else{
                    if(grado == "Doctorado"){
                        anios = 4;
                        titulo = "DR. en ";
                    }
                    else{
                        anios = 2;
                        titulo = "postgrado de ";
                    }
                }
            }
            
            char tipoPlan = plan.charAt(0);
            
            
            Carrera carreraNueva = new Carrera(codigo, titulo+nombre, anios, tipoPlan);
            carreraNueva.setPorcentajeOptativasRequeridas(Integer.parseInt(porcentaje));
            JOptionPane.showMessageDialog(null, "CARRERA CREADA");
        }
    }
}
