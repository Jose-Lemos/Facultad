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
public class Plan_D extends PlanEstudio{
    


    public Plan_D(Carrera carrera, char tipo) {
        super(carrera, tipo);
        this.setDescripcion("Aprobar las Cursadas de todas las Materias Correlativas y los Finales de los 3 Cuatrimestres Previos a la materia que se quiere anotar");
    }
    
    
    
    
    private boolean verificarFinales3CuatrimestresPrevios(int nivelMateria, Alumno alumno){
        boolean finalesVerificados = true;
        List<Materia> materiasAVerificarFinales = new ArrayList<>();
        
        if(this.getCarrera().getMaterias().size()>0){
            if(nivelMateria == 8){
            
                    for(Materia materia : this.getCarrera().getMaterias()){
                        if(materia.getNivel() < 8 && materia.getNivel() > 1){
                            materiasAVerificarFinales.add(materia);
                        }
                    }
                    
                    if(materiasAVerificarFinales.size()>0){
                        int ind = 0; 
                        Materia materia;
                        
                        while(ind < materiasAVerificarFinales.size() && finalesVerificados == true){
                            materia = materiasAVerificarFinales.get(ind);
                            if(alumno.materiasAprobadas.contains(materia) == false){
                                finalesVerificados = false;
                            }
                            
                            ind++;
                        }
                    }
            }else{
                if(nivelMateria == 11){
            
                    for(Materia materia : this.getCarrera().getMaterias()){
                        if(materia.getNivel()<11 && materia.getNivel() > 2){
                            materiasAVerificarFinales.add(materia);
                        }
                    }
                    
                    if(materiasAVerificarFinales.size()>0){
                        int ind = 0; 
                        Materia materia;
                        
                        while(ind < materiasAVerificarFinales.size() && finalesVerificados == true){
                            materia = materiasAVerificarFinales.get(ind);
                            if(alumno.materiasAprobadas.contains(materia) == false){
                                finalesVerificados = false;
                            }
                            
                            ind++;
                        }
                    }
                }else{
                    if(nivelMateria == 15){
            
                        for(Materia materia : this.getCarrera().getMaterias()){
                            if(materia.getNivel()<15 && materia.getNivel() > 3){
                                materiasAVerificarFinales.add(materia);
                            }
                        }
                    
                        if(materiasAVerificarFinales.size()>0){
                            int ind = 0; 
                            Materia materia;
                        
                            while(ind < materiasAVerificarFinales.size() && finalesVerificados == true){
                                materia = materiasAVerificarFinales.get(ind);
                                if(alumno.materiasAprobadas.contains(materia) == false){
                                    finalesVerificados = false;
                                }
                            
                                ind++;
                            }
                        }
                    }else{
                        if(nivelMateria == 20){
            
                            for(Materia materia : this.getCarrera().getMaterias()){
                                if(materia.getNivel()<20 && materia.getNivel() > 6){
                                    materiasAVerificarFinales.add(materia);
                                }
                            }
                    
                            if(materiasAVerificarFinales.size()>0){
                                int ind = 0; 
                                Materia materia;
                        
                                while(ind < materiasAVerificarFinales.size() && finalesVerificados == true){
                                    materia = materiasAVerificarFinales.get(ind);
                                    if(alumno.materiasAprobadas.contains(materia) == false){
                                        finalesVerificados = false;
                                    }
                            
                                    ind++;
                                }
                            }
                        }else{
                            if(nivelMateria == 24){
                                for(Materia materia : this.getCarrera().getMaterias()){
                                    if(materia.getNivel()<24 && materia.getNivel() > 8 ){
                                        materiasAVerificarFinales.add(materia);
                                    }
                                }
                    
                                if(materiasAVerificarFinales.size()>0){
                                    int ind = 0; 
                                    Materia materia;
                        
                                    while(ind < materiasAVerificarFinales.size() && finalesVerificados == true){
                                        materia = materiasAVerificarFinales.get(ind);
                                        if(alumno.materiasAprobadas.contains(materia) == false){
                                            finalesVerificados = false;
                                        }
                            
                                        ind++;
                                    }
                                }
                            }else{
                                if(nivelMateria == 30){
                                    for(Materia materia : this.getCarrera().getMaterias()){
                                        if(materia.getNivel()<30 && materia.getNivel() > 11 ){
                                            materiasAVerificarFinales.add(materia);
                                        }
                                    }
                    
                                    if(materiasAVerificarFinales.size()>0){
                                        int ind = 0; 
                                        Materia materia;
                        
                                        while(ind < materiasAVerificarFinales.size() && finalesVerificados == true){
                                            materia = materiasAVerificarFinales.get(ind);
                                            if(alumno.materiasAprobadas.contains(materia) == false){
                                                finalesVerificados = false;
                                            }
                            
                                            ind++;
                                        }
                                    }
                                }else{
                                    for(Materia materia : this.getCarrera().getMaterias()){
                                        if(materia.getNivel()<35 && materia.getNivel() > 15 ){
                                            materiasAVerificarFinales.add(materia);
                                        }
                                    }
                    
                                    if(materiasAVerificarFinales.size()>0){
                                        int ind = 0; 
                                        Materia materia;
                        
                                        while(ind < materiasAVerificarFinales.size() && finalesVerificados == true){
                                            materia = materiasAVerificarFinales.get(ind);
                                            if(alumno.materiasAprobadas.contains(materia) == false){
                                                finalesVerificados = false;
                                            }
                            
                                            ind++;
                                        }
                                    }
                                }
                                
                            }
                        }
                    }
                }
            }
        }
        
        return finalesVerificados;
    }
    


    @Override
    public boolean verificarPlan(Alumno alumno, Materia materia) {
        boolean condicion1, condicion2;
        int nivelMateria = materia.getNivel();
        
        if(materia.correlativas.size()>0){
           condicion1 = materia.verificarCorrelativasRegularizadas(alumno);
        }
        else {
            condicion1 = true;
        }
        
        if(nivelMateria<8){
            condicion2 = true;
        }
        else{
            condicion2 = verificarFinales3CuatrimestresPrevios(nivelMateria, alumno);
        }
        
        return condicion1 && condicion2; //To change body of generated methods, choose Tools | Templates.
    }
}
