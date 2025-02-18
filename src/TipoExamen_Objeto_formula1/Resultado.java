package TipoExamen_Objeto_formula1;

public class Resultado {
	private int posicionLlegada;
	private String tiempoCarrera;
	private float velocidadPromedio;

	public Resultado(int posicionLlegada, String tiempoCarrera, float velocidadPromedio) {
		super();
		this.posicionLlegada = posicionLlegada;
		this.tiempoCarrera = tiempoCarrera;
		this.velocidadPromedio = velocidadPromedio;
	}

	public int getPosicionLlegada() {
		return posicionLlegada;
	}

	public void setPosicionLlegada(int posicionLlegada) {
		this.posicionLlegada = posicionLlegada;
	}

	public String getTiempoCarrera() {
		return tiempoCarrera;
	}

	public void setTiempoCarrera(String tiempoCarrera) {
		this.tiempoCarrera = tiempoCarrera;
	}

	public float getVelocidadPromedio() {
		return velocidadPromedio;
	}

	public void setVelocidadPromedio(float velocidadPromedio) {
		this.velocidadPromedio = velocidadPromedio;
	}

	@Override
	public String toString() {
		return "Resultado [posicionLlegada=" + posicionLlegada + ", tiempoCarrera=" + tiempoCarrera
				+ ", velocidadPromedio=" + velocidadPromedio + "]";
	}

}
