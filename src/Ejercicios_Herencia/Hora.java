package Ejercicios_Herencia;

public class Hora {

	
	private int hora;
	private int minuto;
	
	
	
	public Hora(int hora, int minuto) {
		this.hora = hora;
		this.minuto = minuto;
	}

	
	public void inc () {
		this.minuto++;
		if (this.minuto==60) {
			this.hora++;
			this.minuto=0;
		}
	}


	public int getHora() {
		return hora;
	}


	public void setHora(int hora) {
		
		if (this.hora>=0 && this.hora<24) {
			this.hora = hora;
			
	}
	}


	@Override
	public String toString() {
		return hora + ":" + minuto ;
		
		
	}


	public int getMinuto() {
		return minuto;
	}


	public void setMinuto(int minuto) {
		
		if (this.minuto>=0 && this.minuto<60) {
			this.minuto = minuto;
			
		}
		
	}
	
	
}
