package B1Funciones;

public class Ej4_ElMayorDeLos2 {

    // Función que devuelve el mayor de dos números enteros
    public static int obtenerMayor(int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la función
        int numero1 = 10;
        int numero2 = 20;

        int mayor = obtenerMayor(numero1, numero2);
        System.out.println("El mayor de los dos números es: " + mayor);
    }
}

