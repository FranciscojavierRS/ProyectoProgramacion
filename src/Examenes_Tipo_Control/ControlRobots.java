package Examenes_Tipo_Control;

import java.util.Scanner;

public class ControlRobots {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int contN = 0;
		int contE = 0;
		int contJ = 0;
		int numMision = 1;
		int sumaDias = 0;
		int contMisiones = 0;
		int temperaturaMaxima = Integer.MIN_VALUE;
		String robotMayorTemp = "";
		int numMisionMayorTemp = 0;
		double sumaPresion = 0;
		int contPresion = 0;
		String menorPresionRobot = "";
		double menorPresionMedia = Double.MAX_VALUE;
		double menorRadiacion = Double.MAX_VALUE;
		double segundoMenorRadiacion = Double.MAX_VALUE;
		int contMisionMas5Dias = 0;
		int totalMisiones = 0;
		int longitudMaximaNombre = Integer.MIN_VALUE;
		int misionesPlanetaMasLargo = 0;
		String nombrePlanetaMasLargo = "";

		System.out.println("Cuantos robots han enviado datos");
		int numRobots = sc.nextInt();

		for (int i = 0; i < numRobots; i++) {
			numMision = 1;
			
			contPresion=0;
			sumaPresion=0;
			
			System.out.println("Introduce el nombre del Robot");
			String nombreRobots = sc.next();

			System.out.println("Nombre del planeta que visita");
			String nombrePlaneta = sc.next();

			if (nombrePlaneta.length() > longitudMaximaNombre) {
				longitudMaximaNombre = nombreRobots.length();
				nombrePlanetaMasLargo = nombrePlaneta;
				misionesPlanetaMasLargo = 0;

			}

			switch (nombreRobots.charAt(0)) {
			case 'N':
				contN++;
				break;
			case 'E':
				contE++;
				break;
			case 'J':
				contJ++;
				break;
			}

			System.out.println("Numero de dias para la mision: " + numMision + " -1 para finalizar");
			int numDias = sc.nextInt();

			while (numDias != -1) {
				contMisiones++;
				totalMisiones++;
				sumaDias += numDias;

				if (nombrePlaneta.equals(nombrePlanetaMasLargo)) {
					misionesPlanetaMasLargo++;

				}

				if (numDias > 5) {
					contMisionMas5Dias++;
				}

				for (int j = 1; j <= numDias; j++) {
					
					
					System.out.println("--Dia" + j);

					System.out.println("-- Temperatura para el dia 1 : " + j);
					int temperatura = sc.nextInt();

					System.out.println("--Presion para el dia  1 : " + j);
					double presion = sc.nextDouble();
					sumaPresion += presion;

					System.out.println("-- Nivel de radiación para el dia " + j);
					double radiacion = sc.nextDouble();

					if (temperatura > temperaturaMaxima) {
						temperaturaMaxima = temperatura;
						robotMayorTemp = nombreRobots;
						numMisionMayorTemp = numMision;
					}

					if (radiacion < menorRadiacion) {
						segundoMenorRadiacion = menorRadiacion;
						menorRadiacion = radiacion;

					} else if (radiacion < segundoMenorRadiacion) {
						segundoMenorRadiacion = radiacion;

					}

					contPresion++;

				}

				double mediaPresion = sumaPresion / contPresion;

				if (mediaPresion < menorPresionMedia) {
					menorPresionMedia = mediaPresion;
					menorPresionRobot = nombreRobots;

				}

				numMision++;
				System.out.println("Numero de dias para la mision: " + numMision + " -1 para finalizar");
				numDias = sc.nextInt();

			}

		}

		System.out.println("A)  Días promedio por misión: " + (double) sumaDias / contMisiones);

		if (contE >= 1 && contN >= 1 && contJ >= 1) {
			System.out.println("B) ¿Se han detectado robots de NASA, ESA y JAXA? SI");

		} else {
			System.out.println("¿Se han detectado robots de NASA, ESA y JAXA? NO");
		}

		System.out.println("C) Temperatura máxima registrada: " + temperaturaMaxima + "ºC (Robot: " + robotMayorTemp
				+ " Mision: " + numMisionMayorTemp);

		System.out.println(" D) Robot que ha registrado la menor presión media:" + menorPresionRobot);

		System.out.println("E) Indica los dos valores menores de radiación registrados" + segundoMenorRadiacion + ", "
				+ menorRadiacion);
		
		System.out.println("F) Porcentaje de misiones de más de 5 días " + (double)contMisionMas5Dias * 100 / totalMisiones);

		System.out.println("G) El número de misiones del planeta más largo es "+misionesPlanetaMasLargo);
		sc.close();
	}

}