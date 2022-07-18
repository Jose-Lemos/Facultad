/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author eljos
 */
public class Examen {

    String fecha;
    int notaExamen;
    String tipo;
    Alumno alumno ;  //falta metodo.
    Cursada cursada;
    

    Examen( String tipo, Cursada cursada, Alumno alumno)
    {
        this.alumno = alumno;
        this.tipo = tipo;
        this.cursada = cursada;
        this.fecha = asignarFecha();
        DB.agregarExamen(this);
    }
    
    private String asignarFecha(){
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }
    
    private int darDevolucionExamen(){
        Random randomclass = new Random();
        int nota =  2+randomclass.nextInt(10-2);
        return nota;
    }
    

    
    public void tomarExamenParcial(){
            notaExamen = darDevolucionExamen();
            alumno.examenesRendidos.add(this);
            
            if(notaExamen < 4){
                
                alumno.getCursadas().remove(cursada.getMateria());
            }
            
            else{
                if(cursada.getMateria().isPromocion() && notaExamen > 7){
                    Examen examenFinal = new Examen("Final", cursada, alumno);
                    examenFinal.setNotaExamen(notaExamen);
                    alumno.examenesRendidos.add(examenFinal);
                    alumno.getMateriasAprobadas().add(cursada.getMateria());
                    alumno.getCursadas().remove(cursada.getMateria());
                }else{
                    alumno.getMateriasRegularizadas().add(cursada.getMateria());
                    alumno.getCursadas().remove(cursada.getMateria());
                }
                
            }
            
    }
    
    public void tomarExamenFinal(){
        
            notaExamen = darDevolucionExamen();
            alumno.examenesRendidos.add(this);
            
            if (notaExamen> 3){
                alumno.getMateriasAprobadas().add(cursada.getMateria());
                alumno.getMateriasRegularizadas().remove(cursada.getMateria());
                
            }
            
           
        
    }

    public int getNotaExamen() {
        return notaExamen;
    }

    public void setNotaExamen(int notaExamen) {
        this.notaExamen = notaExamen;
    }

    public Cursada getCursada() {
        return cursada;
    }

    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    
    public String getNotaExamenString(){
        Integer notaString = new Integer(notaExamen);
        return notaString.toString();
    }

    public String getFecha() {
        return fecha;
    }
    
    
}


