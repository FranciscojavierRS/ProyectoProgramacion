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
		// 1. Añadir el equipo al TreeSet
		// 2. TreeSet automáticamente ordena por Comparable de Equipo
		// 3. TreeSet.add() devuelve true si se añadió, false si ya existía (evita duplicados)
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

		// 1. Verificar si el equipo ya existe en el mapa
		if (!jugadoresEquipo.containsKey(equipo)) {
			// 2. Si no existe, crear nuevo HashSet para sus jugadores
			jugadoresEquipo.put(equipo, new HashSet<Jugador>());
		}
		// 3. Añadir el jugador al conjunto del equipo
		// 4. HashSet.add() evita duplicados automáticamente
		return jugadoresEquipo.get(equipo).add(jugador);

	}

	// Añade la partida a la lista partidas.

	public void addPartida(Partida partida) {

		// 1. Añadir la partida al ArrayList de partidas
		// 2. ArrayList.add() añade al final y siempre devuelve true
		// 3. ArrayList permite duplicados y mantiene orden de inserción
		partidas.add(partida);
	}

	/*
	 * Devuelve el número de jugadores que tiene ese equipo.
	 * 
	 * Si no existe → devuelve 0.
	 */
	public int numJugadoresEquipo(Equipo equipo) {

		// 1. Verificar si el equipo existe en el mapa
		if (!jugadoresEquipo.containsKey(equipo)) {
			// 2. Si no existe, devolver 0
			return 0;
		}

		// 3. Devolver el tamaño del conjunto de jugadores de ese equipo
		return jugadoresEquipo.get(equipo).size();

	}

	/*
	 * Devuelve un conjunto ordenado con todos los equipos que han ganado al menos
	 * una partida.
	 */
	public TreeSet<Equipo> equiposGanadores() {

		// 1. Crear TreeSet para almacenar equipos ganadores (automáticamente ordenado y sin duplicados)
		TreeSet<Equipo> equiposGanadores = new TreeSet<>();

		// 2. Recorrer todas las partidas registradas
		for (Partida partida : partidas) {
			// 3. Añadir el equipo ganador de cada partida al conjunto
			// 4. TreeSet automáticamente evita duplicados
			equiposGanadores.add(partida.getGanador());
		}

		// 5. Devolver el conjunto de equipos únicos que han ganado al menos una partida
		return equiposGanadores;
	}

	// Devuelve el conjunto de juegos distintos en los que se han jugado partidas.
	public HashSet<String> juegosJugados() {

		// 1. Crear HashSet para almacenar nombres de juegos (automáticamente sin duplicados)
		HashSet<String> juegos = new HashSet<>();

		// 2. Recorrer todas las partidas registradas
		for (Partida partida : partidas) {
			// 3. Añadir el nombre del juego de esta partida al conjunto
			// 4. HashSet automáticamente evita duplicados
			juegos.add(partida.getJuego());
		}

		// 5. Devolver el conjunto de juegos únicos en los que se ha jugado
		return juegos;

	}

	// Devuelve el equipo que tiene más jugadores registrados.
	public Equipo equipoConMasJugadores() {

		// 1. Variable para almacenar el equipo con más jugadores
		Equipo equipoConMasJugadores = null;

		// 2. Contador para el número máximo de jugadores encontrado
		int maxNumJugadores = 0;

		// 3. Recorrer cada entrada del mapa (equipo -> conjunto de jugadores)
		for (Map.Entry<Equipo, HashSet<Jugador>> entry : jugadoresEquipo.entrySet()) {

			// 4. Obtener el número de jugadores de este equipo usando el método auxiliar
			int tamañoEquipo = numJugadoresEquipo(entry.getKey());

			// 5. Verificar si este equipo tiene más jugadores que el máximo actual
			if (tamañoEquipo > maxNumJugadores) {
				// 6. Actualizar el máximo y guardar este equipo como el más grande
				maxNumJugadores = tamañoEquipo;
				equipoConMasJugadores = entry.getKey();
			}

		}

		// 7. Devolver el equipo con más jugadores (o null si no hay equipos)
		return equipoConMasJugadores;
	}

	/*
	 * Devuelve true si existen dos partidas donde:
	 * 
	 * Equipo A vs Equipo B y Equipo B vs Equipo A
	 */
	public boolean hayEnfrentamientosRepetidos() {
		
		// 1. Recorrer todas las partidas con doble bucle para comparar pares
		for (int i=0; i<partidas.size()-1; i++) {
			// 2. Obtener la primera partida del par
			Partida partida1 = partidas.get(i);
			// 3. Comparar con todas las partidas siguientes
			for (int j=i+1; j<partidas.size(); j++) {
				// 4. Obtener la segunda partida del par
				Partida partida2 = partidas.get(j);
				
				// 5. Verificar si hay enfrentamiento recíproco:
				//    - Equipo1 de partida1 == Equipo2 de partida2
				//    - Equipo2 de partida1 == Equipo1 de partida2
				if (partida1.getEquipo1().equals(partida2.getEquipo2()) && partida2.getEquipo1().equals(partida1.getEquipo2()) ) {
					
					// 6. Se encontraron enfrentamientos recíprocos
					return true;
				}

			}
		}
		
		// 7. No se encontraron enfrentamientos recíprocos
		return false;

	}

}
