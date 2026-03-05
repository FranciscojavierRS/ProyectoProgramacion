package Ejercicio_Colecciones_CHATGPT;

import java.util.ArrayList;
import java.util.Iterator;

public class Alumno {

	public static void main(String[] args) {
		ArrayList<Alumno> lista = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			lista.add(new Alumno("Alumno" + i,  (Math.random() * 10)));
		}
		System.out.println(lista);
		Alumno alumnoMasNota = lista.get(0);
		double notaMaxima = alumnoMasNota.getNota();
		double sumaNota = 0;

		for (Alumno alumno : lista) {
			sumaNota += alumno.getNota();
			if (alumno.getNota() > notaMaxima) {
				alumnoMasNota = alumno;
				notaMaxima = alumno.getNota();
			}
		}
		System.out.println("El alumno con mayor nota es " + alumnoMasNota);
		System.out.println("La nota media es " + sumaNota /lista.size());

		Iterator<Alumno> iteradorLista = lista.iterator();

		for (; iteradorLista.hasNext();) {
			Alumno alumno = (Alumno) iteradorLista.next();
			if (alumno.getNota() < 5) {
				iteradorLista.remove();
			}
		}
		System.out.println(lista);

	}

	String nombre;
	double nota;

	public Alumno(String nombre, double nota) {
		super();
		this.nombre = nombre;
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nota=" + nota + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
}
