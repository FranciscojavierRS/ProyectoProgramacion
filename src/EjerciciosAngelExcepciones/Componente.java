package EjerciciosAngelExcepciones;

import java.io.Serializable;
import java.util.Objects;

public class Componente implements Comparable<Componente>, Serializable {

	/*
	 * /* 1. Modelo de Datos (POO) Crea una clase única llamada Componente:
	 * Atributos: id (int), nombre (String), categoria (String), stock (int) y
	 * precioUnitario (double). Un componente es igual a otro si tiene el mismo id.
	 * Criterio de ordenación: Por categoria y, en caso de empate, por nombre. 2.
	 * Paso 1: Importación de datos (Texto a Objetos) Lee un fichero de texto
	 * llamado nuevos_componentes.txt con el siguiente formato:
	 * ID;Nombre;Categoria;Stock;Precio (Nota: el separador es punto y coma ;). Lee
	 * cada línea y crea un objeto Componente. Guarda los objetos en un
	 * ArrayList<Componente>. 3. Paso 2: Persistencia Binaria (Escritura y Lectura)
	 * Escritura: Guarda la lista completa de componentes en un fichero binario
	 * llamado almacen.dat. Lectura: En el método main, sobreescribe la lista
	 * leyendo el fichero almacen.dat ​4. Paso 3: Procesamiento e Informe (Objetos a
	 * Texto) ​Genera un archivo reporte_inventario.txt con la siguiente
	 * información: ​La lista de todos los componentes ordenados según el criterio
	 * definido en el paso 1. ​Conteo por categoría: Indica cuántos componentes hay
	 * de cada categoría (ej: "Procesadores: 5", "RAM: 3") Valor del inventario:
	 * Suma total de stock * precioUnitario de todos los productos. El nombre del
	 * componente que tiene menos unidades en stock (el más próximo a agotarse).
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String categoria;
	private int stock;
	private double precioUnitario;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Componente))
			return false;
		Componente other = (Componente) obj;
		return id == other.id;
	}

	public Componente(int id, String nombre, String categoria, int stock, double precioUnitario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public int compareTo(Componente o) {

		int variable = this.categoria.compareTo(o.categoria);
		if (variable == 0) {
			variable = this.nombre.compareTo(o.nombre);
		}

		return variable;
	}

}
