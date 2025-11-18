package ExamenLLuvias_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenLluvias {
	
	private static int numeroCiudades= 0;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		String [] nombreCiudades = new String [20];

		float [] [] lluvias = new float [20][12];

		inicializarTabla(lluvias);


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
				pedirDatos(sc,nombreCiudades,lluvias);
				break;

			case 2:
				mostrarlosdatos(nombreCiudades,lluvias);

				break;
			case 3:
				mediaLluviaTodoElAño(sc,lluvias,nombreCiudades);
				break;

			case 4:
				mostrarListadoAlfabetico(nombreCiudades,lluvias);
				break;
			case 5:
				lluviasMes(sc,lluvias,nombreCiudades);

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
		float [] lluviasMes = new float[numeroCiudades];
		for (int i=0; i<numeroCiudades; i++) {
			lluviasMes[i]= lluvias[i][mes];
		}
		
		float[] lluviasMesOrdenados = Arrays.copyOf(lluviasMes, numeroCiudades);
		Arrays.sort(lluviasMesOrdenados);
		System.out.println("Para el mes "+mes);
		for (int i=0; i<numeroCiudades; i++) {
			float lluviaMes = lluviasMesOrdenados[i];
			int indiceLluviaMes = getindice(lluviasMes, numeroCiudades,lluviaMes);
			String nombreCiudad=nombreCiudades[indiceLluviaMes];
			
			System.out.println(nombreCiudad+"lluvias en el mes  "+lluviaMes);
			
		}
		
		
	}


	private static void mostrarListadoAlfabetico(String[] nombreCiudades, float[][] lluvias) {
		
		String[] ciudadesOrdenadas = Arrays.copyOf(nombreCiudades, numeroCiudades);
		Arrays.sort(ciudadesOrdenadas);
		
		for (int i= 0; i<numeroCiudades; i++) {
			String ciudad = ciudadesOrdenadas[i];
			
			int indiceCiudad = getindice(nombreCiudades, numeroCiudades, ciudad);
			
			float cantidadTotalLluviaAnual = 0;
			
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
			int indiceCiudad = getindice(nombreCiudades, numeroCiudades, nombreCiudad);
			
			int contadorMesesLLuvia = 0;
			
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

		String[] ciudadesOrdenadas = Arrays.copyOf(nombreCiudades, numeroCiudades);
		Arrays.sort(ciudadesOrdenadas);
		
		for (int i= 0; i<numeroCiudades; i++) {
			String ciudad = ciudadesOrdenadas[i];
			System.out.println("Ciudad: " + ciudad);
			
			int indiceCiudad = getindice(nombreCiudades, numeroCiudades, ciudad);
			
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
		
		int indiceLocalidad = getindice(nombreCiudades, numeroCiudades,nombreciudad);
		
		if (indiceLocalidad == numeroCiudades) {
			numeroCiudades++;
			}
		System.out.println("Introduce numero del mes");
		int numeroMes = sc.nextInt();
		
		System.out.println("Introduce cantidad Lluvia");
		float cantidadLluvia = sc.nextFloat();
		
		lluvias[indiceLocalidad][numeroMes] = cantidadLluvia;


	}

	private static int getindice(float [] lluviasMes, int numeroCiudades, float lluviaMes) {

		for (int i = 0; i < numeroCiudades; i++) {

			if (lluviasMes[i]==lluviaMes) {
				return i;

			}
		}

		
		return 0;
	}

	private static int getindice(String[] nombreCiudades, int numeroCiudades, String nombreciudad) {

		for (int i = 0; i < numeroCiudades; i++) {

			if (nombreCiudades[i].equals(nombreciudad)) {
				return i;

			}
		}

		// aqui si llega si la ciudad es nueva
		nombreCiudades[numeroCiudades] = nombreciudad;
		return numeroCiudades;
	}


	private static void inicializarTabla(float[][] lluvias) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 12; j++) {
				lluvias[i][j] = -1;
			}
		}		
	}

}
