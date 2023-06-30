/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.med.sistema_calificaciones.main;

import com.med.sistema_calificaciones.controller.cAlumno;
import com.med.sistema_calificaciones.controller.cCalificacion;
import com.med.sistema_calificaciones.controller.cGrupo;
import com.med.sistema_calificaciones.controller.cGrupoAlumno;
import com.med.sistema_calificaciones.controller.cMateria;
import com.med.sistema_calificaciones.controller.cPonderacion;
import com.med.sistema_calificaciones.model.Alumno;
import com.med.sistema_calificaciones.model.Calificacion;
import com.med.sistema_calificaciones.model.Grupo;
import com.med.sistema_calificaciones.model.GrupoAlumno;
import com.med.sistema_calificaciones.model.Materia;
import com.med.sistema_calificaciones.model.Ponderacion;
import static com.med.sistema_calificaciones.utils.Consola.clearConsole;
import static com.med.sistema_calificaciones.utils.Impresion.printer;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author usuario1
 */
public class Sistema_Redirecciones {

    // Controladores
    static cMateria cmateria = new cMateria();
    static cGrupo cgrupo = new cGrupo();
    static cAlumno calumno = new cAlumno();
    static cCalificacion ccalif = new cCalificacion();
    static cPonderacion cpond = new cPonderacion();
    static cGrupoAlumno cgral = new cGrupoAlumno();
    // Soporte
    static Character opt = '1';
    static Scanner scn = new Scanner(System.in);

