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




/*
 * 1. Modelo de Datos (POO)
Crea una clase única llamada Componente:
Atributos: id (int), nombre (String), categoria (String), stock (int) y precioUnitario (double).
Un componente es igual a otro si tiene el mismo id.
Criterio de ordenación: Por categoria y, en caso de empate, por nombre.
2. Paso 1: Importación de datos (Texto a Objetos)
Lee un fichero de texto llamado nuevos_componentes.txt con el siguiente formato:
ID;Nombre;Categoria;Stock;Precio (Nota: el separador es punto y coma ;).
Lee cada línea y crea un objeto Componente.
Guarda los objetos en un ArrayList<Componente>.
3. Paso 2: Persistencia Binaria (Escritura y Lectura)
Escritura: Guarda la lista completa de componentes en un fichero binario llamado almacen.dat.
Lectura: En el método main, sobreescribe la lista leyendo el fichero almacen.dat
​4. Paso 3: Procesamiento e Informe (Objetos a Texto)
​Genera un archivo reporte_inventario.txt con la siguiente información:
​La lista de todos los componentes ordenados según el criterio definido en el paso 1.
​Conteo por categoría: Indica cuántos componentes hay de cada categoría (ej: "Procesadores: 5", "RAM: 3")
Valor del inventario: Suma total de stock * precioUnitario de todos los productos.
El nombre del componente que tiene menos unidades en stock (el más próximo a agotarse).
 */
public class PrincipalComponente {

	public static void main(String[] args) {

		// Paso 1
		ArrayList<Componente> listaComponentes = new ArrayList<>();

		try {
			BufferedReader in = new BufferedReader(new FileReader("nuevos_componentes.txt"));

			String linea = in.readLine();

			String[] campos;

			while (linea != null) {

				campos = linea.split(";");

				Componente componente = new Componente(Integer.parseInt(campos[0]), campos[1], campos[2],
						Integer.parseInt(campos[3]), Double.parseDouble(campos[4]));

				listaComponentes.add(componente);

				linea = in.readLine();

			}

			in.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// Paso 2:

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("almacen.dat"));

			for (Componente componente : listaComponentes) {

				out.writeObject(componente);

			}
			out.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		listaComponentes = new ArrayList<>();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("almacen.dat"));

			while (true) {

				listaComponentes.add((Componente) in.readObject());

			}

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}

		// Paso 3

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("reporte_inventario.txt"));

			listaComponentes.sort(null);
			HashMap<String, Integer> mapaCategoria = new HashMap<>();

			double totalInventario = 0;

			Componente componenteConMenosUnidades = null;
			int minimoUnidades = 99999;

			for (Componente componente : listaComponentes) {
				out.newLine();
				out.write(componente.getNombre() + " " + componente.getPrecioUnitario());

				if (!mapaCategoria.containsKey(componente.getCategoria())) {
					mapaCategoria.put(componente.getCategoria(), componente.getStock());

				} else {
					mapaCategoria.put(componente.getCategoria(),
							mapaCategoria.get(componente.getCategoria()) + componente.getStock());
				}

				totalInventario += componente.getPrecioUnitario() * componente.getStock();

				if (componente.getStock() < minimoUnidades) {
					minimoUnidades = componente.getStock();
					componenteConMenosUnidades = componente;
				}

			}

			for (Map.Entry<String, Integer> entrada : mapaCategoria.entrySet()) {

				out.newLine();
				out.write(entrada.getKey() + " : " + entrada.getValue());

			}

			out.newLine();

			out.write("El valor total del inventario es: " + totalInventario);
			out.newLine();
			out.write("El componente que tiene menos unidades es " + componenteConMenosUnidades.getNombre());

			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
