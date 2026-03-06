package Examen_Feria_Colecciones;

public class Articulo implements Comparable<Articulo> {
	private String denominacion;
	private String tamanio;

	public Articulo(String denominacion, String tamanio) {
		super();
		this.denominacion = denominacion;
		this.tamanio = tamanio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + ((tamanio == null) ? 0 : tamanio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (tamanio == null) {
			if (other.tamanio != null)
				return false;
		} else if (!tamanio.equals(other.tamanio))
			return false;
		return true;
	}

	public int compareTo(Articulo otro) {
		int res;

		res = this.denominacion.compareTo(otro.denominacion);
		if (res == 0)
			res = this.tamanio.compareTo(otro.tamanio);
		return res;
	}

	public String getdenominacion() {
		return denominacion;
	}

	public void setdenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String gettamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	@Override
	public String toString() {
		return this.denominacion + " " + this.tamanio;
	}
}
