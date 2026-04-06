package EjerciciosAngelExcepciones;

import java.io.Serializable;
import java.util.Objects;

/*
 * Crea una clase Alumno con:
Atributos: dni (String), nombre (String) y notaMedia (double).
Un alumno es igual a otro si tiene el mismo dni
Orden natural: Por notaMedia de mayor a menor.

En una clase Principal, crea un HashSet<Alumno> y añade 5 alumnos (asegúrate de repetir un DNI para comprobar que el Set no lo admite).
Escribe todos los alumnos del HashSet en un fichero binario llamado estudiantes.dat

Imprime por pantalla y escribe en un fichero de texto:
1 Dame la lista de alumnos ordenada.
Al final del fichero, indica quién es el alumno con la nota más alta.
Indica cuántos alumnos tienen una nota superior a 5.
 */
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

		return (int) ((notaMedia - o.notaMedia) * 1000); // compareTO pasando de int a Double
	}

}
