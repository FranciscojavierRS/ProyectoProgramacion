package Examen_Articulos_Objetos;


public class Articulo
{
	private int codigo;
	private String descripcion;
	private float precioUnitario;
	
	public Articulo(int codigo, String descripcion, float precioUnitario)
	{
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public float getPrecioUnitario()
	{
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario)
	{
		this.precioUnitario = precioUnitario;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Articulo codigo=" + codigo + "\n";
	}

	
	
}
