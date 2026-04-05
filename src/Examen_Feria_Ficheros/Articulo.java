package Examen_Feria_Ficheros;

public class Articulo implements Comparable<Articulo> {
	private String denominacion;
	private String tamanyo;

	public Articulo(String denominacion, String tamanyo) {
		super();
		this.denominacion = denominacion;
		this.tamanyo = tamanyo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + ((tamanyo == null) ? 0 : tamanyo.hashCode());
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
		if (tamanyo == null) {
			if (other.tamanyo != null)
				return false;
		} else if (!tamanyo.equals(other.tamanyo))
			return false;
		return true;
	}

	public int compareTo(Articulo otro) {
		int res;

		res = this.denominacion.compareTo(otro.denominacion);
		if (res == 0)
			res = this.tamanyo.compareTo(otro.tamanyo);
		return res;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(String tamanyo) {
		this.tamanyo = tamanyo;
	}

	@Override
	public String toString() {
		return this.denominacion + " " + this.tamanyo;
	}
}
