package B1Funciones;

public class Ej6_BooleanVocal {

    // Función que verifica si un carácter es una vocal
    public static boolean esVocal(char c) {
        // Convertimos el carácter a minúscula para simplificar la comparación
        c = Character.toLowerCase(c);

        // Verificamos si es una vocal
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la función
        char caracter = 'A';

        if (esVocal(caracter)) {
            System.out.println("El carácter '" + caracter + "' es una vocal.");
        } else {
            System.out.println("El carácter '" + caracter + "' no es una vocal.");
        }
    }
}
