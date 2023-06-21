/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crud_alumnos;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gabo
 */
public class Crud_alumnos {
    
        private static final List<Alumno> listaAlumnos = new ArrayList<>();

        public void crearAlumno(String carnet, String nombreCompleto) {
            Alumno alumno = new Alumno();
            alumno.setCarnet(carnet);
            alumno.setNombreCompleto(nombreCompleto);
            listaAlumnos.add(alumno);
        }

        public void modificarAlumno(String carnet, String nuevoNombreCompleto) {
            Alumno alumno = buscarAlumnoPorCarnet(carnet);

            if (alumno != null) {
                alumno.setNombreCompleto(nuevoNombreCompleto);
                System.out.println("Alumno modificado exitosamente.");
            } else {
                System.out.println("No se encontró ningún alumno con el carnet especificado.");
            }
        }

        public void inhabilitarAlumno(String carnet) {
        var alumnoEncontrado = buscarAlumnoPorCarnet(carnet);

        if (alumnoEncontrado != null) {
            for (Alumno alumno : listaAlumnos) {
                if (alumno.getCarnet().equals(carnet)) {
                    listaAlumnos.remove(alumno);
                    System.out.println("Alumno inhabilitado exitosamente.");
                    return;
                }
            }
        } else {
            System.out.println("No se encontró ningún alumno con el carnet especificado.");
        }
    }


        public void leerInformacionAlumno(String carnet) {
            Alumno alumno = buscarAlumnoPorCarnet(carnet);

            if (alumno != null) {
                System.out.println("Carnet: " + alumno.getCarnet());
                System.out.println("Nombre completo: " + alumno.getNombreCompleto());
            } else {
                System.out.println("No se encontró ningún alumno con el carnet especificado.");
            }
        }

        private Alumno buscarAlumnoPorCarnet(String carnet) {
            for (Alumno alumno : listaAlumnos) {
                if (alumno.getCarnet().equals(carnet)) {
                    return alumno;
                }
            }
            return null; 
        }

}











