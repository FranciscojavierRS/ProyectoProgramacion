package Examen_Articulos_Objetos;

import java.util.Arrays;

public class ModeloDeDatos {

	Articulo tArticulos[];
	Cliente tClientes[];
	Factura tFacturas[];

	public ModeloDeDatos() {
		this.tArticulos = new Articulo[0];
		this.tClientes = new Cliente[0];
		this.tFacturas = new Factura[0];
	}

	public void anadeArticulo(Articulo ArticuloNuevo) {
		Articulo nuevaTArticulos[] = new Articulo[this.tArticulos.length + 1];
		for (int i = 0; i < this.tArticulos.length; i++)
			nuevaTArticulos[i] = tArticulos[i];

		nuevaTArticulos[this.tArticulos.length] = ArticuloNuevo;
		this.tArticulos = nuevaTArticulos;
	}

	public void anadeFactura(Factura FacturaNueva) {
		Factura nuevaTFacturas[] = new Factura[this.tFacturas.length + 1];
		for (int i = 0; i < this.tFacturas.length; i++)
			nuevaTFacturas[i] = tFacturas[i];

		nuevaTFacturas[this.tFacturas.length] = FacturaNueva;
		this.tFacturas = nuevaTFacturas;
	}

	public void anadeCliente(Cliente clienteNuevo) {
		Cliente nuevaTClientes[] = new Cliente[this.tClientes.length + 1];
		for (int i = 0; i < this.tClientes.length; i++)
			nuevaTClientes[i] = tClientes[i];

		nuevaTClientes[this.tClientes.length] = clienteNuevo;
		this.tClientes = nuevaTClientes;
	}

	public Factura facturaFusionada(Cliente cliente, int numFra) {

		Factura facturafusionada = new Factura(numFra, cliente, 0);
		// Recorremos el Array de Facturas. Si el cliente de la facutara es el cliente
		// introducido...
		// añadimos las lineas de esa factura a la factura fusionada

		for (int i = 0; i < this.tFacturas.length; i++) {

			Factura factura = this.tFacturas[i];

			if (cliente.equals(factura.getCliente())) {

				for (int j = 0; j < factura.gettLineas().length; j++) {
					facturafusionada.anadeLinea(factura.gettLineas()[j]);
				}

			}
		}

		return facturafusionada;
	}

	public Factura facturaFusionadaResumida(Cliente cliente, int numFra) {
		Factura facturafusionada = new Factura(numFra, cliente, 0);

		for (int i = 0; i < this.tFacturas.length; i++) {

			Factura factura = this.tFacturas[i];

			if (cliente.equals(factura.getCliente())) {

				for (int j = 0; j < factura.gettLineas().length; j++) {
					facturafusionada
							.settLineas(anadeLineaSinRepetir(facturafusionada.gettLineas(), factura.gettLineas()[j]));
				}

			}
		}

		return facturafusionada;
	}

	public float gastoPorCliente(Cliente cliente) {
		float gastoCliente = 0.0F;
		for (Factura f : this.tFacturas)
			if (cliente.equals(f.getCliente()))
				gastoCliente += f.getImporteTotalFra();
		return gastoCliente;
	}

	public Cliente clienteMayorGasto() {

		Cliente clienteMayorgasto = tClientes[0];
		float mayorGasto = gastoPorCliente(clienteMayorgasto);
		for (int i = 1; i < tClientes.length; i++) {
			float gastoCliente = gastoPorCliente(tClientes[i]);
			if (gastoCliente > mayorGasto) {
				clienteMayorgasto = tClientes[i];
				mayorGasto = gastoCliente;
			}
		}

		return clienteMayorgasto;
	}

	public Articulo[] ArticulosPorVentas() {
		
		Articulo tArtDevolver[] = new Articulo[this.tArticulos.length];
		int nElem = 0;
		
		for (int i= 0; i<tArticulos.length; i++) {
			
			Articulo articulo = tArticulos[i];
			int pos = nElem-1;
			   while(pos>=0 && totalUnidadesVendidas(articulo)>totalUnidadesVendidas(tArtDevolver[pos]))
			   {
				   tArtDevolver[pos+1]=tArtDevolver[pos];
				   pos--;
			   }
			   tArtDevolver[pos+1] = articulo;
			   nElem++;
			}
			return tArtDevolver;
	}

	public int totalUnidadesVendidas(Articulo articulo) {
		
		//Creamos un contador Recorremos cada factura. 
		//Por cada factura recorremos cada linea. 
		//Si el artuculo de esa linea es el articulo de entrada sumamos al contador de ventas las unidades de esa linea.
		
		int contadorFactura = 0;
		
		for (int i=0; i<tFacturas.length; i++) {
			for (int j= 0; j<tFacturas[i].gettLineas().length; j++) {
				if (tFacturas[i].gettLineas()[j].equals(articulo)) {
					contadorFactura+=tFacturas[i].gettLineas()[j].getCantidad();
					
				}
			}
		}
		
		return contadorFactura;
	}

	private Linea[] anadeLineaSinRepetir(Linea[] lineas, Linea linea) {

		Linea nuevaTLineas[] = new Linea[lineas.length];

		boolean repetido = false;

		for (int i = 0; i < lineas.length; i++) {

			if (lineas[i].getArticulo().equals(linea.getArticulo())) {

				repetido = true;

				lineas[i].setCantidad(lineas[i].getCantidad() + linea.getCantidad());
			}

			nuevaTLineas[i] = lineas[i];
		}
		if (!repetido) {
			nuevaTLineas = Arrays.copyOf(nuevaTLineas, lineas.length + 1);
			nuevaTLineas[lineas.length] = linea;
		}

		return nuevaTLineas;

	}

}
