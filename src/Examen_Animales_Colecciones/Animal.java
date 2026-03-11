package Examen_Animales_Colecciones;

import java.util.HashSet;
import java.util.Objects;

public class Animal implements Comparable<Animal> {
	private String nombre;
	private HashSet<Animal> presas;

	public Animal(String nombre, HashSet<Animal> presas) {
		super();
		this.nombre = nombre;
		this.presas = presas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Animal> getPresas() {
		return presas;
	}

	public void setPresas(HashSet<Animal> presas) {
		this.presas = presas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal))
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Animal o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public String toString() {
		return nombre;
	}

}
