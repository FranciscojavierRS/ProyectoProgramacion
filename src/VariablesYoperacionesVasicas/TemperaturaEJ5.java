package VariablesYoperacionesVasicas;

import java.util.Scanner;

public class TemperaturaEJ5 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int gradosCentigrados;
	    double  fahrenheit;
	    System.out.println("Dame una temperatura en Grados Centigrados");
	    gradosCentigrados =sc.nextInt();
	    
	    fahrenheit = gradosCentigrados * (double) 9/5+32;
	    
	    System.out.println("La temperatura en Fahrenheit es "+ fahrenheit);
	    
	    
	    
	    
	    
	    
	    sc.close();

	}

}
