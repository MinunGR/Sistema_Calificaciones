/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.controller;

import com.med.sistema_calificaciones.model.Grupo;
import com.med.sistema_calificaciones.model.Materia;
import static com.med.sistema_calificaciones.utils.Impresion.printer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
    // Otros
    private Scanner scn;

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
     * @throws java.lang.Exception
     */
    public void crearGrupos(Materia materia) throws Exception {
        Integer cant = 0;
        this.init();
        try {
            scn = new Scanner(System.in);
            printer("Ingrese la cantidad de grupos a crear:");
            cant = scn.nextInt();
            for (int i = 0; i < cant; i++) {
                // Creamos un grupo
                this.grupo = new Grupo(materia.getCodigoMateria() + "0" + (i + 1));
                this.grupo.setMateriaAsignada(materia);
                // Añadimos el grupo a la lista.
                this.listGrupo.add(grupo);
                this.init();
            }
            System.out.printf("------------------------------------------------------------------------%n");
            printer("Se crearon " + cant + " grupos en " + materia.getCodigoMateria() + " exitosamente.");
            System.out.printf("------------------------------------------------------------------------%n");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método para buscar información de un grupo por su código.
     *
     * @return
     * @throws java.lang.Exception
     *
     */
    public Grupo buscarGrupoPorCodigo() throws Exception {
        try {
            scn = new Scanner(System.in);
            printer("Introduzca el código del grupo:");
            this.grupo.setNombreGrupo(scn.nextLine());
            for (Grupo grp : listGrupo) {
                if (grp.getNombreGrupo().equals(grupo.getNombreGrupo())) {
                    System.out.printf("---------------------------------%n");
                    printer("• Grupo Encontrado.");
                    printer("   Información de grupo ");
                    printer("   Nombre: " + grp.getNombreGrupo());
                    printer("   Materia: " + grp.getMateriaAsignada().getNombreMateria());
                    printer("   Código de materia: " + grp.getMateriaAsignada().getCodigoMateria());
                    System.out.printf("---------------------------------%n");
                    this.init();
                    return grp;
                }
            }
            this.init();
        } catch (Exception e) {
            throw e;
        }
        System.out.printf("------------------------------------%n");
        printer("No se encontro el grupo con el nombre recibido.", 0);
        System.out.printf("------------------------------------%n");
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
                .filter(grupo -> grupo.getMateriaAsignada().getCodigoMateria().equals(materiaBuscada))
                .collect(Collectors.toList());
    }

    /**
     * Método para suprimir un grupo ingresado en la lista.
     *
     * @throws Exception
     */
    public void inhabilitarGrupo() throws Exception {
        try {
            this.grupo = buscarGrupoPorCodigo();
            if (this.grupo != null) {
                for (Grupo grp : listGrupo) {
                    if (grp.getNombreGrupo().equals(this.grupo.getNombreGrupo())) {
                        listGrupo.remove(grp);
                        System.out.printf("---------------------------------%n");
                        printer("El grupo de nombre '" + this.grupo.getNombreGrupo() + "'; ha sido inhabilitado.");
                        System.out.printf("---------------------------------%n");
                        this.init();
                        return;
                    }
                }
            } else {
                printer("No se encontró ningún grupo con el nombre especificado.", 0);
            }
            this.init();
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizarGrupo() throws Exception {
        try {
            scn = new Scanner(System.in);
            printer("Actualización de Grupo: ");
            printer("Por favor, introduzca el código del grupo a actualizar: ");
            grupo.setNombreGrupo(scn.nextLine());
            for (Grupo g : listGrupo) {
                if (g.getNombreGrupo().equals(grupo.getNombreGrupo())) {
                    // Actualizamos
                    printer("Ingrese el nuevo nombre del grupo: ");
                    g.setNombreGrupo(scn.nextLine());

                    // Mostramos
                    System.out.printf("---------------------------------%n");
                    printer("• Grupo actualizado.");
                    printer("Información: ");
                    printer("Nombre de grupo: " + g.getNombreGrupo());
                    printer("Materia: " + g.getMateriaAsignada().getCodigoMateria() + " "
                            + g.getMateriaAsignada().getNombreMateria());
                    System.out.printf("---------------------------------%n");
                    break;
                }
            }
        } catch (Exception e) {
            throw e;
        }

        this.init();
    }

}
