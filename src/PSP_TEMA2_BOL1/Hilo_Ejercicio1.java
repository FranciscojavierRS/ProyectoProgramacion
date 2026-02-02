package PSP_TEMA2_BOL1;

public class Hilo_Ejercicio1  extends Thread{
	
	private String texto;
	private boolean ejecutando = false;

	public Hilo_Ejercicio1(String texto) {
		super();
		this.texto = texto;
	}
	
	
	public void run () {
		this.ejecutando = true;
		while (ejecutando) {
			System.out.println(this.texto);
		}
	}
	// El metodo parar es lo que diferencia el ejercicio 1 de la Version 2
	public void parar() {
		this.ejecutando = false;
	}

}
