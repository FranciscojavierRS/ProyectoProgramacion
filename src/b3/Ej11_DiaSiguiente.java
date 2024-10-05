package b3;

import java.util.Scanner;

public class Ej11_DiaSiguiente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("introduce un dia");

		int dia = sc.nextInt();

		System.out.println("introduce un mes");

		int mes = sc.nextInt();

		System.out.println("introduce un año");
		int ano = sc.nextInt();
		dia++;

		if (dia > 30) {
			dia = 1;
			if(mes == 12) {
				ano++;
				mes = 1;
			}else {
			mes++;
			}
		}

		System.out.println("La nueva fecha es el " +dia+" del mes " +mes+ " del año " +ano);

	}

}
