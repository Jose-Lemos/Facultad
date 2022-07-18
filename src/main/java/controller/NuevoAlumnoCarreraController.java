/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Ventanas.NuevoAlumnoCarrera;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Alumno;
import model.DB;

/**
 *
 * @author eljos
 */
public class NuevoAlumnoCarreraController {
    public static NuevoAlumnoCarrera nuevoAlumnoCarrera = new NuevoAlumnoCarrera();
    public static int idCarrera;
    
    public static void mostrarVentana(int idCarrera){
        NuevoAlumnoCarreraController.idCarrera = idCarrera;
        nuevoAlumnoCarrera.setVisible(true);
        
    }
    
    public static void ocultarVentana(){
        resetComponents();
        nuevoAlumnoCarrera.setVisible(false);
    }
    
    public static void back(){
        NuevoAlumnoCarreraController.ocultarVentana();
        resetComponents();
        MostrarAlumnosCarreraController.mostrarVentana(idCarrera);
    }
    
    private static void resetComponents(){
        JTextField campoVacio = nuevoAlumnoCarrera.getJtxtLegajo();
        campoVacio.setText("");
        nuevoAlumnoCarrera.setJtxtLegajo(campoVacio);
        
        campoVacio = nuevoAlumnoCarrera.getJtxtDni();
        campoVacio.setText("");
        nuevoAlumnoCarrera.setJtxtDni(campoVacio);
        
        campoVacio = nuevoAlumnoCarrera.getJtxtNombre();
        campoVacio.setText("");
        nuevoAlumnoCarrera.setJtxtNombre(campoVacio);
        
        campoVacio = nuevoAlumnoCarrera.getJtxtApellido();
        campoVacio.setText("");
        nuevoAlumnoCarrera.setJtxtApellido(campoVacio);
        
        campoVacio = nuevoAlumnoCarrera.getJtxtCorreo();
        campoVacio.setText("");
        nuevoAlumnoCarrera.setJtxtCorreo(campoVacio);
        
        campoVacio = nuevoAlumnoCarrera.getJtxtDIreccion();
        campoVacio.setText("");
        nuevoAlumnoCarrera.setJtxtDIreccion(campoVacio);
    } 
    
    
    public static boolean verificarDNI(){  //verifica que el texto ingresado sean números, que ese número sea mayor a cero y que no pertenezca a algún alumno existente.
        String dni = nuevoAlumnoCarrera.getJtxtDni().getText();
        boolean valido = true;
                
        try{  //verifico que el dni ingresado sea un número entero y que esté dentro del rango de valores posibles.
                long valorDni = Integer.parseInt(dni);
  
        }
        catch (NumberFormatException e){  //verifico que se haya ingresado números.
            valido = false;
            JOptionPane.showMessageDialog(null, "Error al ingresar el DNI del Alumno, usted ingresó un caracter alfanumérco o un numero mayor al máximo permitido"
                    + "Por Favor corrija el DNI del Alumno...");
        }
        
        if (valido){  //verifico que el número de legajo sea un número de legajo válido(legajo>0)
            
            long valorDni = Integer.parseInt(dni);
            
            if (valorDni <= 0){  //verifico que el número ingresado sea mayor a cero.
                valido = false;
                JOptionPane.showMessageDialog(null, "Error al ingresar el DNI del Alumno, usted ingresó un número menor o igual a cero"
                    + "Por Favor corrija el DNI del Alumno...");
            }
            else {
            
            if (DB.alumnos.size() > 0){  //verifico que el legajo ingresado no pertenezca a un alumno ya cargado en el sistema.
            int i = 0;
            
            
            while (i < DB.alumnos.size() && (valido == true)){
                if (DB.alumnos.get(i).getDni() == valorDni){
                    valido = false;
                    
                    JOptionPane.showMessageDialog(null, "Error al ingresar el DNI del Alumno, este DNI ya pertenece a un Alumno del Sistema"
                    + "Por Favor corrija el DNI del Alumno...");
                    }
                i++;
                }
            }
            }
            
        }       
        return valido;
    }
    
