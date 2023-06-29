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

    private String descripcion;
    private Double porcentaje;
    private Materia materiaAsignada;

    public Ponderacion() {
    }

    public Ponderacion(String descripcion, Double porcentaje) {
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
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
        return "Ponderacion{" + ", descripcion=" + descripcion
                + ", porcentaje=" + porcentaje + ", materia=" + materiaAsignada.toString() + '}';
    }

}
