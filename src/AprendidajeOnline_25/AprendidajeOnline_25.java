package AprendidajeOnline_25;

import java.util.Scanner;

public class AprendidajeOnline_25 {

	private static int numeroAlumnos= 0;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del curso");
		String nombreCurso =sc.next();
		
		System.out.println("El numero de sesiones");
		int numeroSesiones =sc.nextInt();
		
		int[] tiempoSesiones = new int[numeroSesiones];
		
		for (int i= 0; i< numeroSesiones; i++) {
			System.out.println("Duración de la sesion "+i);
			int duracion = sc.nextInt();
			tiempoSesiones[i]=duracion;
			
		}
		
		String[] nombreAlumnos = new String [20];
		float [] [] notas = new float [numeroSesiones][20];
		
		inicializarTabla(notas,numeroSesiones);
		

		int opcion = 0;
		
		while (opcion != 6) {

			System.out.println("1. Registrar la calificación de un usuario en cierta sesión de aprendizaje.");
			System.out.println("2. Listar todas las sesiones, junto con su duración y notas.");
			System.out.println("3. Indicar cuál es la sesión en la que se ha sacado mejor nota media.");
			System.out.println("4. Mostrar los usuarios que han estudiado solo una sesión.");
			System.out.println("5. Listar usuarios (ordenados alfabéticamente) con su nota media.");
			System.out.println("6- Fin.");

			opcion = sc.nextInt();

			switch (opcion) {
		
			case 1:
					insertarDatos(sc,notas,nombreAlumnos);
				break;

			case 2: 
				listadoSesiones(tiempoSesiones,notas,nombreAlumnos,nombreCurso,numeroSesiones);

				break;
			case 3:
				sesionMejorNotaMedia(notas,numeroSesiones);
				
				break;

			case 4:
				listadoUsuariosSoloUnaSesión(notas,nombreAlumnos,numeroSesiones);

				break;
			case 5:
				totalMinutosDedicados(tiempoSesiones,notas,nombreAlumnos,numeroSesiones);
				
				break;

			case 6:

				break;

			default:

			}
			System.out.println("");
		}
		
		sc.close();
	}
	private static void totalMinutosDedicados(int[] tiempoSesiones, float[][] notas, String[] nombreAlumnos,
			int numeroSesiones) {

		for (int j= 0; j<numeroAlumnos; j++) {
			int contadorMinutosSesion = 0;
			for (int i= 0; i<numeroSesiones; i++) {
				if (notas[i][j]!=-1) {
					contadorMinutosSesion+=tiempoSesiones[i];
				}
			}
			System.out.println(nombreAlumnos[j]+": "+contadorMinutosSesion);
		}
	}
	private static void listadoUsuariosSoloUnaSesión(float[][] notas, String[] nombreAlumnos, int numeroSesiones) {

		String[] alumnos = new String [numeroAlumnos];
		int numero= 0;
		for (int j=0; j<numeroAlumnos; j++) {
			
			int contadorSesiones =0;
			
			for (int i= 0; i<numeroSesiones; i++) {
				
				if (notas[i][j]==-1) {
					contadorSesiones++;
				}
			}
			
			if (contadorSesiones==1) {
				alumnos[numero]=nombreAlumnos[j];
				numero++;
				
			}
		}
		 System.out.println("Usuarios que estudiaron solo una sesión: ");
		 
		 for (int j= 0; j<numero; j++) {
			 System.out.println("- "+alumnos[j]);
		 }
		
	}
	private static void sesionMejorNotaMedia(float[][] notas, int numeroSesiones) {

		float maxNotaMedia = 0;
		int sesionMejorNotaMedia = 0;
		
		for (int i=0; i<numeroSesiones; i++) {
			float notaMedia= calculaNotaMedia(notas[i]);
			
			if (notaMedia>maxNotaMedia) {
				maxNotaMedia=notaMedia;
				sesionMejorNotaMedia=i;
			}
		}
		
		System.out.println("La sesión con la mejor nota media es "+sesionMejorNotaMedia);
	}
	private static float calculaNotaMedia(float[] notaSesion) {
		
		float sumaNotas = 0;
		int numAlumnoSesion =0;
		
		for (int i=0; i<numeroAlumnos; i++) {
			float notaAlumno=notaSesion[i];
			if  (notaAlumno!=-1) {
				sumaNotas+=notaAlumno;
				numAlumnoSesion++;
			}
		}
		
		return sumaNotas/numAlumnoSesion;
	}
	private static void listadoSesiones(int[] tiempoSesiones, float[][] notas, String[] nombreAlumnos,
			String nombreCurso, int numeroSesiones) {

		System.out.println("Curso: "+nombreCurso);
		System.out.println("Listado de Sesiones: ");
		
		for (int i=0; i<numeroSesiones; i++) {
			System.out.println("Sesion: "+i+": "+tiempoSesiones[i]+" minutos.");
			for (int j=0; j<numeroAlumnos; j++) {
				System.out.println("- Usuario: "+nombreAlumnos[j]+" , Nota: "+notas[i][j]);
				
			}
		}
	}
	private static void insertarDatos(Scanner sc, float[][] notas, String[] nombreAlumnos) {
		
		System.out.println("Introduce el nombre del Usuario");
		String nombreUsuario= sc.next();
		int indiceAlumno = getindice(nombreAlumnos, nombreUsuario, numeroAlumnos);

		if (indiceAlumno == numeroAlumnos) {
			numeroAlumnos++;

		}
		
		System.out.println("Introduce el numero de la sesión");
		int sesion =sc.nextInt();
		
		System.out.println("Nota obtenida por el usuario en esa sesion");
		float nota = sc.nextFloat();
		
		notas [sesion][indiceAlumno] = nota;
		
	}
	
	
	private static int getindice(String[] nombreAlumnos, String nombreUsuario, int numeroAlumnos) {

		for (int i = 0; i < numeroAlumnos; i++) {

			if (nombreAlumnos[i].equals(nombreUsuario)) {
				return i;

			}
		}

		nombreAlumnos[numeroAlumnos] = nombreUsuario;
		return numeroAlumnos;
	}
	
	private static void inicializarTabla(float[][] notas, int numeroSesiones) { // Inicializamos las tablas a -1

		for (int i = 0; i < numeroSesiones; i++) {
			for (int j = 0; j < 20; j++) {
				notas[i][j] = -1;
			}
		}

	}
}
