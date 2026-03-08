package Examen_Musica_Colecciones;

import java.util.Objects;

public class FechaHora extends Fecha implements Comparable<FechaHora> {
	private int hora;
	private int minuto;
	private int segundo;

	public FechaHora(int dia, int mes, int anyo, int hora, int minuto, int segundo) {
		super(dia, mes, anyo);
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}

	public int getHora() {
		return hora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hora, minuto, segundo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof FechaHora))
			return false;
		FechaHora other = (FechaHora) obj;
		return hora == other.hora && minuto == other.minuto && segundo == other.segundo;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	@Override
	public int compareTo(FechaHora o) {
		int res = this.anyo - o.anyo;

		if (res == 0) {
			res = this.mes - o.mes;
		}
		if (res == 0) {
			res = this.dia - o.dia;
		}
		if (res == 0) {
			res = this.hora - o.hora;
		}
		if (res == 0) {
			res = this.minuto - o.minuto;
		}
		if (res == 0) {
			res = this.segundo - o.segundo;
		}
		return res;
	}

	@Override
	public String toString() {
		return super.toString() + " " + hora + ":" + minuto + ":" + segundo;
	}
}
