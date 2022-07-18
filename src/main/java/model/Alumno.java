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
public class Alumno {
    private static int id;
    int legajo;
    int dni;
    String nombre;
    String apellido;
    String domicilio;
    String correo;
    String estado;
    Carrera carrera;  //falta asignar.
//    List<Cursada> cursadas = new ArrayList<>();  //faltan metodos.
    List<Materia> cursadas = new ArrayList<>();  //faltan metodos.
    List<Materia> materiasAprobadas = new ArrayList<>();
    List<Materia> materiasRegularizadas = new ArrayList<>();
    List<Examen> examenesRendidos = new ArrayList<>();

    
    
   
    
    public Alumno (int legajo, int dni,String nombre,String apellido,
           String domicilio ,String correo)//Integer telefono
    {
        AsignarId();
        this.legajo = legajo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.correo = correo;
        //this.telefono = telefono;
        this.estado = "ingresante";
        DB.alumnos.add(this);
        
    }
    
    
    
    
    private void AsignarId()
    {
        this.id = this.id +1;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

//    public Integer getTelefono() {
//        return telefono;
//    }
//
//    public void setTelefono(Integer telefono) {
//        this.telefono = telefono;
//    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    public String getStringLegajo(){
        Integer legajo = new Integer(this.legajo);
        return legajo.toString();
    }
    
    public String getStringDni(){
        Integer dni = new Integer(this.dni);
        return dni.toString();
    }
    
    public String getCarreraString(){
        if(this.carrera == null){
            return "Sin Inscripcion";
        }else{
            return this.carrera.getNombre();
        }   
    }

    public List<Materia> getCursadas() {
        return cursadas;
    }

    public void setCursadas(List<Materia> cursadas) {
        this.cursadas = cursadas;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public List<Materia> getMateriasRegularizadas() {
        return materiasRegularizadas;
    }
    
    
    public int cantidadMateriasOptativasAprobadas(){
        int cantidadOptativasAprobadas = 0;
        if(materiasAprobadas.size()>0){
            for(Materia materia : materiasAprobadas){
                if(carrera.materias.contains(materia) && materia.getTipo()=="Optativa"){
                    cantidadOptativasAprobadas++;
                }
            }
        }
        return cantidadOptativasAprobadas;
    }
    
    public int cantidadMateriasObligatoriasAprobadas(){
        int cantidadObligatoriasAprobadas = 0;
        if(materiasAprobadas.size()>0){
            for(Materia materia : materiasAprobadas){
                if(carrera.materias.contains(materia) && materia.getTipo()=="Obligatoria"){
                    cantidadObligatoriasAprobadas++;
                }
            }
        }
        return cantidadObligatoriasAprobadas;
    }
    
//    public int getNotaExamenRendido(Examen examen){
//        if (examenesRendidos.contains(examen)){
//            return examen.getNotaExamen();
//        }else{
//            return 0;
//        }
//    }
//    
    public String getTipoExamenRendido(Examen examen){
        if (examenesRendidos.contains(examen)){
            return examen.getTipo();
        }else{
            return "";
        }
    }

    public List<Examen> getExamenesRendidos() {
        return examenesRendidos;
    }
    
    
}
