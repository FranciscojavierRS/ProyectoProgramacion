package Examen_CampusUniversitario_Colecciones;

public class Matricula {
    private Estudiante estudiante;
    private Asignatura asignatura;
    private double nota;
    private String convocatoria;

    public Matricula(Estudiante estudiante, Asignatura asignatura, double nota, String convocatoria) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.nota = nota;
        this.convocatoria = convocatoria;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public double getNota() {
        return nota;
    }

    public String getConvocatoria() {
        return convocatoria;
    }

    public boolean estaAprobada() {
        return nota >= 5.0;
    }

    @Override
    public String toString() {
        return estudiante.getNombre() + " - " + asignatura.getNombre() + 
               ": " + nota + " (" + convocatoria + ")";
    }
}
