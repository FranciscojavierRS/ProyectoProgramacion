package EjerciciosAngelExcepciones;

import java.io.Serializable;
import java.util.Objects;

public class Alumno implements Comparable<Alumno>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String dni;
	private String nombre;
	private double notaMedia;

	public Alumno(String dni, String nombre, double notaMedia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.notaMedia = notaMedia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alumno))
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", notaMedia=" + notaMedia + "]";
	}

	@Override
	public int compareTo(Alumno o) {
		
		return (int) ((notaMedia-o.notaMedia)*1000); // compareTO pasando de int a Double
	}

}
