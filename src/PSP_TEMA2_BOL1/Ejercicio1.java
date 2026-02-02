package PSP_TEMA2_BOL1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

		
		Hilo_Ejercicio1 hilo1 = new Hilo_Ejercicio1("SERVICIOS");
		Hilo_Ejercicio1 hilo2 = new Hilo_Ejercicio1("PROCESOS");
		
		Runable_Ejercicio1v3 hiloRunnable = new Runable_Ejercicio1v3("Se esta ejecutando");
		
		hilo1.setPriority(10);
		hilo2.setPriority(9);

		
		hilo1.start();
		hilo2.start();
		
		Scanner sc = new Scanner(System.in);
		sc.next();
		sc.close();
		hilo1.parar();
		hilo2.parar();
		hiloRunnable.parar();

	}

}
