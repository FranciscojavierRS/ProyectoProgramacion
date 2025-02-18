package TipoExamen_Objeto_formula1;

public class Piloto {
	private String nombre;
	private int edad;
	private String nacionalidad;
	private Equipo equipo;
	private int puntos;

	public Piloto(String nombre, int edad, String nacionalidad, int puntos) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Piloto [nombre=" + nombre + ", edad=" + edad + ", nacionalidad=" + nacionalidad + ", equipo="
				+ equipo.getNombre() + ", puntos=" + puntos + "]";
	}

}	