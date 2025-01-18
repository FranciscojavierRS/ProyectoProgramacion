package Tarea1_POO_Clases;

public class Texto {
	
	private String cadena;
	private int tamañoMaximo;
	
	public Texto(String cadena, int tamañoMaximo) {
		this.cadena=cadena;
		this.tamañoMaximo=tamañoMaximo;
	}
	
	public void añadirCaracterPrincipio (char caracter) {
		if (this.cadena.length()<this.tamañoMaximo) {
			this.cadena=caracter+this.cadena;
		}
	}
	
	public void añadirCaracterFinal (char caracter) {
		if (this.cadena.length()<this.tamañoMaximo) {
			this.cadena=this.cadena+caracter;
		}
	}
	
	public void añadirCadenaPrincipio (String cadena) {
		if (this.cadena.length()+cadena.length()<this.tamañoMaximo) {
			this.cadena=cadena+this.cadena;
		}
	}
	public void añadirCadenaFinal (String cadena) {
		if (this.cadena.length()+cadena.length()<this.tamañoMaximo) {
			this.cadena=this.cadena+cadena;
		}
	}
	
	public int contarVocales() {
		int vocales= 0;
		for (int i=0;i<cadena.length();i++ ) {
			switch(cadena.charAt(i)) {
			case 'a':
			case 'A':
				vocales++;
				break;
			case 'e':
			case 'E':
				vocales++;
				break;
			case 'i':
			case 'I':
				vocales++;
				break;
			case 'o':
			case 'O':
				vocales++;
				break;
			case 'u':
			case 'U':
				vocales++;
				break;
				default:
			}
		}
		return vocales;
	}
}
