package b3;

import java.util.Scanner;

public class Ej8_MiniCuestionario {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int puntuacion = 0;
        System.out.println("¿Como se llama nuestra tutora? \n 1 Marta \n 2 Inma \n 3 Carlos");
        
        int opcion = sc.nextInt();
        
        if(opcion == 1) {
        	puntuacion++;
        }
 System.out.println("¿Como se llama la maestra que nos da Base de Datos? \n 1 Marta \n 2 Inma \n 3 Carlos");
        
         opcion = sc.nextInt();
        
        if(opcion == 2) {
        	puntuacion++;
        }
        System.out.println("¿Como se llama el maestro que nos da Digitalizacion? \n 1 Marta \n 2 Inma \n 3 Carlos");
        
        opcion = sc.nextInt();
       
       if(opcion == 3) {
       	puntuacion++;
       }
        
       System.out.println("¿Como se llama el maestro que nos da Sistemas? \n 1 Marta \n 2 Inma \n 3 Javi");
       
       opcion = sc.nextInt();
      
      if(opcion == 3) {
      	puntuacion++;
      }
      System.out.println("¿Como se llama el maestro de apollo en Base de Datos? \n 1 Marta \n 2 Inma \n 3 Eduardo");
      
      opcion = sc.nextInt();
     
     if(opcion == 3) {
     	puntuacion++;
     }
     
     System.out.println("la puntuacion es " +puntuacion);
     sc.close();
	}

}
