package EjerciciosTABLAS;

import java.util.Arrays;
import java.util.Scanner;

public class Ej6_El5PeroSinRepetidos {

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

        // Fusionar ambas tablas en una tercera tabla eliminando duplicados
        int[] tablaFusionada = new int[12]; // Puede haber hasta 12 elementos
        int i = 0, j = 0, k = 0;

        // Fusionar las tablas en orden sin duplicados
        while (i < 6 && j < 6) {
            if (tabla1[i] < tabla2[j]) {
                if (k == 0 || tablaFusionada[k - 1] != tabla1[i]) { // Evitar duplicados
                    tablaFusionada[k++] = tabla1[i];
                }
                i++;
            } else if (tabla1[i] > tabla2[j]) {
                if (k == 0 || tablaFusionada[k - 1] != tabla2[j]) { // Evitar duplicados
                    tablaFusionada[k++] = tabla2[j];
                }
                j++;
            } else { // Son iguales, añadir solo uno y avanzar ambos índices
                if (k == 0 || tablaFusionada[k - 1] != tabla1[i]) { // Evitar duplicados
                    tablaFusionada[k++] = tabla1[i];
                }
                i++;
                j++;
            }
        }

        // Copiar los elementos restantes (si los hay) de tabla1 sin duplicados
        while (i < 6) {
            if (k == 0 || tablaFusionada[k - 1] != tabla1[i]) { // Evitar duplicados
                tablaFusionada[k++] = tabla1[i];
            }
            i++;
        }

        // Copiar los elementos restantes (si los hay) de tabla2 sin duplicados
        while (j < 6) {
            if (k == 0 || tablaFusionada[k - 1] != tabla2[j]) { // Evitar duplicados
                tablaFusionada[k++] = tabla2[j];
            }
            j++;
        }

        // Mostrar la tabla fusionada sin repetidos
        System.out.println("Tabla fusionada y ordenada sin repetidos:");
        for (int l = 0; l < k; l++) {
            System.out.print(tablaFusionada[l] + " ");
        }

        sc.close();
    }
}

