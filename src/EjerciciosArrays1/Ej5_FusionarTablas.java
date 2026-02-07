package EjerciciosArrays1;

import java.util.Arrays;
import java.util.Scanner;

public class Ej5_FusionarTablas {
	
	// Leer una serie de 6 enteros que se almacenarán en una tabla que hay que
	// ordenar y mostrar. Hacer lo mismo con otra serie de 6 enteros. A continuación, fusionar las dos
	// tablas en una tercera, de forma que los 12 números sigan ordenados. Fusionar significa copiar
	// en el orden correcto para que los datos resultantes continúen ordenados sin necesidad de
	// volver a realizar una ordenación
	

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] tabla1 = new int[6];
        int[] tabla2 = new int[6];

        //  Leer los números de la primera tabla
        System.out.println("Introduce 6 números enteros para la primera tabla:");
        for (int i = 0; i < tabla1.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            tabla1[i] = sc.nextInt();
        }

        //  Leer los números de la segunda tabla
        System.out.println("\nIntroduce 6 números enteros para la segunda tabla:");
        for (int i = 0; i < tabla2.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            tabla2[i] = sc.nextInt();
        }

        //  Ordenar ambas tablas
        Arrays.sort(tabla1);
        Arrays.sort(tabla2);

        // Mostrar ambas tablas ordenadas
        System.out.println("\nPrimera tabla ordenada: " + Arrays.toString(tabla1));
        System.out.println("Segunda tabla ordenada: " + Arrays.toString(tabla2));

        //  Fusionar ambas tablas en una tercera manteniendo el orden
        int[] tablaFusionada = new int[12];
        int i = 0, j = 0, k = 0;

        // Recorrer ambas tablas y fusionar ordenadamente
        while (i < tabla1.length && j < tabla2.length) {
            if (tabla1[i] < tabla2[j]) {
                tablaFusionada[k] = tabla1[i];
                i++;
            } else {
                tablaFusionada[k] = tabla2[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes (si quedan)
        while (i < tabla1.length) {
            tablaFusionada[k++] = tabla1[i++];
        }

        while (j < tabla2.length) {
            tablaFusionada[k++] = tabla2[j++];
        }

        //  Mostrar la tabla fusionada
        System.out.println("\nTabla fusionada (ordenada): " + Arrays.toString(tablaFusionada));

        sc.close();
    }
}
