package b2;

import java.util.Scanner;

public class Ej1_positivoElse {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un numero");

			int num1= sc.nextInt();
			if (num1 > 0) 
			System.out.println("valor positivo");
			else
				System.out.println("valor negativo");
				
			System.out.println("Introduce otro numero");

			int num2= sc.nextInt();
			
			if (num2 > 0) 
				System.out.println("valor positivo");
				else
					System.out.println("valor negativo");
			
			sc.close();
			}

}
