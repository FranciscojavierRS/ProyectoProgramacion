package ExamenPSPTEMA1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class Pares {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.err.println("Uso: java Pares <ficheroOrigen> <ficheroDestino>");
            System.exit(1);
        }

        String ficheroOrigen = args[0];
        String ficheroDestino = args[1];

        try (
            BufferedReader br = new BufferedReader(new FileReader(ficheroOrigen));
            PrintWriter pr = new PrintWriter(new File(ficheroDestino))
        ) {

            String linea;

            while ((linea = br.readLine()) != null) {
                int numero = Integer.parseInt(linea);
                if (numero % 2 == 0) {
                    pr.println(numero);
                }
            }

            System.out.println("Fichero de pares generado correctamente.");

        } catch (IOException e) {
            System.err.println("Error al procesar los ficheros.");
            System.exit(1);
        }
    }
}
