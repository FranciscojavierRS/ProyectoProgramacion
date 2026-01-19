package Ejercicios_Herencia;

public abstract class Instrumento {
	
	private NotasMusicales notas []= new NotasMusicales[100];
	
	private int numNotas= 0;
	
	public void add(NotasMusicales nota) {
		
		if (numNotas<100) {
			notas[numNotas]=nota;
			numNotas++;
			
		}
		
	}
	
	
	public NotasMusicales[] getNotas() {
		return notas;
	}


	public abstract void interpretar ();
	
	

}