    public static boolean verificarLegajo(){  //verifica que el texto ingresado sean números, que ese número sea mayor a cero y que no pertenezca a algún alumno existente.
        String legajo = nuevoAlumnoCarrera.getJtxtLegajo().getText();
        boolean valido = true;
                
        try{  //verifico que el dni ingresado sea un número entero y que esté dentro del rango de valores posibles.
                long valorLegajo = Integer.parseInt(legajo);
  
        }
        catch (NumberFormatException e){  //verifico que se haya ingresado números.
            valido = false;
            JOptionPane.showMessageDialog(null, "Error al ingresar el Legajo del Alumno, usted ingresó un caracter alfanumérco o un numero mayor al máximo permitido"
                    + "Por Favor corrija el Legajo del Alumno...");
        }
        
        if (valido){  //verifico que el número de legajo sea un número de legajo válido(legajo>0)
            
            long valorLegajo = Integer.parseInt(legajo);
            
            if (valorLegajo <= 0){  //verifico que el número ingresado sea mayor a cero.
                valido = false;
                JOptionPane.showMessageDialog(null, "Error al ingresar el Legajo del Alumno, usted ingresó un número menor o igual a cero"
                    + "Por Favor corrija el Legajo del Alumno...");
            }
            else {
            
            if (DB.alumnos.size() > 0){  //verifico que el legajo ingresado no pertenezca a un alumno ya cargado en el sistema.
            int i = 0;
            
            
            while (i < DB.alumnos.size() && (valido == true)){
                if (DB.alumnos.get(i).getLegajo() == valorLegajo){
                    valido = false;
                    
                    JOptionPane.showMessageDialog(null, "Error al ingresar el Legajo del Alumno, este Legajo ya pertenece a un Alumno del Sistema"
                    + "Por Favor corrija el Legajo del Alumno...");

                    }
                i++;
                }
            }
            }
            
        }   
        return valido;  //devuelvo el valor booleano de lo analizado.
    }
    
    public static boolean verificarNombre(){  //Se puede usar para verificar nombre.
        boolean valido = true;
        String nombre = nuevoAlumnoCarrera.getJtxtNombre().getText();
        String letrasValidas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz";
        
        int i = 0;  int cantLetras = 0;  
        
        while (i < nombre.length()&& valido){  //recorro el nombre completo o hasta que válido sea falso.
            char valor = nombre.charAt(i);
            int j = 0; 
            boolean pertenece = false;
            
            while (j < letrasValidas.length() && (pertenece == false)){
                if (valor == letrasValidas.charAt(j)){
                    pertenece = true;
                    cantLetras += 1;
                }
                j += 1;
            }
            
            if ((pertenece == false))
            {
                valido = false;
                JOptionPane.showMessageDialog(null, "Error al ingresar el Nombre del Alumno, caracteres inválidos!!"
                    + "Por Favor corrija el Nombre del Alumno...");
             }
            
            i +=1;
           }
            

        if (cantLetras < 2){
            valido = false;
            
            JOptionPane.showMessageDialog(null, "Error al ingresar el Nombre del Alumno, Nombre muy corto!!"
                    + "Por Favor corrija el Nombre del Alumno...");
        }
       
        return valido;
    }
    
    public static boolean verificarApellido(){  //Se puede usar para verificar apellido.
        boolean valido = true;
        String apellido = nuevoAlumnoCarrera.getJtxtApellido().getText();
        String letrasValidas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz";
        
        int i = 0;  int cantLetras = 0;  
        
        while (i < apellido.length()&& valido){  //recorro el apellido completo o hasta que válido sea falso.
            char valor = apellido.charAt(i);
            int j = 0; 
            boolean pertenece = false;
            
            while (j < letrasValidas.length() && !(pertenece)){
                
                if (valor == letrasValidas.charAt(j)){
                    pertenece = true;
                    cantLetras += 1;
                }
                j += 1;
            }
            
            if (!(pertenece))
            {
                valido = false;
                JOptionPane.showMessageDialog(null, "Error al ingresar el Apellido del Alumno, caracteres inválidos!!"
                    + "Por Favor corrija el Apellido del Alumno...");
             }
            
            i +=1;
           }
            

        if (cantLetras < 2){
            valido = false;
            
            JOptionPane.showMessageDialog(null, "Error al ingresar el Apellido del Alumno, Apellido muy corto!!"
                    + "Por Favor corrija el Apellido del Alumno...");
        }
        
        return valido;
    }
 
