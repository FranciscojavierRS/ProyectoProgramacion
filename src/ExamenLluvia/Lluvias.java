package ExamenLluvia;

import java.util.Arrays;
import java.util.Scanner;

public class Lluvias {
    // Constantes que definen el máximo de ciudades y meses permitidos
    private static final int MAXCIUDADES = 20;
    private static final int MAXMESES = 12; 

    // Matriz para almacenar las lluvias por ciudad y mes
    private static float[][] lluvias = new float[MAXCIUDADES][MAXMESES]; 
    private static int numciudades = 0; // Contador de ciudades registradas
    private static String[] ciudades = new String[MAXCIUDADES]; // Array que almacena los nombres de las ciudades

    public static void main(String[] args) {
        inicializarlluvia(); // Inicializa la matriz de lluvias con ceros

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Bucle principal para el menú interactivo
        while (opcion != 6) {
            System.out.println("1-Introducir dato\n" 
                             + "2-Listar todos los datos\n"
                             + "3-Mostrar la media de lluvias anual en una ciudad dada\n"
                             + "4-Listado alfabético de ciudades y su cantidad de lluvia anual\n"
                             + "5-Listado (ordenado por lluvia) de ciudades y su lluvia en un mes dado\n" 
                             + "6-Finalizar");

            opcion = sc.nextInt(); // Leer la opción seleccionada por el usuario

            // Ejecutar la opción correspondiente
            switch (opcion) {
                case 1: 
                    insertarlluvia(sc); // Insertar datos de lluvias
                    break;
                case 2: 
                    mostrarlluvias(); // Listar todos los datos registrados
                    break;
                case 3: 
                    medialluviasciudad(sc); // Mostrar la media anual de lluvias en una ciudad
                    break;
                case 4: 
                    mostrarLluviasAnuales(); // Mostrar lluvias anuales en orden alfabético
                    break;
                case 5: 
                    mostrarCiudadesOrdenadasMes(sc); // Listar ciudades y lluvias de un mes dado, ordenado
                    break;
                default:
                    break; // No hacer nada si la opción no es válida
            }
        }

        sc.close(); // Cerrar el Scanner al finalizar
    }

    // Función que muestra las lluvias de un mes en orden ascendente
    private static void mostrarCiudadesOrdenadasMes(Scanner sc) {
        System.out.println("Introduce el mes:");
        int mes = sc.nextInt() - 1; // Convertir el mes a índice (0-based)

        int contadorDatos = 0;
        // Contar cuántas ciudades tienen datos registrados en ese mes
        for (int i = 0; i < lluvias[0].length; i++) {
            if (lluvias[i][mes] > 0) {
                contadorDatos++;
            }
        }

        // Arrays temporales para almacenar las lluvias y ciudades correspondientes
        float[] lluviasMes = new float[contadorDatos];
        String[] ciudadesLluviasMes = new String[contadorDatos];
        int numElementosInsertados = 0;

        for (int i = 0; i < lluvias[0].length; i++) {
            if (lluvias[i][mes] > 0) {
                lluviasMes[numElementosInsertados] = lluvias[i][mes];
                ciudadesLluviasMes[numElementosInsertados] = ciudades[i];
                numElementosInsertados++;
            }
        }

        // Ordenar las lluvias y sus ciudades asociadas
        float[] lluviasMesOrdenada = new float[numElementosInsertados];
        String[] ciudadesLluviasOrdenadas = new String[numElementosInsertados];
        for (int i = 0; i < lluviasMes.length; i++) {
            int pos = Arrays.binarySearch(Arrays.copyOf(lluviasMesOrdenada, i), lluviasMes[i]);
            if (pos < 0) {
                pos = -pos - 1;
            }
            insertarEnPosicion(lluviasMesOrdenada, i, lluviasMes[i], pos, ciudadesLluviasOrdenadas, ciudadesLluviasMes[i]);
        }

        // Mostrar el resultado ordenado
        for (int i = 0; i < lluviasMesOrdenada.length; i++) {
            System.out.println(ciudadesLluviasOrdenadas[i] + ": " + lluviasMesOrdenada[i]);
        }
    }

