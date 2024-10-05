package b2;

import java.util.Scanner;

public class Ej6_TiempoGravedad {

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		
		final float GRAVEDAD = 9.8f;
		float velocidad = 0;
		
		System.out.println ("Dime el tiempo");
		float tiempo = sc.nextFloat();
		
		if (tiempo>0) {	
			velocidad=GRAVEDAD*tiempo;
			System.out.println("La velocidad es: " + velocidad);
			
			
		}else {
			System.out.println("Tiempo incorrecto");
	
		}
	}
}


