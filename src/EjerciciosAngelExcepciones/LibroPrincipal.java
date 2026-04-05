package EjerciciosAngelExcepciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Ejercicio: Sistema de Gestión de Inventario de Biblioteca
​1. La Clase de Datos (POO)
​Crea una clase llamada Libro con:
​Atributos: isbn (String), titulo (String), cantidad (int) y precio (double).

​2. Paso 1: Importación desde TXT (Lectura con Split)
​Imagina que tienes un archivo llamado datos_brutos.txt con este contenido (puedes crearlo manualmente para probar):
8401,El Quijote,5,15.50
9782,Fundacion,10,25.00
1234,Java Total,2,40.00
Crea un método que lea este archivo línea a línea y guarde cada libro en una lista.
3. Paso 2: Copia de Seguridad (Escritura Binaria)
Toma el ArrayList resultante y escríbelo en un fichero binario llamado biblioteca.dat.
4. Paso 3: Recuperación y Reporte (Lectura Binaria y Escritura TXT)
Lee el contenido de biblioteca.dat y cárgalo de nuevo en el programa.
​Genera un nuevo archivo de texto llamado inventario_final.txt que contenga:
​El título de todos los libros con su precio.
​El valor total del inventario (suma de cantidad * precio de cada libro).
​Una línea que diga cuál es el libro con más unidades en stock.
 */

public class LibroPrincipal {

	public static void main(String[] args) {

		ArrayList<Libro> listaLibros = listaLibros("datos_brutos.txt");

		// 3

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("biblioteca.dat"));

			for (Libro libro : listaLibros) {
				out.writeObject(libro);

			}
			out.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// 4
		ArrayList<Libro> listaLibros2 = new ArrayList<>();

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("biblioteca.dat"));

			while (true) {

				listaLibros2.add((Libro) in.readObject());

			}

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("inventario_final.txt"));

			double totalInventario = 0;

			for (Libro libro : listaLibros) {
				out.write(libro.getTitulo() + " " + libro.getPrecio());
				out.newLine();

				totalInventario += libro.getPrecio();

			}

			out.write("el valor total del inventario es " + totalInventario);

			HashMap<Libro, Integer> mapaLibroRepeticiones = new HashMap<>();

			for (Libro libro : listaLibros) {

				if (!mapaLibroRepeticiones.containsKey(libro)) {
					mapaLibroRepeticiones.put(libro, 1);

				} else {
					mapaLibroRepeticiones.put(libro, mapaLibroRepeticiones.get(libro) + 1);
				}

			}

			Libro libroMasUnidades = null;
			int maxrepeticiones = 0;

			for (Map.Entry<Libro, Integer> entrada : mapaLibroRepeticiones.entrySet()) {

				if (entrada.getValue() > maxrepeticiones) {
					maxrepeticiones = entrada.getValue();
					libroMasUnidades = entrada.getKey();
				}

			}

			out.newLine();

			out.write("El libro con mas unidades es:" + libroMasUnidades.getTitulo());
			
			out.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static ArrayList<Libro> listaLibros(String nombrefichero) {

		ArrayList<Libro> listaLibros = new ArrayList<>();

		try {
			BufferedReader in = new BufferedReader(new FileReader(nombrefichero));

			String linea = in.readLine();

			String[] campos;

			while (linea != null) {

				campos = linea.split(",");

				Libro libro = new Libro(campos[0], campos[1], Integer.parseInt(campos[2]),
						Double.parseDouble(campos[3]));

				listaLibros.add(libro);

				linea = in.readLine();

			}

			in.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaLibros;

	}

}
