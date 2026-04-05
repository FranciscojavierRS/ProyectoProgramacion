package ExamenSemanaSantaExcepciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Modelo {
	private ArrayList<Provincia> provincias = new ArrayList<>();
	private HashMap<DiaSemanaSanta, HashSet<Hermandad>> diasSalidaHermandades = new HashMap<>();

	public ArrayList<Provincia> getProvincias() {
		return provincias;
	}

	public HashMap<DiaSemanaSanta, HashSet<Hermandad>> getDiasSalidaHermandades() {
		return diasSalidaHermandades;
	}

	@Override
	public String toString() {
		return "Modelo [provincias=" + provincias + ", diasSalidaHermandades=" + diasSalidaHermandades + "]";
	}

	// a) 
	public Hermandad hermandadMasHermanos(DiaSemanaSanta dia) {
		
		
		Hermandad hermandadMasHermanos = null;
		int maximoNumHermanos = 0;
		
		for ( Hermandad hermandad : diasSalidaHermandades.get(dia) ) {
			if (hermandad.getNumHermanos()>maximoNumHermanos) {
				hermandadMasHermanos=hermandad;
				maximoNumHermanos=hermandad.getNumHermanos();
			}
		}
		
		
		return hermandadMasHermanos;
	}

	// b) 
	public HashMap<Hermandad, Provincia> hermandadesProvincias() {
		HashMap<Hermandad, Provincia> hermandadesProvincia = new HashMap<>();
		
		for (Provincia provincia: provincias) {
			for (Hermandad hermandad : provincia.getHermandades()) {
				hermandadesProvincia.put(hermandad, provincia);
			}
		}
		
		return hermandadesProvincia;
	}

	// c) 
	public HashSet<Hermandad> hermandadesEnParada(Parada parada) {
		
		HashSet<Hermandad> hermandadesParada = new HashSet<>();
		
		for (Map.Entry<DiaSemanaSanta, HashSet<Hermandad>> entry : diasSalidaHermandades.entrySet()) {
			for (Hermandad hermandad : entry.getValue() ) {
				if (hermandad.getParadasVisitadas().containsKey(parada)) {
					hermandadesParada.add(hermandad);
				}
			}
		}

		
		return hermandadesParada;
	}

}
