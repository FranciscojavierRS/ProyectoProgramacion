package ObjetosAngel;

public class Escuderia {
    public String nombre;
    public ListaPilotos plantilla;

    public Escuderia(String nombre) {
        this.nombre = nombre;
        this.plantilla = new ListaPilotos();
    }
}
