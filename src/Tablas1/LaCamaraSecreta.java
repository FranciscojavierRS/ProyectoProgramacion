package Tablas1;

import java.util.Arrays;
import java.util.Scanner;

public class LaCamaraSecreta {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("especifica el número de dígitos de la clave secreta");

		int cantidad = sc.nextInt();
		
		int[] clave = new int[cantidad];
		
		for (int i= 0; i<cantidad; i++) {
			clave [i]=(int)(Math.random() * ((5 - 1) + 1)) + 1;
		}

		System.out.println(Arrays.toString(clave));// borrar 
		
		System.out.println("Intente acertarla");
		
		 
		
		boolean acertado =false;
		
		while (!acertado) {
			String claveUsuario = sc.next();
			for (int i=0; i<claveUsuario.length(); i++) {
				
				int digitoClave = clave[i];
				int digitoUsuario = Integer.parseInt(claveUsuario.substring(i, i+1));
				if (digitoClave==digitoUsuario) {
					acertado = true;
					System.out.println(digitoUsuario + " es igual");
				}else if(digitoUsuario > digitoClave) {
					System.out.println(digitoUsuario + " es mayor");
					acertado = false;
				}else {
					System.out.println(digitoUsuario + " es menor");
					acertado = false;
				}
				
				
			}
			if(!acertado) {
				System.out.println("Intentelo de nuevo");
			} else {
				System.out.println("Correcto");
			}
		}
		
		
		
		sc.close();
	}

}
