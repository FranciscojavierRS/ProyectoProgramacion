package PSP_TEMA2_BOL4;


public class Semaforo extends Thread {

	private int colorSemaforo;
	ClaseCompartida claseComp;	

	public Semaforo(int colorSemaforo, ClaseCompartida c) {
		super(String.valueOf(colorSemaforo));
		this.colorSemaforo = colorSemaforo;
		this.claseComp = c;
	}

	public void run() {		
		for (int i = 0; i < 10; i++) {
			claseComp.decididorTurno(colorSemaforo);
		}
	}

}
