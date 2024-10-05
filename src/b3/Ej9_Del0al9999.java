package b3;

import java.util.Scanner;

public class Ej9_Del0al9999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero");
        
        String numero = String.valueOf(sc.nextInt());
        
        System.out.println("El numero insertado tiene " + numero.length() + " cifras");
        
        sc.close();
	}

}
