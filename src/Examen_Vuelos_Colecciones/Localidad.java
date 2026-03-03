package Examen_Vuelos_Colecciones;

import java.util.Objects;

public class Localidad implements Comparable<Localidad>{
	
	private String nombre;
	private int habitantes;
	
	public Localidad(String nombre, int habitantes){
		super();
		this.nombre = nombre;
		this.habitantes = habitantes;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getHabitantes(){
		return habitantes;
	}
	
	public void setHabitantes(int habitantes){
		this.habitantes = habitantes;
	}
	
	@Override
	public String toString(){
		return "Localidad [nombre=" + nombre + ", habitantes=" + habitantes + "]";
	}

	@Override
	public int compareTo(Localidad localidad2) {
		// TODO Auto-generated method stub
		return this.getNombre().compareTo(localidad2.getNombre());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Localidad))
			return false;
		Localidad other = (Localidad) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
