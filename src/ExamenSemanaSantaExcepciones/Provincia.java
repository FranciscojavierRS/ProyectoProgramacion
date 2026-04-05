package ExamenSemanaSantaExcepciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Provincia implements Comparable<Provincia>{
	private String nombre;
	private HashSet<Hermandad> hermandades = new HashSet<>();

	public Provincia(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Hermandad> getHermandades() {
		return hermandades;
	}

	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre /*+ ", hermandades=" + hermandades  */+"]";
	}

	// e) 
	public boolean leerHermandadesYanyadirlas(File file) {
		boolean añadidos = false;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String linea = in.readLine();
			String[] campos;
			
			while(linea != null) {
				campos=linea.split(", ");
				añadidos=añadidos || hermandades.add(new Hermandad(campos[0], Integer.parseInt(campos[1])));
				linea = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return añadidos;
	}

	// f) 
	public void escribirHermandadesEnTXT(File file) {
		
	
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(file));
				for (Hermandad hermandad : hermandades) {
					out.write(hermandad.getNombre()+", "+hermandad.getNumHermanos());
					out.newLine();
				}
				out.close();
			} catch (IOException e) {
				
				
				e.printStackTrace();
			}
			
	
		
	}

	@Override
	public int compareTo(Provincia o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.nombre);
	}

}
