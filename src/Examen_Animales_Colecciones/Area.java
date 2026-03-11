package Examen_Animales_Colecciones;

import java.util.Objects;

public class Area {

	private String nombre;
	private float extension;

	public Area(String nombre, float extension) {
		super();
		this.nombre = nombre;
		this.extension = extension;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getExtension() {
		return extension;
	}

	public void setExtension(float extension) {
		this.extension = extension;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Area))
			return false;
		Area other = (Area) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
