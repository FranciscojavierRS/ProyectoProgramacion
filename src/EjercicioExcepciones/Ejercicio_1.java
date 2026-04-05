package EjercicioExcepciones;

/**
 * Ejercicio 1: Manejo de excepciones en arrays
 * Este ejercicio demuestra el manejo de NullPointerException y ArrayIndexOutOfBoundsException
 * al buscar elementos en un array que puede contener valores nulos.
 */
public class Ejercicio_1 {

	public static void main(String[] args) {
		
		try {
			// Creamos un array con un valor null para provocar una excepción
			Integer[] array = {1, 2, null, 4};

			// Buscamos el elemento 2 en el array
			int posicion = buscarElemento(array, 2);
			System.out.println("Elemento encontrado en posición: " + posicion);

		} catch (NullPointerException e) {
			// Capturamos la excepción cuando hay un valor nulo en el array
			System.out.println("Error: hay un valor nulo en el array");

		} catch (ArrayIndexOutOfBoundsException e) {
			// Capturamos la excepción cuando se accede a una posición inválida del array
			System.out.println("Error: se ha accedido a una posición inválida");
		}

	}

	/**
	 * Método que busca un elemento en un array de Integer
	 * @param array El array donde buscar (puede contener valores nulos)
	 * @param valor El valor a buscar
	 * @return La posición del elemento encontrado, o -1 si no se encuentra
	 * @throws NullPointerException Si el array contiene valores nulos
	 * @throws ArrayIndexOutOfBoundsException Si se accede a una posición inválida
	 */
	public static int buscarElemento(Integer[] array, int valor)
			throws NullPointerException, ArrayIndexOutOfBoundsException {

		// Recorremos el array elemento por elemento
		for (int i = 0; i < array.length; i++) {

			// Verificamos si el elemento actual es nulo
			if (array[i] == null) {
				// Lanzamos una excepción si encontramos un valor nulo
				throw new NullPointerException("El array contiene valores nulos");
			}

			// Comparamos el elemento actual con el valor buscado
			if (array[i] == valor) {
				// Devolvemos la posición si encontramos el elemento
				return i;
			}
		}

		// Devolvemos -1 si no encontramos el elemento en todo el array
		return -1; // No encontrado
	}
}