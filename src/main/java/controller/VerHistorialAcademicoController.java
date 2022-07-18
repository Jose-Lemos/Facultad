/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Ventanas.VerHistorialAcademico;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;
import model.Materia;

/**
 *
 * @author eljos
 */
public class VerHistorialAcademicoController {
    public static VerHistorialAcademico verHistorialAcademico = new VerHistorialAcademico();
    static int idAlumno;
    
    public static void mostrarVentana(int idAlumno){
        VerHistorialAcademicoController.idAlumno = idAlumno;
        
        cargarMateriasCursada();
        cargarMateriasRegularizadas();
        cargarMateriasAprobadas();
        
        
        verHistorialAcademico.setVisible(true);
    }
    
    public static void ocultarVentana(){
        verHistorialAcademico.setVisible(false);
    }
    
    public static void back(){
        ocultarVentana();
        MostrarAlumnosController.mostrarVentana();
    }
    
    
    public static void cargarMateriasCursada(){
        String matrix[][] = new String[DB.alumnos.get(idAlumno).getCursadas().size()][1];
        
        for(int i=0;i <DB.alumnos.get(idAlumno).getCursadas().size(); i++ ){
            matrix[i][0] = DB.alumnos.get(idAlumno).getCursadas().get(i).getNombre();
            
        }
        
        JTable tablaMaterias = verHistorialAcademico.getjTableMateriasEnCurso();
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Materias en Curso:"
        }
        ));
    }
    
    public static void cargarMateriasRegularizadas(){
        String matrix[][] = new String[DB.alumnos.get(idAlumno).getMateriasRegularizadas().size()][1];
        
        for(int i=0;i <DB.alumnos.get(idAlumno).getMateriasRegularizadas().size(); i++ ){
            matrix[i][0] = DB.alumnos.get(idAlumno).getMateriasRegularizadas().get(i).getNombre();
            
        }
        
        JTable tablaMaterias = verHistorialAcademico.getjTableMateriasRegularizadas();
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Materias Regularizadas:"
        }
        ));
    }
    
    
    
    public static void cargarMateriasAprobadas(){
        String matrix[][] = new String[DB.alumnos.get(idAlumno).getMateriasAprobadas().size()][1];
        
        for(int i=0;i <DB.alumnos.get(idAlumno).getMateriasAprobadas().size(); i++ ){
            matrix[i][0] = DB.alumnos.get(idAlumno).getMateriasAprobadas().get(i).getNombre();
            
        }
        
        JTable tablaMaterias = verHistorialAcademico.getjTableMateriasAprobadas();
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Materias Aprobadas:"
        }
        ));
    }
    
    
    public static void verExamenesRendidos(){
        ocultarVentana();
        VerExamenesRendidosController.mostrarVentana(idAlumno);        
    }
    
    
    public static void verificarGraduacion(){
        
        int cantidadMateriasObligatoriasRequeridas = DB.alumnos.get(idAlumno).getCarrera().cantidadMateriasObligatorias();
        int cantidadMateriasOptativasRequeridas = DB.alumnos.get(idAlumno).getCarrera().cantidadOptativasRequeridasParaGraduacion();
        
        int cantidadMateriasObligatoriasAprobadas = DB.alumnos.get(idAlumno).cantidadMateriasObligatoriasAprobadas();
        int cantidadMateriasOptativasAprobadas = DB.alumnos.get(idAlumno).cantidadMateriasOptativasAprobadas();
        
        int condicionObligatorias = cantidadMateriasObligatoriasRequeridas-cantidadMateriasObligatoriasAprobadas;
        int condicionOptativas = cantidadMateriasOptativasRequeridas-cantidadMateriasOptativasAprobadas;
        
        if(condicionObligatorias == 0 && condicionOptativas < 1){
            JOptionPane.showMessageDialog(null, "Alumno Graduado!!");
        }else{
            String informar = "";
            if(condicionObligatorias == 0){
                informar+= "Todas las Materias ObligatoriasEstán Aprobadas \n";
            }else{
                informar+= "Faltan Aprobar "+condicionObligatorias+" Materias Obligatorias \n";
            }
            
            if(condicionOptativas < 1){
                informar += "La cantidad de Materias Optativas Requeridas están Aprobadas \n";
            }else{
                informar+= "Faltan Aprobar "+condicionOptativas+" Materias Optativas \n";
            }
            
            JOptionPane.showMessageDialog(null, informar);
        }
        
        
    }
    
    public static void rendirFinal(){
        int seleccionFila;
        String informar = "";

        
        try{
            seleccionFila = verHistorialAcademico.getjTableMateriasRegularizadas().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia que desea Rendir...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                    Materia materiaSeleccionada = DB.alumnos.get(idAlumno).getMateriasRegularizadas().get(seleccionFila);
                    materiaSeleccionada.getCursada().tomarAExamenFinal(DB.alumnos.get(idAlumno));
                    
                    
                    if(DB.alumnos.get(idAlumno).getMateriasAprobadas().contains(materiaSeleccionada)){
                        informar += "Examen Final Rendido! \n El Alumno "+DB.alumnos.get(idAlumno).getNombre()+" "+DB.alumnos.get(idAlumno).getApellido()+" Aprobó el Examen Final!!";
                    }
                    else{
                        informar += "Examen Final Rendido! \n El Alumno "+DB.alumnos.get(idAlumno).getNombre()+" "+DB.alumnos.get(idAlumno).getApellido()+" Desaprobó el Examen Final!!";
                    }
                    JOptionPane.showMessageDialog(null, informar);
                    cargarMateriasRegularizadas();
                    cargarMateriasAprobadas();
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Eliminación de la Carrera", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
}
