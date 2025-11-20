package Examenes_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenEvaluaciónAlumnos {
	static int numAlumnos = 0; // Contador real de alumnos introducidos

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcion = 0;
		float [][] notas = new float[30][3]; 
		// notas[i][0] = nota control
		// notas[i][1] = nota examen final
		// notas[i][2] = positivos del alumno
		String [] nombresAlumnos = new String[30];

		inicializarTabla(notas); // Rellena la matriz con -1 (marca posiciones no usadas)

		while (opcion != 5) {

			System.out.println("1- Introducir alumno, nota del control y nota del examen final del alumno");
			System.out.println(" 2- Poner un positivo a un alumno. ");
			System.out.println("3- Listar todos los alumnos con su nota final de evaluación ordenado por nota.");
			System.out.println("4- Mostrar estadísticas de la evaluación.");
			System.out.println("5- Fin");

			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				// Introduce alumno y sus notas
				introducirDatos(sc, notas, nombresAlumnos);
				break;

			case 2:
				// Aumenta en 1 el número de positivos del alumno
				añadirPositivoAlumno(sc, notas, nombresAlumnos);
				break;

			case 3:
				// Calcula nota final y lista alumnos ordenados por nota
				calcularNota(notas,nombresAlumnos);
				break;

			case 4:
				// Genera estadísticas generales del grupo
				mostrarEstadistica(notas,nombresAlumnos);
				break;

			case 5:
				// Salir
				break;

			default:
			}
			System.out.println("");
		}

		sc.close();
	}

	private static void mostrarEstadistica(float[][] notas, String[] nombresAlumnos) {
		
		int contadorSuspenso = 0; // Cuenta cuántos suspenden examen final
		float maxNotaControl = 0; // Guarda la mayor nota del control
		int indiceAlumnoMaxNota = 0; // Alumno con mejor control
		
		float[] notasFinales = calculaNotaFinal(notas); // Notas finales calculadas
		
		float sumaNotasFinales = 0; // Para obtener la media del grupo

		for (int i = 0; i < numAlumnos; i++) {

			// Comprobación de suspenso en el examen final
			if (notas[i][1] < 5) {
				contadorSuspenso++;
			}
			
			// Detecta la nota más alta del control
			if (notas[i][0] > maxNotaControl) {
				maxNotaControl = notas[i][0];
				indiceAlumnoMaxNota = i;
			}

			sumaNotasFinales += notasFinales[i];
		}
		
		float porcentajeSuspensos = contadorSuspenso * 100 / numAlumnos;
		float notamediaGrupo = sumaNotasFinales / numAlumnos;
		
		System.out.println("El porcentaje de alumnos con el examen final suspensos es: " + porcentajeSuspensos);
		System.out.println("La nota media final de todo el grupo es: " + notamediaGrupo);
		System.out.println("El alumno con mas nota en el control es: " + nombresAlumnos[indiceAlumnoMaxNota]);
	}

	private static void calcularNota(float[][] notas, String[] nombresAlumnos) {

		float[] notasFinales = calculaNotaFinal(notas);

		// Copia para poder ordenar las notas finales sin perder las originales
		float [] notasFinalesOrdenada = Arrays.copyOf(notasFinales, numAlumnos);
		
		// *FALTA UNA ORDENACIÓN AQUÍ, PERO NO LA MODIFICO POR INDICACIÓN TUYA*
		// Se imprime en el orden actual
		
		for (int i = 0; i < numAlumnos; i++) {
			float notaFinal = notasFinalesOrdenada[i];
			
			// Busca a qué alumno pertenece esa nota final
			int indiceAlumno = getindice(notasFinales, notaFinal, numAlumnos);
			
			String nombreAlumno = nombresAlumnos[indiceAlumno];
			
			System.out.println("El alumno: " + nombreAlumno + " Y su nota final es: " + notaFinal);
		}
	}

	private static float[] calculaNotaFinal(float[][] notas) {

		// Primero averigua cuántos positivos tiene el alumno con más positivos
		float maxPostivos = 0;
		for (int i = 0; i < numAlumnos; i++) {
			
			float positivos = notas[i][2];
			if (positivos > maxPostivos) {
				maxPostivos = positivos;
			}
		}

		// Calcula la nota final ponderada
		float notasFinales[] = new float[numAlumnos];
		
		for (int i = 0; i < numAlumnos; i++) {

			// Fórmula: 30% control + 60% examen final + proporción de positivos
			float notaFinal = (float)(notas[i][0] * 0.3 + notas[i][1] * 0.6 + notas[i][2] / maxPostivos);
			notasFinales[i] = notaFinal;
		}
		return notasFinales;
	}

	private static void añadirPositivoAlumno(Scanner sc, float[][] notas, String[] nombresAlumnos) {

		System.out.println("Introduce el nombre del alumno");
		String nombreAlumno = sc.next();

		// Busca su índice (si no existiera, lo crearía)
		int indiceAlumno = getindice(nombresAlumnos, nombreAlumno, numAlumnos);
		
		// Suma un positivo
		notas[indiceAlumno][2]++;
	}

	private static void introducirDatos(Scanner sc, float[][] notas, String[] nombresAlumnos) {

		System.out.println("Introduce el nombre del Alumno");
		String nombreAlumno = sc.next();
		
		int indiceAlumno = getindice(nombresAlumnos, nombreAlumno, numAlumnos);
		
		// Si es nuevo alumno se incrementa el contador
		if (indiceAlumno == numAlumnos) {
			numAlumnos++;
		}
		
		System.out.println("Introduce la nota del control");
		float notaControl = sc.nextFloat(); 
		notas[indiceAlumno][0] = notaControl;
		
		System.out.println("Introduce la nota del examen Final");
		float notaExamenFinal = sc.nextFloat(); 
		notas[indiceAlumno][1] = notaExamenFinal;
		
		// Inicializa sus positivos a 0
		notas[indiceAlumno][2] = 0;
	}

	private static int getindice(float notasFinales[], float notaFinal, int numAlumnos) {
		// Busca la posición de una nota dentro del array de notas finales
		for (int i = 0; i < numAlumnos; i++) {
			if (notasFinales[i] == notaFinal) {
				return i;
			}
		}
		return 0;
	}
	
	private static int getindice(String[] nombresAlumnos, String nombreAlumno, int numAlumnos) {
		// Busca por nombre y devuelve el índice si existe
		for (int i = 0; i < numAlumnos; i++) {

			if (nombresAlumnos[i].equals(nombreAlumno)) {
				return i;
			}
		}

		// Si no existe, lo crea y devuelve su nueva posición
		nombresAlumnos[numAlumnos] = nombreAlumno;
		return numAlumnos;
	}

	private static void inicializarTabla(float[][] notas) {
		// Llena la matriz de notas con -1 para indicar ninguna nota registrada
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 3; j++) {
				notas[i][j] = -1;
			}
		}
	}
}
