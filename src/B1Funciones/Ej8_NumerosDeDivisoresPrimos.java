package B1Funciones;

public class Ej8_NumerosDeDivisoresPrimos {

    // Función que verifica si un número es primo
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Función que devuelve el número de divisores primos de un número dado
    public static int contarDivisoresPrimos(int numero) {
        int contador = 0;

        // Recorremos todos los posibles divisores hasta el valor del número
        for (int i = 2; i <= numero; i++) {
            // Verificamos si `i` es divisor y primo
            if (numero % i == 0 && esPrimo(i)) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la función
        int numero = 60;

        int divisoresPrimos = contarDivisoresPrimos(numero);
        System.out.println("El número de divisores primos de " + numero + " es: " + divisoresPrimos);
    }
}
