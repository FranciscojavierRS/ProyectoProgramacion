package TipoExamene_Objeto_Rutas;

import java.util.Arrays;

public class ListaRutas {
	private Ruta[] rutas;
	private int numRutas=0;
	
	public ListaRutas(Ruta[] rutas) {
		super();
		setRutas(rutas);
	}

	public ListaRutas() {
		super();
		rutas=new Ruta[10];
	}
	
	
	public Ruta[] getRutas() {
		return rutas;
	}

	public int getNumRutas() {
		return numRutas;
	}
	
	

	public void setRutas(Ruta[] rutas) {
		this.rutas=rutas;
		numRutas=0;
		for(int i=0;i<rutas.length && rutas[i]!=null;i++) {
			numRutas++;
		}
	}

	public void addRuta( Ruta r) {
		if(this.rutas.length>=this.numRutas) {
			this.rutas=Arrays.copyOf(rutas, this.rutas.length+1);
		}
		this.rutas[numRutas++]=r;
	}

	//a
	public boolean hayRutaEntre(Ciudad origen, Ciudad destino) {
		return false;
	}
	
	//b
	public boolean hayRutaDeIdaYVueltaEntre(Ciudad origen, Ciudad destino) {
		return false;
	}
	
	//c
	public ListaRutas getRutasDesde(Ciudad origen) {
		return null;
	}
	
	//d
	public Ciudad[] getCiudadesImportantes(int numHabitantes) {
			return null;
	}
	
	//e)
	public ListaRutas getListaOrdenada() {
		return null;
	}
	
	@Override
	public String toString() {
		return "ListaRutas [rutas=" + Arrays.toString(Arrays.copyOf(rutas, numRutas)) + "]";
	}
	
	
	
}

