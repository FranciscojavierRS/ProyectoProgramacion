package Tablas1;

import java.util.Arrays;
import java.util.Scanner;

public class OrdenInversoEj2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuantos numeros quieres introducir?");
		
		int cantidad= sc.nextInt();
		
		System.out.println("Introduce los numeros");
		
		
		
		int [] numerosDecimales= new int[cantidad]; 
		
		for (int i= 0; i<cantidad; i++) {
			int numero = sc.nextInt();
			numerosDecimales [i]=numero;
			
		}
		
		for (int i= cantidad -1; i>= 0; i--) {
		System.out.println(numerosDecimales[i]);	
		}
		
		sc.close();


	}

}
