package com.mycompany.app;

//import java.time.LocalDate;
//import java.util.function.Predicate;

public class Funcional01Test {
    
    /*@Test
    public void debeBuscarAlumnosMayoresDeEdad01() {

        int cantidadAlumnosEsperada = 30;
        
        Materia m1 = generarMateriaConAlumnos(cantidadAlumnosEsperada);

         var cantidadAlumnosActual = m1.getAlumnos().size();

         org.junit.Assert.assertEquals("Error cantidad incorrecto", 
                    cantidadAlumnosEsperada,
                    cantidadAlumnosActual);

        int cantidadAlumnosMayores = 
            (int) m1.getAlumnos().stream()
                .filter(a -> a.edad() >= 18)
                .count();


         org.junit.Assert.assertEquals("Error cantidad incorrecto", 
                    15,
                    cantidadAlumnosMayores);
    }


    @Test
    public void debeBuscarAlumnosMayoresDeEdad02() {

        int cantidadAlumnosEsperada = 30;
        
        Materia m1 = generarMateriaConAlumnos(cantidadAlumnosEsperada);

         var cantidadAlumnosActual = m1.getAlumnos().size();

         org.junit.Assert.assertEquals("Error cantidad incorrecto", 
                    cantidadAlumnosEsperada,
                    cantidadAlumnosActual);

        int cantidadAlumnosMayores = 
            (int) m1.getAlumnos().stream()
                //.filter(esMayorOIgualA(18))
                .filter(esMayorDeEdad())
                .count();


         org.junit.Assert.assertEquals("Error cantidad incorrecto", 
                    15,
                    cantidadAlumnosMayores);
    }


    @Test
    public void debeBuscarAlumnosMayoresDeEdad03() {

        Materia m1 = generarMateriaConAlumnos(2);


        Alumno alumno1 = 
           m1.getAlumnos().stream()
                .filter(esMayorDeEdad())
                .findFirst()
                .get();


         org.junit.Assert.assertEquals("Alumno nombre incorrecto", 
                    "Nombre 2",
                    alumno1.getNombre());
    }

    private Predicate<Alumno> esMayorDeEdad() {
        return esMayorOIgualA(18);
    }

    private Predicate<Alumno> esMayorOIgualA(int edad) {
        return a -> a.edad() >= edad;
    }


    private Materia generarMateriaConAlumnos(int cantidad) {
        Materia m1 = new Materia();
       
        for (int i = 1; i <= cantidad; i++) {
             Alumno a1 = new Alumno("Nombre " + i);
             if (i % 2 == 0) {
                a1.setFechaNacimiento(LocalDate.of(2000, 1, 1));
             } else {
                a1.setFechaNacimiento(LocalDate.of(2010, 1, 1));
             }
             m1.agregar(a1);
        }

        return m1;
    }*/
}