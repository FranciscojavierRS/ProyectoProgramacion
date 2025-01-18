package Tarea1_POO_Clases.ferroviaria;

public class JefeEstacion extends Empleado {

	private String dni;
	public JefeEstacion(String nombreCompleto, String dni) {
		super(nombreCompleto);
		this.dni=dni;
	}
	@Override
	public String toString() {
		return "JefeEstacion [nombreCompleto = "+getNombreCompleto()+" dni=" + dni + "]";
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

}
