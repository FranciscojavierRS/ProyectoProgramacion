package Ejercicios_Herencia;

public class Campana  extends Instrumento{

	@Override
	public void interpretar() {
		System.out.println("sonando como campana "+this.getNotas());
		
	}

}
