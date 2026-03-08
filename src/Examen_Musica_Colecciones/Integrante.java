package Examen_Musica_Colecciones;

import java.util.Objects;

//se comparan/ordenan en caso de ser necesario por dni.
public class Integrante {
	private String nombre;
	private String dni;

	public Integrante(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Integrante))
			return false;
		Integrante other = (Integrante) obj;
		return Objects.equals(dni, other.dni);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "\n\tIntegrante [nombre=" + nombre + ", dni=" + dni + "]";
	}

}
