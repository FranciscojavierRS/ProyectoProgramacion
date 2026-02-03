package Formula1_Examen_Objetos;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(curvas, longitud, nombre, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Circuito))
			return false;
		Circuito other = (Circuito) obj;
		return curvas == other.curvas && Float.floatToIntBits(longitud) == Float.floatToIntBits(other.longitud)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(pais, other.pais);
	}

	public void setCurvas(int curvas) {
		this.curvas = curvas;
	}

	@Override
	public String toString() {
		return "Circuito [nombre=" + nombre + ", pais=" + pais + ", longitud=" + longitud + ", curvas=" + curvas + "]";
	}
    
    
}
