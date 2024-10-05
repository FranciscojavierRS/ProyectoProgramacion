package b3;

import java.util.Scanner;

public class Ej5_DNI {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el número de DNI: ");
        int numeroDNI = scanner.nextInt();

        String nombreDNI;
        switch (numeroDNI%23) {
            case 0:
                nombreDNI = "T";
                break;
            case 1:
                nombreDNI = "R";
                break;
            case 2:
                nombreDNI = "W";
                break;
            case 3:
                nombreDNI = "A";
                break;
            case 4:
                nombreDNI = "G";
                break;
            case 5:
                nombreDNI = "M";
                break;
            case 6:
                nombreDNI = "Y";
                break;
            case 7:
                nombreDNI = "F";
                break;
            case 8:
                nombreDNI = "P";
                break;
            case 9:
                nombreDNI = "D";
                break;
            case 10:
                nombreDNI = "X";
                break;
            case 11:
                nombreDNI = "B";
                break;
            case 12:
                nombreDNI = "N";
                break;
            case 13:
                nombreDNI = "J";
                break;
            case 14:
                nombreDNI = "Z";
                break;
            case 15:
                nombreDNI = "S";
                break;
            case 16:
                nombreDNI = "Q";
                break;
            case 17:
                nombreDNI = "V";
                break;
            case 18:
                nombreDNI = "H";
                break;
            case 19:
                nombreDNI = "L";
                break;
            case 20:
                nombreDNI = "C";
                break;
            case 21:
                nombreDNI = "K";
                break;
            case 22:
                nombreDNI = "E";
                break;
     
            default:
                nombreDNI = "Número de DNI no válido";
                break;
        }

        System.out.println("El DNI es: " + nombreDNI);

        scanner.close();
    }

	}


