/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Ventanas.NuevoAlumno;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import model.Alumno;
import model.DB;

/**
 *
 * @author eljos
 */
public class NuevoAlumnoController {
    private static NuevoAlumno nuevoAlumno = new NuevoAlumno();

    
    public static void resetComponents(){ 
        JLabel lVacio = nuevoAlumno.getApellidoVerificado();
        lVacio.setText("");
        nuevoAlumno.setApellidoVerificado(lVacio);
        
        lVacio = nuevoAlumno.getCalleVerificada();
        lVacio.setText("");
        nuevoAlumno.setCalleVerificada(lVacio);
        
        lVacio = nuevoAlumno.getCorreoVerificado();
        lVacio.setText("");
        nuevoAlumno.setCorreoVerificado(lVacio);
        
        lVacio = nuevoAlumno.getDniVerificado(); 
        lVacio.setText("");
        nuevoAlumno.setDniVerificado(lVacio);
        
        lVacio = nuevoAlumno.getLegajoVerificado(); 
        lVacio.setText("");
        nuevoAlumno.setLegajoVerificado(lVacio);
        
        lVacio = nuevoAlumno.getLocalidadVerificada();
        lVacio.setText("");
        nuevoAlumno.setLocalidadVerificada(lVacio);
        
        lVacio = nuevoAlumno.getNombreVerificado();
        lVacio.setText("");
        nuevoAlumno.setNombreVerificado(lVacio);
        
        lVacio = nuevoAlumno.getNumeroVerificado();
        lVacio.setText("");
        nuevoAlumno.setNumeroVerificado(lVacio);
        
        
        nuevoAlumno.setTextApellidoAlumno("");
        nuevoAlumno.setTextCalle("");
        nuevoAlumno.setTextCorreoAlumno("");
        nuevoAlumno.setTextDniAlumno("");
        nuevoAlumno.setTextLegajoAlumno("");
        nuevoAlumno.setTextNombreAlumno("");

    }
    
    public static void mostrarVentana(){
        nuevoAlumno.setVisible(true);
        
    }
    

    
    
    public static void ocultarVentana(){
        resetComponents();
        nuevoAlumno.setVisible(false);
    }
    
    public static void back(){
        ocultarVentana();
        MostrarAlumnosController.mostrarVentana();
    }
    
    
    
    public static boolean verificarDNI(){  //verifica que el texto ingresado sean números, que ese número sea mayor a cero y que no pertenezca a algún alumno existente.
        String dni = nuevoAlumno.getTextDniAlumno().getText();
        JLabel dniVerificado = nuevoAlumno.getDniVerificado();
        Font font = new Font("Arial", Font.BOLD, 12);
        boolean valido = true;
                
        try{  //verifico que el dni ingresado sea un número entero y que esté dentro del rango de valores posibles.
                long valorDni = Integer.parseInt(dni);
  
        }
        catch (NumberFormatException e){  //verifico que se haya ingresado números.
            valido = false;
            JOptionPane.showMessageDialog(null, "Error al ingresar el DNI del Alumno, usted ingresó un caracter alfanumérco o un numero mayor al máximo permitido"
                    + "Por Favor corrija el DNI del Alumno...");
            dniVerificado.setText("DNI INVÁLIDO");
            dniVerificado.setForeground(Color.DARK_GRAY);
            dniVerificado.setFont(font);
            nuevoAlumno.setDniVerificado(dniVerificado);
        }
        
        if (valido){  //verifico que el número de legajo sea un número de legajo válido(legajo>0)
            
            long valorDni = Integer.parseInt(dni);
            
            if (valorDni <= 0){  //verifico que el número ingresado sea mayor a cero.
                valido = false;
                JOptionPane.showMessageDialog(null, "Error al ingresar el DNI del Alumno, usted ingresó un número menor o igual a cero"
                    + "Por Favor corrija el DNI del Alumno...");
                dniVerificado.setText("DNI INVÁLIDO");
                dniVerificado.setForeground(Color.DARK_GRAY);
                dniVerificado.setFont(font);
                nuevoAlumno.setDniVerificado(dniVerificado);
            }
            else {
            
            if (DB.alumnos.size() > 0){  //verifico que el legajo ingresado no pertenezca a un alumno ya cargado en el sistema.
            int i = 0;
            
            
            while (i < DB.alumnos.size() && (valido == true)){
                if (DB.alumnos.get(i).getDni() == valorDni){
                    valido = false;
                    
                    JOptionPane.showMessageDialog(null, "Error al ingresar el DNI del Alumno, este DNI ya pertenece a un Alumno del Sistema"
                    + "Por Favor corrija el DNI del Alumno...");
                    
                    dniVerificado.setText("DNI INVÁLIDO");
                    dniVerificado.setForeground(Color.DARK_GRAY);
                    dniVerificado.setFont(font);
                    nuevoAlumno.setDniVerificado(dniVerificado);
                    }
                i++;
                }
            }
            }
            
        }
        if (valido){
            dniVerificado.setText("DNI VÁLIDO");
            dniVerificado.setForeground(Color.WHITE);
            dniVerificado.setFont(font);
            nuevoAlumno.setDniVerificado(dniVerificado);
        }
        
        return valido;
    }
    
