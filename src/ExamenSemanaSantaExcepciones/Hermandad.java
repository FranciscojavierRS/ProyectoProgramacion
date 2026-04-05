package ExamenSemanaSantaExcepciones;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Hermandad {
	private String nombre;
	private int numHermanos;
	
	//en el mapa paradasVisitadas el booleano indica si la hermandad ya ha pasado por la parada o no
	private TreeMap<Parada, Boolean> paradasVisitadas = new TreeMap<Parada, Boolean>();
	
	public Hermandad(String nombre, int numHermanos) {
		this.nombre = nombre;
		this.numHermanos = numHermanos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumHermanos() {
		return numHermanos;
	}

	public void setNumHermanos(int numHermanos) {
		this.numHermanos = numHermanos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Hermandad))
			return false;
		Hermandad other = (Hermandad) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public TreeMap<Parada, Boolean> getParadasVisitadas() {
		return paradasVisitadas;
	}

	@Override
	public String toString() {
		return "Hermandad [nombre=" + nombre + ", numHermanos=" + numHermanos + /*", paradas=" + paradasVisitadas +*/ "]";
	}

	//d) 
	public boolean haPasadoPorMasDe(int numParadas) {
		int contadorParadasVisitadas = 0;
		
		for (Map.Entry<Parada, Boolean> entry : paradasVisitadas.entrySet()) {
			if(entry.getValue()) {
				contadorParadasVisitadas++;
			}
		}

		return contadorParadasVisitadas>numParadas;
	}

	

	
}
