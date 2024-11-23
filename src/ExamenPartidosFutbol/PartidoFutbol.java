package ExamenPartidosFutbol;

import java.util.Scanner;

public class PartidoFutbol {

    private static final int MAXEQUIPOS = 20; // Número máximo de equipos permitidos
    private static int[][][] partidos = new int[MAXEQUIPOS][MAXEQUIPOS][2]; // Matriz para almacenar resultados (local, visitante)
    private static int numequipos = 0; // Contador del número actual de equipos
    private static String[] equipos = new String[MAXEQUIPOS]; // Array de nombres de equipos

    public static void main(String[] args) {
        inicializarPartidos(); // Inicializa la matriz de resultados
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        // Bucle principal del menú interactivo
        while (opcion != 6) {
            System.out.println("1-Introducir resultado de un partido\n" 
                             + "2-Mostrar todos los partidos introducidos\n"
                             + "3-Monstrar el equipo ganador de la liga\n"
                             + "4-Monstrar el porcentaje de partidos en los que perdió el equipo local\n"
                             + "5-Introducir nombre de equipo y mostrar los resultados de todos sus partidos\n" 
                             + "6-Finalizar");

            opcion = sc.nextInt(); // Leer la opción del usuario

            switch (opcion) {
                case 1: // Insertar un nuevo partido
                    insertarPartido(sc);
                    break;
                case 2: // Mostrar todos los partidos registrados
                    mostrarPartido();
                    break;
                case 3: // Mostrar el equipo ganador de la liga
                    obtenerGanador();
                    break;
                case 4: // Calcular porcentaje de derrotas del equipo local
                    porcentajeGanadorLocal();
                    break;
                case 5: // Mostrar partidos jugados por un equipo específico
                    participadoEquipo(sc);
                    break;
                default:
                    // No hacer nada si la opción no es válida
                    break;
            }
        }

        sc.close(); // Cerrar el Scanner al finalizar
    }

    // Mostrar partidos de un equipo específico (como local y visitante)
    private static void participadoEquipo(Scanner sc) {
        System.out.println("Introduce un equipo:");
        String equipo = sc.next();
        int indice = indiceEquipo(equipo); // Obtener el índice del equipo

        // Mostrar partidos como local
        System.out.println("Como Local ha jugado con:");
        for (int i = 0; i < numequipos; i++) {
            if (partidos[indice][i][0] != -1) { // Si el partido está registrado
                System.out.println(equipos[i]); // Mostrar equipo contrario
            }
        }

        // Mostrar partidos como visitante
        System.out.println("Como Visitante ha jugado con:");
        for (int i = 0; i < numequipos; i++) {
            if (partidos[i][indice][0] != -1) { // Si el partido está registrado
                System.out.println(equipos[i]); // Mostrar equipo contrario
            }
        }
    }

    // Calcular porcentaje de derrotas del equipo local
    private static void porcentajeGanadorLocal() {
        int partidosGanados = 0; // Contador de partidos donde el visitante ganó
        int partidosJugados = 0; // Total de partidos jugados

        // Recorrer todos los partidos
        for (int i = 0; i < partidos.length; i++) {
            for (int j = 0; j < partidos[i].length; j++) {
                if (partidos[i][j][0] != -1) { // Verificar si el partido fue jugado
                    partidosJugados++;
                    if (partidos[i][j][0] < partidos[i][j][1]) { // Si el visitante ganó
                        partidosGanados++;
                    }
                }
            }
        }

        double porcentaje = (double) partidosGanados / partidosJugados; // Calcular porcentaje
        System.out.println("El porcentaje de partidos perdidos por el equipo local es " + (porcentaje * 100) + "%");
    }

