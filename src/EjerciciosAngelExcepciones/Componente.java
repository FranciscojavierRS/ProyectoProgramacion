package EjerciciosAngelExcepciones;

import java.io.Serializable;
import java.util.Objects;

public class Componente implements Comparable<Componente>, Serializable{

	/**
	 * 
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
		if (variable==0) {
			variable = this.nombre.compareTo(o.nombre);
		}
		
		
		return variable;
	}

}
