package Examen_EmpresaComercial_Colecciones;

import java.util.*;

import Examen_Feria_Colecciones.Consumicion;



public class Modelo {
	private HashMap<Comercial, TreeSet<Empresa>> asignaciones;
	private Vector<Visita> visitas;

	public Modelo() {
		this.asignaciones = new HashMap<Comercial, TreeSet<Empresa>>();
		this.visitas = new Vector<Visita>();
	}

	public void anyadeComercial(Comercial c) {
		// anyade al mapa de asignaciones una nueva pareja con el comercial pasado como
		// parimetro y un conjunto nuevo vacio de empresas asignadas.

		asignaciones.put(c, new TreeSet<Empresa>());

	}

	public void asignaEmpresaAComercial(Comercial c, Empresa e) {
		// asigna la empresa pasada como parimetro al conjunto de empresas que tiene
		// asignadas
		// el comercial pasado como parimetro.

		/*
		 * Comprobamos si el comercial esta ya registrado en el mapa. Si esta
		 * registrado, obtenemos su lista de empresas y le añadimos la nueva empresa.
		 */

		if (asignaciones.containsKey(c)) {
			asignaciones.get(c).add(e);
		}
	}

	public void anyadeVisita(Visita visita) {
		this.visitas.add(visita);
	}

	public boolean hayErrores() {
		// Devuelve true si hay alguna visita hecha por un comercial a una empresa que
		// NO estaba
		// asignada a ese comercial. Devuelve false en otro caso.

		for (Visita visita : visitas) {
			if (!asignaciones.get(visita.getComercial()).contains(visita.getEmpresa())) {
				return true;
			}

		}

		return false;
	}

	public float totalComprasPorComercial(Comercial c) {
		// Devuelve el total de compras hechas por las empresas asignadas al comercial
		// pasado como parimetro.

		TreeSet<Empresa> empresas = asignaciones.get(c);

		float sumaPrecios = 0;

		for (Empresa empresa : empresas) {
			sumaPrecios += empresa.getCompras();
		}

		return sumaPrecios;
	}

	public float totalVentasPorEmpresa(Empresa e) {
		// Devuelve el total de ventas hechas por todos los comerciales asignados a
		// la empresa pasada como parimetro.
		
		float sumaPrecios = 0;
		
		for (Map.Entry<Comercial, TreeSet<Empresa>>entrada: asignaciones.entrySet()) {
			if(entrada.getValue().contains(e)) {
				sumaPrecios+= entrada.getKey().getVentas();
			}
			
		}
		return sumaPrecios;
	}

	public TreeSet<Comercial> comercialesQueVisitaronEnElMes(int mes) {
		// Devuelve un TreeSet con todos los comerciales que hicieron alguna visita
		// en el mes pasado como parimetro.
		
		TreeSet<Comercial>comerciales = new TreeSet<>();
		
		for (Visita visita:visitas) {
			if(visita.getMes()==mes) {
				comerciales.add(visita.getComercial());
			}
		}
		
		
		return comerciales;
	}

	public TreeSet<String> nombresDeEmpresasNoVisitadas() {
		// Devuelve un TreeSet con todas las empresas que no han recibido ninguna
		// visita.
		
		TreeSet<String> empresas = new TreeSet<>();
		TreeSet<Empresa> empresasTotales = new TreeSet<>();
		
		for (Map.Entry<Comercial, TreeSet<Empresa>>entrada: asignaciones.entrySet()) {
			empresasTotales.addAll(entrada.getValue());
		}
		for (Visita visita : visitas) {
			empresasTotales.remove(visita.getEmpresa());
		}
		
		for (Empresa empresa : empresasTotales) {
			empresas.add(empresa.getNombre());
		}
		
		return empresas;
	}

	public TreeMap<Comercial, LinkedList<Visita>> mapaVisitasPorComercial() {
		// Devuelve un mapa con todos los comerciales como claves, y el valor asociado a
		// cada comercial es una LinkedList de las visitas que ha hecho ese comercial.
		
		
		TreeMap<Comercial, LinkedList<Visita>> mapaVisitas = new TreeMap<>();
		
		for (Visita visita : visitas) {
			if (mapaVisitas.containsKey(visita.getComercial())) {
				mapaVisitas.get(visita.getComercial()).add(visita);
				
			}else {
				LinkedList<Visita> visitas2=new LinkedList<Visita>();
				visitas2.add(visita);
				mapaVisitas.put(visita.getComercial(), visitas2);
			}
		}
		
		
		return mapaVisitas;
	}

}
