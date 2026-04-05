package Examen_Inventario_Ficheros;

import java.io.File;

public class Principal {

	private static final String FICHERO_TEXTO_A_LEER = "productos.txt";
	private static final String FICHERO_TEXTO_ESCRITO = "productosTotal.txt";
	private static final String FICHERO_BINARIO = "productos.dat";
	private static final String FICHERO_XML = "productos.xml";

	public static void main(String[] args) {
		Modelo modelo = new Modelo();

		// Agregar productos para pruebas iniciales
		
		modelo.getInventario().addProducto(new Producto(1004, "Auriculares Sony WH-1000XM4", 349.99, 20));
		modelo.getInventario().addProducto(new Producto(1005, "Smartwatch Apple Series 6", 429.00, 8));
		modelo.getInventario().addProducto(new Producto(1006, "Monitor LG UltraWide 34''", 499.00, 12));
		modelo.getInventario().addProducto(new Producto(1007, "Tablet Amazon Fire HD 10", 149.99, 25));

		System.out.println("\n--------------------------------");
		System.out.println("a) He le�do y cargado " + modelo.leerFicheroTexto(new File(FICHERO_TEXTO_A_LEER))
				+ " productos de " + FICHERO_TEXTO_A_LEER);
		
		System.out.println("\n--------------------------------");
		modelo.escribirFicheroTexto(new File(FICHERO_TEXTO_ESCRITO));
		System.out.println("b) "+ FICHERO_TEXTO_ESCRITO + " generado.");
				
		System.out.println("\n--------------------------------");
		//creo algunos productos nuevos y los a�ado a otro modelo para escribirlos en el fichero binario
		//y luego poder leerlos y cargarlos en el primer modelo
		Modelo modelo2 = new Modelo();
		modelo2.getInventario().addProducto(new Producto(1001, "C�mara Canon EOS", 799.99, 10));
		modelo2.getInventario().addProducto(new Producto(1002, "Smartphone Samsung Galaxy S21", 999.99, 15));
		modelo2.getInventario().addProducto(new Producto(1003, "Laptop Dell XPS 13", 1199.00, 5));
		
		System.out.println("c) Escribo productos del modelo 2 en fichero binario: "+modelo2.escribirFicheroBinario(new File(FICHERO_BINARIO)));
		
		System.out.println("\n--------------------------------");
		modelo.leerFicheroBinario(new File(FICHERO_BINARIO));
		System.out.println("d) Modelo tras leer productos del fichero binario: "+modelo.getInventario().getProductos());
		
		System.out.println("\n--------------------------------");
		System.out.println("e) Escribiendo productos en XML...");
		modelo.escribirFicheroXML(new File(FICHERO_XML));
		
		System.out.println("\n--------------------------------");
		System.out.println("f) Leyendo productos del XML y cargandolos en modelo2...");
		modelo2.leerFicheroXML(new File(FICHERO_XML));
		
		System.out.println("f) Modelo2 tras leer productos del fichero XML: "+modelo2.getInventario().getProductos());

	}

}
