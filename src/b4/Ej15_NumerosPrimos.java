package b4;

import java.util.Scanner;

public class Ej15_NumerosPrimos {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int numero=0;
		
		while(numero <=0) {
		System.out.println("Introduce un Numero");
		numero=sc.nextInt();
		
		}
		int primos = 0;
		boolean primo;
		for(int i=1; i<=numero;i++) {
			primo = true;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
		            primo = false;
				}
			}
			if(primo) {
				primos++;
			}
		}
		System.out.println("Hay "+ primos+ " numeros primos entre 1 y "+numero);
		sc.close();
	}
	

}
