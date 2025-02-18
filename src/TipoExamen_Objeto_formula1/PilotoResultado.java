package TipoExamen_Objeto_formula1;

public class PilotoResultado {
	private Piloto piloto;
	private Resultado resultado;

	public PilotoResultado(Piloto piloto, Resultado resultado) {
		super();
		this.piloto = piloto;
		this.resultado = resultado;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "[" + piloto + ": " + resultado + "]";
	}

}
