package Examen_CampusUniversitario_Colecciones;

public class Asignatura implements Comparable<Asignatura> {
    private String codigo;
    private String nombre;
    private int creditos;
    private String facultad;

    public Asignatura(String codigo, String nombre, int creditos, String facultad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.facultad = facultad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getFacultad() {
        return facultad;
    }

    @Override
    public int compareTo(Asignatura o) {
        return this.codigo.compareTo(o.codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asignatura)) return false;
        
        Asignatura a = (Asignatura) o;
        return codigo.equals(a.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ") - " + creditos + " créditos";
    }
}
