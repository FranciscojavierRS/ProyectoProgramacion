package Ayudas_Arrays;


import java.util.Arrays;
import java.util.Scanner;

public class Examen_Maestro_Arrays {

    private static Scanner sc = new Scanner(System.in);

    // ===== BLOQUE 1: BANCO / SUCURSALES / CLIENTES =====
    private static final int MAX_ANIOS = 21;
    private static final int MAX_SUCURSALES = 10;
    private static int contadorAnios = 0;
    private static int contadorSucursales = 0;

    private static int[] listaAnios = new int[MAX_ANIOS];
    private static String[] listaCodigosSucursales = new String[MAX_SUCURSALES];
    private static int[][] clientes = new int[MAX_ANIOS][MAX_SUCURSALES];

    // Transfers between branches
    private static final int MAX_TRANSFERENCIAS = 200;
    private static int contadorTransferencias = 0;
    private static String[] transferOrigen = new String[MAX_TRANSFERENCIAS];
    private static String[] transferDestino = new String[MAX_TRANSFERENCIAS];
    private static int[] importesTransferencias = new int[MAX_TRANSFERENCIAS];

    // ===== BLOQUE 2: LLUVIAS / CIUDADES / MESES =====
    private static final int MAX_CIUDADES = 20;
    private static int contadorCiudades = 0;
    private static String[] listaCiudades = new String[MAX_CIUDADES];
    private static double[][] lluvias = new double[MAX_CIUDADES][12];

    // ===== BLOQUE 3: FUTBOL / PARTIDOS =====
    private static final int MAX_PARTIDOS = 20;
    private static int contadorPartidos = 0;
    private static String[] equiposLocal = new String[MAX_PARTIDOS];
    private static String[] equiposVisitante = new String[MAX_PARTIDOS];
    private static int[] golesLocal = new int[MAX_PARTIDOS];
    private static int[] golesVisitante = new int[MAX_PARTIDOS];

    // ===== BLOQUE 4: ALUMNOS / EVALUACION =====
    private static final int MAX_ALUMNOS = 30;
    private static int contadorAlumnos = 0;
    private static String[] alumnos = new String[MAX_ALUMNOS];
    private static int[] notaControl = new int[MAX_ALUMNOS];
    private static int[] notaFinalExamen = new int[MAX_ALUMNOS];
    private static int[] positivos = new int[MAX_ALUMNOS];

    public static void main(String[] args) {

        inicializarTablas();

        int opcion = mostrarMenuPrincipal();

        while (opcion != 28) {

            switch (opcion) {

            // ===================== BANCO =====================
            case 1:
                introducirDatoBanco();
                break;

            case 2:
                listarTodosLosDatosBanco();
                break;

            case 3:
                sucursalConMasClientesEnAnio();
                break;

            case 4:
                listadoSucursalesYAnosConMenosDe1000Clientes();
                break;

            case 5:
                listadoSucursalesConMasDe2000DeMediaOrdenadas();
                break;

            case 6:
                minimoYMaximoDeClientesEnAnio();
                break;

            case 7:
                listadoAlfabeticoDeSucursales();
                break;

            case 8:
                introducirTransferencia();
                break;

            case 9:
                sucursalQueHaRecibidoMasDinero();
                break;

            case 10:
                cuantasSucursalesSuperan10000Enviado();
                break;

            case 11:
                listadoSucursalesOrigenYDestino();
                break;

            case 12:
                porcentajeTransferenciasConSaldoNegativoOrigen();
                break;

            // ===================== LLUVIAS =====================
            case 13:
                introducirDatoLluvia();
                break;

            case 14:
                listarTodosLosDatosLluvia();
                break;

            case 15:
                mediaAnualDeUnaCiudad();
                break;

            case 16:
                listadoAlfabeticoCiudadesYTotalAnual();
                break;

            case 17:
                listadoOrdenadoPorLluviaDeUnMes();
                break;

            case 18:
                introducirPartido();
                break;

            case 19:
                listarTodosLosPartidos();
                break;

            case 20:
                mostrarEquipoGanadorLiga();
                break;

            case 21:
                porcentajePartidosPerdidosPorLocal();
                break;

            case 22:
                introducirEquipoYMostrarResultados();
                break;

            case 23:
                listadoMejoresResultadosDeCadaPartido();
                break;

            // ===================== ALUMNOS =====================
            case 24:
                introducirAlumnoYNotas();
                break;

            case 25:
                ponerPositivoAAlumno();
                break;

            case 26:
                listarAlumnosConNotaFinalOrdenado();
                break;

            case 27:
                mostrarEstadisticasEvaluacion();
                break;

            default:
                System.out.println("Opcion no valida");
            }

            opcion = mostrarMenuPrincipal();
        }

        System.out.println("Fin del programa");
    }

