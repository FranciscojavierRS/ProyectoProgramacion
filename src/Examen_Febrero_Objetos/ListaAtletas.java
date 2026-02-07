package Examen_Febrero_Objetos;

import java.util.Arrays;

public class ListaAtletas {
	private Atleta[] tabla = new Atleta[10];
	private int numAtletas = 0;

	public ListaAtletas() {

	}

	public Atleta[] getTabla() {
		return tabla;
	}

	public void anyadeAtleta(Atleta a) {
		if (numAtletas >= tabla.length) {
			tabla = Arrays.copyOf(tabla, numAtletas + 10);
		}
		tabla[numAtletas++] = a;

	}

	// Apartado a)
	public boolean contieneAtleta(Atleta atleta) {

		boolean esta = false;

		for (int i = 0; i < numAtletas && !esta; i++) {
			// if (atleta.getNombre() !=atleta.getNombre([i]){
			esta = true;
		}
		return esta;

	}

	// return esta;
	// }

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
