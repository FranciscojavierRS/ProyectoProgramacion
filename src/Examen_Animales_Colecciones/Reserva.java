package Examen_Animales_Colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Reserva {

	private Map<Area, ListaAnimales> mapaAnimales;

	public Reserva() {
		mapaAnimales = new HashMap<>();
	}

	/*
	 * Añade al mapa el área con las características pasadas como parámetros.
	 * Devuelve false si la reserva ya tenía esa área. Dos áreas son iguales si
	 * tienen el mismo nombre.
	 * 
	 */
	public boolean anyadeArea(String string, float f) {

		Area area = new Area(string, f);
		if (mapaAnimales.containsKey(area)) {
			return false;
		}
		mapaAnimales.put(area, new ListaAnimales());

		return true;
	}

	/*
	 * Añade al mapa el área pasada como parámetro. Devuelve false si la reserva ya
	 * tenía esa área.
	 * 
	 */
	public boolean anyadeArea(Area area) {
		if (mapaAnimales.containsKey(area)) {
			return false;
		}
		mapaAnimales.put(area, new ListaAnimales());

		return true;
	}

	/*
	 * Añade al mapa el animal llamado "nombre" al área pasada como parámetro. El
	 * animal es depredador de los animales pasados en listaPresas. Devuelve false
	 * si el animal ya existía en la reserva, en cualquier área. Dos animales son
	 * iguales si tienen el mismo nombre.
	 * 
	 */
	public boolean anyadeAnimal(String string, Area pradera, List listaPresas) {

		if (!this.mapaAnimales.containsKey(pradera)) {
			return false;

		}
		return mapaAnimales.get(pradera).add(new Animal(string, new HashSet<Animal>(listaPresas))); // IMPORTANTE aqui
																									// hacemos una
																									// transformacion de
																									// lista a conjunto

	}

	// Devuelve el conjunto de áreas de la reserva.
	public Set<Area> getListaAreas() {

		return mapaAnimales.keySet();
	}

	// Devuelve un TreeSet con todos los animales de la reserva (todos los
	// animales de todas las áreas.
	public TreeSet<Animal> getListaAnimales() {

		TreeSet<Animal> listaAnimales = new TreeSet<>();

		for (Map.Entry<Area, ListaAnimales> entrada : mapaAnimales.entrySet()) {

			listaAnimales.addAll(entrada.getValue());

		}
		return listaAnimales;
	}

	// Devuelve el listado de animales del área pasada, tal como se muestra
	// en el área de texto de la izquierda (incluido el orden).

	public String getListadoArea(Area area) {

		String listadoArea = "";

		for (Animal animal : mapaAnimales.get(area)) {
			listadoArea += animal.toString() + "\n";
		}

		return listadoArea;
	}

	// Devuelve el animal cuyo nombre coincide con el parámetro pasado.
	// si no existe en la reserva, devuelve null.

	public Animal getAnimal(String nombre) {

		for (Animal animal : getListaAnimales()) {

			if (animal.getNombre().equals(nombre)) {
				return animal;
			}
		}

		return null;
	}

	// Actualiza la lista de presas del animal pasado, añadiendo
	// a las que ya tenía, las pasadas como parámetro.
	public void actualizaAnimal(Animal animalSeleccionado, List<Animal> presas) {

		for (Animal animal : getListaAnimales()) {

			if (animal.equals(animalSeleccionado)) {
				animal.getPresas().addAll(presas);
			}
		}

	}

	// Devuelve el listado de todos los animales de la reserva, tal como
	// muestra en el área de texto de la derecha (incluido el orden).
	
	public String getListadoTotal() {
		
		String listadoArea = "";

		for (Animal animal : getListaAnimales()) {
			listadoArea += animal.toString() + "\n";
		}

		return listadoArea;
		
		
	}

	/*
	 *  Devuelve el listado de todos los problemas que se pueden producir en la
 		reserva, tal como se muestra en el área de texto de la derecha (incluido
 		el orden). Un problema se produce cuando en el mismo área se encuentra
 		algún animal y alguna de sus presas.
	 */
	public String getListadoProblemas() {
		
		String listaProblemas = "";
		
		for (Map.Entry<Area, ListaAnimales> entrada : mapaAnimales.entrySet()) {
			ArrayList<Animal> animalesArea = new ArrayList<>(entrada.getValue());
			
			for (int i = 0; i<entrada.getValue().size()-1; i++) {
				
				Animal animal1 = animalesArea.get(i);
				
				for (int j = i; j<entrada.getValue().size(); j++) {
					
					Animal animal2 = animalesArea.get(j);

						if (animal1.getPresas().contains(animal2)) {
							listaProblemas+= "Area: "+entrada.getKey()+" - El animal : "+animal2.getNombre()+" es presa de :"+animal1.getNombre()+"\n";
						}else if(animal2.getPresas().contains(animal1)){
							listaProblemas+= "Area: "+entrada.getKey()+" - El animal : "+animal1.getNombre()+" es presa de :"+animal2.getNombre()+"\n";
						}
					
				}
			}
			
		}

		
		return listaProblemas;
	}

}