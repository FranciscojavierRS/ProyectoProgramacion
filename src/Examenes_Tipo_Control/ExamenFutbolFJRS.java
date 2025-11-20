package Examenes_Tipo_Control;

import java.util.Scanner;

public class ExamenFutbolFJRS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables de entrada temporales
        String nombreEquipo;
        String nombreJugador;
        String posicion;
        int puntos, numJugadores, edad;
        double precioFicha;
        int goles, penaltis;

        // VARIABLES GLOBALES para los resultados (acumuladores/contadores)
        int sumaEdadDefensas = 0;         // suma de edades de los defensas (F)
        int contadorDefensas = 0;         // número de defensas

        double mejorPrecioMenos7 = -1;    // mayor precio encontrado en equipos con < 7 jugadores
        String nombreJugadorMasCaroMenos7 = ""; // nombre del jugador con esa ficha

        double mejorRendimiento = -1;     // mejor puntuación/personal (puntos/numJugadores)
        String equipoMejorRendimiento = ""; // nombre del equipo con ese mejor rendimiento

        System.out.println("=== Estudio de equipos de fútbol ===");
        System.out.println("Introduzca el nombre del equipo (o 'fin' para terminar):");
        nombreEquipo = sc.nextLine();

        while (!nombreEquipo.equalsIgnoreCase("fin")) {
            System.out.println("\n***** Equipo: " + nombreEquipo + " *****");

            // Pedimos datos básicos del equipo
            System.out.print("Puntos del equipo: ");
            puntos = sc.nextInt();

            System.out.print("Número de jugadores: ");
            numJugadores = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            // Variables por equipo
            boolean tieneLateral = false;       // para saber si el equipo tiene lateral(s)
            double precioMasCaroEquipo = -1;    // precio más alto dentro del equipo
            String nombreMasCaroEquipo = "";    // nombre del jugador más caro dentro del equipo

            // Si el equipo dice tener 0 jugadores, evitamos dividir por cero más adelante.
            if (numJugadores <= 0) {
                System.out.println("El equipo debe tener al menos 1 jugador. Se ignora este equipo.");
            } else {
                // Bucle para pedir datos de cada jugador del equipo
                for (int i = 1; i <= numJugadores; i++) {
                    System.out.println("\nJugador " + i + ":");

                    System.out.print("Nombre: ");
                    nombreJugador = sc.nextLine();

                    System.out.print("Edad: ");
                    edad = sc.nextInt();

                    System.out.print("Precio de ficha: ");
                    precioFicha = sc.nextDouble();

                    System.out.print("Posición (D-delantero, P-portero, F-defensa, L-lateral): ");
                    posicion = sc.next();
                    sc.nextLine(); // limpiar buffer después de leer la posición

                    // Si es defensa, acumulamos para la media
                    if (posicion.equalsIgnoreCase("F")) {
                        sumaEdadDefensas += edad;
                        contadorDefensas++;
                    }

                    // Si es lateral, marcamos que el equipo tiene lateral
                    if (posicion.equalsIgnoreCase("L")) {
                        tieneLateral = true;
                    }

                    // Si es delantero, pedimos goles
                    if (posicion.equalsIgnoreCase("D")) {
                        System.out.print("Número de goles marcados: ");
                        goles = sc.nextInt();
                        sc.nextLine();
                        // (no hacemos nada adicional con goles por este apartado)
                    }
                    // Si es portero, pedimos penaltis encajados
                    else if (posicion.equalsIgnoreCase("P")) {
                        System.out.print("Penaltis encajados: ");
                        penaltis = sc.nextInt();
                        sc.nextLine();
                        // (no hacemos nada adicional con penaltis por este apartado)
                    }

                    // Actualizar jugador más caro del equipo
                    if (precioFicha > precioMasCaroEquipo) {
                        precioMasCaroEquipo = precioFicha;
                        nombreMasCaroEquipo = nombreJugador;
                    }

                    // Mostramos confirmación de los datos introducidos del jugador (opcional)
                    System.out.println(" -> Registrado: " + nombreJugador + " | Edad: " + edad +
                                       " | Precio: " + precioFicha + " | Posición: " + posicion);
                } // fin del for (jugadores)
                
                // Comprobar si el equipo NO tiene laterales y avisar
                if (!tieneLateral) {
                    System.out.println("** Aviso: El equipo '" + nombreEquipo + "' no tiene laterales. **");
                }

                // Actualizar mejor rendimiento (puntos / numJugadores)
                double rendimientoEquipo = (double) puntos / (double) numJugadores;
                if (rendimientoEquipo > mejorRendimiento) {
                    mejorRendimiento = rendimientoEquipo;
                    equipoMejorRendimiento = nombreEquipo;
                }

                // Si el equipo tiene menos de 7 jugadores, considerar su jugador más caro
                if (numJugadores < 7) {
                    if (precioMasCaroEquipo > mejorPrecioMenos7) {
                        mejorPrecioMenos7 = precioMasCaroEquipo;
                        nombreJugadorMasCaroMenos7 = nombreMasCaroEquipo;
                    }
                }
            } // fin else numJugadores>0

            // Pedimos siguiente equipo
            System.out.println("\nIntroduzca el nombre del siguiente equipo (o 'fin' para terminar):");
            nombreEquipo = sc.nextLine();
        } // fin while equipos

        // Mostrar resultados finales
        System.out.println("\n=== RESULTADOS FINALES ===");

        // a) Media de edad de los defensas
        if (contadorDefensas > 0) {
            double mediaEdadDefensas = (double) sumaEdadDefensas / (double) contadorDefensas;
            System.out.println("a) Media de edad de los defensas: " + mediaEdadDefensas);
        } else {
            System.out.println("a) No se introdujeron defensas (no hay datos para calcular la media).");
        }

        // b) Jugador con la ficha más cara en equipos con menos de 7 jugadores
        if (mejorPrecioMenos7 >= 0) {
            System.out.println("b) Jugador con la ficha más cara (equipos < 7 jugadores): " +
                               nombreJugadorMasCaroMenos7 + " (precio: " + mejorPrecioMenos7 + ")");
        } else {
            System.out.println("b) No se registraron equipos con menos de 7 jugadores.");
        }

        // c) Equipo con mejor rendimiento
        if (!equipoMejorRendimiento.equals("")) {
            System.out.println("c) Equipo con mejor rendimiento (puntos / #jugadores): " + equipoMejorRendimiento +
                               " (rendimiento = " + mejorRendimiento + ")");
        } else {
            System.out.println("c) No se registró ningún equipo con datos válidos.");
        }

        System.out.println("\n--- Fin del programa ---");
        sc.close();
    }
}
