package Examen_Febrero_Objetos;

import java.util.Arrays;
import java.util.Comparator;

import Examen_Biblioteca_Objetos.MaterialBibliografico;
import Hotel_Examen_Objetos.Reserva;

public class GestionJJOO {
	public static void main(String[] args) {

		// 1. Creación de Atletas
		Atleta a1 = new Atleta("Johannes Boe", 5);
		Atleta a2 = new Atleta("Quentin Fillon", 2);
		Atleta a3 = new Atleta("Marte Olsbu", 3);
		Atleta a4 = new Atleta("Therese Johaug", 3);
		Atleta a5 = new Atleta("Irene Schouten", 3);

		// 2. Creación de Países
		Pais noruega = new Pais("Noruega");
		Pais francia = new Pais("Francia");
		Pais paisesBajos = new Pais("Países Bajos");

		// 3. Asignación a delegaciones
		noruega.getAtletas().anyadeAtleta(a1); // Boe (Nor)
		noruega.getAtletas().anyadeAtleta(a3); // Marte (Nor)
		noruega.getAtletas().anyadeAtleta(a4); // Johaug (Nor)
		francia.getAtletas().anyadeAtleta(a2); // Fillon (Fra)
		paisesBajos.getAtletas().anyadeAtleta(a5); // Schouten (PB)

		Pais[] jjoo = { noruega, francia, paisesBajos };

		// --- PRUEBA APARTADO A: contieneAtleta ---
		System.out.println("a) ¿Noruega tiene a Boe?: " + noruega.getAtletas().contieneAtleta(a1));
		System.out.println("a) ¿Noruega tiene a Schouten?: " + noruega.getAtletas().contieneAtleta(a5));

		// --- PRUEBA APARTADO B: registrarRival ---
		hacerRivales(a1, a2); // Válido (Boe vs Fillon)
		hacerRivales(a1, a1); // Inválido (Mismo atleta)
		hacerRivales(a3, a2); // Válido (Marte vs Fillon)
		hacerRivales(a5, a2); // Válido (Schouten vs Fillon)

		System.out.println("\nb) Rivales registrados: ");
		System.out.println(a1);// Johannes Boe tiene como rival a [Quentin Fillon]
		System.out.println(a2);// Quentin Fillon tiene como rival a [Johannes Boe, Marte, Schouten]
		System.out.println(a3);// Marte tiene como rival a [Quentin Fillon]
		System.out.println(a4);// Therese Johaug no tiene rivales
		System.out.println(a5);// Schouten tiene como rival a Quentin Fillon

		// --- PRUEBA APARTADO C: hayErrores ---
		System.out.println("\nc) Errores antes de fallo: " + hayErrores(jjoo));
		// Forzamos error: Marte (Nor) registra como rival a Boe (Nor)
		a3.registrarRival(a1);
		System.out.println("c) Errores tras registro erróneo (mismo país): " + hayErrores(jjoo));

		// --- PRUEBA APARTADO D: getAtletasOrdenados ---
		// Noruega tiene a Boe (5), Marte (3) y Johaug (3).
		System.out.println("\nd) Atletas de Noruega ordenados:");
		Atleta[] noruegosOrd = getAtletasOrdenados(noruega);
		for (Atleta at : noruegosOrd) {
			System.out.println("- " + at.getNombre() + " (" + at.getMedallasOro() + " oros)");
		}

		// --- PRUEBA APARTADO E: paisMenosMedallas ---
		Pais menosLaureado = paisMenosMedallas(jjoo);
		System.out.println("\ne) País con menos medallas: " + menosLaureado.getNombre());

		// --- PRUEBA APARTADO F: rivalesEnComun ---
		// Registramos otro rival común para Boe (a1) y Marte (a3)
		Atleta a6 = new Atleta("Otro Rival Común", 1);
		hacerRivales(a1, a6);
		hacerRivales(a3, a6);
		System.out.println("\nf) Rivales en común entre Boe y Marte: ");
		ListaAtletas comunes = a1.rivalesEnComun(a3);
		for (int i = 0; i < comunes.getNumAtletas(); i++) {
			System.out.println(comunes.getAtleta(i).getNombre());
		}
	}

	/**
	 * Establece una relación de rivalidad bidireccional entre dos atletas.
	 */
	public static void hacerRivales(Atleta a, Atleta b) {
		a.registrarRival(b);
		b.registrarRival(a);
	}

	// Apartado c)
	public static boolean hayErrores(Pais[] paisesJJOO) {

		for (int i = 0; i < paisesJJOO.length; i++) {
			Pais paisActual = paisesJJOO[i];
			Atleta atletaActual = paisActual.getAtletas().getTabla()[i];

			/*
			 * 
			 * for (int j = 0; j < atletaActual.getRivales().getNumAtletas(); j++) { Atleta
			 * rivalAtleta = atletaActual.getRivales().getTabla()[j]; }
			 * 
			 * 
			 */

		}
		return false;
	}

	/*
	 * for (int i = 0; i < tReservas.length - 1; i++) { Reserva reserva =
	 * tReservas[i]; for (int j = i + 1; j < tReservas.length; j++) { if
	 * (reserva.getHabitacion().equals(tReservas[j].getHabitacion()) &&
	 * tReservas[j].getFechaInicio().compareTo(reserva.getFechaFin()) < 0 &&
	 * tReservas[j].getFechaFin().compareTo(reserva.getFechaInicio()) > 0) { return
	 * true; } } } return false; }
	 * 
	 */

	// Apartado d)
	public static Atleta[] getAtletasOrdenados(Pais pais) {

		/*
		 * { Reserva[] reservasHabitacion = new Reserva[0];
		 * 
		 * for (Reserva reserva : tReservas) { if
		 * (reserva.getHabitacion().equals(habitacion)) { reservasHabitacion =
		 * Arrays.copyOf(reservasHabitacion, reservasHabitacion.length + 1);
		 * reservasHabitacion[reservasHabitacion.length - 1] = reserva; } }
		 * 
		 * return reservasHabitacion; } pais.atletas
		 */

		Atleta[] atletaOrdenado = new Atleta[0];

		for (int i = 0; i < pais.getAtletas().getNumAtletas(); i++) {
			if (pais.getAtletas().equals(pais.getAtletas())) {
				atletaOrdenado = Arrays.copyOf(atletaOrdenado, atletaOrdenado.length + 1);
				atletaOrdenado[atletaOrdenado.length - 1] = atletaOrdenado[i];
				Arrays.sort(atletaOrdenado);
			}
		}

		return atletaOrdenado;
	}

// Arrays.sort(materialesOrdenados, new Comparator<MaterialBibliografico>()

	// Apartado e)
	public static Pais paisMenosMedallas(Pais[] paisesJJOO) {
		return null;
	}

}
