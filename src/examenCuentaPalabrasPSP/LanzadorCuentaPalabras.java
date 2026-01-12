package examenCuentaPalabrasPSP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzadorCuentaPalabras {

	public static void main(String[] args) {

		String ficheroLectura = args[0];
		String paqueteClase = args[1];
		
		LanzadorCuentaPalabras lanzador= new LanzadorCuentaPalabras();
		String[] palabras = { "servicio", "hilo","proceso","multihilo","concurrencia" };
		Process [] procesos = new Process [5];
		
		for (int i= 0; i<5; i++) {
			Process p= lanzador.lanzaCuentaPalabra(palabras[i], ficheroLectura, paqueteClase);
			procesos[i]=p;
		}
		
		for (int i= 0; i<5; i++) {
			try {
				Process p= procesos[i];
				p.waitFor();
				InputStreamReader isr_error = new InputStreamReader(p.getErrorStream());
				BufferedReader br_error = new BufferedReader(isr_error);
				
					if (br_error.readLine() == null) {
						//Se han generado correctamente los ficheros					
						InputStreamReader isr = new InputStreamReader(p.getInputStream());
						BufferedReader br = new BufferedReader(isr);
						
						String cadena = br.readLine();
						System.out.println(cadena);
						br.close();
						isr.close();
					}else {
						System.out.println("ERRORES AL LANZAR LOS PROCESOS");	
					}
					br_error.close();
					isr_error.close();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public Process lanzaCuentaPalabra(String palabra, String ficheroLectura, String paqueteClase) {
		ProcessBuilder pb;
        Process proceso = null;
        try {

        	pb=new ProcessBuilder("java", "-cp", "./bin", paqueteClase+".CuentaPalabra", ficheroLectura, palabra,palabra+".txt");
        	
        	//pb=new ProcessBuilder("java", "-jar", clase, n1.toString(), n2.toString());
        	//System.out.println(System.getProperty("user.dir"));
        	
              	
        	pb.redirectError(new File("Errores_" + palabra+".txt"));
        	//pb.redirectOutput(new File(palabra+".txt"));
  
        	proceso = pb.start();
        	//System.out.println("1=" + ProcessHandle.current().isAlive());
        	
        } catch (Exception e) {
                e.printStackTrace();
        }
        return proceso;
	}

}
