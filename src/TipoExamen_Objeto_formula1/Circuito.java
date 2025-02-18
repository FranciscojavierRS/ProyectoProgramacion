package TipoExamen_Objeto_formula1;

public class Circuito {
    private String nombre;
    private String pais;
    private float longitud;
    private int curvas;
    
	public Circuito(String nombre, String pais, float longitud, int curvas) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.longitud = longitud;
		this.curvas = curvas;
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

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public int getCurvas() {
		return curvas;
	}

	public void setCurvas(int curvas) {
		this.curvas = curvas;
	}

	@Override
	public String toString() {
		return "Circuito [nombre=" + nombre + ", pais=" + pais + ", longitud=" + longitud + ", curvas=" + curvas + "]";
	}
    
    
}