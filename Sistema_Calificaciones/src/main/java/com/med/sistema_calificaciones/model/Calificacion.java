/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.model;

import java.io.Serializable;

/**
 *
 * @author usuario1
 */
public class Calificacion implements Serializable {

    private Integer identificador;
    private Double calificacion;
    private GrupoAlumno grupoAlumno;
    private Ponderacion ponderacion;

    public Calificacion() {
    }

    public Calificacion(Integer identificador, Double calificacion) {
        this.identificador = identificador;
        this.calificacion = calificacion;
    }

    public Calificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public GrupoAlumno getGrupoAlumno() {
        return grupoAlumno;
    }

    public void setGrupoAlumno(GrupoAlumno grupoAlumno) {
        this.grupoAlumno = grupoAlumno;
    }

    public Ponderacion getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(Ponderacion ponderacion) {
        this.ponderacion = ponderacion;
    }

    @Override
    public String toString() {
        return "Calificacion{"
                + "calificacion=" + calificacion + ", "
                + "grupoAlumno=" + grupoAlumno.toString()
                + ", ponderacion=" + ponderacion.toString() + '}';
    }

}
