package EjerciciosArrays1;

import java.util.Scanner;

public class Ej1_NumerosDecimales {
	
	// Diseñar un programa que solicite al usuario 5 números decimales. A
	// continuación, debe mostrar los números en el mismo orden en que se han introducido.

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        float [] numerosDecimales = new float[5];  
        
        System.out.println("Introduce 5 números decimales:");

        for (int i = 0; i < numerosDecimales.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numerosDecimales[i] = sc.nextFloat();
        }

        System.out.println("\nHas introducido los siguientes números:");

        for (int i = 0; i < numerosDecimales.length; i++) {
            System.out.println(numerosDecimales[i]);
        }

        sc.close();
    }
}
