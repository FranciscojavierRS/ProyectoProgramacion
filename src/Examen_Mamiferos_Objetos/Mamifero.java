package Examen_Mamiferos_Objetos;

public class Mamifero extends SerVivo {
	private Mamifero padre;
	private Mamifero madre;
	private Fecha diaNacimiento;
	private Veterinario asistente;

	public Mamifero(String nombre, Mamifero padre, Mamifero madre, Fecha diaNacimiento, Veterinario asistente) {
		super(nombre);
		this.padre = padre;
		this.madre = madre;
		this.diaNacimiento = diaNacimiento;
		this.asistente = asistente;
	}

	// getters y setters preparados para que no de NullPointerException si no tiene
	// padre o madre
	public Mamifero getPadre() {
		if (this.padre == null) {
			padre = new Mamifero(null, null, null, null, null);
		}
		return padre;
	}

	public Mamifero getMadre() {
		if (this.madre == null) {
			madre = new Mamifero(null, null, null, null, null);
		}
		return madre;
	}

	public Fecha getDiaNacimiento() {
		if (this.diaNacimiento == null) {
			diaNacimiento = new Fecha(0, 0, 0);
		}
		return diaNacimiento;
	}

	public Veterinario getAsistente() {
		if (this.asistente == null) {
			asistente = new Veterinario("");
		}
		return asistente;
	}

	@Override
	public String toString() {
		String res = "";
		if (this.padre != null) {
			res += "Nombre: " + this.nombre + " ";
			res += "naci� de " + this.padre.nombre + " y de " + this.madre.nombre + " ";
			res += "el d�a " + this.diaNacimiento + " ";
			res += "veterinario asistente: " + this.asistente.getNombre();
		}
		return res;
	}

}
