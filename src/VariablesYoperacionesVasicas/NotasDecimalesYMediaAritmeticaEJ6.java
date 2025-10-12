package VariablesYoperacionesVasicas;

import java.util.Scanner;

public class NotasDecimalesYMediaAritmeticaEJ6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		float nota1;
		float nota2;
		float nota3;
		float nota4;

		System.out.println("Necesito que me des 4 notas con decimales");
		nota1 = sc.nextFloat();
		nota2 = sc.nextFloat();
		nota3 = sc.nextFloat();
		nota4 = sc.nextFloat();

		System.out.println("La media aritmetica de los numeros es " + (int) (nota1 + nota2 + nota3 + nota4) / 4);

		sc.close();
	}

}
