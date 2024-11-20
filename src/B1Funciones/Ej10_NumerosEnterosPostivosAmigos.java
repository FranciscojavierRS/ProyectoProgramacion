package B1Funciones;

public class Ej10_NumerosEnterosPostivosAmigos {

    // Función que calcula la suma de los divisores propios de un número
    public static int sumaDivisoresPropios(int numero) {
        int suma = 0;

        // Recorremos todos los números desde 1 hasta la mitad del número
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) { // Si `i` es divisor de `numero`
                suma += i;
            }
        }
        return suma;
    }

    // Función que verifica si dos números son amigos
    public static boolean sonAmigos(int numero1, int numero2) {
        // Verificamos la condición de números amigos
        return sumaDivisoresPropios(numero1) == numero2 && sumaDivisoresPropios(numero2) == numero1;
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la función
        int numero1 = 220;
        int numero2 = 284;

        if (sonAmigos(numero1, numero2)) {
            System.out.println("Los números " + numero1 + " y " + numero2 + " son amigos.");
        } else {
            System.out.println("Los números " + numero1 + " y " + numero2 + " no son amigos.");
        }
    }
}

