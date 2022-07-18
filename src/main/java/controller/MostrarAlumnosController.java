/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Ventanas.MostrarAlumnos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Alumno;
import model.DB;
import model.Materia;

/**
 *
 * @author eljos
 */
public class MostrarAlumnosController {
    public static MostrarAlumnos mostrarAlumnos = new MostrarAlumnos();

    
    public static void mostrarVentana(){ 
        cargarAlumnos();
        mostrarAlumnos.setVisible(true);
    }
    
    public static void ocultarVentana(){
        mostrarAlumnos.setVisible(false);        
    }
    
    public static void back(){
        ocultarVentana();
        PrincipalController.mostrarVentanaPrincipal();
    }
    
    private static void cargarAlumnos(){
        String matrix[][] = new String[DB.alumnos.size()][6];
//        List alumnosCarrera = DB.carreras.get(idCarrera).getAlumnosCarrera();
        for(int i=0; i<DB.alumnos.size(); i++){
            matrix[i][0] = DB.alumnos.get(i).getStringLegajo();
            matrix[i][1] = DB.alumnos.get(i).getStringDni();
            matrix[i][2] = DB.alumnos.get(i).getNombre();
            matrix[i][3] = DB.alumnos.get(i).getApellido();
            matrix[i][4] = DB.alumnos.get(i).getEstado();
            matrix[i][5] = DB.alumnos.get(i).getCarreraString();
        }
        
        JTable tablaAlumnos = mostrarAlumnos.getjTableAlumnos();
        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Legajo","DNI","Nombre","Apellido", "Condición", "Carrera"
        }
        ));
    }
    
    public static void inscribirACarrera(){
        int seleccionFila;
        int respuesta;

        
        try{
            seleccionFila = mostrarAlumnos.getjTableAlumnos().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar el Alumno que desea Inscribir...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                if((DB.alumnos.get(seleccionFila).getCarreraString()).compareTo("Sin Inscripcion") != 0){
                    respuesta = JOptionPane.showConfirmDialog(null, "Desea cambiar de Carrera al Alumno seleccionado??", "Eliminar", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION){
                        ocultarVentana();
                        InscribirACarreraController.mostrarVentana(seleccionFila);
                    }
                }else{
                    ocultarVentana();
                    InscribirACarreraController.mostrarVentana(seleccionFila);
                }
                
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Inscripción del Alumno a la Carrera", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    }
    
    public static void inscribirAMateria(){
        int seleccionFila;

        
        try{
            seleccionFila = mostrarAlumnos.getjTableAlumnos().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar el Alumno que desea Inscribir...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                if(DB.alumnos.get(seleccionFila).getCarrera() == null){
                    JOptionPane.showMessageDialog(null, "El Alumno seleccionado debe estar Inscripto en alguna Carrera para poder inscribirse a Una Materia");
                }else{
                    ocultarVentana();
                    InscribirAMateriaController.mostrarVentana(seleccionFila);
                }
                
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Inscripción del Alumno a la Materia", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    
    public static void eliminarAlumno(){
        int seleccionFila;
        int respuesta;

        
        try{
            seleccionFila = mostrarAlumnos.getjTableAlumnos().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar el Alumno que desea Eliminar...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                respuesta = JOptionPane.showConfirmDialog(null, "Desea Eliminar Permanentemente al Alumno seleccionado??", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION){
                    Alumno alumnoAEliminar = DB.alumnos.get(seleccionFila);
                    
                    if (alumnoAEliminar.getCarrera() != null){
                        for(Materia materia : alumnoAEliminar.getCarrera().materias){
                            if(DB.alumnos.get(seleccionFila).getCursadas().contains(materia)){
                                materia.getCursada().darBajaAlumno(alumnoAEliminar);
                            }
                        }
                        alumnoAEliminar.getCarrera().bajaAlumno(alumnoAEliminar);
                    }
                    
                    
                    DB.alumnos.remove(alumnoAEliminar);
                    DefaultTableModel model = (DefaultTableModel)mostrarAlumnos.getjTableAlumnos().getModel();
                    model.removeRow(seleccionFila);
                }
                
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Eliminación del Alumno", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public static void agregarAlumno(){
        ocultarVentana();
        NuevoAlumnoController.mostrarVentana();
    }
    
    public static void verHistorialAcademico(){
        int seleccionFila;
        
        try{
            seleccionFila = mostrarAlumnos.getjTableAlumnos().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar del Alumno que desea ver el Historial Academico...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                ocultarVentana();
                VerHistorialAcademicoController.mostrarVentana(seleccionFila);
                
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la muestra del Historial Academico", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
}
