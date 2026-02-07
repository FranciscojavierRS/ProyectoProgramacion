package EjerciciosOrientadoObjetos;

public class CuentaCorriente {

	public CuentaCorriente(String nombre, String dNI) {
		super();
		this.saldo = 0;
		this.limiteDescubierto = -50;
		this.nombre = nombre;
		DNI = dNI;
	}
	
 public boolean	sacarDinero(double sacarDinero) {
	
	boolean valido= false;
	
	if (saldo-sacarDinero>=-50) {
		 valido=true;
		 this.saldo -=sacarDinero;
		 System.out.println("Fue posible llevar a 	cabo la transacción");
		
	}
	
	
	
	
	
		return valido;
	}
 
 public void agregarDinero (double ingreso) {
	 
	 saldo+=ingreso;
	 
	 
 }
 
 public void mostrarInformacion () {
	 
	 System.out.println("saldo: "+saldo);
	 System.out.println("limiteDescubierto: "+limiteDescubierto);
	 System.out.println("nombre: "+nombre);
	 System.out.println("DNI: "+DNI);

	 
	 
 }
 
 

	public static String getBanco() {
		
	return banco;
}

 public static void setBanco(String banco) {
	CuentaCorriente.banco = banco;
 }



	private double saldo;
	private double limiteDescubierto;
	public String nombre;
	 String DNI;
	 private static String banco;
}

	