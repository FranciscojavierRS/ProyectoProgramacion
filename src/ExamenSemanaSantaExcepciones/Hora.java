package ExamenSemanaSantaExcepciones;

public class Hora implements Comparable<Hora> {
	private int horas;
	private int minutos;
	
	public Hora(int horas, int minutos) {
		this.horas = horas;
		this.minutos = minutos;
	}
	
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	@Override
	public String toString() {
		return horas + ":" + minutos;
	}

	@Override
	public int compareTo(Hora o) {
		int resultado = this.horas-o.horas;
		if (resultado== 0) {
			resultado = this.minutos-o.minutos;
		}
		return resultado;
	}
	
	
}
