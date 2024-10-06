package b4;

import java.util.Scanner;

public class Ej10_TablaMultiplicar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		while(numero<=0 || numero>10) {
			System.out.println("Introduce un numero entre el 1 y el 10");
			numero=sc.nextInt();
		}
		
		for(int i=1; i<=10; i++) {
			System.out.println(numero + "x"+i+"="+numero*i);
		}
		
		sc.close();
	}

}
