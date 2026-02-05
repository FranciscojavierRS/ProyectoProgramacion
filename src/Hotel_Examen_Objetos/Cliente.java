package Hotel_Examen_Objetos;

public class Cliente {
	private String nombre;

	public Cliente(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return "cliente " + this.nombre;
	}

}