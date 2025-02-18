package TipoExamene_Objeto_Rutas;

public class Ruta {
	private Ciudad origen;
	private Ciudad destino;
	private int kilometros;
	
	public Ruta(Ciudad origen, Ciudad destino, int kilometros) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.kilometros = kilometros;
	}	
	
	public Ciudad getOrigen() {
		return origen;
	}


	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}


	public Ciudad getDestino() {
		return destino;
	}


	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}


	public int getKilometros() {
		return kilometros;
	}


	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}


	@Override
	public String toString() {
		return "\n\tRuta [origen=" + origen + ", destino=" + destino + ", kilometros=" + kilometros + "]";
	}
	
	
}
