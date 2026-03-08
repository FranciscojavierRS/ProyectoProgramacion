package Examen_Musica_Colecciones;

import java.util.HashSet;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// Crear un objeto Modelo
		Modelo modelo = new Modelo();

		Grupo grupo1 = new Grupo("The Beatles", TipoMusica.ROCK);
		Grupo grupo2 = new Grupo("Queen", TipoMusica.ROCK);
		Grupo grupo3 = new Grupo("Coldplay", TipoMusica.POP);

		// Crear algunos integrantes y agregarlos a los grupos
		modelo.addIntegrante(grupo1, new Integrante("John Lennon", "12345678A"));
		modelo.addIntegrante(grupo1, new Integrante("Paul McCartney", "23456789B"));
		modelo.addIntegrante(grupo2, new Integrante("Freddie Mercury", "34567890C"));
		modelo.addIntegrante(grupo3, new Integrante("Chris Martin", "45678901D"));

		// Crear algunos alquileres
		modelo.addAlquiler(new Alquiler(1, new Fecha(2024, 4, 21), 3, grupo1)); // The Beatles alquila local 1
		modelo.addAlquiler(new Alquiler(2, new Fecha(2024, 4, 20), 1, grupo2)); // Queen alquila local 2
		modelo.addAlquiler(new Alquiler(3, new Fecha(2023, 2, 10), 6, grupo3)); // Coldplay alquila local 3

		System.out.println("Integrantes: " + modelo.getIntegrantes());
		System.out.println("Alquileres: " + modelo.getAlquileres());
		System.out.println("Incidencias: " + modelo.getIncidenciasLocales());

		// a)
		System.out.println("a)");
		// Agregar incidencias
		modelo.addIncidencia(1, new FechaHora(21, 4, 2024, 10, 0, 0), "Baldosa rota");
		modelo.addIncidencia(2, new FechaHora(20, 4, 2024, 15, 30, 0), "Puerta desencajada");
		modelo.addIncidencia(1, new FechaHora(21, 4, 2024, 15, 0, 0), "Falta tornillo en la mesa");
		modelo.addIncidencia(2, new FechaHora(22, 4, 2024, 12, 0, 0), "Hay que poner 3en1 en las sillas");

		System.out.println("Incidencias: " + modelo.getIncidenciasLocales());

		// e)
		System.out.println("e)");
		// Verificar si hay integrante con un nombre espec�fico
		System.out.println(
				"(true) �Hay integrante con nombre 'John Lennon'? " + modelo.hayIntegranteConNombre("John Lennon"));

		// b)
		System.out.println("b)");
		// Eliminar un integrante de un grupo
		boolean eliminado = modelo.eliminaIntegrante(grupo1, "12345678A");
		System.out.println("�Se ha eliminado el integrante de The Beatles? " + eliminado);

		// e)
		System.out.println("e)");
		// Verificar si hay integrante con un nombre espec�fico
		System.out.println(
				"(false) �Hay integrante con nombre 'John Lennon'? " + modelo.hayIntegranteConNombre("John Lennon"));

		// c)
		System.out.println("c)");
		// Obtener incidencias para una fecha espec�fica
		List<String> incidencias = modelo.getIncidencias(new Fecha(21, 4, 2024));
		System.out.println("Incidencias para el 21/04/2024:");
		for (String incidencia : incidencias) {
			System.out.println("\t" + incidencia);
		}

		// d)
		System.out.println("d)");
		// Obtener grupos con alquileres en locales con incidencias
		HashSet<Grupo> gruposConIncidencias = modelo.getGruposConAlquileresEnLocalesIncidencia();

		// Imprimir los grupos con alquileres en locales con incidencias
		System.out.println("Grupos con alquileres en locales con incidencias:");
		for (Grupo grupo : gruposConIncidencias) {
			System.out.println("\t" + grupo.getNombre());
		}

		// f)
		System.out.println("f)");
		// Obtener el tipo de m�sica m�s popular entre los grupos
		TipoMusica tipoMasPopular = modelo.getTipoMusicaMasGrupos();
		System.out.println("Tipo de m�sica m�s popular entre los grupos: " + tipoMasPopular);

	}

}
