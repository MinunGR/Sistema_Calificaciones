/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.med.sistema_calificaciones.controller;

import com.med.sistema_calificaciones.model.Alumno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabo
 */
public class cAlumno {

    private static final List<Alumno> listaAlumnos = new ArrayList<>();

    /**
     * Función impresión básica en consola
     *
     * @param texto
     */
    public static void printer(String texto) {
        System.out.println(texto);
    }

    /**
     * Función impresión de advertencias y errores.
     *
     * @param texto
     * @param tipo
     */
    public static void printer(String texto, int tipo) {
        switch (tipo) {
            case 0:
                System.out.println("Advertencia: " + texto);
                break;
            case 1:
                System.err.println("Error: " + texto);
                break;
        }
    }

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
            printer("Alumno modificado exitosamente.");
        } else {
            printer("No se encontró ningún alumno con el carnet especificado.", 0);
        }
    }

    public void inhabilitarAlumno(String carnet) {
        Alumno alumnoEncontrado = buscarAlumnoPorCarnet(carnet);

        if (alumnoEncontrado != null) {
            for (Alumno alumno : listaAlumnos) {
                if (alumno.getCarnet().equals(carnet)) {
                    listaAlumnos.remove(alumno);
                    printer("Alumno inhabilitado exitosamente.");
                    return;
                }
            }
        } else {
            printer("No se encontró ningún alumno con el carnet especificado.", 0);
        }
    }

    public void leerInformacionAlumno(String carnet) {
        Alumno alumno = buscarAlumnoPorCarnet(carnet);

        if (alumno != null) {
            printer("Carnet: " + alumno.getCarnet());
            printer("Nombre completo: " + alumno.getNombreCompleto());
        } else {
            printer("No se encontró ningún alumno con el carnet especificado.", 0);
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
