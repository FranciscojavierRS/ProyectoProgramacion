package TipoExamen_Objeto_formula1;

public class Equipo {
    private String nombre;
    private String pais;
    private String director;
    
	public Equipo(String nombre, String pais, String director) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.director = director;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}


	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", pais=" + pais + ", director="
				+ director + "]";
	}
}