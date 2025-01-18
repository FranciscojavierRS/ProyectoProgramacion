package Tarea1_POO_Clases;

public class SintonizadorDigital {
private float frecuencia;

private static final float FRECUENCIAMIN=80;
private static final float FRECUENCIAMAX=108;
public void display() {
	System.out.println("la frencuencia que se esta emitiendo ahora mismo es "+frecuencia);
}
public void up(){
	if (this.frecuencia==FRECUENCIAMAX) {
		this.frecuencia=FRECUENCIAMIN;
	
	}else {
		this.frecuencia+=0.5;
	}
}

public void down(){
	if (this.frecuencia==FRECUENCIAMIN) {
		this.frecuencia=FRECUENCIAMAX;
	
	}else {
		this.frecuencia-=0.5;
	}
}

public SintonizadorDigital() {
	this.frecuencia=FRECUENCIAMIN;
}

}
