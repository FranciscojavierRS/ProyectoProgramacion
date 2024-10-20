package b4;

import java.util.Scanner;

public class Ej14_TrianguloRectanguloFOR {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int tamano=0; //Creamos variable
		
		while(tamano <=0) {
			System.out.println("Introduce el tamaño del triangulo");
			tamano=sc.nextInt();
		
		}
		String cadena;
		for (int i=tamano;i>=1;i--) { // hacemos un for que va restando el numero introducido (*) y el siguiente lo que hace 
									// es la posición de la misma
			cadena = "";
			for(int j = 0;j<i;j++) {
				cadena = cadena + "*";
			}
			System.out.println(cadena);
		}
		sc.close();
	}

}
