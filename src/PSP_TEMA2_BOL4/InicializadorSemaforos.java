
package PSP_TEMA2_BOL4;


public class InicializadorSemaforos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClaseCompartida claseComp = new ClaseCompartida();
		
		Semaforo hilo0 = new Semaforo(0, claseComp);
		Semaforo hilo1 = new Semaforo(1, claseComp);
		Semaforo hilo2 = new Semaforo(2, claseComp);		
		
		hilo0.start();
		hilo1.start();
		hilo2.start();
	}
}
