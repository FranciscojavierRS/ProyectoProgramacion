package Examen_CampusUniversitario_Colecciones;

public class Aula implements Comparable<Aula> {
    private String codigo;
    private int capacidad;
    private String edificio;
    private boolean tieneProyector;

    public Aula(String codigo, int capacidad, String edificio, boolean tieneProyector) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.edificio = edificio;
        this.tieneProyector = tieneProyector;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getEdificio() {
        return edificio;
    }

    public boolean tieneProyector() {
        return tieneProyector;
    }

    @Override
    public int compareTo(Aula o) {
        return this.codigo.compareTo(o.codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aula)) return false;
        
        Aula a = (Aula) o;
        return codigo.equals(a.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return codigo + " (" + edificio + ") - Capacidad: " + capacidad + 
               (tieneProyector ? " con proyector" : " sin proyector");
    }
}
