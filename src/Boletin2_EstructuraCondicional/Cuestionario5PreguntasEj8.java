package Boletin2_EstructuraCondicional;

import java.util.Scanner;

public class Cuestionario5PreguntasEj8 {

	public static void main(String[] args) {
		System.out.println("A continuacion va a empezar el Cuestionario");
		Scanner sc = new Scanner(System.in);

		int nota = 0; 
		int pregunta;

		
		System.out.println("Pregunta 1: ¿Qué tipo de lenguaje es Java?");
		System.out.println("a) Compilado");
		System.out.println("b) Interpretado");
		System.out.println("c) Compilado e interpretado");
		char respuesta1 = sc.next().charAt(0);

		pregunta = 1;
		switch (pregunta) {
			case 1: {
				if (respuesta1 == 'c') {
					nota++;
				}
				break;
			}
		}

		System.out.println("Pregunta 2: ¿Qué estructura se usa para repetir código?");
		System.out.println("a) if");
		System.out.println("b) while");
		System.out.println("c) switch");
		char respuesta2 = sc.next().charAt(0);

		pregunta = 2;
		switch (pregunta) {
			case 2: {
				if (respuesta2 == 'b') {
					nota++;
				}
				break;
			}
		}

		System.out.println("Pregunta 3: ¿Cuál es el tipo de dato para números decimales?");
		System.out.println("a) int");
		System.out.println("b) double");
		System.out.println("c) boolean");
		char respuesta3 = sc.next().charAt(0);

		pregunta = 3;
		switch (pregunta) {
			case 3: {
				if (respuesta3 == 'b') {
					nota++;
				}
				break;
			}
		}

		System.out.println("Pregunta 4: ¿Qué palabra se usa para definir una constante en Java?");
		System.out.println("a) const");
		System.out.println("b) final");
		System.out.println("c) static");
		char respuesta4 = sc.next().charAt(0);

		pregunta = 4;
		switch (pregunta) {
			case 4: {
				if (respuesta4 == 'b') {
					nota++;
				}
				break;
			}
		}

		System.out.println("Pregunta 5: ¿Qué palabra se usa para heredar en Java?");
		System.out.println("a) this");
		System.out.println("b) extends");
		System.out.println("c) implements");
		char respuesta5 = sc.next().charAt(0);

		pregunta = 5;
		switch (pregunta) {
			case 5: {
				if (respuesta5 == 'b') {
					nota++;
				}
				break;
			}
		}

		System.out.println("Tu calificación final es: " + nota + " puntos de 5.");

		sc.close();
	}
}
