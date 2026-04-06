package EjerciciosAngelExcepciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;
/*
 * Create primero una clase llamada Coche cuyos atributos son nombre (String) numero de asientos (entero) y precio (double). 

Dos coches son iguales si tienen el mismo nombre. El criterio de ordenacion es por nombre y numero de asientos.

Create otra clase principal con un mapa con clave Coche y valor entero para representar la cantidad que hay de cada coche. el metodo main de esta clase debe de leer de un fichero txt con coches en cada linea con el formato nombre,numeroAsientos,precio e insertarlo en el mapa. Si insertas por primera vez un coche, le pones cantidad 1. Si ya existia, le incrementas la cantidad.

Todo esto imprimelo por pantalla y escribelo en otro fichero txt
1- Muestrame la lista de coches ordenada.
2- Muestra el coche con mayor cantidad
3- Muestra la media de precios de los coches
 */

public class PrincipalCoches {

	public static void main(String[] args) {

		TreeMap<Coche, Integer> mapaCoches = new TreeMap<>();

		try (BufferedReader in = new BufferedReader(new FileReader("ejercicioAngel.txt"))) {

			String linea = in.readLine();
			String[] campos;

			while (linea != null) {

				campos = linea.split(",");

				Coche coche = new Coche((campos[0]), Integer.parseInt(campos[1]), Double.parseDouble(campos[2]));

				if (!mapaCoches.containsKey(coche)) {
					mapaCoches.put(coche, 1);
				} else {
					mapaCoches.put(coche, mapaCoches.get(coche) + 1);

				}

				linea = in.readLine();

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// Ejercicio 1
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("copiaejercicioAngel.txt"));
			System.out.println("Esta es la lista de los coches de manera ordenada" + mapaCoches.keySet());

			out.write("lista de coches ordenadas");

			for (Coche coche : mapaCoches.keySet()) {
				out.newLine();
				out.write(coche.getNombre() + "," + coche.getNumeroAsientos() + "," + coche.getPrecio());

			}

			// Ejercicio 2

			Coche cocheMasVendido = null;
			int maximoNumeroCoches = 0;

			for (Coche coche : mapaCoches.keySet()) {

				if (mapaCoches.get(coche) > maximoNumeroCoches) {
					cocheMasVendido = coche;
					maximoNumeroCoches = mapaCoches.get(coche);

				}

			}

			System.out.println("este es el coche que se vendio mas veces " + cocheMasVendido.getNombre());

			out.newLine();

			out.write("este es el coche que se vendio mas veces " + cocheMasVendido.getNombre());

			// Ejercicio 3:

			int numeroCoches = 0;
			double mediaValorCoches = 0;

			for (Coche coche : mapaCoches.keySet()) {

				mediaValorCoches += coche.getPrecio();
				numeroCoches++;

			}

			System.out.println("La media de los precios de los coches es " + mediaValorCoches / numeroCoches + "€");

			out.newLine();

			out.write("La media de los precios de los coches es " + mediaValorCoches / numeroCoches + "€");

			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
