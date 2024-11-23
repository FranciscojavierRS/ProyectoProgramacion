package B1Funciones;

public class Ej7_EsteNumeroEsPrimo {

    // Función que verifica si un número es primo
    public static boolean esPrimo(int numero) {
        // Un número menor o igual a 1 no es primo
        if (numero <= 1) {
            return false;
        }

        // Verificamos divisores desde 2 hasta la raíz cuadrada del número
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Si es divisible por algún número, no es primo
            }
        }
        return true; // Si no tiene divisores, es primo
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la función
        int numero = 29;

        if (esPrimo(numero)) {
            System.out.println("El número " + numero + " es primo.");
        } else {
            System.out.println("El número " + numero + " no es primo.");
        }
    }
}
