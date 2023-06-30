/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.controller;

import com.med.sistema_calificaciones.model.Alumno;
import com.med.sistema_calificaciones.model.Grupo;
import com.med.sistema_calificaciones.model.GrupoAlumno;
import static com.med.sistema_calificaciones.utils.Impresion.printer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

/**
 *
 * @author usuario1
 */
public class cGrupoAlumno implements Serializable {

    // Modelos
    private GrupoAlumno grupoAl;
    private Alumno alumno;
    private Grupo grupo;
    //Listados
    private List<GrupoAlumno> listGr_al = new ArrayList<>();
    //Otros
    private Scanner scn;

    public GrupoAlumno getGrupoAl() {
        return grupoAl;
    }

    public void setGrupoAl(GrupoAlumno grupoAl) {
        this.grupoAl = grupoAl;
    }

    public List<GrupoAlumno> getListGr_al() {
        return listGr_al;
    }

    public void setListGr_al(List<GrupoAlumno> listGr_al) {
        this.listGr_al = listGr_al;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @PostConstruct
    public void init() {
        this.grupoAl = new GrupoAlumno();
        this.alumno = new Alumno();
        this.grupo = new Grupo();
    }

    /**
     * Función para asignar alumnos a un grupo
     *
     * @param grupo
     * @param alumno
     * @throws java.lang.Exception
     */
    public void asignarAlumnoAGrupo(Grupo grupo, Alumno alumno) throws Exception {
        this.init();
        try {
            // Llenamos nuestro modelo
            this.grupoAl.setIdentificador(obtenerNumeroMayor());
            this.grupoAl.setAlumnoDefinido(alumno);
            this.grupoAl.setGrupoPertenece(grupo);
            //Añadimos a la lista
            this.listGr_al.add(grupoAl);

            System.out.printf("------------------------------------%n");
            printer("• Alumno asignado exitosamente al grupo.");
            System.out.printf("------------------------------------%n");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Función para filtrar la lista de grupo_alumno por un código de grupo.
     *
     * @param grupoBuscado
     * @return
     */
    public List<GrupoAlumno> filtrarAlumnosdeGrupo(String grupoBuscado) {
        if (this.listGr_al.isEmpty()) {
            System.out.printf("--------------------------------------------------%n");
            printer("• No existen grupos con alumnos asignados...", 0);
            System.out.printf("--------------------------------------------------%n");
            return new ArrayList<>();
        }
        return listGr_al.stream()
                .filter(grupoAl -> grupoAl.getGrupoPertenece().getNombreGrupo().equals(grupoBuscado))
                .collect(Collectors.toList());
    }

    /**
     * Función que filtra los grupos de estudiantes, en base a su carnet y
     * devuelve una lista con los resultados.
     *
     * @param carnet
     * @return
     * @throws java.lang.Exception
     */
    public List<GrupoAlumno> filtrarGruposPorAlumno(String carnet) throws Exception {
        List<GrupoAlumno> grupoAlumnoFiltrados = new ArrayList<>();
        try {
            if (this.listGr_al.isEmpty()) {
                System.out.printf("------------------------------------%n");
                printer("• No hay alumnos con grupos asignados...", 0);
                System.out.printf("------------------------------------%n");
                return new ArrayList<>();
            }
            grupoAlumnoFiltrados = listGr_al.stream()
                    .filter(grupoAl -> grupoAl.getAlumnoDefinido().getCarnet().equals(carnet))
                    .collect(Collectors.toList());

            if (grupoAlumnoFiltrados.isEmpty()) {
                return new ArrayList<>();
            }
        } catch (Exception e) {
            throw e;
        }
        return grupoAlumnoFiltrados;
    }

    /**
     * Función para filtrar la lista de alumnos y grupo para obtener un registro
     * especifico.
     *
     * @param list
     * @return
     * @throws java.lang.Exception
     */
    public GrupoAlumno obtenerAlumnoGrupoID(List<GrupoAlumno> list) throws Exception {
        this.init();
        try {
            if (list.isEmpty()) {
                System.out.printf("------------------------------------%n");
                printer("• No existen registros para esta relación...", 0);
                System.out.printf("------------------------------------%n");
                return null;
            }
            scn = new Scanner(System.in);
            printer("Ingrese un ID de alumno: ");
            this.grupoAl.setIdentificador(scn.nextInt());

            this.grupoAl = list.stream()
                    .filter(grupoAl -> grupoAl.getIdentificador().equals(this.grupoAl.getIdentificador()))
                    .findFirst().orElse(null);
            if (this.grupoAl != null) {

                return this.grupoAl;
            }

        } catch (Exception e) {
            throw e;
        }
        System.out.printf("------------------------------------%n");
        printer("• No existe un registro para esta identificador...", 0);
        System.out.printf("------------------------------------%n");
        return null;
    }

    /**
     * Función para obtener el id mayor
     *
     * @return
     * @throws java.lang.Exception
     */
    public int obtenerNumeroMayor() throws Exception {
        // Si la lista se encuentra vacia devuelve 1
        if (this.listGr_al.isEmpty()) {
            System.out.printf("-----------------------------------------------%n");
            printer("• No existen registros anteriores.");
            System.out.printf("-----------------------------------------------%n");
            return 1;
        }
        // Si la lista no esta vacia usamos stream para obtener el mayor # y sumarle 1.
        return this.listGr_al.stream()
                .mapToInt(GrupoAlumno::getIdentificador)
                .max()
                .getAsInt() + 1;
    }
}
