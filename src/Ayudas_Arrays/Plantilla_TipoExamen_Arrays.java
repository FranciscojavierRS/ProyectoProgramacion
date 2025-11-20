package Ayudas_Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class Plantilla_TipoExamen_Arrays {

    // Contadores de filas y columnas "activas" (datos introducidos)
    static int numFilas = 0;
    static int numColumnas = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Definir tamaño máximo de la tabla según examen
        float[][] datos = new float[20][20]; 
        inicializarTabla(datos);

        // Arrays para nombres de filas y columnas
        String[] nombresFilas = new String[20];    
        String[] nombresColumnas = new String[20]; 

        while (opcion != 6) {
            System.out.println("1- Introducir dato");
            System.out.println("2- Mostrar todos los datos");
            System.out.println("3- Buscar fila con mayor suma");
            System.out.println("4- Buscar columna con mayor suma");
            System.out.println("5- Mostrar listado alfabético de filas");
            System.out.println("6- Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Introducir un dato en la tabla
                    System.out.println("Introduce nombre fila:");
                    String fila = sc.next();
                    int indiceFila = getIndice(nombresFilas, fila, numFilas);
                    if (indiceFila == -1) break; // superó límite del array
                    if (indiceFila == numFilas) numFilas++;

                    System.out.println("Introduce nombre columna:");
                    String columna = sc.next();
                    int indiceColumna = getIndice(nombresColumnas, columna, numColumnas);
                    if (indiceColumna == -1) break; // superó límite del array
                    if (indiceColumna == numColumnas) numColumnas++;

                    System.out.println("Introduce valor:");
                    datos[indiceFila][indiceColumna] = sc.nextFloat();
                    break;

                case 2:
                    // Mostrar todos los datos de la tabla
                    mostrar(datos, numFilas, numColumnas, nombresFilas, nombresColumnas);
                    break;

                case 3:
                    // Buscar fila con mayor suma
                    int filaMaxIndex = filaMax(datos, numFilas, numColumnas);
                    System.out.println("Fila con mayor suma: " + nombresFilas[filaMaxIndex]);
                    break;

                case 4:
                    // Buscar columna con mayor suma
                    int colMaxIndex = columnaMax(datos, numColumnas, numFilas);
                    System.out.println("Columna con mayor suma: " + nombresColumnas[colMaxIndex]);
                    break;

                case 5:
                    // Mostrar filas ordenadas alfabéticamente
                    String[] copiaFilas = Arrays.copyOf(nombresFilas, numFilas);
                    Arrays.sort(copiaFilas);
                    System.out.println("Listado alfabético filas:");
                    for (String s : copiaFilas) System.out.println(s);
                    break;

                case 6:
                    System.out.println("Fin del examen.");
                    break;
            }
            System.out.println();
        }

        sc.close();
    }

    // ---------------- Métodos Universales ----------------

    // Inicializa la tabla con -1 (indicando "sin valor")
    static void inicializarTabla(float[][] tabla) {
        for (int i = 0; i < tabla.length; i++)
            for (int j = 0; j < tabla[0].length; j++)
                tabla[i][j] = -1;
    }

    // Devuelve índice de clave en array; si no existe, la añade
    // Retorna -1 si se supera el límite del array
    static int getIndice(String[] array, String clave, int contador) {
        for (int i = 0; i < contador; i++)
            if (array[i].equals(clave)) return i;

        if (contador < array.length) {
            array[contador] = clave;
            return contador;
        } else {
            System.out.println("ERROR: se ha superado el límite del array.");
            return -1;
        }
    }

    // Devuelve el índice de la columna con mayor suma
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

    // Devuelve el índice de la fila con mayor suma
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

    // Muestra la tabla con nombres de filas y columnas
    static void mostrar(float[][] tabla, int filas, int columnas, String[] nombresFilas, String[] nombresColumnas) {
        for (int i = 0; i < filas; i++) {
            System.out.println("Fila " + i + " (" + nombresFilas[i] + "):");
            for (int j = 0; j < columnas; j++)
                if (tabla[i][j] != -1) System.out.println("   -> " + nombresColumnas[j] + ": " + tabla[i][j]);
        }
    }
}
