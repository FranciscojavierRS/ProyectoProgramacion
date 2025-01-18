package Tarea1_POO_Clases;

public class CuentaCorriente {

	private double saldo;
	private double limiteDescubierto;
	public String nombreTitular;
	 String dniTitular;
	 private static Banco banco;
	 
	 public void cambiarBanco(Banco banco) {
		 this.banco=banco;
	 }
	
	public  CuentaCorriente(String nombreTitular, String dniTitular) {
		this.nombreTitular= nombreTitular;
		this.dniTitular= dniTitular;
		this.saldo= 0;
		this.limiteDescubierto= -50;
	}
	
	public  CuentaCorriente(double saldo) {
		this.nombreTitular= "";
		this.dniTitular= "";
		this.saldo= saldo;
		this.limiteDescubierto= 0;
	}
	
	public  CuentaCorriente(double saldo, double limiteDescubierto,String dniTitular) {
		this.nombreTitular="";
		this.dniTitular= dniTitular;
		this.saldo= saldo;
		this.limiteDescubierto= limiteDescubierto;
	}
	public boolean sacarDinero(double cantidad) {
		if ((this.saldo-cantidad)<this.limiteDescubierto) {
			System.out.println("LIMITE DE DESCUBIERTO SUPERADO");
			return false;
		}
		this.saldo=this.saldo-cantidad;
		return true;
	}
	
	public void ingresarDinero (double cantidad) {
		this.saldo=this.saldo+cantidad;
	}
	
	public void mostrarInformacion () {
		System.out.println("Banco: "+this.banco+" Nombre de titular: "+this.nombreTitular+
				" DNI titular: "+this.dniTitular+" Saldo "+this.saldo+" Limite descubierto: "+this.limiteDescubierto);
	}
}
