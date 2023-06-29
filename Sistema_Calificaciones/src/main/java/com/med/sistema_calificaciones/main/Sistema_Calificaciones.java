/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.main;

import com.med.sistema_calificaciones.controller.cMateria;
import static com.med.sistema_calificaciones.utils.Consola.clearConsole;
import static com.med.sistema_calificaciones.utils.Impresion.printer;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Fernando.Barraza
 */
public class Sistema_Calificaciones {

    static Character opt = '1';
    static Scanner scn = new Scanner(System.in);
    static cMateria cmateria = new cMateria();

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //  Menú inicial
        menuPrincipal();
    }

    public static void menuPrincipal() throws Exception {
        try {
            System.out.printf("Inicializando");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(800);
                System.out.printf(".");
                if (i == 2) {
                    System.out.printf("%n");
                }
            }
            Thread.sleep(600);
            do {
                System.out.printf("• MENÚ PRINCIPAL.%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("| - Seleccione una opción:       |%n");
                System.out.printf("| - Ingrese [e] para cerrar.     |%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("•[1] Apartado Materia. \n"
                        + "•[2] Apartado Grupos. \n"
                        + "•[3] Apartado Alumnos. \n"
                        + "•[4] Apartado Ponderaciones. \n"
                        + "•[5] Apartado Calificaciones.%n");
                opt = scn.nextLine().charAt(0);
                switch (opt) {
                    case ('1'):
                        clearConsole();
                        // Movemos a apartado de materias
                        Sistema_Redirecciones.menuMaterias(scn);
                        break;
                    case ('2'):
                        clearConsole();
                        // Movemos a apartado de grupos
                        Sistema_Redirecciones.menuGrupos(scn);
                        break;
                    case ('3'):
                        clearConsole();
                        // Movemos a apartado de grupos
                        Sistema_Redirecciones.menuAlumnos(scn);
                        break;
                    case ('4'):
                        clearConsole();
                        // Movemos a apartado de grupos
                        Sistema_Redirecciones.menuPonderaciones(scn);
                        break;
                    case ('5'):
                        clearConsole();
                        Sistema_Redirecciones.menuCalificaciones(scn);
                        break;
                    case ('0'):
                        printer("Saliendo del programa...");
                        break;
                }

            } while (Pattern.matches("[1-9]", opt.toString()));
            Thread.sleep(2000);
            printer("Gracias por utilizar!");
        } catch (Exception e) {
            throw e;
        }
    }

}
