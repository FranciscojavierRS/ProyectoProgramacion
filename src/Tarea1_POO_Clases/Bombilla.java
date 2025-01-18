package Tarea1_POO_Clases;

public class Bombilla {
	private boolean estado;
	
	private static boolean interuptorGeneral=true;

	public void pulsarInterruptor() {
		this.estado=!this.estado;
	}
	public Bombilla() {
		this.estado=false;
	}
	
	public boolean getEstado() {
		if(interuptorGeneral) {
			return estado;
		}else {
			return false;
		}
	}
	
	public static void pulsarInterruptorGeneral() {
		interuptorGeneral=!interuptorGeneral;
	}

}
