/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.model;

/**
 *
 * @author usuario1
 */
public class Calificacion {

    private Integer identificador;
    private Double calificacion;
    private GrupoAlumno grupoAlumno;

    public Calificacion() {
    }

    public Calificacion(Integer identificador, Double calificacion) {
        this.identificador = identificador;
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

    @Override
    public String toString() {
        return "Calificacion{" + "identificador=" + identificador + ", "
                + "calificacion=" + calificacion + ", "
                + "grupoAlumno=" + grupoAlumno.toString() + '}';
    }

}
