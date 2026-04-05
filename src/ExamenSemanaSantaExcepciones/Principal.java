package ExamenSemanaSantaExcepciones;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;


public class Principal {

	public static void main(String[] args) {
		// Crear modelo
		Modelo modelo = new Modelo();

		// Crear provincias
		Provincia sevilla = new Provincia("Sevilla");
		Provincia cadiz = new Provincia("Cádiz");
		Provincia malaga = new Provincia("Málaga");
		modelo.getProvincias().add(sevilla);
		modelo.getProvincias().add(cadiz);
		modelo.getProvincias().add(malaga);

		// Crear hermandades
		Hermandad esperanzaMacarena = new Hermandad("Esperanza Macarena", 1500);
		Hermandad granPoder = new Hermandad("Gran Poder", 2000);
		Hermandad sentencia = new Hermandad("Sentencia", 1000);
		Hermandad laPasion = new Hermandad("La Pasión", 1800);
		Hermandad losGitanos = new Hermandad("Los Gitanos", 1200);
		Hermandad laEsperanza = new Hermandad("La Esperanza", 1600);

		// Agregar paradas a hermandades
		Parada parada1 = new Parada("Plaza del Duque", new Hora(19, 30));
		Parada parada2 = new Parada("Campana", new Hora(20, 15));
		Parada parada3 = new Parada("Sierpes", new Hora(21, 00));
		Parada parada4 = new Parada("Catedral", new Hora(22, 30));

		granPoder.getParadasVisitadas().put(parada1, true);
		granPoder.getParadasVisitadas().put(parada2, false);
		granPoder.getParadasVisitadas().put(parada3, false);
		granPoder.getParadasVisitadas().put(parada4, false);

		sentencia.getParadasVisitadas().put(new Parada("San Antonio", new Hora(18, 45)), true);
		sentencia.getParadasVisitadas().put(new Parada("Plaza España", new Hora(19, 15)), true);
		sentencia.getParadasVisitadas().put(new Parada("Catedral", new Hora(20, 15)), false);

		laPasion.getParadasVisitadas().put(new Parada("Alameda", new Hora(20, 10)), false);
		laPasion.getParadasVisitadas().put(new Parada("Gran Vía", new Hora(21, 45)), false);

		// Agregar hermandades a provincias
		sevilla.getHermandades().add(esperanzaMacarena);
		sevilla.getHermandades().add(granPoder);
		cadiz.getHermandades().add(sentencia);
		malaga.getHermandades().add(laPasion);
		malaga.getHermandades().add(losGitanos);
		cadiz.getHermandades().add(laEsperanza);

		// Crear días y asociar hermandades
		HashSet<Hermandad> miercolesHermandades = new HashSet<>();
		miercolesHermandades.add(esperanzaMacarena);
		miercolesHermandades.add(granPoder);
		modelo.getDiasSalidaHermandades().put(DiaSemanaSanta.MIERCOLES_SANTO, miercolesHermandades);

		HashSet<Hermandad> juevesHermandades = new HashSet<>();
		juevesHermandades.add(sentencia);
		juevesHermandades.add(laPasion);
		modelo.getDiasSalidaHermandades().put(DiaSemanaSanta.JUEVES_SANTO, juevesHermandades);

		HashSet<Hermandad> viernesHermandades = new HashSet<>();
		viernesHermandades.add(losGitanos);
		viernesHermandades.add(laEsperanza);
		modelo.getDiasSalidaHermandades().put(DiaSemanaSanta.VIERNES_SANTO, viernesHermandades);

		// a) Obtener la hermandad con más hermanos el Miércoles Santo
		Hermandad hermandadMasHermanos = modelo.hermandadMasHermanos(DiaSemanaSanta.MIERCOLES_SANTO);
		System.out.println(
				"a) Hermandad con más hermanos el Miércoles Santo: (Debe salir Gran Poder)" + hermandadMasHermanos);

		// b) Obtener mapa de hermandades y provincias
		HashMap<Hermandad, Provincia> hermandadesProvincias = modelo.hermandadesProvincias();
		System.out.println("b) Mapa de hermandades y provincias: " + hermandadesProvincias);

		// c) Obtener hermandades que paran en la parada "Catedral"
		HashSet<Hermandad> hermandadesEnParada = modelo.hermandadesEnParada(new Parada("Catedral", new Hora(00, 00)));
		System.out.println("c) Hermandades que paran en Catedral: " + hermandadesEnParada);

		// d) Verificar si una hermandad ha pasado por más de N paradas

		boolean haPasadoGP = granPoder.haPasadoPorMasDe(1);
		System.out.println("d) ¿Gran Poder ha pasado por más de 1 parada? (debe salir false): " + haPasadoGP);

		boolean haPasadoSentencia = sentencia.haPasadoPorMasDe(1);
		System.out.println("¿Gran Poder ha pasado por más de 1 parada? (debe salir true): " + haPasadoSentencia);

		// e) Leer hermandades desde un archivo y agregarlas a una provincia
		File archivoHermandadesRepetidas = new File("hermandades_repetidas.txt");
		boolean anyadidasF = cadiz.leerHermandadesYanyadirlas(archivoHermandadesRepetidas);
		System.out.println("e) ¿Se añadieron nuevas hermandades desde el archivo? (debe salir false): " + anyadidasF);

		File archivoHermandades = new File("hermandades_con_nuevas.txt");
		boolean anyadidas = cadiz.leerHermandadesYanyadirlas(archivoHermandades);
		System.out.println("¿Se añadieron nuevas hermandades desde el archivo? (debe salir true): " + anyadidas);

		// f) Guardar hermandades en un archivo
		File archivoSalida = new File("hermandades_guardadas.txt");
		sevilla.escribirHermandadesEnTXT(archivoSalida);
		System.out.println("f) Hermandades de Sevilla guardadas en archivo.");
	}

}
