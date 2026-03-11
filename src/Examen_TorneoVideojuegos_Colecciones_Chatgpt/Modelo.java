package Examen_TorneoVideojuegos_Colecciones_Chatgpt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Modelo {

	private TreeMap<Equipo, HashSet<Jugador>> jugadoresEquipo;
	private ArrayList<Partida> partidas;
	private TreeSet<Equipo> equipos;

	public Modelo() {
		jugadoresEquipo = new TreeMap<>();
		partidas = new ArrayList<>();
		equipos = new TreeSet<>();
	}

	/*
	 * Añade el equipo al conjunto equipos.
	 * 
	 * Si ya existe un equipo con ese nombre → no lo añade y devuelve false.
	 */
	public boolean addEquipo(Equipo equipo) {
		return equipos.add(equipo);

	}

	/*
	 * Añade el jugador al conjunto de jugadores de ese equipo.
	 * 
	 * Si el equipo no existe en el mapa, se crea.
	 * 
	 * No se permiten jugadores duplicados.
	 */
	public boolean addJugadorAEquipo(Equipo equipo, Jugador jugador) {

		if (!jugadoresEquipo.containsKey(equipo)) {
			jugadoresEquipo.put(equipo, new HashSet<Jugador>());
		}
		return jugadoresEquipo.get(equipo).add(jugador);

	}

	// Añade la partida a la lista partidas.

	public void addPartida(Partida partida) {

		partidas.add(partida);
	}

	/*
	 * Devuelve el número de jugadores que tiene ese equipo.
	 * 
	 * Si no existe → devuelve 0.
	 */
	public int numJugadoresEquipo(Equipo equipo) {

		if (!jugadoresEquipo.containsKey(equipo)) {
			return 0;
		}

		return jugadoresEquipo.get(equipo).size();

	}

	/*
	 * Devuelve un conjunto ordenado con todos los equipos que han ganado al menos
	 * una partida.
	 */
	public TreeSet<Equipo> equiposGanadores() {

		TreeSet<Equipo> equiposGanadores = new TreeSet<>();

		for (Partida partida : partidas) {
			equiposGanadores.add(partida.getGanador());
		}

		return equiposGanadores;
	}

	// Devuelve el conjunto de juegos distintos en los que se han jugado partidas.
	public HashSet<String> juegosJugados() {

		HashSet<String> juegos = new HashSet<>();

		for (Partida partida : partidas) {
			juegos.add(partida.getJuego());
		}

		return juegos;

	}

	// Devuelve el equipo que tiene más jugadores registrados.
	public Equipo equipoConMasJugadores() {

		Equipo equipoConMasJugadores = null;

		int maxNumJugadores = 0;

		for (Map.Entry<Equipo, HashSet<Jugador>> entry : jugadoresEquipo.entrySet()) {

			int tamañoEquipo = numJugadoresEquipo(entry.getKey());

			if (tamañoEquipo > maxNumJugadores) {
				maxNumJugadores = tamañoEquipo;
				equipoConMasJugadores = entry.getKey();
			}

		}

		return equipoConMasJugadores;
	}

	/*
	 * Devuelve true si existen dos partidas donde:
	 * 
	 * Equipo A vs Equipo B y Equipo B vs Equipo A
	 */
	public boolean hayEnfrentamientosRepetidos() {
		
		for (int i=0; i<partidas.size()-1; i++) {
			Partida partida1 = partidas.get(i);
			for (int j=i+1; j<partidas.size(); j++) {
				Partida partida2 = partidas.get(j);
				
				if (partida1.getEquipo1().equals(partida2.getEquipo2()) && partida2.getEquipo1().equals(partida1.getEquipo2()) ) {
					
					return true;
				}

			}
		}
		
		return false;

	}

}
