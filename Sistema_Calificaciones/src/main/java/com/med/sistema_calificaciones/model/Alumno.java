package com.med.sistema_calificaciones.model;

/**
 *
 * @author gabo
 */
public class Alumno {

    private String carnet;
    private String nombreCompleto;

    public Alumno() {
    }

    public Alumno(String carnet, String nombreCompleto) {
        this.carnet = carnet;
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "Alumno{" + "carnet=" + carnet + ", nombreCompleto=" + nombreCompleto + '}';
    }

}
