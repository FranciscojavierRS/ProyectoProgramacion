package b2;

import java.util.Scanner;

public class Ej5_3numerosMayor {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un numero");
		double num1= sc.nextDouble();
		
		System.out.println("Introduce un numero");
		double num2= sc.nextDouble();
		
		System.out.println("Introduce un numero");
		double num3= sc.nextDouble();
	
		if (num1>num2) {
			if (num1>num3) {
				System.out.println("El numero 1 es el mayor");}
			else {
				System.out.println("el tercero es mayor");
			}
		}else {
				if (num2 >num3) {
					System.out.println("el numero 2 es el mayor");
				}
				else {
					System.out.println("el numero 3 es el mayor");

				}
				}
			
		
	
	
	}
}
