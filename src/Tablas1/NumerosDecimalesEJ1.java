package Tablas1;

import java.util.Arrays;
import java.util.Scanner;

public class NumerosDecimalesEJ1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce 5 numeros decimales");
		
		float [] numerosDecimales= new float[5]; 
		
		for (int i= 0; i<numerosDecimales.length; i++) {
			float numero = sc.nextFloat();
			numerosDecimales [i]=numero;
			
		}
		
		System.out.println(Arrays.toString(numerosDecimales));
		
		sc.close();

	}

}
