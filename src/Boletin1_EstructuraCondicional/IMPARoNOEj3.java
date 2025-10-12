package Boletin1_EstructuraCondicional;

import java.util.Scanner;

public class IMPARoNOEj3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numero;
		
		 System.out.print("Introduce un número: ");
			numero = sc.nextInt();


	        if (numero % 2 != 0) {
	            System.out.println("El número " + numero + " es impar.");
	        } else {
	            System.out.println("El número " + numero + " no es impar.");
	        }

	        sc.close();
	    }
	}