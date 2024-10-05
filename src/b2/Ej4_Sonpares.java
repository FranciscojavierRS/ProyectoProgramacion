package b2;

import java.util.Scanner;

public class Ej4_Sonpares {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int contador=0;
		System.out.println("Introduce un numero");

			int num1= sc.nextInt();
			if (num1 % 2 !=0) 
			System.out.println("valor impar");
			else {
				System.out.println("valor par");
				contador= contador+1;
			}
				
			System.out.println("Introduce un numero");

				int num2= sc.nextInt();
				if (num2 % 2 !=0) 
				System.out.println("valor impar");
				else {
					System.out.println("valor par");
				
			contador= contador+1; }
				System.out.println(contador+" son pares");
	
	}

}
