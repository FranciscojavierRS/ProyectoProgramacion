package PSP_TEMA2_BOL2;

public class PrincipalV3 {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Uso: java Principal <tamArray> <numHilos>");
            return;
        }

        int tamArray = Integer.parseInt(args[0]);
        int numHilos = Integer.parseInt(args[1]);

        int[] notas = new int[tamArray];

        // 🔹 HILO GENERADOR
        HiloGenerador generador = new HiloGenerador(notas);
        generador.start();

        // Esperar a que termine de rellenar el array
        try {
            generador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        

        // 🔹 HILOS QUE BUSCAN EL MÁXIMO
        HiloMaximo[] hilos = new HiloMaximo[numHilos];
        int tamParte = tamArray / numHilos;

        for (int i = 0; i < numHilos; i++) {

            int inicio = i * tamParte;
            int fin;

            if (i == numHilos - 1) {
                fin = tamArray;
            } else {
                fin = inicio + tamParte;
            }

            hilos[i] = new HiloMaximo(notas, inicio, fin);
            hilos[i].start();
        }

        // Esperar a que terminen todos
        try {
            for (int i = 0; i < numHilos; i++) {
                hilos[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 🔹 Máximo final
        int maxFinal = hilos[0].getMaximo();

        for (int i = 1; i < numHilos; i++) {
            if (hilos[i].getMaximo() > maxFinal) {
                maxFinal = hilos[i].getMaximo();
            }
        }

        System.out.println("La calificación máxima es: " + maxFinal);
    }
}

