/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author usuario1
 */
public class Consola {

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

            Thread.sleep(500);
        } catch (AWTException | InterruptedException e) {
            System.out.println("Error al limpiar la consola: " + e.getMessage());
        }
    }
}
