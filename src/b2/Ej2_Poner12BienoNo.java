package b2;

import java.util.Scanner;

public class Ej2_Poner12BienoNo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		System.out.println("Escribe el numero 12");
		int num1= sc.nextInt();
		if (num1 == 12) 
		System.out.println("Correctoo");
		else
			System.out.println("Nooooooo pon 12");
		sc.close();
	}
	
}
