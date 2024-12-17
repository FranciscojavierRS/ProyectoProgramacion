package EXAMEN_CABALLOS;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenCaballosTABLAS {
	private static final int MAXCARRERAS = 10;
	private static final int MAXCABALLOS = 15;
	private static float[][] velocidades = new float[MAXCABALLOS][MAXCARRERAS];
	private static String[] ciudades = new String[MAXCARRERAS];
	private static String[] caballos = new String[MAXCABALLOS];
	private static int numcaballos = 0;
	private static int numcarreras = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		inicializardatos();

		while (opcion != 6) {
			System.out.println("1-Introducir caballo,carrera,ciudad y velocidad\n" + "2-Listar todos los datos\n"
					+ "3-Indicar en que ciudad ha habido mas carreras\n"
					+ "4-Listado de carreras junto con el caballo ha quedado en ultima posicion\n"
					+ "5-Listado de caballo de velocidades media\n" + "6-Fin");

			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				insertardatos(sc);
				break;
			case 2:
				mostrarDatos();

				break;
			case 3:
				ciudadmascarreras();
				break;
			case 4:
				caballomaslento();
				break;
			case 5:
				ordenadoAlfabeticamente();

				break;
			default:
				break;
			}
		}
		sc.close();
	}

	private static void ordenadoAlfabeticamente() {
		String[] caballosOrdenados = getOrdenarArray(caballos, numcaballos);
		System.out.println("Caballos ordenados alfabeticamente");
		for (int i = 0; i < numcaballos; i++) {
			
			int indice= indiceCaballo(caballosOrdenados[i]);
			float media = calculaMedia(indice);
			System.out.println(caballosOrdenados[i] + " -->" + media);
		}
	}	
	

	private static float calculaMedia(int indice) {
		float media = 0;
		int carreras = 0;
		
		for(int i = 0;i<MAXCARRERAS; i++) {
			float velocidad = velocidades[indice][i];
			if(-1 != velocidad) {
				carreras ++;
				media = media + velocidad;
			}
		}
		if(0!= carreras) {
			media = media/carreras;
		}
		return media;
	}

	private static String[] getOrdenarArray(String[] caballos2, int numcaballos2) {
		String[] arrayOrdenado = Arrays.copyOf(caballos2, numcaballos2);
		Arrays.sort(arrayOrdenado);
		return arrayOrdenado;
	}

	private static void caballomaslento() {
		int caballomaslento = -1;
		float minvelocidad = 9999;

		for (int j = 0; j < MAXCARRERAS; j++) {
			for (int i = 0; i < numcaballos; i++) {
				if (velocidades[i][j] != -1) {
					if (velocidades[i][j] < minvelocidad) {
						caballomaslento = i;
						minvelocidad = velocidades[i][j];
					}
				}

			}
			if (caballomaslento != -1) {
				System.out.println("carrera " + (j + 1) + " -->" + caballos[caballomaslento]);
			}
			caballomaslento = -1;
			minvelocidad = 9999;
		}
	}

	private static void ciudadmascarreras() {
		int contador = 0;
		int max = 0;
		String ciudad = "";
		for (int i = 0; i < MAXCARRERAS; i++) {
			String c = ciudades[i];
			contador++;
			for (int j = i + 1; j < MAXCARRERAS; j++) {
				if (null != c && c.equals(ciudades[j])) {
					contador++;
				}
			}

			if (contador > max) {
				ciudad = c;
				max = contador;
			}
			contador = 0;
		}
		System.out.println(ciudad);
	}

	private static void mostrarDatos() {
		for (int i = 0; i < numcaballos; i++) {
			String caballo = caballos[i];
			System.out.println(caballo);
			for (int j = 0; j < MAXCARRERAS; j++) {
				float velocidad = velocidades[i][j];
				if (velocidad != -1) {
					System.out.println("carrera " + (j + 1) + " --> " + velocidad);
				}
			}

		}
	}

	private static void insertardatos(Scanner sc) {
		System.out.println("Introduce el nombre del caballo:");
		String caballo = sc.next();

		if (comprobarcaballo(caballo)) {
			caballos[numcaballos] = caballo;
			numcaballos++;
		}

		System.out.println("Introduce la carrera:");
		int carrera = sc.nextInt();
		if (comprobarcarrera(carrera, sc)) {

			numcarreras++;
		}

		System.out.println("Introduce la velocidad del caballo:");
		float velocidad = sc.nextFloat();
		velocidades[indiceCaballo(caballo)][carrera - 1] = velocidad;

		System.out.println("Datos almacenados");
	}

	private static int indiceCaballo(String caballo) {
		int indice = 0;
		while (indice < numcaballos && !caballo.equals(caballos[indice])) {
			indice++;
		}
		return indice;

	}

	private static boolean comprobarcarrera(int carrera, Scanner sc) {
		if (numcarreras == MAXCARRERAS - 1) {
			System.out.println("Se ha alcanzado el número máximo de carreras");
			return false;
		}

		if (ciudades[carrera] == null) {
			System.out.println("Introduce el nombre de la ciudad");
			String ciudad = sc.next();
			ciudades[carrera] = ciudad;
			return true;

		}

		return false;
	}

	private static boolean comprobarcaballo(String caballo) {
		for (int i = 0; i < numcaballos; i++) {

			if (caballo.equals(caballos[i])) {
				return false; // Ciudad ya registrada
			}
		}

		if (numcaballos == MAXCABALLOS - 1) {
			System.out.println("Se ha alcanzado el número máximo de caballos");
			return false;
		}

		return true;
	}

	private static void inicializardatos() {
		for (int i = 0; i < MAXCABALLOS; i++) {
			for (int j = 0; j < MAXCARRERAS; j++) {
				velocidades[i][j] = -1;
			}
		}
	}

}
