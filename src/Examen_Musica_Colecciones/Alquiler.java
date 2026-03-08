package Examen_Musica_Colecciones;

import java.util.Objects;

//se comparan/ordenan en caso de ser necesario por codLocal, fechaDesede y grupo
public class Alquiler {
	private int codLocal;
	private Fecha fechaDesde;
	private int duracionEnMeses;
	private Grupo grupo;

	public Alquiler(int codLocal, Fecha fechaDesde, int duracionEnMeses, Grupo grupo) {
		super();
		this.codLocal = codLocal;
		this.fechaDesde = fechaDesde;
		this.duracionEnMeses = duracionEnMeses;
		this.grupo = grupo;
	}

	public int getCodLocal() {
		return codLocal;
	}

	public void setCodLocal(int codLocal) {
		this.codLocal = codLocal;
	}

	public Fecha getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Fecha fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public int getDuracionEnMeses() {
		return duracionEnMeses;
	}

	public void setDuracionEnMeses(int duracionEnMeses) {
		this.duracionEnMeses = duracionEnMeses;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codLocal, fechaDesde, grupo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alquiler))
			return false;
		Alquiler other = (Alquiler) obj;
		return codLocal == other.codLocal && Objects.equals(fechaDesde, other.fechaDesde)
				&& Objects.equals(grupo, other.grupo);
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "\nAlquiler [codLocal=" + codLocal + ", fechaDesde=" + fechaDesde + ", duracionEnMeses="
				+ duracionEnMeses + ", grupo=" + grupo + "]";
	}

}
