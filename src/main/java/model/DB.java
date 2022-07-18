/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eljos
 */
public class DB {
    
    public static List<Carrera> carreras = new ArrayList<>();
    public static List<Alumno> alumnos = new ArrayList<>();
    public static List<Materia> materias = new ArrayList<>();
    public static List<Examen> examenes = new ArrayList<>();
    public static List<Cursada> cursadas = new ArrayList<>();

    
    public static void agregarAlumno(int legajo, int dni,String nombre,String apellido,
        String localidad,String correo){
        Alumno alumnoNuevo = new Alumno(legajo, dni, nombre, apellido, localidad, correo); 
        alumnos.add(alumnoNuevo);
    }
    
    public static void bajaAlumno(Alumno alumno){
        alumnos.remove(alumno);
    }
    
    public static void agregarMateria(Materia materia){
        materias.add(materia);
    }
    
    public static void bajaMateria(Materia materia){
        materias.remove(materia);
    }
    
    public static void agregarCarrera(Carrera carrera){
        carreras.add(carrera);
    }
    
    public static void bajaCarrera(Carrera carrera){
        carreras.remove(carrera);
    }
    
    public static void agregarExamen(Examen examen){
        examenes.add(examen);
    }
    
    
}
