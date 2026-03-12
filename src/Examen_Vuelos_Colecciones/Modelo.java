package Examen_Vuelos_Colecciones;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Modelo{
	
	private TreeMap<Localidad,HashSet<Vuelo>> conexiones;
	private TreeSet<LineaAerea> lineas;

	public Modelo()	{
		this.conexiones = new TreeMap<Localidad,HashSet<Vuelo>>();
		this.lineas = new TreeSet<LineaAerea>();
	}

	public void addLinea(LineaAerea linea)
	{
		// 1. Añadir la línea aérea al TreeSet
		// 2. TreeSet automáticamente ordena por Comparable de LineaAerea
		// 3. TreeSet.add() devuelve true si se añadió, false si ya existía
		this.lineas.add(linea);
	}
	
	
	

	public void addLocalidad(Localidad localidad){
		// 1. Añade al mapa de conexiones una nueva pareja con la localidad
		// 2. Crea un nuevo conjunto de vuelos vacío para esta localidad
		// 3. TreeMap.put() sobrescribe si la clave ya existe
		this.conexiones.put(localidad, new HashSet<>());

	}

	public void addVueloALocalidad(Localidad localidad, Vuelo vuelo){
		// 1. Añade el vuelo al conjunto de vuelos asociado a la localidad
		// 2. Obtiene el HashSet de vuelos de esa localidad y añade el vuelo
		this.conexiones.get(localidad).add(vuelo);
	}

	public boolean hayErrores()	{
		// Devuelve true si hay errores: vuelo con misma localidad de origen que destino
		
		// 1. Recorrer cada localidad del mapa (clave)
		// 2. Por cada localidad, recorrer su conjunto de vuelos
		// 3. Si algún vuelo tiene como destino la misma localidad origen → error

		for (Localidad localidad: this.conexiones.keySet()) {
			// 4. Recorrer todos los vuelos que parten de esta localidad
			for (Vuelo vuelo : this.conexiones.get(localidad)) {
				// 5. Verificar si el destino es igual al origen
				if (vuelo.getDestino().equals(localidad)) {
					// 6. Error encontrado: vuelo a sí mismo
					return true;
					
				}
			}
		}

		// 7. No se encontraron errores
		return false;
	}

	public int numVuelosALocsMillon(Localidad localidad){
		// Devuelve número de vuelos que parten de la localidad y llegan a ciudades >1M hab.
		
		// 1. Contador para vuelos a ciudades con más de 1 millón de habitantes
		int vuelosMas1Millon = 0;
		
		// 2. Recorrer todos los vuelos que parten de la localidad especificada
		for (Vuelo vuelo: this.conexiones.get(localidad)) {
			// 3. Verificar si el destino tiene más de 1.000.000 habitantes
			if (vuelo.getDestino().getHabitantes()>=1000000) {
				// 4. Incrementar contador si cumple la condición
				vuelosMas1Millon++;
			}
		}

		// 5. Devolver el total de vuelos a ciudades grandes
		return vuelosMas1Millon;
	}

	public TreeSet<LineaAerea> lineasHasta(Localidad localidad)	{
		// Devuelve TreeSet con todas las líneas aéreas que tienen vuelos hacia la localidad
		
		// 1. Crear TreeSet para almacenar líneas (automáticamente ordenado y sin duplicados)
		TreeSet <LineaAerea> lineas = new TreeSet<>();
		
		// 2. Recorrer todas las localidades de origen en el mapa
		for (Localidad localidad2: this.conexiones.keySet()) {
			// 3. Recorrer todos los vuelos de cada localidad de origen
			for (Vuelo vuelo : this.conexiones.get(localidad2)) {
				// 4. Verificar si el destino de este vuelo es la localidad buscada
				if (vuelo.getDestino().equals(localidad)) {
					// 5. Añadir la línea aérea de este vuelo al conjunto
					lineas.add(vuelo.getLinea());
				}
			}
		}
		
		// 6. Devolver el conjunto de líneas que vuelan a esa localidad
		return lineas;
	}

	public int totalAvionesDesde(Localidad localidad){
		// Devuelve suma de todos los aviones de las líneas que hacen vuelos desde la localidad
		
		// 1. Contador para el total de aviones
		int contadorAvionesLineas = 0; 
		// 2. TreeSet para evitar contar la misma línea varias veces
		TreeSet <LineaAerea> lineas = new TreeSet<>();
		
		// 3. Recorrer todos los vuelos que parten de la localidad
		for (Vuelo vuelo : this.conexiones.get(localidad)) {
			// 4. Verificar si ya hemos contado esta línea (evitar duplicados)
			if (!lineas.contains(vuelo.getLinea())) {
				// 5. Añadir línea al conjunto de líneas ya contadas
				lineas.add(vuelo.getLinea());
				// 6. Sumar el número de aviones de esta línea al contador
				contadorAvionesLineas+= vuelo.getLinea().getNumAviones();
			}
		}

		// 7. Devolver el total de aviones de todas las líneas únicas
		return contadorAvionesLineas;
	}

	public boolean hayVuelosReciprocos(){
		// Devuelve true si existen dos ciudades con vuelos en ambos sentidos
		
		// 1. Recorrer cada localidad de origen
		for (Localidad localidad: this.conexiones.keySet()) {
			// 2. Recorrer todos los vuelos de esta localidad
			for (Vuelo vuelo : this.conexiones.get(localidad)) {
				// 3. Para cada vuelo, verificar si existe vuelo de regreso
				// 4. Acceder a los vuelos del destino y buscar si hay vuelo a la localidad original
				for (Vuelo vuelo2 : this.conexiones.get(vuelo.getDestino())) {
					// 5. Verificar si el destino del vuelo de regreso es la localidad original
					if (localidad.equals(vuelo2.getDestino())) {
						// 6. Se encontraron vuelos recíprocos
						return true;
					}
				}
				
			}
		}
		
		// 7. No se encontraron vuelos recíprocos
		return false;
	}

	@Override
	public String toString(){
		// Genera representación textual de todas las conexiones de vuelos
		
		// 1. String para construir el resultado
		String res="";
		// 2. Recorrer cada localidad de origen
		for(Localidad l:this.conexiones.keySet())
		{
			// 3. Añadir encabezado para esta localidad de origen
			res+="\nDesde: "+l.getNombre()+" hasta:\n";
			// 4. Recorrer todos los vuelos de esta localidad
			for(Vuelo v:this.conexiones.get(l))
				// 5. Añadir información del destino y línea aérea
				res+=v.getDestino().getNombre()+" con "+v.getLinea()+", ";
		}

		// 6. Devolver la representación completa
		return res;
	}

}
