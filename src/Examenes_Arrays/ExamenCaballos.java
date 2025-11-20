package Examenes_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenCaballos {
	static int numCaballos = 0; // Número de caballos registrados hasta el momento
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcion = 0;
		float [][] velocidades = new float[15][10]; // Cada caballo (15) puede participar en 10 carreras
		inicializarTabla(velocidades); // Rellena con -1 indicando posiciones vacías
		String[] nombresCiudades = new String[10]; // Ciudad asociada a cada carrera
		String[] nombresCaballos = new String[15]; // Nombre de cada caballo registrado
		

		while (opcion != 6) {

			System.out.println("1- Introducir caballo, carrera, ciudad y velocidad.");
			System.out.println("2- Listar todos los datos");
			System.out.println("3- Indicar en qué ciudad ha habido más carreras.");
			System.out.println("4- Listado de carreras junto con el caballo ha quedado en última posición.");
			System.out.println("5- Listado -ordenado por caballo- de velocidades medias.");
			System.out.println("6- Fin.");

			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				// Introduce un caballo (nuevo o existente), la carrera y su velocidad
				introducirDatos(sc, velocidades, nombresCiudades, nombresCaballos);
				break;

			case 2:
				// Muestra los datos completos almacenados
				mostrarDatos(velocidades,nombresCaballos,nombresCiudades);
				break;

			case 3:
				// Determina la ciudad que más se repite
				ciudadConMasCarreras(nombresCiudades);
				break;

			case 4:
				// Muestra qué caballo ha sido el más lento en cada carrera
				caballoMasLento(velocidades,nombresCaballos);
				break;

			case 5:
				// Calcula y lista las velocidades medias ordenadas por nombre de caballo
				velocidadesMediasAlfabeticamente(velocidades,nombresCaballos);
				break;

			case 6:
				System.out.println("!Hasta la próxima!");
				break;

			default: // Opción no válida
			}
			System.out.println("");
		}

		sc.close();
	}

	private static void velocidadesMediasAlfabeticamente(float[][] velocidades, String[] nombresCaballos) {
		
		// Copia solo los caballos registrados hasta ahora
		String [] nombresCaballosAlfabeticamente = Arrays.copyOf(nombresCaballos, numCaballos);
		
		Arrays.sort(nombresCaballosAlfabeticamente); // Orden alfabético
		
		for (int i=0; i<numCaballos; i++) {
			String nombreCaballo = nombresCaballosAlfabeticamente[i];
			
			// Busca el índice real del caballo en el array original
			int indiceCaballo = getindice(nombresCaballos, nombreCaballo, numCaballos);
			
			float sumaVelocidades = 0;
			int contadorCarreras =0;

			// Recorre sus 10 carreras posibles
			for ( int j= 0; j<10; j++) {
				float velocidad= velocidades[indiceCaballo][j];
				if (velocidad!=-1) { // Si realmente participó
					sumaVelocidades += velocidad;
					contadorCarreras++;
				}
			}
			
			// Muestra la media
			System.out.println(nombreCaballo+" : "+sumaVelocidades/contadorCarreras);
		}
		
	}

	private static void caballoMasLento(float[][] velocidades, String[] nombresCaballos) {
		
		// Para cada carrera
		for (int j=0; j<10; j++) {
			float menorVelocidad = Float.MAX_VALUE; // Para encontrar el mínimo
			int caballoMasLento = -1;

			 // Comparamos todos los caballos
			 for (int i=0; i<numCaballos; i++) {
				 float velocidad = velocidades[i][j];
				 if (velocidad!=-1 && velocidad<menorVelocidad) {
					 menorVelocidad = velocidad;
					 caballoMasLento = i;
				 }
			 }

			 // Si hubo al menos un caballo en esta carrera
			 if (caballoMasLento!=-1) {
				 System.out.println("Carrera "+j+" -> "+nombresCaballos[caballoMasLento]);
			 }
		}
		
	}

	private static void ciudadConMasCarreras(String[] nombresCiudades) {

		int maxrepeticiones = 0;
		String ciudadMasRepetida = "";
		
		// Recorre todas las ciudades existentes
		for (int i= 0; i<10; i++) {
			String nombreCiudad = nombresCiudades[i];
			
			if (nombreCiudad != null) {
				int contadorRepeticiones = 0;

				// Cuenta cuántas veces aparece esa ciudad en el array
				for (int j=i; j<10; j++) {
					if (nombreCiudad.equals(nombresCiudades[j])) {
						contadorRepeticiones++;
					}
				}
				
				// Actualiza si es la ciudad más repetida hasta ahora
				if (contadorRepeticiones > maxrepeticiones) {
					maxrepeticiones = contadorRepeticiones;
					ciudadMasRepetida = nombreCiudad;
				}
			}
		}
		
		System.out.println(ciudadMasRepetida);
	}

	private static void mostrarDatos(float[][] velocidades, String[] nombresCaballos, String[] nombresCiudades) {

		// Recorre solo los caballos introducidos
		for (int i=0; i<numCaballos; i++) {
			System.out.println("Caballo: "+nombresCaballos[i]);
			
			for (int j= 0; j<10; j++) {
				float velocidad= velocidades[i][j];
				
				// Solo muestra las carreras donde realmente participó
				if (velocidad!=-1) {
					System.out.println("Carrera "+j+"("+nombresCiudades[j]+"): "+velocidad);
				}
				
			}
		}
	}

	private static void introducirDatos(Scanner sc, float[][] velocidades, String[] nombresCiudades,
			String[] nombresCaballos) {

		System.out.println("Introduce el nombre del caballo");
		String nombreCaballo = sc.next();
		
		// Busca el índice del caballo o lo registra si es nuevo
		int indiceCaballo = getindice(nombresCaballos, nombreCaballo, numCaballos);

		if (indiceCaballo == numCaballos) {
			numCaballos++; // Se añade un nuevo caballo
		}
		
		System.out.println("Introduce el numero de la carrera");
		int numeroCarrera = sc.nextInt(); 
		
		// Si esa carrera aún no tiene ciudad asignada, se pide
		if (nombresCiudades[numeroCarrera] == null) {
			System.out.println("Introduce nombre Ciudad");
			String nombreCiudad = sc.next();
			nombresCiudades[numeroCarrera] = nombreCiudad;
		}
		
		System.out.println("Introduce el numero de la carrera");
		float velocidadMedia = sc.nextFloat();
		
		// Guarda la velocidad del caballo en esa carrera
		velocidades[indiceCaballo][numeroCarrera] = velocidadMedia;
	}

	private static int getindice(String[] nombresCaballos, String nombreCaballo, int numCaballos) {
		
		// Busca si el caballo ya existe
		for (int i = 0; i < numCaballos; i++) {
			if (nombresCaballos[i].equals(nombreCaballo)) {
				return i; // Ya estaba
			}
		}

		// Si no existe, se registra en la primera posición libre
		nombresCaballos[numCaballos] = nombreCaballo;
		return numCaballos;
	}

	private static void inicializarTabla(float[][] velocidades) {
		
		// Marca todas las posiciones como vacías (-1)
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				velocidades[i][j] = -1;
			}
		}
	}
	
}
