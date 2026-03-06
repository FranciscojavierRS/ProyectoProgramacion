package Examen_Feria_Colecciones;

public class Socio {
	private String nombre;
	private int antiguedad;

	public Socio(String nombre, int antiguedad) {
		this.nombre = nombre;
		this.antiguedad = antiguedad;
	}

	public String toString() {
		return this.nombre;
	}

}
