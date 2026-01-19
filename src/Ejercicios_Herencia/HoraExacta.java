package Ejercicios_Herencia;

import java.util.Objects;

public class HoraExacta  extends Hora{
	
	@Override
	public int hashCode() {
		return Objects.hash(segundos, this.getMinuto(), this.getHora());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof HoraExacta))
			return false;
		HoraExacta other = (HoraExacta) obj;
		return segundos == other.segundos && this.getMinuto()== other.getMinuto() && this.getHora()== other.getHora();
	}
	
	private int segundos;

	public HoraExacta(int hora, int minuto, int segundos) {
		super(hora, minuto);
		this.segundos = segundos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		if (this.segundos>=0 && this.segundos<60) {
			this.segundos = segundos;
			
		}
	}
	public void inc () {
		this.segundos++;
		if (this.segundos==60) {
			super.inc();
			this.segundos=0;
		}
	}

	
	

}
