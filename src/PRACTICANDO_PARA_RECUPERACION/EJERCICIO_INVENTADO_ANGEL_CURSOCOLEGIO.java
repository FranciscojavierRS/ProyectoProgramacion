package PRACTICANDO_PARA_RECUPERACION;

import java.util.Arrays;
import java.util.Scanner;

public class EJERCICIO_INVENTADO_ANGEL_CURSOCOLEGIO {

    // Registrar asignaturas, alumnos y notas. Máximo 8 asignaturas y 20 alumnos
    private static final int MAXASIGNATURA = 8;  // Número máximo de asignaturas
    private static final int MAXALUMNO = 20;     // Número máximo de alumnos
    
    // Matriz que almacena las notas de los alumnos en las distintas asignaturas
    private static float[][] notas = new float[MAXASIGNATURA][MAXALUMNO];
    
    // Contadores para el número de alumnos y asignaturas
    private static int numalumno = 0;
    private static int numasignatura = 0;
    
    // Arrays para almacenar los nombres de las asignaturas y alumnos
    private static String[] nombreasignaturas = new String[MAXASIGNATURA];
    private static String[] nombrealumnos = new String[MAXALUMNO];
    
    public static void main(String[] args) {
        inicializarDatos(); // Inicializa la matriz de notas con valores por defecto (-1)
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Bucle principal para el menú interactivo
        while (opcion != 6) {
            System.out.println("1-Insertar datos. Se pedira nombre de asignatura, nombre del alumno y la nota del alumno\n"
            		+ "2-Mostrar los datos registrados ordenados alfabeticamente por asignatura\n"
					+ "3-Para una asignatura dada por teclado. Mostrar la nota media de la clase\n"
					+ "4-Mostrar Alumnos que tengan que repetir. Un alumno tiene que repetir si tiene suspensas más de 2 asignaturas\n"
					+ "5-Mostrar cuántos alumnos aprobaron y cuántos suspendieron en cada asignatura\n" + "6-Fin");

            opcion = sc.nextInt();
            switch (opcion) {
            case 1:
                // Opción para insertar los datos de una asignatura, alumno y nota
                insertarDatos(sc);
                break;
            case 2:
                // Opción para mostrar los datos registrados ordenados alfabéticamente por asignatura
                mostrarDatosAlfabeticamente();
                break;
            case 3:
                // Opción para calcular y mostrar la nota media de una asignatura
                notaMediaClase(sc);
                break;
            case 4:
                // Opción para mostrar los alumnos que deben repetir
                mostrarAlumnosRepetir();
                break;
            case 5:
                // Opción (no implementada en este código) para mostrar los alumnos aprobados y suspendidos por asignatura
                break;
            default:
                break;
            }
        }
        sc.close(); // Cerrar el Scanner al finalizar
    }

    // Función para mostrar los alumnos que deben repetir (tienen más de 2 asignaturas suspensas)
    private static void mostrarAlumnosRepetir() {
        for (int j = 0; j < numalumno; j++) {
            int suspensas = 0;
            // Recorremos las notas de cada alumno y contamos cuántas asignaturas tiene suspendidas
            for (int i = 0; i < numasignatura; i++) {
                if (notas[i][j] < 5) { // Nota inferior a 5 indica suspenso
                    suspensas++;
                }
            }
            // Si tiene más de 2 asignaturas suspendidas, el alumno debe repetir
            if (suspensas > 2) {
                System.out.println(nombrealumnos[j]);
            }
        }
    }

    // Función para calcular y mostrar la nota media de una asignatura dada por teclado
    private static void notaMediaClase(Scanner sc) {
        System.out.println("Introduce una asignatura:");
        String asignatura = sc.next(); // Leemos el nombre de la asignatura
        int indice = indiceAsignatura(asignatura); // Obtenemos el índice de la asignatura en el array
        
        float sumaNotas = 0;
        int alumnosAsignatura = 0;
        // Recorremos las notas de la asignatura y sumamos las notas de los alumnos
        for (int j = 0; j < numalumno; j++) {
            if (notas[indice][j] != -1) { // Solo contamos las notas ingresadas
                sumaNotas += notas[indice][j];
                alumnosAsignatura++;
            }
        }
        // Calculamos y mostramos la nota media de la asignatura
        System.out.println(asignatura + ": " + sumaNotas / alumnosAsignatura);
    }

