package EjercicioExamen3_12_2024;

import java.util.Scanner;

public class ExamenenFunciones {
	private static final int MAXCABALLOS = 15;
	private static final int MAXCARRERAS = 10;
	private static int[][] votos = new int[MAXCABALLOS][MAXCARRERAS];
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int opcion = 0;

	        // Bucle principal para el menú interactivo
	        while (opcion != 6) {
	            System.out.println("1-Introducir caballo, carrera, ciudad, y velocidad\n" 
	                             + "2-Listar todos los datos\n"
	                             + "3-Indicar en que ciudad ha habido mas carreras\n"
	                             + "4-Listado de carreras junto con el caballo ha quedado en ultima posicion\n"
	                             + "5-Listado -ordenado por caballo- de velocidades medias\n" 
	                             + "6-Fin");

	            opcion = sc.nextInt(); // Leer la opción seleccionada por el usuario

	            // Ejecutar la opción correspondiente
	            switch (opcion) {
	                case 1: 
	                    break;
	                case 2: 
	                	
	                    break;
	                case 3: 
	              
	                    break;
	                case 4: 
	            
	                    break;
	                case 5: 
	               
	                    break;
	                default:
	                    break; // No hacer nada si la opción no es válida
	            }
	        }

	        sc.close();
	}

}
