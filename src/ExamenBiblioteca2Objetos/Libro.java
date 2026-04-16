package ExamenBiblioteca2Objetos;

public class Libro extends MaterialBibliografico {
	private int numeroPaginas;

	public Libro(String titulo, String autor, int anoPublicacion, int numeroPaginas) {
		super(titulo, autor, anoPublicacion);
		this.numeroPaginas = numeroPaginas;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}


	public String toString() {
		return super.toString() + "\nN�mero de p�ginas: " + this.numeroPaginas;
	}



}
