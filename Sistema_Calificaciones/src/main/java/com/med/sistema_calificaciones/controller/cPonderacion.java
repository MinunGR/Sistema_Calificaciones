/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.controller;

import com.med.sistema_calificaciones.model.Materia;
import com.med.sistema_calificaciones.model.Ponderacion;
import static com.med.sistema_calificaciones.utils.Impresion.printer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

/**
 *
 * @author usuario1
 */
public class cPonderacion {

    //Modelos
    private Ponderacion ponderacion;
    private Materia materia;
    //Listados
    private List<Ponderacion> listPond = new ArrayList<>();
    // Otros
    private Scanner scn;

    public Ponderacion getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(Ponderacion ponderacion) {
        this.ponderacion = ponderacion;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Ponderacion> getListPond() {
        return listPond;
    }

    public void setListPond(List<Ponderacion> listPond) {
        this.listPond = listPond;
    }

    @PostConstruct
    public void init() {
        this.ponderacion = new Ponderacion();
        this.materia = new Materia();
    }

    /**
     * Función para añadir ponderaciones a una materia.
     *
     * @param materia
     * @throws java.lang.Exception
     */
    public void crearPonderacion(Materia materia) throws Exception {
        Double pct = 0.00;
        Integer i = 0;
        this.init();
        try {
            while (pct < 100) {
                scn = new Scanner(System.in);
                System.out.printf("------------------------------------%n");
                printer("Ingrese la descripción de la ponderación: " + (i + 1));
                this.ponderacion.setDescripcion(scn.nextLine());
                do {
                    printer("Ingrese el porcentaje 1-100");
                    this.ponderacion.setPorcentaje(scn.nextDouble());
                } while (this.ponderacion.getPorcentaje() <= 0
                        || this.ponderacion.getPorcentaje() > (100 - pct));
                this.ponderacion.setMateriaAsignada(materia);
                //Añadimos a la lista
                this.listPond.add(ponderacion);
                pct = pct + this.ponderacion.getPorcentaje();
                //Alertamos
                printer("*** Queda un valor restante de:" + (100 - pct) + " ***", 0);
                i++;
                this.init();
            }
            System.out.printf("----------------------------------------------------------%n");
            printer("• Se crearon las ponderaciones con éxito");
            System.out.printf("----------------------------------------------------------%n");

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Función para eliminar ponderaciones de una materia.
     *
     * @param materiaBuscada
     */
    public void eliminarClasesEspecificas(Materia materiaBuscada) {
        try {
            this.listPond.removeIf(ponderacion -> ponderacion.getMateriaAsignada().getCodigoMateria().equals(materiaBuscada.getCodigoMateria()));
            System.out.printf("----------------------------------------------------------%n");
            printer("• Ponderaciones eliminadas correctamente");
            System.out.printf("----------------------------------------------------------%n");
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Ponderacion> filtrarPondPorMateria(String materiaBuscada) {
        return listPond.stream()
                .filter(ponderacion -> ponderacion.getMateriaAsignada().getCodigoMateria().equals(materiaBuscada))
                .collect(Collectors.toList());
    }
}
