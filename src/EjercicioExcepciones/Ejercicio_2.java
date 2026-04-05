package EjercicioExcepciones;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Ejercicio 2: Manejo de excepciones en entrada de datos
 * Este ejercicio demuestra el manejo de InputMismatchException al leer datos del usuario
 * cuando se espera un número entero pero se introduce otro tipo de dato.
 */
public class Ejercicio_2 {

	public static void main(String[] args) {

		// Llamamos al método que pide un entero al usuario
		pedirEntero();

	}

	/**
	 * Método que solicita al usuario un número entero y maneja excepciones
	 * de entrada inválida.
	 */
	public static void pedirEntero() {

		// Creamos un objeto Scanner para leer datos desde la consola
		Scanner sc = new Scanner(System.in);

		try {
			// Solicitamos al usuario que introduzca un número entero
			System.out.print("Introduce un número entero: ");
			// Intentamos leer un entero desde la entrada del usuario
			int numero = sc.nextInt();
			// Si la entrada es correcta, mostramos el número introducido
			System.out.println("Número introducido: " + numero);

		} catch (InputMismatchException e) {
			// Capturamos la excepción cuando el usuario introduce un valor no numérico
			System.out.println("Error: " + e.getMessage());
			// Mensaje más claro para el usuario
			System.out.println("Por favor, introduce un número entero válido.");
		}
	}
}