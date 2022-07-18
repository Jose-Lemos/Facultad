/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Ventanas.DefinirCorrelativas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;
import model.Materia;

/**
 *
 * @author eljos
 */
public class DefinirCorrelativasController {
    public static DefinirCorrelativas definirCorrelativas = new DefinirCorrelativas();
    static int idMateria, idCarrera;
    
    public static void mostrarVentana(int idCarrera, int idMateria){
        DefinirCorrelativasController.idCarrera = idCarrera;
        DefinirCorrelativasController.idMateria = idMateria;
        
        cargarMaterias(idCarrera , idMateria);
        
        definirCorrelativas.setVisible(true);
    }
    
    public static void ocultarVentana(){
        definirCorrelativas.setVisible(false);
    }
    
    
    public static void back(){
        ocultarVentana();
        MostrarMateriasController.crearVentana(idCarrera); 
    }
    
    public static void cargarMaterias(int idCarrera,int idMateria){
        List<Materia> materiasCandidatas = new ArrayList<>();
         
        Materia materiaSeleccionada = DB.carreras.get(idCarrera).materias.get(idMateria);
        int nivelMateriaSeleccionada = materiaSeleccionada.getGrado()* materiaSeleccionada.getCuatrimestre()+ materiaSeleccionada.getGrado()*materiaSeleccionada.getGrado();
        
        for(int i=0;i <DB.carreras.get(idCarrera).materias.size(); i++ ){
            Materia materiaCarrera = DB.carreras.get(idCarrera).materias.get(i);
            int nivelMateriaCarrera = materiaCarrera.getGrado()* materiaCarrera.getCuatrimestre()+materiaCarrera.getGrado()*materiaCarrera.getGrado();
            
            
            if(nivelMateriaCarrera < nivelMateriaSeleccionada){
                materiasCandidatas.add(materiaCarrera);
            }
        }
        
        
        int indMatrix = 0;
        while(indMatrix < materiasCandidatas.size()){
            if(materiaSeleccionada.getCorrelativas().contains((materiasCandidatas.get(indMatrix)))){
                materiasCandidatas.remove(indMatrix);
            }
            indMatrix++;
        }
        
        String matrix[][] = new String[materiasCandidatas.size()][8];
                    for(int i=0; i < materiasCandidatas.size(); i++){
                        matrix[i][0] = materiasCandidatas.get(i).getCodigo();
                        matrix[i][1] = materiasCandidatas.get(i).getNombre();
                        matrix[i][2] = materiasCandidatas.get(i).getGradoString();
                        matrix[i][3] = materiasCandidatas.get(i).getCuatrimestreString();
                        matrix[i][4] = materiasCandidatas.get(i).getTipo();
                        matrix[i][5] = materiasCandidatas.get(i).getPromocionString();
                        matrix[i][6] = materiasCandidatas.get(i).getCursada().cantidadAlumnosString();
                        matrix[i][7] = materiasCandidatas.get(i).getCantidadCorrelativasString();
                    }    
                
            
        
        
        JTable tablaMaterias = definirCorrelativas.getjTableMateriasCandidatas();
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Codigo","Nombre","Grado","Cuatrimestre", "Tipo","Promocion","N° de Alumnos","N° Correlativas"
        }
        ));
    }
    
    public static void agregarCorrelativa(){
        int seleccionFila;
        int respuesta;

        
        try{
            seleccionFila = definirCorrelativas.getjTableMateriasCandidatas().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia que desea agregar como Correlativa...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                respuesta = JOptionPane.showConfirmDialog(null, "Desea Definir esta Materia como Correlativa??", "Eliminar", JOptionPane.YES_NO_OPTION);
                
                if (respuesta == JOptionPane.YES_OPTION){
                    Materia materia = DB.carreras.get(idCarrera).materias.get(seleccionFila);
                    DB.carreras.get(idCarrera).materias.get(idMateria).asignarCorrelativas(materia);
                    JOptionPane.showMessageDialog(null, "Correlativa Definida");
                    cargarMaterias(idCarrera, idMateria);
                }
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Definición de la Materia Correlativa", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
}
