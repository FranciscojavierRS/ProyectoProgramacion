package OrientadoAObjetosGuiado;

public class Profesor {

	String nombre;
	int edad;
	String especialidad;

	public Profesor(String nombre, int edad, String especialidad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.especialidad = especialidad;

	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", edad=" + edad + ", especialidad=" + especialidad + "]";
	}

}
