package EjerciciosCortosExamen;

import java.util.Scanner;

public class Ej1_CentroEducativo {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definición de los grupos y sus cantidades de alumnos
        int numAlumnos = 0;
        String grupoSeleccionado = "";

        // Pedir al usuario que ingrese el grupo
        while (true) {
            System.out.println("Introduce la letra del grupo (A, B, C, D):");
            grupoSeleccionado = scanner.next().toUpperCase();

            switch (grupoSeleccionado) {
                case "A":
                    numAlumnos = 25;
                    break;
                case "B":
                    numAlumnos = 28;
                    break;
                case "C":
                    numAlumnos = 31;
                    break;
                case "D":
                    numAlumnos = 29;
                    break;
                default:
                    System.out.println("Grupo inválido. Inténtalo de nuevo.");
                    continue;
            }
            break; // Sale del bucle si el grupo es válido
        }

        // Arrays para almacenar la información de los alumnos
        String[] nombres = new String[numAlumnos];
        double[][] notas = new double[numAlumnos][3]; // Notas de cada parcial

        // Solicitar datos de los alumnos
        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("Introduce el nombre del alumno " + (i + 1) + ":");
            nombres[i] = scanner.next();

            // Solicitar las notas
            System.out.println("Introduce la nota del primer parcial de " + nombres[i] + ":");
            notas[i][0] = scanner.nextDouble();
            System.out.println("Introduce la nota del segundo parcial de " + nombres[i] + ":");
            notas[i][1] = scanner.nextDouble();
            System.out.println("Introduce la nota del tercer parcial de " + nombres[i] + ":");
            notas[i][2] = scanner.nextDouble();
        }

        // Variables para los resultados finales
        String alumnoMayorNota = "";
        double mayorNotaMedia = 0;
        int alumnosSuspensos = 0;
        boolean existenSobresalientes = false;

        // Calcular los resultados
        for (int i = 0; i < numAlumnos; i++) {
            double promedio = (notas[i][0] + notas[i][1] + notas[i][2]) / 3.0;

            // Comprobar si es la mayor nota media
            if (promedio > mayorNotaMedia) {
                mayorNotaMedia = promedio;
                alumnoMayorNota = nombres[i];
            }

            // Contar alumnos con nota media suspensa (menor que 5)
            if (promedio < 5) {
                alumnosSuspensos++;
            }

            // Comprobar si hay sobresalientes (nota mayor o igual que 9)
            if (promedio >= 9) {
                existenSobresalientes = true;
            }
        }

        // Mostrar los resultados
        System.out.println("\nResultados:");
        System.out.println("El alumno con mayor nota media es: " + alumnoMayorNota + " con una media de " + mayorNotaMedia);
        System.out.println("Cantidad de alumnos con la nota media suspensa: " + alumnosSuspensos);
        if (existenSobresalientes) {
            System.out.println("Existen sobresalientes");
        } else {
            System.out.println("No existen sobresalientes");
        }

        // Cerrar el escáner
        scanner.close();
    }
}

