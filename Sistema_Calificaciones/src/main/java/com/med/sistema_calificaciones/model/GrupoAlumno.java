/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.model;

/**
 *
 * @author Fernando.Barraza
 */
public class GrupoAlumno {

    private Integer identificador;
    private Alumno alumnoDefinido;
    private Grupo grupoPertenece;

    public GrupoAlumno() {
    }

    public GrupoAlumno(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Alumno getAlumnoDefinido() {
        return alumnoDefinido;
    }

    public void setAlumnoDefinido(Alumno alumnoDefinido) {
        this.alumnoDefinido = alumnoDefinido;
    }

    public Grupo getGrupoPertenece() {
        return grupoPertenece;
    }

    public void setGrupoPertenece(Grupo grupoPertenece) {
        this.grupoPertenece = grupoPertenece;
    }

    @Override
    public String toString() {
        return "GrupoAlumno{" + "identificador=" + identificador
                + ", alumnoDefinido=" + alumnoDefinido.toString()
                + ", grupoPertenece=" + grupoPertenece.toString() + '}';
    }

}
