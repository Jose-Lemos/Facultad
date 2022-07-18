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
public class Materia {
    public static int id;
    String codigo;
    String nombre;
    String tipo;  // obligatoria u optativa
    int grado;  //Del 1 al año de duración de la carrera a la que pertenece esta materia
    int cuatrimestre;  // 1 o 2. 
    boolean promocion;  // si tiene  promoción true. sino false.
    List<Materia> correlativas = new ArrayList<>();  //falta metodo.
    Cursada cursada;
    int nivel;
    
    
    public Materia(String codigo, String nombre, String tipo, int grado, int cuatrimestre, boolean promocion)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.grado = grado;
        this.cuatrimestre = cuatrimestre;
        this.promocion = promocion;
        this.nivel = grado * cuatrimestre + grado * grado;
        crearCursada(this);
        DB.agregarMateria(this);
    }
    
    
    
    public List<Alumno> getAlumnosCusada(){
        return this.cursada.getAlumnos();
    }
    
    public boolean verificarCorrelativasRegularizadas(Alumno alumno){
       boolean correlativasValidas = true;
       int indCorrelativas = 0;
       
       while(indCorrelativas< correlativas.size() && correlativasValidas == true){
           if(alumno.materiasRegularizadas.contains(correlativas.get(indCorrelativas)) == false){
               correlativasValidas =false;
           }
           indCorrelativas++;
       }
       
        
       return correlativasValidas; 
    }
    
    public boolean verificarCorrelativasAprobadas(Alumno alumno){
        boolean correlativasValidas=false;
        int indCorrelativas = 0;
       
       while(indCorrelativas< correlativas.size() && correlativasValidas == true){
           if(alumno.materiasAprobadas.contains(correlativas.get(indCorrelativas)) == false){
               correlativasValidas =false;
           }
           indCorrelativas++;
       }
       

        return correlativasValidas;
    }
    
    public void crearCursada(Materia materia){  //falta definir.
        this.cursada = new Cursada(materia);
        DB.cursadas.add(cursada);
    } 
    
    public void asignarCorrelativas(Materia materia){  //falta definir.
        correlativas.add(materia);
    }
    
    public void AsignarId()
    {
        this.id = this.id +1;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getGrado() {
        return grado;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public boolean isPromocion() {
        return promocion;
    }

    public Cursada getCursada() {
        return cursada;
    }
    
    
    
    public String getGradoString(){
        Integer grado = new Integer(this.grado);
        return grado.toString();
    }
    
    public String getCuatrimestreString(){
        Integer cuatrimestre = new Integer(this.cuatrimestre);
        return cuatrimestre.toString();
    }
    
    public String getPromocionString(){
        if (promocion == true){
            return "SI";
        }
        else{
            return "NO";
        }        
    }

    public String getCantidadCorrelativasString(){
        Integer cantidadCorrelativas = new Integer(this.correlativas.size());
        return cantidadCorrelativas.toString();
    }
    
    @Override
    public String toString() {
        return "Materia{" + "codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", grado=" + grado + ", cuatrimestre=" + cuatrimestre + ", promocion=" + promocion + '}';
    }
    
    
    public int getNivel(){
        return this.nivel;
    }
}




