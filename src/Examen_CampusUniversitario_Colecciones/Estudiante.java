package Examen_CampusUniversitario_Colecciones;

public class Estudiante implements Comparable<Estudiante> {
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;

    public Estudiante(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Estudiante o) {
        return this.dni.compareTo(o.dni);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        
        Estudiante e = (Estudiante) o;
        return dni.equals(e.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (" + dni + ")";
    }
}
