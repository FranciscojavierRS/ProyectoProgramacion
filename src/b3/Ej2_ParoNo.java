package b3;

import java.util.Scanner;

public class Ej2_ParoNo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un numero");

			int num1= sc.nextInt();
			if (num1 % 2 !=0) 
			System.out.println("valor impar");
			else
				System.out.println("valor par");
			sc.close();
	}

}


