package b4;

import java.util.Scanner;

public class Ej8_CalculoFactorial {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un numero");
		int numero=sc.nextInt();
		int resultado=1;
		while(numero>0) {
			resultado=resultado*numero;
			numero--;
		}
		System.out.println("El factorial es " +resultado);
		
		sc.close();
	}

}
