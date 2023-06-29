/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.controller;

import com.med.sistema_calificaciones.model.GrupoAlumno;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

/**
 *
 * @author usuario1
 */
public class cGrupoAlumno {

    // Modelos
    private GrupoAlumno grupoAl;
    private List<GrupoAlumno> listGr_al = new ArrayList<>();

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

    @PostConstruct
    public void init() {
        this.grupoAl = new GrupoAlumno();
    }

    /**
     * Función que filtra los grupos de estudiantes, en base a su carnet y
     * devuelve una lista con los resultados.
     *
     * @param carnet
     * @return
     */
    public List<GrupoAlumno> filtrarGruposPorEstudiante(String carnet) {
        return listGr_al.stream()
                .filter(gral -> grupoAl.getAlumnoDefinido().getCarnet().equals(carnet))
                .collect(Collectors.toList());
    }

}
