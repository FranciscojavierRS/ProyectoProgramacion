package Examen_Febrero_Objetos;

public class Pais {
	private String nombre;
	private ListaAtletas atletas;

	public Pais(String nombre) {
		this.nombre = nombre;
		this.atletas = new ListaAtletas();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ListaAtletas getAtletas() {
		return atletas;
	}

	public void setAtletas(ListaAtletas atletas) {
		this.atletas = atletas;
	}

	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", atletas=" + atletas + "]";
	}

}
