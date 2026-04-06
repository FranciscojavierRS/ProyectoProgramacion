package EjerciciosAngelExcepciones;

import java.util.Objects;

/*
 * Create primero una clase llamada Coche cuyos atributos son nombre (String) numero de asientos (entero) y precio (double). 

Dos coches son iguales si tienen el mismo nombre. El criterio de ordenacion es por nombre y numero de asientos.

Create otra clase principal con un mapa con clave Coche y valor entero para representar la cantidad que hay de cada coche. el metodo main de esta clase debe de leer de un fichero txt con coches en cada linea con el formato nombre,numeroAsientos,precio e insertarlo en el mapa. Si insertas por primera vez un coche, le pones cantidad 1. Si ya existia, le incrementas la cantidad.

Todo esto imprimelo por pantalla y escribelo en otro fichero txt
1- Muestrame la lista de coches ordenada.
2- Muestra el coche con mayor cantidad
3- Muestra la media de precios de los coches
 */

public class Coche implements Comparable<Coche> {

	private String nombre;
	private int numeroAsientos;
	private double precio;

	public Coche(String nombre, int numeroAsientos, double precio) {
		super();
		this.nombre = nombre;
		this.numeroAsientos = numeroAsientos;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroAsientos() {
		return numeroAsientos;
	}

	public void setNumeroAsientos(int numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Coche))
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Coche o) {

		int variable = this.nombre.compareTo(o.nombre);
		if (variable == 0) {
			variable = this.numeroAsientos - o.numeroAsientos;
		}
		return variable;
	}

}
