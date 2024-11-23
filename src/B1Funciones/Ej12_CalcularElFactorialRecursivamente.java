package B1Funciones;

public class Ej12_CalcularElFactorialRecursivamente {

    // Función recursiva para calcular el factorial de n
    public static int factorial(int n) {
        // Caso base: el factorial de 0 es 1
        if (n == 0) {
            return 1;
        }
        // Caso recursivo: n * factorial de (n - 1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int numero = 5;
        int resultado = factorial(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado);
    }
}
