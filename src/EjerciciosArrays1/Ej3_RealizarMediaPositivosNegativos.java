package EjerciciosArrays1;

import java.util.Scanner;

public class Ej3_RealizarMediaPositivosNegativos {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //  Pedir cuántos números se van a introducir
        System.out.print("¿Cuántos números deseas introducir?: ");
        int n = sc.nextInt();
        
        // Crear el array
        int[] numeros = new int[n];
        
        // Variables 
        int contadorPositivos = 0;
        int	contadorNegativos = 0;
        int contadorCeros = 0;
        double sumaPositivos = 0; 
        int sumaNegativos = 0;
        
        //  Pedir los números
        for (int i = 0; i < n; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
            
            if (numeros[i] > 0) {
                sumaPositivos += numeros[i];
                contadorPositivos++;
            } else if (numeros[i] < 0) {
                sumaNegativos += numeros[i];
                contadorNegativos++;
            } else {
                contadorCeros++;
            }
        }
        
        //  Calcular las medias (con control de división por cero)
        double mediaPositivos = (contadorPositivos > 0) ? (sumaPositivos / contadorPositivos) : 0;
        double mediaNegativos = (contadorNegativos > 0) ? (sumaNegativos / contadorNegativos) : 0;
        
        //  Mostrar resultados
        System.out.println("\n--- Resultados ---");
        if (contadorPositivos > 0)
            System.out.println("Media de positivos: " + mediaPositivos);
        else
            System.out.println("No se introdujeron números positivos.");
        
        if (contadorNegativos > 0)
            System.out.println("Media de negativos: " + mediaNegativos);
        else
            System.out.println("No se introdujeron números negativos.");
        
        System.out.println("Cantidad de ceros introducidos: " + contadorCeros);
        
        sc.close();
    }
}
