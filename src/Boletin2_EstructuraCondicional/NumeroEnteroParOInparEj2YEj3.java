package Boletin2_EstructuraCondicional;

import java.util.Scanner;

public class NumeroEnteroParOInparEj2YEj3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Intoduce un numero entero");
		int numero = sc.nextInt();
		int par;

		if (numero % 2 == 0) {
			par = 1;

		} else {
			par = 2;
		}
		
		
		System.out.println(par);
		System.out.println("Dime otro numero");
		int numero2 = sc.nextInt();
		
		int par2 = (numero2 %2 == 0) ? 1:0;
		System.out.println(par2);

		sc.close();

	}

}
