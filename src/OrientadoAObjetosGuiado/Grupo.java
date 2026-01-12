package OrientadoAObjetosGuiado;

import java.util.Arrays;

public class Grupo {

	String nombre;
	Profesor tutor;
	private static final int MAX = 30;
	Alumno[] alumnos;
	int numAlumnos;

	public Grupo(String nombre, Profesor tutor) {
		super();
		this.nombre = nombre;
		this.tutor = tutor;
		this.alumnos = new Alumno[MAX];
		this.numAlumnos = 0;

	}

	public boolean perteneceAlGrupo(Alumno alumno) {
		for (int i = 0; i < numAlumnos; i++) {

			if (alumnos[i].expediente == alumno.expediente) {
				return true;
			}

		}
		return false;
	}

	public boolean addAlumno(Alumno alumno) {
		if (this.numAlumnos == MAX) {
			return false;

		}

		for (int i = 0; i < numAlumnos; i++) {

			if (alumnos[i].nombre.equals(alumno.nombre)) {
				return false;
			}

		}

		this.alumnos[numAlumnos] = alumno;
		this.numAlumnos++;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", tutor=" + tutor + ", alumnos=" + Arrays.toString(alumnos)
				+ ", numAlumnos=" + numAlumnos + "]";
	}
}
