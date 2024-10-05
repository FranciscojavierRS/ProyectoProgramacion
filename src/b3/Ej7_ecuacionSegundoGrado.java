package b3;

import java.util.Scanner;

public class Ej7_ecuacionSegundoGrado {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vamos a resolver una ecuacion de segundo grado ax2+bx+c = 0");
        
        System.out.println("Introduce el valor de a");
        
        double numeroA= sc.nextDouble();
        
        System.out.println("Introduce el valor de b");

        double numeroB= sc.nextDouble();

        System.out.println("Introduce el valor de c");

        double numeroC= sc.nextDouble();

        double solucion1 = (-numeroB + Math.sqrt(numeroB*numeroB -4*numeroA*numeroC))/2*numeroA;
        
        double solucion2 = (-numeroB - Math.sqrt(numeroB*numeroB -4*numeroA*numeroC))/2*numeroA;
        
        System.out.println("las soluciones son " +solucion1+" y " +solucion2);
        sc.close();
        
	}

}
