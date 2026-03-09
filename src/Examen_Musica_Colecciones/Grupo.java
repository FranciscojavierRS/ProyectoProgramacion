package Examen_Musica_Colecciones;

import java.util.Objects;

//se comparan/ordenan en caso de ser necesario por nombre.
public class Grupo implements Comparable<Grupo>{
	private String nombre;
	private TipoMusica tipoMusica;

	public Grupo(String nombre, TipoMusica tipoMusica) {
		super();
		this.nombre = nombre;
		this.tipoMusica = tipoMusica;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Grupo))
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoMusica getTipoMusica() {
		return tipoMusica;
	}

	public void setTipoMusica(TipoMusica tipoMusica) {
		this.tipoMusica = tipoMusica;
	}

	@Override
	public String toString() {
		return "\nGrupo [nombre=" + nombre + ", tipoMusica=" + tipoMusica + "]";
	}

	@Override
	public int compareTo(Grupo o) {
		// TODO Auto-generated method stub
		return this.getNombre().compareTo(o.getNombre());
	}

}
