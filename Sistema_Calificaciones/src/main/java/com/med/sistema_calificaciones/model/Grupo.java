/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.model;

import java.io.Serializable;

/**
 *
 * @author Fernando.Barraza
 */
public class Grupo implements Serializable{

    private String nombreGrupo;
    private Materia materiaAsignada;

    public Grupo() {
    }

    public Grupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public Materia getMateriaAsignada() {
        return materiaAsignada;
    }

    public void setMateriaAsignada(Materia materiaAsignada) {
        this.materiaAsignada = materiaAsignada;
    }

    @Override
    public String toString() {
        return "Grupo{" + "nombreGrupo=" + nombreGrupo
                + ", materiaAsignada=" + materiaAsignada.toString() + '}';
    }

}
