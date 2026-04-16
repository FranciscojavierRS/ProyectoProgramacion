package Examen_Febrero_Atleta_Objetos;

import java.util.Objects;

public class Atleta implements Comparable<Atleta> {
	private String nombre;
	private int medallasOro;
	private ListaAtletas rivales;

	// Constructor: inicializa nombre, medallas y crea lista vacía de rivales
	public Atleta(String nombre, int medallasOro) {
		this.nombre = nombre;
		this.medallasOro = medallasOro;
		this.rivales = new ListaAtletas();
	}

	// hashCode basado SOLO en el nombre (porque define igualdad)
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	// Dos atletas son iguales si tienen el mismo nombre
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Atleta))
			return false;
		Atleta other = (Atleta) obj;
		return Objects.equals(nombre, other.nombre);
	}

	// Getters
	public ListaAtletas getRivales() {
		return rivales;
	}

	public String getNombre() {
		return nombre;
	}

	public int getMedallasOro() {
		return medallasOro;
	}

	// Setters
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
	/*
	 * Añade un rival SOLO si:
	 * 1. No está ya en la lista
	 * 2. No es el propio atleta
	 */
	public void registrarRival(Atleta a) {

		// Comprueba que no esté ya y que no sea él mismo
		if (!rivales.contieneAtleta(a) && !a.equals(this)) {
			rivales.anyadeAtleta(a); // lo añade
		}

	}

	// Apartado f)
	/*
	 * Devuelve una lista con los rivales comunes entre este atleta y otro
	 * Sin duplicados
	 */
	public ListaAtletas rivalesEnComun(Atleta otro) {

		ListaAtletas res = new ListaAtletas(); // lista resultado

		// Recorre mis rivales
		for (int i = 0; i < this.getRivales().getNumAtletas(); i++) {
			Atleta obj = this.getRivales().getAtleta(i);

			// Si también es rival del otro y no está ya en la lista resultado
			if (otro.getRivales().contieneAtleta(obj) && !res.contieneAtleta(obj)) {
				res.anyadeAtleta(obj); // lo añade
			}
		}
		return res;
	}

	@Override
	public String toString() {
		String nombresRivales = "[";

		// Construye string con nombres de rivales
		for (int i = 0; i < this.rivales.getNumAtletas(); i++) {
			nombresRivales += rivales.getAtleta(i).nombre;
			if (i < this.rivales.getNumAtletas() - 1) {
				nombresRivales += ", ";
			}
		}

		nombresRivales += "]";

		return "Atleta [nombre=" + nombre + ", medallasOro=" + medallasOro + ", rivales=" + nombresRivales + "]";
	}

	// Orden natural:
	// 1. Más medallas primero (descendente)
	// 2. Si empate → orden alfabético
	@Override
	public int compareTo(Atleta o) {

		int variable = o.medallasOro - this.medallasOro; // orden descendente

		if (variable == 0) {
			variable = this.nombre.compareTo(o.nombre); // desempate alfabético
		}

		return variable;
	}

}