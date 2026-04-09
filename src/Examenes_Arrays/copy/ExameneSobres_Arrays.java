package Examenes_Arrays.copy;

import java.util.Scanner;

public class ExameneSobres_Arrays {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		float [][] dinero = new float[12][20];
		inicializarTabla(dinero);


		

		while (opcion != 5) {

			System.out.println("1- Introducir datos del envío de un sobre.");
			System.out.println(" 2- Mostrar todos los datos introducidos.");
			System.out.println("3- Mostrar el número del mes en que se envió más dinero en total, y la cantidad.");
			System.out.println("4- Mostrar cuál fue el número del mes cuyo último sobre tenía menos dinero.");
			System.out.println("5- Finalizar");
			

			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				introducirDatos(sc,dinero);

				break;

			case 2:
				mostrarLosDatos(dinero);
				
				break;
			case 3:
				mesQueSeEnvioMasDinero(dinero);
				break;

			case 4:
				mesSobreMenosDinero(dinero);
				
				break;
			case 5:
				
				break;

			

			default:

			}
			System.out.println("");
		}

		sc.close();
	}

	private static void mesSobreMenosDinero(float[][] dinero) {

		float minimaTransferencia = Float.MAX_VALUE;
		int indiceTransferencia = 0;
		
		for (int i=0; i<12; i++) {
			
			int numeroSobresMes = getNumeroSobre(dinero[i]);
			if(numeroSobresMes!=0) {
			float dineroSobre = dinero[i][numeroSobresMes-1];
			
			if (dineroSobre!=-1 && dineroSobre<minimaTransferencia) {
				minimaTransferencia=dineroSobre;
				indiceTransferencia=i;
				
			}
			}

		}
		
		System.out.println("El mes cuyo ultimo sobre contenia menos dinero fue el numero: "+(indiceTransferencia+1)+" y tenia la cantidad: "+minimaTransferencia);
	}

	private static void mesQueSeEnvioMasDinero(float[][] dinero) {

		float maximaTransferencia = 0;
		int indiceTransferencia = 0;
		
		for (int i=0; i<12; i++) {
			float dinerosSucursales = 0;
			
			
				for (int j=0; j<20; j++) {
					
					if (dinero[i][j] != -1) {
						dinerosSucursales += dinero[i][j];
					}
					
				}
				if (dinerosSucursales>maximaTransferencia) {
					maximaTransferencia=dinerosSucursales;
					indiceTransferencia=i;
				}
				
			}
		
		System.out.println("El mes que mas dinero se envio en sobre fue el numero: "+(indiceTransferencia+1)+" con un total de: "+maximaTransferencia);
	}

	private static void mostrarLosDatos(float[][] dinero) {

		for (int i=0; i<12; i++) {
			System.out.println("Mes "+(i+1)+"º:");
			
			for (int j=0; j<20; j++) {

				if (dinero[i][j]!=-1) {
					
				System.out.println((j+1)+"º: "+dinero[i][j]);
				}
				
			}
		}
	}

	private static void introducirDatos(Scanner sc, float[][] dinero) {

		System.out.println("número del mes del envío");
		int numeroMesEnvio = sc.nextInt()-1;
		
		System.out.println("cantidad que habia en el sobre");
		float cantidadDineroSobre = sc.nextFloat();
		//Como no tenemos Indice J tenemos que calcularlo
		
		int numeroSobre=getNumeroSobre(dinero[numeroMesEnvio]);
		
		
		dinero[numeroMesEnvio][numeroSobre] = cantidadDineroSobre;
		
		System.out.println("datos almacenados");
	}

	private static int getNumeroSobre(float[] sobres) { // este metedo calcula cuantos sobre con dinero existe en un mes

		int contadorSobreMes = 0;
		
		for (int j= 0; j<20; j++) {
			float dineroDentroSobre = sobres[j];
			if (dineroDentroSobre!=-1) {
				contadorSobreMes++;
			}else {
				break;
			}
		}
		
		return contadorSobreMes;
	}

	private static void inicializarTabla(float[][] dinero) {

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 20; j++) {
				dinero[i][j] = -1;
			}
		}
	}
	

}
