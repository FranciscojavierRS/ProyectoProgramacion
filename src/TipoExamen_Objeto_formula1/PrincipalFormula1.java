package TipoExamen_Objeto_formula1;

import java.util.Arrays;

public class PrincipalFormula1 {

	public static void main(String[] args) {
		// Crear objetos de tipo Piloto
		Piloto pilotoHamilton = new Piloto("Lewis Hamilton", 37, "Brit�nico", 100);
		Piloto pilotoRosberg = new Piloto("Nico Rosberg", 38, "Alemana", 85);
		Piloto pilotoVettel = new Piloto("Sebastian Vettel", 36, "Alemana", 30);
		Piloto pilotoVerstappen = new Piloto("Max Verstappen", 25, "Neerland�s", 95);
		Piloto pilotoWebber = new Piloto("Mark Webber", 47, "Australiana", 95);
		Piloto pilotoBottas = new Piloto("Valtteri Bottas", 33, "Finland�s", 35);

		// Crear objetos de tipo Circuito
		Circuito circuitoMonza = new Circuito("Monza", "Italia", 5.793f, 11);
		Circuito circuitoSilverstone = new Circuito("Silverstone", "Reino Unido", 5.891f, 18);
		Circuito circuitoBarcelona = new Circuito("Barcelona", "Espa�a", 4.655f, 16);
		Circuito circuitoSpa = new Circuito("Spa-Francorchamps", "B�lgica", 7.004f, 19);
		
		// Crear objetos de tipo Carrera
		Carrera carrera1Monza = new Carrera(circuitoMonza, new Fecha(23, 2, 2024));
		
		Carrera carrera1Silverstone = new Carrera(circuitoSilverstone, new Fecha(15, 1, 2022));
		Carrera carrera2Silverstone = new Carrera(circuitoSilverstone, new Fecha(20, 8, 2024));

		Carrera carrera1CircuitoBarcelona = new Carrera(circuitoBarcelona, new Fecha(5, 6, 2024));
		Carrera carrera2CircuitoBarcelona = new Carrera(circuitoBarcelona, new Fecha(15, 9, 2024));

		Carrera carrera1CircuitoSpa = new Carrera(circuitoSpa, new Fecha(10, 8, 2023));
		Carrera carrera2CircuitoSpa = new Carrera(circuitoSpa, new Fecha(20, 11, 2023));
		
		// Crear objetos de tipo Resultado
		Resultado resultado1 = new Resultado(1, "1:30:25", 210.5f);
		Resultado resultado2 = new Resultado(2, "1:32:10", 208.3f);
		Resultado resultado3 = new Resultado(3, "1:22:10", 199.4f);
		Resultado resultado22 = new Resultado(2, "1:40:25", 230.2f);
		Resultado resultado12 = new Resultado(1, "1:22:10", 200.1f);
		Resultado resultado32 = new Resultado(3, "1:20:03", 198.1f);

		// Crear objetos de tipo Equipo
		Equipo equipo1 = new Equipo("Mercedes", "Alemania", "Toto Wolff");
		Equipo equipo2 = new Equipo("Red Bull Racing", "Austria", "Christian Horner");

		// Agregar pilotos a equipos
		pilotoHamilton.setEquipo(equipo1);
		pilotoRosberg.setEquipo(equipo1);
		pilotoBottas.setEquipo(equipo1);
		
		pilotoVerstappen.setEquipo(equipo2);
		pilotoWebber.setEquipo(equipo2);
		pilotoVettel.setEquipo(equipo2);

		// Agregar pilotos y resultados a carreras
		carrera1Monza.addPilotoResultado(new PilotoResultado(pilotoHamilton, resultado1));
		carrera1Monza.addPilotoResultado(new PilotoResultado(pilotoVerstappen, resultado2));
		carrera1Monza.addPilotoResultado(new PilotoResultado(pilotoVettel, resultado3));		
		
		carrera2Silverstone.addPilotoResultado(new PilotoResultado(pilotoWebber, resultado22));
		carrera2Silverstone.addPilotoResultado(new PilotoResultado(pilotoRosberg, resultado12));
		carrera2Silverstone.addPilotoResultado(new PilotoResultado(pilotoVettel, resultado32));
		
		carrera1Silverstone.addPilotoResultado(new PilotoResultado(pilotoHamilton, resultado2));
		carrera1Silverstone.addPilotoResultado(new PilotoResultado(pilotoVettel, resultado12));
		
		carrera1CircuitoBarcelona.addPilotoResultado(new PilotoResultado(pilotoVerstappen, resultado12));
		carrera1CircuitoBarcelona.addPilotoResultado(new PilotoResultado(pilotoRosberg, resultado2));
		
		carrera2CircuitoBarcelona.addPilotoResultado(new PilotoResultado(pilotoRosberg, resultado22));
		carrera2CircuitoBarcelona.addPilotoResultado(new PilotoResultado(pilotoHamilton, resultado1));
		
		carrera1CircuitoSpa.addPilotoResultado(new PilotoResultado(pilotoVettel, resultado1));
		carrera1CircuitoSpa.addPilotoResultado(new PilotoResultado(pilotoHamilton, resultado2));
		
		carrera2CircuitoSpa.addPilotoResultado(new PilotoResultado(pilotoVerstappen, resultado1));
		carrera2CircuitoSpa.addPilotoResultado(new PilotoResultado(pilotoVettel, resultado2));
		
		ModeloDeDatos modelo= new ModeloDeDatos();
		modelo.anadeCarrera(carrera1Monza);
		modelo.anadeCarrera(carrera1Silverstone);
		modelo.anadeCarrera(carrera2Silverstone);
		modelo.anadeCarrera(carrera1CircuitoBarcelona);
		modelo.anadeCarrera(carrera1CircuitoSpa);
		modelo.anadeCarrera(carrera2CircuitoBarcelona);
		modelo.anadeCarrera(carrera2CircuitoSpa);
		
		modelo.anadeEquipo(equipo1);
		modelo.anadeEquipo(equipo2);
		
		modelo.anadePiloto(pilotoHamilton);
		modelo.anadePiloto(pilotoVerstappen);
		modelo.anadePiloto(pilotoRosberg);
		modelo.anadePiloto(pilotoWebber);
		modelo.anadePiloto(pilotoBottas);
		modelo.anadePiloto(pilotoVettel);
		
		System.out.println("Datos carreras modelo: "+Arrays.toString(modelo.tCarreras));
		System.out.println("a)-----------------------------------------------");
		//a) Devuelve los equipos participantes en la carrera (sin repetidos). 
		//Dos equipos son iguales si su nombre es el mismo.
		System.out.println(Arrays.toString(carrera1Monza.equiposParticipantes()));
		
		System.out.println("b)-----------------------------------------------");
		//b) Obtiene el piloto que ha quedado en la posici�n indicada
		System.out.println(carrera1Monza.getPilotoPosicion(2));
		
		System.out.println("c)-----------------------------------------------");
		//c) La ordenaci�n natural de los pilotos es por puntos descendentemente (los de m�s puntos van antes). A igualdad de puntos, se ordenan alfab�ticamente por nombre.
		// Ordena el array de pilotos del modelo por este criterio.
		System.out.println("Pilotos ordenados: "+Arrays.toString(modelo.getPilotosOrdenados()));
		
		System.out.println("d)-----------------------------------------------");
		//d) A�o en el que ha habido m�s carreras
		System.out.println("A�o en el que ha habido m�s carreras: "+modelo.anioMasCarreras());
		
		System.out.println("e)-----------------------------------------------");
		//e) Devuelve true si existe alg�n piloto que haya ganado al menos dos veces en el mismo circuito.
		//Dos circuitos son iguales si tienen el mismo nombre. Dos pilotos son iguales si su nombre y nacionalidad son
		System.out.println("(false) Hay pilotos que han ganado m�s de una vez en el mismo circuito: "+modelo.hayPilotoGanador2MismoCircuito());
		
		Carrera carrera2Monza = new Carrera(circuitoMonza, new Fecha(6, 3, 2023));
		modelo.anadeCarrera(carrera2Monza);
		carrera2Monza.addPilotoResultado(new PilotoResultado(pilotoHamilton, resultado12));
		carrera2Monza.addPilotoResultado(new PilotoResultado(pilotoRosberg, resultado22));
		
		System.out.println("(true) Hay pilotos que han ganado m�s de una vez en el mismo circuito: "+modelo.hayPilotoGanador2MismoCircuito());
		
	}

}