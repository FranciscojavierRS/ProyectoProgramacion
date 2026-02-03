package Formula1_Examen_Objetos;

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

	// TODO c) La ordenaci�n natural de los pilotos es por puntos descendentemente
	// (los
	// de m�s puntos van antes).
	// A igualdad de puntos, se ordenan alfab�ticamente por nombre.
	// Este m�todo hace una copia del array de pilotos del modelo, la ordena por
	// este criterio, y la devuelve.
	public Piloto[] getPilotosOrdenados() {

		Piloto[] tPilotosOrdenados = Arrays.copyOf(tPilotos, tPilotos.length);
		Arrays.sort(tPilotosOrdenados);
		return tPilotosOrdenados;
	}

	// TODO d) A�o en el que ha habido m�s carreras
	public int anioMasCarreras() {

		/*
		 * Ponemos como valor por defecto el año de la primera carrera y una variable de
		 * MaxnumCarreras= 0; Recooremos el Arrays de Carreras y de cada carrera el año
		 * en el que se corrio recorremos de nuevo el Array para mirar cuantas carreras
		 * existen con ese año
		 */

		int maxnumCarreras = 0;
		int añoMasCarreras = tCarreras[0].getFecha().getAnyo();

		for (Carrera carrera : tCarreras) {
			int añoCarrera = carrera.getFecha().getAnyo();
			int contadorCarrera = 0;

			for (Carrera carrera2 : tCarreras) {
				if (carrera2.getFecha().getAnyo() == añoCarrera) {
					contadorCarrera++;
				}
			}

			if (contadorCarrera > maxnumCarreras) {
				maxnumCarreras = contadorCarrera;
				añoMasCarreras = añoCarrera;
			}
		}

		return añoMasCarreras;
	}

	// TODO e) Devuelve true si existe alg�n piloto que haya ganado al menos dos
	// veces en
	// el mismo circuito.
	// Dos circuitos son iguales si tienen el mismo nombre. Dos pilotos son iguales
	// si su nombre y nacionalidad son iguales.
	public boolean hayPilotoGanador2MismoCircuito() {
		
		/*
		 * Recorremos el Arrays de tCarreras por cada Carrera cogemos el getPilotoPosicion para obetener el piloto que quedro primero
		 * si ese piloto vuelve a quedar primero devolvemos true
		 */
		
		for (int i=0; i<tCarreras.length; i++) {
			Piloto piloto = tCarreras[i].getPilotoPosicion(1);
			for (int j=i+1; j<tCarreras.length; j++) { // Recorremos el Array empezando por el elemento siguiente de i por eso se pone lo de i+1 
				if (piloto.equals(tCarreras[j].getPilotoPosicion(1)) && tCarreras[i].getCircuito().equals(tCarreras[j].getCircuito())) {
					return true;
				}
			}
		}
		return false;
	}

}
