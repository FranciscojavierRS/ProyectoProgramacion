package Examen_Febrero_Atleta_Objetos;

import java.util.Arrays;

public class ListaAtletas {
	private Atleta[] tabla = new Atleta[10]; // array inicial
	private int numAtletas = 0; // número real de atletas

	public ListaAtletas() {
	}

	public Atleta[] getTabla() {
		return tabla;
	}

	// Añade atleta al array (redimensiona si hace falta)
	public void anyadeAtleta(Atleta a) {
		if (numAtletas >= tabla.length) {
			tabla = Arrays.copyOf(tabla, numAtletas + 10);
		}
		tabla[numAtletas++] = a;
	}

	// Apartado a)
	/*
	 * Comprueba si un atleta está en la lista
	 */
	public boolean contieneAtleta(Atleta a) {

		// Recorre los elementos válidos
		for (int i = 0; i < numAtletas; i++) {
			if (tabla[i].equals(a)) {
				return true;
			}
		}

		return false;
	}

	public int getNumAtletas() {
		return numAtletas;
	}

	public Atleta getAtleta(int i) {
		return tabla[i];
	}

	@Override
	public String toString() {
		return "ListaAtletas [tabla=" + Arrays.toString(tabla) + "]";
	}

}