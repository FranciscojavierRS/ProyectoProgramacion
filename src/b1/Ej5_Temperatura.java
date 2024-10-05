package b1;

import java.util.Scanner;

public class Ej5_Temperatura {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce una temperatura en centigrados");
		int centigrados= sc.nextInt();
		final int fahrenheit= 9*centigrados/5+32;
		System.out.println(centigrados+" centigrados son : " + fahrenheit + " fahrenheits");
		sc.close();
	}
}
