package ExamenPSPTEMA1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Aleatorio {

    public static void main(String[] args) {

        // Control de argumentos
        if (args.length < 4) {
            System.err.println("Uso: java Aleatorio <M> <N> <X> <nombreFichero>");
            System.exit(1);
        }

        int numeroM = Integer.parseInt(args[0]);
        int numeroN = Integer.parseInt(args[1]);
        int cantidad = Integer.parseInt(args[2]);
        String nombreFichero = args[3];

        if (numeroM >= numeroN) {
            System.err.println("Error: M debe ser menor que N");
            System.exit(1);
        }

        try (PrintWriter pr = new PrintWriter(new File(nombreFichero))) {

            for (int i = 0; i < cantidad; i++) {
                int valorEntero = (int) (Math.floor(Math.random() * (numeroN - numeroM + 1) + numeroM));
                pr.println(valorEntero);
            }

            System.out.println("Fichero generado correctamente.");

        } catch (FileNotFoundException e) {
            System.err.println("Error al crear el fichero.");
            System.exit(1);
        }
    }
}
