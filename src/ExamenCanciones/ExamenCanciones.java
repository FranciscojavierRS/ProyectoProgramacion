package ExamenCanciones;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenCanciones {
	private static final int MAXCANCIONES = 10;
	private static final int MAXMESES = 12;
	private static int[][] likes = new int[MAXCANCIONES][MAXMESES];
	private static int numcanciones = 0;
	private static String[] canciones = new String[MAXCANCIONES];

	public static void main(String[] args) {
		inicializardatos();

		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		// Bucle principal para el menú interactivo
		while (opcion != 6) {
			System.out.println("1-Introducir dato\n" + "2-Listar todos los datos\n"
					+ "3-Mostrar las canciones ordenadas alfabeticamente\n"
					+ "4-Mostrar el promedio de likes  de un mes en concreto\n"
					+ "5-Mostrar si hay alguna canción con datos para todos los meses\n" + "6-Fin");

			opcion = sc.nextInt(); // Leer la opción seleccionada por el usuario

			switch (opcion) {
			case 1:
				insertardatos(sc);
				break;
			case 2:
				mostrarDatos();
				break;
			case 3:
				ordenadoAlfabeticamente();
				break;
			case 4:
				promedioCancionesMes(sc);
				break;
			case 5:
				cancionesParaTodosLosMeses();
				break;
			default:
				break;
			}
		}
		sc.close();
	}

	private static void cancionesParaTodosLosMeses() {
		boolean todoslosmeses=false;
		for(int i=0;i<numcanciones;i++) {
			todoslosmeses=true;
			for (int j=0;j<MAXMESES;j++) {
				if (-1==likes[i][j]) {
					todoslosmeses=false;
					break;
				}
			}
			if (todoslosmeses) {
				System.out.println("Hay al menos una canción con datos para todos los meses");
				return;
			}
		}
			System.out.println("No hay ninguna canción con datos para todos los meses");	
	}

	private static void promedioCancionesMes(Scanner sc) {
		System.out.println("Introduce el mes:");
		int mes = sc.nextInt();
		float totalLikes=0;
		int numdatos=0;
		for (int i=0; i<numcanciones;i++) {
			if (-1!=likes[i][mes-1]) {
				numdatos++;
				totalLikes=totalLikes+likes[i][mes-1];
			}
		}
		if(0 == numdatos) {
			System.out.println("No hay datos para ese mes");
			return;
		}
		
		System.out.println("el promedio de likes de este mes es "+totalLikes/numdatos);
		
	}

	private static void ordenadoAlfabeticamente() {
		String[] cancionesOrdenadas=getOrdenarArray(canciones, numcanciones);
				System.out.println("Canciones ordenadas alfabeticamente");
			for (int i=0; i<numcanciones;i++) {
				System.out.println(cancionesOrdenadas[i]);
			}
	}

	private static String[] getOrdenarArray(String[] array, int numElementos) {
        String[] arrayOrdenado = Arrays.copyOf(array, numElementos);
        Arrays.sort(arrayOrdenado);
        return arrayOrdenado;
    }
	private static void mostrarDatos() {
		for (int j = 0; j < MAXMESES; j++) {
			String mes = getNombreMes(j);
			System.out.println(mes);
			for (int i = 0; i < numcanciones; i++) {
				String nombreCancio = canciones[i];
				int like = likes[i][j];
				if (like != -1) {
					System.out.println(nombreCancio + " --> " + like + " Likes");
				}
			}

		}

	}

	private static void insertardatos(Scanner sc) {
		System.out.println("Introduce la cancion:");
		String cancion = sc.next();

		if (comprobarcancion(cancion)) {
			canciones[numcanciones] = cancion;
			numcanciones++;
		}

		System.out.println("Introduce el mes:");
		int mes = sc.nextInt();

		System.out.println("Introduce la cantidad de likes:");
		int like = sc.nextInt();
		likes[indiceCanciones(cancion)][mes - 1] = like;

		System.out.println("Datos almacenados");
	}

	private static boolean comprobarcancion(String cancion) {
		for (int i = 0; i < numcanciones; i++) {

			if (cancion.equals(canciones[i])) {
				return false; // Ciudad ya registrada
			}
		}

		if (numcanciones == MAXCANCIONES - 1) {
			System.out.println("Se ha alcanzado el número máximo de canciones");
			return false;
		}

		return true; // Ciudad no registrada aún

	}

	private static int indiceCanciones(String cancion) {
		int indice = 0;
		while (indice < numcanciones && !cancion.equals(canciones[indice])) {
			indice++;
		}
		return indice;
	}

	private static void inicializardatos() {
		for (int i = 0; i < MAXCANCIONES; i++) {
			for (int j = 0; j < MAXMESES; j++) {
				likes[i][j] = -1;
			}
		}
	}

	private static String getNombreMes(int mes) {
		String[] meses = new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
				"Septiembre", "Octubre", "Noviembre", "Diciembre" };
		return meses[mes];
	}

}
