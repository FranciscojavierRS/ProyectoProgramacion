package Tarea1_POO_Clases.ferroviaria;

import java.util.Arrays;

public class Tren extends Maquinaria {
private Locomotora locomotora;
private Vagon[] vagones=new Vagon[MAXVAGONES];
private Maquinista maquinista;
private static final int MAXVAGONES = 5;
private int numVagones = 0;

public Tren(Locomotora locomotora, Maquinista maquinista) {
	super();
	this.locomotora = locomotora;
	this.maquinista = maquinista;
}
public Locomotora getLocomotora() {
	return locomotora;
}
public void setLocomotora(Locomotora locomotora) {
	this.locomotora = locomotora;
}
public Vagon[] getVagones() {
	return vagones;
}

public void addVagon(Vagon vagon) {
	if(numVagones == MAXVAGONES) {
		System.out.println("Numero maximo de vagones alcanzado");
	}else {
		vagones[numVagones] = vagon;
		numVagones++;
	}
}

public Maquinista getMaquinista() {
	return maquinista;
}
public void setMaquinista(Maquinista maquinista) {
	this.maquinista = maquinista;
}
@Override
public String toString() {
	return "Tren [locomotora=" + locomotora + ", vagones=" + Arrays.toString(vagones) + ", maquinista=" + maquinista
			+ "]";
}
}
