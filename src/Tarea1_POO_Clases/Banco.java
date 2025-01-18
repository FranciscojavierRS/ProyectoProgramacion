package Tarea1_POO_Clases;

public class Banco {

	private String nombre;
	private double capital;
	private String direccionCentral;
	
	public Banco(String nombre, double capital, String direccionCentral) {
		this.nombre = nombre;
		this.capital = capital;
		this.direccionCentral = direccionCentral;
	}

	public Banco(String nombre, String direccionCentral) {
		this(nombre, 5200000.00, direccionCentral);
	}

	public String getNombre() {
		return nombre;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public String getDireccionCentral() {
		return direccionCentral;
	}

	public void setDireccionCentral(String direccionCentral) {
		this.direccionCentral = direccionCentral;
	}

	@Override
	public String toString() {
		return "Banco [nombre=" + nombre + "]";
	}
	
	
}
