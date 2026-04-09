package ObjetosAngel;

public class ListaPilotos {
	public Piloto[] tabla;
	public int numPilotos;

	public ListaPilotos() {
		this.tabla = new Piloto[10]; // Tamaño por defecto para el examen
		this.numPilotos = 0;
	}

	// --- MÉTODOS A IMPLEMENTAR ---

	/*
	 * a) (1 Punto) public int buscarPiloto(Piloto p) en ListaPilotos. Debe devolver
	 * el índice donde se encuentra el piloto en la tabla. Si no existe, devolver
	 * -1.
	 */
	// a) public int buscarPiloto(Piloto p)

	public int buscarPiloto(Piloto p) {

		for (int i = 0; i < this.numPilotos; i++) {
			if (tabla[i].equals(p)) {
				return i;
			}
		}

		return -1;
	}

}
