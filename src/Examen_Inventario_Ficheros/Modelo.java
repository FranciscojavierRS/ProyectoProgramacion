package Examen_Inventario_Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Modelo {

	private Inventario inventario = new Inventario();

	public Inventario getInventario() {

		return inventario;
	}

	// a) Este m�todo leer� los datos de productos del fichero de texto recibido por
	// par�metro, y a�adir� dichos productos al modelo. Este fichero tendr� el
	// formato del fichero aportado �productos.txt�.
	// El m�todo devolver� un entero indicando el n�mero de productos que ha a�adido
	// al modelo. Ojo, puede haber objetos que se lean pero, al estar ya contenidos
	// en el Set del Modelo, no ser�n a�adidos, y por tanto no entrar�n en ese
	// c�mputo.
	public int leerFicheroTexto(File ficheroTexto) {

		int contadorProductos = 0;
		try (BufferedReader in = new BufferedReader(new FileReader(ficheroTexto))) {

			String linea = in.readLine();
			String[] campos;

			while (linea != null) {

				campos = linea.split(",");

				Producto producto = new Producto(Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2]),
						Integer.parseInt(campos[3]));

				if (inventario.addProducto(producto)) {
					contadorProductos++;

				}
				linea = in.readLine();

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		return contadorProductos;
	}
	
	
	

	// b) Este m�todo escribir� los objetos Producto del inventario en el fichero de
	// texto que se reciba por par�metro (en el mismo formato que el archivo
	// productos.txt que se aporta.
	public void escribirFicheroTexto(File ficheroTexto) {
		
		try (BufferedWriter in = new BufferedWriter(new FileWriter(ficheroTexto))) {
			
			for (Producto producto :inventario.getProductos() ) {
				
				String cad = producto.getId()+","+producto.getNombre()+","+producto.getPrecio()+","+producto.getCantidad();
				in.write(cad);
				in.newLine();
			}
			
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}

	}

	// c) Este m�todo escribir� los objetos Producto del inventario en el fichero
	// binario recibido por par�metro s�lo si este archivo no existe. En este caso,
	// el m�todo devolver� true. En el caso de que el fichero exista, el m�todo
	// devolver� false y no escribir� nada.
	public boolean escribirFicheroBinario(File ficheroBinario) {
		
		if(!ficheroBinario.exists()) {
			
			try {
				ficheroBinario.createNewFile();
				ObjectOutputStream flujoSalida =  new ObjectOutputStream(new FileOutputStream(ficheroBinario));
				
				for (Producto producto :inventario.getProductos() ) {
					
				flujoSalida.writeObject(producto);
					
				}
				
				flujoSalida.close();
				return true;
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			
		}

		return false;
	}

	// d) Este m�todo leer� los objetos Producto escritos en el fichero binario que
	// se recibe por par�metro y los a�adir� al inventario del modelo.
	public void leerFicheroBinario(File ficheroBinario) {
		
		try {
			ObjectInputStream flujoSalida =  new ObjectInputStream(new FileInputStream(ficheroBinario));
			
			while (flujoSalida.available()> 0) {
				
				inventario.addProducto((Producto)flujoSalida.readObject());
				
			}
			
			flujoSalida.close();
			
		} catch (FileNotFoundException e) {
			

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}

	// e)
	public void escribirFicheroXML(File ficheroXml) {

	}

	public void leerFicheroXML(File ficheroXml) {

	}
}
