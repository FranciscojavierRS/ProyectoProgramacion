package ExamenOficinaEstudios;

import java.util.Scanner;

public class OficinaEstudios {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombreClase = ""; 
        String nombreTutor;

        while (true) {
            System.out.print("Nombre de la clase (o 'fin' para terminar): ");
            nombreClase = sc.nextLine();

            if (nombreClase.equalsIgnoreCase("fin")) {
                break; // salir del bucle si escribe 'fin'
            }

            System.out.print("Nombre del tutor: ");
            nombreTutor = sc.nextLine();

            System.out.println("Clase: " + nombreClase + " | Tutor: " + nombreTutor);
            System.out.println("----------------------------------");
            // Aquí luego pediremos los alumnos
        }

        sc.close();
        System.out.println("Fin del programa.");
    }
}
