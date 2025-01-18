package Tarea1_POO_Clases.ferroviaria;

public class Locomotora extends Maquinaria {

	private String matricula;
	private double potencia;
	private String añoFabricacion;
	private Mecanico mecanico;
	public Locomotora(String matricula, double potencia, String añoFabricacion, Mecanico mecanico) {
		super();
		this.matricula = matricula;
		this.potencia = potencia;
		this.añoFabricacion = añoFabricacion;
		this.mecanico = mecanico;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getPotencia() {
		return potencia;
	}
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	public String getAñoFabricacion() {
		return añoFabricacion;
	}
	public void setAñoFabricacion(String añoFabricacion) {
		this.añoFabricacion = añoFabricacion;
	}
	public Mecanico getMecanico() {
		return mecanico;
	}
	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}
	@Override
	public String toString() {
		return "Locomotora [matricula=" + matricula + ", potencia=" + potencia + ", añoFabricacion=" + añoFabricacion
				+ ", mecanico=" + mecanico + "]";
	}
}
