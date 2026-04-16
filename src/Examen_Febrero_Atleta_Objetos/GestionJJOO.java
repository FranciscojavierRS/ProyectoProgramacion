package Examen_Febrero_Atleta_Objetos;

import java.util.Arrays;

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

	/*
	 * c) (2 Puntos) public static boolean hayErrores(Pais[] paisesJJOO) en
	 * GestionJJOO. Este método devuelve true si algún atleta de alguno de los
	 * paises del array recibido por parámetro contiene rivales de su mismo pais, y
	 * false en caso contrario (ya que un atleta no compite contra otro de su mismo
	 * país).
	 * 
	 */
	public static boolean hayErrores(Pais[] paisesJJOO) {

		for (Pais pais : paisesJJOO) {

			for (int i = 0; i < pais.getAtletas().getNumAtletas() - 1; i++) {

				for (int j = 1; j < pais.getAtletas().getNumAtletas(); j++) {

					if (pais.getAtletas().getTabla()[i].getRivales().contieneAtleta(pais.getAtletas().getTabla()[j])
							|| pais.getAtletas().getTabla()[j].getRivales()
									.contieneAtleta(pais.getAtletas().getTabla()[i])) {

						return true;

					}
				}
			}

		}

		return false;
	}

	// Apartado d)
	
	/*
	 * d) (1 Punto) public static Atleta[] getAtletasOrdenados(Pais pais) en
GestionJJOO.
Este método devuelve el array de atletas del país recibido por parámetro del tamaño justo y
ordenado por la ordenación natural de los atletas.

	 */
	public static Atleta[] getAtletasOrdenados(Pais pais) {

		Atleta[] atletas = Arrays.copyOf(pais.getAtletas().getTabla(), pais.getAtletas().getNumAtletas());

		Arrays.sort(atletas);

		return atletas;
	}

	// Apartado e)
	public static Pais paisMenosMedallas(Pais[] paisesJJOO) {

		Pais paisConMenosMedallas = paisesJJOO[0];
		int numeroMedallasmin = 999999999;

		for (Pais pais : paisesJJOO) {
			int numeroMedallas = 0;

			for (int i = 0; i < pais.getAtletas().getNumAtletas(); i++) {

				numeroMedallas += pais.getAtletas().getAtleta(i).getMedallasOro();
			}

			if (numeroMedallas < numeroMedallasmin) {
				numeroMedallasmin = numeroMedallas;
				paisConMenosMedallas = pais;
			}
		}

		return paisConMenosMedallas;
	}

}
