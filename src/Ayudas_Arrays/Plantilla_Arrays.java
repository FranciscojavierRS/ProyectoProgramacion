package Ayudas_Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class Plantilla_Arrays {

    // ------------------------------
    // PLANTILLA UNIVERSAL EXÁMEN ARRAYS
    // ------------------------------

    // Contadores de filas y columnas: representan los elementos activos en la matriz
    static int numFilas = 0;
    static int numColumnas = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Tamaño máximo de la matriz y arrays de nombres
        float[][] tabla = new float[20][20];      // matriz de datos, ajustar según examen
        String[] nombresFilas = new String[20];   // nombres de filas (ej: alumnos, ciudades...)
        String[] nombresColumnas = new String[20];// nombres de columnas (ej: notas, meses...)

        // Inicializamos la matriz con -1 (indica "sin dato")
        inicializarTabla(tabla);

        int opcion = 0;

        while (opcion != 6) {
            // Menú de opciones para el examen
            System.out.println("1 - Introducir dato");
            System.out.println("2 - Mostrar todos los datos");
            System.out.println("3 - Buscar fila con mayor suma");
            System.out.println("4 - Buscar columna con mayor suma");
            System.out.println("5 - Listado alfabético de filas");
            System.out.println("6 - Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: // Introducir dato en la matriz
                    System.out.println("Introduce nombre fila:");
                    String fila = sc.next();
                    int indiceFila = getIndice(nombresFilas, fila, numFilas);
                    if (indiceFila == numFilas) numFilas++; // si es nueva fila, incrementamos contador

                    System.out.println("Introduce nombre columna:");
                    String columna = sc.next();
                    int indiceColumna = getIndice(nombresColumnas, columna, numColumnas);
                    if (indiceColumna == numColumnas) numColumnas++; // si es nueva columna, incrementamos contador

                    System.out.println("Introduce valor:");
                    tabla[indiceFila][indiceColumna] = sc.nextFloat();
                    break;

                case 2: // Mostrar todos los datos
                    mostrar(tabla, numFilas, numColumnas, nombresFilas, nombresColumnas);
                    break;

                case 3: // Fila con mayor suma
                    int filaMaxIndex = filaMax(tabla, numFilas, numColumnas);
                    System.out.println("Fila con mayor suma: " + nombresFilas[filaMaxIndex]);
                    break;

                case 4: // Columna con mayor suma
                    int colMaxIndex = columnaMax(tabla, numColumnas, numFilas);
                    System.out.println("Columna con mayor suma: " + nombresColumnas[colMaxIndex]);
                    break;

                case 5: // Listado alfabético de filas
                    String[] copiaFilas = Arrays.copyOf(nombresFilas, numFilas);
                    Arrays.sort(copiaFilas);
                    System.out.println("Listado alfabético de filas:");
                    for (String s : copiaFilas) System.out.println(s);
                    break;

                case 6:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println(); // línea en blanco para mejor legibilidad
        }

        sc.close();
    }

    // ------------------------------
    // MÉTODOS UNIVERSALES
    // ------------------------------

    // Inicializar tabla a -1
    static void inicializarTabla(float[][] tabla) {
        for (int i = 0; i < tabla.length; i++)
            for (int j = 0; j < tabla[0].length; j++)
                tabla[i][j] = -1; // -1 indica "sin dato"
    }

    // Obtener índice de un array de Strings, creando si no existe
    static int getIndice(String[] array, String clave, int contador) {
        for (int i = 0; i < contador; i++)
            if (array[i].equals(clave)) return i; // clave ya existe
        array[contador] = clave; // clave nueva → guardarla
        return contador;          // devolver índice donde se guardó
    }

    // Obtener índice de un array de int dado un valor (solo busca)
    static int getIndice(int[] array, int valor, int contador) {
        for (int i = 0; i < contador; i++)
            if (array[i] == valor) return i;
        return -1; // no encontrado
    }

    // Calcular índice de la columna con mayor suma
    static int columnaMax(float[][] tabla, int columnas, int filas) {
        float max = -1;
        int indice = 0;
        for (int j = 0; j < columnas; j++) {
            float suma = 0;
            for (int i = 0; i < filas; i++)
                if (tabla[i][j] != -1) suma += tabla[i][j];
            if (suma > max) { max = suma; indice = j; }
        }
        return indice;
    }

    // Calcular índice de la fila con mayor suma
    static int filaMax(float[][] tabla, int filas, int columnas) {
        float max = -1;
        int indice = 0;
        for (int i = 0; i < filas; i++) {
            float suma = 0;
            for (int j = 0; j < columnas; j++)
                if (tabla[i][j] != -1) suma += tabla[i][j];
            if (suma > max) { max = suma; indice = i; }
        }
        return indice;
    }

    // Mostrar matriz de forma legible
    static void mostrar(float[][] tabla, int filas, int columnas, String[] nombresFilas, String[] nombresColumnas) {
        for (int i = 0; i < filas; i++) {
            System.out.println("Fila " + i + " (" + nombresFilas[i] + "):");
            for (int j = 0; j < columnas; j++)
                if (tabla[i][j] != -1) // solo mostrar datos existentes
                    System.out.println("   -> " + nombresColumnas[j] + ": " + tabla[i][j]);
        }
    }
}
