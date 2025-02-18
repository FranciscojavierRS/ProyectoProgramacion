package ExamenRecuperacion1;

import java.util.Arrays;
import java.util.Scanner;

public class RecuperacionProgramacion {

	private static final int MAX_SESIONES = 20;  
    private static final int MAX_USUARIO = 4;
    private static final int NOTA_NO_INGRESADA = -1;
    private static int[][] notas = new int[MAX_SESIONES][MAX_USUARIO];
    private static String[] nombreusuario = new String[MAX_USUARIO];
    private static String[] nombresesion = new String[MAX_SESIONES];

    private static int numsesiones = 0;
    private static int numusuario = 0;

    private static String[] nombresesiones = new String[MAX_SESIONES];



    
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Introduce nombre del curso:");
	        String usuario = sc.next();
		 
	        System.out.println("Introduce numero de sesiones:");
	        int sesiones = sc.nextInt();
		 
	        System.out.println("Introduce tiempo  que se estima que debe dedicarse a cada una de las sesiones:");
	        float sesion = sc.nextFloat();
		 
		 
		 
		 
		 
		 
	        inicializarSesiones();
	        int opcion = 0;
	      
	        // Bucle principal del menú
	        while (opcion != 6) {
	            mostrarMenu(); // Muestra las opciones del menú al usuario
	            opcion = sc.nextInt(); // Leer la opción seleccionada por el usuario
	            
	            switch (opcion) {
	                case 1:
	                	insertarDatos(sc);
	                    break;
	                case 2:
	                	mostrardatos();
	                    break;
	                case 3:
	                	 mejornotamedia();
	                    break;
	                case 4:
	                	usuariosUnaSesion();
	                    break;
	                case 5:
	                	totalminutosdedicados();
	                    break;
	                case 6:
	                    System.out.println("Saliendo del programa..."); // Finaliza el programa
	                    break;
	                default:
	                    System.out.println("Opción no válida."); // Mensaje en caso de opción incorrecta
	            }
	        }
	        
	        sc.close(); // Cierra el Scanner al finalizar
	    }
		
	

	
	private static void totalminutosdedicados() {
		
	}




	private static void usuariosUnaSesion() {
		for (int j=0; j<numusuario;j++) {
			for (int i=0; i<numsesiones;i++) {
				System.out.println("Usuarios que han estudiado solo una sesión: ");{
					
				}
			}
			
		}
			
	}




	private static void mejornotamedia() {
        int estudianteMayorPromedio = -1;  // Índice del estudiante con mayor promedio
        double mayorPromedio = -1; // Valor del mayor promedio

        // Iterar sobre todos los estudiantes para calcular sus promedios
        for (int j = 0; j < MAX_USUARIO; j++) {
            int sumaNotas = 0;
            int numEvaluaciones = 0;

            // Sumar las notas del estudiante actual
            for (int i = 0; i < MAX_SESIONES; i++) {
                if (notas[i][j] != NOTA_NO_INGRESADA) {
                    sumaNotas += notas[i][j];
                    numEvaluaciones++;
                }
            }

            // Si tiene evaluaciones, calcular el promedio y compararlo con el mayor promedio hasta ahora
            if (numEvaluaciones > 0) {
                double promedio = (double) sumaNotas / numEvaluaciones;
                if (promedio > mayorPromedio) {
                    mayorPromedio = promedio;
                    estudianteMayorPromedio = j;
                }
            }
        }

        // Mostrar el estudiante con mayor promedio
        if (estudianteMayorPromedio != -1) {
            System.out.println("El estudiante con el mayor promedio es el estudiante " + (estudianteMayorPromedio + 1) + " con un promedio de " + mayorPromedio);
        } else {
            System.out.println("No hay notas ingresadas.");
        }
    }




	private static void mostrardatos() {
		String[] sesionesOrdenadas = getOrdenarArray(nombresesiones, numsesiones);
    for (int i = 0; i < numsesiones; i++) {
        String sesiones = sesionesOrdenadas[i];
        int indice = indiceSesiones(sesiones);
        System.out.println("notas " + notas);
        for (int j = 0; j < MAX_USUARIO; j++) {
            if (notas[indice][j] != -1) {
                System.out.println("El numero de la sesion es: "+sesiones+" - "+"Las calificaciones de todos los usuarios en esa sesión :"+notas);
                //System.out.println(nombrealumnos[j] + " - " + notas[indice][j] + " nota");

            }
        }
    }
}




	private static int indiceSesiones(String sesiones) {
        int indice = 0;
        while (indice < numsesiones && !sesiones.equals(nombresesiones[indice])) {
            indice++;
        }
        return indice;
    }
	private static String[] getOrdenarArray(String[] nombresesiones2, int numsesiones2) {
        String[] arrayOrdenado = Arrays.copyOf(nombresesiones2, numsesiones2);
        Arrays.sort(arrayOrdenado); // Ordenamos el array
        return arrayOrdenado; // Devolvemos el array ordenado
    }

	private static void insertarDatos(Scanner sc) {
		System.out.println("Introduce nombre usuario:");
        String usuario = sc.next();
        if (comprobarusuario(usuario)) { // Comprobamos si el alumno ya existe
            nombreusuario[numusuario] = usuario;
            numusuario++;
            
        System.out.println("Introduce el número de la SESION:");
        int sesiones = sc.nextInt() ;

        System.out.println("Introduce la nota obtenida (0-10):");
        float nota = sc.nextFloat();}
  
	
	}
        
        
        
		
	

	



	private static boolean comprobarusuario(String usuario) {
        for (String c : nombreusuario) {
            if (usuario.equals(c)) {
                return false; // Si el alumno ya existe, devolver false
            }
        }
        return true; // Si no existe, devolver true
    }




	private static void mostrarMenu() {
        System.out.println("\n1- Registrar la calificación de un usuario en cierta sesión de aprendizaje");
        System.out.println("2- Listar todas las sesiones, junto con su duración y notas");
        System.out.println("3- Indicar cuál es la sesión en la que se ha sacado mejor nota media");
        System.out.println("4- Mostrar los usuarios que han estudiado solo una sesión.");
        System.out.println("5- Listar usuarios (ordenados alfabéticamente) con su nota media");
        System.out.println("6- Salir del programa");
        System.out.print("Opción: "); // Espera la selección del usuario
    }

	private static void inicializarSesiones() {
        for (int i = 0; i < MAX_SESIONES; i++) {
            for (int j = 0; j < MAX_USUARIO; j++) {
            	notas[i][j] = -1;
            }
        }
    }
	    
	    
	}