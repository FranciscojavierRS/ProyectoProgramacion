package Examen_Biblioteca_Objetos;

public class Periodico extends MaterialBibliografico {
    private String fechaPublicacion;
    
    public Periodico(String titulo, String autor, int anoPublicacion, String fechaPublicacion) {
        super(titulo, autor, anoPublicacion);
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public String toString() {
        return super.toString()+"\nFecha de publicaci�n: " + this.fechaPublicacion;
    }
}

