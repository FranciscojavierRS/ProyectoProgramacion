package PSP_TEMA2_BOL3;

/*  EJERCICIO 7:
 * 
 * Crea un programa que simule un cajero automático de donde se retira y se
 * ingresa dinero. Tendremos:
 * 
 * 1. Una clase Cuenta donde tendremos 2 métodos, retirarDinero e
 *    ingresarDinero que realizará las respectivas operaciones. Controlar si
 *    hay algún error:
 *    a. si se hace algún reintegro y no hay saldo o se supera el máximo
 *    b. si se hace un ingreso y el saldo supera el máximo permitido
 * 
 *    Se deberá poder obtener el saldo actual.
 * 
 * 2. Se crearán 2 hilos: uno para realizar los ingresos y otro para realizar los
 *    reintegros.
 * 
 * 3. La clase principal recibe en su constructor el saldo actual y el valor
 *    máximo que puede tener. Se realizarán 2 ingresos y 2 retiradas de dinero
 *    alternándolos. Mostrar mensajes con los movimientos que se realicen.
 * 
 * 4. Para crear los movimientos de dinero generar números aleatorios entre 1
 *    y 500 con la función:
 *    int aleatorio = ((int)(Math.random() * 500 + 1));
 */

public class Cuenta {

    private double saldo;   // Saldo actual de la cuenta
    private double maximo;  // Límite máximo permitido en la cuenta

    public Cuenta(double saldoInicial, double maximo) {
        // Inicializamos el saldo y el máximo permitido
        this.saldo = saldoInicial;
        this.maximo = maximo;
    }

    // Método sincronizado para ingresar dinero
    // Solo un hilo puede ejecutarlo a la vez → evita inconsistencias
    public synchronized void ingresarDinero(double cantidad) {

        // Comprobamos si el ingreso supera el máximo permitido
        if (saldo + cantidad > maximo) {
            System.out.println("ERROR: Ingreso de " + cantidad 
                    + " supera el máximo permitido. Saldo actual: " + saldo);
        } else {
            // Si no supera el máximo, se suma al saldo
            saldo += cantidad;
            System.out.println("Ingreso de " + cantidad 
                    + " realizado. Saldo actual: " + saldo);
        }
    }

    // Método sincronizado para retirar dinero
    public synchronized void retirarDinero(double cantidad) {

        // Comprobamos si hay saldo suficiente para retirar
        if (cantidad > saldo) {
            System.out.println("ERROR: No hay saldo suficiente para retirar " 
                    + cantidad + ". Saldo actual: " + saldo);
        } else {
            // Si hay saldo suficiente, se descuenta
            saldo -= cantidad;
            System.out.println("Retirada de " + cantidad 
                    + " realizada. Saldo actual: " + saldo);
        }
    }

    // Método sincronizado para consultar el saldo actual
    public synchronized double getSaldo() {
        return saldo;
    }
}
