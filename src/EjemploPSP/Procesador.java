package EjemploPSP;

import java.io.*;

public class Procesador {

    public static void main(String[] args) throws IOException {

        // args[0] -> fichero de entrada
        // args[1] -> tipo / palabra a contar
        // args[2] -> fichero de salida
        if (args.length < 3) System.exit(1);

        String entrada = args[0];
        String tipo = args[1];
        String salida = args[2];

        contar(entrada, tipo, salida);
    }

    static void contar(String entrada, String tipo, String salida) throws IOException {

        int cont = 0;

        BufferedReader br = new BufferedReader(new FileReader(entrada));
        String linea;

        while ((linea = br.readLine()) != null) {

            // LÓGICA DEL EJERCICIO (modificable en examen)
            for (String p : linea.toLowerCase().split("\\W+")) {
                if (p.equals(tipo.toLowerCase())) cont++;
            }
        }

        br.close();

        // CREA el fichero de salida si no existe
        PrintWriter pw = new PrintWriter(new FileWriter(salida));
        pw.println(cont);
        pw.close();
    }
}
