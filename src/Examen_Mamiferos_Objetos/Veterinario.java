package Examen_Mamiferos_Objetos;

public class Veterinario extends SerVivo
{
	public Veterinario(String nombre)
	{
		super(nombre);
	}

	public String toString()
	{
		return "Veterinario: "+this.nombre;
	}


}
