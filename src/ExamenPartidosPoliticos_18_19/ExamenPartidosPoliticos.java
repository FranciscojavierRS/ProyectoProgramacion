package ExamenPartidosPoliticos_18_19;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenPartidosPoliticos {
	static int numLocalidades = 0;
	static int numPartidos = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcion = 0;

		int[][] votos = new int[20][30];
		inicializarTabla(votos);

		String[] partidos = new String[20];
		String[] localidades = new String[30];

		while (opcion != 6) {

			System.out.println("1- Introducir votos obtenidos en una ciudad por un partido.");
			System.out.println("2- Listado alfabético por partidos de todos los datos introducidos.");
			System.out.println("3- Listado de mejores resultados de cada partido.");
			System.out.println("4- Listado de localidades de menor a mayor participación.");
			System.out.println("5- Porcentajes de votos obtenidos por cada partido en la comunidad.");
			System.out.println("6- Fin.");

			opcion = sc.nextInt();

			switch (opcion) {
			// Introducir votos obtenidos en una ciudad por un partido.
			case 1:
				introducirDatos(sc, votos, partidos, localidades);

				break;

			case 2:
				mostrarListadoAlfabetico(votos, partidos, localidades);

				break;
			case 3:
				partidosLocalidadMasVotada(votos, partidos, localidades);
				break;

			case 4:
				votosPorLocalidad(votos, localidades);

				break;
			case 5:
				porcentajeVotosPartidos(votos, partidos);

				break;

			case 6:

				break;

			default:

			}
			System.out.println("");
		}

		sc.close();
	}

	private static void porcentajeVotosPartidos(int[][] votos, String[] partidos) {

		int contadorTotalVotos = 0;
		int[] contadorPartidos = new int [numPartidos];
		Arrays.fill(contadorPartidos, 0);
		for (int i= 0; i<numPartidos; i++) {
			
			for (int j= 0; j<numLocalidades; j++) {
				
				int votosLocalidad= votos [i][j];
				
				if (votosLocalidad!=-1) {
					contadorTotalVotos+=votosLocalidad;
					contadorPartidos[i]+=votosLocalidad;
					
				}
			}
		}
		
		for (int i= 0; i<numPartidos; i++) {
			float porcentaje = (float)contadorPartidos[i]*100/contadorTotalVotos;
			
			System.out.println("Partido: "+partidos[i]+". Porcentaje de votos: "+porcentaje+"%");
		}
		
		
		
		
	}

	private static void votosPorLocalidad(int[][] votos, String[] localidades) {

		int[] votosNoOrdenados = new int[numLocalidades];

		for (int j = 0; j < numLocalidades; j++) {

			int sumaVotos = 0;

			for (int i = 0; i < numPartidos; i++) {
				if (votos[i][j] != -1) {
					sumaVotos += votos[i][j];
				}

			}

			votosNoOrdenados[j] = sumaVotos;

		}
		int[] votosOrdenados = Arrays.copyOf(votosNoOrdenados, numLocalidades);
		Arrays.sort(votosOrdenados);

		for (int i = 0; i < numLocalidades; i++) {

			int sumaVotos = votosOrdenados[i];

			int indiceVotos = getindice(votosNoOrdenados, sumaVotos, numLocalidades);

			String localidad = localidades[indiceVotos];

			System.out.println("En la ciudad de " + localidad + " el numero de votos ha sido de :" + sumaVotos);
		}

	}

	private static void partidosLocalidadMasVotada(int[][] votos, String[] partidos, String[] localidades) {

		for (int i = 0; i < numPartidos; i++) {
			String partido = partidos[i];

			int indiceMasVotado = indiceMasVotado(votos[i]);

			String localidad = localidades[indiceMasVotado];

			System.out.println("El partido: " + partido + " ha obtenido mas votos en: " + localidad);

		}
	}

	private static int indiceMasVotado(int[] votos) {

		int maxVotos = -1;
		int indice = 0;
		for (int i = 0; i < numLocalidades; i++) {

			if (votos[i] > maxVotos) {
				maxVotos = votos[i];
				indice = i;
			}
		}

		return indice;
	}

	private static void mostrarListadoAlfabetico(int[][] votos, String[] partidos, String[] localidades) {

		String[] partidosOrdenados = Arrays.copyOf(partidos, numPartidos);

		Arrays.sort(partidosOrdenados);

		String[] localidadesOrdenados = Arrays.copyOf(localidades, numLocalidades);

		Arrays.sort(localidadesOrdenados);

		for (int i = 0; i < numPartidos; i++) {
			String partido = partidosOrdenados[i];
			System.out.println("Partido: " + partido);

			int indicePartido = getindice(partidos, partido, numPartidos);

			for (int j = 0; j < numLocalidades; j++) {
				String localidad = localidadesOrdenados[j];

				int indiceLocalidad = getindice(localidades, localidad, numLocalidades);

				int votosPartidos = votos[indicePartido][indiceLocalidad];

				if (votosPartidos != -1) {
					System.out.println(localidad + ": " + votosPartidos + " votos");
				}

			}
		}
	}

	private static void introducirDatos(Scanner sc, int[][] votos, String[] partidos, String[] localidades) {

		System.out.println("Introduce nombre de la localidad");
		String localidad = sc.next();
		int indiceLocalidad = getindice(localidades, localidad, numLocalidades);

		if (indiceLocalidad == numLocalidades) {
			numLocalidades++;

		}

		System.out.println("Introduce nombre de la partido");
		String partido = sc.next();
		int indicePartido = getindice(partidos, partido, numPartidos);

		if (indicePartido == numPartidos) {
			numPartidos++;

		}

		System.out.println("Introduce los votos");
		int votosPartido = sc.nextInt();

		votos[indicePartido][indiceLocalidad] = votosPartido;
	}

	private static int getindice(int[] votos, int voto, int numLocalidades) {

		for (int i = 0; i < numLocalidades; i++) {

			if (votos[i] == voto) {
				return i;

			}
		}

		return -1;
	}

	private static int getindice(String[] localidades, String localidad, int numLocalidades) {

		for (int i = 0; i < numLocalidades; i++) {

			if (localidades[i].equals(localidad)) {
				return i;

			}
		}

		localidades[numLocalidades] = localidad;
		return numLocalidades;
	}

	private static void inicializarTabla(int[][] votos) { // Inicializamos las tablas a -1

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 30; j++) {
				votos[i][j] = -1;
			}
		}

	}

}
