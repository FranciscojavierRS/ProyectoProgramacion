package Examen_Articulos_Objetos;


public class Cliente
{
	private String dni;
	private String nombre;
	
	public Cliente(String dni, String nombre)
	{
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	public String getDni()
	{
		return dni;
	}
	public void setDni(String dni)
	{
		this.dni = dni;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String toString()
	{
		String res="";
		res+="Cliente\n";
		res+="DNI....:"+this.dni+"\n";
		res+="Nombre.:"+this.nombre;	
		return res;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Cliente other = (Cliente) obj;
		if (dni == null)
		{
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	
	

}
