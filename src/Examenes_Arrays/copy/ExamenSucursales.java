package Examenes_Arrays.copy;

import java.util.Scanner;

public class ExamenSucursales {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Matriz donde transferencias[i][j] almacena
        // el dinero que la sucursal i envía a la sucursal j.
        float [][] transferencias = new float[20][20];

        // Iniciamos toda la tabla con -1 para indicar "no hay transferencia".
        inicializarTabla(transferencias);

        // Menú principal
        while (opcion != 5) {

            System.out.println("1- Introducir transferencia de una a otra sucursal.");
            System.out.println("2- Mostrar todos los datos introducidos.");
            System.out.println("3- Mostrar sucursal que ha recibido más dinero.");
            System.out.println("4- Mostrar en cuántas sucursales el total de lo enviado supera 10.000€.");
            System.out.println("5- Finalizar");

            opcion = sc.nextInt();

            switch (opcion) {

            // Introducir una transferencia entre sucursales
            case 1:
                introducirDatos(sc,transferencias);
                break;

            // Mostrar todas las transferencias no vacías
            case 2:
                mostrarLosDatos(transferencias);
                break;

            // Averiguar qué sucursal ha recibido más dinero
            case 3:
                numeroSucursalMasDineroRecibido(transferencias);
                break;

            // Contar cuántas sucursales han enviado más de 10.000€
            case 4:
                sucursalConMasDe10k(transferencias);
                break;

            case 5: 
                break;

            default:
                // No se hace nada
            }
            System.out.println("");
        }

        sc.close();
    }

    // -------------------------------------------------------------------------
    // Cuenta cuántas sucursales han enviado más de 10.000€
    // -------------------------------------------------------------------------
    private static void sucursalConMasDe10k(float[][] transferencias) {

        int sucursalMas10k = 0;

        for (int i= 0; i<20; i++) {

            float dinerosSucursales = 0;

            // Sumamos todo lo que envía la sucursal i
            for (int j= 0; j<20; j++) {

                if (transferencias[i][j] != -1) {
                    dinerosSucursales += transferencias[i][j];
                }
            }

            // Si supera 10.000€, contamos
            if (dinerosSucursales > 10000) {
                sucursalMas10k++;
            }
        }

        System.out.println(
            "El numero de sucursales que enviaron mas de 10.000€ fue: " 
            + sucursalMas10k
        );
    }

    // -------------------------------------------------------------------------
    // Calcula qué sucursal ha recibido más dinero (suma de columna j)
    // -------------------------------------------------------------------------
    private static void numeroSucursalMasDineroRecibido(float[][] transferencias) {

        float maximaTransferencia = 0;
        int indiceTransferencia = 0;

        // Recorremos por columnas (lo recibido)
        for (int j = 0; j < 20; j++) {

            float dinerosSucursales = 0;

            // Sumamos lo que recibe esta sucursal desde todas las demás
            for (int i = 0; i < 20; i++) {

                if (transferencias[i][j] != -1) {
                    dinerosSucursales += transferencias[i][j];
                }
            }

            // Guardamos el mayor
            if (dinerosSucursales > maximaTransferencia) {
                maximaTransferencia = dinerosSucursales;
                indiceTransferencia = j;
            }
        }

        System.out.println(
            "La sucursal que ha recibido mas dinero es la: " 
            + indiceTransferencia
            + " que recibió un total de: " 
            + maximaTransferencia
        );
    }

    // -------------------------------------------------------------------------
    // Muestra todas las transferencias registradas
    // -------------------------------------------------------------------------
    private static void mostrarLosDatos(float[][] transferencias) {

        for (int i = 0; i < 20; i++) {
            System.out.println("La sucursal num " + i + " ha enviado:");

            for (int j = 0; j < 20; j++) {

                float transferencia = transferencias[i][j];

                // Sólo mostramos los valores reales
                if (transferencia != -1) {
                    System.out.println("A la sucursal " + j + ", " + transferencia + "€");
                }
            }
        }
    }

    // -------------------------------------------------------------------------
    // Introduce una transferencia de una sucursal origen a destino
    // -------------------------------------------------------------------------
    private static void introducirDatos(Scanner sc, float[][] transferencias) {

        System.out.println("Introduce el numero de la sucursal de origen");
        int sucursalOrigen = sc.nextInt();

        System.out.println("Introduce el numero de la sucursal de destino");
        int sucursalDestino = sc.nextInt();

        System.out.println("Cantidad transferida");
        float cantidadTransferida = sc.nextFloat();

        // Guardamos el valor en la matriz
        transferencias[sucursalOrigen][sucursalDestino] = cantidadTransferida;

        System.out.println("Datos almacenados");
    }

    // -------------------------------------------------------------------------
    // Inicializa toda la tabla con -1
    // -------------------------------------------------------------------------
    private static void inicializarTabla(float[][] transferencias) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                transferencias[i][j] = -1;
            }
        }
    }
}
