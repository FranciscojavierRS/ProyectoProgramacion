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
import java.util.HashSet;
import java.util.Map;

/*
 *
​2. Paso 1: Carga y Filtrado (Lectura TXT y Set)
​Lee un fichero avistamientos_diarios.txt con el formato: especie,lugar,cantidad,peso.
​Crea objetos Avistamiento y añádelos a un HashSet<Avistamiento>.
​Pasa los elementos del Set a un ArrayList para poder ordenarlos.

​3. Paso 2: Copia de Seguridad (Binario)
​Escritura: Guarda el ArrayList en un fichero binario llamado registro_limpio.dat.
​Lectura: Recupera la lista desde el fichero binario en una nueva variable.

​4. Paso 3: Informe de Estadísticas (Salida TXT)
​Genera un archivo informe_aves.txt que responda a lo siguiente:
​Frecuencias: ¿Cuántas veces aparece cada lugar en el registro?
​Máximo: ¿Cuál es la especie con el mayor avistamiento (más cantidadAves)?
​Mínimo: ¿Cuál es el pesoPromedio más bajo registrado?
​Media: Calcula el peso promedio de todas las aves registradas en el fichero.
 */


public class PrincipalAvistamiento {

	public static void main(String[] args) {
		
		HashSet<Avistamiento> avistamientos = new HashSet<>();

		try {
			BufferedReader in = new BufferedReader(new FileReader("avistamientos_diarios.txt"));
			
			String linea = in.readLine();

			String[] campos;

			while (linea != null) {

				campos = linea.split(",");

				Avistamiento avistamiento = new Avistamiento(campos[0], campos[1], Integer.parseInt(campos[2]),
						Double.parseDouble(campos[3]));

				avistamientos.add(avistamiento);

				linea = in.readLine();

			}

			in.close();			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		// ​Pasa los elementos del Set a un ArrayList para poder ordenarlos.
		ArrayList<Avistamiento> avistamientosOrdenados = new ArrayList<>(avistamientos);
		avistamientosOrdenados.sort(null);
		
		//3 Paso 2:
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("registro_limpio.dat"));
		
			for (Avistamiento avistamiento : avistamientosOrdenados) {
				out.writeObject(avistamiento);

			}
			out.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList<Avistamiento> avistamientosOrdenados2 = new ArrayList<>();
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("registro_limpio.dat"));
		
			while (true) {

				avistamientosOrdenados2.add((Avistamiento) in.readObject());

			}
		
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}

		//4 Paso 3:
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("informe_aves.txt"));
			
			
			// ​Frecuencias: ¿Cuántas veces aparece cada lugar en el registro?
			HashMap<String, Integer> mapaAvistamientoRepeticiones = new HashMap<>();
			HashMap<String, Integer> mapaRepeticionesEspecie = new HashMap<>();
			
			double pesoPromedioMinimo = 9999999;
			
			double sumatorioPeso = 0;
			
			
			for (Avistamiento avistamiento : avistamientosOrdenados2) {
				
				sumatorioPeso+= avistamiento.getPesoPromedio();

				if (avistamiento.getPesoPromedio()<pesoPromedioMinimo) {
					pesoPromedioMinimo=avistamiento.getPesoPromedio();
				}
				
				
				if (!mapaAvistamientoRepeticiones.containsKey(avistamiento.getLugar())) {
					mapaAvistamientoRepeticiones.put(avistamiento.getLugar(), 1);

				} else {
					mapaAvistamientoRepeticiones.put(avistamiento.getLugar(), mapaAvistamientoRepeticiones.get(avistamiento.getLugar()) + 1);
				}
				
				if (!mapaRepeticionesEspecie.containsKey(avistamiento.getEspecie())) {
					mapaRepeticionesEspecie.put(avistamiento.getEspecie(), avistamiento.getCantidadAves());

				} else {
					mapaRepeticionesEspecie.put(avistamiento.getEspecie(), mapaRepeticionesEspecie.get(avistamiento.getEspecie()) + avistamiento.getCantidadAves());
				}
				

			}
			
			
			out.write("Veces que se repite cada lugar ");
			
			
			for (Map.Entry<String, Integer> entrada : mapaAvistamientoRepeticiones.entrySet()) {
				
				out.newLine();
				
				out.write(entrada.getKey()+" : "+entrada.getValue());
				
				
			}
		
			String especieMasUnidades = null;
			int maxrepeticiones = 0;
			
			for (Map.Entry<String, Integer> entrada : mapaRepeticionesEspecie.entrySet()) {
				
				if (entrada.getValue() > maxrepeticiones) {
					maxrepeticiones = entrada.getValue();
					especieMasUnidades = entrada.getKey();
				}
				
			}

			out.newLine();

			out.write("La especie con el mayor avistamiento es:" +especieMasUnidades);
			
			out.newLine();
			
			out.write("El peso promedio registrado es de :"+" "+pesoPromedioMinimo);
			
			out.newLine();
			
			out.write("El peso promedio de todas las aves es:"+sumatorioPeso/avistamientosOrdenados2.size());
			
			
			out.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
		
		
		

	}

}
