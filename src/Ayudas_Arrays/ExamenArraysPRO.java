package Ayudas_Arrays;

import java.util.*;

public class ExamenArraysPRO {

    static Scanner sc = new Scanner(System.in);

    // Contadores reales
    static int numFilas = 0;
    static int numColumnas = 0;

    static final int MAX_FILAS = 30;
    static final int MAX_COLUMNAS = 30;

    public static void main(String[] args) {

        float[][] datos = new float[MAX_FILAS][MAX_COLUMNAS];
        inicializarTabla(datos);

        String[] nombresFilas = new String[MAX_FILAS];
        String[] nombresColumnas = new String[MAX_COLUMNAS];

        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {

            // ================= INSERTAR =================
            case 1:
                System.out.println("Fila:");
                String fila = sc.next();
                añadirFila(fila, nombresFilas);

                System.out.println("Columna:");
                String col = sc.next();
                añadirColumna(col, nombresColumnas);

                System.out.println("Valor:");
                float valor = sc.nextFloat();

                datos[getIndex(fila, nombresFilas)][getIndex(col, nombresColumnas)] = valor;
                break;

            // ================= LISTAR =================
            case 2:
                for (int i = 0; i < numFilas; i++)
                    for (int j = 0; j < numColumnas; j++)
                        if (datos[i][j] != -1)
                            System.out.println(nombresFilas[i] + " - " + nombresColumnas[j] + ": " + datos[i][j]);
                break;

            // ================= MIN / MAX =================
            case 3:
                float min = Float.MAX_VALUE;
                for (int i = 0; i < numFilas; i++)
                    for (int j = 0; j < numColumnas; j++)
                        if (datos[i][j] != -1 && datos[i][j] < min)
                            min = datos[i][j];
                System.out.println("Min: " + min);
                break;

            case 4:
                float max = Float.MIN_VALUE;
                for (int i = 0; i < numFilas; i++)
                    for (int j = 0; j < numColumnas; j++)
                        if (datos[i][j] != -1 && datos[i][j] > max)
                            max = datos[i][j];
                System.out.println("Max: " + max);
                break;

            // ================= MEDIA DE UNA FILA =================
            case 5:
                System.out.println("Fila?");
                int f = getIndex(sc.next(), nombresFilas);
                float suma = 0;
                int cont = 0;
                for (int j = 0; j < numColumnas; j++) {
                    if (datos[f][j] != -1) {
                        suma += datos[f][j];
                        cont++;
                    }
                }
                if (cont > 0)
                    System.out.println("Media: " + (suma / cont));
                break;

            // ================= MAYORES QUE X =================
            case 6:
                System.out.println("Valor X:");
                float x = sc.nextFloat();
                for (int i = 0; i < numFilas; i++)
                    for (int j = 0; j < numColumnas; j++)
                        if (datos[i][j] > x)
                            System.out.println(nombresFilas[i] + " " + nombresColumnas[j]);
                break;

            // ================= CONTEO POR FILA =================
            case 7:
                for (int i = 0; i < numFilas; i++) {
                    int c = 0;
                    for (int j = 0; j < numColumnas; j++)
                        if (datos[i][j] > 10)
                            c++;
                    System.out.println(nombresFilas[i] + ": " + c);
                }
                break;

            // ================= ORDEN ALFABÉTICO =================
            case 8:
                String[] copia = Arrays.copyOf(nombresFilas, numFilas);
                Arrays.sort(copia);
                for (String s : copia)
                    System.out.println(s);
                break;

            // ================= ORDEN POR MEDIA =================
            case 9:
                float[] medias = new float[numFilas];
                for (int i = 0; i < numFilas; i++) {
                    float s = 0;
                    int c = 0;
                    for (int j = 0; j < numColumnas; j++) {
                        if (datos[i][j] != -1) {
                            s += datos[i][j];
                            c++;
                        }
                    }
                    medias[i] = (c > 0) ? s / c : 0;
                }

                for (int i = 0; i < numFilas; i++)
                    for (int j = i + 1; j < numFilas; j++)
                        if (medias[i] < medias[j]) {
                            float aux = medias[i]; medias[i] = medias[j]; medias[j] = aux;
                            String auxN = nombresFilas[i]; nombresFilas[i] = nombresFilas[j]; nombresFilas[j] = auxN;
                        }

                for (int i = 0; i < numFilas; i++)
                    System.out.println(nombresFilas[i] + " " + medias[i]);
                break;

            // ================= PORCENTAJE =================
            case 10:
                int total = 0, cumple = 0;
                for (int i = 0; i < numFilas; i++)
                    for (int j = 0; j < numColumnas; j++)
                        if (datos[i][j] != -1) {
                            total++;
                            if (datos[i][j] < 5)
                                cumple++;
                        }
                if (total > 0)
                    System.out.println("% = " + (cumple * 100.0 / total));
                break;

            // ================= TRANSFERENCIA =================
            case 11:
                System.out.println("Origen fila y col:");
                int fo = getIndex(sc.next(), nombresFilas);
                int co = getIndex(sc.next(), nombresColumnas);

                System.out.println("Destino fila y col:");
                int fd = getIndex(sc.next(), nombresFilas);
                int cd = getIndex(sc.next(), nombresColumnas);

                System.out.println("Cantidad:");
                float cant = sc.nextFloat();

                if (datos[fo][co] >= cant) {
                    datos[fo][co] -= cant;
                    datos[fd][cd] += cant;
                }
                break;

            // ================= MAX POR FILA =================
            case 12:
                for (int i = 0; i < numFilas; i++) {
                    float m = Float.MIN_VALUE;
                    for (int j = 0; j < numColumnas; j++)
                        if (datos[i][j] > m)
                            m = datos[i][j];
                    System.out.println(nombresFilas[i] + " max: " + m);
                }
                break;

            }

        } while (opcion != 0);
    }

    static void inicializarTabla(float[][] t) {
        for (int i = 0; i < t.length; i++)
            for (int j = 0; j < t[0].length; j++)
                t[i][j] = -1;
    }

    static void añadirFila(String f, String[] arr) {
        if (getIndex(f, arr) == -1)
            arr[numFilas++] = f;
    }

    static void añadirColumna(String c, String[] arr) {
        if (getIndex(c, arr) == -1)
            arr[numColumnas++] = c;
    }

    static int getIndex(String s, String[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (s.equalsIgnoreCase(arr[i]))
                return i;
        return -1;
    }

    static void mostrarMenu() {
        System.out.println("1 Insertar\n2 Listar\n3 Min\n4 Max\n5 Media fila\n6 Mayores que X\n7 Conteo\n8 Orden alfabetico\n9 Orden por media\n10 Porcentaje\n11 Transferencia\n12 Max por fila\n0 Salir");
    }
}
