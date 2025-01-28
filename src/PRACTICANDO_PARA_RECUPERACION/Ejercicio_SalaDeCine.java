package PRACTICANDO_PARA_RECUPERACION;

import java.util.Scanner;

public class Ejercicio_SalaDeCine {
	// Definimos constantes para el número máximo de salas, días de la semana y asientos
	private static final int MAX_SALAS = 5; 
	private static final int MAX_DIAS = 7;  
	private static final int MAX_ASIENTOS = 50;
	
	// Matriz bidimensional que almacena las reservas de asientos, donde las filas son las salas y las columnas son los días
	private static int[][] reservas = new int[MAX_SALAS][MAX_DIAS]; 
	
	// Scanner para la entrada de datos del usuario
	private static Scanner sc = new Scanner(System.in); 

	public static void main(String[] args) {
		// Inicializar la matriz de reservas con 0 al comenzar
		inicializarDatos();

		int opcion = 0; // Variable para la opción seleccionada por el usuario

		// Bucle principal del menú interactivo
		while (opcion != 6) {
			// Mostrar las opciones del menú
			System.out.println(
					"1-Reservar un asiento en una sala para un día específico.\r\n" +
					"2-Mostrar las reservas actuales de todas las salas.\r\n" +
					"3-Mostrar el total de reservas de una sala específica durante toda la semana\n" +
					"4-Mostrar el día con mayor número de reservas en una sala dada\n" +
					"5-Mostrar la sala con la mayor cantidad de reservas totales durante la semana\n" +
					"6- Salir del programa");

			opcion = sc.nextInt(); // Leer la opción seleccionada
			switch (opcion) {
				case 1:
					// Opción para reservar un asiento
					reservarUnAsiento();
					break;
				case 2:
					// Opción para mostrar las reservas actuales
					mostrarlosdatos();
					break;
				case 3:
					// Opción para mostrar el total de reservas de una sala en la semana
					totalReservasSala();
					break;
				case 4:
					// Opción para mostrar el día con más reservas en una sala
					diaMayorReservas();
					break;
				case 5:
					// Opción para mostrar la sala con más reservas totales
					salaMayorReservas();
					break;
				default:
					break;
			}
		}

		sc.close(); // Cerrar el Scanner cuando se termina el programa
	}

	// Función para mostrar las reservas actuales de todas las salas y días
	private static void mostrarlosdatos() {
		// Recorre cada sala
		for (int sala = 0; sala < MAX_SALAS; sala++) {
			System.out.print("Sala " + (sala + 1) + ": ");
			// Recorre cada día para la sala actual y muestra el número de reservas
			for (int dia = 0; dia < MAX_DIAS; dia++) {
				System.out.print(reservas[sala][dia] + " ");
			}
			System.out.println(); // Salto de línea después de cada sala
		}
	}

	// Función para reservar un asiento en una sala para un día específico
	private static void reservarUnAsiento() {
		System.out.println("Introduce el número de la sala (1-5):");
		int sala = sc.nextInt(); // Leer el número de la sala
		
		System.out.println("Introduce el día de la semana (1-7):");
		int dia = sc.nextInt(); // Leer el número del día
		
		System.out.println("Introduce el número de asientos a reservar:");
		int asientos = sc.nextInt(); // Leer el número de asientos a reservar
		
		// Validar que los números de sala y día estén dentro del rango permitido
		if (sala >= 1 && sala <= MAX_SALAS && dia >= 1 && dia <= MAX_DIAS) {
			// Verificar si la cantidad de asientos a reservar no excede el máximo permitido
			if (reservas[sala - 1][dia - 1] + asientos <= MAX_ASIENTOS) {
				// Realizar la reserva sumando los asientos reservados
				reservas[sala - 1][dia - 1] += asientos;
				System.out.println("Reserva realizada con éxito.");
			} else {
				System.out.println("Error: No es posible reservar más de " + MAX_ASIENTOS + " asientos en un día.");
			}
		} else {
			System.out.println("Error: Datos inválidos. Inténtalo de nuevo.");
		}
	}

	// Función para mostrar el total de reservas en una sala durante toda la semana
	private static void totalReservasSala() {
		System.out.println("Introduce el número de la sala (1-5):");
		int sala = sc.nextInt(); // Leer el número de la sala
		
		// Verificar si el número de la sala es válido
		if (sala >= 1 && sala <= MAX_SALAS) {
			int total = 0; // Variable para almacenar el total de reservas en la semana
			// Sumar las reservas de todos los días de la sala seleccionada
			for (int dia = 0; dia < MAX_DIAS; dia++) {
				total += reservas[sala - 1][dia];
			}
			// Mostrar el total de asientos reservados en la semana para esa sala
			System.out.println("Total de asientos reservados en la sala " + sala + " durante la semana: " + total);
		} else {
			System.out.println("Sala inválida.");
		}
	}

	// Función para mostrar el día con mayor número de reservas en una sala
	private static void diaMayorReservas() {
		System.out.println("Introduce el número de la sala (1-5):");
		int sala = sc.nextInt(); // Leer el número de la sala
		
		// Verificar si el número de la sala es válido
		if (sala >= 1 && sala <= MAX_SALAS) {
			int diaMayor = 0; // Variable para almacenar el día con más reservas
			int maxReservas = reservas[sala - 1][0]; // Inicializar con las reservas del primer día
			
			// Recorrer los días de la sala seleccionada para encontrar el día con más reservas
			for (int dia = 1; dia < MAX_DIAS; dia++) {
				if (reservas[sala - 1][dia] > maxReservas) {
					maxReservas = reservas[sala - 1][dia];
					diaMayor = dia;
				}
			}
			// Mostrar el día con mayor número de reservas
			System.out.println("El día con mayor número de reservas en la sala " + sala + " es el día " + (diaMayor + 1) + " con " + maxReservas + " asientos reservados.");
		} else {
			System.out.println("Sala inválida.");
		}
	}

	// Función para mostrar la sala con mayor cantidad de reservas totales durante la semana
	private static void salaMayorReservas() {
		int salaMayor = 0; // Variable para almacenar el índice de la sala con más reservas
		int maxReservas = 0; // Variable para almacenar el número máximo de reservas
		
		// Recorrer cada sala
		for (int sala = 0; sala < MAX_SALAS; sala++) {
			int totalReservas = 0; // Variable para sumar las reservas de la sala actual
			
			// Sumar las reservas de todos los días de la sala actual
			for (int dia = 0; dia < MAX_DIAS; dia++) {
				totalReservas += reservas[sala][dia];
			}
			
			// Si la sala actual tiene más reservas que la anterior, actualizar los valores
			if (totalReservas > maxReservas) {
				maxReservas = totalReservas;
				salaMayor = sala;
			}
		}
		// Mostrar la sala con más reservas totales
		System.out.println("La sala con la mayor cantidad de reservas es la Sala " + (salaMayor + 1) + " con " + maxReservas + " reservas.");
	}

	// Inicializar las reservas con 0 al comienzo
	private static void inicializarDatos() {
		// Recorrer todas las salas y días y poner las reservas en 0
		for (int i = 0; i < MAX_SALAS; i++) {
			for (int j = 0; j < MAX_DIAS; j++) {
				reservas[i][j] = 0; // Inicializar todas las posiciones de la matriz en 0
			}
		}
	}
}
