package EjerciciosAngelExcepciones;

import java.util.Objects;

public class Coche  implements Comparable<Coche> {
	
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
		if(variable==0) {
			variable = this.numeroAsientos-o.numeroAsientos;
		}
		return variable;
	}
	
	

}
