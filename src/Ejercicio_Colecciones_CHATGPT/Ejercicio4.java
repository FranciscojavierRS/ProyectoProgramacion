package Ejercicio_Colecciones_CHATGPT;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Set<Persona> conjuntoPersonas = new HashSet<>();
		conjuntoPersonas.add(new Persona("Ana",20));
		conjuntoPersonas.add(new Persona("Luis",30));
		conjuntoPersonas.add(new Persona("Ana",20));
		
		System.out.println(conjuntoPersonas);
	}	

	
}

