package PRACTICANDO_PARA_RECUPERACION;

import java.util.Arrays;
import java.util.Scanner;

public class EXAMEN_CABALLOS {
    // Constantes para el máximo de caballos y carreras
	private static final int MAXCABALLOS = 15;
    private static final int MAXCARRERA = 10;
    
    // Matriz que almacena las velocidades de los caballos en diferentes carreras
    private static float[][] velocidades = new float[MAXCABALLOS][MAXCARRERA];
    
    // Contador de caballos y arrays para almacenar los nombres de las ciudades y caballos
    private static int numcaballos = 0;
    private static String[] ciudades = new String[MAXCARRERA];
    private static String[] caballos = new String[MAXCABALLOS];
    
    public static void main(String[] args) {
        // Inicializar los datos de la matriz de velocidades y otros valores
		inicializarDatos();
		Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Bucle principal del menú interactivo
        while (opcion != 6) {
            // Mostrar las opciones del menú
            System.out.println("1-Introducir caballo, carrera, ciudad y velocidad\n" + 
                               "2-Listar todos los datos\n" +
							   "3-Indicar en qué ciudad ha habido más carreras\n" +
							   "4-Listado de carreras junto con el caballo que ha quedado en última posición\n" +
							   "5-Listado de caballos con velocidades medias\n" + 
							   "6-Fin");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    // Opción para insertar los datos de una carrera
                    insertarCarrera(sc);
                    break;
                case 2:
                    // Opción para mostrar los datos de todos los caballos
                    mostrarDatos();
                    break;
                case 3:
                    // Opción para encontrar la ciudad con más carreras
                    CiudadMasCarreras();
                    break;
                case 4:
                    // Opción para mostrar el caballo con la velocidad más baja en cada carrera
                    CaballoMasLento();
                    break;
                case 5:
                    // Opción para mostrar los caballos ordenados alfabéticamente con su velocidad media
                    OrdenadoAlfabeticamente();
                    break;
                default:
                    break;
            }
        }
        sc.close();
	}
    
    // Muestra los caballos ordenados alfabéticamente junto con su velocidad media
	private static void OrdenadoAlfabeticamente() {
        // Obtener una lista de caballos ordenada alfabéticamente
		String[] caballosOrdenados = getOrdenarArray(caballos, numcaballos);
		System.out.println("Caballos ordenados alfabéticamente:");
		
        // Para cada caballo, calcular su velocidad media
		for (int i = 0; i < numcaballos; i++) {
			int indice = indiceCaballo(caballosOrdenados[i]);
			float sumaVelocidad = 0;
			int numcarreras = 0;
            
            // Sumar las velocidades del caballo en todas las carreras
			for (int j = 0; j < MAXCARRERA; j++) {
				if (0 != velocidades[indice][j]) {
					sumaVelocidad = sumaVelocidad + velocidades[indice][j];
					numcarreras++;
				}
			}
            // Mostrar el nombre del caballo y su velocidad media
			System.out.println(caballosOrdenados[i] + ": " + sumaVelocidad / numcarreras);
		}
	}

    // Ordena un array alfabéticamente y devuelve una copia ordenada
	private static String[] getOrdenarArray(String[] array, int numElementos) {
		String[] arrayOrdenado = Arrays.copyOf(array, numElementos);
        Arrays.sort(arrayOrdenado);
        return arrayOrdenado;	
    }

    // Muestra el caballo que ha quedado en última posición (velocidad más baja) en cada carrera
	private static void CaballoMasLento() {
        // Iterar por cada carrera
		for (int j = 0; j < MAXCARRERA; j++) {
			int indiceCaballo = -1;
			float maxVelocidad = 99999; // Valor arbitrario grande para comparar
			
            // Buscar el caballo con la velocidad más baja en la carrera actual
			for (int i = 0; i < numcaballos; i++) {
				float velocidadActual = velocidades[i][j];
				if (velocidadActual != 0 && velocidadActual < maxVelocidad) {
					indiceCaballo = i;
					maxVelocidad = velocidadActual;
				}
			}
            
            // Mostrar el caballo más lento en la carrera actual
			if (-1 != indiceCaballo) {
				System.out.println("CARRERA " + (j + 1) + " --> " + caballos[indiceCaballo]);
			}
		}
	}

    // Encuentra la ciudad con más carreras
	private static void CiudadMasCarreras() {
		String ciudadMasRepetida = "";
		int maxRepeticiones = 0;
        
        // Contar cuántas veces se repite cada ciudad
        for (int i = 0; i < MAXCARRERA; i++) {
        	int repeticiones = 0;
        	String ciudadActual = ciudades[i];
        	
            // Comparar la ciudad actual con las demás para contar repeticiones
            for (int j = i + 1; j < MAXCARRERA; j++) {
        		if (null != ciudadActual && ciudadActual.equals(ciudades[j])) {
        			repeticiones++;
        		}
        	}
            
            // Actualizar la ciudad más repetida si es necesario
        	if (repeticiones > maxRepeticiones) {
        		ciudadMasRepetida = ciudadActual;
        		maxRepeticiones = repeticiones;
        	}
        }
        
        // Mostrar la ciudad con más carreras
        System.out.println(ciudadMasRepetida);
	}

    // Muestra los datos de todos los caballos y sus velocidades en cada carrera
	private static void mostrarDatos() {
		for (int i = 0; i < numcaballos; i++) {
			System.out.println("CABALLO: " + caballos[i]);
            for (int j = 0; j < MAXCARRERA; j++) {
                if (velocidades[i][j] != 0) { // Solo mostrar carreras con datos
                    System.out.println("CARRERA " + j + " (" + ciudades[j] + "): " + velocidades[i][j]);
                }
            }
        }	
	}

    // Inserta los datos de una carrera: caballo, ciudad, y velocidad
	private static void insertarCarrera(Scanner sc) {
        // Introducir el nombre del caballo
		System.out.println("Introduce Nombre caballo:");
        String caballo = sc.next();
        
        // Si el caballo no existe, agregarlo a la lista
        if (comprobarCaballo(caballo)) {
            caballos[numcaballos] = caballo;
            numcaballos++;
        }
		
        // Introducir el número de la carrera
		System.out.println("Introduce la carrera:");
        int carrera = sc.nextInt();

        // Introducir la ciudad si es una nueva carrera
        if (comprobarCarrera(carrera)) {
        	System.out.println("Introduce Nombre ciudad:");
            String ciudad = sc.next();
            ciudades[carrera - 1] = ciudad;
        }

        // Introducir la velocidad del caballo en la carrera
        System.out.println("Introduce la velocidad:");
        float velocidad = sc.nextFloat();
        velocidades[indiceCaballo(caballo)][carrera - 1] = velocidad;

        System.out.println("Datos almacenados");
	}

    // Devuelve el índice del caballo dado su nombre
	private static int indiceCaballo(String caballo) {
		int indice = 0;
        while (indice < numcaballos && !caballo.equals(caballos[indice])) {
            indice++;
        }
        return indice;
	}

    // Comprueba si la carrera ya ha sido registrada
	private static boolean comprobarCarrera(int carrera) {
		return null == ciudades[carrera - 1];
	}

    // Comprueba si el caballo ya está registrado en la lista
	private static boolean comprobarCaballo(String caballo) {
		for (String c : caballos) {
            if (caballo.equals(c)) {
                return false;  
            }
        }

        if (numcaballos == MAXCABALLOS - 1) {
            System.out.println("Se ha alcanzado el número máximo de caballos");
            return false;
        }

        return true;
	}

    // Inicializa los datos de la matriz de velocidades a 0
	private static void inicializarDatos() {
		for (int i = 0; i < MAXCABALLOS; i++) {
            for (int j = 0; j < MAXCARRERA; j++) {
            	velocidades[i][j] = 0;
            }
        }
	}
}
