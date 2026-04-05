package Examen_Feria_Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import Examen_Musica_Colecciones.FechaHora;

public class Modelo {
	private ListaPrecios listaPrecios;
	private ListaSocios listaSocios;
	private HashMap<Socio, LinkedList<Consumicion>> listaCuentas;

	public Modelo() {
		this.listaPrecios = new ListaPrecios();
		this.listaSocios = new ListaSocios();
		this.listaCuentas = new HashMap<Socio, LinkedList<Consumicion>>();
	}

	public boolean addArticulo(String nombre, String tamanyo, float precio) {
		if (this.listaPrecios.put(new Articulo(nombre, tamanyo), precio) == null)
			return true;
		else
			return false;
	}

	public boolean borraArticulo(String nombre, String tamanyo) {
		if (this.listaPrecios.remove(new Articulo(nombre, tamanyo)) == null)
			return false;
		else
			return true;
	}

	public ListaSocios getListaSocios() {
		return this.listaSocios;
	}

	public ListaPrecios getListaPrecios() {
		return listaPrecios;
	}

	public boolean hayCuentaPendienteConEseArticulo(String art, String tamanyo) {
		for (Socio s : this.listaCuentas.keySet())
			for (Consumicion c : this.listaCuentas.get(s))
				if (c.getArticulo().equals(new Articulo(art, tamanyo)))
					return true;

		return false;

	}

	public void addConsumicion(Socio socio, Articulo articulo, int cantidad) {
		if (!this.listaCuentas.containsKey(socio))
			this.listaCuentas.put(socio, new LinkedList<Consumicion>());

		this.listaCuentas.get(socio).add(new Consumicion(articulo, cantidad));
	}

	public LinkedList<Consumicion> getListaConsumiciones(Socio socio) {
		return this.listaCuentas.get(socio);
	}

	public String calculaTotalCuenta(Socio socio) {
		String res = "";
		float total = 0.0F;
		if (this.listaCuentas.get(socio) != null) {
			res += socio + "\n";
			for (Consumicion c : this.listaCuentas.get(socio)) {
				res += c.toString() + " x " + this.listaPrecios.get(c.getArticulo()) + " = "
						+ c.getCantidad() * this.listaPrecios.get(c.getArticulo()) + "\n";
				total += c.getCantidad() * this.listaPrecios.get(c.getArticulo());
			}
			res += "\nTOTAL...........:" + total;
		}
		return res;
	}

	public float calculaTotalCuentaNumerico(Socio socio) {

		float total = 0.0F;
		if (this.listaCuentas.get(socio) != null) {
			for (Consumicion c : this.listaCuentas.get(socio)) {
				total += c.getCantidad() * this.listaPrecios.get(c.getArticulo());
			}
		}
		return total;
	}

	// M�todos acceso a datos - U1

	// a)
	/*
	 * Este m�todo escribir� los objetos Socio del atributo listaSocios en un
	 * fichero binario cuyo nombre debe ser la fecha del d�a en el que se genere. El
	 * m�todo devolver� un entero indicando el n�mero de objetos que ha guardado en
	 * el archivo binario.
	 */
	public int escribeSociosEnBinario() {

		int contadorSocios = 0;

		try {
			ObjectOutputStream flujoSalida = new ObjectOutputStream(
					new FileOutputStream(LocalDate.now().toString() + ".dat"));

			for (Socio socio : listaSocios) {

				flujoSalida.writeObject(socio);
				contadorSocios++;

			}

			flujoSalida.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return contadorSocios;
	}

	// b)
	/*
	 * Este m�todo escribir� los datos de las consumiciones de cada socio y el total
	 * de cada cuenta en un fichero XML de nombre "cuentas-socios.xml". El m�todo
	 * devolver� un entero indicando el n�mero de socios cuyas cuentas han sido
	 * guardadas en el archivo XML.
	 */
	public int escribeCuentasXML() {

		return 0;
	}

	//
	//
	//
	// NADA
	//
	//
	//
	// c)
	/*
	 * El m�todo debe escribir en un archivo de texto llamado
	 * "articulos-pendientes.txt" los datos de los art�culos pendientes, y qu� socio
	 * debe cada uno de ellos.
	 */
	public boolean escribeEnTXTCuentasPendientesArticulos() {

		HashMap<Articulo, ArrayList<Socio>> mapaArticulosPendientes = new HashMap<>();
		
		for (Map.Entry<Socio, LinkedList<Consumicion>> entrada : listaCuentas.entrySet()) {
			
			for (Consumicion consumicion : entrada.getValue()) {
				if (!mapaArticulosPendientes.containsKey(consumicion.getArticulo())) {
					mapaArticulosPendientes.put(consumicion.getArticulo(), new ArrayList<>());
					
				}
				mapaArticulosPendientes.get(consumicion.getArticulo()).add(entrada.getKey());
			
			}
			
		}


		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("articulos-pendientes.txt"));

			for (Map.Entry<Articulo, ArrayList<Socio>> entrada : mapaArticulosPendientes.entrySet()) {
				out.write(entrada.getKey().getDenominacion());
				out.newLine();
				for(Socio socio : entrada.getValue()) {
					out.write(socio.getNombre());
					out.newLine();
				}
			}
			
			out.close();
			return true;
		} catch (IOException e) {

			e.printStackTrace();
		}

		return false;
	}

	// d)
	/*
	 * El m�todo debe devolver un String con los datos le�dos del fichero binario
	 * que se habr�a generado en el d�a de hoy pulsando el bot�n que ejecuta el
	 * m�todo del apartado a). El String debe contener �apellidos, nombre� de cada
	 * socio en cada l�nea.
	 */
	public String leeBinarioHoy() {
		String cadena = "";
		ObjectInputStream flujoSalida = null;
		try {
			flujoSalida = new ObjectInputStream(
					new FileInputStream(LocalDate.now().toString() + ".dat"));
			
			
			while (true) {
				
				Socio socio=(Socio)flujoSalida.readObject();
				cadena += socio.getNombre()+"\r\n";
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}finally {
			if(flujoSalida!=null) {
				try {
					flujoSalida.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			return cadena;
		}
		
	}

	// e)
	/*
	 * El m�todo debe devolver un String con los datos le�dos del fichero XML
	 * "cuentas-socios.xml" que se habr�a generado pulsando el bot�n que ejecuta el
	 * m�todo del apartado b).
	 */
	public String leeXML() {
		return "";
	}

	// f)
	public String leeTXT() {
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("articulos-pendientes.txt"));
			String salida = "";
			String cadena = in.readLine();
			while (cadena!=null) {
				
				salida += cadena+"\r\n";
				cadena = in.readLine();
			}
			
			
			in.close();
			return salida;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "";
	}
}
