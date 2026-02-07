package ExamenArray21;

import java.util.Scanner;

public class ExamenMarta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// String [] sucursal = new String[10];
		// int [] año = new int [21]; 
		
        float [][] clientes = new float[21][10];

        inicializarTabla(clientes);
		
		
		
		
		

		int opcion = 0;

		while (opcion != 6) {

			System.out.println("1-Introducir dato.");
			System.out.println("2- Listar todos los datos.");
			System.out.println("3- Sucursal con más clientes en un año concreto.");
			System.out.println("4- Listado de sucursales y años con menos de 1000 clientes.");
			System.out.println("5- Listado ordenado de sucursales con más de 2000 clientes de media.");
			System.out.println("6- Fin.");

			opcion = sc.nextInt();

			switch (opcion) {

			case 1:
				
				introducirDatos(sc,clientes);
				break;

			case 2:

				break;
			case 3:

				break;

			case 4:

				break;
			case 5:

				break;

			case 6:

				break;

			default:

			}
			System.out.println("");
		}

		sc.close();
	}

	private static void introducirDatos(Scanner sc, float[][] clientes) {

		System.out.println(" Introduce número del año");
		int numeroaño = sc.nextInt()-1;
		
		System.out.println(" Introduce codigo de la sucursal");
		int sucursal = sc.nextInt();
		
		System.out.println("Introduce los clientes");
		int numeroclientes = sc.nextInt();

		
		int numeroClientes=getNumeroClientes(clientes[numeroclientes]);
		
		
		clientes[numeroaño][sucursal] = numeroclientes;
		
	
	}

	private static int getNumeroClientes(float[] clientes) { // este metedo calcula cuantos sobre con dinero existe en un mes

		int contadorClientes = 0;
		
		for (int j= 0; j<20; j++) {
			float clientesSucursal = clientes[j];
			if (clientesSucursal!=-1) {
				contadorClientes++;
			}else {
				break;
			}
		}
		
		return contadorClientes;
	}

	
	private static void inicializarTabla(float[][] clientes) {
		  for (int i = 0; i < 21; i++) {
	            for (int j = 0; j < 10; j++) {
	            	clientes[i][j] = -1;
	            }
	        }		
	}
}