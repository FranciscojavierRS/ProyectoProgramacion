package pruebasJunit;

public class Prueba {

	public boolean diaValido(int dia) {
		if(dia >= 1 && dia <=7) {
			return true;
		}else {
			return false;
		}
	}
	
	public int multiplica(int num1, int num2) {
		return num1*num2;
	}
	
}
