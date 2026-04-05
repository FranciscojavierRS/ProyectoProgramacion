package EjercicioExcepciones;

/**
 * Clase de excepción personalizada para representar el error cuando
 * un carácter no es una vocal.
 * 
 * Esta clase hereda de Exception, lo que la convierte en una excepción
 * verificada (checked exception) que debe ser manejada o declarada.
 */
public class NoVocalException extends Exception {

	/**
	 * Constructor de la excepción personalizada
	 * @param mensaje El mensaje descriptivo del error
	 */
	public NoVocalException(String mensaje) {
		// Llamamos al constructor de la clase padre (Exception) con el mensaje
		super(mensaje);
	}
}