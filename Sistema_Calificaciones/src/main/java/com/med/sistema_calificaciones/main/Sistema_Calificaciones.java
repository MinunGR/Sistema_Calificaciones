/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.main;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Fernando.Barraza
 */
public class Sistema_Calificaciones {

    static Character opt = '1';
    static Scanner scn = new Scanner(System.in);

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //  Menú
        menu1();
    }

    public static void menu1() throws Exception {
        try {
            do {
                System.out.println("Ingrese un número del 1-9 para repetir \n Cualquier otro valor para salir Menu1.");
                opt = scn.next().charAt(0);
                scn.nextLine();

                if (Pattern.matches("[1-9]", opt.toString())) {
                    menu2(scn);
                    opt = '1';
                }
                if (Pattern.matches("[0]", opt.toString())) {
                    System.out.println("Saliendo del programa...");
                    break;
                }
            } while (Pattern.matches("[1-9]", opt.toString()));
            Thread.sleep(2000);
            System.out.println("Gracias por utilizar!");
        } catch (Exception e) {
            throw e;
        }
    }

    public static void menu2(Scanner scanner) throws Exception {
        try {
            do {
                System.out.println("Ingrese un número del 1-9 para repetir \n Cualquier otro valor para salir Menu2.");
                opt = scn.next().charAt(0);
                scn.nextLine();
                if (Pattern.matches("[1-9]", opt.toString())) {
                    menu3(scanner);
                    opt = '1';
                }
                if (opt == 'e') {
                    System.out.println("Saliendo del programa...");
                    Thread.sleep(2000);
                    System.out.println("Gracias por utilizar!");
                    System.exit(0);
                }
                if (Pattern.matches("[0]", opt.toString())) {
                    System.out.println("Salida menú #2");
                }
            } while (Pattern.matches("[1-9]", opt.toString()));
        } catch (Exception e) {
            throw e;
        }
    }

    public static void menu3(Scanner scanner) throws Exception {
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

}
