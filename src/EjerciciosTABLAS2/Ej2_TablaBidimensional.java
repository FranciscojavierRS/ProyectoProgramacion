package EjerciciosTABLAS2;

public class Ej2_TablaBidimensional {

    public static void main(String[] args) {
        // Crear una tabla bidimensional de tamaño 5x5
        int[][] tabla = new int[5][5];

        // Rellenar la tabla de forma que en la posición [n, m] contenga n + m
        for (int n = 0; n < 5; n++) {
            for (int m = 0; m < 5; m++) {
                tabla[n][m] = n + m;
            }
        }

        // Mostrar el contenido de la tabla
        System.out.println("Contenido de la tabla 5x5 (n + m):");
        for (int n = 0; n < 5; n++) {
            for (int m = 0; m < 5; m++) {
                System.out.print(tabla[n][m] + "\t"); // Mostrar cada valor con tabulación
            }
            System.out.println(); // Nueva línea al final de cada fila
        }
    }
}

