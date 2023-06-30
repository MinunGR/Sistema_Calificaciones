/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.med.sistema_calificaciones.controller;

import com.med.sistema_calificaciones.model.Alumno;
import static com.med.sistema_calificaciones.utils.Impresion.printer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;

/**
 *
 * @author gabo
 */
public class cAlumno implements Serializable{

    //Modelos
    private Alumno alumno;
    //Listados
    private List<Alumno> listaAlumnos = new ArrayList<>();
    // Otros
    private Scanner scn;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    @PostConstruct
    public void init() {
        this.alumno = new Alumno();
    }

    public void crearAlumno() {
        this.init();
        try {
            scn = new Scanner(System.in);
            printer("Registro de Alumno: ");
            printer("Ingrese el carnet del alumno:");
            this.alumno.setCarnet(scn.nextLine());
            printer("Ingrese el nombre completo");
            this.alumno.setNombreCompleto(scn.nextLine());
            // Añadimos a la lista
            this.listaAlumnos.add(alumno);

            //Mostramos
            System.out.printf("---------------------------------%n");
            printer("• Nueva Alumno Ingresado.");
            printer("Información:");
            printer("Carnet: " + this.alumno.getCarnet());
            printer("Nombre completo: " + this.alumno.getNombreCompleto());
            System.out.printf("---------------------------------%n");
            //Restauramos
            this.init();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarAlumno() throws Exception {
        try {
            scn = new Scanner(System.in);
            printer("Actualización de Alumno: ");
            printer("Por favor, introduzca el carnet del alumno a actualizar: ");
            this.alumno.setCarnet(scn.nextLine());
            for (Alumno a : listaAlumnos) {
                if (a.getCarnet().equals(this.alumno.getCarnet())) {
                    // Actualizamos
                    printer("Ingrese el nuevo carnet del alumno: ");
                    a.setCarnet(scn.nextLine());
                    printer("Ingrese el nuevo nombre completo:");
                    a.setNombreCompleto(scn.nextLine());

                    // Mostramos
                    System.out.printf("---------------------------------%n");
                    printer("• Alumno actualizado.");
                    printer("Información: ");
                    printer("Carnet: " + a.getCarnet());
                    printer("Nombre completo: " + a.getNombreCompleto());
                    System.out.printf("---------------------------------%n");
                    break;
                }
            }
        } catch (Exception e) {
            throw e;
        }

        this.init();
    }

    public void inhabilitarAlumno() {
        try {
            scn = new Scanner(System.in);
            printer("Ingrese el carnet que corresponde al Alumno a inhabilitar: ");
            this.alumno = buscarAlumnoPorCarnet(scn.nextLine());

            if (this.alumno != null) {
                for (Alumno alm : listaAlumnos) {
                    if (alm.getCarnet().equals(this.alumno.getCarnet())) {
                        listaAlumnos.remove(alm);
                        System.out.printf("---------------------------------%n");
                        printer("El Alumno con carnet '" + this.alumno.getCarnet() + "', ha sido inhabilitado.");
                        System.out.printf("---------------------------------%n");
                        this.init();
                        return;
                    }
                }
            } else {
                printer("No se encontró ningún alumno con el carnet especificado.", 0);
            }
            this.init();
        } catch (Exception e) {
            throw e;
        }
    }

    public Alumno leerInformacionAlumno() {
        scn = new Scanner(System.in);
        printer("Ingrese el carnet que corresponde al Alumno: ");
        this.alumno = buscarAlumnoPorCarnet(scn.nextLine());

        if (this.alumno != null) {
            System.out.printf("---------------------------------%n");
            printer("• Alumno Encontrado.");
            printer("   Información del alumno ");
            printer("   Carnet: " + alumno.getCarnet());
            printer("   Nombre completo: " + alumno.getNombreCompleto());
            System.out.printf("---------------------------------%n");

        } else {
            System.out.printf("------------------------------------%n");
            printer("No se encontró ningún alumno con el carnet especificado.", 0);
            System.out.printf("------------------------------------%n");
        }
        return this.alumno;
    }

    public Alumno buscarAlumnoPorCarnet(String carnet) {
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getCarnet().equals(carnet)) {
                return alumno;
            }
        }
        return null;
    }

}