    public static boolean verificarLegajo(){  //verifica que el texto ingresado sean números, que ese número sea mayor a cero y que no pertenezca a algún alumno existente.
        String legajo = nuevoAlumno.getTextLegajoAlumno().getText();
        JLabel legajoVerificado = nuevoAlumno.getLegajoVerificado();
        Font font = new Font("Arial", Font.BOLD, 12);
        boolean valido = true;
                
        try{  //verifico que el dni ingresado sea un número entero y que esté dentro del rango de valores posibles.
                long valorLegajo = Integer.parseInt(legajo);
  
        }
        catch (NumberFormatException e){  //verifico que se haya ingresado números.
            valido = false;
            JOptionPane.showMessageDialog(null, "Error al ingresar el Legajo del Alumno, usted ingresó un caracter alfanumérco o un numero mayor al máximo permitido"
                    + "Por Favor corrija el Legajo del Alumno...");
            legajoVerificado.setText("INVÁLIDO");
            legajoVerificado.setForeground(Color.DARK_GRAY);
            legajoVerificado.setFont(font);
            nuevoAlumno.setLegajoVerificado(legajoVerificado);
        }
        
        if (valido){  //verifico que el número de legajo sea un número de legajo válido(legajo>0)
            
            long valorLegajo = Integer.parseInt(legajo);
            
            if (valorLegajo <= 0){  //verifico que el número ingresado sea mayor a cero.
                valido = false;
                JOptionPane.showMessageDialog(null, "Error al ingresar el Legajo del Alumno, usted ingresó un número menor o igual a cero"
                    + "Por Favor corrija el Legajo del Alumno...");
                legajoVerificado.setText("INVÁLIDO");
                legajoVerificado.setForeground(Color.DARK_GRAY);
                legajoVerificado.setFont(font);
                nuevoAlumno.setLegajoVerificado(legajoVerificado);
            }
            else {
            
            if (DB.alumnos.size() > 0){  //verifico que el legajo ingresado no pertenezca a un alumno ya cargado en el sistema.
            int i = 0;
            
            
            while (i < DB.alumnos.size() && (valido == true)){
                if (DB.alumnos.get(i).getLegajo() == valorLegajo){
                    valido = false;
                    
                    JOptionPane.showMessageDialog(null, "Error al ingresar el Legajo del Alumno, este Legajo ya pertenece a un Alumno del Sistema"
                    + "Por Favor corrija el Legajo del Alumno...");
                    
                    legajoVerificado.setText("INVÁLIDO");
                    legajoVerificado.setForeground(Color.DARK_GRAY);
                    legajoVerificado.setFont(font);
                    nuevoAlumno.setLegajoVerificado(legajoVerificado);
                    }
                i++;
                }
            }
            }
            
        }
        if (valido){
            legajoVerificado.setText("LEGAJO VÁLIDO");
            legajoVerificado.setForeground(Color.WHITE);
            legajoVerificado.setFont(font);
            nuevoAlumno.setLegajoVerificado(legajoVerificado);
        }
        
        return valido;  //devuelvo el valor booleano de lo analizado.
    }
    
    
    
    public static boolean verificarNombre(){  //Se puede usar para verificar nombre.
        boolean valido = true;
        String nombre = nuevoAlumno.getTextNombreAlumno().getText();
        JLabel nombreVerificado = nuevoAlumno.getNombreVerificado();
        Font font = new Font("Arial", Font.BOLD, 12);
        String letrasValidas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz";
        
        int i = 0;  int cantLetras = 0;  
        
        while (i < nombre.length()&& valido){  //recorro el nombre completo o hasta que válido sea falso.
            char valor = nombre.charAt(i);
            int j = 0; 
            boolean pertenece = false;
            
            while (j < letrasValidas.length() && (pertenece == false)){
                System.out.println(letrasValidas.charAt(j));
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
                    
                    nombreVerificado.setText("NOMBRE INVÁLIDO");
                    nombreVerificado.setForeground(Color.DARK_GRAY);
                    nombreVerificado.setFont(font);
                    nuevoAlumno.setNombreVerificado(nombreVerificado);
             }
            
            i +=1;
           }
            

        if (cantLetras < 2){
            valido = false;
            
            JOptionPane.showMessageDialog(null, "Error al ingresar el Nombre del Alumno, Nombre muy corto!!"
                    + "Por Favor corrija el Nombre del Alumno...");
                    
                    nombreVerificado.setText("NOMBRE INVÁLIDO");
                    nombreVerificado.setForeground(Color.DARK_GRAY);
                    nombreVerificado.setFont(font);
                    nuevoAlumno.setNombreVerificado(nombreVerificado);
        }
        
        if(valido)
        {
            nombreVerificado.setText("NOMBRE VÁLIDO");
            nombreVerificado.setForeground(Color.WHITE);
            nombreVerificado.setFont(font);
            nuevoAlumno.setNombreVerificado(nombreVerificado);
        }
        
        return valido;
    }
    
