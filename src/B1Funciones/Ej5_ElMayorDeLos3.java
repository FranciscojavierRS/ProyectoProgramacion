package B1Funciones;

public class Ej5_ElMayorDeLos3 {

    // Función que devuelve el mayor de dos números enteros
    public static int obtenerMayor(int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }

    // Función que devuelve el mayor de tres números enteros
    public static int obtenerMayorDeTres(int num1, int num2, int num3) {
        // Usa la función obtenerMayor para comparar el primer y segundo número,
        // y luego el resultado con el tercer número.
        return obtenerMayor(obtenerMayor(num1, num2), num3);
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la función
        int numero1 = 10;
        int numero2 = 20;
        int numero3 = 15;

        int mayor = obtenerMayorDeTres(numero1, numero2, numero3);
        System.out.println("El mayor de los tres números es: " + mayor);
    }
}
