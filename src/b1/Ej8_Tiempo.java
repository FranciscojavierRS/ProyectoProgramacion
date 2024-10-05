package b1;

import java.util.Scanner;

public class Ej8_Tiempo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un horas");

			int num1= sc.nextInt();
			
			System.out.println("Introduce  minutos");

			int num2= sc.nextInt();
			
			System.out.println("Introduce  segundos");

			int num3= sc.nextInt();
			
			int segundos = num3%60;
			
			int minutos = num2 + (num3/60);
			
			int horas = num1 + (minutos / 60);
			minutos = minutos%60;
			
			System.out.println("La hora es "+horas+" horas "+minutos+" minutos "+segundos + " segundos");
			sc.close();
			
	}

}