    // Inserta un elemento y su cadena asociada en un array ordenado
    private static void insertarEnPosicion(float[] arrayDondeInsertar, int numElementos, float elemAInsertar, int pos,
                                           String[] arrayDondeInsertarStrings, String cadenaAInsertar) {
        for (int i = numElementos; i > pos; i--) {
            arrayDondeInsertar[i] = arrayDondeInsertar[i - 1];
            arrayDondeInsertarStrings[i] = arrayDondeInsertarStrings[i - 1];
        }

        arrayDondeInsertar[pos] = elemAInsertar;
        arrayDondeInsertarStrings[pos] = cadenaAInsertar;
    }

    // Calcula y muestra las lluvias anuales por ciudad en orden alfabético
    private static void mostrarLluviasAnuales() {
        String[] ciudadesOrdenadas = getOrdenarArray(ciudades, numciudades); // Ordenar ciudades alfabéticamente
        for (String ciudad : ciudadesOrdenadas) {
            int indice = indiceCiudad(ciudad);
            float totalLluvias = 0;

            for (float lluvia : lluvias[indice]) {
                totalLluvias += lluvia;
            }

            System.out.println(ciudad + " - " + totalLluvias + " Litros");
        }
    }

    // Muestra la media anual de lluvias para una ciudad específica
    private static void medialluviasciudad(Scanner sc) {
        System.out.println("Introduce la ciudad:");
        String ciudad = sc.next();
        int indiceCiudad = indiceCiudad(ciudad);
        float mediaLluvias = 0;
        int numDatos = 0;
        for (float lluvia : lluvias[indiceCiudad]) {
        	if(lluvia > 0) {
            mediaLluvias += lluvia;
            numDatos++;
        	}
        }

        mediaLluvias /= numDatos; // Calcular la media
        System.out.println("La media de lluvias es de " + mediaLluvias + " Litros");
    }

    // Inicializa la matriz de lluvias con ceros
    private static void inicializarlluvia() {
        for (int i = 0; i < MAXCIUDADES; i++) {
            for (int j = 0; j < MAXMESES; j++) {
                lluvias[i][j] = 0;
            }
        }
    }

    // Comprueba si una ciudad ya está registrada
    private static boolean comprobarciudad(String ciudad) {
        for (String c : ciudades) {
            if (ciudad.equals(c)) {
                return false; // Ciudad ya registrada
            }
        }

        if (numciudades == MAXCIUDADES - 1) {
            System.out.println("Se ha alcanzado el número máximo de ciudades");
            return false;
        }

        return true; // Ciudad no registrada aún
    }

    // Inserta una nueva entrada de lluvia para una ciudad
    private static void insertarlluvia(Scanner sc) {
        System.out.println("Introduce la ciudad:");
        String ciudad = sc.next();

        if (comprobarciudad(ciudad)) {
            ciudades[numciudades] = ciudad;
            numciudades++;
        }

        System.out.println("Introduce el mes:");
        int mes = sc.nextInt();

        System.out.println("Introduce la cantidad de lluvia en litros:");
        float litros = sc.nextFloat();
        lluvias[indiceCiudad(ciudad)][mes - 1] = litros;

        System.out.println("Datos almacenados");
    }

    // Busca el índice de una ciudad en el array
    private static int indiceCiudad(String ciudad) {
        int indice = 0;
        while (indice < numciudades && !ciudad.equals(ciudades[indice])) {
            indice++;
        }
        return indice;
    }

    // Muestra todos los datos registrados en orden alfabético
    private static void mostrarlluvias() {
        String[] ciudadesOrdenadas = getOrdenarArray(ciudades, numciudades); // Ordenar ciudades
        for (String ciudad : ciudadesOrdenadas) {
            int indice = indiceCiudad(ciudad);

            for (int mes = 0; mes < MAXMESES; mes++) {
                if (lluvias[indice][mes] != 0) {
                    System.out.println(ciudad + " -  mes " +(mes +1) +"-" + lluvias[indice][mes] + " Litros");
                }
            }
        }
    }

    // Ordena un array de cadenas alfabéticamente
    private static String[] getOrdenarArray(String[] array, int numElementos) {
        String[] arrayOrdenado = Arrays.copyOf(array, numElementos);
        Arrays.sort(arrayOrdenado);
        return arrayOrdenado;
    }
}
