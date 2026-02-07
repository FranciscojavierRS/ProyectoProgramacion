package EjemploPSP;

import java.io.*;
import java.nio.file.*;

public class Lanzador {

    public static void main(String[] args) throws Exception {
    	System.out.println("Directorio de trabajo: " + System.getProperty("user.dir"));


        // args[0] -> fichero de entrada
        // args[1] -> jar del Procesador
        if (args.length < 2) System.exit(1);

        String dato = args[0];
        String programa = args[1];

        // =================================================
        // CREAR FICHERO DE ENTRADA SI NO EXISTE
        // =================================================
        File ficheroEntrada = new File(dato);
        if (!ficheroEntrada.exists()) {
            PrintWriter pw = new PrintWriter(new FileWriter(ficheroEntrada));
            pw.println("servicio hilo proceso");
            pw.println("hilo concurrencia multihilo");
            pw.println("proceso servicio hilo");
            pw.close();
        }

        // valores a cambiar en cada proceso
        String[] tipos = {
            "servicio", "hilo", "proceso", "multihilo", "concurrencia"
        };

        Process[] procesos = new Process[tipos.length];

        // lanzar procesos
        for (int i = 0; i < tipos.length; i++) {

            ProcessBuilder pb = new ProcessBuilder(
                "java", "-jar",
                programa, dato, tipos[i], tipos[i] + ".txt"
            );
            pb.redirectOutput(new File("salida.txt"));


            // CREA fichero de errores automáticamente
            pb.redirectError(new File("Errores_" + tipos[i] + ".txt"));

            procesos[i] = pb.start();
        }

        // esperar a todos
        for (Process p : procesos) {
            p.waitFor();
        }

        // leer resultados
        int total = 0;
        for (String t : tipos) {

            // si el fichero de errores está vacío, todo OK
            if (Files.size(Paths.get("Errores_" + t + ".txt")) == 0) {
                BufferedReader br = new BufferedReader(new FileReader(t + ".txt"));
                total += Integer.parseInt(br.readLine());
                br.close();
            }
        }

        System.out.println("TOTAL = " + total);
    }
}
