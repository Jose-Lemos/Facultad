/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Ventanas.MateriasEnCondicionDeCursar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Alumno;
import model.DB;
import model.Materia;

/**
 *
 * @author eljos
 */
public class MateriasEnCondicionDeCursarController {
    public static MateriasEnCondicionDeCursar materiasEnCondicionDeCursar = new MateriasEnCondicionDeCursar();
    static int idAlumno;
    
    public static void mostrarVentana(int idAlumno){
        MateriasEnCondicionDeCursarController.idAlumno = idAlumno;
        cargarMaterias();
        materiasEnCondicionDeCursar.setVisible(true);
    }
    
    public static void ocultarVentana(){
        materiasEnCondicionDeCursar.setVisible(false);
    }
    
    public static void back(){
        ocultarVentana();
        InscribirAMateriaController.mostrarVentana(idAlumno);
    }
    
    private static void cargarMaterias(){
        boolean planValido, correlativasValidas;
        List<Materia> materiasValidasACursar = new ArrayList<>();
        
        Alumno alumnoSeleccionado = DB.alumnos.get(idAlumno);
        
        if(alumnoSeleccionado.getCarrera().getMaterias().size()>0){
            for(Materia materia : alumnoSeleccionado.getCarrera().getMaterias()){
                correlativasValidas = materia.verificarCorrelativasRegularizadas(alumnoSeleccionado);
                planValido = alumnoSeleccionado.getCarrera().planEstudio.verificarPlan(alumnoSeleccionado, materia);
                
                if(correlativasValidas && planValido && (alumnoSeleccionado.getCursadas().contains(materia) == false)){
                    if(alumnoSeleccionado.getMateriasAprobadas().contains(materia)==false && alumnoSeleccionado.getMateriasRegularizadas().contains(materia)==false){
                        materiasValidasACursar.add(materia);
                    }
                }
            }
        }
        
        String matrix[][] = new String[materiasValidasACursar.size()][8];
        
        for(int i=0;i < materiasValidasACursar.size(); i++ ){
            matrix[i][0] = materiasValidasACursar.get(i).getCodigo();
            matrix[i][1] = materiasValidasACursar.get(i).getNombre();
            matrix[i][2] = materiasValidasACursar.get(i).getGradoString();
            matrix[i][3] = materiasValidasACursar.get(i).getCuatrimestreString();
            matrix[i][4] = materiasValidasACursar.get(i).getTipo();
            matrix[i][5] = materiasValidasACursar.get(i).getPromocionString();
            matrix[i][6] = materiasValidasACursar.get(i).getCursada().cantidadAlumnosString();
            matrix[i][7] = materiasValidasACursar.get(i).getCantidadCorrelativasString();
        }
        
        JTable tablaMaterias = materiasEnCondicionDeCursar.getjTableMateriasParaCursar();
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Codigo","Nombre","Grado","Cuatrimestre", "Tipo","Promocion","N° de Alumnos","N° Correlativas"
        }
        ));
    }
    
    
//    public static void inscribirAlumno(){
//        int seleccionFila;
//        
//        
//        try{
//            seleccionFila = materiasEnCondicionDeCursar.getjTableMateriasParaCursar().getSelectedRow();
//            if (seleccionFila == -1){
//                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia en la que desea inscribir al Alumno...","Advertencia",JOptionPane.WARNING_MESSAGE);
//            }
//            else{
//                Alumno alumnoSeleccionado = DB.alumnos.get(idAlumno);
//                Materia materiaSeleccionada = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(seleccionFila);
//                
//                alumnoSeleccionado.getCursadas().add(materiaSeleccionada);
//                materiaSeleccionada.getCursada().InscribirAlumno(alumnoSeleccionado);
//                
//                JOptionPane.showMessageDialog(null, "Alumno Inscripto!!");
//                back();
//            }
//        }catch(Exception e){
//        JOptionPane.showMessageDialog(null, "No se pudo realizar la Inscripción del Alumno a la Materia", "Error", JOptionPane.ERROR_MESSAGE);
//    }    
//            
//    }
    
    public static void aceptar(){
        back();
    }
}
