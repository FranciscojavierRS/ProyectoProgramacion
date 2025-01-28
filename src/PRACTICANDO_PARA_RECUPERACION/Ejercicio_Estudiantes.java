package PRACTICANDO_PARA_RECUPERACION;

import java.util.Scanner;

public class Ejercicio_Estudiantes {
    // Constantes
    private static final int MAX_ESTUDIANTES = 20;  // Número máximo de estudiantes
    private static final int MAX_EVALUACIONES = 4;  // Número máximo de evaluaciones
    private static final int NOTA_NO_INGRESADA = -1; // Valor que indica que no se ha ingresado una nota
    
    // Matriz que almacena las notas de los estudiantes para las evaluaciones
    private static int[][] notas = new int[MAX_ESTUDIANTES][MAX_EVALUACIONES];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inicializarNotas(); // Inicializa la matriz de notas con -1 para indicar que no se han ingresado

        int opcion = 0;
        
        // Bucle principal del menú
        while (opcion != 6) {
            mostrarMenu(); // Muestra las opciones del menú al usuario
            opcion = sc.nextInt(); // Leer la opción seleccionada por el usuario
            
            switch (opcion) {
                case 1:
                    introducirNota(sc); // Opción para introducir una nota
                    break;
                case 2:
                    mostrarNotas(); // Opción para mostrar todas las notas ingresadas
                    break;
                case 3:
                    mostrarPromedioEstudiante(sc); // Opción para mostrar el promedio de un estudiante
                    break;
                case 4:
                    mostrarEstudianteMayorPromedio(); // Opción para mostrar el estudiante con el mayor promedio
                    break;
                case 5:
                    mostrarEvaluacionPromedioMasBajo(); // Opción para mostrar la evaluación con el promedio más bajo
                    break;
                case 6:
                    System.out.println("Saliendo del programa..."); // Finaliza el programa
                    break;
                default:
                    System.out.println("Opción no válida."); // Mensaje en caso de opción incorrecta
            }
        }
        
