package EjerciciosCortosExamen;

import java.util.Scanner;

/** 3.- Una empresa fabrica motores de automóviles. Se pretende contabilizar las unidades
fabricadas cada mes. Para ello, disponemos del número de motores que se ha fabricado
cada día. Realizar un programa en Java que:
- Pida el número del mes que se va a introducir (sólo se van a introducir datos de un
mes).
- Para cada día de ese mes debe pedir el número de piezas que se ha fabricado.
Sabemos que en un día nunca se van a fabricar más de 1000 piezas. No todos los
meses tienen igual número de días; consideramos febrero con 28 días.
- Debe mostrarse al final: Qué día se fabricaron más piezas. Cuál fue el mínimo de
piezas fabricadas. Cuántos motores se han fabricado en el mes. Si algún día se ha
fabricado menos de 300 piezas, debe indicarse al final con el mensaje: “Existen días
por debajo del mínimo”.
*/

public class Ej3_MotoresAutomoviles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir el número del mes
        System.out.println("Introduce el número del mes (1 a 12): ");
        int mes = scanner.nextInt();

        // Validación del mes
        while (mes < 1 || mes > 12) {
            System.out.println("Mes no válido. Introduce un número de mes entre 1 y 12: ");
            mes = scanner.nextInt();
        }

        // Determinar el número de días del mes según el valor del mes
        int diasDelMes;
        switch (mes) {
            case 2:
                diasDelMes = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diasDelMes = 30;
                break;
            default:
                diasDelMes = 31;
                break;
        }

        // Variables para almacenar resultados
        int maxPiezas = 0;
        int diaMaxPiezas = 0;
        int minPiezas = 1000; // No se fabrican más de 1000 piezas por día
        int totalPiezas = 0;
        boolean hayDiasPorDebajoMinimo = false;

        // Solicitar el número de piezas fabricadas cada día del mes
        for (int dia = 1; dia <= diasDelMes; dia++) {
            System.out.println("Introduce las piezas fabricadas el día " + dia + ": ");
            int piezas = scanner.nextInt();

            // Validación del número de piezas
            while (piezas < 0 || piezas > 1000) {
                System.out.println("Número de piezas no válido. Introduce un valor entre 0 y 1000: ");
                piezas = scanner.nextInt();
            }

            // Acumular el total de piezas
            totalPiezas += piezas;

            // Determinar el día con más piezas fabricadas
            if (piezas > maxPiezas) {
                maxPiezas = piezas;
                diaMaxPiezas = dia;
            }

            // Determinar el mínimo de piezas fabricadas
            if (piezas < minPiezas) {
                minPiezas = piezas;
            }

            // Comprobar si algún día se fabricaron menos de 300 piezas
            if (piezas < 300) {
                hayDiasPorDebajoMinimo = true;
            }
        }

        // Resultados
        System.out.println("Total de motores fabricados en el mes: " + totalPiezas);
        System.out.println("El día que se fabricaron más piezas fue el día " + diaMaxPiezas + " con " + maxPiezas + " piezas.");
        System.out.println("El mínimo de piezas fabricadas en un día fue: " + minPiezas);
        
        if (hayDiasPorDebajoMinimo) {
            System.out.println("Existen días por debajo del mínimo.");
        }
    }
}

