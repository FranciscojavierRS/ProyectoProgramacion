package b1;

import java.util.Scanner;

public class Ej3_Media {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("Introduce un numero");

	int num1= sc.nextInt();
	
	System.out.println("Introduce otro numero");

	int num2= sc.nextInt();
	double media= (num1+num2)/2;
	System.out.println("La media es "+media);
	sc.close();
	}

}