    /**
     * Menú funcional para apartado de materias.
     *
     * @param s
     * @throws java.lang.Exception
     */
    public static void menuMaterias(Scanner s) throws Exception {
        try {
            do {
                System.out.printf("*** Menú apartado Materias. ***%n");
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
                            System.out.printf("• En caso de no existir el valor solicitado, será devuelto al menú.");
                            cmateria.actualizarMateria();
                            break;
                        case ('3'):
                            // Función para eliminar una materia.
                            cmateria.inhabilitarMateria();
                            break;
                        case ('4'):
                            // Función para buscar una materia y mostrarla
                            cmateria.buscarMateria();
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
                }
                if (opt == 'e') {
                    System.out.println("Saliendo del programa...");
                    Thread.sleep(1500);
                    System.out.println("Fin de la transmisión...");
                    System.exit(0);
                }
            } while (Pattern.matches("[1-9]", opt.toString())); // Revisión para saber que valor retorna
            // Puede ser mediante variables booleanas.
        } catch (Exception e) {
            throw e;
        }
        clearConsole();
    }

    /**
     * Menú funcional para apartado de grupos.
     *
     * @param s
     * @throws java.lang.Exception
     */
    public static void menuGrupos(Scanner s) throws Exception {
        try {
            do {
                System.out.printf("*** Menú apartado Grupos. ***%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("| - Seleccione una opción:       |%n");
                System.out.printf("| - Ingrese [e] para cerrar.     |%n");
                System.out.printf("| - Otro: <- Menú Anterior       |%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("•[1] Ingresar Grupo. \n"
                        + "•[2] Modificar Grupo. \n"
                        + "•[3] Eliminar Grupo. \n"
                        + "•[4] Buscar Grupo. \n"
                        + "•[5] Listar Grupos. \n"
                        + "•[6] Alumnos en un grupo. \n"
                        + "•[7] Ver grupos de materia. %n");

                opt = scn.next().charAt(0);
                if (Pattern.matches("[1-9]", opt.toString())) {
                    switch (opt) {
                        case ('1'):
                            // Mostramos las materias.
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
                            Materia tmp = cmateria.buscarMateria();
                            // Validamos si el valor es diferente a null
                            if (tmp != null) {
                                // Función para ingresar un grupo.
                                cgrupo.crearGrupos(tmp);
                            }
                            break;
                        case ('2'):
                            System.out.printf("• En caso de no existir el valor solicitado, será devuelto al menú.");
                            // Función para modificar un grupo
                            cgrupo.actualizarGrupo();
                            break;
                        case ('3'):
                            // Función para eliminar un grupo
                            cgrupo.inhabilitarGrupo();
                            break;
                        case ('4'):
                            cgrupo.buscarGrupoPorCodigo();
                            break;
                        case ('5'):
                            System.out.printf("-------------------------%n");
                            System.out.printf(" Listado de Grupos            %n");
                            System.out.printf("-------------------------%n");
                            System.out.printf("| %-10s | %-8s |%n", "GRUPO", "MATERIA");
                            System.out.printf("-------------------------%n");
                            for (int i = 0; i < cgrupo.getListGrupo().size(); i++) {
                                System.out.printf("| %-10s | %-8s |%n", cgrupo.getListGrupo().get(i).getNombreGrupo(),
                                        cgrupo.getListGrupo().get(i).getMateriaAsignada().getCodigoMateria());
                            }
                            System.out.printf("--------------------------------%n");
                            break;
                        case ('6'):
                            // Buscamos el grupo para filtrar
                            Grupo grtmp = cgrupo.buscarGrupoPorCodigo();
                            // Validamos si el valor es diferente a null
                            if (grtmp != null) {
                                // Función para ver los alumnos de un grupo.
                                List<GrupoAlumno> listGrAltmp = cgral.filtrarAlumnosdeGrupo(grtmp.getNombreGrupo());
                                System.out.printf("-------------------------------------------------%n");
                                System.out.printf("               Listado de Alumnos                %n");
                                System.out.printf("-------------------------------------------------%n");
                                System.out.printf("| %5s | %-10s | %-15s | %-10s |%n", "#", "CARNET", "NOMBRE COMPLETO", "GRUPO");
                                System.out.printf("-------------------------------------------------%n");
                                for (int i = 0; i < listGrAltmp.size(); i++) {
                                    System.out.printf("| %5s | %-10s | %-15s | %-10s |%n",
                                            listGrAltmp.get(i).getIdentificador(),
                                            listGrAltmp.get(i).getAlumnoDefinido().getCarnet(),
                                            listGrAltmp.get(i).getAlumnoDefinido().getNombreCompleto(),
                                            listGrAltmp.get(i).getGrupoPertenece().getNombreGrupo());
                                }
                                System.out.printf("-------------------------------------------------%n");
                            }
                            break;
                        case ('7'):
                            // Buscamos la materia para filtrar
                            Materia mattmp = cmateria.buscarMateria();
                            // Validamos si el valor es diferente a null
                            if (mattmp != null) {
                                // Función para ver los grupos de una materia.                     
                                List<Grupo> listGrtmp = cgrupo.filtrarGruposPorMateria(mattmp.getCodigoMateria());
                                System.out.printf("-------------------------%n");
                                System.out.printf(" Listado de Grupos            %n");
                                System.out.printf("-------------------------%n");
                                System.out.printf("| %-10s | %-8s |%n", "GRUPO", "MATERIA");
                                System.out.printf("-------------------------%n");
                                for (int i = 0; i < listGrtmp.size(); i++) {
                                    System.out.printf("| %-10s | %-8s |%n", listGrtmp.get(i).getNombreGrupo(),
                                            listGrtmp.get(i).getMateriaAsignada().getCodigoMateria());
                                }
                                System.out.printf("-------------------------%n");
                            }
                            break;
                    }
                }
                if (opt == 'e') {
                    System.out.println("Saliendo del programa...");
                    Thread.sleep(1500);
                    System.out.println("Fin de la transmisión...");
                    System.exit(0);
                }
            } while (Pattern.matches("[1-9]", opt.toString())); // Revisión para saber que valor retorna
            // Puede ser mediante variables booleanas.
        } catch (Exception e) {
            throw e;
        }
        clearConsole();
    }

    /**
     * Menú funcional para apartado de alumnos.
     *
     * @param s
     * @throws java.lang.Exception
     */
    public static void menuAlumnos(Scanner s) throws Exception {
        try {
            do {
                System.out.printf("*** Menú apartado Alumnos. ***%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("| - Seleccione una opción:       |%n");
                System.out.printf("| - Ingrese [e] para cerrar.     |%n");
                System.out.printf("| - Otro: <- Menú Anterior       |%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("•[1] Ingresar Alumno. \n"
                        + "•[2] Modificar Alumno. \n"
                        + "•[3] Eliminar Alumno. \n"
                        + "•[4] Buscar Alumno. \n"
                        + "•[5] Listar Alumnos. \n"
                        + "•[6] Añadir alumno a un grupo. %n");

                opt = scn.next().charAt(0);
                if (Pattern.matches("[1-9]", opt.toString())) {
                    switch (opt) {
                        case ('1'):
                            // Función para ingresar un alumno
                            calumno.crearAlumno();
                            break;
                        case ('2'):
                            System.out.printf("• En caso de no existir el valor solicitado, será devuelto al menú.");
                            // Función para modificar un alumno
                            calumno.modificarAlumno();
                            break;
                        case ('3'):
                            // Función para inhabilitar un alumno
                            calumno.inhabilitarAlumno();
                            break;
                        case ('4'):
                            // Función para buscar información de un alumno.
                            calumno.leerInformacionAlumno();
                            break;
                        case ('5'):
                            System.out.printf("----------------------------------%n");
                            System.out.printf(" Listado de Alumnos               %n");
                            System.out.printf("----------------------------------%n");
                            System.out.printf("| %-10s | %-10s |%n", "CARNET", "NOMBRE COMPLETO");
                            System.out.printf("----------------------------------%n");
                            for (int i = 0; i < calumno.getListaAlumnos().size(); i++) {
                                System.out.printf("| %-10s | %-10s |%n", calumno.getListaAlumnos().get(i).getCarnet(),
                                        calumno.getListaAlumnos().get(i).getNombreCompleto());
                            }
                            System.out.printf("----------------------------------%n");
                            break;
                        case ('6'):
                            //Mostramos los grupos disponibles
                            System.out.printf("-------------------------%n");
                            System.out.printf(" Listado de Grupos            %n");
                            System.out.printf("-------------------------%n");
                            System.out.printf("| %-10s | %-8s |%n", "GRUPO", "MATERIA");
                            System.out.printf("-------------------------%n");
                            for (int i = 0; i < cgrupo.getListGrupo().size(); i++) {
                                System.out.printf("| %-10s | %-8s |%n", cgrupo.getListGrupo().get(i).getNombreGrupo(),
                                        cgrupo.getListGrupo().get(i).getMateriaAsignada().getCodigoMateria());
                            }
                            System.out.printf("-------------------------%n");
                            //Buscamos el grupo
                            Grupo grupoTemp = cgrupo.buscarGrupoPorCodigo();
                            if (grupoTemp != null) {
                                boolean agregarAlumnos = true;
                                while (agregarAlumnos) {
                                    scn = new Scanner(System.in);
                                    // Pedimos el estudiante
                                    Alumno alumnoTemp = calumno.leerInformacionAlumno();
                                    if (alumnoTemp != null) {
                                        // Ingresamos los alumnos al grupo.
                                        cgral.asignarAlumnoAGrupo(grupoTemp, alumnoTemp);
                                        printer("*** ¿Desea agregar otro alumno al grupo? (s/n) ***", 0);
                                        String respuesta = scn.nextLine();
                                        if (respuesta.equalsIgnoreCase("n")) {
                                            agregarAlumnos = false;
                                        }
                                    }
                                }
                            }

                            break;
                    }
                }
                if (opt == 'e') {
                    System.out.println("Saliendo del programa...");
                    Thread.sleep(1500);
                    System.out.println("Fin de la transmisión...");
                    System.exit(0);
                }
            } while (Pattern.matches("[1-9]", opt.toString()));
        } catch (Exception e) {
            throw e;
        }
        clearConsole();
    }

    /**
     * Menú funcional para apartado de Ponderaciones.
     *
     * @param s
     * @throws java.lang.Exception
     */
    public static void menuPonderaciones(Scanner s) throws Exception {
        try {
            do {
                System.out.printf("*** Menú apartado Ponderaciones. ***%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("| - Seleccione una opción:       |%n");
                System.out.printf("| - Ingrese [e] para cerrar.     |%n");
                System.out.printf("| - Otro: <- Menú Anterior       |%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("•[1] Ingresar Ponderacion. \n"
                        + "•[2] Eliminar Ponderaciones. \n"
                        + "•[3] Ver ponderaciones materia. \n"
                        + "•[4] Listar Ponderaciones. %n");

                opt = scn.next().charAt(0);
                if (Pattern.matches("[1-9]", opt.toString())) {
                    switch (opt) {
                        case ('1'):
                            // Mostramos las materias
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
                            // Buscamos la materia que necesitemos
                            Materia tmp = cmateria.buscarMateria();
                            if (tmp != null) {
                                // Función para creación de ponderaciones
                                cpond.crearPonderacion(tmp);
                            }
                            break;
                        case ('2'):
                            // Buscamos la materia
                            Materia materiadel = cmateria.buscarMateria();
                            if (materiadel != null) {
                                // Función para eliminar las ponderaciones
                                cpond.inhabilitarPondMateria(materiadel);
                            }
                            break;
                        case ('3'):
                            // Buscamos la materia
                            Materia materiaFilter = cmateria.buscarMateria();
                            if (materiaFilter != null) {
                                // Filtramos por esa materia
                                List<Ponderacion> ltmp = cpond.filtrarPondPorMateria(materiaFilter.getCodigoMateria());
                                // Imprimimos la lista
                                System.out.printf("----------------------------------%n");
                                System.out.printf(" Listado de Ponderaciones               %n");
                                System.out.printf("----------------------------------%n");
                                System.out.printf("| %-10s | %-10s | %-10s |%n", "PORCENTAJE", "DESC", "MATERIA");
                                System.out.printf("----------------------------------%n");
                                for (int i = 0; i < ltmp.size(); i++) {
                                    System.out.printf("| %-10s | %-10s | %-10s |%n", ltmp.get(i).getPorcentaje(),
                                            ltmp.get(i).getDescripcion(), ltmp.get(i).getMateriaAsignada().getCodigoMateria());
                                }
                                System.out.printf("----------------------------------%n");
                            }
                            break;
                        case ('4'):
                            // Imprimimos la lista.
                            System.out.printf("----------------------------------%n");
                            System.out.printf(" Listado de Ponderaciones               %n");
                            System.out.printf("----------------------------------%n");
                            System.out.printf("| %-10s | %-10s | %-10s |%n", "PORCENTAJE", "DESC", "MATERIA");
                            System.out.printf("----------------------------------%n");
                            for (int i = 0; i < cpond.getListPond().size(); i++) {
                                System.out.printf("| %-10s | %-10s | %-10s |%n", cpond.getListPond().get(i).getPorcentaje(),
                                        cpond.getListPond().get(i).getDescripcion(), cpond.getListPond().get(i).getMateriaAsignada().getCodigoMateria());
                            }
                            System.out.printf("----------------------------------%n");
                            break;
                    }
                }
                if (opt == 'e') {
                    System.out.println("Saliendo del programa...");
                    Thread.sleep(1500);
                    System.out.println("Fin de la transmisión...");
                    System.exit(0);
                }
            } while (Pattern.matches("[1-9]", opt.toString()));
        } catch (Exception e) {
            throw e;
        }
        clearConsole();
    }

    /**
     * Menú funcional para apartado de Calificaciones.
     *
     * @param s
     * @throws java.lang.Exception
     */
    public static void menuCalificaciones(Scanner s) throws Exception {
        try {
            do {
                System.out.printf("*** Menú apartado Calificaciones. ***%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("| - Seleccione una opción:       |%n");
                System.out.printf("| - Ingrese [e] para cerrar.     |%n");
                System.out.printf("| - Otro: <- Menú Anterior       |%n");
                System.out.printf("---------------------------------%n");
                System.out.printf("•[1] Ingresar Calificacion. \n"
                        + "•[2] Eliminar Calificacion. \n"
                        + "•[3] Ver resumen calificaciones. \n"
                        + "•[4] Ver calificaciones por alumno. %n");

                opt = scn.next().charAt(0);
                if (Pattern.matches("[1-9]", opt.toString())) {
                    switch (opt) {
                        case ('1'):
                            // Mostramos los grupos
                            System.out.printf("-------------------------%n");
                            System.out.printf(" Listado de Grupos            %n");
                            System.out.printf("-------------------------%n");
                            System.out.printf("| %-10s | %-8s |%n", "GRUPO", "MATERIA");
                            System.out.printf("-------------------------%n");
                            for (int i = 0; i < cgrupo.getListGrupo().size(); i++) {
                                System.out.printf("| %-10s | %-8s |%n", cgrupo.getListGrupo().get(i).getNombreGrupo(),
                                        cgrupo.getListGrupo().get(i).getMateriaAsignada().getCodigoMateria());
                            }
                            System.out.printf("--------------------------------%n");
                            // Buscamos el grupo que necesitamos.
                            Grupo grupoFilter = cgrupo.buscarGrupoPorCodigo();
                            if (grupoFilter != null && grupoFilter.getMateriaAsignada() != null) {
                                // Filtramos por ese grupo.
                                List<GrupoAlumno> listGrAltmp = cgral.filtrarAlumnosdeGrupo(grupoFilter.getNombreGrupo());
                                // Imprimimos la lista de alumnos en el grupo
                                System.out.printf("-------------------------------------------------------%n");
                                System.out.printf("                    Listado de Alumnos                 %n");
                                System.out.printf("-------------------------------------------------------%n");
                                System.out.printf("| %5s | %-10s | %-15s | %-10s |%n", "#", "CARNET", "NOMBRE COMPLETO", "GRUPO");
                                System.out.printf("-------------------------------------------------------%n");
                                for (int i = 0; i < listGrAltmp.size(); i++) {
                                    System.out.printf("| %5s | %-10s | %-15s | %-10s |%n",
                                            listGrAltmp.get(i).getIdentificador(),
                                            listGrAltmp.get(i).getAlumnoDefinido().getCarnet(),
                                            listGrAltmp.get(i).getAlumnoDefinido().getNombreCompleto(),
                                            listGrAltmp.get(i).getGrupoPertenece().getNombreGrupo());
                                }
                                System.out.printf("---------------------------------------------------%n");
                                //Buscamos el alumno necesitado, filtrando la lista anterior.
                                GrupoAlumno gralFilter = cgral.obtenerAlumnoGrupoID(listGrAltmp);
                                if (gralFilter != null) {
                                    // Elegimos el valor de la ponderación.                                    
                                    // Filtramos por la materia
                                    List<Ponderacion> listPondFilter
                                            = cpond.filtrarPondPorMateria(grupoFilter.getMateriaAsignada().getCodigoMateria());
                                    // Imprimimos la lista
                                    System.out.printf("---------------------------------------------%n");
                                    System.out.printf("           Listado de Ponderaciones          %n");
                                    System.out.printf("---------------------------------------------%n");
                                    System.out.printf("| %-10s | %-10s | %-10s |%n", "PORCENTAJE", "DESC", "MATERIA");
                                    System.out.printf("---------------------------------------------%n");
                                    for (int i = 0; i < listPondFilter.size(); i++) {
                                        System.out.printf("| %-10s | %-10s | %-10s |%n", listPondFilter.get(i).getPorcentaje(),
                                                listPondFilter.get(i).getDescripcion(), listPondFilter.get(i).getMateriaAsignada().getCodigoMateria());
                                    }
                                    System.out.printf("---------------------------------------------%n");
                                    // Elegimos una ponderación
                                    Ponderacion pndtmp = cpond.obtenerDeListaxIndex(listPondFilter);
                                    if (pndtmp != null) {
                                        // Creamos la calificación
                                        ccalif.ingresarCalificacion(gralFilter, pndtmp);
                                        break;
                                    }
                                }
                            }
                            break;
                        case ('2'):
                            System.out.printf("------------------------------------------------%n");
                            System.out.printf("             Listado de Calificaciones          %n");
                            System.out.printf("------------------------------------------------%n");
                            System.out.printf("| %-5s | %-10s | %-15s | %-10s | %-5s |%n", "#", "CARNET", "NOMBRE", "CONCEPTO", "CALIFICACIÓN");
                            System.out.printf("------------------------------------------------%n");
                            for (int i = 0; i < ccalif.getListCalif().size(); i++) {
                                System.out.printf("| %-5s| %-10s | %-15s | %-10s | %-5s |%n",
                                        ccalif.getListCalif().get(i).getIdentificador(),
                                        ccalif.getListCalif().get(i).getGrupoAlumno().getAlumnoDefinido().getCarnet(),
                                        ccalif.getListCalif().get(i).getGrupoAlumno().getAlumnoDefinido().getNombreCompleto(),
                                        (ccalif.getListCalif().get(i).getPonderacion().getPorcentaje() + "% -" + ccalif.getListCalif().get(i).getPonderacion().getDescripcion()),
                                        ccalif.getListCalif().get(i).getCalificacion()
                                );
                            }
                            System.out.printf("------------------------------------------------%n");
                            // Función para inhabilitar una materia.
                            ccalif.inhabilitarCalificacion();
                            break;
                        case ('3'): // Ver resumen de calificaciones
                            // Buscamos la materia para filtrar
                            Materia mattmp = cmateria.buscarMateria();
                            // Validamos si el valor es diferente a null
                            if (mattmp != null) {
                                // Función para ver los grupos de una materia.                     
                                List<Grupo> listGrtmp = cgrupo.filtrarGruposPorMateria(mattmp.getCodigoMateria());
                                System.out.printf("----------------------------%n");
                                System.out.printf(" Listado de Grupos          %n");
                                System.out.printf("----------------------------%n");
                                System.out.printf("| %-10s | %-8s |%n", "GRUPO", "MATERIA");
                                System.out.printf("----------------------------%n");
                                for (int i = 0; i < listGrtmp.size(); i++) {
                                    System.out.printf("| %-10s | %-8s |%n", listGrtmp.get(i).getNombreGrupo(),
                                            listGrtmp.get(i).getMateriaAsignada().getCodigoMateria());
                                }
                                System.out.printf("----------------------------%n");
                                // Buscamos el grupo para filtrar
                                Grupo grupoCaliftmp = cgrupo.buscarGrupoPorCodigo();
                                if (grupoCaliftmp != null) {
                                    List<Calificacion> listCalifFilter = ccalif.filtrarCalifGrupo(grupoCaliftmp.getNombreGrupo());
                                    System.out.printf("------------------------------------------------%n");
                                    System.out.printf("             Listado de Calificaciones          %n");
                                    System.out.printf("------------------------------------------------%n");
                                    System.out.printf("| %-5s | %-10s | %-15s | %-10s | %-5s |%n", "#", "CARNET", "NOMBRE", "CONCEPTO", "CALIFICACIÓN");
                                    System.out.printf("------------------------------------------------%n");
                                    for (int i = 0; i < listCalifFilter.size(); i++) {
                                        System.out.printf("| %-5s | %-10s | %-15s | %-10s | %-5s |%n",
                                                listCalifFilter.get(i).getIdentificador(),
                                                listCalifFilter.get(i).getGrupoAlumno().getAlumnoDefinido().getCarnet(),
                                                listCalifFilter.get(i).getGrupoAlumno().getAlumnoDefinido().getNombreCompleto(),
                                                (listCalifFilter.get(i).getPonderacion().getPorcentaje() + "% -" + listCalifFilter.get(i).getPonderacion().getDescripcion()),
                                                listCalifFilter.get(i).getCalificacion()
                                        );
                                    }
                                    System.out.printf("------------------------------------------------%n");
                                }
                            }
                            break;
                        case ('4'): //Ver calificaciones por alumno.
                            // Mostramos los alumnos
                            System.out.printf("----------------------------------%n");
                            System.out.printf(" Listado de Alumnos               %n");
                            System.out.printf("----------------------------------%n");
                            System.out.printf("| %-10s | %-10s |%n", "CARNET", "NOMBRE COMPLETO");
                            System.out.printf("----------------------------------%n");
                            for (int i = 0; i < calumno.getListaAlumnos().size(); i++) {
                                System.out.printf("| %-10s | %-10s |%n", calumno.getListaAlumnos().get(i).getCarnet(),
                                        calumno.getListaAlumnos().get(i).getNombreCompleto());
                            }
                            System.out.printf("----------------------------------%n");
                            // Buscamos el alumno pedido
                            Alumno alumnoFilter = calumno.leerInformacionAlumno();
                            if (alumnoFilter != null) {
                                // Obtenemos las materias de ese alumno
                                List<GrupoAlumno> listGrAltmp = cgral.filtrarGruposPorAlumno(alumnoFilter.getCarnet());
                                // Imprimimos la lista de materias del alumno
                                System.out.printf("------------------------------------------------%n");
                                System.out.printf("               Materias inscritas               %n");
                                System.out.printf("------------------------------------------------%n");
                                System.out.printf("| %5s | %-10s | %-15s | %-10s |%n", "#", "CARNET", "NOMBRE COMPLETO", "MATERIA");
                                System.out.printf("------------------------------------------------%n");
                                for (int i = 0; i < listGrAltmp.size(); i++) {
                                    System.out.printf("| %5s | %-10s | %-15s | %-10s |%n",
                                            listGrAltmp.get(i).getIdentificador(),
                                            listGrAltmp.get(i).getAlumnoDefinido().getCarnet(),
                                            listGrAltmp.get(i).getAlumnoDefinido().getNombreCompleto(),
                                            listGrAltmp.get(i).getGrupoPertenece().getMateriaAsignada().getCodigoMateria());
                                }
                                System.out.printf("------------------------------------------------%n");

                                System.out.printf("\n\n");
                                for (int i = 0; i < listGrAltmp.size(); i++) {
                                    /* Filtramos las notas en base a carnet y grupo
                                       de esta forma, podemos filtrar por materia igualmente.
                                     */
                                    List<Calificacion> listCalifGrAlFilter
                                            = ccalif.filtrarCalifAlumnoGrupo(alumnoFilter.getCarnet(), listGrAltmp.get(i).getGrupoPertenece().getNombreGrupo());
                                    // Imprimimos las notas de todas las materias para este alumno.
                                    printer("• " + listGrAltmp.get(i).getGrupoPertenece().getMateriaAsignada().getNombreMateria());
                                    System.out.printf("------------------------------------------------%n");
                                    System.out.printf("             Listado de Calificaciones          %n");
                                    System.out.printf("------------------------------------------------%n");
                                    System.out.printf("| %-5s | %-10s | %-15s | %-10s | %-5s |%n", "#", "CARNET", "NOMBRE", "CONCEPTO", "CALIFICACIÓN");
                                    System.out.printf("------------------------------------------------%n");
                                    for (int j = 0; j < listCalifGrAlFilter.size(); j++) {
                                        System.out.printf("| %-5s | %-10s | %-15s | %-10s | %-5s |%n",
                                                listCalifGrAlFilter.get(i).getIdentificador(),
                                                listCalifGrAlFilter.get(j).getGrupoAlumno().getAlumnoDefinido().getCarnet(),
                                                listCalifGrAlFilter.get(j).getGrupoAlumno().getAlumnoDefinido().getNombreCompleto(),
                                                (listCalifGrAlFilter.get(j).getPonderacion().getPorcentaje() + "% -" + listCalifGrAlFilter.get(j).getPonderacion().getDescripcion()),
                                                listCalifGrAlFilter.get(j).getCalificacion()
                                        );
                                    }
                                    System.out.printf("------------------------------------------------%n");
                                    printer("PROMEDIO : "
                                            + listCalifGrAlFilter.stream().mapToDouble(Calificacion::getCalificacion)
                                                    .average()
                                                    .orElse(0.00));
                                    System.out.printf("------------------------------------------------%n");
                                }
                            }
                            break;
                    }
                }
                if (opt == 'e') {
                    System.out.println("Saliendo del programa...");
                    Thread.sleep(1500);
                    System.out.println("Fin de la transmisión...");
                    System.exit(0);
                }
            } while (Pattern.matches("[1-9]", opt.toString()));
        } catch (Exception e) {
            throw e;
        }
        clearConsole();
    }

}
