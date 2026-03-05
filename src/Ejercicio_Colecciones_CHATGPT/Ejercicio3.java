package Ejercicio_Colecciones_CHATGPT;

import java.util.ArrayList;
import java.util.HashSet;

public class Ejercicio3 {

	public static void main(String[] args) {
		ArrayList<String>listaNombres = new ArrayList<>();
		
		listaNombres.add("Francisco");
		listaNombres.add("Francisco");
		listaNombres.add("Angel");
		listaNombres.add("Virginia");
		listaNombres.add("Francisco");
		listaNombres.add("Francisco");
		listaNombres.add("Francisco");
		listaNombres.add("Huan");
		listaNombres.add("Huan");
		listaNombres.add("Francisco");
		listaNombres.add("Francisco");
		listaNombres.add("Kami");
		listaNombres.add("Francisco");
		listaNombres.add("Kami");
		listaNombres.add("Virginia");
		
		System.out.println(listaNombres);
		
		HashSet<String> conjuntoNombres = new HashSet<>(listaNombres);
		System.out.println(conjuntoNombres);

	}

}
