package EXAMEN2017_2018;

import java.util.Scanner;


/** En la Oficina de Estudios Futbolísticos Hermanos Machado
(OEEHM), se pretende es s. Para ello se
debe realizar un programa en Java que permita la introducción de datos, y posteriormente muestre unos

udiar una serie de datos sobre equipos de fútbol y su

jugador

resultados,

El programa debe permitir al usuario la introducción de una serio de equipos y sus jugadores, de
la siguiente forma:

Para cada equipo, se introducirá en primer lugar su nombre (se sabrá que se desea terminar de
introducir datos cuando el nombre del mismo sea “Nin”) y a continuación los puntos que tiene y su
número de jugadores. Para cada jugador del equipo so introducirá su nombre, su edad, el precio de su
ficha y medianto una letra su posición en el campo (D — delantero, P — portero, F — defensa, L
lateral). Si el jugador es delantero, se introducirá el número de goles marcados y si es portero el de
penaltis encajados. (1 punto la petición correcta de datos).

Los resultados que se deben mostrar al finalizar la introducción de datos son:

a) (1 punto) Media de edad de todos los defensas de todos los equipos.

b) (1,5 puntos) Nombre del jugador con la ficha más cara de los equipos con menos de 7
jugadores introducidos.

e) (1,5 puntos) Nombre del equipo que obtiene más rendimiento de sus jugadores, es decir, con la
mejor relación puntos/número de jugadores.

d) (1,5 puntos) Si hubiere algún equipo que no tuviere portero ni laterales, se “debiere” indicar
con un mensaje, */

public class FUTBOLHM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables globales
        double totalEdadDefensas = 0;
        int contadorDefensas = 0;

        String jugadorFichaCaraMenos7 = "";
        double fichaMasCaraMenos7 = 0;

        String equipoMejorRendimiento = "";
        double mejorRendimiento = 0;

        boolean equipoSinPorteroNiLateral = false;

        while (true) {
            System.out.print("Introduce el nombre del equipo (o 'Nin' para terminar): ");
            String nombreEquipo = scanner.nextLine();

            if (nombreEquipo.equalsIgnoreCase("Nin")) {
                break;
            }

            // Introducción de datos del equipo
            System.out.print("Introduce los puntos del equipo: ");
            int puntosEquipo = scanner.nextInt();
            System.out.print("Introduce el número de jugadores del equipo: ");
            int numJugadores = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de nueva línea

            // Variables para el equipo actual
            double rendimientoEquipo = (double) puntosEquipo / numJugadores;
            boolean tienePortero = false;
            boolean tieneLateral = false;

            // Actualizar el equipo con mejor rendimiento
            if (rendimientoEquipo > mejorRendimiento) {
                mejorRendimiento = rendimientoEquipo;
                equipoMejorRendimiento = nombreEquipo;
            }

            for (int i = 1; i <= numJugadores; i++) {
                System.out.print("Introduce el nombre del jugador " + i + ": ");
                String nombreJugador = scanner.nextLine();

                System.out.print("Introduce la edad del jugador " + i + ": ");
                int edadJugador = scanner.nextInt();

                System.out.print("Introduce el precio de la ficha del jugador " + i + ": ");
                double fichaJugador = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer de nueva línea

                System.out.print("Introduce la posición del jugador (D - delantero, P - portero, F - defensa, L - lateral): ");
                char posicionJugador = scanner.nextLine().charAt(0);

                switch (posicionJugador) {
                    case 'D': // Delantero
                        System.out.print("Introduce el número de goles marcados: ");
                        int golesMarcados = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer de nueva línea
                        break;

                    case 'P': // Portero
                        System.out.print("Introduce el número de penaltis encajados: ");
                        int penaltisEncajados = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer de nueva línea
                        tienePortero = true;
                        break;

                    case 'F': // Defensa
                        totalEdadDefensas += edadJugador;
                        contadorDefensas++;
                        break;

                    case 'L': // Lateral
                        tieneLateral = true;
                        break;
                }

                // Comprobar si el jugador tiene la ficha más cara en equipos con menos de 7 jugadores
                if (numJugadores < 7 && fichaJugador > fichaMasCaraMenos7) {
                    fichaMasCaraMenos7 = fichaJugador;
                    jugadorFichaCaraMenos7 = nombreJugador;
                }
            }

            // Verificar si el equipo no tiene ni portero ni laterales
            if (!tienePortero && !tieneLateral) {
                equipoSinPorteroNiLateral = true;
                System.out.println("El equipo " + nombreEquipo + " no tiene ni portero ni laterales.");
            }
        }

        // Resultados finales
        if (contadorDefensas > 0) {
            System.out.println("Media de edad de los defensas: " + (totalEdadDefensas / contadorDefensas));
        } else {
            System.out.println("No se introdujeron defensas.");
        }

        if (!jugadorFichaCaraMenos7.isEmpty()) {
            System.out.println("Jugador con la ficha más cara en equipos con menos de 7 jugadores: " + jugadorFichaCaraMenos7);
        } else {
            System.out.println("No se encontró ningún jugador con ficha cara en equipos con menos de 7 jugadores.");
        }

        System.out.println("El equipo con mejor relación puntos/jugadores es: " + equipoMejorRendimiento);

        if (!equipoSinPorteroNiLateral) {
            System.out.println("No se encontró ningún equipo sin porteros ni laterales.");
        }

        scanner.close();
    }
}

