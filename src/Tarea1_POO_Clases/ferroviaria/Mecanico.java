package Tarea1_POO_Clases.ferroviaria;

public class Mecanico extends Empleado {

	private String telefono;
	private String especialidad;
	
	public Mecanico(String nombreCompleto, String telefono, String especialidad) {
		super(nombreCompleto);
		this.telefono=telefono;
		this.especialidad=especialidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	@Override
	public String toString() {
		return "Mecanico [nombreCompleto = "+getNombreCompleto()+" telefono=" + telefono + ", especialidad=" + especialidad + "]";
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
