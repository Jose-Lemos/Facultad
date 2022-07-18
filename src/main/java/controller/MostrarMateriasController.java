/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Ventanas.MostrarMaterias;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;

/**
 *
 * @author eljos
 */
public class MostrarMateriasController {
    public static int idCarrera;
    public static MostrarMaterias mostrarMateria = new MostrarMaterias();
    
    public static void crearVentana(int idCarrera){
        MostrarMateriasController.idCarrera = idCarrera;
        
        cargarMaterias(idCarrera);
        
        mostrarMateria.setVisible(true);
    }
    
    public static void cerrarVentana(){
        mostrarMateria.setVisible(false);
    }
    
    public static void back(MostrarMaterias mostrarMateria){
        MostrarMateriasController.cerrarVentana();
        MostrarCarrerasController.mostrarVentana();
    }

    
    public static void cargarMaterias(int idCarrera){
        String matrix[][] = new String[DB.carreras.get(idCarrera).materias.size()][8];
        
        for(int i=0;i <DB.carreras.get(idCarrera).materias.size(); i++ ){
            matrix[i][0] = DB.carreras.get(idCarrera).materias.get(i).getCodigo();
            matrix[i][1] = DB.carreras.get(idCarrera).materias.get(i).getNombre();
            matrix[i][2] = DB.carreras.get(idCarrera).materias.get(i).getGradoString();
            matrix[i][3] = DB.carreras.get(idCarrera).materias.get(i).getCuatrimestreString();
            matrix[i][4] = DB.carreras.get(idCarrera).materias.get(i).getTipo();
            matrix[i][5] = DB.carreras.get(idCarrera).materias.get(i).getPromocionString();
            matrix[i][6] = DB.carreras.get(idCarrera).materias.get(i).getCursada().cantidadAlumnosString();
            matrix[i][7] = DB.carreras.get(idCarrera).materias.get(i).getCantidadCorrelativasString();
        }
        
        JTable tablaMaterias = mostrarMateria.getjTableMaterias();
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Codigo","Nombre","Grado","Cuatrimestre", "Tipo","Promocion","N° de Alumnos","N° Correlativas"
        }
        ));
    }
    
    public static void eliminarMateria(){
        int seleccionFila;
        int respuesta;

        
        try{
            seleccionFila = mostrarMateria.getjTableMaterias().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia que desea Eliminar...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar la materia Seleccionada??", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION){
                    DB.materias.remove(seleccionFila);
                    DB.carreras.get(idCarrera).materias.remove(seleccionFila);
                    DefaultTableModel model = (DefaultTableModel)mostrarMateria.getjTableMaterias().getModel();
                    model.removeRow(seleccionFila);
                }
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Eliminación de la Materia", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public static void definirMateriasCorrelativas(){
        int seleccionFila;

        
        try{
            seleccionFila = mostrarMateria.getjTableMaterias().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia para definir las correlativas...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                cerrarVentana();
                DefinirCorrelativasController.mostrarVentana(idCarrera, seleccionFila);
                
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Definición de las Materias Correlativas", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public static void mostrarMateriasCorrelativas(){
         int seleccionFila;

        
        try{
            seleccionFila = mostrarMateria.getjTableMaterias().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia para definir las correlativas...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                cerrarVentana();
                MostrarMateriasCorrelativasController.mostrarVentana(idCarrera, seleccionFila);
                
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Definición de las Materias Correlativas", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    
    public static void mostrarAlumnosMateria(){
        int seleccionFila;

        
        try{
            seleccionFila = mostrarMateria.getjTableMaterias().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia para poder ver los alumnos Inscriptos a la Cursada...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                cerrarVentana();
                MostrarAlumnosMateriaController.mostrarVentana(idCarrera, seleccionFila);
                
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Muestra de Alumnos de la Cursada", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
}
