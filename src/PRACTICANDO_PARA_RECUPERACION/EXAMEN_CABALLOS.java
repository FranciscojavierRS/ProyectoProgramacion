package PRACTICANDO_PARA_RECUPERACION;

import java.util.Arrays;
import java.util.Scanner;

public class EXAMEN_CABALLOS {
	private static final int MAXCABALLOS = 15;
    private static final int MAXCARRERA = 10;
    private static float[][] velocidades = new float[MAXCABALLOS][MAXCARRERA];
    private static int numcaballos = 0;
    private static String[] ciudades = new String[MAXCARRERA];
    private static String[] caballos = new String[MAXCABALLOS];
	public static void main(String[] args) {
		inicializarDatos();
		Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Bucle principal para el menú interactivo
        while (opcion != 6) {
            System.out.println("1-Introducir caballo,carrera,ciudad y velocidad\n" + "2-Listar todos los datos\n"
					+ "3-Indicar en que ciudad ha habido mas carreras\n"
					+ "4-Listado de carreras junto con el caballo ha quedado en ultima posicion\n"
					+ "5-Listado de caballo de velocidades media\n" + "6-Fin");

            opcion = sc.nextInt();
            switch (opcion) {
            case 1: 
              insertarCarrera(sc);
                break;
            case 2: 
            	mostrarDatos();
                break;
            case 3: 
             CiudadMasCarreras();
                break;
            case 4: 
            CaballoMasLento();
                break;
            case 5: 
               OrdenadoAlfabeticamente();
                break;
            default:
                break; 
        }
        }
        
        sc.close();
		
	}
	private static void OrdenadoAlfabeticamente() {
		String[] caballosOrdenados=getOrdenarArray(caballos, numcaballos);
		System.out.println("Caballos ordenados alfabeticamente");
	for (int i=0; i<numcaballos;i++) {
		
		int indice = indiceCaballo(caballosOrdenados[i]);
		float sumaVelocidad=0;
		int numcarreras=0;
			for (int j=0; j<MAXCARRERA; j++) {
				if (0!=velocidades[indice][j]) {
					sumaVelocidad=sumaVelocidad+velocidades[indice][j];
					numcarreras++;
				}
			}
			System.out.println(caballosOrdenados[i] +": "+sumaVelocidad/numcarreras);
	}
		
	}
	private static String[] getOrdenarArray(String[] array, int numElementos) {
		String[] arrayOrdenado = Arrays.copyOf(array, numElementos);
        Arrays.sort(arrayOrdenado);
        return arrayOrdenado;	
    }
	private static void CaballoMasLento() {
		
			for (int j= 0; j < MAXCARRERA;j++) {
				int indiceCaballo=-1;
				float maxVelocidad=99999;
				for (int i= 0; i < numcaballos;i++) {
					float velocidadActual= velocidades[i][j];
						if(velocidadActual!=0 && velocidadActual<maxVelocidad) {
							indiceCaballo=i;
							maxVelocidad=velocidadActual;
						}
				}
				if(-1!=indiceCaballo) {
				System.out.println("CARRERA "+(j+1)+ "--> "+caballos[indiceCaballo]);
				}
			}
	}
	private static void CiudadMasCarreras() {
		String ciudadMasRepetida= "";
		int maxRepeticiones= 0;
        	for (int i =0; i <MAXCARRERA; i++ ) {
        	int repeticiones = 0;
        	 String ciudadActual=ciudades[i];
        	 for (int j=i+1; j<MAXCARRERA; j++) {
        		 if (null !=ciudadActual && ciudadActual.equals(ciudades[j])) {
        			 repeticiones++;
        		 }
        	 }
        	 if (repeticiones>maxRepeticiones) {
        	 ciudadMasRepetida=ciudadActual;
        	 }
        	}
        	
        	System.out.println(ciudadMasRepetida);
	}
	
	private static void mostrarDatos() {
		for (int i = 0; i < numcaballos; i++) {
			System.out.println("CABALLO : "+caballos[i]);
            for (int j = 0; j < MAXCARRERA; j++) {
                if (velocidades[i][j]!= 0) { // Verificar si hay carrera registrado
                    System.out.println("CARRERA "+j+"("+ciudades[j]+"): "+velocidades[i][j]);
                }
            }
        }	
	}
	private static void insertarCarrera(Scanner sc) {
		System.out.println("Introduce Nombre caballo:");
        String caballo = sc.next();
        if (comprobarCaballo(caballo)) {
           caballos[numcaballos] = caballo;
            numcaballos++;
        }
		
		System.out.println("Introduce la carrera:");
        int carrera = sc.nextInt();

        if (comprobarCarrera(carrera)) {
        	System.out.println("Introduce Nombre ciudad:");
            String ciudad = sc.next();
            ciudades[carrera-1] = ciudad;
        }

        

        System.out.println("Introduce la velocidad:");
        float velocidad = sc.nextFloat();
        velocidades[indiceCaballo(caballo)][carrera-1] = velocidad;

        System.out.println("Datos almacenados");
	}		
	private static int indiceCaballo(String caballo) {
		int indice = 0;
        while (indice < numcaballos && !caballo.equals(caballos[indice])) {
            indice++;
        }
        return indice;
	}
	private static boolean comprobarCarrera(int carrera) {
		
		return null==ciudades[carrera-1];
	}
	private static boolean comprobarCaballo(String caballo) {
		for (String c : caballos) {
            if (caballos.equals(c)) {
                return false;  
            }
        }

        if (numcaballos == MAXCABALLOS - 1) {
            System.out.println("Se ha alcanzado el número máximo de Localidades");
            return false;
        }

        return true;
		
		
		
	}
	
	private static void inicializarDatos() {
		for (int i = 0; i < MAXCABALLOS; i++) {
            for (int j = 0; j < MAXCARRERA; j++) {
            	velocidades[i][j] = 0;
            }
        }
	}

}
