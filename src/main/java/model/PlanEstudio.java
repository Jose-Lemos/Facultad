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
public abstract class PlanEstudio {
    private static int id;
    char tipo;
    Carrera carrera;
    String descripcion;
  //asignada.
    
    
    PlanEstudio(Carrera carrera, char tipo)
    {
        AsignarId();
        this.carrera = carrera;
        this.tipo = tipo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    private void AsignarId()
    {
        this.id = this.id +1;
    }
    

    
    public String getTipo(){
        String S = Character.toString(tipo);
        return S;
    }
    
    public abstract boolean verificarPlan(Alumno alumno, Materia materia);
}
