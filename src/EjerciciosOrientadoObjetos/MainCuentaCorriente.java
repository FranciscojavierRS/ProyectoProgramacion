package EjerciciosOrientadoObjetos;

public class MainCuentaCorriente {

	public static void main(String[] args) {
		

		CuentaCorriente cc1 = new CuentaCorriente("Francisco Javier", "49134342V");
		cc1.agregarDinero(100);
		cc1.mostrarInformacion();
		CuentaCorriente.setBanco("Santander");
		
		System.out.println(CuentaCorriente.getBanco());
		
		

}
	
	
}