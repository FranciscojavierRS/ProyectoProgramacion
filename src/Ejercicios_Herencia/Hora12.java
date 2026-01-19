package Ejercicios_Herencia;

public class Hora12 extends Hora {
	
	public Hora12(int hora, int minuto) {
		super(hora, minuto);
		
	}

	@Override
	public String toString() {
		String horario="AM";
		int hora= this.getHora();
		if (this.getHora()>=12) {
			horario = "PM";
			hora=hora%12;
		}
		return hora + ":" + this.getMinuto()+" "+horario ;
	}

}
