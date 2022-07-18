/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author eljos
 */
public class Cursada {
    private static int id;
    String fechaDesde;
    String fechaHasta;

    Materia materia;
    List<Alumno> alumnos = new ArrayList<>();
//    List<Examen> examenesTomados = new ArrayList<>();//faltan metodos.
//    List<Examen> examenesParciales = new ArrayList<>();  //faltan metodos.
//    List<Examen> examenesRecuperatorios = new ArrayList<>();  //faltan metodos.
//    List<Examen> examenesFinales = new ArrayList<>();  //faltan metodos.
    
//    Cursada(String fechaDesde, String fechaHasta,String aula, Materia materia)
    Cursada(Materia materia){
    
        AsignarId();
        this.fechaDesde = asignarFecha();
        this.materia = materia;
    }
    
    private void AsignarId()
    {
        this.id = this.id +1;
    }
    
    private String asignarFecha(){
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }
    
    public void InscribirAlumno(Alumno alumno){
        this.alumnos.add(alumno);
    }
    
    public void darBajaAlumno(Alumno alumno){
        this.alumnos.remove(alumno);
    }
    
    public List<Alumno> getAlumnos(){
        return alumnos;
    }
    
    public String cantidadAlumnosString(){
        Integer cantidadAlumnos = new Integer(alumnos.size());
        return cantidadAlumnos.toString();
    }
    


    public Materia getMateria() {
        return materia;
    }
    
    
//    public int getIdParcialAlumno(Alumno alumno){
//        boolean alumnoEncontrado = false;
//        int indExamen = 0;
//        while(indExamen < examenesParciales.size() && alumnoEncontrado == false){
//            if(examenesParciales.get(indExamen).getAlumno() == alumno){
//                alumnoEncontrado = true;
//            }
//            indExamen++;
//        }
//        
//        return indExamen;
//    }
    
//    public int getIdRecuperatorioAlumno(Alumno alumno){
//        boolean alumnoEncontrado = false;
//        int indExamen = 0;
//        while(indExamen < examenesRecuperatorios.size() && alumnoEncontrado == false){
//            if(examenesRecuperatorios.get(indExamen).getAlumno() == alumno){
//                alumnoEncontrado = true;
//            }
//            indExamen++;
//        }
//        
//        return indExamen;
//    }
//    
    
//    public int getIdFinalAlumno(Alumno alumno){
//        boolean alumnoEncontrado = false;
//        int indExamen = 0;
//        while(indExamen < examenesFinales.size() && alumnoEncontrado == false){
//            if(examenesFinales.get(indExamen).getAlumno() == alumno){
//                alumnoEncontrado = true;
//            }
//            indExamen++;
//        }
//        
//        if(alumnoEncontrado){
//            return indExamen;
//        }else{
//            return -1;
//        }
//    }
    
    
    public void tomarAExamenFinal(Alumno alumno){
        Examen examenFinal = new Examen("Final" , this, alumno);
//        examenesFinales.add(examenFinal);
        examenFinal.tomarExamenFinal();
        
    }
    
    public void tomarExamenParcial(Alumno alumno){
        if(alumnos.contains(alumno)){
            Examen examenCursada = new Examen("Parcial", this, alumno);
            examenCursada.tomarExamenParcial();
        }else{
            JOptionPane.showMessageDialog(null, "Este Alumno no Pertenece a la cursada");
        }
    }
    
    public void finalizarCursada(){
        this.fechaHasta = asignarFecha();
        this.getAlumnos().clear();
    }
    
    
    
//    public List<Examen> getExamenesTomados() {
//        return examenesTomados;
//    }

//    public List<Examen> getExamenesParciales() {
//        return examenesParciales;
//    }
//
//    public List<Examen> getExamenesRecuperatorios() {
//        return examenesRecuperatorios;
//    }
//
//    public List<Examen> getExamenesFinales() {
//        return examenesFinales;
//    }
    
    
}
