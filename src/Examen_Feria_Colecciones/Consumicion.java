package Examen_Feria_Colecciones;

public class Consumicion
{
	private Articulo Articulo;
	private int cantidad;

	public Consumicion(Articulo Articulo, int cantidad)
	{
		this.Articulo = Articulo;
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return Articulo;
	}

	public void setArticulo(Articulo Articulo) {
		this.Articulo = Articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "    " + Articulo + "\t" + cantidad ;
	}




}
