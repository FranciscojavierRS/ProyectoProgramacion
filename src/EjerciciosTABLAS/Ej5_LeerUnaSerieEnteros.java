package EjerciciosTABLAS;

import java.util.Arrays;
import java.util.Scanner;

public class Ej5_LeerUnaSerieEnteros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Definir las dos tablas de enteros
        int[] tabla1 = new int[6];
        int[] tabla2 = new int[6];

        // Leer la primera serie de 6 enteros
        System.out.println("Introduce 6 números enteros para la primera tabla:");
        for (int i = 0; i < 6; i++) {
            tabla1[i] = sc.nextInt();
        }

        // Leer la segunda serie de 6 enteros
        System.out.println("Introduce 6 números enteros para la segunda tabla:");
        for (int i = 0; i < 6; i++) {
            tabla2[i] = sc.nextInt();
        }

        // Ordenar ambas tablas
        Arrays.sort(tabla1);
        Arrays.sort(tabla2);

        // Fusionar ambas tablas en una tercera tabla de 12 elementos
        int[] tablaFusionada = new int[12];
        int i = 0, j = 0, k = 0;

        // Fusionar las tablas en orden
        while (i < 6 && j < 6) {
            if (tabla1[i] <= tabla2[j]) {
                tablaFusionada[k++] = tabla1[i++];
            } else {
                tablaFusionada[k++] = tabla2[j++];
            }
        }

        // Copiar los elementos restantes (si los hay) de tabla1
        while (i < 6) {
            tablaFusionada[k++] = tabla1[i++];
        }

        // Copiar los elementos restantes (si los hay) de tabla2
        while (j < 6) {
            tablaFusionada[k++] = tabla2[j++];
        }

        // Mostrar la tabla fusionada
        System.out.println("Tabla fusionada y ordenada:");
        for (int num : tablaFusionada) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
