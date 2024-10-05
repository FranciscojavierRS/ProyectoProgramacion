package b1;

import java.util.Scanner;

public class Ej6_Decimales {
	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("Introduce un numero");

	double num1= sc.nextDouble();
	
	System.out.println("Introduce otro numero");

	double num2= sc.nextDouble();
	
	System.out.println("Introduce otro numero");

	double num3= sc.nextDouble();
	System.out.println("Introduce otro numero");

	double num4= sc.nextDouble();
	int media= (int) ((num1+num2+num3+num4)/4);
	System.out.println("La media es "+media);
	sc.close();
	}
}
