package Examen_Inventario_Ficheros;

import java.io.Serializable;
import java.util.Objects;

class Producto implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private double precio;
	private int cantidad;

	public Producto(int id, String nombre, double precio, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	//dos productos son iguales si tienen el mismo id
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Producto{" + "id=" + id + ", nombre='" + nombre + '\'' + ", precio=" + precio + ", cantidad=" + cantidad
				+ '}';
	}
}
