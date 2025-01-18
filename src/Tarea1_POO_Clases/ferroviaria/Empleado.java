package Tarea1_POO_Clases.ferroviaria;

public class Empleado {
private String nombreCompleto;

public Empleado(String nombreCompleto) {
	this.nombreCompleto = nombreCompleto;
}

public String getNombreCompleto() {
	return nombreCompleto;
}

public void setNombreCompleto(String nombreCompleto) {
	this.nombreCompleto = nombreCompleto;
}

@Override
public String toString() {
	return "Empleado [nombreCompleto=" + nombreCompleto + "]";
}

}
