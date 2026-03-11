package Examen_CampusUniversitario_Colecciones;

public class Profesor implements Comparable<Profesor> {
    private String codigo;
    private String nombre;
    private String departamento;

    public Profesor(String codigo, String nombre, String departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public int compareTo(Profesor o) {
        return this.codigo.compareTo(o.codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profesor)) return false;
        
        Profesor p = (Profesor) o;
        return codigo.equals(p.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return nombre + " [" + codigo + "] - " + departamento;
    }
}
