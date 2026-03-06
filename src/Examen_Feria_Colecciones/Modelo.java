package Examen_Feria_Colecciones;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Modelo {

	private ListaPrecios listaPrecios;
	private ListaSocios listaSocios;
	private HashMap<Socio, LinkedList<Consumicion>> listaCuentas;
	
	public Modelo() {
		this.listaPrecios = new ListaPrecios();
		this.listaSocios = new ListaSocios();
		this.listaCuentas = new HashMap<>() ;
	}

	
	public boolean aniadeArticulo(String nombre, String tamanio, float precio) {
		
		if (listaPrecios.containsKey(new Articulo (nombre,tamanio))) {
			listaPrecios.put(new Articulo (nombre,tamanio),precio);
			return false;
		}
		
		listaPrecios.put(new Articulo (nombre,tamanio), precio);
		
		return true;
	}
	
	public ListaPrecios getListaPrecios() {
		return listaPrecios;
	}


	public void setListaPrecios(ListaPrecios listaPrecios) {
		this.listaPrecios = listaPrecios;
	}


	public ListaSocios getListaSocios() {
		return listaSocios;
	}


	public void setListaSocios(ListaSocios listaSocios) {
		this.listaSocios = listaSocios;
	}


	public HashMap<Socio, LinkedList<Consumicion>> getListaCuentas() {
		return listaCuentas;
	}


	public void setListaCuentas(HashMap<Socio, LinkedList<Consumicion>> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}


	public boolean borraArticulo (String nombre, String tamanio) {
		
		if (listaPrecios.containsKey(new Articulo (nombre,tamanio))) {
			listaPrecios.remove(new Articulo (nombre,tamanio));
			return true;
		}
		return false;
	}
	
	public boolean hayCuentaPendienteConEseArticulo(String art,String tamanio) {
		
		Articulo articulo = new Articulo (art,tamanio);
		
		for (Map.Entry<Socio, LinkedList<Consumicion>>entrada: listaCuentas.entrySet()) {
			for(Consumicion consumicion :entrada.getValue()) {
				if(consumicion.getArticulo().equals(articulo)) {
					return true;
				}
				
			}
		}
		return false;
		
	}
	
	public void aniadeConsumicion(Socio socio, Articulo articulo,int cantidad) {
		
		if(listaCuentas.containsKey(socio)) {
			listaCuentas.get(socio).add(new Consumicion(articulo,cantidad));
			
		}else {
			LinkedList<Consumicion> consumiciones=new LinkedList<Consumicion>();
			consumiciones.add(new Consumicion(articulo,cantidad));
			listaCuentas.put(socio, consumiciones);
		}
	}

	public LinkedList<Consumicion> getListaConsumiciones(Socio socio) {
		return listaCuentas.get(socio);
	}

	public String calculaTotalCuenta(Socio socio) {
		
		LinkedList<Consumicion> consumiciones =  listaCuentas.get(socio);
		
		Float sumaPrecios = 0F;
		
		for( Consumicion consumicion : consumiciones) {
			sumaPrecios+= listaPrecios.get(consumicion.getArticulo()) * consumicion.getCantidad();
		}
		return sumaPrecios.toString();
	}

	
	
	
}
