package b1;

import java.util.Scanner;

public class Ej4_Distancia {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce una distancia en millas");
		int millas= sc.nextInt();
		final int metro= 1609;
		System.out.println(millas+" millas son :" + millas*metro + "metros");
		sc.close();
	}

}
