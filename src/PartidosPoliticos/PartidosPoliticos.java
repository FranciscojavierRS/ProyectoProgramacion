package PartidosPoliticos;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PartidosPoliticos {
    private static final int MAXPARTIDOS = 20;
    private static final int MAXLOCALIDADES = 30;
    private static int[][] votos = new int[MAXPARTIDOS][MAXLOCALIDADES]; //EJE I PARTIDOS EJE J LOCALIDADES
    private static int numpartidos = 0;
    private static int numlocalidades = 0;
    private static String[] partidos = new String[MAXPARTIDOS];
    private static String[] localidades = new String[MAXLOCALIDADES];


	public static void main(String[] args) {
		inicializarDatos();
		 Scanner sc = new Scanner(System.in);
	        int opcion = 0;

	        // Bucle principal para el menú interactivo
	        while (opcion != 6) {
	            System.out.println("1-Introducir votos optenidos en una ciudad por un partido\n" 
	                             + "2-Listado Alfabetico por partidos de todos los datos introducidos\n"
	                             + "3-Listado de mejores resultados de cada partido\n"
	                             + "4-Listado de localidades de menor a mayor participación\n"
	                             + "5-Porcentaje de votos obtenidos por cada partido en la comunidad\n" 
	                             + "6-Fin");

	            opcion = sc.nextInt(); // Leer la opción seleccionada por el usuario

	            // Ejecutar la opción correspondiente
	            switch (opcion) {
	                case 1: 
	                  insertarVotos(sc);
	                    break;
	                case 2: 
	                	mostrarVotos();
	                    break;
	                case 3: 
	                 mostrarMasVotados();
	                    break;
	                case 4: 
	                 localidadesOrdenadasPorVotos();
	                    break;
	                case 5: 
	                   porcentajePartidos();
	                    break;
	                default:
	                    break; // No hacer nada si la opción no es válida
	            }
	        }

	        sc.close();
	}


	private static void porcentajePartidos() {
		int[] totalVotosPartido=new int[numpartidos];
		int totalVotos=0;
			for (int i=0;i<numpartidos;i++) {
				totalVotosPartido[i] = 0;
				for(int j = 0; j<numlocalidades;j++) {
					totalVotosPartido[i]=totalVotosPartido[i]+votos[i][j];
				}
				totalVotos = totalVotos + totalVotosPartido[i];
			}
			
			for (int i=0;i<numpartidos;i++) {
				String partido = partidos[i];
				float porcentaje = (float) 100.00 * totalVotosPartido[i] / totalVotos;
				System.out.println("Partido: "+ partido + " el porcentaje de votos es de " +String.format("%.2f", porcentaje)  +"%");
			}
	}


	private static void localidadesOrdenadasPorVotos() {
		int[] totalVotosPorLocalidad=new int[numlocalidades];
		for (int i=0;i<numlocalidades;i++) {
			int totalVotos=0;
			for (int j=0; j<numpartidos;j++) {
				totalVotos=totalVotos+votos[j][i];
			}
			totalVotosPorLocalidad[i]=totalVotos;
		}
		
		int[] totalVotosPorLocalidadOrdenados=getOrdenarArray(totalVotosPorLocalidad, numlocalidades);
			for (int i=0;i<numlocalidades;i++) {
				int indiceLocalidad = indiceVotos(totalVotosPorLocalidadOrdenados[i], totalVotosPorLocalidad);
				String localidad = localidades[indiceLocalidad];
				System.out.println("La localidad "+localidad + " el numero de votos ha sido "+totalVotosPorLocalidadOrdenados[i]);
			}
	}


	private static void mostrarMasVotados() {
		for (int i=0;i<numpartidos;i++) {
			String partido=partidos[i];
			int indiceLocalidad=0;
			int maxVotos=0;
			for (int j=0; j<numlocalidades;j++) {
				if (votos[i][j]!=0 && votos[i][j]>maxVotos) {
					maxVotos=votos[i][j];
					indiceLocalidad=j;
				}
			}
			System.out.println("El partido " +partido+" ha obtenido mas votos en "+localidades[indiceLocalidad]+" con "+maxVotos+" votos");
		}
	}


	private static void insertarVotos(Scanner sc) {
		System.out.println("Introduce la localidad:");
        String localidad = sc.next();
        if (comprobarLocalidad(localidad)) {
            localidades[numlocalidades] = localidad;
            numlocalidades++;
        }
		
		System.out.println("Introduce el nombre del partido:");
        String partido = sc.next();

        if (comprobarPartido(partido)) {
            partidos[numpartidos] = partido;
            numpartidos++;
        }

        

        System.out.println("Introduce la cantidad de votos:");
        int numvotos = sc.nextInt();
        votos[indicePartido(partido)][indiceLocalidad(localidad)] = numvotos;

        System.out.println("Datos almacenados");
	}


	private static int indicePartido(String partido) {
		  int indice = 0;
	        while (indice < numpartidos && !partido.equals(partidos[indice])) {
	            indice++;
	        }
	        return indice;
	}
	private static int indiceVotos(int voto,int[] arrayVotos) {
		  int indice = 0;
	        while (indice < numlocalidades && voto!=arrayVotos[indice]) {
	            indice++;
	        }
	        return indice;
	}


	private static int indiceLocalidad(String localidad) {
		int indice = 0;
        while (indice < numlocalidades && !localidad.equals(localidades[indice])) {
            indice++;
        }
        return indice;
	}


	private static boolean comprobarLocalidad(String localidad) {
		for (String c : localidades) {
            if (localidad.equals(c)) {
                return false;  
            }
        }

        if (numlocalidades == MAXLOCALIDADES - 1) {
            System.out.println("Se ha alcanzado el número máximo de Localidades");
            return false;
        }

        return true; 
	}


	private static boolean comprobarPartido(String partido) {
		for (String c : partidos) {
            if (partido.equals(c)) {
                return false;  
            }
        }

        if (numpartidos == MAXPARTIDOS - 1) {
            System.out.println("Se ha alcanzado el número máximo de Partidos");
            return false;
        }

        return true; 
	}


	private static void inicializarDatos() {
		for (int i = 0; i < MAXPARTIDOS; i++) {
            for (int j = 0; j < MAXLOCALIDADES; j++) {
                votos[i][j] = 0;
            }
        }
		
	}
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
	// Ordena un array de cadenas alfabéticamente
    private static String[] getOrdenarArray(String[] array, int numElementos) {
        String[] arrayOrdenado = Arrays.copyOf(array, numElementos);
        Arrays.sort(arrayOrdenado);
        return arrayOrdenado;
    }
    private static int[] getOrdenarArrayReverse(int[] array, int numElementos) {
        int[] arrayOrdenado = Arrays.copyOf(array, numElementos);
        Arrays.sort(arrayOrdenado);
        
        int[] arrayOrdenadoReverse = new int[numElementos];
        int indice = 0;
        for(int i = numElementos-1; i>=0; i--) {
        	arrayOrdenadoReverse[indice] = arrayOrdenado[i];
        	indice++;
        }
        return arrayOrdenadoReverse;
    }
    
    private static int[] getOrdenarArray(int[] array, int numElementos) {
        int[] arrayOrdenado = Arrays.copyOf(array, numElementos);
        Arrays.sort(arrayOrdenado);
        
       
        return arrayOrdenado;
    }
}
