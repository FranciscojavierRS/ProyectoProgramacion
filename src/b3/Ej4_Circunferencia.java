package b3;

import java.util.Scanner;

public class Ej4_Circunferencia {

	public static void main(String[] args) {
			
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el radio de una circunferencia");
        
        double numero;
        numero = sc.nextDouble();
        
        System.out.println("Escoge una opcion: \n 1 Calcular diametro \n 2 Calcular perimetro \n 3 Calcular area");

        int opcion = sc.nextInt();
        switch (opcion) {
        
        case 1:
        	System.out.println("El diametro es " + numero*2);
        	break;
        	
        case 2:
        	System.out.println("El perimetro es " + numero*2*3.14);
        	break;
        
        case 3:
        	System.out.println("El area es " + 3.14*numero*numero);
        	break;
        default:
        	System.out.println("opción no valida");
        
        }
        
        sc.close();
		
	}

}
