package b1;

import java.util.Scanner;

public class Ej7_Area_triangulo {

	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Introduce la base");

				double num1= sc.nextDouble();
				
				System.out.println("Introduce la altura");

				double num2= sc.nextDouble();
				
				
				double area= num1*num2/2;
				System.out.println("El area es "+area);
				sc.close();
	}

}
