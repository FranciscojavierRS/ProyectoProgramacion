package ObjetosAngel;

import java.util.Arrays;
import java.util.Collections;

public class GestionF1 {

    // --- MÉTODOS A IMPLEMENTAR ---
    
	
	/*
	 * c) (2 Puntos) public static boolean conflictoDeIntereses(Escuderia[] parrilla) en GestionF1.
Este método devuelve true si detecta que algún piloto tiene como "rival directo" a un compañero de su misma escudería. Devuelve false si todos los rivales de todos los pilotos pertenecen a escuderías diferentes.
	 */
    // c) public static boolean conflictoDeIntereses(Escuderia[] parrilla)
	
	public static boolean conflictoDeIntereses(Escuderia[] parrilla) {
		
		
		for (Escuderia escuderia : parrilla) {
			
			for (Piloto piloto : escuderia.plantilla.tabla) {
				if (piloto != null) {
					
				
				for (Piloto pilotorival : piloto.rivales.tabla) {
					
					if (pilotorival != null && escuderia.plantilla.buscarPiloto(pilotorival)!= -1) {
							return true;
					}
				}
				}
			}
		}
		return false;
	}
	
	/*
	 * d) (1 Punto) public static Piloto[] obtenerTopPilotos(Escuderia e) en GestionF1.
			Devuelve un array con los pilotos de la escudería recibida, de tamaño exacto (sin huecos libres) y ordenados según la ordenación natural.
	 */
    // d) public static Piloto[] obtenerTopPilotos(Escuderia e)
	
	public static Piloto[] obtenerTopPilotos(Escuderia escuderia) {
		
		Piloto[] topPilotos = Arrays.copyOf(escuderia.plantilla.tabla, escuderia.plantilla.numPilotos);
		
		Arrays.sort(topPilotos);
		
		return topPilotos;
		
	}
    
    // e) public static Escuderia escuderiaColista(Escuderia[] parrilla)
	
	public static Escuderia escuderiaColista(Escuderia[] parrilla) {
	
		Escuderia escuderiaColista = null;
		int minimoPuntos = 9999999;
		
		for (Escuderia escuderia : parrilla) {
			
			int puntosEscuderia = 0;
			for (Piloto piloto : escuderia.plantilla.tabla) {
				
				if (piloto!= null) {
					puntosEscuderia+= piloto.puntos;
				}
				
				
			}
			if (puntosEscuderia<minimoPuntos) {
				minimoPuntos=puntosEscuderia;
				escuderiaColista=escuderia;
			}
		}
			return escuderiaColista;
	}

	 public static void main(String[] args) {
	        // 1. CREACIÓN DE PILOTOS
	        Piloto p1 = new Piloto("Max Verstappen", 454);
	        Piloto p2 = new Piloto("Sergio Perez", 285);
	        Piloto p3 = new Piloto("Lewis Hamilton", 240);
	        Piloto p4 = new Piloto("George Russell", 175);
	        Piloto p5 = new Piloto("Fernando Alonso", 206);

	        // 2. CREACIÓN DE ESCUDERÍAS
	        Escuderia redBull = new Escuderia("Red Bull");
	        Escuderia mercedes = new Escuderia("Mercedes");
	        Escuderia astonMartin = new Escuderia("Aston Martin");

	        // Llenamos las plantillas manualmente (simulando que ListaPilotos tiene un método add o acceso directo)
	        redBull.plantilla.tabla[0] = p1;
	        redBull.plantilla.tabla[1] = p2;
	        redBull.plantilla.numPilotos = 2;

	        mercedes.plantilla.tabla[0] = p3;
	        mercedes.plantilla.tabla[1] = p4;
	        mercedes.plantilla.numPilotos = 2;

	        astonMartin.plantilla.tabla[0] = p5;
	        astonMartin.plantilla.numPilotos = 1;

	        Escuderia[] parrilla = {redBull, mercedes, astonMartin};

	        System.out.println("--- PRUEBAS EXAMEN F1 ---");

	        // --- Prueba A: buscarPiloto ---
	        System.out.println("\na) Test buscarPiloto:");
	        int idx = redBull.plantilla.buscarPiloto(p1);
	        System.out.println("¿Verstappen en Red Bull? Índice: " + idx + (idx != -1 ? " (Correcto)" : " (Error)"));
	        System.out.println("¿Hamilton en Red Bull? Índice: " + redBull.plantilla.buscarPiloto(p3));

	        // --- Prueba B: marcarRival ---
	        System.out.println("\nb) Test marcarRival:");
	        p1.marcarRival(p3); // Verstappen marca a Hamilton
	        p1.marcarRival(p1); // No debería dejarse marcar a sí mismo
	        p3.marcarRival(p1); // Hamilton marca a Verstappen
	        p5.marcarRival(p3); // Alonso marca a Hamilton
	        System.out.println("Rivales de Verstappen: " + p1.rivales.numPilotos + " (Esperado: 1)");

	        // --- Prueba F: enemigosCruzados ---
	        System.out.println("\nf) Test enemigosCruzados (Comunes entre Verstappen y Alonso):");
	        // Ambos tienen a Hamilton de rival
	        ListaPilotos comunes = p1.enemigosCruzados(p5);
	        if (comunes != null && comunes.numPilotos > 0) {
	            System.out.println("Rival común detectado: " + comunes.tabla[0].nombre);
	        }

	        // --- Prueba D: obtenerTopPilotos ---
	        System.out.println("\nd) Test obtenerTopPilotos (Mercedes):");
	        Piloto[] ordenados = GestionF1.obtenerTopPilotos(mercedes);
	        if (ordenados != null) {
	            for (Piloto p : ordenados) {
	                System.out.println("- " + p.nombre + " (" + p.puntos + " pts)");
	            }
	        }

	        // --- Prueba E: escuderiaColista ---
	        System.out.println("\ne) Test escuderiaColista:");
	        Escuderia peor = GestionF1.escuderiaColista(parrilla);
	        System.out.println("La escudería con menos puntos es: " + (peor != null ? peor.nombre : "null"));

	        // --- Prueba C: conflictoDeIntereses ---
	        System.out.println("\nc) Test conflictoDeIntereses:");
	        System.out.println("¿Hay conflicto inicial? " + GestionF1.conflictoDeIntereses(parrilla));
	        
	        System.out.println("Registrando a Sergio Perez como rival de su compañero Verstappen...");
	        p1.marcarRival(p2); // Conflicto: Verstappen y Perez son de Red Bull
	        System.out.println("¿Hay conflicto ahora? " + GestionF1.conflictoDeIntereses(parrilla) + " (Esperado: true)");
	    }
}

