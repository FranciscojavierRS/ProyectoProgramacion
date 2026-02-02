package Examen_Mamiferos_Objetos;

import java.util.Arrays;
import java.util.Comparator;

public class Zoologico {
	private Mamifero tMamiferos[];
	private Veterinario tVeterinarios[];

	public Zoologico() {
		this.tVeterinarios = new Veterinario[0];
		this.tMamiferos = new Mamifero[0];
	}

	public Mamifero[] gettMamiferos() {
		return tMamiferos;
	}

	public Veterinario[] gettVeterinarios() {
		return tVeterinarios;
	}

	public void addVeterinario(Veterinario veterinario) {
		this.tVeterinarios = Arrays.copyOf(this.tVeterinarios, this.tVeterinarios.length + 1);
		this.tVeterinarios[this.tVeterinarios.length - 1] = veterinario;
	}

	public void addMamifero(Mamifero mamifero) {
		this.tMamiferos = Arrays.copyOf(tMamiferos, this.tMamiferos.length + 1);
		tMamiferos[this.tMamiferos.length - 1] = mamifero;
	}

	/*
	 * devuelve todos los mam�feros que hayan nacido entre las fechas de inicio y
	 * fin que se pasan como par�metros.
	 */

	public Mamifero[] getMamiferosEntreFechas(Fecha inicio, Fecha fin) {

		/**
		 * Creamos un Array de Mamiferos Hacemos el for que recorre el Array de
		 * Mamiferos, por cada Mamifero miramos el dia de nacimiento Si el dia de
		 * nacimiento es Mayor o = que la fecha de inicio y <= que le fecha de fin, lo
		 * añadimos al Array
		 */

		Mamifero mamiferosEntreFechas[] = new Mamifero[0];
		for (Mamifero mamifero : tMamiferos) {
			if (mamifero.getDiaNacimiento().compareTo(inicio) >= 0 && mamifero.getDiaNacimiento().compareTo(fin) <= 0) {
				mamiferosEntreFechas = Arrays.copyOf(mamiferosEntreFechas, mamiferosEntreFechas.length + 1); // Esto
																												// aumenta
																												// en 1
																												// el
																												// tamaño
																												// del
																												// Array
				mamiferosEntreFechas[mamiferosEntreFechas.length - 1] = mamifero; // Insertamos el Mamifero
			}
		}
		return mamiferosEntreFechas;
	}

	public int getNVeterinariosMasDe(int minNumNacimientos) {

		/**
		 * Nos creamos un contador de Veterinarios que empiece en 0. Recorremos cada
		 * Veterinario.Por cada Veterinario iniciamos un contador de nacimientos a 0 y
		 * recorremos el Arrays de Mamiferos. Por cada Mamifero si el asistente es el
		 * veterinario que estamos viendo aumentamos el contador de nacimientos en +1.
		 * Una vez recorrido el Arrays de mamiferos si el contador de nacimientos es
		 * Mayor o igual a minNumNacimientos aumentamos en 1 el contador de
		 * Veterinarios. Una vez recorrido el Arrays de Veterinarios devolvemos el
		 * contador de Veterinarios
		 * 
		 */
		int contadorVeterinarios = 0;

		for (Veterinario veterinario : tVeterinarios) {
			int contadorNacimientos = 0;

			for (Mamifero mamifero : tMamiferos) {
				if (mamifero.getAsistente().equals(veterinario)) {
					contadorNacimientos++;

				}

			}
			if (contadorNacimientos >= minNumNacimientos) {
				contadorVeterinarios++;
			}
		}

		return contadorVeterinarios;
	}

	public boolean veterinarioPadresEHijo() {

		/**
		 * Vamos a recorremos el Arrays de Mamiferos en el cual tenemos tambien el dato
		 * de los veterinarios ahora en la clase Mamifero tenemos 2 metodos que es
		 * getpadre y getmadre.
		 * 
		 */
		for (Mamifero mamifero : tMamiferos) {
			if (mamifero.getAsistente().equals(mamifero.getPadre().getAsistente())
					&& mamifero.getAsistente().equals(mamifero.getMadre().getAsistente())) {
				return true;
			}
		}

		return false;
	}

	public void ordenarMamiferos() {
		//Arrays.sort(this.tMamiferos, Comparator.comparing( m -> m.nombre));
		Arrays.sort(tMamiferos, new Comparator<Mamifero>(){
			@Override
			public int compare(Mamifero m1, Mamifero m2) {
				return -1*(m1.nombre.compareTo(m2.nombre));
			}
		});
	}

	public boolean hayErroresEnFechas() {
		/*
		 * Recorro mamiferos Comprueba si el padre y la madre es distinto de null Si la
		 * fecha de nacimiento es Mayor que la fecha del padre/madre devuelvo true y
		 * corto el bucle
		 */

		for (Mamifero mamifero : tMamiferos) {
			if (mamifero.getPadre() != null && mamifero.getPadre() != null
					&& mamifero.getDiaNacimiento().compareTo(mamifero.getPadre().getDiaNacimiento()) >= 0
					&& mamifero.getDiaNacimiento().compareTo(mamifero.getMadre().getDiaNacimiento()) >= 0) {

				return true;
			}
		}
		return false;
	}
}