    // Función para mostrar los datos ordenados alfabéticamente por asignatura
    private static void mostrarDatosAlfabeticamente() {
        // Ordenamos las asignaturas alfabéticamente
        String[] asignaturasOrdenadas = getOrdenarArray(nombreasignaturas, numasignatura);
        // Mostramos las asignaturas y las notas de los alumnos para cada asignatura
        for (int i = 0; i < numasignatura; i++) {
            String asignatura = asignaturasOrdenadas[i];
            int indice = indiceAsignatura(asignatura);
            System.out.println("ASIGNATURA " + asignatura);
            // Mostramos las notas de los alumnos para la asignatura actual
            for (int j = 0; j < MAXALUMNO; j++) {
                if (notas[indice][j] != -1) {
                    System.out.println(nombrealumnos[j] + " - " + notas[indice][j] + " nota");
                }
            }
        }
    }

    // Función para ordenar un array de cadenas alfabéticamente
    private static String[] getOrdenarArray(String[] array, int numElementos) {
        String[] arrayOrdenado = Arrays.copyOf(array, numElementos);
        Arrays.sort(arrayOrdenado); // Ordenamos el array
        return arrayOrdenado; // Devolvemos el array ordenado
    }

    // Función para insertar los datos de una asignatura, alumno y nota
    private static void insertarDatos(Scanner sc) {
        // Introducir nombre de la asignatura
        System.out.println("Introduce Nombre ASIGNATURA:");
        String asignatura = sc.next();
        if (comprobarAsignatura(asignatura)) { // Comprobamos si la asignatura ya existe
            nombreasignaturas[numasignatura] = asignatura;
            numasignatura++;
        }

        // Introducir nombre del alumno
        System.out.println("Introduce Nombre ALUMNO:");
        String alumno = sc.next();
        if (comprobarAlumno(alumno)) { // Comprobamos si el alumno ya existe
            nombrealumnos[numalumno] = alumno;
            numalumno++;
        }

        // Introducir la nota del alumno
        System.out.println("Introduce la nota del ALUMNO:");
        float nota = sc.nextFloat();
        notas[indiceAsignatura(asignatura)][indiceAlumno(alumno)] = nota; // Guardamos la nota en la matriz
    }

    // Función para obtener el índice de una asignatura en el array de asignaturas
    private static int indiceAsignatura(String asignatura) {
        int indice = 0;
        while (indice < numasignatura && !asignatura.equals(nombreasignaturas[indice])) {
            indice++;
        }
        return indice;
    }

    // Función para obtener el índice de un alumno en el array de alumnos
    private static int indiceAlumno(String alumno) {
        int indice = 0;
        while (indice < numalumno && !alumno.equals(nombrealumnos[indice])) {
            indice++;
        }
        return indice;
    }

    // Función para comprobar si un alumno ya existe en el array de alumnos
    private static boolean comprobarAlumno(String alumno) {
        for (String c : nombrealumnos) {
            if (alumno.equals(c)) {
                return false; // Si el alumno ya existe, devolver false
            }
        }
        return true; // Si no existe, devolver true
    }

    // Función para comprobar si una asignatura ya existe en el array de asignaturas
    private static boolean comprobarAsignatura(String asignatura) {
        for (String c : nombreasignaturas) {
            if (asignatura.equals(c)) {
                return false; // Si la asignatura ya existe, devolver false
            }
        }
        return true; // Si no existe, devolver true
    }

    // Función para inicializar la matriz de notas con valores por defecto (-1)
    private static void inicializarDatos() {
        for (int i = 0; i < MAXASIGNATURA; i++) {
            for (int j = 0; j < MAXALUMNO; j++) {
                notas[i][j] = -1; // Inicializamos todas las notas a -1 para indicar que no hay datos
            }
        }
    }
}
