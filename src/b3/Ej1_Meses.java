package b3;

import java.util.Scanner;

public class Ej1_Meses {


		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        System.out.print("Introduce el número de un mes (1-12): ");
		        int numeroMes = scanner.nextInt();

		        String nombreMes;
		        switch (numeroMes) {
		            case 1:
		                nombreMes = "Enero";
		                break;
		            case 2:
		                nombreMes = "Febrero";
		                break;
		            case 3:
		                nombreMes = "Marzo";
		                break;
		            case 4:
		                nombreMes = "Abril";
		                break;
		            case 5:
		                nombreMes = "Mayo";
		                break;
		            case 6:
		                nombreMes = "Junio";
		                break;
		            case 7:
		                nombreMes = "Julio";
		                break;
		            case 8:
		                nombreMes = "Agosto";
		                break;
		            case 9:
		                nombreMes = "Septiembre";
		                break;
		            case 10:
		                nombreMes = "Octubre";
		                break;
		            case 11:
		                nombreMes = "Noviembre";
		                break;
		            case 12:
		                nombreMes = "Diciembre";
		                break;
		            default:
		                nombreMes = "Número de mes no válido";
		                break;
		        }

		        System.out.println("El mes es: " + nombreMes);

		        scanner.close();
		    }
		}

	


