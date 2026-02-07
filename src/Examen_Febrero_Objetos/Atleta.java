package Examen_Febrero_Objetos;

import java.util.Objects;

public class Atleta {
	private String nombre;
	private int medallasOro;
	private ListaAtletas rivales;

	public Atleta(String nombre, int medallasOro) {
		this.nombre = nombre;
		this.medallasOro = medallasOro;
		this.rivales = new ListaAtletas();
	}

	public ListaAtletas getRivales() {
		return rivales;
	}

	public String getNombre() {
		return nombre;
	}

	public int getMedallasOro() {
		return medallasOro;
	}

	public void setMedallasOro(int medallasOro) {
		this.medallasOro = medallasOro;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRivales(ListaAtletas rivales) {
		this.rivales = rivales;
	}

	// Apartado b)
	public void registrarRival(Atleta a) {
		/*
		 * 
		 */

		for (int i = 0; i < rivales.getNumAtletas(); i++) {
			Atleta rivalActual = rivales.getTabla()[i];
			// if(this.rivales.getTabla()[i]).equals(rivalActual) && !rivalActual
		}

	}

	// Apartado f)
	public ListaAtletas rivalesEnComun(Atleta otro) {

		ListaAtletas tablaRivalesComun = new ListaAtletas();

		for (int i = 0; i < rivales.getNumAtletas(); i++) {

		}

		return null;
	}

	@Override
	public String toString() {
		String nombresRivales = "[";
		for (int i = 0; i < this.rivales.getNumAtletas(); i++) {
			nombresRivales += rivales.getAtleta(i).nombre;
			if (i < this.rivales.getNumAtletas() - 1) {
				nombresRivales += ", ";
			}
			;

		}
		nombresRivales += "]";
		return "Atleta [nombre=" + nombre + ", medallasOro=" + medallasOro + ", rivales=" + nombresRivales + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
