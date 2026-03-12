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
		// 1. Añade al mapa de asignaciones una nueva pareja con el comercial
		// 2. Crea un conjunto nuevo vacío de empresas asignadas
		// 3. HashMap.put() sobrescribe si la clave ya existe

		asignaciones.put(c, new TreeSet<Empresa>());

	}

	public void asignaEmpresaAComercial(Comercial c, Empresa e) {
		// Asigna la empresa al conjunto de empresas del comercial especificado

		/*
		 * 1. Comprobar si el comercial está ya registrado en el mapa
		 * 2. Si está registrado, obtener su lista de empresas y añadir la nueva empresa
		 * 3. TreeSet.add() evita duplicados automáticamente
		 */

		if (asignaciones.containsKey(c)) {
			asignaciones.get(c).add(e);
		}
	}

	public void anyadeVisita(Visita visita) {
		// 1. Añadir la visita al Vector de visitas
		// 2. Vector.add() añade al final y siempre devuelve true
		// 3. Vector es thread-safe a diferencia de ArrayList
		this.visitas.add(visita);
	}

	public boolean hayErrores() {
		// Devuelve true si hay visita hecha por comercial a empresa NO asignada

		// 1. Recorrer todas las visitas registradas
		for (Visita visita : visitas) {
			// 2. Obtener las empresas asignadas al comercial que hizo la visita
			// 3. Verificar si la empresa visitada NO está entre las asignadas
			if (!asignaciones.get(visita.getComercial()).contains(visita.getEmpresa())) {
				// 4. Error encontrado: comercial visitó empresa no asignada
				return true;
			}

		}

		// 5. No se encontraron errores
		return false;
	}

	public float totalComprasPorComercial(Comercial c) {
		// Devuelve total de compras hechas por empresas asignadas al comercial

		// 1. Obtener el conjunto de empresas asignadas al comercial
		TreeSet<Empresa> empresas = asignaciones.get(c);

		// 2. Acumulador para la suma de precios
		float sumaPrecios = 0;

		// 3. Recorrer todas las empresas asignadas al comercial
		for (Empresa empresa : empresas) {
			// 4. Sumar las compras de cada empresa al acumulador
			sumaPrecios += empresa.getCompras();
		}

		// 5. Devolver el total de compras
		return sumaPrecios;
	}

	public float totalVentasPorEmpresa(Empresa e) {
		// Devuelve total de ventas hechas por todos los comerciales asignados a la empresa
		
		// 1. Acumulador para la suma de ventas
		float sumaPrecios = 0;
		
		// 2. Recorrer cada entrada del mapa (comercial -> conjunto de empresas)
		for (Map.Entry<Comercial, TreeSet<Empresa>>entrada: asignaciones.entrySet()) {
			// 3. Verificar si este comercial tiene asignada la empresa especificada
			if(entrada.getValue().contains(e)) {
				// 4. Sumar las ventas de este comercial al acumulador
				sumaPrecios+= entrada.getKey().getVentas();
			}
			
		}
		// 5. Devolver el total de ventas de todos los comerciales asignados
		return sumaPrecios;
	}

	public TreeSet<Comercial> comercialesQueVisitaronEnElMes(int mes) {
		// Devuelve TreeSet con todos los comerciales que hicieron visitas en el mes
		
		// 1. Crear TreeSet para almacenar comerciales (automáticamente ordenado y sin duplicados)
		TreeSet<Comercial>comerciales = new TreeSet<>();
		
		// 2. Recorrer todas las visitas registradas
		for (Visita visita:visitas) {
			// 3. Verificar si la visita fue en el mes especificado
			if(visita.getMes()==mes) {
				// 4. Añadir el comercial que hizo la visita al conjunto
				comerciales.add(visita.getComercial());
			}
		}
		
		
		// 5. Devolver el conjunto de comerciales que visitaron en ese mes
		return comerciales;
	}

	public TreeSet<String> nombresDeEmpresasNoVisitadas() {
		// Devuelve TreeSet con todas las empresas que no han recibido ninguna visita
		
		// 1. TreeSet para almacenar nombres de empresas no visitadas (ordenado)
		TreeSet<String> empresas = new TreeSet<>();
		// 2. TreeSet auxiliar para almacenar todas las empresas asignadas
		TreeSet<Empresa> empresasTotales = new TreeSet<>();
		
		// 3. Recorrer todas las asignaciones para obtener todas las empresas
		for (Map.Entry<Comercial, TreeSet<Empresa>>entrada: asignaciones.entrySet()) {
			// 4. Añadir todas las empresas de este comercial al conjunto total
			empresasTotales.addAll(entrada.getValue());
		}
		// 5. Recorrer todas las visitas para eliminar empresas visitadas
		for (Visita visita : visitas) {
			// 6. Eliminar la empresa visitada del conjunto total
			empresasTotales.remove(visita.getEmpresa());
		}
		
		// 7. Convertir las empresas no visitadas a nombres
		for (Empresa empresa : empresasTotales) {
			// 8. Añadir el nombre de cada empresa no visitada al conjunto resultado
			empresas.add(empresa.getNombre());
		}
		
		// 9. Devolver los nombres de empresas no visitadas
		return empresas;
	}

	public TreeMap<Comercial, LinkedList<Visita>> mapaVisitasPorComercial() {
		// Devuelve mapa con comerciales como claves y LinkedList de visitas como valores
		
		
		// 1. Crear TreeMap para almacenar visitas por comercial (ordenado por comercial)
		TreeMap<Comercial, LinkedList<Visita>> mapaVisitas = new TreeMap<>();
		
		// 2. Recorrer todas las visitas registradas
		for (Visita visita : visitas) {
			// 3. Verificar si el comercial ya tiene una lista de visitas en el mapa
			if (mapaVisitas.containsKey(visita.getComercial())) {
				// 4. Si existe, añadir la visita a su lista existente
				mapaVisitas.get(visita.getComercial()).add(visita);
				
			}else {
				// 5. Si no existe, crear nueva LinkedList y añadir la visita
				LinkedList<Visita> visitas2=new LinkedList<Visita>();
				visitas2.add(visita);
				// 6. Añadir el comercial con su nueva lista al mapa
				mapaVisitas.put(visita.getComercial(), visitas2);
			}
		}
		
		
		// 7. Devolver el mapa completo de visitas por comercial
		return mapaVisitas;
	}

}
