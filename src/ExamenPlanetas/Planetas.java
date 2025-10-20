package ExamenPlanetas;

import java.util.Scanner;

public class Planetas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String tipoCuerpoCeleste = "";
		String nombreCuerpoCeleste = "";
		long distanciaSol = 0;
		long diametro = 0;
		int numeroSatelite = 0;
		int contadorPlanetaSatelite = 0;
		int contPlaneta = 0;
		String cuerpoCelesteMasCercanoAlSol ="";
		long distanciaMasCercanoSol = Long.MAX_VALUE;
		long diametroTotal = 0;
		int contadorCuerposCelestes = 0;
		int totalSatelites = 0;
		long diametroCuerpoCeleste = 0;
		String cuerpoCelesteMasSatelites = "";
		String cuerpoCelesteMasSatelites2 = "";
		int maxSatelites1 = -1;   
		int maxSatelites2 = -1;   

		
		System.out.println("Tipo cuerpo Celeste: ");
		tipoCuerpoCeleste = sc.next();

		while (!tipoCuerpoCeleste.equalsIgnoreCase("fin")) {
			System.out.println("Nombre del cuerpo celeste: ");
			nombreCuerpoCeleste = sc.next();
			contadorCuerposCelestes++;

			if (tipoCuerpoCeleste.equals("planeta")) {
				contPlaneta++;
			}

			System.out.println("Distancia al sol: ");
			distanciaSol = sc.nextLong();
			
			if (distanciaSol < distanciaMasCercanoSol) {
				distanciaMasCercanoSol = distanciaSol;
				cuerpoCelesteMasCercanoAlSol = nombreCuerpoCeleste;
			}

			System.out.println("Diametro: ");
			diametro = sc.nextLong();
			diametroCuerpoCeleste += diametro;

			if (tipoCuerpoCeleste.equals("planeta") || tipoCuerpoCeleste.equals("estrella")) {
				System.out.println("Numero de Satelites: ");
				numeroSatelite = sc.nextInt();

			
				if (numeroSatelite > maxSatelites1) {
					maxSatelites2 = maxSatelites1;
					cuerpoCelesteMasSatelites2 = cuerpoCelesteMasSatelites;
					maxSatelites1 = numeroSatelite;
					cuerpoCelesteMasSatelites = nombreCuerpoCeleste;
				} else if (numeroSatelite > maxSatelites2) {
					maxSatelites2 = numeroSatelite;
					cuerpoCelesteMasSatelites2 = nombreCuerpoCeleste;
				}

				if (numeroSatelite >= 1 && tipoCuerpoCeleste.equals("planeta")) {
					contadorPlanetaSatelite++;
				}

				for (int i = 0; i < numeroSatelite; i++) {
					System.out.println("Nombre satelite: ");
					String nombreSatelite = sc.next();

					System.out.println("Diametro (kms)");
					long diametroSatelite = sc.nextLong();
					
					diametroTotal += diametroSatelite;
					totalSatelites++;

					System.out.println("Rotacion Sincrona:");
					char rotacionSatelite = sc.next().charAt(0);

					if (rotacionSatelite == 'S') {
						System.out.println("f) Tierra tiene satélites con rotación síncrona: true");
					} else if (rotacionSatelite == 'N') {
						System.out.println("f) Tierra tiene satélites con rotación síncrona: false");
					}
				}
			}

			System.out.println("Tipo cuerpo Celeste: ");
			tipoCuerpoCeleste = sc.next();
		}

		System.out.println("a) Porcentaje de planetas que tienen algún satélite: "
				+ (float) contadorPlanetaSatelite * 100 / contPlaneta + "%");
		
		System.out.println("b) Nombre del cuerpo celeste más cercano al sol: " + cuerpoCelesteMasCercanoAlSol);
		
		System.out.println("c) Diámetro medio de todos los cuerpos celestes (incluyendo satélites): "
				+ (float)(diametroTotal + diametroCuerpoCeleste) / (contadorCuerposCelestes + totalSatelites));
		
		
		System.out.println("d) Nombre de los dos cuerpos celestes que más satélites tienen:");
		if (maxSatelites1 == -1) {
			System.out.println("   No se registraron cuerpos con satélites.");
		} else if (maxSatelites2 == -1) {
			System.out.println("   1º " + cuerpoCelesteMasSatelites + " con " + maxSatelites1 + " satélites.");
			System.out.println("   No hay un segundo cuerpo con satélites.");
		} else {
			System.out.println("   1º " + cuerpoCelesteMasSatelites + " con " + maxSatelites1 + " satélites.");
			System.out.println("   2º " + cuerpoCelesteMasSatelites2 + " con " + maxSatelites2 + " satélites.");
		}

		sc.close();
	}
}
