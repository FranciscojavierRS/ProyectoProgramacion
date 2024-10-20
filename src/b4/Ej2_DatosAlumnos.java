package b4;

import java.util.Scanner;

public class Ej2_DatosAlumnos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        int sumaEdades = 0;
        int contadorAlumnos = 0;
        int mayoresDeEdad = 0;

        // Leer las edades de los alumnos
        do {
            System.out.print("Introduce la edad del alumno (un número negativo para terminar): ");
            edad = sc.nextInt();

            if (edad >= 0) {
                sumaEdades += edad;
                contadorAlumnos++;

                if (edad >= 18) {
                    mayoresDeEdad++;
                }
            }

        } while (edad >= 0);

        // Comprobación 
        if (contadorAlumnos > 0) {
            double mediaEdades = (double) sumaEdades / contadorAlumnos;

            // resultados
            System.out.println("Número de alumnos introducidos: " + contadorAlumnos);
            System.out.println("Suma de las edades: " + sumaEdades);
            System.out.println("Media de las edades: " + mediaEdades);
            System.out.println("Número de alumnos mayores de edad: " + mayoresDeEdad);
        } else {
            System.out.println("No se ha introducido ninguna edad válida.");
        }

        sc.close();
    }
}
