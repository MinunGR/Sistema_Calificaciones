package com.mycompany.crud_materias;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author RomanMendoza
 */
public class CRUD_Materias {
   Materia PartesMateria = new Materia();
   private static List<Materia> Materia = new ArrayList<>();
   
    public void registroMateria(){
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Registro de Materia: ");
        System.out.println("Por favor,introduzca el nombre de la materia aregistrar: ");
        PartesMateria.nombreMateria = entrada.nextLine();
        System.out.println("Ahora, ingrese cual será el código de la materia a registrar: ");
        PartesMateria.codigoMateria = entrada.nextLine();
        System.out.println("Dime el año en que se debería cursar esta materia: ");
        PartesMateria.CicloMateria = entrada.nextInt();
        
        System.out.println("Nueva Materia Ingresada.");
        System.out.println("Información:");
        System.out.println("Nombre de Materia: "+PartesMateria.nombreMateria);
        System.out.println("Código de Materia: "+PartesMateria.codigoMateria);
        System.out.println("Ciclo en que se cursará la Materia: "+PartesMateria.CicloMateria);
    }
   
    public void actualizarMateria(){
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Actualización de Materia: ");
        System.out.println("Por favor, introduzca el código de la materia a actualizar: ");
        String codigo = entrada.nextLine();

    if(codigo.equals(PartesMateria.getCodigoMateria())){
        System.out.println("Ingrese el nuevo nombre de la materia: ");
        PartesMateria.setNombreMateria(entrada.nextLine());
        System.out.println("Ingrese el nuevo código de la materia: ");
        PartesMateria.setCodigoMateria(entrada.nextLine());
        System.out.println("Ingrese el nuevo ciclo de la materia: ");
        PartesMateria.setCicloMateria(entrada.nextInt());
    
        System.out.println("Materia actualizada.");
        System.out.println("Información actualizada: ");
        System.out.println("Nombre de Materia: "+PartesMateria.getNombreMateria());
        System.out.println("Código de Materia: "+PartesMateria.getCodigoMateria());
        System.out.println("Ciclo en que se cursará la Materia: "+PartesMateria.getCicloMateria());
    } 
    else {
    System.out.println("La materia con el código especificado no existe.");
        }
    }
    
    public void leerMateria() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Lectura de Materia:");
        System.out.println("Introduzca el nombre de la materia:");
        PartesMateria.setNombreMateria(entrada.nextLine());
        System.out.println("Introduzca el código de la materia:");
        PartesMateria.setCodigoMateria(entrada.nextLine());
        System.out.println("Introduzca el ciclo de la materia:");
        PartesMateria.setCicloMateria(entrada.nextInt());

        System.out.println("Materia.");
        System.out.println("Información de materia: ");
        System.out.println("Nombre: " + PartesMateria.getNombreMateria());
        System.out.println("Código: " + PartesMateria.getCodigoMateria());
        System.out.println("Ciclo: " + PartesMateria.getCicloMateria());
    }

    public static void inhabilitarMateria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el código de la materia que desea inhabilitar:");
        String codigo = sc.nextLine();
        for (Materia m : Materia) {
            if (m.getCodigoMateria().equals(codigo)) {
                Materia.remove(m);
                System.out.println("La materia con código '" + codigo + "'; ha sido inhabilitada.");
                return;
            }
        }
        System.out.println("La materia con código '" + codigo + "'; no existe.");
    }
}
    