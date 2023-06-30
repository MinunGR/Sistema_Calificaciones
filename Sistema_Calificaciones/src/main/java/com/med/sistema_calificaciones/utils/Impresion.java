/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.utils;

/**
 *
 * @author usuario1
 */
public class Impresion {

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
