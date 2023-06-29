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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

/**
 *
 * @author Fernando.Barraza
 */
public class cCalificacion {

    // Modelos
    private Calificacion calif;
    private Alumno alumno;
    private Grupo grupo;
    private Ponderacion ponderacion;
    private GrupoAlumno grupoAlumno;
    // Listados
    private List<Calificacion> listCalif = new ArrayList<>();

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
     * @param nota
     * @throws java.lang.Exception
     */
    public void ingresarCalificacion(GrupoAlumno gr_al, Ponderacion pond, Double nota) throws Exception {
        try {
            if (gr_al != null || pond != null || nota < 0.00) {
                printer("Uno de los parametros recibidos no es valido.", 0);
                return;
            }
            // Pasamos el alumno y grupo correspondiente
            this.alumno = gr_al.getAlumnoDefinido();
            this.grupo = gr_al.getGrupoPertenece();
            this.grupoAlumno.setAlumnoDefinido(alumno);
            this.grupoAlumno.setGrupoPertenece(grupo);
            this.grupoAlumno.setIdentificador(gr_al.getIdentificador());
            // Creamos la calificación.
            this.calif = new Calificacion(nota);
            this.calif.setGrupoAlumno(grupoAlumno);
            this.calif.setPonderacion(pond);
            // La añadimos a la lista de calificaciones
            this.listCalif.add(calif);
            this.init();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Función para buscar una calificación de la lista en base a un
     * identificaor de ponderacion
     *
     * @param idPonderacion
     * @return
     * @throws java.lang.Exception
     */
    public Calificacion buscarCalifPorPonderacion(String idPonderacion) throws Exception {
        try {
            for (Calificacion cal : listCalif) {
//                if (cal.getPonderacion().getIdentificador().equals(idPonderacion)) {
//                    return cal;
//                }
            }
            this.init();
        } catch (Exception e) {
            throw e;
        }
        return null; // Si no se encuentra el grupo, se retorna null
    }

    /**
     * Función que filtra la lista por el carnet del alumno y grupo o solo
     * carnet. Es equivalente a filtrar por carnet y materia.
     *
     * @param carnet
     * @param grupo
     * @return
     */
    public List<Calificacion> filtrarCalifAlumno(String carnet, String grupo) {
        return listCalif.stream()
                .filter(calfs -> calif.getGrupoAlumno().getAlumnoDefinido().getCarnet().equals(carnet)
                && calif.getGrupoAlumno().getGrupoPertenece().getNombreGrupo().equals(grupo))
                .collect(Collectors.toList());
    }

    public List<Calificacion> filtrarCalifAlumno(String carnet) {
        return listCalif.stream()
                .filter(calif -> calif.getGrupoAlumno().getAlumnoDefinido().getCarnet().equals(carnet))
                .collect(Collectors.toList());
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

    /*
     public static void main(String[] args) {
        // Ejemplo de uso
        List<Nota> listaNotas = ...; // Obtener lista de notas

        Map<String, Double> promediosPorMateria = calcularPromedioPorMateria(listaNotas);

        // Imprimir promedios por materia
        for (String materia : promediosPorMateria.keySet()) {
            double promedio = promediosPorMateria.get(materia);
            System.out.println("Materia: " + materia + ", Promedio: " + promedio);
        }
    }
    
     */
}
