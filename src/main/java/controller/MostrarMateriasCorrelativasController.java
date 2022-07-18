/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Ventanas.MostrarMateriasCorrelativas;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;

/**
 *
 * @author eljos
 */
public class MostrarMateriasCorrelativasController {
    public static MostrarMateriasCorrelativas mostrarMateriasCorrelativas = new MostrarMateriasCorrelativas();
    static int idCarrera, idMateria;
    
    public static void mostrarVentana(int idCarrera, int idMateria){
        MostrarMateriasCorrelativasController.idCarrera = idCarrera;
        MostrarMateriasCorrelativasController.idMateria = idMateria;
        
        cargarMateriasCorrelativas(idCarrera, idMateria);
        
        mostrarMateriasCorrelativas.setVisible(true);
    }
    
    public static void ocultarVentana(){
        mostrarMateriasCorrelativas.setVisible(false);
    }
    
    public static void back(){
        ocultarVentana();
        MostrarMateriasController.crearVentana(idCarrera);
    }
    
    private static void cargarMateriasCorrelativas(int idCarrera, int idMateria){
         String matrix[][] = new String[DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().size()][8];
        
        for(int i=0;i <DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().size(); i++ ){
            matrix[i][0] = DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().get(i).getCodigo();
            matrix[i][1] = DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().get(i).getNombre();
            matrix[i][2] = DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().get(i).getGradoString();
            matrix[i][3] = DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().get(i).getCuatrimestreString();
            matrix[i][4] = DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().get(i).getTipo();
            matrix[i][5] = DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().get(i).getPromocionString();
            matrix[i][6] = DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().get(i).getCursada().cantidadAlumnosString();
            matrix[i][7] = DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().get(i).getCantidadCorrelativasString();
        }
        
        JTable tablaMaterias = mostrarMateriasCorrelativas.getjTableMateriasCorrelativas();
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Codigo","Nombre","Grado","Cuatrimestre", "Tipo","Promocion","N° de Alumnos","N° Correlativas"
        }
        ));
    }
    
    public static void eliminarMateriaCorrelativa(){
        int seleccionFila;
        int respuesta;

        
        try{
            seleccionFila = mostrarMateriasCorrelativas.getjTableMateriasCorrelativas().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia Correlativa que desea Eliminar...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar la materia correlativa Seleccionada??", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION){
                    DB.carreras.get(idCarrera).materias.get(idMateria).getCorrelativas().remove(seleccionFila);
                    DefaultTableModel model = (DefaultTableModel)mostrarMateriasCorrelativas.getjTableMateriasCorrelativas().getModel();
                    model.removeRow(seleccionFila);
                }
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Eliminación de la Materia", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
}
