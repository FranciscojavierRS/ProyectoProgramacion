package b4;

import java.util.Scanner;

public class Ej13_ConteoNotas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aprobado=0;
		int suspenso=0;
		int condicionados=0;
		int nota = 0;
		for (int i=0; i<6; i++) {
			System.out.println("Introduce una nota");
			nota= sc.nextInt();
			if (nota<4) {
				suspenso++;
			}else if (nota>=5) {
				aprobado++;
			}else {
				condicionados++;
			}
			}
		
		System.out.println("Aprobados: "+ aprobado+" condicionados: "+condicionados+ " suspensos: "+suspenso);
		sc.close();
		

	}

}
