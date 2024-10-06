package b4;

import java.util.Scanner;

public class Ej12_SuspensoONo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nota = 0;
		boolean suspenso =false;
		for (int i=0; i<5; i++) {
		System.out.println("Introduce una nota");
		nota= sc.nextInt();
		if (nota<5) {
			suspenso=true;
		}
		}
		if(suspenso) {
			System.out.println("hay un suspenso");
		}else {
			System.out.println("No hay suspensos");
		}
		sc.close();
	}

}
