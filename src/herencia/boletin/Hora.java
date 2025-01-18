package herencia.boletin;

public class Hora {

	protected int hora;
	protected int minutos;

	public Hora(int hora, int minutos) {
		super();
		setHora(hora);
		setMinutos(minutos);
	}

	public int getHora() {
		return hora;
	}

	
	public void setHora(int hora) {
		if (hora >= 0 && hora < 24) {
			this.hora = hora;
		}
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		if (minutos >= 0 && minutos < 60) {
			this.minutos = minutos;
		}
	}
	
	public void inc() {
		if(this.minutos<59) {
			this.minutos++;
		}else {
			this.minutos=0;
			this.hora++;
			if(hora==24) {
				hora=0;
			}
		}
	}

	@Override
	public String toString() {
		String res="";
		if(hora<10) {
			res="0";
		}
		res=res+hora+":";
		if(minutos<10) {
			res+="0";
		}
		res+=minutos;
		return res;
	}

	
}

