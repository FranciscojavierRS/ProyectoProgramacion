package ExamenSemanaSantaExcepciones;

import java.util.Objects;

public class Parada implements Comparable<Parada> {
	private String nombre;
	private Hora horaPrevista;
	
	public Parada(String nombre, Hora horaPrevista) {
		super();
		this.nombre = nombre;
		this.horaPrevista = horaPrevista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Hora getHoraPrevista() {
		return horaPrevista;
	}

	public void setHoraPrevista(Hora horaPrevista) {
		this.horaPrevista = horaPrevista;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Parada))
			return false;
		Parada other = (Parada) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Parada [nombre=" + nombre + ", horaPrevista=" + horaPrevista + "]";
	}

	@Override
	public int compareTo(Parada o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.nombre);
	}

	
	
}
