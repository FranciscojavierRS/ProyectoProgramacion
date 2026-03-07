package Examen_EmpresaComercial_Colecciones;

import java.util.Objects;

public class Comercial implements Comparable<Comercial> {
	private String nombre;
	private float ventas;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, ventas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Comercial))
			return false;
		Comercial other = (Comercial) obj;
		return Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(ventas) == Float.floatToIntBits(other.ventas);
	}

	public float getVentas() {
		return ventas;
	}

	public void setVentas(float ventas) {
		this.ventas = ventas;
	}

	public Comercial(String nombre, float ventas) {
		super();
		this.nombre = nombre;
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int compareTo(Comercial o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.nombre);
	}
}
