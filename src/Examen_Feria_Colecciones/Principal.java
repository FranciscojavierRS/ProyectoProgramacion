package Examen_Feria_Colecciones;

import java.util.LinkedList;

public class Principal
{
	private Modelo modelo;
	private VentanaPpal vista;
	
	public static void main(String args[])
	{
		new Principal();
	}
	
	public Principal()
	{
		this.modelo = new Modelo();
		this.vista = new VentanaPpal(this);
		this.vista.setVisible(true);
		
		
		////CREACION DE LOS DATOS DE PRUEBA
		
		modelo.getListaSocios().add(new Socio("ilvarez Caballero, Fernando Javier",0));
		modelo.getListaSocios().add(new Socio("Berenguer Borrego, Fernando",0));
		modelo.getListaSocios().add(new Socio("Cabanillas Gilvez, Ezequiel",0));
		modelo.getListaSocios().add(new Socio("Campano Laborda, Josi Antonio",0));
		modelo.getListaSocios().add(new Socio("Carmona Montiel, Miguel",0));
		modelo.getListaSocios().add(new Socio("Castaieda Castaio, Alejandro ",0));
		modelo.getListaSocios().add(new Socio("Cervilla Campoy, Sergio",0));
		modelo.getListaSocios().add(new Socio("De la Fuente Campaia, Antonio",0));
		modelo.getListaSocios().add(new Socio("Dominguez Bermidez, Marina Pilar",0));
		modelo.getListaSocios().add(new Socio("Dominguez Gonzilez, Adriin",0));
		modelo.getListaSocios().add(new Socio("Garcia Alves, Diego",0));
		modelo.getListaSocios().add(new Socio("Garcia Moreno, Josi Maria",0));
		modelo.getListaSocios().add(new Socio("Garrido Hernindez, Juan Manuel",0));
		modelo.getListaSocios().add(new Socio("Garrocho Prados, Manuel",0));
		modelo.getListaSocios().add(new Socio("Hernando Ortega, Ivin",0));
		modelo.getListaSocios().add(new Socio("Herrera Pozas, David",0));
		modelo.getListaSocios().add(new Socio("Iglesias Garcia, Javier Manuel",0));
		modelo.getListaSocios().add(new Socio("Mallin Rodriguez, Juan",0));
		modelo.getListaSocios().add(new Socio("Menacho Pantoja, Fernando David",0));
		modelo.getListaSocios().add(new Socio("Niiez Tocin, Alejandro",0));
		modelo.getListaSocios().add(new Socio("Ocampos Buendia, David",0));
		modelo.getListaSocios().add(new Socio("Pirez Vilches, Luis",0));
		modelo.getListaSocios().add(new Socio("Rodriguez Martinez, Juan Antonio",0));
		modelo.getListaSocios().add(new Socio("Sinchez Verdugo, ilvaro",0));
		modelo.getListaSocios().add(new Socio("Serrano Garcia, Valme Maria",0));
		
		modelo.aniadeArticulo("Coca Cola","Grande",1.2F);
		modelo.aniadeArticulo("Coca Cola","Mediano",1.0F);
		modelo.aniadeArticulo("Coca Cola","Pequeio",0.9F);
		modelo.aniadeArticulo("Manzanilla","Mediano",4.2F);
		modelo.aniadeArticulo("Tortilla","Grande",4.2F);
		modelo.aniadeArticulo("Jamin","Mediano",9.0F);
		modelo.aniadeArticulo("Jamin","Grande",10.2F);
		modelo.aniadeArticulo("Jamin","Pequeio",6.5F);
		modelo.aniadeArticulo("Rebujito","Grande",12.0F);
		
		this.vista.actualizaComboSocios();
		this.vista.actualizaComboArticulos();
		
		/// FIN DE LA CREACION DE DATOS DE PRUEBA
	}

	public boolean aniadeArticulo(String nombre, String tamanio, float precio) 
	{
		return this.modelo.aniadeArticulo(nombre,tamanio,precio);
	}

	public boolean borraArticulo(String nombre, String tamanio) 
	{
		return this.modelo.borraArticulo(nombre,tamanio);
	}

	public ListaSocios getListaSocios() 
	{
		return this.modelo.getListaSocios();
	}

	public ListaPrecios getListaPrecios() 
	{
		return this.modelo.getListaPrecios();
	}

	public boolean hayCuentaPendienteConEseArticulo(String art,String tamanio) 
	{
		return this.modelo.hayCuentaPendienteConEseArticulo(art,tamanio);
	}

	public void aniadeConsumicion(Socio socio, Articulo articulo,int cantidad) 
	{
		this.modelo.aniadeConsumicion(socio, articulo, cantidad);
	}

	public LinkedList<Consumicion> getListaConsumiciones(Socio socio) 
	{
		return this.modelo.getListaConsumiciones( socio);
	}

	public String calculaTotal(Socio socio) 
	{
		return this.modelo.calculaTotalCuenta(socio);
	}

	

}
