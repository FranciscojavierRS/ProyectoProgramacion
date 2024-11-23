package B1Funciones;

public class Ej11_Potencia {

	// Versión iterativa de la potencia
    public static double potenciaIterativa(double a, int n) {
        double resultado = 1;

        for (int i = 0; i < n; i++) {
            resultado *= a;
        }

        return resultado;
    }

    // Versión recursiva de la potencia
    public static double potenciaRecursiva(double a, int n) {
        // Caso base: cualquier número elevado a 0 es 1
        if (n == 0) {
            return 1;
        }
        // Caso recursivo
        return a * potenciaRecursiva(a, n - 1);
    }

    public static void main(String[] args) {
        double a = 2.0;
        int n = 5;

        System.out.println("Potencia iterativa: " + potenciaIterativa(a, n));
        System.out.println("Potencia recursiva: " + potenciaRecursiva(a, n));
    }
}