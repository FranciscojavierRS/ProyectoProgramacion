package ExamenPSPTEMA1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lanzador {

    public static void main(String[] args) {

        ProcessBuilder pb;
        BufferedReader br;
        String linea;

        try {

            String classpath = System.getProperty("java.class.path");

            // PROCESO 1 - Generar números
            pb = new ProcessBuilder("java", "-cp", classpath,
                    "ExamenPSPTEMA1.Aleatorio",
                    "2", "50", "10", "numeros.txt");

            Process proceso1 = pb.start();
            int salida1 = proceso1.waitFor();

            if (salida1 != 0) {
                System.err.println("Error en proceso 1");
                return;
            }

            // PROCESO 2 - Cálculos fichero original
            pb = new ProcessBuilder("java", "-cp", classpath,
                    "ExamenPSPTEMA1.Calculos",
                    "numeros.txt");

            pb.redirectOutput(new File("salidaCalculos.txt"));
            pb.redirectError(new File("Errores-salidaCalculos.txt"));
            Process proceso2 = pb.start();

            // PROCESO 3 - Obtener pares
            pb = new ProcessBuilder("java", "-cp", classpath,
                    "ExamenPSPTEMA1.Pares",
                    "numeros.txt", "pares.txt");

            pb.redirectError(new File("Errores-salidaPares.txt"));
            Process proceso3 = pb.start();

            int salida3 = proceso3.waitFor();

            if (salida3 != 0) {
                System.err.println("Error en proceso 3");
                return;
            }

            // PROCESO 4 - Cálculos pares
            pb = new ProcessBuilder("java", "-cp", classpath,
                    "ExamenPSPTEMA1.Calculos",
                    "pares.txt");

            pb.redirectOutput(new File("salidaCalculosPares.txt"));
            pb.redirectError(new File("Errores-salidaCalculosPares.txt"));
            Process proceso4 = pb.start();

            int salida2 = proceso2.waitFor();
            int salida4 = proceso4.waitFor();

            if (salida2 == 0 && salida4 == 0) {

                System.out.println("Resultados fichero original:");
                br = new BufferedReader(new FileReader("salidaCalculos.txt"));
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                br.close();

                System.out.println("\nResultados fichero pares:");
                br = new BufferedReader(new FileReader("salidaCalculosPares.txt"));
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                br.close();

            } else {
                System.err.println("Algún proceso terminó con error.");
            }

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
