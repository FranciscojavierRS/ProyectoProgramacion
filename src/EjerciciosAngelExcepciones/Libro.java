package EjerciciosAngelExcepciones;

import java.io.Serializable;
import java.util.Objects;

public class Libro implements Serializable {

	/**
	 * Ejercicio: Sistema de Gestión de Inventario de Biblioteca ​1. La Clase de
	 * Datos (POO) ​Crea una clase llamada Libro con: ​Atributos: isbn (String),
	 * titulo (String), cantidad (int) y precio (double).
	 * 
	 * ​2. Paso 1: Importación desde TXT (Lectura con Split) ​Imagina que tienes un
	 * archivo llamado datos_brutos.txt con este contenido (puedes crearlo
	 * manualmente para probar): 8401,El Quijote,5,15.50 9782,Fundacion,10,25.00
	 * 1234,Java Total,2,40.00 Crea un método que lea este archivo línea a línea y
	 * guarde cada libro en una lista. 3. Paso 2: Copia de Seguridad (Escritura
	 * Binaria) Toma el ArrayList resultante y escríbelo en un fichero binario
	 * llamado biblioteca.dat. 4. Paso 3: Recuperación y Reporte (Lectura Binaria y
	 * Escritura TXT) Lee el contenido de biblioteca.dat y cárgalo de nuevo en el
	 * programa. ​Genera un nuevo archivo de texto llamado inventario_final.txt que
	 * contenga: ​El título de todos los libros con su precio. ​El valor total del
	 * inventario (suma de cantidad * precio de cada libro). ​Una línea que diga
	 * cuál es el libro con más unidades en stock.
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String titulo;
	private int cantidad;
	private double precio;

	public Libro(String isbn, String titulo, int cantidad, double precio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Libro))
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}

}
