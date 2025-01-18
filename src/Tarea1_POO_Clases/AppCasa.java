package Tarea1_POO_Clases;

public class AppCasa {

	public static void main(String[] args) {
		 Bombilla[] bombillas = new Bombilla[] { new Bombilla(),new Bombilla(),new Bombilla(),new Bombilla(),new Bombilla()};
		 mostrarBombillas(bombillas);
		 pulsarInterruptor(bombillas, 0);
		 pulsarInterruptor(bombillas, 3);
		 mostrarBombillas(bombillas);
		 pulsarInterruptorGeneral();
		 mostrarBombillas(bombillas);
		 pulsarInterruptorGeneral();
		 mostrarBombillas(bombillas);
	}
	
	public static void mostrarBombillas(Bombilla[] bombillas) {
		System.out.println("Mostrando bombillas");
		for(Bombilla bombilla: bombillas) {
			if(bombilla.getEstado()) {
				System.out.println("Encendido");
			}else {
				System.out.println("Apagado");
			}
		}
		
		System.out.println("##############################");
	}
	
	public static void pulsarInterruptor(Bombilla[] bombillas,int interruptor) {
		bombillas[interruptor].pulsarInterruptor();
	}
	public static void pulsarInterruptorGeneral(){
		Bombilla.pulsarInterruptorGeneral();
	}

}
