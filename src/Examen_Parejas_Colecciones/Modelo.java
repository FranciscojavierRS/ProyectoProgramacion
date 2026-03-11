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
		
		Persona persona = new Persona(nombre, sexoSolicitante, sexoSolicitado, gestor, aficiones);
		
		if(solicitantes.contains(persona)) {
			return YA_EXISTE;
		}
		
		solicitantes.add(persona);
		if (gestor) {
			gestoresParejas.put(persona, new TreeMap<Persona,Persona>());
			
		}
		
		return CORRECTO;
	}

	public Set<Persona> getListaGestores()
	{
		
		
		return gestoresParejas.keySet();
	}

	public Set<Persona> getListaSolicitantes()
	{
		
		
		return this.solicitantes;
	}

	public String getListadoAfinidades(String nombreSolicitante)
	{
		
		Persona solicitante = getPersonaPorNombre(nombreSolicitante);
		
		String posiblesParejas = "";
		
		for (Persona persona : solicitantes) {
			if(!persona.equals(solicitante) && persona.getSexoPropio().equals(solicitante.getSexoBuscado())) {
				posiblesParejas+=persona.getNombre()+"-"+solicitante.aficionesComunesCon(persona)+"\n";
			}
		}
		
		return posiblesParejas;
	}

	private Persona getPersonaPorNombre(String nombreSolicitante) {
		Persona solicitante= null;
		
		for (Persona persona : solicitantes) {
			if (persona.getNombre().equals(nombreSolicitante)) {
				solicitante = persona;
				
				break;
			}
		}
		return solicitante;
	}

	public int creaPareja(String nombreGestor, String nombreSolicitante, String nombrePareja)
	{
	Persona gestor =getPersonaPorNombre(nombreGestor);
	Persona solicitante =getPersonaPorNombre(nombreSolicitante);
	Persona pareja =getPersonaPorNombre(nombrePareja);
	
	if(!gestor.isGestor()) {
		return YA_EXISTE;
		
	}
	TreeMap<Persona,Persona>parejas =gestoresParejas.get(gestor);
	
	for (Map.Entry<Persona, Persona>entrada: parejas.entrySet()) {
		if(solicitante.equals(entrada.getKey()) || solicitante.equals(entrada.getValue()) || pareja.equals(entrada.getKey()) || pareja.equals(entrada.getValue())) {
			return YA_EXISTE;
		}
		
	}
		parejas.put(solicitante, pareja);
		return CORRECTO;
	}

	public String getListadoSolicitantes()
	{
		return "getListadoSolicitantes";
	}

	
	public String getListadoParejas() {
		
		String gestorDeParejasDev = "";
		
		TreeMap<Persona, TreeMap<Persona, Persona>> gestorParejasOrdenadas = new TreeMap<>();
		
		
		
		for(Map.Entry<Persona, TreeMap<Persona, Persona>> gestorParejas : gestorParejasOrdenadas.entrySet()) {
			if(gestorParejas.getValue()!=null && !gestorParejas.getValue().isEmpty()) {
				gestorDeParejasDev += "\n Gestor....." + gestorParejas.getKey().getNombre() + "\n" + "Parejas hechas: \n";
				
				for(Map.Entry<Persona,Persona > pareja : gestorParejas.getValue().entrySet()) {
					gestorDeParejasDev += "                  " + pareja.getKey().getNombre()+ " + " + pareja.getValue().getNombre() + "\n";
				}
				
			}
		}
		
		return gestorDeParejasDev;
	}


}
