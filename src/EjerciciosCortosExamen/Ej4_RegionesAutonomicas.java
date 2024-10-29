package EjerciciosCortosExamen;

import java.util.Scanner;

/**Un país centroamericano se encuentra dividido en cuatro regiones autonómicas. La
región número 1 tiene 10 provincias, la número 2 tiene 4 provincias, la 3 tiene 6 provincias,
y la 4 sólo 1 provincia. Se pretende contabilizar los votos que se han efectuado en una de
las autonomías. Realiza un programa en Java que:
- Pida el número de región del que se van a introducir datos (sólo se van a introducir
datos de una autonomía).
- Pedir, para cada provincia de esa región, el nombre de la provincia, el número de
votos obtenido por el partido “A”, número de votos del partido “B”, y número de
abstenciones.
- Debe mostrarse al final: Porcentaje de votos totales y de abstención en la región.
Nombre de la provincia donde el partido “A” ha obtenido más votos, y donde el
partido “B” ha obtenido más votos. Si en alguna provincia el número de
abstenciones es mayor de 100.000, debe mostrarse al final el mensaje: “Alta
abstención”. */

public class Ej4_RegionesAutonomicas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaración de las variables necesarias
        String nombreProvinciaA = "", nombreProvinciaB = "";
        int votosTotales = 0, abstencionesTotales = 0;
        int maxVotosA = -1, maxVotosB = -1;
        boolean altaAbstencion = false;

        // Definición de las provincias según la región seleccionada
        String[] provincias = null;
        System.out.println("Seleccione el número de región (1 a 4): ");
        int region = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Asignamos las provincias dependiendo de la región seleccionada
        if (region == 1) {
            provincias = new String[10];
        } else if (region == 2) {
            provincias = new String[4];
        } else if (region == 3) {
            provincias = new String[6];
        } else if (region == 4) {
            provincias = new String[1];
        } else {
            System.out.println("Región inválida.");
            return; // Terminar el programa si la región no es válida
        }

        // Variables para la suma de votos en toda la región
        for (int i = 0; i < provincias.length; i++) {
            System.out.println("Ingrese el nombre de la provincia " + (i + 1) + ": ");
            String provincia = scanner.nextLine();
            provincias[i] = provincia;

            // Se piden los votos para A, B y las abstenciones
            System.out.println("Ingrese los votos para el partido A: ");
            int votosA = scanner.nextInt();
            System.out.println("Ingrese los votos para el partido B: ");
            int votosB = scanner.nextInt();
            System.out.println("Ingrese el número de abstenciones: ");
            int abstenciones = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            // Acumulación de votos y abstenciones
            votosTotales += votosA + votosB;
            abstencionesTotales += abstenciones;

            // Identificación de provincia con más votos para A y B
            if (votosA > maxVotosA) {
                maxVotosA = votosA;
                nombreProvinciaA = provincia;
            }
            if (votosB > maxVotosB) {
                maxVotosB = votosB;
                nombreProvinciaB = provincia;
            }

            // Verificar abstención alta
            if (abstenciones > 100000) {
                altaAbstencion = true;
            }
        }

        // Cálculo de porcentajes
        int totalRegion = votosTotales + abstencionesTotales;
        double porcentajeVotos = (votosTotales * 100.0) / totalRegion;
        double porcentajeAbstencion = (abstencionesTotales * 100.0) / totalRegion;

        // Mostrar resultados
        System.out.println("Porcentaje de votos totales en la región: " + String.format("%.2f", porcentajeVotos) + "%");
        System.out.println("Porcentaje de abstención en la región: " + String.format("%.2f", porcentajeAbstencion) + "%");
        System.out.println("Provincia donde el partido A obtuvo más votos: " + nombreProvinciaA);
        System.out.println("Provincia donde el partido B obtuvo más votos: " + nombreProvinciaB);

        // Verificar si hubo alta abstención
        if (altaAbstencion) {
            System.out.println("Alta abstención");
        }

        scanner.close();
    }
}

