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
public class TutorMateria implements Serializable{

    private Integer identificador;
    private Tutor tutorDesignado;
    private Materia materiaTutor;

    public TutorMateria() {
    }

    public TutorMateria(Integer identificador) {
        this.identificador = identificador;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Tutor getTutorDesignado() {
        return tutorDesignado;
    }

    public void setTutorDesignado(Tutor tutorDesignado) {
        this.tutorDesignado = tutorDesignado;
    }

    public Materia getMateriaTutor() {
        return materiaTutor;
    }

    public void setMateriaTutor(Materia materiaTutor) {
        this.materiaTutor = materiaTutor;
    }

    @Override
    public String toString() {
        return "TutorMateria{" + "identificador=" + identificador
                + ", tutorDesignado=" + tutorDesignado.toString()
                + ", materiaTutor=" + materiaTutor.toString() + '}';
    }

}