        sc.close(); // Cierra el Scanner al finalizar
    }

    // Función que muestra el menú de opciones
    private static void mostrarMenu() {
        System.out.println("\n1- Introducir las notas de un estudiante para una evaluación");
        System.out.println("2- Mostrar las notas de todos los estudiantes");
        System.out.println("3- Calcular el promedio de un estudiante en todas las evaluaciones");
        System.out.println("4- Mostrar el estudiante con el mayor promedio en el curso");
        System.out.println("5- Mostrar la evaluación con el promedio más bajo de la clase");
        System.out.println("6- Salir del programa");
        System.out.print("Opción: "); // Espera la selección del usuario
    }

    // Inicializa la matriz de notas con -1 para indicar que no se han ingresado notas
    private static void inicializarNotas() {
        for (int i = 0; i < MAX_ESTUDIANTES; i++) {
            for (int j = 0; j < MAX_EVALUACIONES; j++) {
                notas[i][j] = NOTA_NO_INGRESADA; // Inicializa todas las posiciones de la matriz con -1
            }
        }
    }

    // Permite introducir una nota para un estudiante en una evaluación
    private static void introducirNota(Scanner sc) {
        System.out.println("Introduce el número del estudiante (1-20):");
        int estudiante = sc.nextInt() - 1;  // Convertimos a índice (0-19)
        
        System.out.println("Introduce el número de la evaluación (1-4):");
        int evaluacion = sc.nextInt() - 1;  // Convertimos a índice (0-3)
        
        System.out.println("Introduce la nota obtenida (0-10):");
        int nota = sc.nextInt();
        
        // Validar que el número del estudiante, evaluación y nota estén en el rango permitido
        if (estudiante >= 0 && estudiante < MAX_ESTUDIANTES && evaluacion >= 0 && evaluacion < MAX_EVALUACIONES && nota >= 0 && nota <= 10) {
            notas[estudiante][evaluacion] = nota;  // Almacenar la nota en la matriz
            System.out.println("Nota ingresada correctamente.");
        } else {
            System.out.println("Datos inválidos. Inténtalo de nuevo."); // Mensaje en caso de datos incorrectos
        }
    }

    // Muestra todas las notas de los estudiantes en formato tabular
    private static void mostrarNotas() {
        System.out.println("Notas de los estudiantes:");
        for (int i = 0; i < MAX_ESTUDIANTES; i++) {
            System.out.print("Estudiante " + (i + 1) + ": ");
            // Iterar sobre las evaluaciones del estudiante
            for (int j = 0; j < MAX_EVALUACIONES; j++) {
                if (notas[i][j] == NOTA_NO_INGRESADA) {
                    System.out.print("-1 ");  // Mostrar -1 si no se ha ingresado la nota
                } else {
                    System.out.print(notas[i][j] + " "); // Mostrar la nota
                }
            }
            System.out.println();  // Salto de línea entre estudiantes
        }
    }

    // Calcula y muestra el promedio de un estudiante en todas las evaluaciones
    private static void mostrarPromedioEstudiante(Scanner sc) {
        System.out.println("Introduce el número del estudiante (1-20):");
        int estudiante = sc.nextInt() - 1;  // Convertimos a índice (0-19)

        // Validar si el número de estudiante es válido
        if (estudiante >= 0 && estudiante < MAX_ESTUDIANTES) {
            int sumaNotas = 0;
            int numEvaluaciones = 0;

            // Sumar las notas ingresadas del estudiante
            for (int j = 0; j < MAX_EVALUACIONES; j++) {
                if (notas[estudiante][j] != NOTA_NO_INGRESADA) {
                    sumaNotas += notas[estudiante][j];
                    numEvaluaciones++;
                }
            }

            // Si hay notas ingresadas, calculamos el promedio
            if (numEvaluaciones > 0) {
                double promedio = (double) sumaNotas / numEvaluaciones;
                System.out.println("El promedio del estudiante " + (estudiante + 1) + " es: " + promedio);
            } else {
                System.out.println("El estudiante no tiene notas ingresadas.");
            }
        } else {
            System.out.println("Número de estudiante inválido."); // Mensaje si el estudiante no es válido
        }
    }

    // Muestra el estudiante con el mayor promedio en todas las evaluaciones
    private static void mostrarEstudianteMayorPromedio() {
        int estudianteMayorPromedio = -1;  // Índice del estudiante con mayor promedio
        double mayorPromedio = -1; // Valor del mayor promedio

        // Iterar sobre todos los estudiantes para calcular sus promedios
        for (int i = 0; i < MAX_ESTUDIANTES; i++) {
            int sumaNotas = 0;
            int numEvaluaciones = 0;

            // Sumar las notas del estudiante actual
            for (int j = 0; j < MAX_EVALUACIONES; j++) {
                if (notas[i][j] != NOTA_NO_INGRESADA) {
                    sumaNotas += notas[i][j];
                    numEvaluaciones++;
                }
            }

            // Si tiene evaluaciones, calcular el promedio y compararlo con el mayor promedio hasta ahora
            if (numEvaluaciones > 0) {
                double promedio = (double) sumaNotas / numEvaluaciones;
                if (promedio > mayorPromedio) {
                    mayorPromedio = promedio;
                    estudianteMayorPromedio = i;
                }
            }
        }

        // Mostrar el estudiante con mayor promedio
        if (estudianteMayorPromedio != -1) {
            System.out.println("El estudiante con el mayor promedio es el estudiante " + (estudianteMayorPromedio + 1) + " con un promedio de " + mayorPromedio);
        } else {
            System.out.println("No hay notas ingresadas.");
        }
    }

    // Muestra la evaluación con el promedio más bajo de la clase
    private static void mostrarEvaluacionPromedioMasBajo() {
        int evaluacionPromedioMasBajo = -1;  // Índice de la evaluación con el promedio más bajo
        double menorPromedio = Double.MAX_VALUE; // Valor del menor promedio

        // Iterar sobre las evaluaciones para calcular su promedio
        for (int j = 0; j < MAX_EVALUACIONES; j++) {
            int sumaNotas = 0;
            int numEstudiantes = 0;

            // Sumar las notas de los estudiantes en la evaluación actual
            for (int i = 0; i < MAX_ESTUDIANTES; i++) {
                if (notas[i][j] != NOTA_NO_INGRESADA) {
                    sumaNotas += notas[i][j];
                    numEstudiantes++;
                }
            }

            // Si hay estudiantes en la evaluación, calcular el promedio
            if (numEstudiantes > 0) {
                double promedio = (double) sumaNotas / numEstudiantes;
                if (promedio < menorPromedio) {
                    menorPromedio = promedio;
                    evaluacionPromedioMasBajo = j;
                }
            }
        }

        // Mostrar la evaluación con el promedio más bajo
        if (evaluacionPromedioMasBajo != -1) {
            System.out.println("La evaluación con el promedio más bajo es la evaluación " + (evaluacionPromedioMasBajo + 1) + " con un promedio de " + menorPromedio);
        } else {
            System.out.println("No hay notas ingresadas.");
        }
    }
}
