package Boletin1_EstructuraCondicional;

import java.util.Scanner;

public class GravedadyTiempoEJ6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

         double GRAVEDAD = 9.8;

        System.out.print("Introduce el valor del tiempo (en segundos): ");
        double tiempo = sc.nextDouble();

        if (tiempo <= 0) {
            System.out.println("Tiempo incorrecto");
        } else {
            double velocidad = GRAVEDAD * tiempo;
            System.out.println("La velocidad es: " + velocidad + " m/s");
        }

        sc.close();
    }
}