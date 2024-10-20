package EjerciciosExamen1;

import java.util.Scanner;

public class Ej2_AlumnosCurso {

    public static void main(String[] args) {
        // Creación del objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Variables necesarias
        int clasesMenosDe8 = 0;
        double mayorMedia = -1;
        double menorMedia = Double.MAX_VALUE;
        String cursoMayorMedia = "";
        String cursoMenorMedia = "";
        int maxSuspensos1 = -1, maxSuspensos2 = -1;
        String cursoMaxSuspensos1 = "", cursoMaxSuspensos2 = "";
        boolean algunCursoMenos2Suspensos = false;
        int aprobadosMax5Alumnos = 0;
        String cursoAprobadosMax5Alumnos = "";
        int ultimaNota1 = 0, ultimaNota2 = 0;

        while (true) {
            // Pedir el curso al usuario
            System.out.print("Introduce el nombre del curso (o 'fin' para terminar): ");
            String curso = scanner.nextLine();

            // Si se introduce 'fin', termina el ciclo
            if (curso.equalsIgnoreCase("fin")) {
                break;
            }

            // Pedir cuántos alumnos tiene el curso
            System.out.print("Introduce el número de alumnos en " + curso + ": ");
            int numAlumnos = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            int[] notas = new int[numAlumnos];
            int sumaNotas = 0;
            int suspensos = 0;
            int aprobados = 0;

            // Pedir las notas de los alumnos
            for (int i = 0; i < numAlumnos; i++) {
                System.out.print("Introduce la nota del alumno " + (i + 1) + ": ");
                notas[i] = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                sumaNotas += notas[i];

                // Verificar suspensos y aprobados
                if (notas[i] < 5) {
                    suspensos++;
                } else {
                    aprobados++;
                }

                // Guardar las dos últimas notas del último curso
                if (i == numAlumnos - 2) {
                    ultimaNota1 = notas[i];
                }
                if (i == numAlumnos - 1) {
                    ultimaNota2 = notas[i];
                }
            }

            // Calcular la media aritmética del curso
            double mediaCurso = (double) sumaNotas / numAlumnos;
            System.out.println("La media aritmética de " + curso + " es: " + mediaCurso);

            // Contar clases con menos de 8 alumnos
            if (numAlumnos < 8) {
                clasesMenosDe8++;
            }

            // Actualizar curso con mayor y menor media
            if (mediaCurso > mayorMedia) {
                mayorMedia = mediaCurso;
                cursoMayorMedia = curso;
            }
            if (mediaCurso < menorMedia) {
                menorMedia = mediaCurso;
                cursoMenorMedia = curso;
            }

            // Actualizar los dos cursos con mayor número de suspensos
            if (suspensos > maxSuspensos1) {
                maxSuspensos2 = maxSuspensos1;
                cursoMaxSuspensos2 = cursoMaxSuspensos1;
                maxSuspensos1 = suspensos;
                cursoMaxSuspensos1 = curso;
            } else if (suspensos > maxSuspensos2) {
                maxSuspensos2 = suspensos;
                cursoMaxSuspensos2 = curso;
            }

            // Verificar si algún curso tiene menos de 2 suspensos
            if (suspensos < 2) {
                algunCursoMenos2Suspensos = true;
            }

            // Verificar entre los cursos de más de 5 alumnos cuál tiene el mayor número de aprobados
            if (numAlumnos > 5 && aprobados > aprobadosMax5Alumnos) {
                aprobadosMax5Alumnos = aprobados;
                cursoAprobadosMax5Alumnos = curso;
            }
        }

        // Mostrar resultados
        System.out.println("\nResultados:");
        System.out.println("Número de clases con menos de 8 alumnos: " + clasesMenosDe8);
        System.out.println("Curso con mayor nota media: " + cursoMayorMedia + " (" + mayorMedia + ")");
        System.out.println("Curso con menor nota media: " + cursoMenorMedia + " (" + menorMedia + ")");
        System.out.println("Dos cursos con mayor número de suspensos: " + cursoMaxSuspensos1 + " (" + maxSuspensos1 + ") y " + cursoMaxSuspensos2 + " (" + maxSuspensos2 + ")");
        
        if (algunCursoMenos2Suspensos) {
            System.out.println("Ha habido algún curso con menos de 2 suspensos.");
        } else {
            System.out.println("No ha habido ningún curso con menos de 2 suspensos.");
        }

        if (!cursoAprobadosMax5Alumnos.equals("")) {
            System.out.println("El curso con más de 5 alumnos y mayor número de aprobados: " + cursoAprobadosMax5Alumnos);
        }

        System.out.println("Las dos últimas notas del último curso introducido: " + ultimaNota1 + " y " + ultimaNota2);

        // Cerrar el scanner
        scanner.close();
    }
}

