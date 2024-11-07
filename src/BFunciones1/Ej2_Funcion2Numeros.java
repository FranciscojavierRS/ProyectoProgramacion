package BFunciones1;

import java.util.Scanner;

public class Ej2_Funcion2Numeros {

	public static void main(String[] args) {
	
    Scanner scanner = new Scanner(System.in);

	
	System.out.println("Pon dos numeros enteros");
	
	int num1=scanner.nextInt();
	int num2=scanner.nextInt();
	System.out.println("");
	entero(num1,num2);
	
	}

	private static void entero(int num1, int num2) {
		for (int i=num1;i<=num2;i++) {
			System.out.println(i);
		}
	}

	
		
	}

