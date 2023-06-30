package com.med.sistema_calificaciones.controller;

import com.med.sistema_calificaciones.model.Materia;
import static com.med.sistema_calificaciones.utils.Impresion.printer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;

/**
 *
 * @author RomanMendoza
 */
public class cMateria implements Serializable {

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

    public void registroMateria() throws Exception {
        this.init();
        try {
            entrada = new Scanner(System.in);
            printer("Registro de Materia: ");
            printer("Por favor,introduzca el nombre de la materia a registrar: ");
            partesMateria.setNombreMateria(entrada.nextLine());
            printer("Ahora, ingrese cual será el código de la materia a registrar: ");
            partesMateria.setCodigoMateria(entrada.nextLine());
            printer("Dime el ciclo en que se debería cursar esta materia: ");
            partesMateria.setCicloMateria(entrada.nextInt());

            //Añadimos a la lista
            this.listMateria.add(partesMateria);
            //Mostramos
            System.out.printf("---------------------------------%n");
            printer("• Nueva Materia Ingresada.");
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
                printer("• Materia actualizada.");
                printer("Información: ");
                printer("Nombre de Materia: " + m.getNombreMateria());
                printer("Código de Materia: " + m.getCodigoMateria());
                printer("Ciclo en que se cursará la Materia: " + m.getCicloMateria());
                System.out.printf("---------------------------------%n");
                break;
            }
        }
        this.init();
    }

    public Materia buscarMateria() throws Exception {
        this.init();
        try {
            entrada = new Scanner(System.in);
            printer("Introduzca el código de la materia:");
            this.partesMateria.setCodigoMateria(entrada.nextLine());
            if (!this.listMateria.isEmpty()) {
                for (Materia m : listMateria) {
                    if (m.getCodigoMateria().equals(partesMateria.getCodigoMateria())) {
                        System.out.printf("---------------------------------%n");
                        printer("• Materia Encontrada.");
                        printer("   Información de materia ");
                        printer("   Nombre: " + m.getNombreMateria());
                        printer("   Código: " + m.getCodigoMateria());
                        printer("   Ciclo: " + m.getCicloMateria());
                        System.out.printf("---------------------------------%n");
                        this.init();
                        return m;
                    }
                }
            }
            this.init();
        } catch (Exception e) {
            throw e;
        }
        System.out.printf("---------------------------------------------------%n");
        printer("• No se encontro una materia con el código recibido.", 0);
        System.out.printf("---------------------------------------------------%n");
        return null; // Si no se encuentra una materia, se retorna null

    }

    public void inhabilitarMateria() {
        entrada = new Scanner(System.in);
        printer("Ingrese el código de la materia que desea inhabilitar:");
        String codigo = entrada.nextLine();
        for (Materia m : listMateria) {
            if (m.getCodigoMateria().equals(codigo)) {
                listMateria.remove(m);
                System.out.printf("---------------------------------%n");
                printer("La materia con código '" + codigo + "', ha sido inhabilitada.");
                System.out.printf("---------------------------------%n");
                this.init();
                return;
            }
        }
        System.out.printf("---------------------------------%n");
        printer("La materia con código '" + codigo + "', no existe.", 0);
        System.out.printf("---------------------------------%n");
    }
}
