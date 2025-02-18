package TipoExamen_Objeto_formula1;

import java.util.Arrays;

public class ModeloDeDatos {
	Carrera[] tCarreras = new Carrera[0];
	Piloto[] tPilotos = new Piloto[0];
	Equipo[] tEquipos = new Equipo[0];

	public void anadeCarrera(Carrera carreraNueva) {
		tCarreras = Arrays.copyOf(tCarreras, tCarreras.length + 1);
		tCarreras[this.tCarreras.length - 1] = carreraNueva;
	}

	public void anadePiloto(Piloto pilotoNuevo) {
		tPilotos = Arrays.copyOf(tPilotos, tPilotos.length + 1);
		tPilotos[this.tPilotos.length - 1] = pilotoNuevo;
	}

	public void anadeEquipo(Equipo equipoNuevo) {
		tEquipos = Arrays.copyOf(tEquipos, tEquipos.length + 1);
		tEquipos[this.tEquipos.length - 1] = equipoNuevo;
	}

	//TODO c) La ordenaci�n natural de los pilotos es por puntos descendentemente (los
	// de m�s puntos van antes).
	// A igualdad de puntos, se ordenan alfab�ticamente por nombre.
	// Este m�todo hace una copia del array de pilotos del modelo, la ordena por
	// este criterio, y la devuelve.
	public Piloto[] getPilotosOrdenados() {
		return null;
	}

	// TODO d) A�o en el que ha habido m�s carreras
	public int anioMasCarreras() {
		return 0;
	}

	// TODO e) Devuelve true si existe alg�n piloto que haya ganado al menos dos
	// veces en
	// el mismo circuito.
	// Dos circuitos son iguales si tienen el mismo nombre. Dos pilotos son iguales
	// si su nombre y nacionalidad son iguales.
	public boolean hayPilotoGanador2MismoCircuito() {
		return false;
	}

}
