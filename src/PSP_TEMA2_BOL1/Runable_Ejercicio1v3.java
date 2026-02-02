package PSP_TEMA2_BOL1;

public class Runable_Ejercicio1v3 implements Runnable{

	private Thread miHilo = null;
	
	private boolean ejecutando = false;
	
	public Runable_Ejercicio1v3(String texto) {
		super();
		this.miHilo = new Thread (this , texto);
		miHilo.start();
	}



	@Override
	public void run() {
		this.ejecutando = true;
		while (ejecutando) {
			System.out.println(this.miHilo.getName());
		}
		
	}
	public void parar() {
		this.ejecutando = false;
	}
}