     public static boolean verificarCorreo(){  //verifica que el correo ingresado tenga un único arroba necesariamente, que haya algo escrito antes del arroba, que lo escrito sean caracteres válidos y que ese correo termine en ".com" o ".ar".
        boolean valido = true;
        String correo = nuevoAlumnoCarrera.getJtxtCorreo().getText();
        String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String caracteresEspeciales = "-_.";
        String caracteresValidos = letras + numeros + caracteresEspeciales;
        
        int i = 0;  int cantCaracteres = 0;int cantLetras = 0;  int cantArroba=0;
        
        while (i < correo.length()&& valido){  //recorro el nombre completo o hasta que válido sea falso.
            char valor = correo.charAt(i);
            int j = 0; 
            boolean pertenece = false;
            
            while (j < caracteresValidos.length() && (pertenece == false)){
                if (valor == caracteresValidos.charAt(j)){
                    pertenece = true;
                    cantCaracteres += 1;
                    
                    if (j < 54){  //verifico si pertenece al conjunto de letras validas.
                       cantLetras += 1; 
                    }
                }
                j += 1;
            }
            
            if (pertenece == false)
            {
                if (valor == '@'){  //verifico si el caracter es un arroba.
                    cantArroba += 1;
                    
                    if ((cantLetras < 3)||(cantArroba > 1)){  //verifico que exista como máximo un arroba, y que antes del arroba exista al menos 3 letras.
                        valido = false;
                        
                    JOptionPane.showMessageDialog(null, "Error al ingresar el Correo del Alumno, ingresó más de un arroba(@) o menos de tres(3) letras antes del arroba!!"
                    + "Por Favor corrija el Correo del Alumno...");
                    }
                }
                else //si no es un arroba, entonces es un caracter inválido.
                {
                    valido = false;
                    
                    JOptionPane.showMessageDialog(null, "Error al ingresar el Correo del Alumno, caracteres inválidos!!"
                    + "Por Favor corrija el Correo del Alumno...");
                }
            }
            
            i +=1;
            
        }
        
        if (cantArroba == 0){  //verifico que exista al menos un arroba.
            valido = false;
            
            JOptionPane.showMessageDialog(null, "Error al ingresar el Correo del Alumno, un correo debe tener necesariamente un único arroba(@)!!"
                    + "Por Favor corrija el Correo del Alumno...");
        }
        else 
        {
            if ((correo.substring(correo.length()-4, correo.length()-1) == ".com")||(correo.substring(correo.length()-3, correo.length()-1) == ".ar"))  //verifico que el correo term,ine en .com o .ar.
            {
                valido = false;
                
                JOptionPane.showMessageDialog(null, "Error al ingresar el Correo del Alumno, el correo debe terminar en '.com' o '.ar'!!"
                    + "Por Favor corrija el Correo del Alumno...");
            }
        }
        
        
        return valido;
    }
     
     
    
