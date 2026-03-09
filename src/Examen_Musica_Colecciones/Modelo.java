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
		if (!this.integrantes.containsKey(grupo)) {
			this.integrantes.put(grupo, new LinkedHashSet<Integrante>());
		}
		return this.integrantes.get(grupo).add(integrante);
	}

	public boolean addIntegrante(String nombreGrupo, TipoMusica tipoMusica, String nombreIntegrante,
			String dniIntegrante) {
		return addIntegrante(new Grupo(nombreGrupo, tipoMusica), new Integrante(nombreIntegrante, dniIntegrante));
	}

	public void addAlquiler(Alquiler alquiler) {
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
		
		if (!incidenciasLocales.containsKey(local)) {
			incidenciasLocales.put(local, new TreeMap<FechaHora, String>());
			
		}
		
		if (!incidenciasLocales.get(local).containsKey(fecha)) {
			incidenciasLocales.get(local).put(fecha, incidencia);
			
			return true;
			
		}

		return false;
	}

	// TODO b): Elimina al integrante con ese dni del grupo indicado.
	// Devuelve true si ha podido eliminarlo, y false si no ha podido porque no
	// estaba en dicho grupo.
	public boolean eliminaIntegrante(Grupo grupo, String dniIntegrante) {
		
		/*
		 * Comprobar si el grupo existe en integrantes
		 * obtener la lista de integrantes del grupo
		 * comprobar si en la lista hay un integrande con ese DNI, en caso de que este se elimina y devolvemos true.
		 */

		if(integrantes.containsKey(grupo)) {
			Iterator<Integrante> iteradorIntegrantes = integrantes.get(grupo).iterator();
			
			for ( ; iteradorIntegrantes.hasNext();  ) {
				Integrante integrante =(Integrante) iteradorIntegrantes.next();
				if (integrante.getDni().equals(dniIntegrante)) {
					iteradorIntegrantes.remove();
					return true;
				}
			}
			
		}
		
		
		return false;
	}

	// TODO c):
	// Devuelve una lista de incidencias que han sucedido en un d�a concreto
	public List<String> getIncidencias(Fecha fecha) {
		
		/*
		 * Creamos una lista nueva vacia
		 * Dentro del mapa de incidencias y recorremos cada local para tener su mapa de incidcencias
		 * Por cada mapa de incidencias lo recorremos para obtener las incidencias con esa fecha y añadirlas a la lista (que creamos antes)
		 * 
		 */
		
		ArrayList<String> incidencias = new ArrayList<>();
		
		for (Map.Entry<Integer, TreeMap<FechaHora, String>> entrada : incidenciasLocales.entrySet()) {
			for (Map.Entry<FechaHora, String> entrada2 : entrada.getValue().entrySet()) {
				if(fecha.equals(entrada2.getKey())) {
					incidencias.add(entrada2.getValue());
				}
			}
			
			
		}
		return incidencias;
	}

	// TODO d):
	// Devuelve un conjunto con los grupos que tienen o han tenido alquilado un
	// local con alguna incidencia.
	public HashSet<Grupo> getGruposConAlquileresEnLocalesIncidencia() {
		
		/*
		 * Creamos el HashSet donde vamos a almacenar los grupos
		 * Recorremos la lista de alquileres, por cada alguiler vemos si su local existe en el mapa de incidencias
		 * Si existe,obtenemos el GRUPO del alquiler y lo insertamos en el CONJUNTO
		 */
		
		HashSet<Grupo> listaGrupos = new 	HashSet<>();
		
		for (Alquiler alquiler : alquileres) {
			if(incidenciasLocales.containsKey(alquiler.getCodLocal())) {
				listaGrupos.add(alquiler.getGrupo());
			}
			
		}

		return listaGrupos;
	}

	// TODO e):
	// Devuelve true si hay alg�n integrante de alg�n grupo que se llame como el
	// nombre que se recibe por par�metro
	public boolean hayIntegranteConNombre(String nombre) {
		
		for (Map.Entry<Grupo, LinkedHashSet<Integrante>> entrada : integrantes.entrySet()) {
			for (Integrante integrante : entrada.getValue()) {
				if(integrante.getNombre().equals(nombre)) {
					return true;
				}
			}
		}


		return false;
	}

	// TODO f)
	// Tipo de M�sica m�s popular entre los grupos registrados.
	public TipoMusica getTipoMusicaMasGrupos() {
		
		/*
		 * Creamos un mapa de tipo de musica y veces que se repite 
		 * recorremos las keys del mapa de integrantes para obtener los grupos
		 * de cada grupo miramos cual es el tipo de musica, incrementamos el numero de repeticiones de ese tipo de musica
		 * Una vez tenemos el mapa completo... lo recorremos para ver cual a sido el tipo de musica que mas se repitio
		 */
		Map<TipoMusica, Integer> mapaRepeticiones = new HashMap<>();

		for (Grupo grupo : integrantes.keySet()) {
			if(!mapaRepeticiones.containsKey(grupo.getTipoMusica())) {
				mapaRepeticiones.put(grupo.getTipoMusica(), 1);
			}else {
				mapaRepeticiones.put(grupo.getTipoMusica(),mapaRepeticiones.get(grupo.getTipoMusica())+1 );

			}
		}
		
		
		TipoMusica tipoMasRepetido = null;
		int maxRepeticiones = 0;
		
		for (Map.Entry<TipoMusica, Integer> entrada : mapaRepeticiones.entrySet()) {
			if(entrada.getValue()>maxRepeticiones) {
				maxRepeticiones=entrada.getValue();
				tipoMasRepetido=entrada.getKey();
			}
		}

		return tipoMasRepetido;
	}

}