    // Determinar el equipo ganador de la liga
    private static void obtenerGanador() {
        String equipoGanador = "";
        int maxPuntos = -1; // Máximo de puntos encontrados
        int puntos;

        // Recorrer equipos para calcular puntos
        for (int i = 0; i < partidos.length; i++) {
            puntos = 0; // Reiniciar puntos por equipo
            for (int j = 0; j < partidos[i].length; j++) {
                if (partidos[i][j][0] != -1) { // Partidos como local
                    if (partidos[i][j][0] == partidos[i][j][1]) {
                        puntos++; // Empate (1 punto)
                    } else if (partidos[i][j][0] > partidos[i][j][1]) {
                        puntos += 3; // Victoria local (3 puntos)
                    }
                }
                if (partidos[j][i][0] != -1) { // Partidos como visitante
                    if (partidos[j][i][0] == partidos[j][i][1]) {
                        puntos++; // Empate (1 punto)
                    } else if (partidos[j][i][0] < partidos[j][i][1]) {
                        puntos += 3; // Victoria visitante (3 puntos)
                    }
                }
            }

            // Actualizar equipo ganador si tiene más puntos
            if (puntos > maxPuntos) {
                equipoGanador = equipos[i];
                maxPuntos = puntos;
            }
        }
        System.out.println("El equipo ganador es " + equipoGanador + " con " + maxPuntos + " puntos");
    }

    // Mostrar todos los partidos registrados
    private static void mostrarPartido() {
        for (int i = 0; i < partidos.length; i++) {
            for (int j = 0; j < partidos[i].length; j++) {
                if (partidos[i][j][0] != -1) { // Verificar si hay partido registrado
                    System.out.println(
                            equipos[i] + " - " + equipos[j] + " (" + partidos[i][j][0] + "-" + partidos[i][j][1] + ")");
                }
            }
        }
    }

    // Insertar un nuevo partido
    private static void insertarPartido(Scanner sc) {
        System.out.println("Introduce equipo local:");
        String equipolocal = sc.next();

        // Verificar si el equipo local ya está registrado
        if (comprobarEquipo(equipolocal)) {
            equipos[numequipos] = equipolocal;
            numequipos++;
        }

        System.out.println("Introduce equipo visitante:");
        String equipoVisitante = sc.next();

        // Verificar si el equipo visitante ya está registrado
        if (comprobarEquipo(equipoVisitante)) {
            equipos[numequipos] = equipoVisitante;
            numequipos++;
        }

        // Introducir resultados
        int goleslocal = -1, golesVisitante = -1;
        do {
            System.out.println("Introduce goles del equipo local:");
            goleslocal = sc.nextInt();
        } while (goleslocal < 0);

        do {
            System.out.println("Introduce goles del equipo visitante:");
            golesVisitante = sc.nextInt();
        } while (golesVisitante < 0);

        // Registrar el resultado en la matriz
        partidos[indiceEquipo(equipolocal)][indiceEquipo(equipoVisitante)][0] = goleslocal;
        partidos[indiceEquipo(equipolocal)][indiceEquipo(equipoVisitante)][1] = golesVisitante;

        System.out.println("Datos almacenados");
    }

    // Obtener el índice de un equipo en el array
    private static int indiceEquipo(String equipo) {
        int indice = 0;
        while (indice < numequipos && !equipo.equals(equipos[indice])) {
            indice++;
        }
        return indice;
    }

    // Verificar si un equipo ya está registrado
    private static boolean comprobarEquipo(String equipo) {
        for (int i = 0; i < equipos.length; i++) {
            if (equipo.equals(equipos[i])) {
                return false; // Equipo ya registrado
            }
        }

        if (numequipos == MAXEQUIPOS - 1) { // Verificar límite de equipos
            System.out.println("Se ha alcanzado el número máximo de equipos");
            return true;
        }

        return true; // Equipo no registrado aún
    }

    // Inicializar la matriz de resultados con valores predeterminados
    private static void inicializarPartidos() {
        for (int i = 0; i < MAXEQUIPOS; i++) {
            for (int j = 0; j < MAXEQUIPOS; j++) {
                partidos[i][j][0] = -1; // Sin partidos registrados
                partidos[i][j][1] = -1;
            }
        }
    }
}
