package ExamenCaballosArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenCaballos {
	static int numCaballos = 0;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcion = 0;
		float [][] velocidades = new float[15][10];
		inicializarTabla(velocidades);
		String[] nombresCiudades = new String[10];
		String[] nombresCaballos = new String[15];
		

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
				
				introducirDatos(sc, velocidades, nombresCiudades, nombresCaballos);

				break;

			case 2:
				mostrarDatos(velocidades,nombresCaballos,nombresCiudades);
				
				break;
			case 3:
				ciudadConMasCarreras(nombresCiudades);
				break;

			case 4:
				caballoMasLento(velocidades,nombresCaballos);
				break;
			case 5:
				velocidadesMediasAlfabeticamente(velocidades,nombresCaballos);
				
				break;

			case 6:
				System.out.println("!Hasta la próxima!");
				break;

			default:

			}
			System.out.println("");
		}

		sc.close();
	}

	private static void velocidadesMediasAlfabeticamente(float[][] velocidades, String[] nombresCaballos) {
		
		String [] nombresCaballosAlfabeticamente =Arrays.copyOf(nombresCaballos, numCaballos);
		
		Arrays.sort(nombresCaballosAlfabeticamente);
		
		for (int i=0; i<numCaballos; i++) {
			String nombreCaballo =nombresCaballosAlfabeticamente[i];
			
			int indiceCaballo = getindice(nombresCaballos, nombreCaballo, numCaballos);
			
			float sumaVelocidades = 0;
			int contadorCarreras =0;

			for ( int j= 0; j<10; j++) {
				float velocidad= velocidades[indiceCaballo][j];
				if (velocidad!=-1) {
					sumaVelocidades+=velocidad;
					contadorCarreras++;
				}
			}
			
			System.out.println(nombreCaballo+" : "+sumaVelocidades/contadorCarreras);
		}
		
	}

	private static void caballoMasLento(float[][] velocidades, String[] nombresCaballos) {
		
		for (int j=0; j<10; j++) {
			float menorVelocidad = Float.MAX_VALUE;
			int caballoMasLento = -1;
			 for (int i=0; i<numCaballos; i++) {
				 float velocidad = velocidades[i][j];
				 if (velocidad!=-1 && velocidad<menorVelocidad) {
					 menorVelocidad=velocidad;
					 caballoMasLento=i;
					
				 }
			 }
			 if (caballoMasLento!=-1) {
				 System.out.println("Carrera "+j+" -> "+nombresCaballos[caballoMasLento]);
			 }
		}
		
	}

	private static void ciudadConMasCarreras(String[] nombresCiudades) {

		int maxrepeticiones= 0;
		String ciudadMasRepetida = "";
		
		for (int i= 0; i<10; i++) {
			String nombreCiudad = nombresCiudades[i];
			if (nombreCiudad!= null) {
				int contadorRepeticiones = 0;
				for (int j=i; j<10; j++) {
					if (nombreCiudad.equals(nombresCiudades[j])) {
						contadorRepeticiones++;
					}
				}
				
				if (contadorRepeticiones>maxrepeticiones) {
					maxrepeticiones=contadorRepeticiones;
					ciudadMasRepetida=nombreCiudad;
				}
			}
		}
		
		System.out.println(ciudadMasRepetida);
	}

	private static void mostrarDatos(float[][] velocidades, String[] nombresCaballos, String[] nombresCiudades) {

		for (int i=0; i<numCaballos; i++) {
			System.out.println("Caballo: "+nombresCaballos[i]);
			
			for (int j= 0; j<10; j++) {
				float velocidad= velocidades[i][j];
				
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
		
		int indiceCaballo = getindice(nombresCaballos, nombreCaballo, numCaballos);

		if (indiceCaballo == numCaballos) {
			numCaballos++;

		}
		
		System.out.println("Introduce el numero de la carrera");
		int numeroCarrera = sc.nextInt(); 
		
		if (nombresCiudades[numeroCarrera]==null) {
			System.out.println("Introduce nombre Ciudad");
			String nombreCiudad = sc.next();
			nombresCiudades[numeroCarrera]=nombreCiudad;
		}
		
		System.out.println("Introduce el numero de la carrera");
		float velocidadMedia = sc.nextFloat();
		velocidades [indiceCaballo][numeroCarrera]=velocidadMedia;
	}

	private static int getindice(String[] nombresCaballos, String nombreCaballo, int numCaballos) {
		
		for (int i = 0; i < numCaballos; i++) {

			if (nombresCaballos[i].equals(nombreCaballo)) {
				return i;

			}
		}

		nombresCaballos[numCaballos] = nombreCaballo;
		return numCaballos;
		
		
	}

	private static void inicializarTabla(float[][] velocidades) {
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				velocidades[i][j] = -1;
			}
		}

		
	}
	
}

