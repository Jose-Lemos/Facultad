/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Ventanas.MostrarAlumnosCarrera;
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
public class MostrarAlumnosCarreraController {
    public static MostrarAlumnosCarrera mostrarAlumnosCarrera = new MostrarAlumnosCarrera();
    public static int idCarrera;
    
    public static void mostrarVentana(int idCarrera){ 
        MostrarAlumnosCarreraController.idCarrera = idCarrera;
        
        cargarAlumnos(idCarrera);
        
        mostrarAlumnosCarrera.setVisible(true);
    }
    
    public static void ocultarVentana(){
        mostrarAlumnosCarrera.setVisible(false);        
    }
    
    public static void back(){
        ocultarVentana();
        MostrarCarrerasController.mostrarVentana();
    }
    
    public static void cargarAlumnos(int idCarrera){
        String matrix[][] = new String[DB.carreras.get(idCarrera).alumnos.size()][5];
//        List alumnosCarrera = DB.carreras.get(idCarrera).getAlumnosCarrera();
        for(int i=0; i<DB.carreras.get(idCarrera).alumnos.size(); i++){
            matrix[i][0] = DB.carreras.get(idCarrera).alumnos.get(i).getStringLegajo();
            matrix[i][1] = DB.carreras.get(idCarrera).alumnos.get(i).getStringDni();
            matrix[i][2] = DB.carreras.get(idCarrera).alumnos.get(i).getNombre();
            matrix[i][3] = DB.carreras.get(idCarrera).alumnos.get(i).getApellido();
            matrix[i][4] = DB.carreras.get(idCarrera).alumnos.get(i).getEstado();
        }
        
        JTable tablaAlumnos = mostrarAlumnosCarrera.getjTableAlumnosCarrera();
        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Legajo","DNI","Nombre","Apellido", "Condición"
        }
        ));
    }
    
    public static void darBajaAlumnoCarrera(){
        int seleccionFila;
        int respuesta;

        
        try{
            seleccionFila = mostrarAlumnosCarrera.getjTableAlumnosCarrera().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar el Alumno que desea Eliminar...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                respuesta = JOptionPane.showConfirmDialog(null, "Desea Dar de Baja de la Carrera al Alumno seleccionado??", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION){
//                     
//                        
//                        for(Materia materia : DB.alumnos.get(seleccionFila).getCarrera().materias){
//                            if(DB.alumnos.get(seleccionFila).getCursadas().contains(materia)){
//                                DB.alumnos.get(seleccionFila).getCursadas().remove(materia);
//                            }
//                        }
                    Alumno alumnoAEliminar = DB.alumnos.get(seleccionFila);
                    
                    if (alumnoAEliminar.getCarrera() != null){
                        for(Materia materia : alumnoAEliminar.getCarrera().materias){
                            if(DB.alumnos.get(seleccionFila).getCursadas().contains(materia)){
                                materia.getCursada().darBajaAlumno(alumnoAEliminar);
                            }
                        }
                        alumnoAEliminar.getCarrera().bajaAlumno(alumnoAEliminar);
                    }
                    
                    alumnoAEliminar.getCursadas().clear();
                    alumnoAEliminar.setCarrera(null);
                    alumnoAEliminar.setEstado("Dado de Baja");
                    DefaultTableModel model = (DefaultTableModel)mostrarAlumnosCarrera.getjTableAlumnosCarrera().getModel();
                    model.removeRow(seleccionFila);
                }
                
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Eliminación de la Carrera", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    
    public static void agregarAlumnoCarrera(){
        ocultarVentana();
        NuevoAlumnoCarreraController.mostrarVentana(idCarrera);
    }
}
