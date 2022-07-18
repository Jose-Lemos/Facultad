/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Ventanas.VerExamenesRendidos;
import javax.swing.JTable;
import model.DB;

/**
 *
 * @author eljos
 */
public class VerExamenesRendidosController {
    public static VerExamenesRendidos verExamenesRendidos = new VerExamenesRendidos();
    static int idAlumno;
    
public static void mostrarVentana(int idAlumno){
    VerExamenesRendidosController.idAlumno = idAlumno;
    cargarExamenesRendidos();
    verExamenesRendidos.setVisible(true);
}

public static void ocultarVentana(){
   verExamenesRendidos.setVisible(false); 
}

public static void back(){
    ocultarVentana();
    VerHistorialAcademicoController.mostrarVentana(idAlumno);
}

public static void cargarExamenesRendidos(){
    String matrix[][] = new String[DB.alumnos.get(idAlumno).getExamenesRendidos().size()][4];
//        List alumnosCarrera = DB.carreras.get(idCarrera).getAlumnosCarrera();
        for(int i=0; i<DB.alumnos.get(idAlumno).getExamenesRendidos().size(); i++){
            matrix[i][0] = DB.alumnos.get(idAlumno).getExamenesRendidos().get(i).getFecha();
            matrix[i][1] = DB.alumnos.get(idAlumno).getExamenesRendidos().get(i).getCursada().getMateria().getNombre();
            matrix[i][2] = DB.alumnos.get(idAlumno).getExamenesRendidos().get(i).getTipo();
            matrix[i][3] = DB.alumnos.get(idAlumno).getExamenesRendidos().get(i).getNotaExamenString();
            
        }
        
        JTable tablaAlumnos = verExamenesRendidos.getjTableExamenesRendidos();
        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Fecha de Examen","Materia","Tipo de Examen","Nota"
        }
        ));
}

}
