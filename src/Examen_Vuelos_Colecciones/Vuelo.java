package Examen_Vuelos_Colecciones;

public class Vuelo 
{
	private LineaAerea linea;
	private Localidad destino;
	
	public Vuelo(LineaAerea linea, Localidad destino){
		super();
		this.linea = linea;
		this.destino = destino;
	}
	
	public LineaAerea getLinea(){
		return linea;
	}
	
	public void setLinea(LineaAerea linea)	{
		this.linea = linea;
	}
	
	public Localidad getDestino() {
		return destino;
	}
	
	public void setDestino(Localidad destino)	{
		this.destino = destino;
	}
	
	@Override
	public String toString(){
		return "Vuelo [linea=" + linea + ", destino=" + destino + "]";
	}





}
