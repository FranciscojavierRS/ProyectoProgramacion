package Examen_TorneoVideojuegos_Colecciones_Chatgpt;

public class Equipo implements Comparable<Equipo> {

    private String nombre;
    private String pais;

    public Equipo(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Equipo o) {
        return nombre.compareTo(o.nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;

        Equipo e = (Equipo) o;

        return nombre.equals(e.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        return nombre + " (" + pais + ")";
    }
}