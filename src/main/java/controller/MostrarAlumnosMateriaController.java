/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Ventanas.MostrarAlumnosMateria;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Alumno;
import model.DB;

/**
 *
 * @author eljos
 */
public class MostrarAlumnosMateriaController {
    public static MostrarAlumnosMateria mostrarAlumnosMateria = new MostrarAlumnosMateria();
    static int idCarrera, idMateria;
    
    public static void mostrarVentana(int idCarrera, int idMateria){
        MostrarAlumnosMateriaController.idCarrera = idCarrera;
        MostrarAlumnosMateriaController.idMateria = idMateria;
        
        cargarAlumnosMateria(idCarrera, idMateria);
        
        mostrarAlumnosMateria.setVisible(true);
    }
    
    public static void ocultarVentana(){
        mostrarAlumnosMateria.setVisible(false);
    }
    
    public static void back(){
        ocultarVentana();
        MostrarMateriasController.crearVentana(idCarrera);
    }
    
    public static void cargarAlumnosMateria(int idCarrera, int idMateria){
        String matrix[][] = new String[DB.carreras.get(idCarrera).materias.get(idMateria).getCursada().getAlumnos().size()][4];
        
        for(int i=0;i <DB.carreras.get(idCarrera).materias.get(idMateria).getCursada().getAlumnos().size(); i++ ){
            matrix[i][0] = DB.carreras.get(idCarrera).materias.get(idMateria).getCursada().getAlumnos().get(i).getStringLegajo();
            matrix[i][1] = DB.carreras.get(idCarrera).materias.get(idMateria).getCursada().getAlumnos().get(i).getStringDni();
            matrix[i][2] = DB.carreras.get(idCarrera).materias.get(idMateria).getCursada().getAlumnos().get(i).getNombre();
            matrix[i][3] = DB.carreras.get(idCarrera).materias.get(idMateria).getCursada().getAlumnos().get(i).getApellido();
        }
        
        JTable tablaMaterias = mostrarAlumnosMateria.getjTableAlumnosMateria();
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Legajo","DNI","Nombre","Apellido" 
        }
        ));
    }
    
    public static void tomarExamenParcial(){
//        int seleccionFila;
//
//        try{
//            seleccionFila = mostrarAlumnosMateria.getjTableAlumnosMateria().getSelectedRow();
//            if (seleccionFila == -1){
//                JOptionPane.showMessageDialog(null, "Debe Seleccionar el alumno al que desea evaluar...","Advertencia",JOptionPane.WARNING_MESSAGE);
//            }
//            else{
//                ocultarVentana();
//                MostrarAlumnosCarreraController.mostrarVentana(seleccionFila);
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "No se pudo Tomar el Parcial", "Error", JOptionPane.ERROR_MESSAGE);
//        }
        if(DB.carreras.get(idCarrera).materias.get(idMateria).getCursada().getAlumnos().size() > 0){
            String Informar="";
            for(Alumno alumno: DB.carreras.get(idCarrera).materias.get(idMateria).getCursada().getAlumnos()){
                DB.carreras.get(idCarrera).materias.get(idMateria).getCursada().tomarExamenParcial(alumno);
                
                if(alumno.getMateriasRegularizadas().contains(DB.carreras.get(idCarrera).materias.get(idMateria))){
                    Informar+= "El Alumno "+alumno.getNombre() +" "+ alumno.getApellido()+" Regularizó la Materia \n";
                }
                else{
                    if(alumno.getMateriasAprobadas().contains(DB.carreras.get(idCarrera).materias.get(idMateria))){
                        Informar+= "El Alumno "+alumno.getNombre() +" "+ alumno.getApellido()+" Promocionó la Materia \n";
                    }
                    else{
                        Informar+= "El Alumno "+alumno.getNombre() +" "+ alumno.getApellido()+" Desaprobó la Materia \n";
                    }
                }
                
            }
            JOptionPane.showMessageDialog(null, Informar);
            DB.carreras.get(idCarrera).materias.get(idMateria).getCursada().finalizarCursada();
            back();
//
//
//          ResultadosDeLaCursadaController.mostrarVentana(idCarrera, idMateria);
        }
        else{
            JOptionPane.showMessageDialog(null, "No EXISTEN alumnos en la Cursada, no se puede Finalizar la Cursada", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }
}
