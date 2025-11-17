package GestionNotaEvaluación;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenEvaluaciónAlumnos {
	static int numAlumnos = 0;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcion = 0;
		float [][] notas = new float[30][3];
		String [] nombresAlumnos = new String[30];

		inicializarTabla(notas);

		

		while (opcion != 5) {

			System.out.println("1- Introducir alumno, nota del control y nota del examen final del alumno");
			System.out.println(" 2- Poner un positivo a un alumno. ");
			System.out.println("3- Listar todos los alumnos con su nota final de evaluación ordenado por nota.");
			System.out.println("4- Mostrar estadísticas de la evaluación.");
			System.out.println("5- Fin");
			

			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				introducirDatos(sc, notas, nombresAlumnos);

				break;

			case 2:
				añadirPositivoAlumno(sc, notas, nombresAlumnos);
				break;
			case 3:
				calcularNota(notas,nombresAlumnos);
				
				break;

			case 4:
				mostrarEstadistica(notas,nombresAlumnos);
				break;
			case 5:
				
				break;

			

			default:

			}
			System.out.println("");
		}

		sc.close();
	}

	private static void mostrarEstadistica(float[][] notas, String[] nombresAlumnos) {
		
		int contadorSuspenso= 0;
		float maxNotaControl = 0;
		int indiceAlumnoMaxNota = 0;
		
		float[] notasFinales = calculaNotaFinal(notas);
		
		float sumaNotasFinales= 0;

		for (int i = 0; i < numAlumnos; i++) {
			if (notas[i][1]<5  ) {
				contadorSuspenso++;
			}
			
			if (notas[i][0]>maxNotaControl) {
				maxNotaControl= notas[i][0];
				indiceAlumnoMaxNota=i;
			}
			sumaNotasFinales+=notasFinales[i];
			
		}
		
		float porcentajeSuspensos = contadorSuspenso*100/numAlumnos;
		float notamediaGrupo= sumaNotasFinales/numAlumnos;
		
		System.out.println("El porcentaje de alumnos con el examen final suspensos es: "+porcentajeSuspensos);
		System.out.println("La nota media final de todo el grupo es: "+notamediaGrupo);
		System.out.println("El alumno con mas nota en el control es: "+nombresAlumnos[indiceAlumnoMaxNota]);
		
	}

	private static void calcularNota(float[][] notas, String[] nombresAlumnos) {

		float[] notasFinales = calculaNotaFinal(notas);
		
		float [] notasFinalesOrdenada =Arrays.copyOf( notasFinales,numAlumnos);
		for (int i = 0; i < numAlumnos; i++) {
			float notaFinal =notasFinalesOrdenada[i];
			
			int indiceAlumno = getindice(notasFinales, notaFinal,numAlumnos);
			
			String nombreAlumno = nombresAlumnos[indiceAlumno];
			
			System.out.println("El alumno: "+nombreAlumno+" Y su nota final es: "+notaFinal);
			
		}

		
		
	}

	private static float[] calculaNotaFinal(float[][] notas) {
		float maxPostivos = 0;
		for (int i = 0; i < numAlumnos; i++) {
			
		float positivos = notas[i][2];
		 if (positivos>maxPostivos) {
			maxPostivos=positivos;
		 }
			
		}
		float notasFinales [] = new float [numAlumnos];
		for (int i = 0; i < numAlumnos; i++) {
			
			float notaFinal = (float) (notas[i][0]* 0.3+ notas[i][1]* 0.6+notas[i][2]/maxPostivos);
			notasFinales[i]=notaFinal;
			
		}
		return notasFinales;
	}

	private static void añadirPositivoAlumno(Scanner sc, float[][] notas, String[] nombresAlumnos) {

		System.out.println("Introduce el nombre del alumno");
		String nombreAlumno = sc.next();

		int indiceAlumno = getindice(nombresAlumnos, nombreAlumno,numAlumnos);
		notas[indiceAlumno][2]++;

		
	}

	private static void introducirDatos(Scanner sc, float[][] notas, String[] nombresAlumnos) {
		System.out.println("Introduce el nombre del Alumno");
		String nombreAlumno = sc.next();
		
		int indiceAlumno = getindice(nombresAlumnos, nombreAlumno,numAlumnos);
		
		if (indiceAlumno == numAlumnos) {
			numAlumnos++; //numAlumnos = numAlumnos+1;

		}
		
		System.out.println("Introduce la nota del control");
		float notaControl = sc.nextFloat(); 
		
		notas[indiceAlumno][0]=notaControl;
		
		System.out.println("Introduce la nota del examen Final");
		float notaExamenFinal = sc.nextFloat(); 
		
		notas[indiceAlumno][1]=notaExamenFinal;
		
		
		notas[indiceAlumno][2]=0;

		
		
		
	}

	private static int getindice(float notasFinales [], float notaFinal, int numAlumnos) {
		
		for (int i = 0; i < numAlumnos; i++) {

			if (notasFinales[i]==notaFinal) {
				return i;

			}
		}

		return 0;
		
	}
	
private static int getindice(String[] nombresAlumnos, String nombreAlumno, int numAlumnos) {
		
		for (int i = 0; i < numAlumnos; i++) {

			if (nombresAlumnos[i].equals(nombreAlumno)) {
				return i;

			}
		}

		nombresAlumnos[numAlumnos] = nombreAlumno;
		return numAlumnos;
		
		
	}

	private static void inicializarTabla(float[][] notas) {
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 3; j++) {
				notas[i][j] = -1;
			}
		}

		
	}
	}


