package PSP_TEMA2_BOL4;

public class ClaseCompartida {
	private int turnoSemaforo=0;
	
	public synchronized void decididorTurno(int colorSemaforo) {
		try {
			while (colorSemaforo != turnoSemaforo) {
				wait();
			}
			System.out.println("v1 Soy hilo " + colorSemaforo);
			notifyAll();
			incrementaTurnoSemaforo();
			/* SOBRA 
			 * wait();*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getTurnoSemaforo() {
		return turnoSemaforo;
	}

	public void incrementaTurnoSemaforo() {
		if (turnoSemaforo == 2) {
			turnoSemaforo = 0;			
		} else {
			turnoSemaforo = turnoSemaforo + 1;
		}
	}	

}
