package EjerciciosAngelExcepciones;

import java.io.Serializable;
import java.util.Objects;




/*
 * ​1. Modelo de Datos (POO)
​Crea una clase llamada Avistamiento:
​Atributos: especie (String), lugar (String), cantidadAves (int) y pesoPromedio (double).
​Criterio de Igualdad: Dos avistamientos son iguales si son de la misma especie en el mismo lugar.
​Ordenación: Por especie alfabéticamente.

​2. Paso 1: Carga y Filtrado (Lectura TXT y Set)
​Lee un fichero avistamientos_diarios.txt con el formato: especie,lugar,cantidad,peso.
​Crea objetos Avistamiento y añádelos a un HashSet<Avistamiento>.
​Pasa los elementos del Set a un ArrayList para poder ordenarlos.

​3. Paso 2: Copia de Seguridad (Binario)
​Escritura: Guarda el ArrayList en un fichero binario llamado registro_limpio.dat.
​Lectura: Recupera la lista desde el fichero binario en una nueva variable.

​4. Paso 3: Informe de Estadísticas (Salida TXT)
​Genera un archivo informe_aves.txt que responda a lo siguiente:
​Frecuencias: ¿Cuántas veces aparece cada lugar en el registro?
​Máximo: ¿Cuál es la especie con el mayor avistamiento (más cantidadAves)?
​Mínimo: ¿Cuál es el pesoPromedio más bajo registrado?
​Media: Calcula el peso promedio de todas las aves registradas en el fichero.
 */
public class Avistamiento implements Comparable<Avistamiento>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String especie;
	private String lugar;
	private int cantidadAves;
	private double pesoPromedio;
	
	
	public Avistamiento(String especie, String lugar, int cantidadAves, double pesoPromedio) {
		super();
		this.especie = especie;
		this.lugar = lugar;
		this.cantidadAves = cantidadAves;
		this.pesoPromedio = pesoPromedio;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public int getCantidadAves() {
		return cantidadAves;
	}


	public void setCantidadAves(int cantidadAves) {
		this.cantidadAves = cantidadAves;
	}


	public double getPesoPromedio() {
		return pesoPromedio;
	}


	public void setPesoPromedio(double pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}


	@Override
	public int hashCode() {
		return Objects.hash(especie, lugar);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Avistamiento))
			return false;
		Avistamiento other = (Avistamiento) obj;
		return Objects.equals(especie, other.especie) && Objects.equals(lugar, other.lugar);
	}


	@Override
	public int compareTo(Avistamiento o) {
		

		return this.especie.compareTo(o.especie);
	}

	
	
	
	
	

}
