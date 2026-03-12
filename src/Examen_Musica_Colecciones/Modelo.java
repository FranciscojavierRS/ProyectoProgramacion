package Examen_Musica_Colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Modelo {
	private TreeMap<Grupo, LinkedHashSet<Integrante>> integrantes = new TreeMap<>();
	private ArrayList<Alquiler> alquileres = new ArrayList<>();

	// mapa cuya clave es el c�digo del local, y cuyo valor es un mapa de pares
	// <fecha-descripci�n de la incidencia>
	private HashMap<Integer, TreeMap<FechaHora, String>> incidenciasLocales = new HashMap<>();

	public Modelo() {
		super();
	}

	public TreeMap<Grupo, LinkedHashSet<Integrante>> getIntegrantes() {
		return integrantes;
	}

	public ArrayList<Alquiler> getAlquileres() {
		return alquileres;
	}

	public HashMap<Integer, TreeMap<FechaHora, String>> getIncidenciasLocales() {
		return incidenciasLocales;
	}

	public boolean addIntegrante(Grupo grupo, Integrante integrante) {
		// 1. Verificar si el grupo ya existe en el mapa
		if (!this.integrantes.containsKey(grupo)) {
			// 2. Si no existe, crear nuevo LinkedHashSet para sus integrantes
			this.integrantes.put(grupo, new LinkedHashSet<Integrante>());
		}
		// 3. Añadir el integrante al conjunto del grupo
		// 4. LinkedHashSet.add() evita duplicados y mantiene orden de inserción
		return this.integrantes.get(grupo).add(integrante);
	}

	public boolean addIntegrante(String nombreGrupo, TipoMusica tipoMusica, String nombreIntegrante,
			String dniIntegrante) {
		// 1. Método sobrecargado que crea objetos Grupo e Integrante internamente
		// 2. Delega la lógica al método addIntegrante principal
		return addIntegrante(new Grupo(nombreGrupo, tipoMusica), new Integrante(nombreIntegrante, dniIntegrante));
	}

	public void addAlquiler(Alquiler alquiler) {
		// 1. Añadir el alquiler a la ArrayList de alquileres
		// 2. ArrayList.add() añade al final y siempre devuelve true
		// 3. ArrayList permite duplicados y mantiene orden de inserción
		alquileres.add(alquiler);
	}

	// TODO a):
	// A�ade la incidencia relativa a dicho local.
	// Si dicho local no estuviera aun en el mapa de incidencias, habr�a que
	// a�adirlo.
	// Si hubiera una incidencia en esa misma fechahora para ese mismo local, se
	// considerar�a un error, por lo que el m�todo no a�adir�a la incidencia y
	// devolver�a false.
	public boolean addIncidencia(int local, FechaHora fecha, String incidencia) {
		
		// 1. Verificar si el local ya existe en el mapa de incidencias
		if (!incidenciasLocales.containsKey(local)) {
			// 2. Si no existe, crear nuevo TreeMap para sus incidencias
			incidenciasLocales.put(local, new TreeMap<FechaHora, String>());
			
		}
		
		// 3. Verificar si ya existe una incidencia en esa misma fecha/hora para ese local
		if (!incidenciasLocales.get(local).containsKey(fecha)) {
			// 4. Si no hay conflicto, añadir la incidencia
			incidenciasLocales.get(local).put(fecha, incidencia);
			
			// 5. Devolver true (incidencia añadida correctamente)
			return true;
			
		}

		// 6. Ya existe una incidencia en esa fecha/hora, devolver false
		return false;
	}

	// TODO b): Elimina al integrante con ese dni del grupo indicado.
	// Devuelve true si ha podido eliminarlo, y false si no ha podido porque no
	// estaba en dicho grupo.
	public boolean eliminaIntegrante(Grupo grupo, String dniIntegrante) {
		
		/*
		 * 1. Comprobar si el grupo existe en el mapa de integrantes
		 * 2. Obtener la lista de integrantes del grupo
		 * 3. Buscar y eliminar integrante con el DNI especificado usando Iterator
		 * 4. Iterator permite eliminación segura mientras recorremos
		 */

		// 5. Verificar si el grupo existe en el mapa
		if(integrantes.containsKey(grupo)) {
			// 6. Obtener Iterator para eliminación segura
			Iterator<Integrante> iteradorIntegrantes = integrantes.get(grupo).iterator();
			
			// 7. Recorrer todos los integrantes del grupo
			for ( ; iteradorIntegrantes.hasNext();  ) {
				Integrante integrante =(Integrante) iteradorIntegrantes.next();
				// 8. Verificar si este integrante tiene el DNI buscado
				if (integrante.getDni().equals(dniIntegrante)) {
					// 9. Eliminar el integrante de forma segura
					iteradorIntegrantes.remove();
					// 10. Devolver true (integrante eliminado correctamente)
					return true;
				}
			}
			
		}
		
		
		// 11. No se encontró el integrante o el grupo no existe
		return false;
	}

	// TODO c):
	// Devuelve una lista de incidencias que han sucedido en un d�a concreto
	public List<String> getIncidencias(Fecha fecha) {
		
		/*
		 * 1. Crear ArrayList vacía para almacenar las descripciones de incidencias
		 * 2. Recorrer el mapa de incidencias por cada local
		 * 3. Por cada local, recorrer su TreeMap de incidencias (fecha -> descripción)
		 * 4. Filtrar incidencias que coincidan con la fecha especificada
		 */
		
		// 5. Crear lista para almacenar las descripciones de incidencias del día
		ArrayList<String> incidencias = new ArrayList<>();
		
		// 6. Recorrer cada local en el mapa de incidencias
		for (Map.Entry<Integer, TreeMap<FechaHora, String>> entrada : incidenciasLocales.entrySet()) {
			// 7. Recorrer cada incidencia de este local
			for (Map.Entry<FechaHora, String> entrada2 : entrada.getValue().entrySet()) {
				// 8. Verificar si la fecha de la incidencia coincide con la fecha buscada
				if(fecha.equals(entrada2.getKey())) {
					// 9. Añadir la descripción de la incidencia a la lista
					incidencias.add(entrada2.getValue());
				}
			}
			
			
		}
		// 10. Devolver la lista de descripciones de incidencias de esa fecha
		return incidencias;
	}

	// TODO d):
	// Devuelve un conjunto con los grupos que tienen o han tenido alquilado un
	// local con alguna incidencia.
	public HashSet<Grupo> getGruposConAlquileresEnLocalesIncidencia() {
		
		/*
		 * 1. Crear HashSet para almacenar grupos con locales con incidencias
		 * 2. Recorrer la lista de alquileres para verificar cada local
		 * 3. Si el local de un alquiler tiene incidencias, añadir su grupo al conjunto
		 * 4. HashSet evita duplicados automáticamente
		 */
		
		// 5. Crear HashSet para almacenar grupos que cumplen la condición
		HashSet<Grupo> listaGrupos = new 	HashSet<>();
		
		// 6. Recorrer todos los alquileres registrados
		for (Alquiler alquiler : alquileres) {
			// 7. Verificar si el local de este alquiler tiene incidencias registradas
			if(incidenciasLocales.containsKey(alquiler.getCodLocal())) {
				// 8. Añadir el grupo de este alquiler al conjunto
				listaGrupos.add(alquiler.getGrupo());
			}
			
		}

		// 9. Devolver el conjunto de grupos con locales con incidencias
		return listaGrupos;
	}

	// TODO e):
	// Devuelve true si hay alg�n integrante de alg�n grupo que se llame como el
	// nombre que se recibe por par�metro
	public boolean hayIntegranteConNombre(String nombre) {
		
		// 1. Recorrer cada entrada del mapa (grupo -> conjunto de integrantes)
		for (Map.Entry<Grupo, LinkedHashSet<Integrante>> entrada : integrantes.entrySet()) {
			// 2. Recorrer todos los integrantes de este grupo
			for (Integrante integrante : entrada.getValue()) {
				// 3. Verificar si el nombre del integrante coincide con el buscado
				if(integrante.getNombre().equals(nombre)) {
					// 4. Integrante encontrado, devolver true inmediatamente
					return true;
				}
			}
		}

		// 5. No se encontró ningún integrante con ese nombre
		return false;
	}

	// TODO f)
	// Tipo de M�sica m�s popular entre los grupos registrados.
	public TipoMusica getTipoMusicaMasGrupos() {
		
		/*
		 * 1. Crear mapa para contar frecuencia de cada tipo de música
		 * 2. Recorrer los grupos para contar cuántos grupos hay de cada tipo
		 * 3. Encontrar el tipo de música con mayor frecuencia
		 * 4. Devolver el tipo más popular o null si no hay grupos
		 */
		
		// 5. Crear mapa para contar repeticiones de cada tipo de música
		Map<TipoMusica, Integer> mapaRepeticiones = new HashMap<>();

		// 6. Recorrer todos los grupos (claves del mapa de integrantes)
		for (Grupo grupo : integrantes.keySet()) {
			// 7. Verificar si ya contamos este tipo de música
			if(!mapaRepeticiones.containsKey(grupo.getTipoMusica())) {
				// 8. Primera vez que vemos este tipo, inicializar contador en 1
				mapaRepeticiones.put(grupo.getTipoMusica(), 1);
			}else {
				// 9. Incrementar el contador existente para este tipo de música
				mapaRepeticiones.put(grupo.getTipoMusica(),mapaRepeticiones.get(grupo.getTipoMusica())+1 );

			}
		}
		
		
		// 10. Variables para tracking del tipo más repetido
		TipoMusica tipoMasRepetido = null;
		int maxRepeticiones = 0;
		
		// 11. Recorrer el mapa de frecuencias para encontrar el máximo
		for (Map.Entry<TipoMusica, Integer> entrada : mapaRepeticiones.entrySet()) {
			// 12. Si este tipo tiene más repeticiones que el máximo actual
			if(entrada.getValue()>maxRepeticiones) {
				// 13. Actualizar máximo y guardar este tipo como el más repetido
				maxRepeticiones=entrada.getValue();
				tipoMasRepetido=entrada.getKey();
			}
		}

		// 14. Devolver el tipo de música más popular (o null si no hay grupos)
		return tipoMasRepetido;
	}

}
