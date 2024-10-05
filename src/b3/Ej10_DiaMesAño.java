package b3;

import java.util.Scanner;

public class Ej10_DiaMesAño {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("introduce un dia");
		
		int dia= sc.nextInt();
		
System.out.println("introduce un mes");
		
		int mes= sc.nextInt();
		
System.out.println("introduce un año");
		
		int ano= sc.nextInt();
		
		boolean correcto = false;
		
		int diasFebrero = 28;
		switch(mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			correcto = dia <= 31;
			break;
		case 2:
			if(ano%4 == 0) {
				diasFebrero = 29;
			}
			correcto = dia <=diasFebrero;
		break;
		case 4:
		case 6:
		case 9:
		case 11:
			correcto = dia <=30;
			break;
			
		default:
		}
		
		if(correcto) {
			System.out.println("La fecha es correcta");
			
		}else {
			System.out.println("La fecha no es correcta");
			
		}
		sc.close();
	}

}
