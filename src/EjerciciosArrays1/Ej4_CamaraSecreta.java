package EjerciciosArrays1;

import java.util.Random;
import java.util.Scanner;

public class Ej4_CamaraSecreta {
	
	// Juego: La cámara secreta. El jugador especifica el número de dígitos de la clave
	// secreta. La aplicación genera de forma aleatoria, una combinación secreta de n dígitos del 1 al
	// 5 (siendo n la longitud indicada anteriormente por el usuario). El jugador introduce ahora una
	// combinación de prueba. En cada intento se mostrará como pista, para cada dígito, si es mayor
	// menor o igual que el correspondiente de la combinación secreta.
	
	

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        //  Pedir al jugador cuántos dígitos tendrá la clave
        System.out.print("Introduce el número de dígitos de la clave secreta: ");
        int n = sc.nextInt();

        //  Generar la combinación secreta (valores entre 1 y 5)
        int[] claveSecreta = new int[n];
        for (int i = 0; i < n; i++) {
            claveSecreta[i] = random.nextInt(5) + 1; // genera números del 1 al 5
        }

        int[] intento = new int[n];
        boolean acertado = false;

        System.out.println("\n¡Comienza el juego de la cámara secreta!");
        System.out.println("Debes introducir " + n + " números (del 1 al 5).");

        // 3 Bucle hasta acertar
        while (!acertado) {

            System.out.println("\nIntroduce tu combinación de prueba:");

            for (int i = 0; i < n; i++) {
                System.out.print("Número " + (i + 1) + ": ");
                intento[i] = sc.nextInt();
            }

            //  Mostrar pistas
            acertado = true; // suponemos que acierta, y verificamos
            System.out.println("Pistas:");

            for (int i = 0; i < n; i++) {
                if (intento[i] < claveSecreta[i]) {
                    System.out.println("Posición " + (i + 1) + ": Mayor");
                    acertado = false;
                } else if (intento[i] > claveSecreta[i]) {
                    System.out.println("Posición " + (i + 1) + ": Menor");
                    acertado = false;
                } else {
                    System.out.println("Posición " + (i + 1) + ": Correcto");
                }
            }

            if (acertado) {
                System.out.println("\n🎉 ¡Has acertado la clave secreta!");
            }
        }

        sc.close();
    }
}
