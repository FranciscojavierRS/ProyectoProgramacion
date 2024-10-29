package ExamenEspacio;

import java.util.Scanner;


/** La BASA (Brothers Aeronautics and Space Administration) desea hacer
una estudio sobre las estrellas, planetas, satélites y agujeros negros de la vía láctea. Realiza un
programa en Java que permita la introducción de datos, y posteriormente muestre unos resultados.
Los datos se pedirán de la siguiente forma:
En primer lugar, se pedirá el tipo de cuerpo celeste que se va a introducir (estrella, planeta o
agujero), debiendo parar de pedir datos cuando se introduzca como tipo la palabra “fin”. A
continuación, pedirá el nombre del cuerpo celeste, así como su distancia al Sol y su diámetro. Si se
trata de una estrella o un planeta, deberá preguntar además cuántos satélites tiene. Para cada satélite,
se pedirá su nombre, su diámetro y si tiene rotación síncrona respecto del cuerpo sobre el que orbita.
(1 punto la petición correcta de datos).
Los resultados que se deben mostrar al finalizar la introducción de datos son:
a) (1,5 puntos) Porcentaje de planetas que tienen algún satélite.
b) (1,5 puntos) Nombre del cuerpo celeste más cercano al sol.
c) (1,5 puntos) Diámetro medio de todos los cuerpos celestes (incluyendo satélites).
d) (1,5 puntos) Nombre de los dos cuerpos celestes que más satélites tienen..
e) (1,5 puntos) Cuál ha sido el diámetro del cuerpo más grande de entre los que están a menos
de 230000000 de distancia del sol.
f) (1,5 puntos) Para cada cuerpo celeste con satélites, debe mostrarse un mensaje indicando si
tiene algún satélite con rotación síncrona. El formato del mensaje será: “NOMBRE_CUERPO
tiene satélites con rotación síncrona: true/false”. */


public class EspacioPlanetas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalCuerpos = 0;
        int totalPlanetas = 0;
        int planetasConSatelites = 0;
        double sumaDiametros = 0.0;
        String cuerpoMasCercano = "";
        double distanciaMinimaAlSol = Double.MAX_VALUE;
        String cuerpoConMasSatelites1 = "";
        String cuerpoConMasSatelites2 = "";
        int maxSatelites1 = 0;
        int maxSatelites2 = 0;
        double maxDiametroMenorDistancia = 0.0;

        while (true) {
            System.out.println("Introduce el tipo de cuerpo celeste (estrella, planeta, agujero o 'fin' para terminar): ");
            String tipoCuerpo = scanner.next().toLowerCase();

            if (tipoCuerpo.equals("fin")) break;

            System.out.println("Introduce el nombre del cuerpo celeste: ");
            String nombreCuerpo = scanner.next();

            System.out.println("Introduce la distancia al Sol (en km): ");
            double distanciaAlSol = scanner.nextDouble();

            System.out.println("Introduce el diámetro (en km): ");
            double diametro = scanner.nextDouble();

            // Acumular datos generales
            totalCuerpos++;
            sumaDiametros += diametro;

            // Verificar cuerpo más cercano al Sol
            if (distanciaAlSol < distanciaMinimaAlSol) {
                distanciaMinimaAlSol = distanciaAlSol;
                cuerpoMasCercano = nombreCuerpo;
            }

            // Verificar el cuerpo más grande a menos de 230,000,000 km del Sol
            if (distanciaAlSol < 230000000 && diametro > maxDiametroMenorDistancia) {
                maxDiametroMenorDistancia = diametro;
            }

            // Para planetas y estrellas, manejar satélites
            int satelitesActual = 0;
            boolean tieneSateliteConRotacionSincrona = false;
            if (tipoCuerpo.equals("planeta") || tipoCuerpo.equals("estrella")) {
                System.out.println("Introduce el número de satélites: ");
                int numeroSatelites = scanner.nextInt();

                if (numeroSatelites > 0 && tipoCuerpo.equals("planeta")) {
                    planetasConSatelites++;
                }

                for (int j = 0; j < numeroSatelites; j++) {
                    System.out.println("Introduce el nombre del satélite: ");
                    String nombreSatelite = scanner.next();

                    System.out.println("Introduce el diámetro del satélite (en km): ");
                    double diametroSatelite = scanner.nextDouble();
                    sumaDiametros += diametroSatelite;

                    System.out.println("¿Tiene rotación síncrona respecto del cuerpo? (true/false): ");
                    boolean rotacionSincrona = scanner.nextBoolean();

                    if (rotacionSincrona) {
                        tieneSateliteConRotacionSincrona = true;
                    }

                    satelitesActual++;
                }

                // Actualizar los cuerpos con más satélites
                if (satelitesActual > maxSatelites1) {
                    maxSatelites2 = maxSatelites1;
                    cuerpoConMasSatelites2 = cuerpoConMasSatelites1;
                    maxSatelites1 = satelitesActual;
                    cuerpoConMasSatelites1 = nombreCuerpo;
                } else if (satelitesActual > maxSatelites2) {
                    maxSatelites2 = satelitesActual;
                    cuerpoConMasSatelites2 = nombreCuerpo;
                }

                // Mostrar mensaje de rotación síncrona
                System.out.println(nombreCuerpo + " tiene satélites con rotación síncrona: " + tieneSateliteConRotacionSincrona);
            }

            // Incrementar el contador de planetas si es un planeta
            if (tipoCuerpo.equals("planeta")) {
                totalPlanetas++;
            }
        }

        // Calcular el porcentaje de planetas que tienen algún satélite
        double porcentajePlanetasConSatelites = (totalPlanetas > 0) ? (planetasConSatelites * 100.0) / totalPlanetas : 0.0;

        // Calcular el diámetro medio de todos los cuerpos celestes
        double diametroMedio = (totalCuerpos > 0) ? sumaDiametros / totalCuerpos : 0.0;

        // Mensaje del cuerpo con el diámetro máximo dentro del rango de distancia dado
        String mensajeDiametroMaxMenorDistancia = (maxDiametroMenorDistancia > 0) 
            ? "El diámetro máximo de un cuerpo a menos de 230,000,000 km del Sol es: " + maxDiametroMenorDistancia + " km"
            : "No hay cuerpos a menos de 230,000,000 km del Sol";

        // Mostrar resultados
        System.out.println("a) Porcentaje de planetas con satélites: " + porcentajePlanetasConSatelites + "%");
        System.out.println("b) Nombre del cuerpo celeste más cercano al Sol: " + cuerpoMasCercano);
        System.out.println("c) Diámetro medio de todos los cuerpos celestes (incluyendo satélites): " + diametroMedio + " km");
        System.out.println("d) Nombres de los dos cuerpos celestes con más satélites: " + cuerpoConMasSatelites1 + ", " + cuerpoConMasSatelites2);
        System.out.println("e) " + mensajeDiametroMaxMenorDistancia);

        scanner.close();
    }
}

