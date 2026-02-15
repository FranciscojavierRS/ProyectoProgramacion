package ExamenPSPTEMA1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculos {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("Uso: java Calculos <nombreFichero>");
            System.exit(1);
        }

        String nombreFichero = args[0];
        int suma = 0;
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                suma += Integer.parseInt(linea);
                contador++;
            }

            if (contador > 0) {
                System.out.println("Suma = " + suma);
                System.out.println("Media = " + ((double) suma / contador));
            } else {
                System.out.println("El fichero está vacío.");
            }

        } catch (IOException e) {
            System.err.println("Error al leer el fichero.");
            System.exit(1);
        }
    }
}
