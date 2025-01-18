package Tarea1_POO_Clases.ferroviaria;

public class Maquinista extends Empleado {

	private String dni;
	private double sueldoMensual;
	private String rango;
	
	public Maquinista(String nombreCompleto, String dni, double sueldoMensual, String rango) {
		super(nombreCompleto);
		this.dni=dni;
		this.sueldoMensual=sueldoMensual;
		this.rango=rango;
		
	}

	@Override
	public String toString() {
		return "Maquinista [ nombreCompleto = "+getNombreCompleto()+" dni=" + dni + ", sueldoMensual=" + sueldoMensual
		+ ", rango=" + rango + "]";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual(double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

}