    private static void inicializarTablas() {
        for (int i = 0; i < MAX_ANIOS; i++) {
            listaAnios[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < clientes.length; i++) {
            for (int j = 0; j < clientes[0].length; j++) {
                clientes[i][j] = -1;
            }
        }

        for (int i = 0; i < lluvias.length; i++) {
            for (int j = 0; j < lluvias[0].length; j++) {
                lluvias[i][j] = -1;
            }
        }

        Arrays.fill(equiposLocal, null);
        Arrays.fill(equiposVisitante, null);
        Arrays.fill(alumnos, null);
        Arrays.fill(listaCodigosSucursales, null);
        Arrays.fill(listaCiudades, null);
        Arrays.fill(transferOrigen, null);
        Arrays.fill(transferDestino, null);
    }

    private static int mostrarMenuPrincipal() {
        System.out.println(
            "\n1- Introducir dato banco.\n" +
            "2- Listar todos los datos banco.\n" +
            "3- Sucursal con mas clientes en un anio concreto.\n" +
            "4- Listado de sucursales y anios con menos de 1000 clientes.\n" +
            "5- Listado ordenado de sucursales con mas de 2000 clientes de media.\n" +
            "6- Minimo y maximo de clientes en un anio.\n" +
            "7- Listado alfabetico de sucursales.\n" +
            "8- Introducir transferencia entre sucursales.\n" +
            "9- Sucursal que ha recibido mas dinero.\n" +
            "10- Cuantas sucursales superan 10000 enviados.\n" +
            "11- Listado de sucursales origen y destino.\n" +
            "12- Porcentaje de transferencias con saldo negativo del origen.\n" +
            "13- Introducir dato de lluvia.\n" +
            "14- Listar todos los datos de lluvia.\n" +
            "15- Media anual de lluvias en una ciudad.\n" +
            "16- Listado alfabetico por ciudades y total anual.\n" +
            "17- Listado ordenado por lluvia de un mes.\n" +
            "18- Introducir partido de futbol.\n" +
            "19- Listar todos los partidos.\n" +
            "20- Mostrar el equipo ganador de la liga.\n" +
            "21- Mostrar porcentaje de partidos perdidos por el local.\n" +
            "22- Introducir equipo y mostrar resultados.\n" +
            "23- Listado de mejores resultados de cada partido.\n" +
            "24- Introducir alumno, nota del control y nota final.\n" +
            "25- Poner positivo a un alumno.\n" +
            "26- Listar alumnos con su nota final ordenado por nota.\n" +
            "27- Mostrar estadisticas de la evaluacion.\n" +
            "28- Fin."
        );
        return sc.nextInt();
    }

    // ===================== BANCO / SUCURSALES =====================

    private static void introducirDatoBanco() {
        System.out.println("Anio?");
        int anio = sc.nextInt();
        aniadirAnio(anio, listaAnios);

        System.out.println("Codigo de sucursal?");
        String sucursal = sc.next();
        aniadirSucursal(sucursal, listaCodigosSucursales);

        System.out.println("Numero de clientes?");
        int numClientes = sc.nextInt();

        int fila = getIndexOf(anio, listaAnios);
        int columna = getIndexOf(sucursal, listaCodigosSucursales);

        if (fila == -1 || columna == -1) {
            System.out.println("Error al localizar anio o sucursal");
            return;
        }

        clientes[fila][columna] = numClientes;
        System.out.println("Datos almacenados");
    }

    private static void listarTodosLosDatosBanco() {
        if (contadorAnios == 0 || contadorSucursales == 0) {
            System.out.println("No hay datos");
            return;
        }

        for (int i = 0; i < contadorAnios; i++) {
            System.out.println(listaAnios[i] + ":");
            for (int j = 0; j < contadorSucursales; j++) {
                if (clientes[i][j] != -1) {
                    System.out.println("  " + listaCodigosSucursales[j] + " -> " + clientes[i][j]);
                }
            }
        }
    }

    private static void sucursalConMasClientesEnAnio() {
        System.out.println("Anio a buscar?");
        int anio = sc.nextInt();

        int fila = getIndexOf(anio, listaAnios);
        if (fila == -1) {
            System.out.println("Anio no encontrado");
            return;
        }

        int max = Integer.MIN_VALUE;
        String sucursalMax = "";

        for (int j = 0; j < contadorSucursales; j++) {
            if (clientes[fila][j] != -1 && clientes[fila][j] > max) {
                max = clientes[fila][j];
                sucursalMax = listaCodigosSucursales[j];
            }
        }

        if (sucursalMax.equals("")) {
            System.out.println("No hay datos para ese anio");
        } else {
            System.out.println("La sucursal con mas clientes en " + anio + " fue " + sucursalMax + " con " + max);
        }
    }

    private static void listadoSucursalesYAnosConMenosDe1000Clientes() {
        boolean encontrado = false;

        for (int i = 0; i < contadorAnios; i++) {
            for (int j = 0; j < contadorSucursales; j++) {
                if (clientes[i][j] != -1 && clientes[i][j] < 1000) {
                    System.out.println(listaCodigosSucursales[j] + " en " + listaAnios[i] + " -> " + clientes[i][j]);
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No hay sucursales con menos de 1000 clientes");
        }
    }

    private static void listadoSucursalesConMasDe2000DeMediaOrdenadas() {
        String[] sucursalesFiltradas = new String[MAX_SUCURSALES];
        double[] medias = new double[MAX_SUCURSALES];
        int contadorFiltradas = 0;

        for (int j = 0; j < contadorSucursales; j++) {
            int suma = 0;
            int contadorDatos = 0;
            for (int i = 0; i < contadorAnios; i++) {
                if (clientes[i][j] != -1) {
                    suma += clientes[i][j];
                    contadorDatos++;
                }
            }

            if (contadorDatos > 0) {
                double media = (double) suma / contadorDatos;
                if (media > 2000) {
                    sucursalesFiltradas[contadorFiltradas] = listaCodigosSucursales[j];
                    medias[contadorFiltradas] = media;
                    contadorFiltradas++;
                }
            }
        }

        ordenarPorNombreAscendente(sucursalesFiltradas, medias, contadorFiltradas);

        for (int i = 0; i < contadorFiltradas; i++) {
            System.out.println(sucursalesFiltradas[i] + " -> media " + medias[i]);
        }
    }

    private static void minimoYMaximoDeClientesEnAnio() {
        System.out.println("Anio a buscar?");
        int anio = sc.nextInt();

        int fila = getIndexOf(anio, listaAnios);
        if (fila == -1) {
            System.out.println("Anio no encontrado");
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String sucursalMin = "";
        String sucursalMax = "";

        for (int j = 0; j < contadorSucursales; j++) {
            if (clientes[fila][j] != -1) {
                if (clientes[fila][j] < min) {
                    min = clientes[fila][j];
                    sucursalMin = listaCodigosSucursales[j];
                }
                if (clientes[fila][j] > max) {
                    max = clientes[fila][j];
                    sucursalMax = listaCodigosSucursales[j];
                }
            }
        }

        System.out.println("Minimo: " + sucursalMin + " -> " + min);
        System.out.println("Maximo: " + sucursalMax + " -> " + max);
    }

    private static void listadoAlfabeticoDeSucursales() {
        String[] copia = Arrays.copyOf(listaCodigosSucursales, contadorSucursales);
        Arrays.sort(copia);
        for (int i = 0; i < copia.length; i++) {
            System.out.println(copia[i]);
        }
    }

    private static void introducirTransferencia() {
        System.out.println("Sucursal origen?");
        String origen = sc.next();
        aniadirSucursal(origen, listaCodigosSucursales);

        System.out.println("Sucursal destino?");
        String destino = sc.next();
        aniadirSucursal(destino, listaCodigosSucursales);

        System.out.println("Importe?");
        int importe = sc.nextInt();

        if (contadorTransferencias >= MAX_TRANSFERENCIAS) {
            System.out.println("No caben mas transferencias");
            return;
        }

        transferOrigen[contadorTransferencias] = origen;
        transferDestino[contadorTransferencias] = destino;
        importesTransferencias[contadorTransferencias] = importe;
        contadorTransferencias++;

        System.out.println("Transferencia almacenada");
    }

    private static void sucursalQueHaRecibidoMasDinero() {
        if (contadorSucursales == 0 || contadorTransferencias == 0) {
            System.out.println("No hay datos");
            return;
        }

        int max = Integer.MIN_VALUE;
        String sucursalMax = "";

        for (int i = 0; i < contadorSucursales; i++) {
            int sumaRecibida = 0;
            for (int t = 0; t < contadorTransferencias; t++) {
                if (listaCodigosSucursales[i].equalsIgnoreCase(transferDestino[t])) {
                    sumaRecibida += importesTransferencias[t];
                }
            }

            if (sumaRecibida > max) {
                max = sumaRecibida;
                sucursalMax = listaCodigosSucursales[i];
            }
        }

        System.out.println("La sucursal que mas dinero ha recibido es " + sucursalMax + " con " + max);
    }

    private static void cuantasSucursalesSuperan10000Enviado() {
        int contador = 0;

        for (int i = 0; i < contadorSucursales; i++) {
            int sumaEnviada = 0;
            for (int t = 0; t < contadorTransferencias; t++) {
                if (listaCodigosSucursales[i].equalsIgnoreCase(transferOrigen[t])) {
                    sumaEnviada += importesTransferencias[t];
                }
            }

            if (sumaEnviada > 10000) {
                contador++;
                System.out.println(listaCodigosSucursales[i] + " supera 10000 con " + sumaEnviada);
            }
        }

        System.out.println("Numero de sucursales que superan 10000 enviados: " + contador);
    }

    private static void listadoSucursalesOrigenYDestino() {
        for (int i = 0; i < contadorSucursales; i++) {
            boolean esOrigen = false;
            boolean esDestino = false;

            for (int t = 0; t < contadorTransferencias && (!esOrigen || !esDestino); t++) {
                if (listaCodigosSucursales[i].equalsIgnoreCase(transferOrigen[t])) {
                    esOrigen = true;
                }
                if (listaCodigosSucursales[i].equalsIgnoreCase(transferDestino[t])) {
                    esDestino = true;
                }
            }

            if (esOrigen && esDestino) {
                System.out.println(listaCodigosSucursales[i] + " es origen y destino");
            }
        }
    }

    private static void porcentajeTransferenciasConSaldoNegativoOrigen() {
        if (contadorTransferencias == 0) {
            System.out.println("No hay transferencias");
            return;
        }

        int contadorNegativas = 0;
        for (int t = 0; t < contadorTransferencias; t++) {
            // Criterio de examen: transferencias donde el origen envia mas de lo que recibe en total
            String origen = transferOrigen[t];
            int totalEnviado = totalEnviadoPorSucursal(origen);
            int totalRecibido = totalRecibidoPorSucursal(origen);
            if (totalEnviado > totalRecibido) {
                contadorNegativas++;
            }
        }

        double porcentaje = (contadorNegativas * 100.0) / contadorTransferencias;
        System.out.println("Porcentaje de transferencias con saldo negativo del origen: " + porcentaje + "%");
    }

    private static int totalEnviadoPorSucursal(String sucursal) {
        int suma = 0;
        for (int i = 0; i < contadorTransferencias; i++) {
            if (sucursal.equalsIgnoreCase(transferOrigen[i])) {
                suma += importesTransferencias[i];
            }
        }
        return suma;
    }

    private static int totalRecibidoPorSucursal(String sucursal) {
        int suma = 0;
        for (int i = 0; i < contadorTransferencias; i++) {
            if (sucursal.equalsIgnoreCase(transferDestino[i])) {
                suma += importesTransferencias[i];
            }
        }
        return suma;
    }

    // ===================== LLUVIAS / CIUDADES =====================

    private static void introducirDatoLluvia() {
        System.out.println("Ciudad?");
        String ciudad = sc.next();
        aniadirCiudad(ciudad, listaCiudades);

        System.out.println("Mes (1-12)?");
        int mes = sc.nextInt();
        if (mes < 1 || mes > 12) {
            System.out.println("Mes invalido");
            return;
        }

        System.out.println("Cantidad de lluvia?");
        double lluvia = sc.nextDouble();

        int fila = getIndexOf(ciudad, listaCiudades);
        if (fila == -1) {
            System.out.println("Ciudad no encontrada");
            return;
        }

        lluvias[fila][mes - 1] = lluvia;
        System.out.println("Dato de lluvia almacenado");
    }

    private static void listarTodosLosDatosLluvia() {
        String[] ciudadesOrdenadas = Arrays.copyOf(listaCiudades, contadorCiudades);
        Arrays.sort(ciudadesOrdenadas);

        for (int c = 0; c < ciudadesOrdenadas.length; c++) {
            int fila = getIndexOf(ciudadesOrdenadas[c], listaCiudades);
            System.out.println(ciudadesOrdenadas[c] + ":");
            for (int mes = 0; mes < 12; mes++) {
                if (lluvias[fila][mes] != -1) {
                    System.out.println("  Mes " + (mes + 1) + " -> " + lluvias[fila][mes]);
                }
            }
        }
    }

    private static void mediaAnualDeUnaCiudad() {
        System.out.println("Ciudad?");
        String ciudad = sc.next();

        int fila = getIndexOf(ciudad, listaCiudades);
        if (fila == -1) {
            System.out.println("Ciudad no encontrada");
            return;
        }

        double suma = 0;
        int contadorMeses = 0;

        for (int mes = 0; mes < 12; mes++) {
            if (lluvias[fila][mes] != -1) {
                suma += lluvias[fila][mes];
                contadorMeses++;
            }
        }

        if (contadorMeses == 0) {
            System.out.println("No hay datos de lluvia");
        } else {
            System.out.println("Media anual de " + ciudad + " = " + (suma / contadorMeses));
        }
    }

    private static void listadoAlfabeticoCiudadesYTotalAnual() {
        String[] ciudadesOrdenadas = Arrays.copyOf(listaCiudades, contadorCiudades);
        Arrays.sort(ciudadesOrdenadas);

        for (int c = 0; c < ciudadesOrdenadas.length; c++) {
            int fila = getIndexOf(ciudadesOrdenadas[c], listaCiudades);
            double total = 0;
            for (int mes = 0; mes < 12; mes++) {
                if (lluvias[fila][mes] != -1) {
                    total += lluvias[fila][mes];
                }
            }
            System.out.println(ciudadesOrdenadas[c] + " -> total anual " + total);
        }
    }

    private static void listadoOrdenadoPorLluviaDeUnMes() {
        System.out.println("Mes (1-12)?");
        int mes = sc.nextInt();
        if (mes < 1 || mes > 12) {
            System.out.println("Mes invalido");
            return;
        }

        String[] ciudadesConDatos = new String[MAX_CIUDADES];
        double[] valores = new double[MAX_CIUDADES];
        int contador = 0;

        for (int c = 0; c < contadorCiudades; c++) {
            if (lluvias[c][mes - 1] != -1) {
                ciudadesConDatos[contador] = listaCiudades[c];
                valores[contador] = lluvias[c][mes - 1];
                contador++;
            }
        }

        ordenarPorValorAscendente(ciudadesConDatos, valores, contador);

        for (int i = 0; i < contador; i++) {
            System.out.println(ciudadesConDatos[i] + " -> " + valores[i]);
        }
    }

    // ===================== FUTBOL / PARTIDOS =====================

    private static void introducirPartido() {
        if (contadorPartidos >= MAX_PARTIDOS) {
            System.out.println("No caben mas partidos");
            return;
        }

        System.out.println("Equipo local?");
        String local = sc.next();
        System.out.println("Equipo visitante?");
        String visitante = sc.next();
        System.out.println("Goles local?");
        int gl = sc.nextInt();
        System.out.println("Goles visitante?");
        int gv = sc.nextInt();

        equiposLocal[contadorPartidos] = local;
        equiposVisitante[contadorPartidos] = visitante;
        golesLocal[contadorPartidos] = gl;
        golesVisitante[contadorPartidos] = gv;
        contadorPartidos++;

        System.out.println("Partido almacenado");
    }

    private static void listarTodosLosPartidos() {
        if (contadorPartidos == 0) {
            System.out.println("No hay partidos");
            return;
        }

        for (int i = 0; i < contadorPartidos; i++) {
            System.out.println(equiposLocal[i] + " " + golesLocal[i] + " - " + golesVisitante[i] + " " + equiposVisitante[i]);
        }
    }

    private static void mostrarEquipoGanadorLiga() {
        if (contadorPartidos == 0) {
            System.out.println("No hay partidos");
            return;
        }

        String[] equipos = new String[MAX_PARTIDOS * 2];
        int contadorEquipos = 0;

        for (int i = 0; i < contadorPartidos; i++) {
            contadorEquipos = aniadirEquipoUnico(equipos, contadorEquipos, equiposLocal[i]);
            contadorEquipos = aniadirEquipoUnico(equipos, contadorEquipos, equiposVisitante[i]);
        }

        String ganador = "";
        int maxPuntos = Integer.MIN_VALUE;

        for (int e = 0; e < contadorEquipos; e++) {
            int puntos = puntosDeEquipo(equipos[e]);
            if (puntos > maxPuntos) {
                maxPuntos = puntos;
                ganador = equipos[e];
            }
        }

        System.out.println("El equipo ganador es " + ganador + " con " + maxPuntos + " puntos");
    }

    private static int puntosDeEquipo(String equipo) {
        int puntos = 0;
        for (int i = 0; i < contadorPartidos; i++) {
            if (equipo.equalsIgnoreCase(equiposLocal[i])) {
                if (golesLocal[i] > golesVisitante[i]) {
                    puntos += 3;
                } else if (golesLocal[i] == golesVisitante[i]) {
                    puntos += 1;
                }
            }
            if (equipo.equalsIgnoreCase(equiposVisitante[i])) {
                if (golesVisitante[i] > golesLocal[i]) {
                    puntos += 3;
                } else if (golesVisitante[i] == golesLocal[i]) {
                    puntos += 1;
                }
            }
        }
        return puntos;
    }

    private static void porcentajePartidosPerdidosPorLocal() {
        if (contadorPartidos == 0) {
            System.out.println("No hay partidos");
            return;
        }

        int perdidos = 0;
        for (int i = 0; i < contadorPartidos; i++) {
            if (golesLocal[i] < golesVisitante[i]) {
                perdidos++;
            }
        }

        double porcentaje = (perdidos * 100.0) / contadorPartidos;
        System.out.println("Porcentaje de partidos perdidos por el local: " + porcentaje + "%");
    }

    private static void introducirEquipoYMostrarResultados() {
        System.out.println("Nombre de equipo?");
        String equipo = sc.next();

        boolean encontrado = false;

        for (int i = 0; i < contadorPartidos; i++) {
            if (equipo.equalsIgnoreCase(equiposLocal[i])) {
                System.out.println("Como local: " + equiposLocal[i] + " " + golesLocal[i] + " - " + golesVisitante[i] + " " + equiposVisitante[i]);
                encontrado = true;
            } else if (equipo.equalsIgnoreCase(equiposVisitante[i])) {
                System.out.println("Como visitante: " + equiposLocal[i] + " " + golesLocal[i] + " - " + golesVisitante[i] + " " + equiposVisitante[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Ese equipo no ha participado en ningun partido");
        }
    }

    private static void listadoMejoresResultadosDeCadaPartido() {
        if (contadorPartidos == 0) {
            System.out.println("No hay partidos");
            return;
        }

        for (int i = 0; i < contadorPartidos; i++) {
            if (golesLocal[i] > golesVisitante[i]) {
                System.out.println(equiposLocal[i] + " vence a " + equiposVisitante[i] + " por " + (golesLocal[i] - golesVisitante[i]));
            } else if (golesVisitante[i] > golesLocal[i]) {
                System.out.println(equiposVisitante[i] + " vence a " + equiposLocal[i] + " por " + (golesVisitante[i] - golesLocal[i]));
            } else {
                System.out.println(equiposLocal[i] + " y " + equiposVisitante[i] + " empatan");
            }
        }
    }

    // ===================== ALUMNOS / EVALUACION =====================

    private static void introducirAlumnoYNotas() {
        if (contadorAlumnos >= MAX_ALUMNOS) {
            System.out.println("No caben mas alumnos");
            return;
        }

        System.out.println("Alumno?");
        String alumno = sc.next();
        if (getIndexOf(alumno, alumnos) == -1) {
            alumnos[contadorAlumnos] = alumno;
            System.out.println("Nota del control?");
            notaControl[contadorAlumnos] = sc.nextInt();
            System.out.println("Nota del examen final?");
            notaFinalExamen[contadorAlumnos] = sc.nextInt();
            positivos[contadorAlumnos] = 0;
            contadorAlumnos++;
        } else {
            System.out.println("El alumno ya existe");
        }
    }

    private static void ponerPositivoAAlumno() {
        System.out.println("Alumno?");
        String alumno = sc.next();
        int pos = getIndexOf(alumno, alumnos);

        if (pos == -1) {
            System.out.println("Alumno no encontrado");
            return;
        }

        positivos[pos]++;
        System.out.println("Positivo añadido");
    }

    private static void listarAlumnosConNotaFinalOrdenado() {
        if (contadorAlumnos == 0) {
            System.out.println("No hay alumnos");
            return;
        }

        double[] notaFinal = new double[contadorAlumnos];
        String[] alumnosOrdenados = Arrays.copyOf(alumnos, contadorAlumnos);
        int[] controlCopia = Arrays.copyOf(notaControl, contadorAlumnos);
        int[] finalCopia = Arrays.copyOf(notaFinalExamen, contadorAlumnos);
        int[] positivosCopia = Arrays.copyOf(positivos, contadorAlumnos);

        double maxPositivos = 0;
        for (int i = 0; i < contadorAlumnos; i++) {
            if (positivosCopia[i] > maxPositivos) {
                maxPositivos = positivosCopia[i];
            }
        }

        for (int i = 0; i < contadorAlumnos; i++) {
            notaFinal[i] = calcularNotaEvaluacion(controlCopia[i], finalCopia[i], positivosCopia[i]);
        }

        ordenarPorNotaAscendente(alumnosOrdenados, notaFinal, contadorAlumnos);

        for (int i = 0; i < contadorAlumnos; i++) {
            System.out.println(alumnosOrdenados[i] + " -> " + notaFinal[i]);
        }
    }

    private static void mostrarEstadisticasEvaluacion() {
        if (contadorAlumnos == 0) {
            System.out.println("No hay alumnos");
            return;
        }

        int suspensos = 0;
        double sumaFinal = 0;
        int maxControl = Integer.MIN_VALUE;
        String alumnoMaxControl = "";

        for (int i = 0; i < contadorAlumnos; i++) {
            if (notaFinalExamen[i] < 5) {
                suspensos++;
            }

            sumaFinal += calcularNotaEvaluacion(notaControl[i], notaFinalExamen[i], positivos[i]);

            if (notaControl[i] > maxControl) {
                maxControl = notaControl[i];
                alumnoMaxControl = alumnos[i];
            }
        }

        double porcentajeSuspensos = (suspensos * 100.0) / contadorAlumnos;
        double mediaFinal = sumaFinal / contadorAlumnos;

        System.out.println("Porcentaje de suspensos en el final: " + porcentajeSuspensos + "%");
        System.out.println("Media de la nota final de evaluacion: " + mediaFinal);
        System.out.println("Alumno con mayor nota en el control: " + alumnoMaxControl + " -> " + maxControl);
    }

    private static double calcularNotaEvaluacion(int control, int examenFinal, int numPositivos) {
        double maxPositivos = 0;
        for (int i = 0; i < contadorAlumnos; i++) {
            if (positivos[i] > maxPositivos) {
                maxPositivos = positivos[i];
            }
        }

        double notaPositivos = 0;
        if (maxPositivos > 0) {
            notaPositivos = (numPositivos * 10.0) / maxPositivos;
        }

        return control * 0.30 + examenFinal * 0.60 + notaPositivos * 0.10;
    }

    // ===================== HELPERS GENERALES =====================

    private static void aniadirAnio(int anio, int[] listaDeAnios) {
        if (getIndexOf(anio, listaDeAnios) == -1) {
            listaDeAnios[contadorAnios] = anio;
            contadorAnios++;
        }
    }

    private static void aniadirSucursal(String sucursal, String[] listaSucursales) {
        if (getIndexOf(sucursal, listaSucursales) == -1) {
            listaSucursales[contadorSucursales] = sucursal;
            contadorSucursales++;
        }
    }

    private static void aniadirCiudad(String ciudad, String[] lista) {
        if (getIndexOf(ciudad, lista) == -1) {
            lista[contadorCiudades] = ciudad;
            contadorCiudades++;
        }
    }

    private static int aniadirEquipoUnico(String[] lista, int contador, String equipo) {
        if (getIndexOf(equipo, lista) == -1) {
            lista[contador] = equipo;
            contador++;
        }
        return contador;
    }

    private static int getIndexOf(int valor, int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            if (valor == lista[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int getIndexOf(String valor, String[] lista) {
        if (valor == null) {
            return -1;
        }
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && valor.equalsIgnoreCase(lista[i])) {
                return i;
            }
        }
        return -1;
    }

    private static void ordenarPorNombreAscendente(String[] nombres, double[] valores, int longitud) {
        for (int i = 0; i < longitud - 1; i++) {
            for (int j = i + 1; j < longitud; j++) {
                if (nombres[i].compareToIgnoreCase(nombres[j]) > 0) {
                    String auxNombre = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = auxNombre;

                    double auxValor = valores[i];
                    valores[i] = valores[j];
                    valores[j] = auxValor;
                }
            }
        }
    }

    private static void ordenarPorValorAscendente(String[] nombres, double[] valores, int longitud) {
        for (int i = 0; i < longitud - 1; i++) {
            for (int j = i + 1; j < longitud; j++) {
                if (valores[i] > valores[j]) {
                    double auxValor = valores[i];
                    valores[i] = valores[j];
                    valores[j] = auxValor;

                    String auxNombre = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = auxNombre;
                }
            }
        }
    }

    private static void ordenarPorNotaAscendente(String[] nombres, double[] notas, int longitud) {
        for (int i = 0; i < longitud - 1; i++) {
            for (int j = i + 1; j < longitud; j++) {
                if (notas[i] > notas[j]) {
                    double auxNota = notas[i];
                    notas[i] = notas[j];
                    notas[j] = auxNota;

                    String auxNombre = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = auxNombre;
                }
            }
        }
    }
}

