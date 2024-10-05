package b4;

import java.util.Scanner;

public class Ej5_MinimoMaximo {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce valor Minimo");
        int minimo=sc.nextInt();
        
        System.out.println("introduce valor Maximo");
        int maximo=sc.nextInt();
        
        boolean correcto = false;
        
        while(!correcto) {
        	 System.out.println("introduce valor");
             int numero=sc.nextInt();
             if(numero < minimo) {
            	 System.out.println("El numero insertado es menor que el numero minimo");
             }else if(numero > maximo) {
            	 System.out.println("El numero insertado es mayor que el numero maximo");
             }else {
            	 correcto = true;
            	 System.out.println("El numero insertado esta dentro del rango");
             }
             
        }
        sc.close();
	}

}
