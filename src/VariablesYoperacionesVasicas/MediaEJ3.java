package VariablesYoperacionesVasicas;

import java.util.Scanner;

public class MediaEJ3 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		
		int num1;
		int num2;
		
		System.out.println("Dame un numero");
		 num1 = sc.nextInt();
		 System.out.println("Dame otro numero");
		 num2 = sc.nextInt();
		 double media = num1 + (double) num2 / 2;
		System.out.println("La media aritmetica de los numeros es"+media);
		
		

		
		
		
		sc.close();
	}

}
