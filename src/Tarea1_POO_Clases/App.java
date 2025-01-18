package Tarea1_POO_Clases;

public class App {

	public static void main(String[] args) {
		 CuentaCorriente c = new CuentaCorriente("fran", "123456789");
		 c.mostrarInformacion();
		 c.sacarDinero(90);
		 CuentaCorriente c2 = new CuentaCorriente("fran2", "123456789");
		 c.cambiarBanco(new Banco("BANCO", "direccion"));
		 c2.mostrarInformacion();
		 c.mostrarInformacion();
		 
		 CuentaCorriente c3 = new CuentaCorriente("fran", "123456789");
		 c3.mostrarInformacion();
	}

}