     public static boolean verificarDireccion(){  //verifica que el correo ingresado tenga un único arroba necesariamente, que haya algo escrito antes del arroba, que lo escrito sean caracteres válidos y que ese correo termine en ".com" o ".ar".
        boolean valido = true;
        String direccion = nuevoAlumnoCarrera.getJtxtDIreccion().getText();
        String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String caracteresEspeciales = "-_.";
        String caracteresValidos = letras + numeros + caracteresEspeciales;
        
        int i = 0;  
        
        while (i < direccion.length()&& valido){  //recorro el nombre completo o hasta que válido sea falso.
            char valor = direccion.charAt(i);
            int j = 0; 
            boolean pertenece = false;
            
            while (j < caracteresValidos.length() && (pertenece == false)){
                if (valor == caracteresValidos.charAt(j)){
                    pertenece = true;
                }
                j += 1;
            }
            
            
            
            i +=1;
            
        }
        
        
        
        return valido;
    }
     
     
     public static  boolean validarDatos(){  //Verifica todos los datos.
        boolean valido ;
        String informe = "";
        
        if (nuevoAlumnoCarrera.getJtxtLegajo().getText().isEmpty())  //verifico el legajo.
        {
            informe += "No hay nada en Legajo!! Falta Completar!!";
            valido = false;
        }
        else
            {
                valido = verificarLegajo();
         
                if (valido)
                {
                    informe += "Legajo Válido \n";
                }
                else
                    {
                        informe += "Hay que Corregir el Legajo \n";
                    }
        }
        
        
        
        if (nuevoAlumnoCarrera.getJtxtDni().getText().isEmpty())  //verifico el dni.
        {
            informe += "No hay nada en DNI!! Falta Completar!! \n";
            valido = false;
        }
        else
            {
                valido = verificarDNI();
                
                if (valido)
                {
                    informe += "DNI Válido \n";
                }
                else
                    {
                        informe += "Hay que Corregir el DNI \n";
                    }
                
            }
        
        
        if (nuevoAlumnoCarrera.getJtxtNombre().getText().isEmpty())  //verifico el nombre.
        {
            informe += "No hay nada en Nombre!! Falta Completar!! \n";
            valido = false;
        }
        else
            {
                valido = verificarNombre();
                
                if (valido)
                {
                    informe += "Nombre Válido \n";
                }
                else
                    {
                        informe += "Hay que Corregir el Nombre \n";
                    }
                
            }
        
        if (nuevoAlumnoCarrera.getJtxtApellido().getText().isEmpty())  //verifico el nombre.
        {
            informe += "No hay nada en Apellido!! Falta Completar!! \n";
            valido = false;
        }
        else
            {
                valido = verificarApellido();
                
                if (valido)
                {
                    informe += "Apellido Válido \n";
                }
                else
                    {
                        informe += "Hay que Corregir el Apellido \n";
                    }
                
            }
        
        
        if (nuevoAlumnoCarrera.getJtxtDIreccion().getText().isEmpty())  //verifico el nombre.
        {
            informe += "No hay nada en Direccion!! Falta Completar!! \n";
            valido = false;
        }
        else
            {
                valido = verificarDireccion();
                
                if (valido)
                {
                    informe += "Direccion Válida \n";
                }
                else
                    {
                        informe += "Hay que Corregir la Direccion \n";
                    }
                
            }

        
        
        if (nuevoAlumnoCarrera.getJtxtCorreo().getText().isEmpty())  //verifico el nombre.
        {
            informe += "No hay nada en Correo!! Falta Completar!! \n";
            valido = false;
        }
        else
            {
                valido = verificarCorreo();
                
                if (valido)
                {
                    informe += "Correo Válido \n";
                }
                else
                    {
                        informe += "Hay que Corregir el Correo \n";
                    }
                
            }
        
        JOptionPane.showMessageDialog(null, informe);
        
        return valido;
     }
     
     
     public static void crearAlumno(){  //Crear Alumno desde la Carrera, con la inscripcion hecha en la misma.
        boolean valido = validarDatos();
        if (valido)
        {
            int legajo = Integer.parseInt(nuevoAlumnoCarrera.getJtxtLegajo().getText());
            int dni = Integer.parseInt(nuevoAlumnoCarrera.getJtxtDni().getText());
            String nombre = nuevoAlumnoCarrera.getJtxtNombre().getText();
            String apellido = nuevoAlumnoCarrera.getJtxtApellido().getText();
            String localidad = nuevoAlumnoCarrera.getJtxtDIreccion().getText();
            String correo = nuevoAlumnoCarrera.getJtxtCorreo().getText();
            
            Alumno nuevoAlumno = new Alumno(legajo, dni, nombre, apellido, localidad, correo);//creo el alumno con los datos validos ingresados
            nuevoAlumno.setCarrera(DB.carreras.get(idCarrera));  //Le asigno la carrera de donde creé al Alumno.
            DB.carreras.get(idCarrera).alumnos.add(nuevoAlumno);  //Guardo el Alumno en la Carrera inscripto.
            JOptionPane.showMessageDialog(null, "ALUMNO CREADO");
            back();
            
        }
    }
}
