package Ejercicio_Colecciones_CHATGPT;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ejercicio6 {

	public static void main(String[] args) {

		Map<String,Integer> mapaNotas = new HashMap<>();
		
		mapaNotas.put("Ana", 7);
		mapaNotas.put("Luis", 5);
		mapaNotas.put("Marta", 9);
		mapaNotas.put("Pedro", 4);
		mapaNotas.put("Lucia", 8);
		
		System.out.println(mapaNotas);
		// Con esto obtenemos la nota de Marta
		System.out.println(mapaNotas.get("Marta"));
		System.out.println(mapaNotas.containsKey("Pedro"));
		
		Set<Map.Entry<String, Integer>> conjuntoNotas = mapaNotas.entrySet();
		
		int sumaNotas = 0;
		
		String alumnoNotaMasAlta = "";
		int 	notaMasAlta  = 0;
		
		for (Map.Entry<String, Integer>nota: conjuntoNotas) {
			sumaNotas+=nota.getValue();
			
			if(nota.getValue()>notaMasAlta) {
				notaMasAlta=nota.getValue();
				alumnoNotaMasAlta=nota.getKey();
			}
			
		}
		System.out.println((float)sumaNotas/conjuntoNotas.size());
		System.out.println(alumnoNotaMasAlta);
	}

}
