package Examenes_Arrays.copy;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenPartidosPoliticos {
	static int numLocalidades = 0; // Número de localidades registradas
	static int numPartidos = 0;    // Número de partidos registrados

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcion = 0;

		int[][] votos = new int[20][30]; // votos[partido][localidad]
		inicializarTabla(votos);         // Se inicializa todo a -1 (sin datos)

		String[] partidos = new String[20];   // Lista de partidos
		String[] localidades = new String[30]; // Lista de localidades

		while (opcion != 6) {

			System.out.println("1- Introducir votos obtenidos en una ciudad por un partido.");
			System.out.println("2- Listado alfabético por partidos de todos los datos introducidos.");
			System.out.println("3- Listado de mejores resultados de cada partido.");
			System.out.println("4- Listado de localidades de menor a mayor participación.");
			System.out.println("5- Porcentajes de votos obtenidos por cada partido en la comunidad.");
			System.out.println("6- Fin.");

			opcion = sc.nextInt();

			switch (opcion) {

			case 1:
				introducirDatos(sc, votos, partidos, localidades); // Añade votos por partido/localidad
				break;

			case 2:
				mostrarListadoAlfabetico(votos, partidos, localidades); // Muestra partidos y votos ordenados alfabéticamente
				break;

			case 3:
				partidosLocalidadMasVotada(votos, partidos, localidades); // Muestra dónde tiene más votos cada partido
				break;

			case 4:
				votosPorLocalidad(votos, localidades); // Ordena localidades según participación total
				break;

			case 5:
				porcentajeVotosPartidos(votos, partidos); // Muestra % total de votos por partido
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

		int contadorTotalVotos = 0;                // Total de votos de toda la comunidad
		int[] contadorPartidos = new int[numPartidos]; // Total por cada partido
		Arrays.fill(contadorPartidos, 0);

		// Recorre los votos sumando por partido y por el total general
		for (int i= 0; i<numPartidos; i++) {
			for (int j= 0; j<numLocalidades; j++) {
				
				int votosLocalidad= votos [i][j];
				
				if (votosLocalidad!=-1) {
					contadorTotalVotos+=votosLocalidad;
					contadorPartidos[i]+=votosLocalidad;
				}
			}
		}
		
		// Calcula porcentaje para cada partido
		for (int i= 0; i<numPartidos; i++) {
			float porcentaje = (float)contadorPartidos[i]*100/contadorTotalVotos;
			System.out.println("Partido: "+partidos[i]+". Porcentaje de votos: "+porcentaje+"%");
		}
	}

	private static void votosPorLocalidad(int[][] votos, String[] localidades) {

		int[] votosNoOrdenados = new int[numLocalidades]; // Suma de votos por localidad

		for (int j = 0; j < numLocalidades; j++) {

			int sumaVotos = 0;

			// Suma votos de todos los partidos en cada localidad
			for (int i = 0; i < numPartidos; i++) {
				if (votos[i][j] != -1) {
					sumaVotos += votos[i][j];
				}
			}

			votosNoOrdenados[j] = sumaVotos;
		}

		// Copia los votos para ordenarlos de menor a mayor participación
		int[] votosOrdenados = Arrays.copyOf(votosNoOrdenados, numLocalidades);
		Arrays.sort(votosOrdenados);

		for (int i = 0; i < numLocalidades; i++) {

			int sumaVotos = votosOrdenados[i];

			// Busca la localidad correspondiente a esa suma
			int indiceVotos = getindice(votosNoOrdenados, sumaVotos, numLocalidades);

			String localidad = localidades[indiceVotos];

			System.out.println("En la ciudad de " + localidad + " el numero de votos ha sido de :" + sumaVotos);
		}

	}

	private static void partidosLocalidadMasVotada(int[][] votos, String[] partidos, String[] localidades) {

		// Para cada partido busca la localidad donde más votos obtuvo
		for (int i = 0; i < numPartidos; i++) {
			String partido = partidos[i];

			int indiceMasVotado = indiceMasVotado(votos[i]); // Devuelve posición del máximo

			String localidad = localidades[indiceMasVotado];

			System.out.println("El partido: " + partido + " ha obtenido mas votos en: " + localidad);
		}
	}

	private static int indiceMasVotado(int[] votos) {

		// Busca el mayor valor dentro del array votos[localidades]
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

		// Crea copias ordenadas alfabéticamente
		String[] partidosOrdenados = Arrays.copyOf(partidos, numPartidos);
		Arrays.sort(partidosOrdenados);

		String[] localidadesOrdenados = Arrays.copyOf(localidades, numLocalidades);
		Arrays.sort(localidadesOrdenados);

		// Recorre partidos en orden alfabético
		for (int i = 0; i < numPartidos; i++) {
			String partido = partidosOrdenados[i];
			System.out.println("Partido: " + partido);

			int indicePartido = getindice(partidos, partido, numPartidos);

			// Recorre localidades en orden alfabético
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

		// Busca la localidad o la crea si no existe
		int indiceLocalidad = getindice(localidades, localidad, numLocalidades);
		if (indiceLocalidad == numLocalidades) {
			numLocalidades++;
		}

		System.out.println("Introduce nombre de la partido");
		String partido = sc.next();

		// Busca el partido o lo crea si no existe
		int indicePartido = getindice(partidos, partido, numPartidos);
		if (indicePartido == numPartidos) {
			numPartidos++;
		}

		System.out.println("Introduce los votos");
		int votosPartido = sc.nextInt();

		// Asigna los votos en la posición correspondiente
		votos[indicePartido][indiceLocalidad] = votosPartido;
	}

	private static int getindice(int[] votos, int voto, int numLocalidades) {

		// Busca la posición donde aparece esa cantidad de votos
		for (int i = 0; i < numLocalidades; i++) {
			if (votos[i] == voto) {
				return i;
			}
		}

		return -1;
	}

	private static int getindice(String[] localidades, String localidad, int numLocalidades) {

		// Busca una cadena dentro del array
		for (int i = 0; i < numLocalidades; i++) {
			if (localidades[i].equals(localidad)) {
				return i;
			}
		}

		// Si no existe la localidad, se añade en la siguiente posición
		localidades[numLocalidades] = localidad;
		return numLocalidades;
	}

	private static void inicializarTabla(int[][] votos) {

		// Rellena toda la tabla con -1 para indicar "sin votos"
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 30; j++) {
				votos[i][j] = -1;
			}
		}
	}

}
