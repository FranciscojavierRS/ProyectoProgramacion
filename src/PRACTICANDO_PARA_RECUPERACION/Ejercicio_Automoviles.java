package PRACTICANDO_PARA_RECUPERACION;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_Automoviles {
	private static final int MAXFABRICA = 10;  // Número máximo de fábricas
	private static final int MAXAUTO = 12;     // Número máximo de automóviles
	private static final int MAXMESES = 12;    // Número máximo de meses (12 meses del año)
	
	// Matriz tridimensional que almacena la producción de automóviles por fábrica y por mes
	private static int[][][] produccion = new int[MAXFABRICA][MAXAUTO][MAXMESES];
	
	// Variables para contar el número de automóviles y fábricas registradas
	private static int numautomovil = 0;
	private static int numfabrica = 0;
	
	// Arrays para almacenar los nombres de las fábricas y automóviles
	private static String[] nombrefabrica = new String[MAXFABRICA];
	private static String[] nombreautomovil = new String[MAXAUTO];

	public static void main(String[] args) {
		inicializarDatos();  // Inicializar la matriz de producción con valores por defecto (-1)

		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		// Bucle principal para el menú interactivo
		while (opcion != 6) {
			System.out.println(
					"1-Introducir datos de producción para un modelo de automóvil en una fábrica en un mes dado\n"
					+ "2-Listar todos los datos de producción ingresados\n"
					+ "3-Mostrar la producción anual de un modelo de automóvil en una fábrica dada\n"
					+ "4-Mostrar la fábrica con mayor producción de un modelo en un mes dado\n"
					+ "5-Mostrar el modelo con la mayor producción total en el año en todas las fábricas\n"
					+ "6- Salir del programa");

			opcion = sc.nextInt();  // Leer la opción seleccionada por el usuario
			switch (opcion) {
			case 1:
				// Opción para introducir los datos de producción
				introducirdatos(sc);
				break;
			case 2:
				// Opción para mostrar todos los datos de producción
				mostrarlosdatos(sc);
				break;
			case 3:
				// Opción para mostrar la producción anual de un modelo específico en una fábrica
				produccionAnual(sc);
				break;
			case 4:
				// Opción para mostrar la fábrica con mayor producción de un modelo en un mes dado
				produccionMayor(sc);
				break;
			case 5:
				// Opción para mostrar el modelo con la mayor producción total en el año
				modeloMasProducido();
				break;
			default:
				break;
			}
		}

		sc.close();  // Cerrar el Scanner al finalizar
	}

	// Función para mostrar el modelo de automóvil con mayor producción total en todas las fábricas
	private static void modeloMasProducido() {
		String[] automovilesOrdenados = getOrdenarArray(numautomovil, nombreautomovil);  // Ordenar los nombres de los automóviles
		int cantidadMaximaAutomovil = 0;  // Variable para almacenar la mayor cantidad de producción
		String automovil = "";  // Nombre del automóvil con mayor producción

		// Iteramos sobre cada automóvil y fábrica para sumar las producciones
		for (int j = 0; j < numautomovil; j++) {
			for (int i = 0; i < numfabrica; i++) {
				for (int x = 0; x < MAXMESES; x++) {
					if (produccion[i][j][x] > cantidadMaximaAutomovil) {
						cantidadMaximaAutomovil = produccion[i][j][x];
						automovil = automovilesOrdenados[j];  // Actualizamos el automóvil con mayor producción
					}
				}
			}
		}
		System.out.println("El automóvil que ha tenido la mayor producción total en el año: " + automovil);
	}

	// Función para mostrar la fábrica con mayor producción de un modelo en un mes dado
	private static void produccionMayor(Scanner sc) {
		System.out.println("Introduce el nombre del automóvil:");
		String automovil = sc.next();  // Leer el nombre del automóvil
		int cantidadMaximaAutomovil = 0;  // Variable para almacenar la mayor cantidad de producción
		int indiceautomovil = indiceautomovil(automovil);  // Obtener el índice del automóvil
		int indicefabrica = 0;  // Índice de la fábrica con mayor producción
		String[] fabricasOrdenadas = getOrdenarArray(numfabrica, nombrefabrica);  // Ordenar las fábricas

		// Iteramos sobre las fábricas y los meses para encontrar la fábrica con mayor producción
		for (int i = 0; i < numfabrica; i++) {
			String fabrica = fabricasOrdenadas[i];
			for (int x = 0; x < MAXMESES; x++) {
				if (produccion[indicefabrica(fabrica)][indiceautomovil][x] > cantidadMaximaAutomovil) {
					cantidadMaximaAutomovil = produccion[indicefabrica(fabrica)][indiceautomovil][x];
					indicefabrica = indicefabrica(fabrica);
				}
			}
		}
		System.out.println("La fábrica que tuvo la mayor producción de ese modelo en un mes específico es: "
				+ nombrefabrica[indicefabrica]);
	}

	// Función para mostrar la producción anual de un modelo de automóvil en una fábrica dada
	private static void produccionAnual(Scanner sc) {
		System.out.println("Introduce el nombre de una fábrica:");
		String fabrica = sc.next();  // Leer el nombre de la fábrica
		int indicefabrica = indicefabrica(fabrica);  // Obtener el índice de la fábrica

		System.out.println("Introduce el nombre de un automóvil:");
		String automovil = sc.next();  // Leer el nombre del automóvil
		int indiceautomovil = indicefabrica(automovil);  // Obtener el índice del automóvil

		// Calcular la producción anual del automóvil en la fábrica seleccionada
		int productosAnual = calculaProduccionAnual(indicefabrica, indiceautomovil);
		System.out.println("La producción anual es: " + productosAnual);
	}

	// Función para calcular la producción anual de un automóvil en una fábrica
	private static int calculaProduccionAnual(int indicefabrica, int indiceautomovil) {
		int productosAnual = 0;  // Variable para almacenar la suma total de la producción
		for (int i = 0; i < MAXMESES; i++) {
			if (produccion[indicefabrica][indiceautomovil][i] != -1) {  // Si hay datos, sumamos la producción del mes
				productosAnual += produccion[indicefabrica][indiceautomovil][i];
			}
		}
		return productosAnual;  // Devolvemos el total de producción anual
	}

	// Función para mostrar todos los datos de producción ingresados
	private static void mostrarlosdatos(Scanner sc) {
		String[] fabricasOrdenadas = getOrdenarArray(numfabrica, nombrefabrica);  // Ordenar las fábricas

		// Iteramos sobre las fábricas y automóviles para mostrar las producciones por mes
		for (int i = 0; i < numfabrica; i++) {
			System.out.println("FABRICA: " + fabricasOrdenadas[i]);
			int indice = indicefabrica(fabricasOrdenadas[i]);
			for (int j = 0; j < numautomovil; j++) {
				System.out.println("MODELO: " + nombreautomovil[j]);
				for (int x = 0; x < MAXMESES; x++) {
					if (produccion[indice][j][x] != -1) {  // Solo mostramos si hay datos registrados
						System.out.println("MES: " + (x + 1) + " " + produccion[indice][j][x]);
					}
				}
			}
		}
	}

	// Función para ordenar un array alfabéticamente
	private static String[] getOrdenarArray(int numElementos, String[] array) {
		String[] arrayOrdenado = Arrays.copyOf(array, numElementos);  // Copiamos el array
		Arrays.sort(arrayOrdenado);  // Ordenamos alfabéticamente
		return arrayOrdenado;  // Devolvemos el array ordenado
	}

	// Función para introducir datos de producción de un automóvil en una fábrica
	private static void introducirdatos(Scanner sc) {
		System.out.println("Introduce el nombre de la fábrica:");
		String fabrica = sc.next();  // Leer el nombre de la fábrica
		if (comprobarfabrica(fabrica)) {  // Si la fábrica es nueva, la añadimos
			nombrefabrica[numfabrica] = fabrica;
			numfabrica++;
		}

		System.out.println("Introduce el nombre del modelo de automóvil:");
		String automovil = sc.next();  // Leer el nombre del automóvil
		if (comprobarautomovil(automovil)) {  // Si el automóvil es nuevo, lo añadimos
			nombreautomovil[numautomovil] = automovil;
			numfabrica++;
		}

		// Leer el mes y la cantidad de producción
		System.out.println("Introduce el número del MES:");
		int mes = sc.nextInt();

		System.out.println("Introduce la cantidad del producto en dicho mes:");
		int cantidad = sc.nextInt();

		// Almacenar los datos de producción en la matriz
		produccion[indicefabrica(fabrica)][indiceautomovil(automovil)][mes - 1] = cantidad;
	}

	// Función para obtener el índice de un automóvil en el array
	private static int indiceautomovil(String automovil) {
		int indice = 0;
		while (indice < numautomovil && !automovil.equals(nombreautomovil[indice])) {
			indice++;
		}
		return indice;  // Devolvemos el índice del automóvil
	}

	// Función para obtener el índice de una fábrica en el array
	private static int indicefabrica(String fabrica) {
		int indice = 0;
		while (indice < numfabrica && !fabrica.equals(nombrefabrica[indice])) {
			indice++;
		}
		return indice;  // Devolvemos el índice de la fábrica
	}

	// Función para comprobar si un automóvil ya existe
	private static boolean comprobarautomovil(String automovil) {
		for (String c : nombreautomovil) {
			if (automovil.equals(c)) {
				return false;  // Si el automóvil ya existe, devolvemos false
			}
		}
		return true;  // Si no existe, devolvemos true
	}

	// Función para comprobar si una fábrica ya existe
	private static boolean comprobarfabrica(String fabrica) {
		for (String c : nombrefabrica) {
			if (fabrica.equals(c)) {
				return false;  // Si la fábrica ya existe, devolvemos false
			}
		}
		return true;  // Si no existe, devolvemos true
	}

	// Función para inicializar la matriz de producción con -1 (sin datos)
	private static void inicializarDatos() {
		for (int i = 0; i < MAXFABRICA; i++) {
			for (int j = 0; j < MAXAUTO; j++) {
				for (int x = 0; x < MAXMESES; x++) {
					produccion[i][j][x] = -1;  // Inicializamos con -1 para indicar que no hay datos
				}
			}
		}
	}
}
