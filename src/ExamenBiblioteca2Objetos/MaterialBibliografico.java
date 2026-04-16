package ExamenBiblioteca2Objetos;

import java.util.Objects;

public abstract class MaterialBibliografico implements Prestable, Comparable<MaterialBibliografico>{
    protected String titulo;
    protected String autor;
    protected int anoPublicacion;
    protected boolean prestado;
    
    @Override
	public int hashCode() {
		return Objects.hash(anoPublicacion, autor, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MaterialBibliografico))
			return false;
		MaterialBibliografico other = (MaterialBibliografico) obj;
		return anoPublicacion == other.anoPublicacion && Objects.equals(autor, other.autor)
				&& Objects.equals(titulo, other.titulo);
	}

	public MaterialBibliografico(String titulo, String autor, int anoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.prestado = false;
    }
    
    public MaterialBibliografico(String titulo, int anoPublicacion) {
        this.titulo = titulo;
        this.autor = "-";
        this.anoPublicacion = anoPublicacion;
        this.prestado = false;
	}

	public boolean prestar() {
		boolean puedePrestarse=!estaPrestado();
        if (puedePrestarse) {
            this.prestado = true;
        }
        return puedePrestarse;
    }
    
    public boolean devolver() {
    	boolean puedeDevolverse=estaPrestado();
    
        if (puedeDevolverse) {
            this.prestado = false;
        } 
        return puedeDevolverse;
    }
    
    public boolean estaPrestado() {
        return this.prestado;
    }
    
    public String toString() {
       return ("\n\n* T�tulo: " + this.titulo+"\n"
       		+ "Autor: " + this.autor+"\n"
       		+ "A�o de publicaci�n: " + this.anoPublicacion
       		+" \nprestado: "+prestado
       		);
    }
    @Override
	public int compareTo(MaterialBibliografico o) {
		
		int variable = this.anoPublicacion - o.anoPublicacion;
		
		if (variable == 0) {
			
			variable = this.titulo.compareTo(o.titulo);
			
		}
		
		return variable;
	}
}
