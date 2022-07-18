/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.ArrayList;
import java.util.List;
import model.Alumno;
import model.Carrera;
import model.Materia;

/**
 *
 * @author eljos
 */
public class Principal {
    
    
    public static void main(String[] args) {
          PrincipalController.mostrarVentanaPrincipal();
          //Creo las Carreras Iniciales
          List<Materia> materiasSistemas = new ArrayList<>();
          List<Materia> materiasTurismo = new ArrayList<>();
          
          Carrera Sistemas = new Carrera("AAA","Lic en Sistemas",5,'A');
          Carrera Biologia = new Carrera("BBB","Lic en Biologia",5,'B');
          Carrera Turismo = new Carrera("CCC","Lic en Turismo",5,'C');
          Carrera Sociologia = new Carrera("DDD","Lic en Sociología",5,'D');
          Carrera Politica = new Carrera("EEE","Lic en Ciencias Políticas", 5, 'E');
          
          //Creo las Materias, para definirlas en Lic de Sistemas 
          Materia matSis1= new Materia("AAA","Algebra","Obligatoria",1,1,true);
          Materia matSis2= new Materia("AAB","Analisis Matematico","Obligatoria",1,2,true);
          Materia matSis3= new Materia("AAC","Arquitectura de Computadoras","Obligatoria",2,1,false);
          Materia matSis4= new Materia("AAD","Programacion Orientada a Objetos","Obligatoria",2,2,true);
          Materia matSis5= new Materia("AAE","Introduccion a la Concurrencia","Obligatoria",3,1,true);
          Materia matSis6= new Materia("AAF","Laboratorio de Software","Obligatoria",3,2,true);
          Materia matSis7= new Materia("AAG","Redes y Transmisión de Datos","Obligatoria",4,1,false);
          Materia matSis8= new Materia("AAH","Sistemas Distribuidos","Obligatoria",4,2,true);
          Materia matSis9= new Materia("AAI","Sistemas Paralelos","Obligatoria",5,1,false);
          Materia matSis10= new Materia("AAJ","Proyecto Software","Obligatoria",5,2,true);
          
          //Agrego las materias creadas a la lista 
          materiasSistemas.add(matSis1);
          materiasSistemas.add(matSis2);
          materiasSistemas.add(matSis3);
          materiasSistemas.add(matSis4);
          materiasSistemas.add(matSis5);
          materiasSistemas.add(matSis6);
          materiasSistemas.add(matSis7);
          materiasSistemas.add(matSis8);
          materiasSistemas.add(matSis9);
          materiasSistemas.add(matSis10);
          
          //defino las materias creadas como las materias de la carrera de sistemas
          Sistemas.definirMaterias(materiasSistemas);
          
          //creo los alumnos, que van a tomar la carrera de sistemas
          Alumno alumSis1 = new Alumno(1, 42760470,"Jose Luis", "Lemos", "Tolhuin Urquiza 161", "eljoselemons@gmail.com");
          Alumno alumSis2 = new Alumno(2, 11111,"Jeremias", "Schreiner", "Ushuaia Onas 245","jere_xd@gmail.com");
          Alumno alumSis3 = new Alumno(3, 34252435,"Lautaro", "Barba", "Ushuaia GBR Paz 426", "elLauchaFlix@gmail.com");
          Alumno alumSis4 = new Alumno(4, 4452525,"Joma", "Garay", "Ushuaia Magallanes 725","jomaFull@gmail.com");
          Alumno alumSis5 = new Alumno(5, 12342234,"Tomas", "Villanueva", "Ushuaia 527", "TomaxVilla@gmail.com");
          
          //Les asigno el Estado Regular.
          alumSis1.setEstado("Regular");
          alumSis2.setEstado("Regular");
          alumSis3.setEstado("Regular");
          alumSis4.setEstado("Regular");
          alumSis5.setEstado("Regular");
          
          //Les asigno la Carrera
          alumSis1.setCarrera(Sistemas);
          alumSis2.setCarrera(Sistemas);
          alumSis3.setCarrera(Sistemas);
          alumSis4.setCarrera(Sistemas);
          alumSis5.setCarrera(Sistemas);
          
          //Los inscribo a la carrera
          Sistemas.inscribirAlumno(alumSis1);
          Sistemas.inscribirAlumno(alumSis2);
          Sistemas.inscribirAlumno(alumSis3);
          Sistemas.inscribirAlumno(alumSis4);
          Sistemas.inscribirAlumno(alumSis5);
          
          //creo las materias para definirlas en la carrera de Turismo
          Materia matTur1= new Materia("CCA","Introduccion al Turismo","Obligatoria",1,1,true);
          Materia matTur2= new Materia("CCB","Economia","Obligatoria",1,2,true);
          Materia matTur3= new Materia("CCC","Investigacion I","Obligatoria",2,1,false);
          Materia matTur4= new Materia("CCD","Parques","Obligatoria",2,2,true);
          Materia matTur5= new Materia("CCE","Turismo Nacional","Obligatoria",3,1,true);
          Materia matTur6= new Materia("CCF","Turismo Internacional","Obligatoria",3,2,true);
          Materia matTur7= new Materia("CCG","Guias Turisticas","Obligatoria",4,1,false);
          Materia matTur8= new Materia("CCH","Proyecto Turistico","Obligatoria",4,2,true);
          Materia matTur9= new Materia("CCI","Investigacion II","Obligatoria",5,1,false);
          Materia matTur10= new Materia("CCJ","Proyecto FINAL ","Obligatoria",5,2,true);
          
          //Agrego las Materias creadas a la lista
          materiasTurismo.add(matTur1);
          materiasTurismo.add(matTur2);
          materiasTurismo.add(matTur3);
          materiasTurismo.add(matTur4);
          materiasTurismo.add(matTur5);
          materiasTurismo.add(matTur6);
          materiasTurismo.add(matTur7);
          materiasTurismo.add(matTur8);
          materiasTurismo.add(matTur9);
          materiasTurismo.add(matTur10);
          
          //Agrego las materias creadas a la Carrera de Turismo
          Turismo.definirMaterias(materiasTurismo);
          
          //creo los alumnos, que van a tomar la carrera de sistemas
          Alumno alumTur1 = new Alumno(423, 423256,"Javier", "Lopez", "Ushua Deloqui 161", "JAVA@gmail.com");
          Alumno alumTur2 = new Alumno(234, 462323,"Andres", "Torres", "Ushuaia Onas 700","Andy@gmail.com");
          Alumno alumTur3 = new Alumno(254, 235617,"Adrian", "Zole", "Ushuaia San Martin 764", "Adryzel@gmail.com");
          Alumno alumTur4 = new Alumno(623, 436825,"Dario", "Jurado", "Ushuaia Pipo 243","DarK@gmail.com");
          Alumno alumTur5 = new Alumno(562, 9065234,"Mateo", "Valencia", "Ushuaia 640", "Matax@gmail.com");
          
          //Les asigno el Estado Regular.
          alumTur1.setEstado("Regular");
          alumTur2.setEstado("Regular");
          alumTur3.setEstado("Regular");
          alumTur4.setEstado("Regular");
          alumTur5.setEstado("Regular");
          
          //Les asigno la Carrera
          alumTur1.setCarrera(Turismo);
          alumTur2.setCarrera(Turismo);
          alumTur3.setCarrera(Turismo);
          alumTur4.setCarrera(Turismo);
          alumTur5.setCarrera(Turismo);
          
          //Los inscribo a la carrera
          Turismo.inscribirAlumno(alumTur1);
          Turismo.inscribirAlumno(alumTur2);
          Turismo.inscribirAlumno(alumTur3);
          Turismo.inscribirAlumno(alumTur4);
          Turismo.inscribirAlumno(alumTur5);

    }
    
//ADFA	Materia uno	1	1	Obligatoria	SI	0	0
//KJSC	Materia dos	1	2	Obligatoria	SI	0	1
//HDSCVK	Materia tres	2	1	Obligatoria	SI	0	1
//JSDCJ	Materia cuatro	2	2	Obligatoria	NO	0	0
//IUYHDSF	Materia Cinco	3	1	Obligatoria	SI	0	0
//SJJF	Materia seis	3	2	Optativa	SI	0	1
//JSJF	Materia siete	4	1	Obligatoria	SI	0	0
//JSKF	Materia ocho	4	2	Obligatoria	SI	0	2
//UYSG	Materia nueve	5	1	Optativa	SI	0	0
//OUISDH	Materia diez	5	2	Obligatoria	NO	0	1
}
