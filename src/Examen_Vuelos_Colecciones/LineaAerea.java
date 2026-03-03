package Examen_Vuelos_Colecciones;

public class LineaAerea implements Comparable<LineaAerea>{
	
	private String nombre;
	private int numAviones;
	
	public LineaAerea(String nombre, int numAviones){
		this.nombre = nombre;
		this.numAviones = numAviones;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getNumAviones(){
		return numAviones;
	}
	
	public void setNumAviones(int numAviones){
		this.numAviones = numAviones;
	}

	@Override
	public String toString(){
		return nombre;
	}

	@Override
	public int compareTo(LineaAerea linea2) {
		return  this.getNombre().compareTo(linea2.getNombre());

	}

}
