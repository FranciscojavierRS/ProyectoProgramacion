package OrientadoAObjetosGuiado;

public class Alumno {

	String nombre;
	int edad;
	long expediente;

	public Alumno(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", expediente=" + expediente + "]";
	}

	public Alumno(String nombre, int edad, long expediente) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.expediente = expediente;
	}

}
