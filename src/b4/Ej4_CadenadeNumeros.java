package b4;

import java.util.Scanner;

public class Ej4_CadenadeNumeros {

    public static void main(String[] args) {
        // Crear un Scanner para capturar el número n
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario que introduzca el número n
        System.out.print("Introduce un número n: ");
        int n = sc.nextInt();

        // Inicializar un contador para comenzar desde 1
        int i = 1;

        // Usar un bucle while para imprimir los números desde 1 hasta n
        while (i <= n) {
            System.out.println(i);
            i++;  // Incrementar el contador
        }

        // Cerrar el objeto Scanner
        sc.close();
    }
}
