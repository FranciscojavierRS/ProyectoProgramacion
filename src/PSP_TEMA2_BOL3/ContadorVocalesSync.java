package PSP_TEMA2_BOL3;

/*
 * EJERCICIO 4:
 * 
 * Crea una clase Java que utilice 5 hilos para contar el número de vocales que
hay en un determinado texto. Cada hilo se encargará de contar una vocal
diferente, actualizando todos los hilos la misma variable común que
representa el número de vocales totales. Para evitar condiciones de carrera se
deben utilizar métodos sincronizados. 
 */
public class ContadorVocalesSync {

    private String texto;
    private int totalVocales = 0;

    public ContadorVocalesSync(String texto) {
        // Guardamos el texto en minúsculas para facilitar la comparación
        this.texto = texto.toLowerCase();
    }

    // Método sincronizado para actualizar el total
    // Solo un hilo puede entrar aquí a la vez → evita condiciones de carrera
    public synchronized void sumarAlTotal(int cantidad) {
        totalVocales += cantidad;
    }

    // Devuelve el total de vocales contadas
    public int getTotalVocales() {
        return totalVocales;
    }

    // Hilo que cuenta una vocal concreta
    class HiloVocal extends Thread {
        private char vocal;

        public HiloVocal(char vocal) {
            // Cada hilo recibe la vocal que debe contar
            this.vocal = vocal;
        }

        @Override
        public void run() {
            int contador = 0;

            // Recorremos todo el texto buscando la vocal asignada al hilo
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == vocal) {
                    contador++;
                }
            }

            // Actualizamos el total de forma sincronizada
            sumarAlTotal(contador);

            // Mostramos cuántas veces aparece esa vocal
            System.out.println("Vocal " + vocal + ": " + contador);
        }
    }

    public static void main(String[] args) {
        // Texto a analizar
        String texto = "Este es un texto de prueba con varias vocales.";

        // Creamos el objeto contador
        ContadorVocalesSync contador = new ContadorVocalesSync(texto);

        // Array con las vocales que contarán los hilos
        char[] vocales = { 'a', 'e', 'i', 'o', 'u' };

        // Array para almacenar los hilos creados
        Thread[] hilos = new Thread[vocales.length];

        // Creamos y arrancamos los 5 hilos, uno por vocal
        for (int i = 0; i < vocales.length; i++) {
            hilos[i] = contador.new HiloVocal(vocales[i]);
            hilos[i].start();
        }

        // Esperamos a que todos los hilos terminen su ejecución
        for (Thread t : hilos) {
            try {
                t.join(); // join() hace que el main espere a cada hilo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mostramos el total de vocales encontradas
        System.out.println("Total de vocales: " + contador.getTotalVocales());
    }
}
