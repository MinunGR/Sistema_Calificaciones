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
public class Ponderacion {

    private String identificador;
    private String descripcion;
    private Double porcentaje;
    private Materia materiaAsignada;

    public Ponderacion() {
    }

    public Ponderacion(String identificador, String descripcion, Double porcentaje) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Materia getMateriaAsignada() {
        return materiaAsignada;
    }

    public void setMateriaAsignada(Materia materiaAsignada) {
        this.materiaAsignada = materiaAsignada;
    }

    @Override
    public String toString() {
        return "Ponderacion{" + "identificador=" + identificador + ", descripcion=" + descripcion
                + ", porcentaje=" + porcentaje + ", materia=" + materiaAsignada.toString() + '}';
    }

}
