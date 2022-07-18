/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Ventanas.InscribirACarrera;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DB;
import model.Materia;

/**
 *
 * @author eljos
 */
public class InscribirACarreraController {
    public static InscribirACarrera inscribirCarrera = new InscribirACarrera();
    static int idAlumno;
    
    public static void mostrarVentana(int idAlumno){
        InscribirACarreraController.idAlumno = idAlumno;
        
        cargarCarreras();
        
        inscribirCarrera.setVisible(true);
    }
    
    public static void ocultarVentana(){
        inscribirCarrera.dispose();
    }
    
    public static void back(){
        ocultarVentana();
        MostrarAlumnosController.mostrarVentana();
    }
    
    private static void cargarCarreras(){
        String matrix[][] = new String[DB.carreras.size()][6];
        for(int i=0; i<DB.carreras.size() ;i++){
            matrix[i][0] = DB.carreras.get(i).getCodigo();
            matrix[i][1] = DB.carreras.get(i).getNombre();
            matrix[i][2] = DB.carreras.get(i).getDuracion();
            matrix[i][3] = DB.carreras.get(i).getCantidadMaterias();
            matrix[i][4] = DB.carreras.get(i).getCantidadAlumnos();
            matrix[i][5] = DB.carreras.get(i).planEstudio.getTipo();
        }
        
        JTable tablaCarreras = inscribirCarrera.getjTableCarreras();
        tablaCarreras.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Codigo","Carrera","Duracion","N° Materias", "N° Alumnos", "Tipo-Plan"
        }
        ));
    }
    
    public static void inscribirAlumnoCarrera(){
        int seleccionFila;
        int respuesta;

        
        try{
            seleccionFila = inscribirCarrera.getjTableCarreras().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Carrera a la que desea inscribir al Alumno...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                if((DB.alumnos.get(idAlumno).getCarreraString()).compareTo("Sin Inscripcion") != 0){
                    respuesta = JOptionPane.showConfirmDialog(null, "Desea cambiar de Carrera al Alumno seleccionado??", "Eliminar", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION){
                        DB.alumnos.get(idAlumno).getCarrera().bajaAlumno(DB.alumnos.get(idAlumno));                      
                        DB.alumnos.get(idAlumno).setCarrera(DB.carreras.get(seleccionFila)); 
                        DB.carreras.get(seleccionFila).alumnos.add(DB.alumnos.get(idAlumno));
                        JOptionPane.showMessageDialog(null, "Inscripción Realizada con Éxito");
                        back();
                    }
                }else{
                    DB.alumnos.get(idAlumno).setCarrera(DB.carreras.get(seleccionFila));
                    DB.alumnos.get(idAlumno).setEstado("Regular");
                    DB.carreras.get(seleccionFila).alumnos.add(DB.alumnos.get(idAlumno));
                    JOptionPane.showMessageDialog(null, "Inscripción Realizada con Éxito");
                    back();
                }
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Inscripcion a la Carrera", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
}
