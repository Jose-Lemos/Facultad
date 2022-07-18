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
public class Plan_B extends PlanEstudio{
    
//    public Plan_B(PlanEstudio planEstudio) 
//    {
//        AsignarId();
//        String descripcion = new String("Aprobar los finales de todas las materias correlativas");    
//        this.descripcion = descripcion;
//        this.planEstudio = planEstudio;
//    }

    public Plan_B(Carrera carrera, char tipo) {
        super(carrera, tipo);
        this.setDescripcion("Aprobar los Finales de todas las Materias Correlativas");
    }
    
//    public Plan_B(PlanEstudio planEstudio) 
//    {
//        AsignarId();
//        String descripcion = new String("Aprobar los finales de todas las materias correlativas");    
//        this.descripcion = descripcion;
//        this.planEstudio = planEstudio;
//    }

    @Override
    public boolean verificarPlan(Alumno alumno, Materia materia) {
        boolean planValido;
        if(materia.correlativas.size()>0){
           planValido = materia.verificarCorrelativasAprobadas(alumno);
        }
        else {
            planValido = true;
        }
        return planValido; //To change body of generated methods, choose Tools | Templates.
    }
}
