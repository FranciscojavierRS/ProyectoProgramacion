package EjerciciosArrays1;

import java.util.Scanner;

public class Ej2_OrdenInverso {
	
	// Escribir una aplicación que solicite al usuario cuántos números desea introducir. A
	// continuación, se introducirá por teclado esa cantidad de números enteros, y por último, los
	// mostrará en el orden inverso al introducido.


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        
        

        //  Pedir cuántos números desea introducir
        System.out.print("¿Cuántos números deseas introducir?: ");
        int cantidad = sc.nextInt();

        //  Crear un array con esa cantidad
        int[] numeros = new int[cantidad];

        //  Pedir los números al usuario
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        //  Mostrar los números en orden inverso
        System.out.println("\nLos números en orden inverso son:");
        for (int i = cantidad - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }

        sc.close();
    }
}
