/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.main;

import com.med.sistema_calificaciones.controller.cMateria;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
                System.out.printf(". ");
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
                        + "•[3] Apartado alumnos. \n"
                        + "•[4] Apartado ponderaciones. \n"
                        + "•[5] Apartado calificaciones.%n");
                opt = scn.nextLine().charAt(0);
//                scn.nextLine();
                switch (opt) {
                    case ('1'):
                        clearConsole();
                        // Movemos a apartado de materias
                        menuMaterias(scn);
                        opt = '1';
                        break;
                    case ('2'):

                        break;
                    case ('3'):

                        break;
                    case ('4'):

                        break;
                    case ('0'):
                        System.out.println("Saliendo del programa...");
                        break;
                }

//                if (Pattern.matches("[1-9]", opt.toString())) {
//                    menuMaterias(scn);
//                    opt = '1';
//                }
//                if (Pattern.matches("[0]", opt.toString())) {
//
//                    break;
//                }
            } while (Pattern.matches("[1-9]", opt.toString()));
            Thread.sleep(2000);
            System.out.println("Gracias por utilizar!");
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Menú funcional para apartado de materias.
     *
     * @param s
     * @throws java.lang.Exception
     */
    public static void menuMaterias(Scanner s) throws Exception {
        try {
            do {
                System.out.printf("• Menú apartado Materias.%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("| - Seleccione una opción:       |%n");
                System.out.printf("| - Ingrese [e] para cerrar.     |%n");
                System.out.printf("| - Otro: <- Menú Anterior       |%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("•[1] Ingresar Materia. \n"
                        + "•[2] Modificar Materia. \n"
                        + "•[3] Eliminar Materia. \n"
                        + "•[4] Buscar materia. \n"
                        + "•[5] Listar materias. %n");
                opt = scn.next().charAt(0);
                if (Pattern.matches("[1-9]", opt.toString())) {
                    switch (opt) {
                        case ('1'):
                            // Función para ingresar una materia
                            cmateria.registroMateria();
                            break;
                        case ('2'):
                            // Función para modificar una materia.
                            cmateria.actualizarMateria();
                            break;
                        case ('3'):
                            // Función para eliminar una materia.
                            cmateria.inhabilitarMateria();
                            break;
                        case ('4'):
                            // Función para buscar una materia y mostrarla
                            cmateria.leerMateria();
                            break;
                        case ('5'):
                            System.out.printf("--------------------------------%n");
                            System.out.printf(" Listado de materias            %n");
                            System.out.printf("--------------------------------%n");
                            System.out.printf("| %-10s | %-8s | %-1s|%n", "CÓDIGO", "NOMBRE", "CICLO");
                            System.out.printf("--------------------------------%n");
                            for (int i = 0; i < cmateria.getListMateria().size(); i++) {
                                System.out.printf("| %-10s | %-8s | %04d |%n", cmateria.getListMateria().get(i).getCodigoMateria(),
                                        cmateria.getListMateria().get(i).getNombreMateria(),
                                        cmateria.getListMateria().get(i).getCicloMateria());
                            }
                            System.out.printf("--------------------------------%n");
                            break;
                    }
                    opt = '1';
                }
                if (opt == 'e') {
                    System.out.println("Saliendo del programa...");
                    Thread.sleep(1500);
                    System.out.println("Gracias por utilizar!");
                    System.exit(0);
                }
                if (Pattern.matches("[0]", opt.toString())) {
                    System.out.println("Saliendo Menú Materias");
                }
            } while (Pattern.matches("[1-9]", opt.toString())); // Revisión para saber que valor retorna
            // Puede ser mediante variables booleanas.
        } catch (Exception e) {
            throw e;
        }
        clearConsole();
    }

    public static void menu3() throws Exception {
        try {
            do {
                System.out.println("Ingrese un número del 1-9 para repetir \n Cualquier otro valor para salir Menu3.");
                opt = scn.next().charAt(0);
                scn.nextLine();
                if (Pattern.matches("[1-9]", opt.toString())) {
                    //menu3(scanner);
                }
                if (opt == 'e') {
                    System.out.println("Saliendo del programa...");
                    Thread.sleep(2000);
                    System.out.println("Gracias por utilizar!");
                    System.exit(0);
                }
                if (Pattern.matches("[0]", opt.toString())) {
                    System.out.println("Salida menú #3");
                }
            } while (Pattern.matches("[1-9]", opt.toString()));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Función para limpiar la consola, útil unicamente en NETBEANS WINDOWS.
     *
     * @throws java.lang.Exception
     */
    public static void clearConsole() throws Exception {
        try {
            Robot robot = new Robot();
            // Presionar Ctrl
            robot.keyPress(KeyEvent.VK_CONTROL);

            // Presionar L
            robot.keyPress(KeyEvent.VK_L);

            // Liberar L
            robot.keyRelease(KeyEvent.VK_L);

            // Liberar Ctrl
            robot.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(700);
        } catch (AWTException | InterruptedException e) {
            System.out.println("Error al limpiar la consola: " + e.getMessage());
        }
    }

}
