package Ejercicio_Colecciones_CHATGPT;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio7 {

	public static void main(String[] args) {

		String frase = "java python java c++ java python";
		Map<String, Integer> mapaRepeticiones = new HashMap<>();
		
		String [] arrayPalabras = frase.split(" ");
		
		for (String palabra : arrayPalabras) {
			if(!mapaRepeticiones.containsKey(palabra)) {
				mapaRepeticiones.put(palabra, 1);
			}else {
				mapaRepeticiones.put(palabra,mapaRepeticiones.get(palabra)+1 );

			}
		}
		
		System.out.println(mapaRepeticiones);
		
	}

}
