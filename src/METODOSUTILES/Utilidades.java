package METODOSUTILES;

import java.util.Arrays;
import java.util.Scanner;

public class Utilidades {

	
	//1 Ordena un array de cadenas ALFABETICAMENTE (Partidos Politicos)
	
	//2 Ordena un Array numero de forma MAYOR A MENOR (Partidos Politicos)
	
	//3 Ordena un Array de NUMEROS (Si me piden un Array con decimales cambiamos INT por FLOAT) (Partidos Politicos)
	
	//4 Optiene el indice del elemento de entrada en un Array  en caso de INT cambiamos EQUALS por !=   (Partidos Politicos)
	
	//5 Apartir de un numero optenemos el valor     Para optener un elemento String atraves de un Entero (Examen Canciones)
	
	//6 INICIALIZA LA TABLA DE DATOS (Canciones)
	
	//7  Comprueba si el elemento de entrada ya esta en el Array (Canciones)
	
	//8  Insertar Datos (canciones)
	
	//9 Insertar un elemento en una posicion especifica en un Array moviendo los  datos (Lluvias)
	
	//10 Recorre la tabla mostrando los datos insertados en la tabla y ademas Alfabeticamente (partidos)
	
	
	 1 // Ordena un array de cadenas ALFABETICAMENTE (Partidos Politicos)
	private static String[] getOrdenarArray(String[] array, int numElementos) {
		String[] arrayOrdenado = Arrays.copyOf(array, numElementos);
		Arrays.sort(arrayOrdenado);
		return arrayOrdenado;
	}

	2 // Ordena un Array numero de forma MAYOR A MENOR (Partidos Politicos)
	private static int[] getOrdenarArrayReverse(int[] array, int numElementos) {
		int[] arrayOrdenado = Arrays.copyOf(array, numElementos);
		Arrays.sort(arrayOrdenado);

		int[] arrayOrdenadoReverse = new int[numElementos];
		int indice = 0;
		for (int i = numElementos - 1; i >= 0; i--) {
			arrayOrdenadoReverse[indice] = arrayOrdenado[i];
			indice++;
		}
		return arrayOrdenadoReverse;
	}

	3 // Ordena un Array de NUMEROS (Si me piden un Array con decimales cambiamos INT
	// por FLOAT) (Partidos Politicos)
	private static int[] getOrdenarArray(int[] array, int numElementos) {
		int[] arrayOrdenado = Arrays.copyOf(array, numElementos);
		Arrays.sort(arrayOrdenado);
		return arrayOrdenado;
	}

	4 // Optiene el indice del elemento de entrada en un Array (Partidos Politicos) en
	// caso de INT cambiamos EQUALS por !=
	private static int indiceLocalidad(String localidad) {
		int indice = 0;
		while (indice < numlocalidades && !localidad.equals(localidades[indice])) {
			indice++;
		}
		return indice;
	}

	5 // Apartir de un numero optenemos el valor (Examen Canciones) Para optener un
	// elemento String atraves de un Entero
	private static String getNombreMes(int mes) {
		String[] meses = new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
				"Septiembre", "Octubre", "Noviembre", "Diciembre" };
		return meses[mes];
	}

	6 // INICIALIZA LA TABLA DE DATOS (Canciones)
	private static void inicializardatos() {
		for (int i = 0; i < MAXCANCIONES; i++) {
			for (int j = 0; j < MAXMESES; j++) {
				likes[i][j] = -1;
			}
		}
	}

	7 // Comprueba si el elemento de entrada ya esta en el Array (Canciones)
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

	 8 // Insertar Datos
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

	9 // Insertar un elemento en una posicion especifica en un Array moviendo los
	// datos (Lluvias)
	private static void insertarEnPosicion(float[] arrayDondeInsertar, int numElementos, float elemAInsertar, int pos,
			String[] arrayDondeInsertarStrings, String cadenaAInsertar) {
		for (int i = numElementos; i > pos; i--) {
			arrayDondeInsertar[i] = arrayDondeInsertar[i - 1];
			arrayDondeInsertarStrings[i] = arrayDondeInsertarStrings[i - 1];
		}

		arrayDondeInsertar[pos] = elemAInsertar;
		arrayDondeInsertarStrings[pos] = cadenaAInsertar;
	}
	 10 //Recorre la tabla mostrando los datos insertados en la tabla y ademas Alfabeticamente
	private static void mostrarVotos() {
        String[] partidosOrdenados = getOrdenarArray(partidos, numpartidos); // Ordenar ciudades
        for (int i = 0; i< numpartidos;i++) {
        	String partido = partidosOrdenados[i];
            int indice = indicePartido(partido);
            System.out.println("Partido " + partido);
            for (int j = 0; j < MAXLOCALIDADES; j++) {
                if (votos[indice][j] != 0) {
                    System.out.println(localidades[j]+" - "+votos[indice][j]+" votos");
                }
            }
        }
    }
}

