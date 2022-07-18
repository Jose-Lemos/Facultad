/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.DB;

/**
 *
 * @author eljos
 */
public class Carrera {
    private static int id;
    public String codigo;
    public String nombre;
    public int duracion;
    public  PlanEstudio planEstudio;
    public int porcentajeOptativasRequeridas;
    public List<Alumno> alumnos = new ArrayList<>();  //faltan metodos.
    public List<Materia> materias = new ArrayList<>();
    
    public Carrera(String codigo, String nombre, int duracion,char tipo)
    {
        AsignarId();
        this.codigo = codigo;
        this.nombre = nombre;
        this.duracion = duracion;
        determinarPlan(tipo);
        DB.agregarCarrera(this);
    }
    
    
    
    private  void determinarPlan(char tipo){
        if (tipo =='A'){
            this.planEstudio = new Plan_A(this,tipo);
        }
        else{
            if(tipo == 'B'){
                this.planEstudio = new Plan_B(this,tipo);
            }
            else{
                if(tipo == 'C'){
                    this.planEstudio = new Plan_C(this,tipo);
                }
                else{
                    if (tipo == 'D'){
                        this.planEstudio = new Plan_D(this,tipo);
                    }
                    else {
                        this.planEstudio = new Plan_E(this,tipo);
                    }
                }
            }
        } 
            
    }
    
    public void definirMaterias(List<Materia> materias){
        this.materias = materias;
        
    }
    
    public List<Materia> getMaterias(){
        return this.materias;
    }
    
    public void eliminarMateria(Materia materia){
        this.materias.remove(materia);
        DB.bajaMateria(materia);
    }
    
    public void inscribirAlumno(Alumno alumno){
       alumnos.add(alumno);
    }
    
    public List<Alumno> getAlumnosCarrera(){
        return alumnos;
    }
    
    public void bajaAlumno(Alumno alumno){
        alumnos.remove(alumno);
    }
    
    private void AsignarId(){
        
        
        this.id = this.id +1;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getId() {
        return id;
    }
    
//    public int cantidadMateriasOptativasTotales(){
//        int cantidadOptativas=0;
//        
//        if(materias.size()>0){
//            for(int i=0; i< materias.size(); i++ ){
//                if(materias.get(i).tipo == "Optativa"){
//                    cantidadOptativas++;
//                }
//            }
//        }
//        
//        return cantidadOptativas;
//    }
//    
//    public int cantidadMateriasObligatoriasTotales(){
//        int cantidadObligatorias = 0;
//        
//        if(materias.size()>0){
//            for(int i=0; i< materias.size(); i++ ){
//                if(materias.get(i).tipo == "Obligatoria"){
//                    cantidadObligatorias++;
//                }
//            }
//        }
//        
//        return cantidadObligatorias;
//    }
    
    public int definirCantidadOptativasRequeridas(int porcentajeOptativas){// va desde el 30 % hasta el 70 %
        porcentajeOptativas = limitarPorcentaje(porcentajeOptativas);
        
        return (int)Math.round(porcentajeOptativas * cantidadMateriasOptativas()/100);
    }
    
    public String getDuracion(){
        Integer anios = new Integer(duracion); 
        return anios.toString();
    }
    
    public String getCantidadMaterias(){
        Integer cantidadM = new Integer(materias.size());
        return cantidadM.toString();
    }
    
    public String getCantidadAlumnos(){
        Integer cantidadA = new Integer(alumnos.size());
        return cantidadA.toString();
    }

    public void setPorcentajeOptativasRequeridas(int porcentajeOptativasRequeridas) {
        porcentajeOptativasRequeridas = limitarPorcentaje(porcentajeOptativasRequeridas);
        
        this.porcentajeOptativasRequeridas = porcentajeOptativasRequeridas;
    }
    
    private static int limitarPorcentaje(int valorPorcentaje){
        
        if(valorPorcentaje < 30){
                valorPorcentaje = 30;
            }else{
                if(valorPorcentaje > 70){
                    valorPorcentaje = 70;
                }
            }
        return valorPorcentaje;
    }
    
    public int cantidadMateriasObligatorias(){
        int cantidadMateriasObligatorias = 0;
        if(materias.size()>0){
            for(Materia materia : materias){
                if(materia.getTipo()=="Obligatoria"){
                    cantidadMateriasObligatorias++;
                }
            }
        }
        return cantidadMateriasObligatorias;
    }
    
    public int cantidadMateriasOptativas(){
        int cantidadMateriasOptativas = 0;
        if(materias.size()>0){
            for(Materia materia : materias){
                if(materia.getTipo()=="Optativa"){
                    cantidadMateriasOptativas++;
                }
            }
        }
        return cantidadMateriasOptativas;
    }
    
    public int cantidadOptativasRequeridasParaGraduacion(){
        return definirCantidadOptativasRequeridas(this.porcentajeOptativasRequeridas);
    }
    
    public boolean verificarAlumnoGraduado(Alumno alumno){
        if(alumnos.contains(alumno)){
            int cantidadObligatoriasRequeridas = this.cantidadMateriasObligatorias();
            int cantidadOptativasRequeridas = this.cantidadOptativasRequeridasParaGraduacion();
            
            int cantidadOptativasAprobadas = alumno.cantidadMateriasObligatoriasAprobadas();
            int cantidadObligatoriasAprobadas = alumno.cantidadMateriasOptativasAprobadas();
            
            return ((cantidadObligatoriasRequeridas-cantidadObligatoriasAprobadas == 0)&&(cantidadOptativasRequeridas-cantidadOptativasAprobadas == 0));
        }else{
            return false;
        }
    }
}
