package Examen_Vuelos_Colecciones;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Modelo{
	
	private TreeMap<Localidad,HashSet<Vuelo>> conexiones;
	private TreeSet<LineaAerea> lineas;

	public Modelo()	{
		this.conexiones = new TreeMap<Localidad,HashSet<Vuelo>>();
		this.lineas = new TreeSet<LineaAerea>();
	}

	public void addLinea(LineaAerea linea)
	{
		this.lineas.add(linea);
	}
	
	
	

	public void addLocalidad(Localidad localidad){
		// a�ade al mapa de conexiones una nueva pareja con la localidad
		// pasada como par�metro y un nuevo conjunto de vuelos vac�o.
		
		this.conexiones.put(localidad, new HashSet<>());
		
		
		
	}

	public void addVueloALocalidad(Localidad localidad, Vuelo vuelo){
		// a�ade el vuelo pasado como par�metro al conjunto de vuelos asociado a
		// la localidad pasada como par�metro.
		
			this.conexiones.get(localidad).add(vuelo);
			
			
			
	}

	public boolean hayErrores()	{
		// devuelve un boolean indicando si hay errores en los datos, es decir,
		// si hay alg�n vuelo con la misma localidad de origen que de destino.
		
		// Miramos cada localidad del MAPA. Por cada Localidad recorremos el CONJUNTO de vuelos y si
		// ahí un vuelo que su localidad de destino es igual a la localidad devolvemos True
		
		for (Localidad localidad: this.conexiones.keySet()) {
			for (Vuelo vuelo : this.conexiones.get(localidad)) {
				if (vuelo.getDestino().equals(localidad)) {
					return true;
					
				}
			}
		}
		
		
		
		return false;
	}

	public int numVuelosALocsMillon(Localidad localidad){
		// devuelve un entero con el n�mero de vuelos que parten de la localidad
		// pasada como par�metro y llegan a localidades con m�s de 1.000.000 habs.
		
		int vuelosMas1Millon = 0;
		
		for (Vuelo vuelo: this.conexiones.get(localidad)) {
			if (vuelo.getDestino().getHabitantes()>=1000000) {
				vuelosMas1Millon++;
			}
		}
		
		
		return vuelosMas1Millon;
	}

	public TreeSet<LineaAerea> lineasHasta(Localidad localidad)	{
		// devuelve un TreeSet con todas las l�neas a�reas que tienen vuelos hacia
		// la localidad pasada como par�metro.
		
		TreeSet <LineaAerea> lineas = new TreeSet<>();
		
		for (Localidad localidad2: this.conexiones.keySet()) {
			for (Vuelo vuelo : this.conexiones.get(localidad2)) {
				if (vuelo.getDestino().equals(localidad)) {
					lineas.add(vuelo.getLinea());
				}
			}
		}
		
		return lineas;
	}

	public int totalAvionesDesde(Localidad localidad){
		// devuelve un entero con la suma de todos los aviones que tienen las l�neas
		// que hacen vuelos desde la localidad pasada como par�metro.
		
		
		
		int contadorAvionesLineas = 0; 
		TreeSet <LineaAerea> lineas = new TreeSet<>();
		
		for (Vuelo vuelo : this.conexiones.get(localidad)) {
			if (!lineas.contains(vuelo.getLinea())) {
				lineas.add(vuelo.getLinea());
				contadorAvionesLineas+= vuelo.getLinea().getNumAviones();
			}
		}
		

		
		
		return contadorAvionesLineas;
	}

	public boolean hayVuelosReciprocos(){
		// devuelve un boolean indicando si existen dos ciudades entre las que hay 
		// vuelos en los dos sentidos.
		
		for (Localidad localidad: this.conexiones.keySet()) {
			for (Vuelo vuelo : this.conexiones.get(localidad)) {
				for (Vuelo vuelo2 : this.conexiones.get(vuelo.getDestino())) {
					if (localidad.equals(vuelo2.getDestino())) {
						return true;
					}
				}
				
			}
		}
		
		return false;
	}

	@Override
	public String toString(){
		String res="";
		for(Localidad l:this.conexiones.keySet())
		{
			res+="\nDesde: "+l.getNombre()+" hasta:\n";
			for(Vuelo v:this.conexiones.get(l))
				res+=v.getDestino().getNombre()+" con "+v.getLinea()+", ";
		}

		return res;
	}

}
