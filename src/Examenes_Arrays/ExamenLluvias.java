package Examenes_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenLluvias {
	
	private static int numeroCiudades= 0; // Lleva la cuenta de ciudades registradas

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		String [] nombreCiudades = new String [20];       // Almacena nombres de hasta 20 ciudades
		float [] [] lluvias = new float [20][12];         // Para cada ciudad, lluvia registrada en cada mes

		inicializarTabla(lluvias); // Se rellenan todas las posiciones con -1 (sin datos)

		while (opcion != 6) {

			System.out.println("1. Introducir dato.");
			System.out.println("2- Listar todos los datos.");
			System.out.println("3- Mostrar la media de lluvias anual en una ciudad dada.");
			System.out.println("4- Listado alfabético por ciudades y su cantidad de lluvia anual.");
			System.out.println("5- Listado (ordenado por cantidad de lluvia) de ciudades y su lluvia en un mes dado.");
			System.out.println("6- Fin.");

			opcion = sc.nextInt();

			switch (opcion) {

			case 1:
				pedirDatos(sc,nombreCiudades,lluvias); // Añadir lluvia para una ciudad en un mes
				break;

			case 2:
				mostrarlosdatos(nombreCiudades,lluvias); // Muestra todas las ciudades y sus lluvias mes a mes
				break;

			case 3:
				mediaLluviaTodoElAño(sc,lluvias,nombreCiudades); // Media anual de una ciudad concreta
				break;

			case 4:
				mostrarListadoAlfabetico(nombreCiudades,lluvias); // Listado ordenado por nombre con lluvia anual
				break;

			case 5:
				lluviasMes(sc,lluvias,nombreCiudades); // Ordena ciudades según lluvias en un mes
				break;

			case 6:
				break;

			default:
			}
		}
	}

	private static void lluviasMes(Scanner sc, float[][] lluvias, String[] nombreCiudades) {

		System.out.println("Introduce un mes");
		int mes = sc.nextInt();

		// Se crea un array con las lluvias de ese mes para todas las ciudades
		float [] lluviasMes = new float[numeroCiudades];
		for (int i=0; i<numeroCiudades; i++) {
			lluviasMes[i]= lluvias[i][mes];
		}
		
		// Copiamos y ordenamos las lluvias
		float[] lluviasMesOrdenados = Arrays.copyOf(lluviasMes, numeroCiudades);
		Arrays.sort(lluviasMesOrdenados);

		System.out.println("Para el mes "+mes);

		for (int i=0; i<numeroCiudades; i++) {
			float lluviaMes = lluviasMesOrdenados[i];

			// Busca qué ciudad tiene esa cantidad de lluvia
			int indiceLluviaMes = getindice(lluviasMes, numeroCiudades,lluviaMes);

			String nombreCiudad=nombreCiudades[indiceLluviaMes];
			
			System.out.println(nombreCiudad+" lluvias en el mes:  "+lluviaMes);
		}
	}

	private static void mostrarListadoAlfabetico(String[] nombreCiudades, float[][] lluvias) {
		
		// Se hace una copia ordenada alfabéticamente de los nombres
		String[] ciudadesOrdenadas = Arrays.copyOf(nombreCiudades, numeroCiudades);
		Arrays.sort(ciudadesOrdenadas);
		
		for (int i= 0; i<numeroCiudades; i++) {
			String ciudad = ciudadesOrdenadas[i];
			
			int indiceCiudad = getindice(nombreCiudades, numeroCiudades, ciudad);
			
			float cantidadTotalLluviaAnual = 0;
			
			// Suma toda la lluvia registrada durante el año para esa ciudad
			for (int j= 0; j<12; j++) {
				float lluviaMes = lluvias[indiceCiudad][j];
				if (lluviaMes!=-1) {
					cantidadTotalLluviaAnual+=lluviaMes;
				}
			}

			System.out.println(ciudad+" litros.......: "+cantidadTotalLluviaAnual);
		}
	}

	private static void mediaLluviaTodoElAño(Scanner sc, float[][] lluvias, String[] nombreCiudades) {

		System.out.println("Introduce el nombre de una ciudad");
		String nombreCiudad = sc.next();
		
		float mediaLluviasCiudades = 0;

		// Buscar la ciudad
		int indiceCiudad = getindice(nombreCiudades, numeroCiudades, nombreCiudad);
			
		int contadorMesesLLuvia = 0;
			
		// Calcula la media solo sobre meses con dato válido
		for (int j= 0; j<12; j++) {
			float lluviaMes = lluvias[indiceCiudad][j];
			if (lluviaMes!=-1) {
				contadorMesesLLuvia++;
				mediaLluviasCiudades+=lluviaMes;
			}
		}
			
		System.out.println("Para "+nombreCiudad+" : Media de lluvias anual: "+mediaLluviasCiudades/contadorMesesLLuvia);
	}

	private static void mostrarlosdatos(String[] nombreCiudades, float[][] lluvias) {

		// Ordena las ciudades para mostrarlas
		String[] ciudadesOrdenadas = Arrays.copyOf(nombreCiudades, numeroCiudades);
		Arrays.sort(ciudadesOrdenadas);
		
		for (int i= 0; i<numeroCiudades; i++) {
			String ciudad = ciudadesOrdenadas[i];
			System.out.println("Ciudad: " + ciudad);
			
			int indiceCiudad = getindice(nombreCiudades, numeroCiudades, ciudad);
			
			// Muestra los 12 meses siempre que el valor no sea -1
			for (int j=0; j<12; j++) {
				float lluviasMes = lluvias[indiceCiudad][j];
				if (lluviasMes != -1) {
					System.out.println("mes: "+j + " litros: " + lluviasMes);
				}
			}
		}
	}

	private static void pedirDatos(Scanner sc, String[] nombreCiudades, float[][] lluvias) {

		System.out.println("Introduce el nombre de la ciudad");
		String nombreciudad = sc.next();
		
		// Se busca el índice de la ciudad; si no existe, se añade
		int indiceLocalidad = getindice(nombreCiudades, numeroCiudades,nombreciudad);
		
		// Si es nueva, aumenta el contador de ciudades
		if (indiceLocalidad == numeroCiudades) {
			numeroCiudades++;
		}

		System.out.println("Introduce numero del mes");
		int numeroMes = sc.nextInt();
		
		System.out.println("Introduce cantidad Lluvia");
		float cantidadLluvia = sc.nextFloat();
		
		lluvias[indiceLocalidad][numeroMes] = cantidadLluvia; // Registrar la lluvia
	}

	private static int getindice(float [] lluviasMes, int numeroCiudades, float lluviaMes) {

		// Busca qué ciudad corresponde a esa cantidad de lluvia
		for (int i = 0; i < numeroCiudades; i++) {
			if (lluviasMes[i]==lluviaMes) {
				return i;
			}
		}
		return 0;
	}

	private static int getindice(String[] nombreCiudades, int numeroCiudades, String nombreciudad) {

		// Busca la ciudad por nombre
		for (int i = 0; i < numeroCiudades; i++) {
			if (nombreCiudades[i].equals(nombreciudad)) {
				return i;
			}
		}

		// Si no existe, se registra como nueva ciudad
		nombreCiudades[numeroCiudades] = nombreciudad;
		return numeroCiudades;
	}

	private static void inicializarTabla(float[][] lluvias) {
		// Rellena toda la tabla con -1
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 12; j++) {
				lluvias[i][j] = -1;
			}
		}		
	}

}
