package PSP_TEMA2_BOL3;

/*
 * EJERCICIO 5:
 * 
 * Crea una versión del ejercicio 4, implementándolo mediante bloques
 * sincronizados. Lanza los hilos mediante la clase Thread.
 */

public class ContadorVocalesBloque {

    private String texto;
    private int totalVocales = 0;

    // Objeto que usaremos como "candado" para sincronizar bloques
    private final Object lock = new Object();

    public ContadorVocalesBloque(String texto) {
        // Convertimos el texto a minúsculas para facilitar la comparación
        this.texto = texto.toLowerCase();
    }

    // Devuelve el total de vocales contadas
    public int getTotalVocales() {
        return totalVocales;
    }

    // Clase interna que representa un hilo que cuenta una vocal concreta
    class HiloVocal extends Thread {
        private char vocal;

        public HiloVocal(char vocal) {
            // Guardamos la vocal que este hilo debe contar
            this.vocal = vocal;
        }

        @Override
        public void run() {
            int contador = 0;

            // Recorremos el texto buscando la vocal asignada al hilo
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == vocal) {
                    contador++;
                }
            }

            // Bloque sincronizado: solo un hilo puede entrar aquí a la vez
            synchronized (lock) {
                totalVocales += contador;
            }

            // Mostramos cuántas veces aparece esa vocal
            System.out.println("Vocal " + vocal + ": " + contador);
        }
    }

    public static void main(String[] args) {

        // Texto a analizar
        String texto = "Otro texto de prueba para contar vocales.";

        // Creamos el objeto contador
        ContadorVocalesBloque contador = new ContadorVocalesBloque(texto);

        // Array con las vocales que contarán los hilos
        char[] vocales = { 'a', 'e', 'i', 'o', 'u' };

        // Array donde guardaremos los hilos creados
        Thread[] hilos = new Thread[vocales.length];

        // Creamos y arrancamos los hilos
        for (int i = 0; i < vocales.length; i++) {
            hilos[i] = contador.new HiloVocal(vocales[i]);
            hilos[i].start();
        }

        // Esperamos a que todos los hilos terminen
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
