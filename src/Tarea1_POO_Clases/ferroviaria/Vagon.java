package Tarea1_POO_Clases.ferroviaria;

 class Vagon extends Maquinaria {
	
	private  double capacidadMaxima;
	private double capacidadActual;
	private String tipoMercancia;
	
	 Vagon(double capacidadMaxima, double capacidadActual, String tipoMercancia) {
		super();
		this.capacidadMaxima = capacidadMaxima;
		this.capacidadActual = capacidadActual;
		this.tipoMercancia = tipoMercancia;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(double capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public double getCapacidadActual() {
		return capacidadActual;
	}

	public void setCapacidadActual(double capacidadActual) {
		this.capacidadActual = capacidadActual;
	}

	public String getTipoMercancia() {
		return tipoMercancia;
	}

	public void setTipoMercancia(String tipoMercancia) {
		this.tipoMercancia = tipoMercancia;
	}

	@Override
	public String toString() {
		return "Vagon [capacidadMaxima=" + capacidadMaxima + ", capacidadActual=" + capacidadActual + ", tipoMercancia="
				+ tipoMercancia + "]";
	}
	
}
