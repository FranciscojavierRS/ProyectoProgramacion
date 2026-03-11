package Examen_Animales_Colecciones;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Principal
{
	Vista vista;
	Reserva modelo;

	public static void main(String[] args)
	{
		new Principal();
	}

	private void anyadeDatosDePrueba()
	{
		Area pradera = new Area("Pradera", 3.4F);
		Area lago = new Area("Orilla del lago", 4.2F);
		Area bosque = new Area("Bosque", 5.4F);
		
		
		this.modelo.anyadeArea("Pradera", 3.4F);
		this.modelo.anyadeArea("Orilla del lago", 4.2F);
		this.modelo.anyadeArea("Bosque", 5.4F);
		
		this.modelo.anyadeAnimal("Leon", pradera, new LinkedList<Animal>());
		this.modelo.anyadeAnimal("Hiena", pradera, new LinkedList<Animal>());
		this.modelo.anyadeAnimal("Elefante", pradera, new LinkedList<Animal>());
		
		this.modelo.anyadeAnimal("Gacela", lago, new LinkedList<Animal>());
		this.modelo.anyadeAnimal("Nu", lago, new LinkedList<Animal>());	
		this.modelo.anyadeAnimal("Cocodrilo", lago, new LinkedList<Animal>());
		
		this.modelo.anyadeAnimal("Gorila", bosque, new LinkedList<Animal>());
		this.modelo.anyadeAnimal("Tigre", bosque, new LinkedList<Animal>());	

		
		this.vista.actualizaListadoAreasVentana();
		this.vista.actualizaListaAnimales();
		
		
		
	
		
	}

	public Principal()
	{
		this.modelo = new Reserva();
		this.vista = new Vista(this);
		
		/***********************************/
		
		this.anyadeDatosDePrueba();
		
		/***********************************/ 
	}

	public boolean anyadeAnimal(String nombre, Area area, List listaPresas)
	{

		return this.modelo.anyadeAnimal(nombre,area,listaPresas);
	}

	public boolean anyadeArea(String nombre, float extension)
	{
		return this.modelo.anyadeArea(nombre,extension);
	}

	public Set<Area> getlistaAreas()
	{
		return this.modelo.getListaAreas();
	}


	public TreeSet<Animal> getListaAnimales()
	{
		return this.modelo.getListaAnimales();
	}

	public String getListadoArea(Area area)
	{
		return this.modelo.getListadoArea(area);
	}

	public Animal getAnimal(String nombre)
	{
		return this.modelo.getAnimal(nombre);
	}

	public void actualizaAnimal(Animal animalSeleccionado, List<Animal> presas)
	{
		this.modelo.actualizaAnimal(animalSeleccionado,presas);
		
	}

	public String getListadoTotal()
	{
		return this.modelo.getListadoTotal();
	}

	public String getListadoProblemas()
	{
		return this.modelo.getListadoProblemas();
	}
}
