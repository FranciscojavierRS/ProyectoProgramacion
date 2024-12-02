package ExamenNotasEvaluacion;

import java.util.Scanner;

public class NotasEvaluacion {
	private static final int MAXALUMNOS = 30;
	

	public static void main(String[] args) {
		
	        Scanner sc = new Scanner(System.in);

	        int opcion = 0;

	        // Bucle principal del menú interactivo
	        while (opcion != 5) {
	            System.out.println("1-Introducir alumno,nota del control y nota del examen final del alumno\n" 
	                             + "2-Poner un positivo a un alumno\n"
	                             + "3-Listar  todos los alumnos  con su nota  final de evaluacion ordenado por nota\n"
	                             + "4-Mostrar estadisticas de la evaluacion\n"
	                             + "5-Fin\n");

	            opcion = sc.nextInt(); // Leer la opción del usuario
	            
	            
	            switch (opcion) {
                case 1: // Introducir a un alumno(PUNTO 1)
                    intertarAlumno();
                    break;
	        }
	        }

	}
	
	        private static void intertarAlumno() {
	    		
	    		
	    	}
   
	        
}


	