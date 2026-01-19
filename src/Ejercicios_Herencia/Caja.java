package Ejercicios_Herencia;

public class Caja {
	
	private final int ancho;
	private final int alto;
	private  final int fondo;
	private final Unidades unidad;
	
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public int getFondo() {
		return fondo;
	}

	public Unidades getUnidad() {
		return unidad;
	}

	public Caja(int ancho, int alto, int fondo, Ejercicios_Herencia.Unidades unidad) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.fondo = fondo;
		this.unidad = unidad;
	}
	
	public double getVolumen() {
		
		double volumen = this.alto * this.ancho * this.fondo;
		
		if (this.unidad==Unidades.CM) {
			volumen= volumen/1000000;
		}
		
		return volumen;
	}

	@Override
	public String toString() {
		return "Caja [ancho=" + ancho + ", alto=" + alto + ", fondo=" + fondo + ", unidad=" + unidad + "]";
	}


}
