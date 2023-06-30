/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.controller;

import com.med.sistema_calificaciones.model.Alumno;
import com.med.sistema_calificaciones.model.Calificacion;
import com.med.sistema_calificaciones.model.Grupo;
import com.med.sistema_calificaciones.model.GrupoAlumno;
import com.med.sistema_calificaciones.model.Ponderacion;
import static com.med.sistema_calificaciones.utils.Impresion.printer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

/**
 *
 * @author Fernando.Barraza
 */
public class cCalificacion implements Serializable {

    // Modelos
    private Calificacion calif;
    private Alumno alumno;
    private Grupo grupo;
    private Ponderacion ponderacion;
    private GrupoAlumno grupoAlumno;
    // Listados
    private List<Calificacion> listCalif = new ArrayList<>();
    // Otros
    private Scanner scn;

    public Calificacion getCalif() {
        return calif;
    }

    public void setCalif(Calificacion calif) {
        this.calif = calif;
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

    public Ponderacion getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(Ponderacion ponderacion) {
        this.ponderacion = ponderacion;
    }

    public GrupoAlumno getGrupoAlumno() {
        return grupoAlumno;
    }

    public void setGrupoAlumno(GrupoAlumno grupoAlumno) {
        this.grupoAlumno = grupoAlumno;
    }

    public List<Calificacion> getListCalif() {
        return listCalif;
    }

    public void setListCalif(List<Calificacion> listCalif) {
        this.listCalif = listCalif;
    }

    @PostConstruct
    public void init() {
        this.calif = new Calificacion();
        this.alumno = new Alumno();
        this.grupo = new Grupo();
        this.ponderacion = new Ponderacion();
        this.grupoAlumno = new GrupoAlumno();
    }

    /**
     * Método para ingresar una calificación
     *
     * @param gr_al
     * @param pond
     * @throws java.lang.Exception
     */
    public void ingresarCalificacion(GrupoAlumno gr_al, Ponderacion pond) throws Exception {
        this.init();
        try {
            scn = new Scanner(System.in);
//            if (gr_al != null || pond != null) {
//                printer("Uno de los parametros recibidos no es valido.", 0);
//                return;
//            }
            printer("Ingrese la calificación a asignar.");
            // Creamos la calificación.
            this.calif = new Calificacion(scn.nextDouble());
            // Pasamos el alumno y grupo correspondiente
            this.alumno = gr_al.getAlumnoDefinido();
            this.grupo = gr_al.getGrupoPertenece();
            this.grupoAlumno.setAlumnoDefinido(alumno);
            this.grupoAlumno.setGrupoPertenece(grupo);
            this.grupoAlumno.setIdentificador(gr_al.getIdentificador());
            //Pasamos a entidad principal
            this.calif.setGrupoAlumno(grupoAlumno);
            this.calif.setPonderacion(pond);
            this.calif.setIdentificador(obtenerNumeroMayor());
            // La añadimos a la lista de calificaciones
            this.listCalif.add(calif);

            //Mostramos
            System.out.printf("---------------------------------%n");
            printer("• Nueva Calificación Ingresada.");
            printer("Información:");
            printer("Calificación: " + calif.getCalificacion());
            printer("Alumno: " + calif.getGrupoAlumno().getAlumnoDefinido().getCarnet());
            printer("Grupo: " + calif.getGrupoAlumno().getGrupoPertenece().getNombreGrupo());
            printer("Ponderación: " + calif.getPonderacion().getDescripcion() + " "
                    + calif.getPonderacion().getPorcentaje() + "% ");
            System.out.printf("---------------------------------%n");
            //Restauramos
            this.init();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Función que filtra la lista por el carnet del alumno y grupo o solo
     * carnet. Es equivalente a filtrar por carnet y materia.
     *
     * @param carnet
     * @param grupo
     * @return
     */
    public List<Calificacion> filtrarCalifGrupo(String grupo) {
        List<Calificacion> calificacionesFiltradas = new ArrayList<>();
        try {
            calificacionesFiltradas = listCalif.stream()
                    .filter(calif -> calif.getGrupoAlumno().getGrupoPertenece().getNombreGrupo().equals(grupo))
                    .collect(Collectors.toList());

            if (calificacionesFiltradas.isEmpty()) {
                return new ArrayList<>(); // Retorna una nueva lista vacía
            }
        } catch (Exception e) {
            throw e;
        }
        return calificacionesFiltradas;
    }

    public List<Calificacion> filtrarCalifAlumno(String carnet) throws Exception {
        List<Calificacion> calificacionesFiltradas = new ArrayList<>();
        try {
            calificacionesFiltradas = listCalif.stream()
                    .filter(calif -> calif.getGrupoAlumno().getAlumnoDefinido().getCarnet().equals(carnet))
                    .collect(Collectors.toList());

            if (calificacionesFiltradas.isEmpty()) {
                return new ArrayList<>(); // Retorna una nueva lista vacía
            }
        } catch (Exception e) {
            throw e;
        }
        return calificacionesFiltradas;
    }

    public List<Calificacion> filtrarCalifAlumnoGrupo(String carnet, String grupo) throws Exception {
        List<Calificacion> calificacionesFiltradas = new ArrayList<>();
        try {
            calificacionesFiltradas = listCalif.stream()
                    .filter(calif -> calif.getGrupoAlumno().getGrupoPertenece().getNombreGrupo().equals(grupo)
                    && calif.getGrupoAlumno().getAlumnoDefinido().getCarnet().equals(carnet))
                    .collect(Collectors.toList());

            if (calificacionesFiltradas.isEmpty()) {
                return new ArrayList<>(); // Retorna una nueva lista vacía
            }
        } catch (Exception e) {
            throw e;
        }
        return calificacionesFiltradas;
    }

    /**
     * Función que filtra una lista por materia asignada, y saca un promedio de
     * las calificaciones de esa materia. Debe recibir una lista de un solo
     * estudiante
     *
     * @param listaNotas
     * @return
     * @throws java.lang.Exception
     */
    public Map<String, Double> calcularPromedioPorMateria(List<Calificacion> listaNotas) throws Exception {
        Map<String, Double> promediosPorMateria = new HashMap<>();
        try {
            // Filtrar notas por materia
            Map<String, List<Calificacion>> notasPorMateria = listaNotas.stream()
                    .collect(Collectors.groupingBy(nota -> calif.getGrupoAlumno().getGrupoPertenece().getMateriaAsignada().getCodigoMateria()));

            // Calcular promedio por materia
            for (String materia : notasPorMateria.keySet()) {
                List<Calificacion> notasMateria = notasPorMateria.get(materia);

                // Calcular promedio de notas de la materia
                double sumaNotas = notasMateria.stream()
                        .mapToDouble(Calificacion::getCalificacion)
                        .sum();

                double promedio = sumaNotas / notasMateria.size();

                // Agregar el promedio a la lista de promedios por materia
                promediosPorMateria.put(materia, promedio);
            }
        } catch (Exception e) {
            throw e;
        }
        return promediosPorMateria;
    }

    /**
     * Función para eliminar una calificación ingresada.
     *
     * @throws java.lang.Exception
     */
    public void inhabilitarCalificacion() throws Exception {
        this.init();
        try {
            scn = new Scanner(System.in);
            printer("Ingrese un identificador de Calificación: .");
            this.calif.setIdentificador(scn.nextInt());

            if (this.calif != null) {
                for (Calificacion calf : listCalif) {
                    if (calf.getIdentificador().equals(this.calif.getIdentificador())) {
                        this.listCalif.remove(calf);
                        System.out.printf("---------------------------------------------------%n");
                        printer("• Calificación eliminada correctamente");
                        System.out.printf("---------------------------------------------------%n");
                        this.init();
                        return;
                    }
                }
            }
            System.out.printf("---------------------------------------------------%n");
            printer("No existe calificación con el ID recibido.", 0);
            System.out.printf("---------------------------------------------------%n");
            this.init();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Función para obtener el id mayor
     *
     * @return
     * @throws java.lang.Exception
     */
    public int obtenerNumeroMayor() throws Exception {
        // Si la lista se encuentra vacia devuelve 1
        if (this.listCalif.isEmpty()) {
            System.out.printf("-----------------------------------------------%n");
            printer("• No existen registros anteriores.");
            System.out.printf("-----------------------------------------------%n");
            return 1;
        }
        // Si la lista no esta vacia usamos stream para obtener el mayor # y sumarle 1.
        return this.listCalif.stream()
                .mapToInt(Calificacion::getIdentificador)
                .max()
                .getAsInt() + 1;
    }

}
