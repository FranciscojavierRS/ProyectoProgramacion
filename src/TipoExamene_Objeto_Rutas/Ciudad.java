package TipoExamene_Objeto_Rutas;

public class Ciudad {
	private String nombre;
	private int numHabitantes;
	
	public Ciudad(String nombre, int numHabitantes) {
		super();
		this.nombre = nombre;
		this.numHabitantes = numHabitantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumHabitantes() {
		return numHabitantes;
	}

	public void setNumHabitantes(int numHabitantes) {
		this.numHabitantes = numHabitantes;
	}

	@Override
	public String toString() {
		return " "+nombre + "(" + numHabitantes + ") ";
	}
	
	
	
}