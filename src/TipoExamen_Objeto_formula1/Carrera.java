package TipoExamen_Objeto_formula1;

import java.util.Arrays;

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
		return null;
	}

	// TODO b)Obtiene el Piloto que ha quedado en la posici�n que se indica por
	// par�metro
	public Piloto getPilotoPosicion(int posicionBuscada) {
		return null;
	}

	@Override
	public String toString() {
		return "Carrera [nombreCircuito=" + circuito + ", fecha=" + fecha + ", resultados="
				+ Arrays.toString(pilotosResultados) + "]";
	}
}