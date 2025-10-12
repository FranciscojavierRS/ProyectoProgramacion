package VariablesYoperacionesVasicas;

import java.util.Scanner;

public class ConvertidorSegundosMinutosHorasEj8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce las horas: ");
        int horas = sc.nextInt();
        System.out.print("Introduce los minutos: ");
        int minutos = sc.nextInt();
        System.out.print("Introduce los segundos: ");
        int segundos = sc.nextInt();

        if (segundos >= 60) {
            minutos += segundos / 60; 
            segundos = segundos % 60; 
        }

        
        if (minutos >= 60) {
            horas += minutos / 60; 
            minutos = minutos % 60; 
        }

        
        System.out.printf("Tiempo normalizado: %d horas, %d minutos, %d segundos%n",
                horas, minutos, segundos);

        sc.close();
    }
}
