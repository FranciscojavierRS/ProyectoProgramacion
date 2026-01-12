package Multiprocesos;

import java.io.File;

public class AbrirVariasVentanas {

	public Process abrirVentana(String url, String ficheroSalida) {
		ProcessBuilder pb;
        Process proceso = null;
        try {

        	pb=new ProcessBuilder("java", "-cp", "./bin", "Multiprocesos.RickRoll", url);
        	
        	//pb=new ProcessBuilder("java", "-jar", clase, n1.toString(), n2.toString());
        	//System.out.println(System.getProperty("user.dir"));
        	
        	pb.redirectOutput(new File(ficheroSalida));            	
                    	
        	pb.redirectError(new File("Errores-" + ficheroSalida));
  
        	proceso = pb.start();
        	//System.out.println("1=" + ProcessHandle.current().isAlive());
        	
        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return proceso;
	}
	
	public static void main(String[] args) {
		AbrirVariasVentanas v1= new AbrirVariasVentanas();
		AbrirVariasVentanas v2= new AbrirVariasVentanas();
		AbrirVariasVentanas v3= new AbrirVariasVentanas();
		Process p1=v1.abrirVentana(args[0], "Ventana1.txt");
		Process p2=v2.abrirVentana(args[1], "Ventana2.txt");
		Process p3=v3.abrirVentana(args[2], "Ventana3.txt");
		
		try {
			p1.waitFor();
			p2.waitFor();
			p3.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
