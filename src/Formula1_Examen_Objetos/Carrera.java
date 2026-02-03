package Formula1_Examen_Objetos;

import java.util.Arrays;

import Examen_Mamiferos_Objetos.Mamifero;

public class Carrera {
	private Circuito circuito;
	private Fecha fecha;
	private PilotoResultado[] pilotosResultados = new PilotoResultado[10];
	private int numPilotosResultados = 0;

	public Carrera(Circuito circuito, Fecha fecha) {
		super();
		this.circuito = circuito;
		this.fecha = fecha;
	}

	public Circuito getCircuito() {
		return circuito;
	}

	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public void addPilotoResultado(PilotoResultado pr) {
		if (this.pilotosResultados.length <= this.numPilotosResultados) {
			this.pilotosResultados = Arrays.copyOf(pilotosResultados, this.pilotosResultados.length + 1);
		}
		this.pilotosResultados[numPilotosResultados++] = pr;
	}

	// TODO a) Devuelve un array del tama�o justo con los equipos participantes en
	// la carrera (sin repetidos).
	// Dos equipos son iguales si su nombre es el mismo.
	public Equipo[] equiposParticipantes() {

		/*
		 * Creamos un Array de equipos vacio Recorro el Array pilotosResultados Cogemos
		 * el Piloto y a su vez en el equipo en el que corre Si ese equipo no esta en el
		 * Array lo insertamos y aumentamos en 1 el tamaño total
		 */

		Equipo[] equipos = new Equipo[0];

		for (PilotoResultado pilotoResultado : pilotosResultados) {

			if (pilotoResultado != null) { // Comprobamos que el elemento no es nulo

				Equipo equipoPiloto = pilotoResultado.getPiloto().getEquipo();

				if (!contieneEquipo(equipos, equipoPiloto)) {
					equipos = Arrays.copyOf(equipos, equipos.length + 1);
					// mamiferosEntreFechas[mamiferosEntreFechas.length - 1] = mamifero; [ COPIADO
					// DEL EXAMEN DE MAMIFEROS ]
					equipos[equipos.length - 1] = equipoPiloto;
				}
			}
		}

		return equipos;
	}

	private boolean contieneEquipo(Equipo[] equipos, Equipo equipo) {
		for (Equipo ekipo : equipos) {
			if (ekipo.getNombre().equals(equipo.getNombre())) {
				return true;
			}
		}
		return false;
	}

	// TODO b)Obtiene el Piloto que ha quedado en la posici�n que se indica por
	// par�metro
	public Piloto getPilotoPosicion(int posicionBuscada) {
		/*
		 * Antes de nada recorremos el Array de pilotosResultados tenemos que ver el
		 * resultado del PilotoResultado.Si la posicion del resultado es = a
		 * posicionBuscada, devolvemos el piloto del Piloto Resultado
		 */

		for (PilotoResultado pilotoResultado : pilotosResultados) {
			if (pilotoResultado.getResultado().getPosicionLlegada() == posicionBuscada) {
				return pilotoResultado.getPiloto();
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return "Carrera [nombreCircuito=" + circuito + ", fecha=" + fecha + ", resultados="
				+ Arrays.toString(pilotosResultados) + "]";
	}
}