    public static boolean verificarApellido(){  //Se puede usar para verificar apellido.
        boolean valido = true;
        String apellido = nuevoAlumno.getTextApellidoAlumno().getText();
        JLabel apellidoVerificado = nuevoAlumno.getApellidoVerificado();
        Font font = new Font("Arial", Font.BOLD, 12);
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
                    
                    apellidoVerificado.setText("APELLIDO INVÁLIDO");
                    apellidoVerificado.setForeground(Color.DARK_GRAY);
                    apellidoVerificado.setFont(font);
                    nuevoAlumno.setApellidoVerificado(apellidoVerificado);
             }
            
            i +=1;
           }
            

        if (cantLetras < 2){
            valido = false;
            
            JOptionPane.showMessageDialog(null, "Error al ingresar el Apellido del Alumno, Apellido muy corto!!"
                    + "Por Favor corrija el Apellido del Alumno...");
                    
                    apellidoVerificado.setText("APELLIDO INVÁLIDO");
                    apellidoVerificado.setForeground(Color.DARK_GRAY);
                    apellidoVerificado.setFont(font);
                    nuevoAlumno.setNombreVerificado(apellidoVerificado);
        }
        
        if(valido)
        {
            apellidoVerificado.setText("APELLIDO VÁLIDO");
            apellidoVerificado.setForeground(Color.WHITE);
            apellidoVerificado.setFont(font);
            nuevoAlumno.setNombreVerificado(apellidoVerificado);
        }
        
        return valido;
    }
    

    
    public static boolean verificarCalle(){
        boolean valido = true;
        String calle = nuevoAlumno.getTextCalle().getText();
        JLabel calleVerificada = nuevoAlumno.getCalleVerificada();
        Font font = new Font("Arial", Font.BOLD, 12);
        String letrasValidas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ abcdefghijklmnñopqrstuvwxyz";
        
        int i = 0;  int cantLetras = 0;  
        
        while (i < calle.length()&& valido){  //recorro el nombre completo o hasta que válido sea falso.
            char valor = calle.charAt(i);
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
                JOptionPane.showMessageDialog(null, "Error al ingresar la calle del domicilio del Alumno, caracteres inválidos!!"
                    + "Por Favor corrija la calle del domicilio del Alumno...");
                    
                    calleVerificada.setText("CALLE INVÁLIDA");
                    calleVerificada.setForeground(Color.DARK_GRAY);
                    calleVerificada.setFont(font);
                    nuevoAlumno.setCalleVerificada(calleVerificada);
             }
            
            i +=1;
           }
            

        if (cantLetras < 2){
            valido = false;
            
            JOptionPane.showMessageDialog(null, "Error al ingresar la calle del domicilio del Alumno, Nombre muy corto!!"
                    + "Por Favor corrija la calle del domicilio del Alumno...");
                    
                    calleVerificada.setText("CALLE INVÁLIDA");
                    calleVerificada.setForeground(Color.DARK_GRAY);
                    calleVerificada.setFont(font);
                    nuevoAlumno.setCalleVerificada(calleVerificada);
        }
        
        if(valido)
        {
                                
                    calleVerificada.setText("CALLE VÁLIDA");
                    calleVerificada.setForeground(Color.WHITE);
                    calleVerificada.setFont(font);
                    nuevoAlumno.setCalleVerificada(calleVerificada);
        }
        
        return valido;
    }
    
    public static boolean verificarDomicilio(){
        boolean valido = true;
        String direccion = nuevoAlumno.getJTxtDomicilio().getText();
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
    
    public static boolean verificarCorreo(){  //verifica que el correo ingresado tenga un único arroba necesariamente, que haya algo escrito antes del arroba, que lo escrito sean caracteres válidos y que ese correo termine en ".com" o ".ar".
        boolean valido = true;
        String correo = nuevoAlumno.getTextCorreoAlumno().getText();
        String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String caracteresEspeciales = "-_.";
        String caracteresValidos = letras + numeros + caracteresEspeciales;
        JLabel correoVerificado = nuevoAlumno.getCorreoVerificado();
        Font font = new Font("Arial", Font.BOLD, 12);
        
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
                    
                    correoVerificado.setText("CORREO INVÁLIDO");
                    correoVerificado.setForeground(Color.DARK_GRAY);
                    correoVerificado.setFont(font);
                    nuevoAlumno.setCorreoVerificado(correoVerificado);
                    }
                }
                else //si no es un arroba, entonces es un caracter inválido.
                {
                    valido = false;
                    
                    JOptionPane.showMessageDialog(null, "Error al ingresar el Correo del Alumno, caracteres inválidos!!"
                    + "Por Favor corrija el Correo del Alumno...");
                    
                    correoVerificado.setText("CORREO INVÁLIDO");
                    correoVerificado.setForeground(Color.DARK_GRAY);
                    correoVerificado.setFont(font);
                    nuevoAlumno.setCorreoVerificado(correoVerificado);
                }
            }
            
            i +=1;
            
        }
        
        if (cantArroba == 0){  //verifico que exista al menos un arroba.
            valido = false;
            
            JOptionPane.showMessageDialog(null, "Error al ingresar el Correo del Alumno, un correo debe tener necesariamente un único arroba(@)!!"
                    + "Por Favor corrija el Correo del Alumno...");
                    
                    correoVerificado.setText("CORREO INVÁLIDO");
                    correoVerificado.setForeground(Color.DARK_GRAY);
                    correoVerificado.setFont(font);
                    nuevoAlumno.setCorreoVerificado(correoVerificado);
        }
        else 
        {
            if ((correo.substring(correo.length()-4, correo.length()-1) == ".com")||(correo.substring(correo.length()-3, correo.length()-1) == ".ar"))  //verifico que el correo term,ine en .com o .ar.
            {
                valido = false;
                
                JOptionPane.showMessageDialog(null, "Error al ingresar el Correo del Alumno, el correo debe terminar en '.com' o '.ar'!!"
                    + "Por Favor corrija el Correo del Alumno...");
                    
                    correoVerificado.setText("CORREO INVÁLIDO");
                    correoVerificado.setForeground(Color.DARK_GRAY);
                    correoVerificado.setFont(font);
                    nuevoAlumno.setCorreoVerificado(correoVerificado);
            }
        }
        
        if(valido)
        {
            correoVerificado.setText("CORREO VÁLIDO");
            correoVerificado.setForeground(Color.WHITE);
            correoVerificado.setFont(font);
            nuevoAlumno.setCorreoVerificado(correoVerificado);
        }
        
        
        return valido;
    }
    
    public static  boolean validarDatos(){  //Verifica todos los datos.
        boolean valido ;
        String informe = "";
        
        if (nuevoAlumno.getTextLegajoAlumno().getText().isEmpty())  //verifico el legajo.
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
        
        
        
        if (nuevoAlumno.getTextDniAlumno().getText().isEmpty())  //verifico el dni.
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
        
        
        if (nuevoAlumno.getTextNombreAlumno().getText().isEmpty())  //verifico el nombre.
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
        
        if (nuevoAlumno.getTextApellidoAlumno().getText().isEmpty())  //verifico el nombre.
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
        
        
        if(nuevoAlumno.getJTxtDomicilio().getText().isEmpty()){
            informe += "No hay nada en Direccion!! Falta Completar!! \n";
            valido = false;
        }
        else{
            valido = verificarDomicilio();
            
            if (valido)
                {
                    informe += "Direccion Válida \n";
                }
                else
                    {
                        informe += "Hay que Corregir la Direccion \n";
                    }
        }
        
        if (nuevoAlumno.getTextCorreoAlumno().getText().isEmpty())  //verifico el nombre.
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
    
    public static void crearAlumno(){  //Crea un Alumno en el Sistema.
        boolean valido = validarDatos();
        if (valido)
        {
            int legajo = Integer.parseInt(nuevoAlumno.getTextLegajoAlumno().getText());
            int dni = Integer.parseInt(nuevoAlumno.getTextDniAlumno().getText());
            String nombre = nuevoAlumno.getTextNombreAlumno().getText();
            String apellido = nuevoAlumno.getTextApellidoAlumno().getText();
            String localidad = nuevoAlumno.getJTxtDomicilio().getText();
            String correo = nuevoAlumno.getTextCorreoAlumno().getText();
            
            Alumno nuevoAlumno = new Alumno(legajo, dni, nombre, apellido, localidad, correo);  //Guardo el Alumno en la Base de Datos.
            JOptionPane.showMessageDialog(null, "ALUMNO CREADO");
            back();
            
        }
    }
    
    
}
