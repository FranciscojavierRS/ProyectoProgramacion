package Examen_Parejas_Colecciones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Modelo 
{
	public static final int CORRECTO = 0;
	public static final int YA_EXISTE = 1;

	private LinkedHashSet<Persona> solicitantes;
	private  HashMap<Persona, TreeMap<Persona,Persona>> gestoresParejas;

	public Modelo()
	{
		solicitantes=new LinkedHashSet<>();
		gestoresParejas=new HashMap<Persona, TreeMap<Persona,Persona>> ();
	}

	public int anyadeSolicitante(String nombre, Sexo sexoSolicitante, Sexo sexoSolicitado, boolean gestor,
			List<String> aficiones)
	{
		
		// 1. Crear objeto Persona con los parámetros proporcionados
		Persona persona = new Persona(nombre, sexoSolicitante, sexoSolicitado, gestor, aficiones);
		
		// 2. Verificar si la persona ya existe en el conjunto de solicitantes
		if(solicitantes.contains(persona)) {
			// 3. Si ya existe, devolver código de error YA_EXISTE
			return YA_EXISTE;
		}
		
		// 4. Añadir la persona al conjunto de solicitantes
		solicitantes.add(persona);
		// 5. Si es gestor, añadirlo al mapa de gestores con TreeMap vacío
		if (gestor) {
			// 6. Crear TreeMap para almacenar las parejas que gestione este gestor
			gestoresParejas.put(persona, new TreeMap<Persona,Persona>());
			
		}
		
		// 7. Devolver código de éxito CORRECTO
		return CORRECTO;
	}

	public Set<Persona> getListaGestores()
	{
		
		
		// 1. Devolver el conjunto de claves del mapa de gestores
		// 2. keySet() contiene todas las personas que tienen rol de gestor
		return gestoresParejas.keySet();
	}

	public Set<Persona> getListaSolicitantes()
	{
		
		
		// 1. Devolver el conjunto completo de solicitantes
		// 2. Incluye tanto solicitantes normales como gestores
		return this.solicitantes;
	}

	public String getListadoAfinidades(String nombreSolicitante)
	{
		
		// 1. Buscar la persona solicitante por su nombre
		Persona solicitante = getPersonaPorNombre(nombreSolicitante);
		
		// 2. String para construir el listado de posibles parejas
		String posiblesParejas = "";
		
		// 3. Recorrer todos los solicitantes para buscar compatibles
		for (Persona persona : solicitantes) {
			// 4. Verificar condiciones de compatibilidad:
			//    a) No es la misma persona
			//    b) El sexo de la persona coincide con el sexo buscado por el solicitante
			if(!persona.equals(solicitante) && persona.getSexoPropio().equals(solicitante.getSexoBuscado())) {
				// 5. Añadir información: nombre - número de aficiones comunes
				posiblesParejas+=persona.getNombre()+"-"+solicitante.aficionesComunesCon(persona)+"\n";
			}
		}
		
		// 6. Devolver el listado completo de posibles parejas
		return posiblesParejas;
	}

	private Persona getPersonaPorNombre(String nombreSolicitante) {
		// 1. Inicializar variable para almacenar la persona encontrada
		Persona solicitante= null;
		
		// 2. Recorrer todos los solicitantes buscando por nombre
		for (Persona persona : solicitantes) {
			// 3. Verificar si el nombre coincide con el buscado
			if (persona.getNombre().equals(nombreSolicitante)) {
				// 4. Asignar la persona encontrada
				solicitante = persona;
				
				// 5. Romper el bucle (optimización: ya encontramos lo que buscábamos)
				break;
			}
		}
		// 6. Devolver la persona encontrada o null si no se encontró
		return solicitante;
	}

	public int creaPareja(String nombreGestor, String nombreSolicitante, String nombrePareja)
	{
	// 1. Buscar las tres personas por sus nombres
	Persona gestor =getPersonaPorNombre(nombreGestor);
	Persona solicitante =getPersonaPorNombre(nombreSolicitante);
	Persona pareja =getPersonaPorNombre(nombrePareja);
	
	// 2. Verificar si la persona que actúa como gestor realmente es gestor
	if(!gestor.isGestor()) {
		// 3. Error: la persona no es gestor, devolver código de error
		return YA_EXISTE;
		
	}
	// 4. Obtener el TreeMap de parejas gestionadas por este gestor
	TreeMap<Persona,Persona>parejas =gestoresParejas.get(gestor);
	
	// 5. Verificar que ninguna de las dos personas ya esté en una pareja existente
	for (Map.Entry<Persona, Persona>entrada: parejas.entrySet()) {
		// 6. Comprobar si solicitante o pareja ya están en alguna pareja existente
		if(solicitante.equals(entrada.getKey()) || solicitante.equals(entrada.getValue()) || pareja.equals(entrada.getKey()) || pareja.equals(entrada.getValue())) {
			// 7. Error: alguna de las personas ya está emparejada
			return YA_EXISTE;
		}
		
	}
	// 8. Crear la nueva pareja en el TreeMap del gestor
	parejas.put(solicitante, pareja);
	// 9. Devolver código de éxito
	return CORRECTO;
	}

	public String getListadoSolicitantes()
	{
		// 1. Método placeholder - devuelve texto fijo
		// 2. Debería implementar listado real de solicitantes
		return "getListadoSolicitantes";
	}

	
	public String getListadoParejas() {
		
		// 1. String para construir el listado de parejas por gestor
		String gestorDeParejasDev = "";
		
		// 2. TreeMap auxiliar ordenado para procesar gestores en orden
		TreeMap<Persona, TreeMap<Persona, Persona>> gestorParejasOrdenadas = new TreeMap<>();
		
		
		
		// 3. ERROR: Se está recorriendo el mapa vacío en lugar del mapa real
		// 4. Debería ser: for(Map.Entry<Persona, TreeMap<Persona, Persona>> gestorParejas : gestoresParejas.entrySet()) {
		for(Map.Entry<Persona, TreeMap<Persona, Persona>> gestorParejas : gestorParejasOrdenadas.entrySet()) {
			// 5. Verificar si el gestor tiene parejas asignadas
			if(gestorParejas.getValue()!=null && !gestorParejas.getValue().isEmpty()) {
				// 6. Añadir encabezado del gestor
				gestorDeParejasDev += "\n Gestor....." + gestorParejas.getKey().getNombre() + "\n" + "Parejas hechas: \n";
				
				// 7. Recorrer todas las parejas de este gestor
				for(Map.Entry<Persona,Persona > pareja : gestorParejas.getValue().entrySet()) {
					// 8. Añadir información de la pareja (persona1 + persona2)
					gestorDeParejasDev += "                  " + pareja.getKey().getNombre()+ " + " + pareja.getValue().getNombre() + "\n";
				}
				
			}
		}
		
		// 9. Devolver el listado completo de parejas por gestor
		return gestorDeParejasDev;
	}


}
