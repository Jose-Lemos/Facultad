/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Ventanas.InscribirAMateria;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Alumno;
import model.DB;
import model.Materia;

/**
 *
 * @author eljos
 */
public class InscribirAMateriaController {
    public static InscribirAMateria inscribirAMateria = new InscribirAMateria();
    static int idAlumno;
    
    public static void mostrarVentana(int idAlumno){
        InscribirAMateriaController.idAlumno = idAlumno;
        cargarMateriasCarrera();
        inscribirAMateria.setVisible(true);
    }
    
    public static void ocultarVentana(){
        inscribirAMateria.setVisible(false);
    }
    
    public static void back(){
        ocultarVentana();
        MostrarAlumnosController.mostrarVentana();
    }
    
    private static void cargarMateriasCarrera(){
        String matrix[][] = new String[DB.alumnos.get(idAlumno).getCarrera().getMaterias().size()][8];
        
        for(int i=0;i <DB.alumnos.get(idAlumno).getCarrera().getMaterias().size(); i++ ){
            matrix[i][0] = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(i).getCodigo();
            matrix[i][1] = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(i).getNombre();
            matrix[i][2] = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(i).getGradoString();
            matrix[i][3] = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(i).getCuatrimestreString();
            matrix[i][4] = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(i).getTipo();
            matrix[i][5] = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(i).getPromocionString();
            matrix[i][6] = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(i).getCursada().cantidadAlumnosString();
            matrix[i][7] = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(i).getCantidadCorrelativasString();
        }
        
        JTable tablaMaterias = inscribirAMateria.getjTableMaterias();
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
        matrix, new String[] {
                "Codigo","Nombre","Grado","Cuatrimestre", "Tipo","Promocion","N° de Alumnos","N° Correlativas"
        }
        ));
    }
    
    public static void verificarPlanEstudio(){
        int seleccionFila;
        boolean planValido;

        
        try{
            seleccionFila = inscribirAMateria.getjTableMaterias().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia que desea Verificar las Correlativas...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                planValido = DB.alumnos.get(idAlumno).getCarrera().planEstudio.verificarPlan(DB.alumnos.get(idAlumno), DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(seleccionFila));
                String informar = ""
                        + "";
                
                if(planValido == true){
                    informar += "El Alumno CUMPLE con el Plan de Estudio de la Carrera para inscribirse a la Materia. "
                            + "";
                    JOptionPane.showMessageDialog(null, informar+ "Descripción de Plan: "+DB.alumnos.get(idAlumno).getCarrera().planEstudio.getDescripcion());
                }
                else{
                    informar += "El Alumno NO CUMPLE con el Plan de Estudio de la Carrera para inscribirse a la Materia. "
                            + "";
                    JOptionPane.showMessageDialog(null, informar+ "Descripción de Plan: "+DB.alumnos.get(idAlumno).getCarrera().planEstudio.getDescripcion(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Inscripción del Alumno a la Materia", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public static void verificarCorrelativas(){
        int seleccionFila;
        boolean correlativasValidas;

        
        try{
            seleccionFila = inscribirAMateria.getjTableMaterias().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia que desea Verificar las Correlativas...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                correlativasValidas = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(seleccionFila).verificarCorrelativasRegularizadas(DB.alumnos.get(idAlumno));
                
                if(DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(seleccionFila).getCorrelativas().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Esta Materia no tiene definida NINGUNA CORRELATIVA. Por lo tanto, el alumno cumple con las correlativas");
                }else{
                    if(correlativasValidas == true){
                        JOptionPane.showMessageDialog(null, "El Alumno CUMPLE con las Materias Correlativas Regularizadas");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El Alumno NO CUMPLE con las Materias Correlativas Regularizadas","ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Inscripción del Alumno a la Materia", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public static void inscribirAlumnoAMateria(){
        int seleccionFila;
        boolean planValido, correlativasValidas;
        String informe = "";
        
        try{
            seleccionFila = inscribirAMateria.getjTableMaterias().getSelectedRow();
            if (seleccionFila == -1){
                JOptionPane.showMessageDialog(null, "Debe Seleccionar la Materia en la que desea inscribir al Alumno...","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                Alumno alumnoSeleccionado = DB.alumnos.get(idAlumno);
                Materia materiaSeleccionada = DB.alumnos.get(idAlumno).getCarrera().getMaterias().get(seleccionFila);
                
                correlativasValidas = materiaSeleccionada.verificarCorrelativasRegularizadas(alumnoSeleccionado);
                planValido = alumnoSeleccionado.getCarrera().planEstudio.verificarPlan(alumnoSeleccionado, materiaSeleccionada);
                
                if(correlativasValidas && planValido && alumnoSeleccionado.getCursadas().contains(materiaSeleccionada) == false){
                    if(alumnoSeleccionado.getMateriasAprobadas().contains(materiaSeleccionada)==false && alumnoSeleccionado.getMateriasRegularizadas().contains(materiaSeleccionada)==false){
                        alumnoSeleccionado.getCursadas().add(materiaSeleccionada);
                        materiaSeleccionada.getCursada().InscribirAlumno(alumnoSeleccionado);
                        
                        JOptionPane.showMessageDialog(null, "Alumno Inscripto EXITOSAMENTE!!");
                        cargarMateriasCarrera();
                    }else{
                       JOptionPane.showMessageDialog(null, "Esta Materia Ya fue Aprobada por el Alumno, y No se puede inscribir de nuevo", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                }else{
                    if(correlativasValidas == true){
                        informe += "Correlativas Válidas! \n";
                    }
                    else{
                        informe += "Correlativas Inválidas! \n";
                    }
                    
                    if(planValido == true){
                        informe += "Plan de Estudio Válido! \n";
                    }
                    else{
                        informe += "Plan de Estudio Inválido! \n";
                    }
                    
                    if(alumnoSeleccionado.getCursadas().contains(materiaSeleccionada)){
                        informe += "El Alumno ya estaba Inscripto en la Materia, No se puede Inscribir dos veces \n";
                    }
                    
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la Inscripción. Revisar: \n"+informe,"Error", JOptionPane.ERROR_MESSAGE);
                }    
            }
            
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No se pudo realizar la Inscripción del Alumno a la Materia", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public static void mostrarMateriasParaCursar(){
        ocultarVentana();
        MateriasEnCondicionDeCursarController.mostrarVentana(idAlumno);
    }
}
