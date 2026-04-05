package EjercicioExcepciones;

/**
 * Ejercicio 3: Creación y manejo de excepciones personalizadas
 * Este ejercicio demuestra cómo crear una excepción personalizada (NoVocalException)
 * y utilizarla para validar si un carácter es una vocal.
 */
public class Ejercicio_3 {

	public static void main(String[] args) {

		try {
			// Probamos el método con una vocal
			comprobarVocal('a');
			
			// Probamos el método con una consonante (lanzará excepción)
			comprobarVocal('b');

		} catch (NoVocalException e) {
			// Capturamos nuestra excepción personalizada
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si un carácter es una vocal
	 * @param letra El carácter a comprobar
	 * @throws NoVocalException Si el carácter no es una vocal
	 */
	public static void comprobarVocal(char letra) throws NoVocalException {

		// Convertimos la letra a minúscula para facilitar la comparación
		letra = Character.toLowerCase(letra);

		// Verificamos si la letra no es ninguna de las vocales
		if (letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u') {
			// Lanzamos nuestra excepción personalizada si no es una vocal
			throw new NoVocalException("La letra no es una vocal");
		}

		// Si es una vocal, mostramos un mensaje confirmatorio
		System.out.println("Es una vocal");
	}
}