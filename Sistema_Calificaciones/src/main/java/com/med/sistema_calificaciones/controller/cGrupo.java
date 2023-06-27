/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.controller;

import com.med.sistema_calificaciones.model.Grupo;
import com.med.sistema_calificaciones.model.Materia;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

/**
 *
 * @author Fernando.Barraza
 */
public class cGrupo {

    //Modelos
    private Grupo grupo;
    private Materia materia;
    //Listados
    private List<Grupo> listGrupo = new ArrayList<>();

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Grupo> getListGrupo() {
        return listGrupo;
    }

    public void setListGrupo(List<Grupo> listGrupo) {
        this.listGrupo = listGrupo;
    }

    @PostConstruct
    public void init() {
        this.grupo = new Grupo();
        this.materia = new Materia();
    }

    /**
     * Método para crear un grupo.
     *
     * @param materia
     * @param cantidad
     * @throws java.lang.Exception
     */
    public void crearGrupos(Materia materia, Integer cantidad) throws Exception {
        try {
            for (int i = 0; i < cantidad; i++) {
                // Creamos un grupo
                this.grupo = new Grupo(materia.getCodigoMateria() + "0" + (i + 1));
                this.grupo.setMateriaAsignada(materia);
                // Añadimos el grupo a la lista.
                this.listGrupo.add(grupo);
            }
            this.init();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método para buscar información de un grupo por su código.
     *
     * @param grupoBuscado
     * @return
     * @throws java.lang.Exception
     *
     */
    public Grupo buscarGrupoPorCodigo(String grupoBuscado) throws Exception {
        try {
            for (Grupo grp : listGrupo) {
                if (grp.getNombreGrupo().equals(grupoBuscado)) {
                    return grupo;
                }
            }
            this.init();
        } catch (Exception e) {
            throw e;
        }
        return null; // Si no se encuentra el grupo, se retorna null
    }

    /**
     * Función para filtrar la lista de grupos por un código de materia.
     *
     * @param materiaBuscada
     * @return
     */
    public List<Grupo> filtrarGruposPorMateria(String materiaBuscada) {
        return listGrupo.stream()
                .filter(grupos -> grupo.getMateriaAsignada().getCodigoMateria().equals(materiaBuscada))
                .collect(Collectors.toList());
    }

    /**
     * Método para suprimir un grupo ingresado en la lista.
     *
     * @param grupo
     * @throws Exception
     */
    public void inhabilitarGrupo(String grupo) throws Exception {
        try {
            this.grupo = buscarGrupoPorCodigo(grupo);

            if (this.grupo != null) {
                for (Grupo grp : listGrupo) {
                    if (grp.getNombreGrupo().equals(grupo)) {
                        listGrupo.remove(grp);
                        printer("Alumno inhabilitado exitosamente.");
                        return;
                    }
                }
            } else {
                printer("No se encontró ningún alumno con el carnet especificado.", 0);
            }
            this.init();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Función impresión básica en consola
     *
     * @param texto
     */
    public static void printer(String texto) {
        System.out.println(texto);
    }

    /**
     * Función impresión de advertencias y errores.
     *
     * @param texto
     * @param tipo
     */
    public static void printer(String texto, int tipo) {
        switch (tipo) {
            case 0:
                System.out.println("Advertencia: " + texto);
                break;
            case 1:
                System.err.println("Error: " + texto);
                break;
        }
    }

}
