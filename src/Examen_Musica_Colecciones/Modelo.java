package Examen_Musica_Colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
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

		return false;
	}

	// TODO b): Elimina al integrante con ese dni del grupo indicado.
	// Devuelve true si ha podido eliminarlo, y false si no ha podido porque no
	// estaba en dicho grupo.
	public boolean eliminaIntegrante(Grupo grupo, String dniIntegrante) {

		return false;
	}

	// TODO c):
	// Devuelve una lista de incidencias que han sucedido en un d�a concreto
	public List<String> getIncidencias(Fecha fecha) {

		return null;
	}

	// TODO d):
	// Devuelve un conjunto con los grupos que tienen o han tenido alquilado un
	// local con alguna incidencia.
	public HashSet<Grupo> getGruposConAlquileresEnLocalesIncidencia() {

		return null;
	}

	// TODO e):
	// Devuelve true si hay alg�n integrante de alg�n grupo que se llame como el
	// nombre que se recibe por par�metro
	public boolean hayIntegranteConNombre(String nombre) {

		return false;
	}

	// TODO f)
	// Tipo de M�sica m�s popular entre los grupos registrados.
	public TipoMusica getTipoMusicaMasGrupos() {

		return null;
	}

}
