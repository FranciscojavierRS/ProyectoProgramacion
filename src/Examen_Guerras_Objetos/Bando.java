package Examen_Guerras_Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Bando {
	private String nombre; // nombre del bando
	private Pais tablaPaises[]; // paises que formaron este bando
	private int nPaises; // numero de paises en la tabla
	public static final int MAX_PAISES = 10; // maximo.

	public Bando(String nombre) {
		this.nombre = nombre;
		this.tablaPaises = new Pais[Bando.MAX_PAISES];
		this.nPaises = 0;
	}

	public void anyadePais(Pais pais) {
		this.tablaPaises[nPaises++] = pais;
	}

	public boolean contienePais(Pais p) {
		boolean esta = false;

		for (int i = 0; i < nPaises && !esta; i++) {
			if (this.tablaPaises[i].equals(p)) {
				esta = true;
			}
		}
		return esta;
	}

	public Pais[] getTablaPaises() {
		return tablaPaises;
	}

	public int getnPaises() {
		return nPaises;
	}

	public String toString() {
		String cad = nombre + "\n";
		for (int i = 0; i < this.nPaises; i++)
			cad += "                      - " + this.tablaPaises[i] + "\n";
		return cad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(tablaPaises);
		result = prime * result + Objects.hash(nPaises);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bando other = (Bando) obj;
		
		if (this.nPaises!= other.nPaises) {
			return false;
		}
		
		for (int i = 0; i<this.nPaises; i++) {
			if (!other.contienePais(this.tablaPaises[i])) {
				return false;
			}
		}
		return true;
		
	}

}
