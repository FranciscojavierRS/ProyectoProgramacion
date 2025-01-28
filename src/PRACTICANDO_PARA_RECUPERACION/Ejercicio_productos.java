package PRACTICANDO_PARA_RECUPERACION;

import java.util.Scanner;

public class Ejercicio_productos {
    // Definimos constantes para el número máximo de meses y productos
	private static final int MAXMESES = 12;  // 12 meses del año
    private static final int MAXPRODUCTO = 10; // Máximo de 10 productos
    
    // Matriz que almacena la producción de cada producto en cada mes
    private static int[][] produccion = new int[MAXMESES][MAXPRODUCTO]; 
    
    // Contador de productos registrados
    private static int numproducto = 0;
    
    // Array para almacenar los nombres de los productos
    private static String[] nombreproductos = new String[MAXPRODUCTO]; 

	public static void main(String[] args) {
		// Inicializamos la matriz de producción con valores por defecto
		inicializarDatos();
		
		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		// Bucle principal para el menú interactivo
		while (opcion != 6) {
			System.out.println("1-Introducir datos de producción de un producto para un mes dado\n" 
					+ "2-Mostrar los datos de producción de todos los productos\n"
					+ "3-Mostrar el total de producción anual de un producto específico\n"
					+ "4-Mostrar el mes con mayor producción para un producto dado\n"
					+ "5-Mostrar el producto con la mayor producción total en todo el año\n"
					+ "6-Fin");

			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				// Opción para introducir la producción de un producto en un mes
				IntroducirDatos(sc);
				break;
			case 2:
				// Opción para mostrar los datos de todos los productos
				mostrarDatos();
				break;
			case 3:
				// Opción para mostrar la producción anual de un producto específico
				produccionAnual(sc);
				break;
			case 4:
				// Opción para mostrar el mes con mayor producción de un producto dado
				produccionMayor(sc);
				break;
			case 5:
				// Opción para mostrar el producto con mayor producción total en el año
				produccionMayorAño();
				break;
			default:
				break;
			}
		}

		sc.close(); // Cerrar el Scanner al finalizar
	}

	// Función para encontrar el producto con la mayor producción anual
	private static void produccionMayorAño() {
		int cantidadMaximaProducto = 0;  // Variable para almacenar la mayor cantidad de producción
		int indiceproducto = 0;  // Índice del producto con mayor producción anual
		
		// Iteramos sobre todos los productos para encontrar el de mayor producción
		for (int j = 0; j < numproducto; j++) {
			if (calculaProduccionAnual(j) > cantidadMaximaProducto) {
				cantidadMaximaProducto = calculaProduccionAnual(j);
				indiceproducto = j;
			}
		}
		System.out.println("EL PRODUCTO CON PRODUCCION ANUAL MAXIMA ES " + nombreproductos[indiceproducto]);
	}

	// Función para encontrar el mes con mayor producción para un producto dado
	private static void produccionMayor(Scanner sc) {
		System.out.println("Introduce el nombre del producto:");
        String producto = sc.next();  // Leer el nombre del producto
        int cantidadMaximaProducto = 0;  // Variable para almacenar la mayor cantidad de producción
        int indiceproducto = indiceproducto(producto);  // Obtener el índice del producto
        int mes = 0;  // Variable para almacenar el mes con mayor producción
        
        // Iterar sobre todos los meses para encontrar el mes con mayor producción para ese producto
        for (int i = 0; i < MAXMESES; i++) {
        	if (produccion[i][indiceproducto] > cantidadMaximaProducto) {
        		cantidadMaximaProducto = produccion[i][indiceproducto];
        		mes = i;  // Actualizamos el mes con mayor producción
        	}
        }
        // Mostrar el mes con la mayor producción
        System.out.println("El mes en el que se alcanzó la cantidad máxima es: " + (mes + 1));
	}

	// Función para calcular la producción anual de un producto específico
	private static void produccionAnual(Scanner sc) {
		System.out.println("Introduce el nombre del producto:");
        String producto = sc.next();  // Leer el nombre del producto
        int indiceproducto = indiceproducto(producto);  // Obtener el índice del producto
        int productosAnual = calculaProduccionAnual(indiceproducto);  // Calcular la producción anual
        
        // Mostrar la producción anual del producto
        System.out.println(productosAnual);		
	}

	// Función para calcular el total de producción anual de un producto
	private static int calculaProduccionAnual(int indiceproducto) {
		int productosAnual = 0;  // Variable para almacenar el total de producción
        for (int i = 0; i < MAXMESES; i++) {
        	// Sumar la producción de todos los meses del producto dado
        	if (produccion[i][indiceproducto] != -1) {
        		productosAnual = productosAnual + produccion[i][indiceproducto];
        	}
        }
		return productosAnual;  // Devolver el total de producción anual
	}

	// Función para mostrar los datos de todos los productos
	private static void mostrarDatos() {
		// Iteramos sobre todos los productos y mostramos los datos de producción
		for (int j = 0; j < numproducto; j++) {
			System.out.println("Nombre del producto: " + nombreproductos[j]);
			// Mostramos la producción para cada mes
			for (int i = 0; i < MAXMESES; i++) {
				if (produccion[i][j] != -1) {
					System.out.println("MES: " + (i + 1) + " CANTIDAD " + produccion[i][j]);
				}
			}
		}
	}

	// Función para introducir los datos de un producto en un mes específico
	private static void IntroducirDatos(Scanner sc) {
		// Pedimos el nombre del producto
		System.out.println("Introduce el nombre del producto:");
	    String producto = sc.next();
	    
	    // Comprobamos si el producto es nuevo y lo añadimos
	    if (comprobarproducto(producto)) {
	    	nombreproductos[numproducto] = producto;
	    	numproducto++;
	    }
	    
	    // Pedimos el número del mes y la cantidad de producción
	    System.out.println("Introduce el numero del MES:");
        int mes = sc.nextInt();

        System.out.println("Introduce la cantidad del producto en dicho mes:");
        int cantidad = sc.nextInt();
        
        // Almacenamos la cantidad en la matriz de producción
        produccion[mes - 1][indiceproducto(producto)] = cantidad;
	}
	
	// Función para obtener el índice de un producto dado su nombre
	private static int indiceproducto(String producto) {
		int indice = 0;
		// Buscar el índice del producto en el array
	    while (indice < numproducto && !producto.equals(nombreproductos[indice])) {
	        indice++;
	    }
	    return indice;
	}

	// Función para comprobar si un producto ya existe
	private static boolean comprobarproducto(String producto) {
		// Recorrer el array de productos para comprobar si ya existe
		for (String c : nombreproductos) {
	        if (producto.equals(c)) {
	            return false;  // Si existe, devolvemos false
	        }
		}
		return true;  // Si no existe, devolvemos true
	}

	// Función para inicializar la matriz de producción con valores por defecto (-1)
	private static void inicializarDatos() {
		// Rellenamos la matriz con -1 para indicar que no hay datos aún
		for (int i = 0; i < MAXMESES; i++) {
	        for (int j = 0; j < MAXPRODUCTO; j++) {
	        	produccion[i][j] = -1;
	        }
	    }
	}
}
