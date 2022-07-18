 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author eljos
 */
public class Plan_A extends PlanEstudio{ //condicionInscripcion
    
    
//    public Plan_A(PlanEstudio planEstudio) 
//    {
//        AsignarId();
//        String descripcion = new String("Aprobar las cursadas de todas las materias correlativas");    
//        this.descripcion = descripcion;
//        this.planEstudio = planEstudio;
//    }

    public Plan_A(Carrera carrera, char tipo) {
        super(carrera, tipo);
        this.setDescripcion("Aprobar todas las Cursadas de las Materias Correlativas");
    }
    
    
//    public Plan_A(PlanEstudio planEstudio) 
//    {
//        AsignarId();
//        String descripcion = new String("Aprobar las cursadas de todas las materias correlativas");    
//        this.descripcion = descripcion;
//        this.planEstudio = planEstudio;
//    }

    @Override
    public boolean verificarPlan(Alumno alumno, Materia materia) {
        boolean planValido;
        if(materia.correlativas.size()>0){
           planValido = materia.verificarCorrelativasRegularizadas(alumno);
        }
        else {
            planValido = true;
        }
        return planValido;
    } 

}
