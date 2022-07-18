/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Ventanas.MostrarCarreras;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;

/**
 *
 * @author eljos
 */
public class MostrarCarrerasController {
    public static MostrarCarreras mostrarCarreras = new MostrarCarreras();
    
    public static void mostrarVentana(){
        cargarCarreras();
        mostrarCarreras.setVisible(true);
        
    }
    
    public static void ocultarVentana(){
        mostrarCarreras.setVisible(false);
    }
    
    public static void back(){
        MostrarCarrerasController.ocultarVentana();
        PrincipalController.mostrarVentanaPrincipal();
    }
    
    public static void mostrarMaterias(){
        int seleccionFila;

        try{
            seleccionFila = mostrarCarreras.getjTable1().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Carrera de la que desea ver Las Materias...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                MostrarCarrerasController.ocultarVentana();
                MostrarMateriasController.crearVentana(seleccionFila);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo Mostrar Las Materias de la Carrera", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void mostrarAlumnos(){
        int seleccionFila;

        try{
            seleccionFila = mostrarCarreras.getjTable1().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Carrera de la que desea ver Los Alumnos...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                ocultarVentana();
                MostrarAlumnosCarreraController.mostrarVentana(seleccionFila);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo Mostrar Los Alumnos de la Carrera", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void cargarCarreras(){
//        mostrarCarreras.cargarCarreras();
        String matrix[][] = new String[DB.carreras.size()][6];
        for(int i=0; i<DB.carreras.size() ;i++){
            matrix[i][0] = DB.carreras.get(i).getCodigo();
            matrix[i][1] = DB.carreras.get(i).getNombre();
            matrix[i][2] = DB.carreras.get(i).getDuracion();
            matrix[i][3] = DB.carreras.get(i).getCantidadMaterias();
            matrix[i][4] = DB.carreras.get(i).getCantidadAlumnos();
            matrix[i][5] = DB.carreras.get(i).planEstudio.getTipo();
        }
        
        JTable tablaCarreras = mostrarCarreras.getjTable1();
        tablaCarreras.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Codigo","Carrera","Duracion","N° Materias", "N° Alumnos", "Tipo-Plan"
        }
        ));
}
    
    public static void eliminarCarrera(){
        int seleccionFila;
        int respuesta;

        
        try{
            seleccionFila = mostrarCarreras.getjTable1().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Carrera que desea Eliminar...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar la carrera Seleccionada??", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION){
                    DB.carreras.remove(seleccionFila);
                    DefaultTableModel model = (DefaultTableModel)mostrarCarreras.getjTable1().getModel();
                    model.removeRow(seleccionFila);
                }
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Eliminación de la Carrera", "Error", JOptionPane.ERROR_MESSAGE);
    }
    } 
    
    public static void renombrarCarrera(){
        int seleccionFila;
        String nombreNuevo;

        
        try{
            seleccionFila = mostrarCarreras.getjTable1().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Carrera que desea Renombrar...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                nombreNuevo = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la Carrera:");
                DB.carreras.get(seleccionFila).setNombre(nombreNuevo);
                DefaultTableModel model = (DefaultTableModel)mostrarCarreras.getjTable1().getModel();
                model.setValueAt(nombreNuevo, seleccionFila, 1);
//                    model.removeRow(seleccionFila);
//                respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar la carrera Seleccionada??", "Eliminar", JOptionPane.YES_NO_OPTION);
//                if (respuesta == JOptionPane.YES_OPTION){
//                    DB.carreras.remove(seleccionFila);
//                    DefaultTableModel model = (DefaultTableModel)mostrarCarreras.getjTable1().getModel();
//                    model.removeRow(seleccionFila);
//                }
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo renombrar la Carrera Seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
}