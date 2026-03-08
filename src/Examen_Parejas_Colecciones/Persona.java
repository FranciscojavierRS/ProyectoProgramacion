package Examen_Parejas_Colecciones;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Persona implements Comparable< Persona>
{
	public static final boolean HOMBRE = true;
	public static final boolean MUJER = false;

	private String nombre;
	private Sexo sexoPropio;
	private Sexo sexoBuscado;
	private boolean esGestor;
	private LinkedList<String> aficiones=new LinkedList<>();

	public Persona(String nombre, Sexo sexoPropio, Sexo sexoBuscado, boolean esGestor, List<String> gustos)
	{
		this.nombre=nombre;
		this.sexoPropio=sexoPropio;
		this.sexoBuscado=sexoBuscado;
		this.esGestor=esGestor;
		this.aficiones.addAll(gustos);
	}
	
   @Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(nombre, other.nombre);
	}

   public String aficionesComunesCon(Persona otra)
	{
	   return "aficionesComunesCon";
	}
   
	public String toString()
	{
		return "";
	}

	public boolean isGestor()
	{
		return esGestor;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public Sexo getSexoPropio()
	{
		return sexoPropio;
	}

	public Sexo getSexoBuscado()
	{
		return sexoBuscado;
	}

	@Override
	public int compareTo(Persona o) {
		return this.nombre.compareTo(o.nombre);
	}
}
