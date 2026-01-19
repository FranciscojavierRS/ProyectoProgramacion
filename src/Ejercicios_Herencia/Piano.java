package Ejercicios_Herencia;

public class Piano  extends Instrumento{

	@Override
	public void interpretar() {
		System.out.println("sonando como piano "+this.getNotas());
		
	}
	

}
