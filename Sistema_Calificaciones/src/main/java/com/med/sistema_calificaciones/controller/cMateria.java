package com.med.sistema_calificaciones.controller;

import com.med.sistema_calificaciones.model.Materia;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;

/**
 *
 * @author RomanMendoza
 */
public class cMateria {

    private Materia partesMateria;
    private List<Materia> listMateria = new ArrayList<>();
    private Scanner entrada;

    public Materia getPartesMateria() {
        return partesMateria;
    }

    public void setPartesMateria(Materia partesMateria) {
        this.partesMateria = partesMateria;
    }

    public List<Materia> getListMateria() {
        return listMateria;
    }

    public void setListMateria(List<Materia> listMateria) {
        this.listMateria = listMateria;
    }

    @PostConstruct
    public void init() {
        this.partesMateria = new Materia();
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

    public void registroMateria() throws Exception {
        this.init();
        try {
            entrada = new Scanner(System.in);
            printer("Registro de Materia: ");
            printer("Por favor,introduzca el nombre de la materia a registrar: ");
            partesMateria.setNombreMateria(entrada.nextLine());
            printer("Ahora, ingrese cual será el código de la materia a registrar: ");
            partesMateria.setCodigoMateria(entrada.nextLine());
            printer("Dime el año en que se debería cursar esta materia: ");
            partesMateria.setCicloMateria(entrada.nextInt());

            //Añadimos a la lista
            this.listMateria.add(partesMateria);
            System.out.printf("---------------------------------%n");
            printer("Nueva Materia Ingresada.");
            printer("Información:");
            printer("Nombre de Materia: " + partesMateria.getNombreMateria());
            printer("Código de Materia: " + partesMateria.getCodigoMateria());
            printer("Ciclo en que se cursará la Materia: " + partesMateria.getCicloMateria());
            System.out.printf("---------------------------------%n");
            //Restauramos
            this.init();
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizarMateria() {
        entrada = new Scanner(System.in);
        printer("Actualización de Materia: ");
        printer("Por favor, introduzca el código de la materia a actualizar: ");
        partesMateria.setCodigoMateria(entrada.nextLine());
        for (Materia m : listMateria) {
            if (m.getCodigoMateria().equals(partesMateria.getCodigoMateria())) {
                // Actualizamos
                printer("Ingrese el nuevo nombre de la materia: ");
                m.setNombreMateria(entrada.nextLine());
                printer("Ingrese el nuevo código de la materia: ");
                m.setCodigoMateria(entrada.nextLine());
                printer("Ingrese el nuevo ciclo de la materia: ");
                m.setCicloMateria(entrada.nextInt());

                // Mostramos
                System.out.printf("---------------------------------%n");
                printer("Materia actualizada.");
                printer("Información actualizada: ");
                printer("Nombre de Materia: " + m.getNombreMateria());
                printer("Código de Materia: " + m.getCodigoMateria());
                printer("Ciclo en que se cursará la Materia: " + m.getCicloMateria());
                System.out.printf("---------------------------------%n");
                break;
            } else {
                printer("La materia con el código especificado no existe.", 0);
            }
        }

        this.init();
    }

    public void leerMateria() {
        entrada = new Scanner(System.in);
        printer("Introduzca el código de la materia:");
        partesMateria.setCodigoMateria(entrada.nextLine());
        for (Materia m : listMateria) {
            if (m.getCodigoMateria().equals(partesMateria.getCodigoMateria())) {
                System.out.printf("---------------------------------%n");
                printer("• Materia.");
                printer("   Información de materia ");
                printer("   Nombre: " + m.getNombreMateria());
                printer("   Código: " + m.getCodigoMateria());
                printer("   Ciclo: " + m.getCicloMateria());
                System.out.printf("---------------------------------%n");
            }
        }
    }

    public void inhabilitarMateria() {
        entrada = new Scanner(System.in);
        printer("Ingrese el código de la materia que desea inhabilitar:");
        String codigo = entrada.nextLine();
        for (Materia m : listMateria) {
            if (m.getCodigoMateria().equals(codigo)) {
                listMateria.remove(m);
                System.out.printf("---------------------------------%n");
                printer("La materia con código '" + codigo + "'; ha sido inhabilitada.");
                System.out.printf("---------------------------------%n");
                return;
            }
        }
        printer("La materia con código '" + codigo + "'; no existe.", 0);
    }
}
