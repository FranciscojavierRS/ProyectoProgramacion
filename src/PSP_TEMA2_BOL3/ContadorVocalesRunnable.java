package PSP_TEMA2_BOL3;

/*  EJERCICIO 6:
 * 
 * Crea una versión del ejercicio anterior, implementándolo mediante bloques
 * sincronizados pero lanzando los hilos mediante el interfaz Runnable.
 */
public class ContadorVocalesRunnable {

    private String texto;
    private int totalVocales = 0;

    // Objeto usado como "candado" para sincronizar bloques
    private final Object lock = new Object();

    public ContadorVocalesRunnable(String texto) {
        // Convertimos el texto a minúsculas para facilitar la comparación
        this.texto = texto.toLowerCase();
    }

    // Devuelve el total de vocales contadas
    public int getTotalVocales() {
        return totalVocales;
    }

    // Clase interna que implementa Runnable en lugar de Thread
    class TareaVocal implements Runnable {
        private char vocal;

        public TareaVocal(char vocal) {
            // Guardamos la vocal que este hilo debe contar
            this.vocal = vocal;
        }

        @Override
        public void run() {
            int contador = 0;

            // Recorremos el texto contando cuántas veces aparece la vocal asignada
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
        String texto = "Texto de ejemplo para Runnable y bloques sincronizados.";

        // Creamos el objeto contador
        ContadorVocalesRunnable contador = new ContadorVocalesRunnable(texto);

        // Array con las vocales que contarán los hilos
        char[] vocales = { 'a', 'e', 'i', 'o', 'u' };

        // Array donde guardaremos los hilos creados
        Thread[] hilos = new Thread[vocales.length];

        // Creamos los hilos usando Runnable y los arrancamos
        for (int i = 0; i < vocales.length; i++) {
            Runnable tarea = contador.new TareaVocal(vocales[i]); // Creamos la tarea
            hilos[i] = new Thread(tarea); // La envolvemos en un Thread
            hilos[i].start(); // Arrancamos el hilo
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
