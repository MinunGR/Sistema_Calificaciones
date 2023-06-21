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
public class CRUD_Materias {

    private Materia partesMateria;
    private static List<Materia> materia = new ArrayList<>();

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

    public void registroMateria() {
        Scanner entrada = new Scanner(System.in);

        printer("Registro de Materia: ");
        printer("Por favor,introduzca el nombre de la materia aregistrar: ");
        partesMateria.setNombreMateria(entrada.nextLine());
        printer("Ahora, ingrese cual será el código de la materia a registrar: ");
        partesMateria.setCodigoMateria(entrada.nextLine());
        printer("Dime el año en que se debería cursar esta materia: ");
        partesMateria.setCicloMateria(entrada.nextInt());

        printer("Nueva Materia Ingresada.");
        printer("Información:");
        printer("Nombre de Materia: " + partesMateria.getNombreMateria());
        printer("Código de Materia: " + partesMateria.getCodigoMateria());
        printer("Ciclo en que se cursará la Materia: " + partesMateria.getCicloMateria());
    }

    public void actualizarMateria() {
        Scanner entrada = new Scanner(System.in);

        printer("Actualización de Materia: ");
        printer("Por favor, introduzca el código de la materia a actualizar: ");
        String codigo = entrada.nextLine();

        if (codigo.equals(partesMateria.getCodigoMateria())) {
            printer("Ingrese el nuevo nombre de la materia: ");
            partesMateria.setNombreMateria(entrada.nextLine());
            printer("Ingrese el nuevo código de la materia: ");
            partesMateria.setCodigoMateria(entrada.nextLine());
            printer("Ingrese el nuevo ciclo de la materia: ");
            partesMateria.setCicloMateria(entrada.nextInt());

            printer("Materia actualizada.");
            printer("Información actualizada: ");
            printer("Nombre de Materia: " + partesMateria.getNombreMateria());
            printer("Código de Materia: " + partesMateria.getCodigoMateria());
            printer("Ciclo en que se cursará la Materia: " + partesMateria.getCicloMateria());
        } else {
            printer("La materia con el código especificado no existe.", 0);
        }
    }

    public void leerMateria() {
        Scanner entrada = new Scanner(System.in);

        printer("Lectura de Materia:");
        printer("Introduzca el nombre de la materia:");
        partesMateria.setNombreMateria(entrada.nextLine());
        printer("Introduzca el código de la materia:");
        partesMateria.setCodigoMateria(entrada.nextLine());
        printer("Introduzca el ciclo de la materia:");
        partesMateria.setCicloMateria(entrada.nextInt());

        printer("Materia.");
        printer("Información de materia: ");
        printer("Nombre: " + partesMateria.getNombreMateria());
        printer("Código: " + partesMateria.getCodigoMateria());
        printer("Ciclo: " + partesMateria.getCicloMateria());
    }

    public static void inhabilitarMateria() {
        Scanner sc = new Scanner(System.in);
        printer("Ingrese el código de la materia que desea inhabilitar:");
        String codigo = sc.nextLine();
        for (Materia m : materia) {
            if (m.getCodigoMateria().equals(codigo)) {
                materia.remove(m);
                printer("La materia con código '" + codigo + "'; ha sido inhabilitada.");
                return;
            }
        }
        printer("La materia con código '" + codigo + "'; no existe.", 0);
    }
}
