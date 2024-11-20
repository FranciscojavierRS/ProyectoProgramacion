package EjerciciosTABLAS2;

import java.util.Scanner;

public class Ej1_CentroEducativo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Definir una matriz de 3 filas (trimestres) y 5 columnas (alumnos)
        int[][] notas = new int[3][5];

        // Leer las notas de los alumnos para cada trimestre
        for (int trimestre = 0; trimestre < 3; trimestre++) {
            System.out.println("Introduce las notas del trimestre " + (trimestre + 1) + ":");
            for (int alumno = 0; alumno < 5; alumno++) {
                System.out.print("Alumno " + (alumno + 1) + ": ");
                notas[trimestre][alumno] = sc.nextInt();
            }
        }

        // Calcular y mostrar la media del grupo en cada trimestre
        for (int trimestre = 0; trimestre < 3; trimestre++) {
            int sumaNotasTrimestre = 0;
            for (int alumno = 0; alumno < 5; alumno++) {
                sumaNotasTrimestre += notas[trimestre][alumno];
            }
            double mediaTrimestre = (double) sumaNotasTrimestre / 5;
            System.out.println("La media del grupo en el trimestre " + (trimestre + 1) + " es: " + mediaTrimestre);
        }

        // Pedir la posición del alumno para calcular su media
        System.out.println("Introduce la posición del alumno (1-5) para calcular su media: ");
        int pos = sc.nextInt() - 1; // Restamos 1 porque las posiciones en el array empiezan desde 0

        // Verificar si la posición es válida
        if (pos >= 0 && pos < 5) {
            int sumaNotasAlumno = 0;
            for (int trimestre = 0; trimestre < 3; trimestre++) {
                sumaNotasAlumno += notas[trimestre][pos];
            }
            double mediaAlumno = (double) sumaNotasAlumno / 3;
            System.out.println("La media del alumno en la posición " + (pos + 1) + " es: " + mediaAlumno);
        } else {
            System.out.println("Posición no válida.");
        }

        sc.close();
    }
}

