package ObjetosAngel;

public class Piloto implements Comparable<Piloto> {
	public String nombre;
	public int puntos;
	public ListaPilotos rivales;

	public Piloto(String nombre, int puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
		this.rivales = new ListaPilotos(); // Inicializa su propia lista de rivales
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Piloto other = (Piloto) obj;
		return nombre != null && nombre.equalsIgnoreCase(other.nombre);
	}

	@Override
	public int compareTo(Piloto otro) {
		// Ordenación natural: descendente por puntos [cite: 7]
		if (this.puntos != otro.puntos) {
			return otro.puntos - this.puntos;
		}
		// En caso de empate, alfabético por nombre [cite: 8]
		return this.nombre.compareToIgnoreCase(otro.nombre);
	}

	// --- MÉTODOS A IMPLEMENTAR ---

	/*
	 * b) (1.5 Puntos) public void marcarRival(Piloto p) en la clase Piloto. Añade
	 * al piloto p a la lista de rivales del piloto que invoca el método, pero solo
	 * si:
	 * 
	 * El rival no es el propio piloto (un piloto no es rival de sí mismo).
	 * 
	 * No estaba ya presente en su lista de rivales.
	 * 
	 * Hay espacio en el array de la lista de rivales.
	 */
	
	// b) public void marcarRival(Piloto p)

	public void marcarRival(Piloto p) {

		if (!this.equals(p) && rivales.buscarPiloto(p) == -1 && rivales.tabla.length != rivales.numPilotos) {
			rivales.tabla[rivales.numPilotos] = p;
			rivales.numPilotos++;
		}

	}

	// f) public ListaPilotos enemigosCruzados(Piloto otro)
	
	public ListaPilotos enemigosCruzados(Piloto otro) {
		
		ListaPilotos listaEnemigosCruzados = new ListaPilotos();
		
		for ( Piloto piloto : otro.rivales.tabla) {
			
			if(this.rivales.buscarPiloto(piloto)!= -1 && listaEnemigosCruzados.buscarPiloto(piloto)== -1) {
				listaEnemigosCruzados.tabla[listaEnemigosCruzados.numPilotos] = piloto;
				listaEnemigosCruzados.numPilotos++;
			}
		}
		return listaEnemigosCruzados;
	}
}